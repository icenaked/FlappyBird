package ui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Bird {
    BufferedImage img;
    int x,y,w,h;
    List<BufferedImage> list=new ArrayList<BufferedImage>();
    double v0;
    double time;
    double s;
    double g;//gravity

    public Bird(){
        img=App.getImage("../image/bird0_0.png");
        x=150;
        y=200;
        w=img.getWidth();
        h=img.getHeight();
        for(int i=0;i<3;i++){
            list.add(App.getImage("../image/bird0_"+i+".png"));
        }
        v0=10;
        time=0.4;
        s=0;
        g=3;
    }
    int index=0;
    int p=0;        //fly slower......
    public void fly(){
        p++;
        if(p%5==0){
            img=list.get(index);
            index++;
        }

        if(index>2){
            index=0;
        }
    }
    public void fall(){
         s=v0*time;
         y=y-(int)s;
         double v2=v0-g*time;
         v0=v2;
    }
    public void rise(){
        v0=10;
    }
    public boolean hit(){
        if(y<=0||y>=600-75-h){
            return true;
        }
        return false;
    }
    public boolean hit(Pipe pipe){
        if(x>=pipe.x-w+10&&x<=pipe.x+pipe.w+15  ){
            if((pipe.y+pipe.h-10)<=y&&y<=(pipe.y+pipe.h+100-h-10)){
                return false;
            }
            return true;
        }
        return false;
    }
    public boolean getScore(Pipe pipe){
        if(x>=pipe.x+pipe.w&&x<=pipe.x+pipe.w+0.5){
            return true;
        }
        return false;
    }
}

