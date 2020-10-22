import bagel.util.Point;

import java.util.ArrayList;

public class Fence extends Actor {
    public static final String TYPE = "Fence";
    public static final ArrayList<Fence> LIST = new ArrayList<>();

    public Fence(Point position) {
        super(position,"res/images/fence.png");
        LIST.add(this);
    }
}
