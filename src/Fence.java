import bagel.util.Point;

import java.util.ArrayList;

/**
 * The Fence element in the game.
 */
public class Fence extends Actor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "Fence";
    /**
     * This list stores all Fence elements in the game.
     */
    public static final ArrayList<Fence> LIST = new ArrayList<>();

    /**
     * The constructor of the Fence class.
     * @param position The position of the Fence.
     */
    public Fence(Point position) {
        super(position,"res/images/fence.png");
        LIST.add(this);
    }
}
