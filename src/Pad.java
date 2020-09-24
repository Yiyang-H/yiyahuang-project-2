import bagel.*;
import bagel.util.Point;

public class Pad extends Actor {
    private final Image pad = new Image("res/images/pad.png");

    public Pad(Point position) {
        super(position);
    }

    @Override
    public void draw(){
        Point p = getPosition();
        pad.drawFromTopLeft(p.x,p.y);
    }
}
