import bagel.util.Point;
import java.util.ArrayList;

/**
 * The Pool element in the game.
 */
public class Pool extends Actor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "Pool";
    /**
     * This list stores all Pool elements in the game.
     */
    public static final ArrayList<Pool> LIST = new ArrayList<>();

    /**
     * The constructor of the Pool class.
     * @param position The position of the Pool.
     */
    public Pool(Point position) {
        super(position,"res/images/pool.png");
        LIST.add(this);
    }
}
