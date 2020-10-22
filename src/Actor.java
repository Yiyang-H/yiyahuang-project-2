import bagel.Image;
import bagel.util.Point;
import bagel.util.Vector2;

public abstract class Actor {
    private Point position;
    private Image image;
    public static final String LIST_NAME = "LIST";

    public Actor(Point position,String imageFile) {
        this.position = position;
        this.image = new Image(imageFile);
    }

    // All actors can draw on window
    public void draw() {
        image.drawFromTopLeft(position.x, position.y);
    }

    public Point getPosition(){
        return this.position;
    }

    public void changePosition(Vector2 v) {
        // Move in the direction v one tile
        position = position.asVector().add(v.mul(ShadowLife.TILE_SIZE)).asPoint();
    }

}
