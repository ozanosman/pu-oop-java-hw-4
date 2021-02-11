package game;

import tile.*;

import java.awt.*;

/**
 * Клас методи за изпълнението на логиката в приложението.
 *
 * @author Озан Осман
 */
public class GameBoard
{
    public final int TILE_SIDE_COUNT = 8;

    public Tile[][] tileCollection = new Tile[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

    public Tile selectedTile;

    private int START_TILE = 1;
    private int IMPASSABLE_TILE = 5;
    private int GPS_TILE = 8;
    private int UNEXPLORED_TILE = 50;

    public boolean isDead = false;

    /**
     * Метод задаващ координати за визуализиране на елемента "Tile", от който започва движението.
     */
    public void startTileCoordinates()
    {
        do
        {
            int row = getStartTileCoordinates();
            int col = getStartTileCoordinates();

            if (this.hasBoardTile(row, col))
            {
                continue;
            }

            this.tileCollection[row][col] = new Tile(row, col, new Color(255, 242, 204), new Color(218, 189, 100), null);

            START_TILE--;
        }
        while(START_TILE != 0);
    }

    /**
     * Метод задаващ координати за визуализиране на елементи "Tile", от които е непроходимо.
     */
    public void impassableTileCoordinates()
    {
        do
        {
            int row = getTileCoordinates();
            int col = getTileCoordinates();

            if (this.hasBoardTile(row, col))
            {
                continue;
            }

            this.tileCollection[row][col] = new Tile(row, col, new Color(0, 80, 239), new Color(5, 36, 194), null);

            IMPASSABLE_TILE--;
        }
        while(IMPASSABLE_TILE != 0);
    }

    /**
     * Метод задаващ координати за визуализиране на елементи "Tile", в които се намира баба Яга.
     */
    public void gPSTileCoordinates()
    {
        do
        {
            int row = getTileCoordinates();
            int col = getTileCoordinates();

            if (this.hasBoardTile(row, col))
            {
                continue;
            }

            this.tileCollection[row][col] = new Tile(row, col, new Color(213, 232, 212), new Color(166, 200, 150), null);

            GPS_TILE--;
        }
        while(GPS_TILE != 0);
    }

    /**
     * Метод задаващ координати за визуализиране на елементи "Tile", които са неизследвани.
     */
    public void unexploredTileCoordinates()
    {
        do
        {
            int row = getTileCoordinates();
            int col = getTileCoordinates();

            if (this.hasBoardTile(row, col))
            {
                continue;
            }

            this.tileCollection[row][col] = new Tile(row, col, new Color(248, 206, 204), new Color(192, 99, 95), null);

            UNEXPLORED_TILE--;
        }
        while(UNEXPLORED_TILE != 0);
    }

    /**
     * Метод съдържащ инстанция на клас за визуализиране на елементи "Tile".
     *
     * @param g     обект на супер класа за всички графични контексти
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    public void renderTile(Graphics g, int row, int col)
    {
        if (this.hasBoardTile(row, col))
        {
            Tile tile = this.getBoardTile(row, col);
            tile.renderTile(g);
        }
    }

    /**
     * Метод, който контролира елемента "Tile", започващ движението върху игралната дъска.
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param tile     инстанция на клас
     */
    public void moveStartTile(int row, int col, Tile tile)
    {
        int initialRow = tile.getRow();
        int initialCol = tile.getCol();

        tile.moveTile(row, col);

        decideStartTileFate(row, col, tile);

        this.tileCollection[initialRow][initialCol] = null;

        this.selectedTile = null;
    }

    /**
     * Метод, който връща елемент от обекта за елементи "Tile".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    public Tile getBoardTile(int row, int col)
    {
        return this.tileCollection[row][col];
    }

    /**
     * Метод, който проверява и връща елемент от обекта за елементи "Tile", ако те съществуват.
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    public boolean hasBoardTile(int row, int col)
    {
        return this.getBoardTile(row, col) != null;
    }

    /**
     * Метод, който връща координати на игралната дъска в единични числа.
     *
     * @param coordinates   координати
     */
    public int getBoardCoordinates(int coordinates)
    {
        return coordinates / Tile.TILE_SIZE;
    }

    /**
     * Метод, който проверява и връща елемент от обекта за елементи "Tile", ако то е от определения цвят.
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    public boolean isImpassable(int row,int col)
    {
        Tile tile = getBoardTile(row,col);

        if (this.hasBoardTile(row, col))
        {
            return tile.getColor().equals(new Color(0, 80, 239));
        }
        return false;
    }

    /**
     * Метод, който проверява и връща елемент от обекта за елементи "Tile", ако то е от определения цвят и ако баба Яга е открита.
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    public boolean isBabaYagaFound(int row,int col)
    {
        int babaYagaHouse = 1;

        Tile tile = getBoardTile(row,col);

        if (this.hasBoardTile(row, col))
        {
            return tile.getColor().equals(new Color(213, 232, 212)) && babaYagaHouse == getBabaYagaCoordinates();
        }
        return false;
    }

    /**
     * Метод, който решава съдбата на елемента "Tile", започващ движението.
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param tile     инстанция на клас
     */
    private void decideStartTileFate(int row, int col, Tile tile)
    {
        int chance = (int) (Math.random() * 101);

        if (chance <= 80)
        {
            if (this.tileCollection[row][col].getColor().equals(new Color(213, 232, 212)))
            {
                this.tileCollection[tile.getRow()][tile.getCol()] = new Tile(row, col, new Color(255, 242, 204), new Color(218, 189, 100), "͡❛_>͡❛");
            }
            else
            {
                this.tileCollection[tile.getRow()][tile.getCol()] = new Tile(row, col, new Color(255, 242, 204), new Color(218, 189, 100), "͡❛‿>͡❛");
            }
        }
        else
        {
            if (this.tileCollection[row][col].getColor().equals(new Color(248, 206, 204)))
            {
                this.tileCollection[tile.getRow()][tile.getCol()] = new Tile(tile.getRow(), tile.getCol(), new Color(0, 80, 239), new Color(5, 36, 194), "͡*_>͡*");
                isDead = true;
            }
            else
            {
                this.tileCollection[tile.getRow()][tile.getCol()] = new Tile(row, col, new Color(255, 242, 204), new Color(218, 189, 100), "͡❛_>͡❛");
            }
        }
    }

    /**
     * Метод, който избира и връща координати на баба Яга.
     */
    private int getBabaYagaCoordinates()
    {
        return Math.random() > 0.13 ? 0: 1;
    }

    /**
     * Метод, който избира и връща координати на елемента "Tile", започващ движението.
     */
    private int getStartTileCoordinates()
    {
        return Math.random() > 0.5 ? 0: 7;
    }

    /**
     * Метод, който избира и връща координати на останалите елементи "Tile".
     */
    private int getTileCoordinates()
    {
        return (int) (Math.random() * 8);
    }
}