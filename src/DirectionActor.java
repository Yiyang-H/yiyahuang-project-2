import bagel.Image;
import bagel.util.Point;
import bagel.util.Vector2;

public abstract class DirectionActor extends Actor{
    private Vector2 direction;

    public DirectionActor(Point position, Image image, Vector2 direction) {
        super(position,image);
        this.direction = direction;
    }

    public void changeDirection(int rotationClockwise) {
        boolean clockwise = rotationClockwise > 0;
        while(rotationClockwise != 0) {
            if(Vector2.up.equals(direction)) {
                direction = clockwise ? Vector2.right : Vector2.left;
                rotationClockwise = clockwise ?
                        rotationClockwise - 90 : rotationClockwise + 90;
            }else if(Vector2.right.equals(direction)) {
                direction = clockwise ? Vector2.down : Vector2.up;
                rotationClockwise = clockwise ?
                        rotationClockwise - 90 : rotationClockwise + 90;
            }else if(Vector2.down.equals(direction)) {
                direction = clockwise ? Vector2.left : Vector2.right;
                rotationClockwise = clockwise ?
                        rotationClockwise - 90 : rotationClockwise + 90;
            }else if(Vector2.left.equals(direction)) {
                direction = clockwise ? Vector2.up : Vector2.down;
                rotationClockwise = clockwise ?
                        rotationClockwise - 90 : rotationClockwise + 90;
            }
        }
    }

    public Vector2 getDirection(){
        return direction;
    }
}
