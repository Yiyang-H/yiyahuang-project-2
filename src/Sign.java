import bagel.util.Point;
import bagel.util.Vector2;

import java.util.ArrayList;

public class Sign extends DirectionActor {
    public static final String TYPE = "Sign";
    public static final ArrayList<Sign> LIST = new ArrayList<>();
    public static final String UP = "Up";
    public static final String RIGHT = "Right";
    public static final String DOWN = "Down";
    public static final String LEFT = "Left";

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
