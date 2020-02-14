package ui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class App {
    public static BufferedImage getImage(String path){
        BufferedImage img=null;
        try {
            img=ImageIO.read(App.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
