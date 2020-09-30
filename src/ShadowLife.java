import bagel.*;
import bagel.util.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ShadowLife extends AbstractGame {
    private final Image background = new Image("res/images/background.png");
    // Count number of ticks
    private int counter;
    public static final ArrayList<Actor> ACTORS = new ArrayList<>();
    private long referenceTime = System.currentTimeMillis();

    public static final int TILE_SIZE = 64;

    private static int tickRate;
    private static int maxTicks;
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private static final String TREE = "Tree";
    private static final String GOLDEN_TREE = "GoldenTree";
    private static final String STOCKPILE = "Stockpile";
    private static final String HOARD = "Hoard";
    private static final String PAD = "Pad";
    private static final String FENCE = "Fence";
    private static final String SIGN = "Sign";
    private static final String MITOSIS_POOL = "MitosisPool";
    private static final String GATHERER = "Gatherer";
    private static final String THIEF = "Thief";
    private static final int NUM_OF_ARGUMENTS = 3;
    private static String filename;

    boolean paused = false;

    public ShadowLife() {
        super(WIDTH,HEIGHT,"ShadowLife");
    }

    public static void main(String[] args) {

        // Checks if the input arguments are valid
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


        ShadowLife game = new ShadowLife();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Scanner scanner = new Scanner(br);
            int i = 0;
            while(scanner.hasNext()) {
                // Split the csv by ","
                String[] columns = scanner.nextLine().split(",");
                // Check if each column is well-formatted
                // Not handled correctly yet
                if(!isValidColumn(columns)) {
                    System.out.println("error: in file \"" + filename + "\" at line " + (i+1));
                }
                String type = columns[0];
                int x = Integer.parseInt(columns[1]);
                int y = Integer.parseInt(columns[2]);
                Point p = new Point(x,y);
                switch(type) {
                    case TREE:
                        ACTORS.add(new Tree(p));
                        break;
                    case GOLDEN_TREE:
                        ACTORS.add(new GoldenTree(p));
                        break;
                    case STOCKPILE:
                        ACTORS.add(new Stockpile(p));
                        break;
                    case HOARD:
                        ACTORS.add(new Hoard(p));
                        break;
                    case PAD:
                        ACTORS.add(new Pad(p));
                        break;
                    case FENCE:
                        ACTORS.add(new Fence(p));
                        break;
                    case MITOSIS_POOL:
                        ACTORS.add(new MitosisPool(p));
                        break;
                    case GATHERER:
                        ACTORS.add(new Gatherer(p));
                        break;
                    case THIEF:
                        ACTORS.add(new Thief(p));
                        break;
                    default:
                        break;
                }
                if(type.contains(SIGN)) {
                    switch (type.substring(4)){
                        case "Up" :
                            ACTORS.add(new Sign(p, Vector2.up));
                            break;
                        case "Right" :
                            ACTORS.add(new Sign(p, Vector2.right));
                            break;
                        case "Down" :
                            ACTORS.add(new Sign(p, Vector2.down));
                            break;
                        case "Left" :
                            ACTORS.add(new Sign(p, Vector2.left));
                            break;
                        default:
                            break;
                    }
                }
                i++;
            }
        } catch (IOException e) {
            // Should I use IOException here?
            System.out.println("error: file \"<file name>\" not found");
            System.exit(-1);
        }
        game.run();
    }

    @Override
    public void update(Input input) {
        background.drawFromTopLeft(0,0);
        // Press space to pause the simulation
        if(input.wasPressed(Keys.SPACE)) {
            paused = paused ? false : true;
        }

        if(input.isDown(Keys.RIGHT)) {
            tickRate = 250;
        }else {
            tickRate = 500;
        }
        // Check if 1 tick has passed
        if(System.currentTimeMillis()-referenceTime >= tickRate && !paused) {
            referenceTime = System.currentTimeMillis();
            counter++;
            Gatherer.moveAll();
            Thief.moveAll();
        }

        // Draw all actors
        for(Actor a : ACTORS) {
            a.draw();
        }

        if(counter > maxTicks) {
            System.out.println("Timed out");
            System.exit(-1);
        }

        if(input.isDown(Keys.ESCAPE)) {
            Window.close();
        }
    }

    private static boolean isValidColumn(String[] column) {
        if(column.length != 3) {
            return false;
        }
        return true;

    }
}
