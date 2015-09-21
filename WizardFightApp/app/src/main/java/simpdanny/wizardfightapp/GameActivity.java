package simpdanny.wizardfightapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import simpdanny.wizardfightapp.simpdanny.wizardfightapp.view.GameView;

/**
 * Created by alon21034 on 2015/9/21.
 */
public class GameActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameView view = new GameView(getApplicationContext());
        setContentView(view);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
