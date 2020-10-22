import bagel.util.Point;

import java.util.ArrayList;

public class GoldenTree extends StockActor {
    public static final String TYPE = "GoldenTree";
    public static final ArrayList<GoldenTree> LIST = new ArrayList<>();

    public GoldenTree(Point position) {
        super(position, "res/images/gold-tree.png",Integer.MAX_VALUE);
        LIST.add(this);
    }
    
}
