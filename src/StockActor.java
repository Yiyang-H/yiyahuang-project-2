import bagel.Font;
import bagel.Image;
import bagel.util.Point;

public abstract class StockActor extends Actor {
    private int fruitNum;
    private Font font = new Font("res/VeraMono.ttf",24);

    public StockActor(Point position, Image image, int fruitNum) {
        super(position,image);
        this.fruitNum = fruitNum;
    }

    public boolean anyFruit(){
        if(fruitNum > 0) {
            return true;
        }
        return false;
    }

    public void changeFruitNum(int n) {
        fruitNum += n;
    }

    public void draw(){
        super.draw();
        // Draw the remaining fruit excluding golden tree
        if(!(this instanceof GoldenTree)) {
            Point p = getPosition();
            font.drawString(String.valueOf(fruitNum), p.x, p.y);
        }

    }
}
