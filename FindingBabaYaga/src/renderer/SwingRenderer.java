package renderer;

import game.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SwingRenderer extends JFrame implements MouseListener
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

        this.gameBoard.StartTileCoordinates();
        this.gameBoard.ImpassableTileCoordinates();
        this.gameBoard.GPSTileCoordinates();
        this.gameBoard.UnexploredTileCoordinates();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void paint(Graphics g)
    {
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                this.gameBoard.renderTile(g, row, col);
            }
        }
    }
}