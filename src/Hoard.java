import bagel.util.Point;
import java.util.ArrayList;

/**
 * The Hoard element in the game.
 */
public class Hoard extends StockActor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "Hoard";
    /**
     * This list stores all Hoard elements in the game.
     */
    public static final ArrayList<Hoard> LIST = new ArrayList<>();

    /**
     * The constructor of the Hoard class.
     * @param position The position of the Hoard.
     */
    public Hoard(Point position) {
        super(position, "res/images/hoard.png",0);
        LIST.add(this);
    }
}
