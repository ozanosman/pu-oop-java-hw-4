package renderer;

import game.GameBoard;

import javax.swing.*;
import java.awt.*;

public class SwingRenderer extends JFrame
{
    GameBoard gameBoard;

    public SwingRenderer(GameBoard gameBoard)
    {
        this.gameBoard = gameBoard;

        this.setTitle("Finding Baba Yaga");
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        gameBoard.randomGreenTileGenerator();
        gameBoard.randomBlueTileGenerator();
    }

    @Override
    public void paint(Graphics g)
    {
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                this.gameBoard.renderRedTile(g, row, col);
                this.gameBoard.renderGreenTile(g);
                this.gameBoard.renderBlueTile(g);
                this.gameBoard.renderStartTile(g, row, col);
            }
        }
    }
}