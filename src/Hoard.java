import bagel.*;
import bagel.util.Point;

public class Hoard extends Actor {
    private final Image hoard = new Image("res/images/hoard.png");

    public Hoard(Point position) {
        super(position);
    }

    @Override
    public void draw(){
        Point p = getPosition();
        hoard.drawFromTopLeft(p.x,p.y);
    }
}
