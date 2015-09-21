package simpdanny.wizardfightapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import simpdanny.wizardfightapp.view.GameView;

/**
 * Created by alon21034 on 2015/9/21.
 */
public class GameActivity extends Activity {

    private final int DELAY = 15;

    GameView view;
    Handler handler;
    private long lastUpdateTime;

    final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            view.update(System.currentTimeMillis() - lastUpdateTime);
            view.invalidate();
            handler.postDelayed(this, DELAY);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new GameView(getApplicationContext());
        setContentView(view);

        handler = new Handler();
        lastUpdateTime = System.currentTimeMillis();
        handler.postDelayed(runnable, DELAY);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
