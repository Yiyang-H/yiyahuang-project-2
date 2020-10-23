import bagel.util.Point;
import bagel.util.Vector2;
import java.util.ArrayList;

/**
 * The gatherer element in the game.
 */
public class Gatherer extends MovableActor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "Gatherer";
    private boolean carrying = false;
    /**
     * This list stores all gatherer elements in the game.
     */
    public static final ArrayList<Gatherer> LIST = new ArrayList<>();

    /**
     * The constructor of the Gatherer class.
     * @param position The position of the gatherer.
     */
    public Gatherer(Point position){
        super(position, "res/images/gatherer.png", Vector2.left);
        LIST.add(this);
    }

    /**
     * The move method moves this gatherer according to an algorithm.
     */
    @Override
    public void move() {
        // Move the Gatherer
        if(this.isActive()) {
            this.changePosition(this.getDirection());
        }

        // Declare a temporary actor in case we need to modify
        // the actor when we stand on it
        Actor temp;
        if((this.isOn(Fence.TYPE)) != null) {
            this.setActive(false);
            this.changePosition(this.getDirection().mul(-1));
        }

        if((this.isOn(Pool.TYPE)) != null) {
            Point currentP = this.getPosition();
            Vector2 currentD = this.getDirection();

            Gatherer first = new Gatherer(currentP);
            first.toDirection(currentD);
            first.changeDirection(CLOCKWISE_90);
            first.move();

            this.changeDirection(-1*CLOCKWISE_90);
            this.move();
            this.carrying = false;
        }

        if((temp = this.isOn(Sign.TYPE)) != null) {
            this.toDirection(((Sign) temp).getDirection());
        }

        if((temp = this.isOn(Tree.TYPE)) != null) {
            if(!carrying) {
                if(((Tree) temp).anyFruit()) {
                    ((Tree) temp).changeFruitNum(-1);
                    carrying = true;
                    this.changeDirection(CLOCKWISE_180);
                }
            }
        }

        if((this.isOn(GoldenTree.TYPE)) != null) {
            carrying = true;
            this.changeDirection(CLOCKWISE_180);
        }

        if((temp = this.isOn(Hoard.TYPE)) != null) {
            if(carrying) {
                carrying = false;
                ((StockActor) temp).changeFruitNum(1);
            }
            this.changeDirection(CLOCKWISE_180);
        }

        if((temp = this.isOn(Stockpile.TYPE)) != null) {
            if(carrying) {
                carrying = false;
                ((StockActor) temp).changeFruitNum(1);
            }
            this.changeDirection(CLOCKWISE_180);
        }
    }

    /**
     * The moveAll method moves all Gatherers in the LIST.
     */
    public static void moveAll() {
        // Using this approach will not move the new added Gatherers
        // Can be done with iterator but this works fine as well
        int size = LIST.size();
        for(int i = 0;i<size;i++) {
            LIST.get(i).move();
        }
    }
}
