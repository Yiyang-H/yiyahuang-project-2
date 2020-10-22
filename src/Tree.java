import bagel.util.Point;

import java.util.ArrayList;

public class Tree extends StockActor {
    public static final String TYPE = "Tree";
    public static final ArrayList<Tree> LIST = new ArrayList<>();
    private static final int FRUITS_TREE = 3;

    public Tree(Point position) {
        super(position,"res/images/tree.png",FRUITS_TREE);
        LIST.add(this);
    }
}
