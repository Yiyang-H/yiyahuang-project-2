import bagel.*;
import bagel.util.Point;
import bagel.util.Vector2;

public class Sign extends DirectionActor {
    public Sign(Point position,Vector2 type) {
        super(position,correctImage(type),type);
    }

    // Returns the correct image based on the direction
    private static Image correctImage(Vector2 type) {
        if(Vector2.up.equals(type)) {
            return new Image("res/images/up.png");
        }else if(Vector2.right.equals(type)) {
            return new Image("res/images/right.png");
        }else if(Vector2.down.equals(type)) {
            return new Image("res/images/down.png");
        }else {
            return new Image("res/images/left.png");
        }
    }

}
