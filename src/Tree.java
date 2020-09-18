import bagel.*;

public class Tree extends Actor {
    private final Image tree = new Image("res/images/tree.png");

    public Tree(int x,int y) {
        super(x,y);
    }

    @Override
    public void draw() {
        tree.drawFromTopLeft(getX(),getY());
    }
}
