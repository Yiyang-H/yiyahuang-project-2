import bagel.*;
import bagel.util.Point;
import bagel.util.Vector2;

public class Thief extends DirectionActor implements Movable {
    private final Image thief = new Image("res/images/thief.png");

    public Thief(Point position) {
        super(position, Vector2.up);
    }

    @Override
    public void move(int tickNum) {
    }

    @Override
    public void draw(){
        Point p = getPosition();
        thief.drawFromTopLeft(p.x,p.y);
    }
}
