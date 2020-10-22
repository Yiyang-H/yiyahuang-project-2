import bagel.Font;
import bagel.util.Point;

/**
 * This abstract class describes actors which can store fruits, and provide
 * methods to monitor/modify the status of the fruits held.
 */
public abstract class StockActor extends Actor {
    private int fruitNum;
    private Font font = new Font("res/VeraMono.ttf",24);

    /**
     * The constructor of the StockActor class.
     * @param position The position of the actor.
     * @param imageFile The image file of the actor.
     * @param fruitNum The fruit number held at this StockActor.
     */
    public StockActor(Point position, String imageFile, int fruitNum) {
        super(position,imageFile);
        this.fruitNum = fruitNum;
    }

    /**
     * This method tells if there is any fruit left at this StockActor.
     * @return True if any fruit left.
     */
    public boolean anyFruit(){
        if(fruitNum > 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to modify the fruit number according to the input parameter.
     * @param n The number to change the fruit number.
     */
    public void changeFruitNum(int n) {
        fruitNum += n;
    }

    /**
     * This method draws the remaining fruit number for this StockActor if it
     * is not a GoldenTree.
     */
    public void draw(){
        super.draw();
        // Draw the remaining fruit excluding golden tree
        if(!(this instanceof GoldenTree)) {
            Point p = getPosition();
            font.drawString(String.valueOf(fruitNum), p.x, p.y);
        }

    }

    /**
     * Getter for the fruitNum attribute.
     * @return The fruit number.
     */
    public int getFruitNum() {
        return fruitNum;
    }
}
