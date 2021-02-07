package ui;

import javax.swing.*;

public class Modal extends JDialog
{
    public Modal(JFrame parent, String title, String message)
    {
        super(parent, title, true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);

        panel.add(label);
        getContentPane().add(panel);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public Modal(String message, JFrame parent, String title)
    {
        super(parent, title, true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);
        JButton button = new JButton("Нова игра?");

        panel.add(label);
        panel.add(button);
        getContentPane().add(panel);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void renderMessage(JFrame parent, String title, String message)
    {
        new Modal(parent, title, message);
    }

    public static void renderGameOver(JFrame parent, String title, String message)
    {
        new Modal(message, parent, title);
    }
}
