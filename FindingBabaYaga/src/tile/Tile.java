package tile;

import java.awt.*;

public abstract class Tile
{
    public static final int TILE_SIZE = 100;

    protected int row;
    protected int col;
    protected Color color;
    protected Color outlineColor;

    public Tile(int row, int col, Color color, Color outlineColor)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public Color getColor()
    {
        return color;
    }

    public void moveTile(int newRow, int newCol)
    {
        this.row = newRow;
        this.col = newCol;
    }

    public abstract void renderTile(Graphics g);

    public abstract boolean isMoveValid(int moveRow, int moveCol);
}