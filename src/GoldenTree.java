import bagel.util.Point;

import java.util.ArrayList;

/**
 * The GoldenTree element in the game.
 */
public class GoldenTree extends StockActor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "GoldenTree";
    /**
     * This list stores all GoldenTree elements in the game.
     */
    public static final ArrayList<GoldenTree> LIST = new ArrayList<>();

    /**
     * The constructor of the GoldenTree class.
     * @param position The position of the GoldenTree.
     */
    public GoldenTree(Point position) {
        super(position, "res/images/gold-tree.png",Integer.MAX_VALUE);
        LIST.add(this);
    }
    
}
