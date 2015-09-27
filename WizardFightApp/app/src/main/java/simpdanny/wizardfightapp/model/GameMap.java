package simpdanny.wizardfightapp.model;

import android.graphics.Canvas;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by alon21034 on 2015/9/21.
 */
public class GameMap {

    ArrayList<Fighter> enemyList;
    public GameMap() {
        enemyList = new ArrayList<Fighter>();


        Fighter f = new Fighter(10, 10);
        enemyList.add(f);
    }

    public void update(long dt) {
        for (Fighter f : enemyList) {
            f.update(dt);
        }
    }

    public void update(JSONArray arr) {
        
    }

    public void draw(Canvas canvas) {
        for (Fighter f : enemyList) {
            f.draw(canvas);
        }
    }
}
