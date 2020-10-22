import bagel.util.Point;

import java.util.ArrayList;

public class Hoard extends StockActor {
    public static final String TYPE = "Hoard";
    public static final ArrayList<Hoard> LIST = new ArrayList<>();
    public Hoard(Point position) {
        super(position, "res/images/hoard.png",0);
        LIST.add(this);
    }
}
