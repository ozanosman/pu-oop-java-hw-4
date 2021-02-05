package game;

import tile.*;

import java.awt.*;

public class GameBoard
{
    public final int TILE_SIDE_COUNT = 8;

    private Tile[][] tileCollection = new Tile[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

    private int START_TILE = 1;
    private int IMPASSABLE_TILE = 5;
    private int GPS_TILE = 8;
    private int UNEXPLORED_TILE = 50;

    public void StartTileCoordinates()
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

    public void ImpassableTileCoordinates()
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

    public void GPSTileCoordinates()
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

    public void UnexploredTileCoordinates()
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

    private int getStartTileCoordinates()
    {
        return Math.random() > 0.5 ? 0: 7;
    }

    private int getTileCoordinates()
    {
        return (int) (Math.random() * 8);
    }

    private Tile getBoardTile(int row, int col)
    {
        return this.tileCollection[row][col];
    }

    private boolean hasBoardTile(int row, int col)
    {
        return this.getBoardTile(row, col) != null;
    }
}