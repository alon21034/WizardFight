package simpdanny.wizardfightapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import simpdanny.wizardfightapp.view.GameView;

/**
 * Created by alon21034 on 2015/9/21.
 */
public class GameActivity extends Activity implements View.OnTouchListener {

    private final int DELAY = 200;

    GameView view;
    Handler handler;
    private long lastUpdateTime;

    private Socket socket;

    final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            long dt = System.currentTimeMillis() - lastUpdateTime;
            JSONObject json = new JSONObject();
            try {
                json.put("dt", dt);
            } catch (Exception e) {}
            socket.emit("update", json);

            handler.removeCallbacks(this);
            handler.postDelayed(this, DELAY);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new GameView(getApplicationContext());
        setContentView(view);

        view.setOnTouchListener(this);
        Log.d("!!", "!! game activity start");

        try {
            socket = IO.socket("http://192.168.2.2:5000");
            socket.on("game_data", onReceiveData);
            socket.connect();
            sendMessage();
        } catch (Exception e) {
            Log.d("!!", "!! socket err");
            Log.d("!!", "!! " + e.getMessage());
        }
        sendMessage();

        handler = new Handler();
        lastUpdateTime = System.currentTimeMillis();
        handler.postDelayed(runnable, DELAY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //if (!socket.connected()) socket.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        socket.disconnect();
    }

    private void sendMessage() {
        //if(socket.connected()) {
            JSONObject json = new JSONObject();
            try {
                json.put("aaa", 123);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            socket.emit("start", json);
        //} else {
        //    Log.d("!!", "!! server socket connect err");
        //}
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("!!", "!! " + event.getX() + " " + event.getY());
        return true;
    }

    Emitter.Listener onReceiveData = new Emitter.Listener() {

        @Override
        public void call(Object... args) {
            try {
                JSONObject json = new JSONObject((String) args[0]);
                view.update(json);
            } catch (Exception e) {}
        }
    };
}
