import bagel.util.Point;
import java.util.ArrayList;

/**
 * The Pad element in the game.
 */
public class Pad extends Actor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "Pad";
    /**
     * This list stores all Pad elements in the game.
     */
    public static final ArrayList<Pad> LIST = new ArrayList<>();

    /**
     * The constructor of the Pad class.
     * @param position The position of the Pad.
     */
    public Pad(Point position) {
        super(position, "res/images/pad.png");
        LIST.add(this);
    }
}
