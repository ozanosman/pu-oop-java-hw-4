package game;

import tile.*;

import java.awt.*;

public class GameBoard
{
    public final int TILE_SIDE_COUNT = 8;

    public Tile[][] tileCollection = new Tile[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

    public Tile selectedTile;

    private int START_TILE = 1;
    private int IMPASSABLE_TILE = 5;
    private int GPS_TILE = 8;
    private int UNEXPLORED_TILE = 50;

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

            tileCollection[row][col] = new YellowTile(row, col, new Color(255, 242, 204), new Color(218, 189, 100));

            START_TILE--;
        }
        while(START_TILE != 0);
    }

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

            tileCollection[row][col] = new BlueTile(row, col, new Color(0, 80, 239), new Color(5, 36, 194));

            IMPASSABLE_TILE--;
        }
        while(IMPASSABLE_TILE != 0);
    }

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

            tileCollection[row][col] = new GreenTile(row, col, new Color(213, 232, 212), new Color(166, 200, 150));

            GPS_TILE--;
        }
        while(GPS_TILE != 0);
    }

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

            tileCollection[row][col] = new RedTile(row, col, new Color(248, 206, 204), new Color(192, 99, 95));

            UNEXPLORED_TILE--;
        }
        while(UNEXPLORED_TILE != 0);
    }

    public void renderTile(Graphics g, int row, int col)
    {
        if (this.hasBoardTile(row, col))
        {
            Tile tile = this.getBoardTile(row, col);
            tile.renderTile(g);
        }
    }

    public void moveStartTile(int row, int col, Tile tile)
    {
        int initialRow = tile.getRow();
        int initialCol = tile.getCol();

        tile.moveTile(row, col);

        // int number = (int) (Math.random() * 101);

        // if (number <= 80)
        // {
        //     this.tileCollection[tile.getRow()][tile.getCol()] = this.selectedTile;
        //     this.tileCollection[initialRow][initialCol] = null;
        // }
        // else
        // {
        //     Tile impassableTile = new BlueTile(row, col, new Color(0, 80, 239), new Color(5, 36, 194));
        //     this.tileCollection[impassableTile.getRow()][impassableTile.getCol()] = impassableTile;
        // }

        this.tileCollection[tile.getRow()][tile.getCol()] = this.selectedTile;
        this.tileCollection[initialRow][initialCol] = null;

        this.selectedTile = null;
    }

    public Tile getBoardTile(int row, int col)
    {
        return this.tileCollection[row][col];
    }

    public boolean hasBoardTile(int row, int col)
    {
        return this.getBoardTile(row, col) != null;
    }

    public int getBoardCoordinates(int coordinates)
    {
        return coordinates / Tile.TILE_SIZE;
    }

    public boolean isImpassable(int row,int col)
    {
        if (hasBoardTile(row,col))
        {
            Tile tile = getBoardTile(row,col);
            return tile.getColor().equals(new Color(0, 80, 239));
        }
        return false;
    }

    public boolean isBabaYagaFound(int row,int col)
    {
        int babaYagaHouse = 1;

        if (hasBoardTile(row,col))
        {
            Tile tile = getBoardTile(row,col);
            return tile.getColor().equals(new Color(213, 232, 212)) && babaYagaHouse == getBabaYagaCoordinates();
        }
        return false;
    }

    private int getBabaYagaCoordinates()
    {
        return Math.random() > 0.13 ? 0: 1;
    }

    private int getStartTileCoordinates()
    {
        return Math.random() > 0.5 ? 0: 7;
    }

    private int getTileCoordinates()
    {
        return (int) (Math.random() * 8);
    }
}