package tile;

import java.awt.*;

/**
 * Клас съдържащ променливи и метод за елементи "Tile".
 *
 * @author Озан Осман
 */
public class Tile
{
    public static final int TILE_SIZE = 100;

    protected int row;
    protected int col;
    protected Color color;
    protected Color outlineColor;
    protected String symbol;

    /**
     * Конструктор на елемента "Tile".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     * @param symbol    символ на елемента
     */
    public Tile(int row, int col, Color color, Color outlineColor, String symbol)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.outlineColor = outlineColor;
        this.symbol = symbol;
    }

    /**
     * Метод, който връща ред на елемента.
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Метод, който връща колона на елемента.
     */
    public int getCol()
    {
        return col;
    }

    /**
     * Метод, който връща цвят на елемента.
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Метод, който дава нови координати на елементи.
     *
     * @param newRow    нов ред на елемента
     * @param newCol    нова колона на елемента
     */
    public void moveTile(int newRow, int newCol)
    {
        this.row = newRow;
        this.col = newCol;
    }

    /**
     * Метод съдържащ логика за визуализиране на елементи "Tile".
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    public void renderTile(Graphics g)
    {
        int tileX = this.col * TILE_SIZE;
        int tileY = this.row * TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);

        g.setColor(this.outlineColor);
        g.drawRect(tileX, tileY, TILE_SIZE, TILE_SIZE);

        if (this.symbol != null)
        {
            g.setColor(Color.RED);
            g.setFont(Font.decode("Courier, Font.BOLD, 25"));
            g.drawString(this.symbol, tileX + 30, tileY + 55);
        }
    }

    /**
     * Метод, който проверява и връща дали елемента може да се движи.
     *
     * @param moveRow   ред на елемента, който може да се движи
     * @param moveCol   колона на елемента, който може да се движи
     */
    public boolean isMoveValid(int moveRow, int moveCol)
    {
        if (this.getColor().equals(new Color(255, 242, 204)))
        {
            int rowCoefficient = Math.abs(moveRow - this.row);
            int colCoefficient = Math.abs(moveCol - this.col);

            return rowCoefficient == 0 && colCoefficient == 1 || rowCoefficient == 1 && colCoefficient == 0;
        }
        return false;
    }
}