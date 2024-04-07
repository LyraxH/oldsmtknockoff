
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Window extends JFrame
{
    JPanel gameWindow = new JPanel(); // where the characters are displayed
    JPanel enemyWindow = new JPanel(); // where enemy health is displayed
    JPanel allyWindow = new JPanel(); // where ally health is displayed
    JPanel moveWindow = new JPanel(); // where actions can be taken
    JPanel chatWindow = new JPanel(); // where text of the actions taken is displayed
    
    public Window(){
        this.add(gameWindow, BorderLayout.CENTER);
        this.add(enemyWindow, BorderLayout.LINE_START);
        this.add(allyWindow, BorderLayout.LINE_END);
        this.add(chatWindow, BorderLayout.PAGE_START);
        this.add(moveWindow, BorderLayout.PAGE_END);
        
        
        gameWindow.setBackground(Color.blue);
        allyWindow.setBackground(Color.green);
        allyWindow.setPreferredSize(new Dimension(200, 0));
        enemyWindow.setBackground(Color.red);
        enemyWindow.setPreferredSize(new Dimension(200, 0));
        chatWindow.setBackground(Color.gray);
        chatWindow.setPreferredSize(new Dimension(0, 100));
        moveWindow.setBackground(Color.pink);
        moveWindow.setPreferredSize(new Dimension(0, 400));
        
        initialize();
    }
    
    void initialize(){
        this.getContentPane().setPreferredSize(new Dimension (1280, 720));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.toFront();
        
        
        gameWindow.setVisible(true);
        this.pack();
        this.setVisible(true);
    }
}