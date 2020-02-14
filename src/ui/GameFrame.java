package ui;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class GameFrame extends JFrame {
    public GameFrame(){
        setTitle("Flappy Bird");//title
        BufferedImage logo= null;
            logo = App.getImage("../image/logo.png");

        setIconImage(logo);
        setSize(400,600);//size
        setLocationRelativeTo(null);// put the window in the centre
        setResizable(false);// not allowed to change the size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//CLOSE the process when you close the window
    }

    public static void main(String[] args){
        GameFrame frame=new GameFrame();
        GamePanel panel=new GamePanel();
        frame.add(panel);//put panel and frame together!!!
        frame.setVisible(true);
        panel.start();
    }
}
