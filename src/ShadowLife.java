import bagel.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ShadowLife extends AbstractGame {
    private final Image background = new Image("res/images/background.png");
    // Count number of ticks
    private int counter;
    private Actor[] actors;
    private long referenceTime = System.currentTimeMillis();

    private static int tickRate;
    private static int maxTicks;
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private static final int TOTAL_ACTOR_NUMBER = 6;
    private static final String TREE = "Tree";
    private static final String GATHERER = "Gatherer";
    private static final int NUM_OF_ARGUMENTS = 3;
    private static String filename;

    public ShadowLife() {
        super(WIDTH,HEIGHT,"ShadowLife");
        actors = new Actor[TOTAL_ACTOR_NUMBER];

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Scanner scanner = new Scanner(br);
            int i = 0;
            while(scanner.hasNext()) {
                // Split the csv by ","
                String[] columns = scanner.nextLine().split(",");
                String type = columns[0];
                int x = Integer.parseInt(columns[1]);
                int y = Integer.parseInt(columns[2]);
                if(type.equals(TREE)) {
                    actors[i++] = new Tree(x,y);
                }else if (type.equals(GATHERER)) {
                    actors[i++] = new Gatherer(x,y);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean validArguments = true;
        if(args.length != NUM_OF_ARGUMENTS) {
            validArguments = false;
        }
        try {
            tickRate = Integer.parseInt(args[0]);
            if (tickRate < 0) {
                validArguments = false;
            }
            maxTicks = Integer.parseInt(args[1]);
            if (maxTicks < 0) {
                validArguments = false;
            }
        }catch(Exception e) {
            validArguments = false;
        }
        if(!validArguments){
            System.out.println("usage: ShadowLife <tick rate> <max ticks> <world file>");
            System.exit(-1);
        }
        filename = args[2];
        new ShadowLife().run();
    }

    @Override
    public void update(Input input) {
        background.drawFromTopLeft(0,0);

        // Check if 1 tick has passed
        if(System.currentTimeMillis()-referenceTime >= tickRate) {
            referenceTime = System.currentTimeMillis();
            // Update the all actors
            for(int i = 0;i < Actor.getActNum();i++) {
                actors[i].update(counter);
            }
            counter++;
        }

        // Draw all actors
        for(int i = 0;i < Actor.getActNum();i++) {
            actors[i].draw();
        }

        if(input.isDown(Keys.ESCAPE)) {
            Window.close();
        }
    }
}
