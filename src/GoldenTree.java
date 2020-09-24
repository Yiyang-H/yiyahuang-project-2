import bagel.Image;
import bagel.util.Point;

public class GoldenTree extends Actor {
    private final Image goldenTree = new Image("res/images/gold-tree.png");

    public GoldenTree(Point position){
        super(position);
    }

    @Override
    public void draw(){
        Point p = getPosition();
        goldenTree.drawFromTopLeft(p.x,p.y);
    }
}
