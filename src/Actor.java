import bagel.Image;
import bagel.util.Point;
import bagel.util.Vector2;

public abstract class Actor {
    private Point position;
    private Image image;
    public static final int TILE_SIZE = 64;

    public Actor(Point position,Image image) {
        this.position = position;
        this.image = image;
    }

    // All actors can draw on window
    public void draw() {
        image.drawFromTopLeft(position.x, position.y);
    }

    public Point getPosition(){
        return this.position;
    }

    public void changePosition(Vector2 v) {
        position = (v.mul(TILE_SIZE).add(position.asVector())).asPoint();
    }

}
