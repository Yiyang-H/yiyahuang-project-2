import bagel.*;
import bagel.util.Point;
import bagel.util.Vector2;

public class Gatherer extends DirectionActor implements Movable {
    // Instance variable for Gatherer
    private int direction;
    private final Image gatherer = new Image("res/images/gatherer.png");
    private static final int NUM_OF_DIRECTIONS = 4;

    public Gatherer(Point position){
        super(position, Vector2.left);
    }

    @Override
    public void move(int tickNum) {
    }
    @Override
    public void draw(){
        Point p = getPosition();
        gatherer.drawFromTopLeft(p.x,p.y);
    }
}
