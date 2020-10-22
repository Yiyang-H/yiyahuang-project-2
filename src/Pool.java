import bagel.util.Point;

import java.util.ArrayList;

public class Pool extends Actor {
    public static final String TYPE = "Pool";
    public static final ArrayList<Pool> LIST = new ArrayList<>();

    public Pool(Point position) {
        super(position,"res/images/pool.png");
        LIST.add(this);
    }
}
