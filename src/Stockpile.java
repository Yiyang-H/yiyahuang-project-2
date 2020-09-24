import bagel.*;
import bagel.util.Point;

public class Stockpile extends Actor {
    private final Image cherries = new Image("res/images/cherries.png");

    public Stockpile(Point position) {
        super(position);
    }

    @Override
    public void draw(){
        Point p = getPosition();
        cherries.drawFromTopLeft(p.x,p.y);
    }
}
