import bagel.util.Point;
import bagel.util.Vector2;

/**
 * This abstract class describe actors which comes with a direction.
 */
public abstract class DirectionActor extends Actor{
    private Vector2 direction;

    /**
     * A constant for rotating 90 degrees clockwise.
     */
    public static final int CLOCKWISE_90 = 90;

    /**
     * A constant for rotating 180 degrees clockwise.
     */
    public static final int CLOCKWISE_180 = 180;

    /**
     * The constructor for the class.
     * @param position The position of the actor.
     * @param imageFile The image file of the actor.
     * @param direction The direction of the actor.
     */
    public DirectionActor(Point position, String imageFile, Vector2 direction) {
        super(position,imageFile);
        this.direction = direction;
    }

    /**
     * Change the direction of this actor according to the rotation angle.
     * @param rotationClockwise The angle to rotate in clockwise direction.
     */
    public void changeDirection(int rotationClockwise) {
        boolean clockwise = rotationClockwise > 0;
        while(rotationClockwise != 0) {
            if(Vector2.up.equals(direction)) {
                direction = clockwise ? Vector2.right : Vector2.left;
                rotationClockwise = clockwise ?
                        rotationClockwise - CLOCKWISE_90 : rotationClockwise + CLOCKWISE_90;
            }else if(Vector2.right.equals(direction)) {
                direction = clockwise ? Vector2.down : Vector2.up;
                rotationClockwise = clockwise ?
                        rotationClockwise - CLOCKWISE_90 : rotationClockwise + CLOCKWISE_90;
            }else if(Vector2.down.equals(direction)) {
                direction = clockwise ? Vector2.left : Vector2.right;
                rotationClockwise = clockwise ?
                        rotationClockwise - CLOCKWISE_90 : rotationClockwise + CLOCKWISE_90;
            }else if(Vector2.left.equals(direction)) {
                direction = clockwise ? Vector2.up : Vector2.down;
                rotationClockwise = clockwise ?
                        rotationClockwise - CLOCKWISE_90 : rotationClockwise + CLOCKWISE_90;
            }
        }
    }

    /**
     * Set the direction to a new direction.
     * @param v This is the new direction.
     */
    public void toDirection(Vector2 v) {
        direction = v;
    }

    /**
     * Get the direction of this actor.
     * @return Direction of the actor.
     */
    public Vector2 getDirection(){
        return direction;
    }
}
