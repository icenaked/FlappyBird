package ui;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Land {
    int x,y;
    BufferedImage img;
    public  Land(){
        try {
            img= ImageIO.read(this.getClass().getResource("../image/land.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        x=0;
         y=525;
    }

public  void landMove(){
        if(x<=-100){
           x=0;
        }
       x-=1;
}


}
