import bagel.util.Point;
import bagel.util.Vector2;
import java.util.ArrayList;

/**
 * The Sign element in the game.
 */
public class Sign extends DirectionActor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "Sign";
    /**
     * This list stores all gatherer elements in the game.
     */
    public static final ArrayList<Sign> LIST = new ArrayList<>();
    /**
     * A constant string indicating up direction.
     */
    public static final String UP = "Up";
    /**
     * A constant string indication right direction.
     */
    public static final String RIGHT = "Right";
    /**
     * A constant string indication down direction.
     */
    public static final String DOWN = "Down";
    /**
     * A constant string indication left direction.
     */
    public static final String LEFT = "Left";

    /**
     * The constructor of the Sign class.
     * @param position The position of the Sign.
     * @param type The direction type of the Sign.
     */
    public Sign(Point position,String type) {
        super(position,mapImageFile(type),mapVector(type));
        LIST.add(this);
    }

    // Returns the correct image based on the direction
    private static String mapImageFile(String type) {
        switch(type) {
            case UP:
                return "res/images/up.png";
            case RIGHT:
                return "res/images/right.png";
            case DOWN:
                return "res/images/down.png";
            case LEFT:
                return "res/images/left.png";
            default:
                // This should not happen!!!
                return "";
        }
    }

    private static Vector2 mapVector(String type) {
        switch(type) {
            case UP:
                return Vector2.up;
            case RIGHT:
                return Vector2.right;
            case DOWN:
                return Vector2.down;
            default:
                return Vector2.left;
        }
    }

}
