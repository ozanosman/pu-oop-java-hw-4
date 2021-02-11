package renderer;

import game.GameBoard;
import tile.Tile;
import ui.Modal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Клас наследяващ JFrame и прилагащ MouseListener, съдържащ конструктор и методи за визуализиране на приложението.
 *
 * @author Озан Осман
 */
public class SwingRenderer extends JFrame implements MouseListener
{
    GameBoard gameBoard;

    /**
     * Конструктор съдържащ характеристиките за създаване на прозореца, в която се визуализира игралната дъска и неговите елементи.
     *
     * @param gameBoard
     */
    public SwingRenderer(GameBoard gameBoard)
    {
        this.gameBoard = gameBoard;

        this.setTitle("Finding Baba Yaga");
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);

        this.gameBoard.startTileCoordinates();
        this.gameBoard.impassableTileCoordinates();
        this.gameBoard.gPSTileCoordinates();
        this.gameBoard.unexploredTileCoordinates();
    }

    /**
     * Метод, който контролира елемента "Tile", започващ движението с мишка и проверява дали е мъртъв.
     *
     * @param e     обект на супер класа за всички графични контексти
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int row = this.gameBoard.getBoardCoordinates(e.getY());
        int col = this.gameBoard.getBoardCoordinates(e.getX());

        if (this.gameBoard.isDead)
        {
            Modal.renderEndGame(this,"Загуба!","Вие сте вече част от игралната дъска!");
        }

        if (this.gameBoard.selectedTile != null)
        {
            Tile tile = this.gameBoard.selectedTile;

            if (tile.isMoveValid(row, col))
            {
                if (this.gameBoard.isImpassable(row, col))
                {
                    Modal.renderMessage(this,"Внимание!","Неможете да влезете тук!");
                }
                else if (this.gameBoard.isBabaYagaFound(row, col))
                {
                    Modal.renderEndGame(this,"Победа!","Вие намерихте къщата на баба Яга!");
                }
                else
                {
                    this.gameBoard.moveStartTile(row, col, tile);

                    this.repaint();

                    return;
                }
            }
        }

        if (this.gameBoard.hasBoardTile(row, col))
        {
            this.gameBoard.selectedTile = this.gameBoard.getBoardTile(row, col);
        }
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

    /**
     * Метод съдържащ цикъл за визуализиране на игралната дъска и неговите елементи.
     *
     * @param g     обект на супер класа за всички графични контексти
     */
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