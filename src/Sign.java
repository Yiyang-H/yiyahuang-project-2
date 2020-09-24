import bagel.*;
import bagel.util.Point;

public class Sign extends Actor {
    private final Image sign = new Image("res/images/sign.png");

    public Sign(Point position) {
        super(position);
    }

    @Override
    public void draw(){
        Point p = getPosition();
        sign.drawFromTopLeft(p.x,p.y);
    }
}
