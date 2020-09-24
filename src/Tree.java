import bagel.*;
import bagel.Image;
import bagel.util.Point;


public class Tree extends Actor {
    private final Image tree = new Image("res/images/tree.png");

    public Tree(Point position) {
        super(position);
    }

    @Override
    public void draw(){
        Point p = getPosition();
        tree.drawFromTopLeft(p.x,p.y);
    }
}
