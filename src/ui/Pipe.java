package ui;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Pipe {
    BufferedImage img;
    int x,y,w,h,random;

    public Pipe(int i){
        if(i==1){
            img=App.getImage("../image/pipe_down.png");
            x=400;
            y=-50;
            w=img.getWidth();
            h=img.getHeight();
        }
      else if(i==2){
           img=App.getImage("../image/pipe_up.png");
           w=img.getWidth();
           h=img.getHeight();
       }
      else if(i==3){
           img=App.getImage("../image/pipe_down.png");
           x=625;
           y=-50;
           w=img.getWidth();
           h=img.getHeight();
       }
       else if(i==4){
            img=App.getImage("../image/pipe_up.png");
            w=img.getWidth();
            h=img.getHeight();
    }
 }
 public void move(){
        if (x<=-50){
            x=400;
            y=-50;
            Random r=new Random();
            random=r.nextInt(100)-50;
            y+=random;
        }
        x-=1;
    }
}
