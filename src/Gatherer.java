import bagel.*;
import java.util.Random;

public class Gatherer extends Actor {
    // Instance variable for Gatherer
    private int direction;
    private final Image gatherer = new Image("res/images/gatherer.png");

    private static final Random RAND = new Random();
    private static final int DIRECTION_UPDATE = 5;
    private static final int UP_DIRECTION = 0;
    private static final int RIGHT_DIRECTION = 1;
    private static final int DOWN_DIRECTION = 2;
    private static final int LEFT_DIRECTION = 3;
    private static final int NUM_OF_DIRECTIONS = 4;

    public Gatherer(int x,int y){
        super(x,y);
        direction = RAND.nextInt(NUM_OF_DIRECTIONS);
    }

    @Override
    public void update(int tickNumber) {
        // Update the direction
        if(tickNumber%DIRECTION_UPDATE == 0) {
            direction = RAND.nextInt(NUM_OF_DIRECTIONS);
        }
        // Update the position based direction
        switch(direction) {
            case UP_DIRECTION:
                // Up direction
                this.changeY(-1 * TILE_SIZE);
                break;
            case RIGHT_DIRECTION:
                // Right direction
                this.changeX(TILE_SIZE);
                break;
            case DOWN_DIRECTION:
                // Down direction
                this.changeY(TILE_SIZE);
                break;
            case LEFT_DIRECTION:
                // Left Direction
                this.changeX(-1 * TILE_SIZE);
                break;
            default:
                break;
        }

    }
    @Override
    public void draw(){
        gatherer.drawFromTopLeft(getX(),getY());
    }
}
