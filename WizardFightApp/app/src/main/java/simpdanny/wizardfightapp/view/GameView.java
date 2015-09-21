package simpdanny.wizardfightapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import simpdanny.wizardfightapp.R;
import simpdanny.wizardfightapp.model.GameMap;

/**
 * Created by alon21034 on 2015/9/21.
 */
public class GameView extends View {

    GameMap map;

    public GameView(Context context) {
        super(context);
        init();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        map = new GameMap();
    }

    public void update(long dt) {

        map.update(dt);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        map.draw(canvas);
    }
}
