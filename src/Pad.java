import bagel.util.Point;

import java.util.ArrayList;

public class Pad extends Actor {
    public static final String TYPE = "Pad";
    public static final ArrayList<Pad> LIST = new ArrayList<>();
    public Pad(Point position) {
        super(position, "res/images/pad.png");
        LIST.add(this);
    }
}
