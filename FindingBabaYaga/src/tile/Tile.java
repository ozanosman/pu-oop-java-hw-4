package tile;

import java.awt.*;

public abstract class Tile
{
    public final int TILE_SIZE = 100;

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

    public abstract void renderTile(Graphics g);
}