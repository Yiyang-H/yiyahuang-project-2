import bagel.*;
import bagel.util.Point;

public class MitosisPool extends Actor {
    private final Image pool = new Image("res/images/pool.png");

    public MitosisPool(Point position) {
        super(position);
    }

    @Override
    public void draw(){
        Point p = getPosition();
        pool.drawFromTopLeft(p.x,p.y);
    }
}
