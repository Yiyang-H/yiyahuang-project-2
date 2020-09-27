import bagel.*;
import bagel.util.Point;
import bagel.util.Vector2;

import java.util.ArrayList;

public class Thief extends DirectionActor {
    private static final ArrayList<Thief> THIEVES = new ArrayList<>();

    public Thief(Point position) {
        super(position, new Image("res/images/thief.png"), Vector2.up);
        THIEVES.add(this);
    }

    public void move(int tickNum) {
    }
}
