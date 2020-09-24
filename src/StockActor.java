import bagel.util.Point;

public abstract class StockActor extends Actor {
    private int fruitNum;
    public StockActor(Point position,int fruitNum) {
        super(position);
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

    }
}
