import bagel.util.Point;
import java.util.ArrayList;

/**
 * The Tree element in the game.
 */
public class Tree extends StockActor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "Tree";
    /**
     * This list stores all Tree elements in the game.
     */
    public static final ArrayList<Tree> LIST = new ArrayList<>();
    private static final int FRUITS_TREE = 3;

    /**
     * The constructor of the Tree class.
     * @param position The position of the Tree.
     */
    public Tree(Point position) {
        super(position,"res/images/tree.png",FRUITS_TREE);
        LIST.add(this);
    }
}
