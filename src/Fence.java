import bagel.*;
import bagel.util.Point;

public class Fence extends Actor {
    private final Image fence = new Image("res/images/fence.png");

    public Fence(Point position) {
        super(position);
    }

    @Override
    public void draw() {
        Point p = getPosition();
        fence.drawFromTopLeft(p.x,p.y);
    }
}
