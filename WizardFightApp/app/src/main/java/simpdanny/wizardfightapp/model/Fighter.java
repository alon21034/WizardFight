package simpdanny.wizardfightapp.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by alon21034 on 2015/9/21.
 */
public class Fighter {

    private int hp;
    private float x;
    private float y;

    public Fighter(float x, float y) {
        this.x = x;
        this.y = y;

        this.hp = 100;
    }

    public void update(long dt) {
        this.x += dt/1000f;
        this.y += dt/1000f;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, 10, new Paint(Color.RED));
    }
}
