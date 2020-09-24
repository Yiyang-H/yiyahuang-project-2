import bagel.util.Point;

public abstract class Actor {
    private Point position;
    private static int actNum;

    public static final int TILE_SIZE = 64;
    
    public Actor(Point position) {
        this.position = position;
        actNum++;
    }

    public void update(int tickNumber) {}

    // All actors can draw on window
    public abstract void draw();

    public Point getPosition(){
        return this.position;
    }

    public static int getActNum() {
        return actNum;
    }
}
