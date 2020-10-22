import bagel.Image;
import bagel.util.Point;
import bagel.util.Vector2;

/**
 * Actor is an element in the game, actors in the game must have an position
 * and a image.
 */
public abstract class Actor {
    private Point position;
    private Image image;
    /**
     * This is a constant name given to the arraylist that holds a specific
     * type of actors in their class.
     */
    public static final String LIST_NAME = "LIST";

    /**
     * The constructor of the Actor class
     * @param position This is the position of the actor.
     * @param imageFile This is the location of the image file of the actor.
     */
    public Actor(Point position,String imageFile) {
        this.position = position;
        this.image = new Image(imageFile);
    }

    /**
     * An actor is drawn according to its current position.
     */
    // All actors can draw on window
    public void draw() {
        image.drawFromTopLeft(position.x, position.y);
    }

    /**
     * Getter for the position attribute.
     * @return Returns the position of the actor.
     */
    public Point getPosition(){
        return this.position;
    }

    /**
     * Changes the position attribute of the actor according to the direction
     * given by one tile.
     * @param v This is the direction.
     */
    public void changePosition(Vector2 v) {
        // Move in the direction v one tile
        position = position.asVector().add(v.mul(ShadowLife.TILE_SIZE)).asPoint();
    }

}
