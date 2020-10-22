import bagel.util.Point;
import bagel.util.Vector2;
import java.util.ArrayList;

public abstract class MovableActor extends DirectionActor {
    private boolean active = true;

    public MovableActor(Point position, String imageFile, Vector2 direction) {
        super(position,imageFile,direction);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void move();

    // Check if this movable is on some type of actor
    // Return the instance of that actor if there is any
    public Actor isOn(String className) {
        try {
            ArrayList<? extends Actor> actorList =
                    (ArrayList<? extends Actor>) Class.forName(className).getDeclaredField(LIST_NAME).get(null);
            for(Actor a : actorList) {
                if(a.getPosition().equals(this.getPosition())) {
                    return a;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean allInactive() {
        for(Gatherer g : Gatherer.LIST) {
            if(g.isActive()) {
                return false;
            }
        }
        for(Thief t : Thief.LIST) {
            if(t.isActive()) {
                return false;
            }
        }
        return true;
    }

    public static void moveAll() {
        Gatherer.moveAll();
        Thief.moveAll();
    }
}
