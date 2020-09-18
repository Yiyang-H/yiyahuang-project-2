public abstract class Actor {
    private int x;
    private int y;
    private static int actNum;

    public static final int TILE_SIZE = 64;
    
    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
        actNum++;
    }

    public void update(int tickNumber) {}

    // All actors can draw on window
    public abstract void draw();

    public int getX() {
        return x;
    }

    public void changeX(int change) {
        this.x += change;
    }

    public int getY() {
        return y;
    }

    public void changeY(int change) {
        this.y += change;
    }

    public static int getActNum() {
        return actNum;
    }
}
