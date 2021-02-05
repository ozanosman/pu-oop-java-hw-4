package game;

import tile.*;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard
{
    private int green1row;
    private int green1col;

    private int green2row;
    private int green2col;

    private int green3row;
    private int green3col;

    private int green4row;
    private int green4col;

    private int green5row;
    private int green5col;

    private int green6row;
    private int green6col;

    private int green7row;
    private int green7col;

    private int green8row;
    private int green8col;

    private int blue1row;
    private int blue1col;

    private int blue2row;
    private int blue2col;

    private int blue3row;
    private int blue3col;

    private int blue4row;
    private int blue4col;

    private int blue5row;
    private int blue5col;

    public void renderRedTile(Graphics g, int row, int col)
    {
        RedTile red = new RedTile(row, col, Color.RED, Color.BLACK);
        red.renderTile(g);
    }

    public void renderGreenTile(Graphics g)
    {
        GreenTile green1 = new GreenTile(green1row, green1col, Color.GREEN, Color.BLACK);
        green1.renderTile(g);

        GreenTile green2 = new GreenTile(green2row, green2col, Color.GREEN, Color.BLACK);
        green2.renderTile(g);

        GreenTile green3 = new GreenTile(green3row, green3col, Color.GREEN, Color.BLACK);
        green3.renderTile(g);

        GreenTile green4 = new GreenTile(green4row, green4col, Color.GREEN, Color.BLACK);
        green4.renderTile(g);

        GreenTile green5 = new GreenTile(green5row, green5col, Color.GREEN, Color.BLACK);
        green5.renderTile(g);

        GreenTile green6 = new GreenTile(green6row, green6col, Color.GREEN, Color.BLACK);
        green6.renderTile(g);

        GreenTile green7 = new GreenTile(green7row, green7col, Color.GREEN, Color.BLACK);
        green7.renderTile(g);

        GreenTile green8 = new GreenTile(green8row, green8col, Color.GREEN, Color.BLACK);
        green8.renderTile(g);
    }

    public void randomGreenTileGenerator()
    {
        do
        {
            green1row = ThreadLocalRandom.current().nextInt(0,8);
            green1col = ThreadLocalRandom.current().nextInt(0,8);

            green2row = ThreadLocalRandom.current().nextInt(0,8);
            green2col = ThreadLocalRandom.current().nextInt(0,8);

            green3row = ThreadLocalRandom.current().nextInt(0,8);
            green3col = ThreadLocalRandom.current().nextInt(0,8);

            green4row = ThreadLocalRandom.current().nextInt(0,8);
            green4col = ThreadLocalRandom.current().nextInt(0,8);

            green5row = ThreadLocalRandom.current().nextInt(0,8);
            green5col = ThreadLocalRandom.current().nextInt(0,8);

            green6row = ThreadLocalRandom.current().nextInt(0,8);
            green6col = ThreadLocalRandom.current().nextInt(0,8);

            green7row = ThreadLocalRandom.current().nextInt(0,8);
            green7col = ThreadLocalRandom.current().nextInt(0,8);

            green8row = ThreadLocalRandom.current().nextInt(0,8);
            green8col = ThreadLocalRandom.current().nextInt(0,8);
        }
        while (green1row == green1col || green2row == green2col || green3row == green3col || green4row == green4col || green5row == green5col || green6row == green6col || green7row == green7col || green8row == green8col);
    }

    public void renderBlueTile(Graphics g)
    {
        BlueTile blue1 = new BlueTile(blue1row, blue1col, Color.BLUE, Color.BLACK);
        blue1.renderTile(g);

        BlueTile blue2 = new BlueTile(blue2row, blue2col, Color.BLUE, Color.BLACK);
        blue2.renderTile(g);

        BlueTile blue3 = new BlueTile(blue3row, blue3col, Color.BLUE, Color.BLACK);
        blue3.renderTile(g);

        BlueTile blue4 = new BlueTile(blue4row, blue4col, Color.BLUE, Color.BLACK);
        blue4.renderTile(g);

        BlueTile blue5 = new BlueTile(blue5row, blue5col, Color.BLUE, Color.BLACK);
        blue5.renderTile(g);
    }

    public void randomBlueTileGenerator()
    {
        do
        {
            blue1row = ThreadLocalRandom.current().nextInt(0,8);
            blue1col = ThreadLocalRandom.current().nextInt(0,8);

            blue2row = ThreadLocalRandom.current().nextInt(0,8);
            blue2col = ThreadLocalRandom.current().nextInt(0,8);

            blue3row = ThreadLocalRandom.current().nextInt(0,8);
            blue3col = ThreadLocalRandom.current().nextInt(0,8);

            blue4row = ThreadLocalRandom.current().nextInt(0,8);
            blue4col = ThreadLocalRandom.current().nextInt(0,8);

            blue5row = ThreadLocalRandom.current().nextInt(0,8);
            blue5col = ThreadLocalRandom.current().nextInt(0,8);
        }
        while (blue1row == blue1col || blue2row == blue2col || blue3row == blue3col || blue4row == blue4col || blue5row == blue5col);
    }

    public void renderStartTile(Graphics g, int row, int col)
    {
        Random random = new Random();

        int randomNumber = random.nextInt(4);

        switch (randomNumber)
        {
            case 0: if (row == 0 && col == 0)
                    {
                        YellowTile yellow = new YellowTile(row, col, Color.YELLOW, Color.BLACK);
                        yellow.renderTile(g);
                    }
                    break;

            case 1: if (row == 7 && col == 0)
                    {
                        YellowTile yellow = new YellowTile(row, col, Color.YELLOW, Color.BLACK);
                        yellow.renderTile(g);
                    }
                    break;

            case 2: if (row == 0 && col == 7)
                    {
                        YellowTile yellow = new YellowTile(row, col, Color.YELLOW, Color.BLACK);
                        yellow.renderTile(g);
                    }
                    break;

            case 3: if (row == 7 && col == 7)
                    {
                        YellowTile yellow = new YellowTile(row, col, Color.YELLOW, Color.BLACK);
                        yellow.renderTile(g);
                    }
                    break;

            default: System.err.println("Грешка!");
        }
    }
}