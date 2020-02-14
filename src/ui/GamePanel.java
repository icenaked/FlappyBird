package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    BufferedImage bg;
    Land land=new Land();
    Pipe pipe1=new Pipe(1);
    Pipe pipe2=new Pipe(2);
    Pipe pipe3=new Pipe(3);
    Pipe pipe4=new Pipe(4);
    Bird bird=new Bird();
    Boolean start=false;
    Boolean gameover=false;
    BufferedImage title=App.getImage("../image/title.png");
    BufferedImage ready=App.getImage("../image/text_ready.png");
    BufferedImage tutorial=App.getImage("../image/tutorial.png");
    BufferedImage over=App.getImage("../image//text_game_over.png");
    int score=0;

    public GamePanel() {
        setBackground(Color.yellow);
            bg = App.getImage("../image/bg.jpg");
        MouseAdapter adapter=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(start==true&&gameover==false){
                    bird.rise();
                }
                if(start==false&&gameover==true){
                    gameover=false;
                    bird=new Bird();
                    pipe1=new Pipe(1);
                    pipe2=new Pipe(2);
                    pipe3=new Pipe(3);
                    pipe4=new Pipe(4);
                    score=0;
                }
             if(start==false&&gameover==false) {
                 start=true;
                   start();
                }
            }
        };
        addMouseListener (adapter);
        addMouseMotionListener(adapter);

    }

    public void start(){
        new Thread(){
            public void run(){
                while(true){
                    if(start==true&&gameover==false){
                        land.landMove();
                        pipe1.move();
                        pipe2.move();
                        pipe3.move();
                        pipe4.move();

                        bird.fly();
                        bird.fall();
                        boolean bool1=bird.hit();
                        boolean bool2=bird.hit(pipe1);
                        boolean bool3=bird.hit(pipe3);
                        boolean bool4=bird.getScore(pipe1);
                        boolean bool5=bird.getScore(pipe3);
                        if(bool1==true||bool2==true||bool3==true){
                            gameover=true;
                            start=false;
                        }
                        if(bool4==true||bool5==true){
                            score++;
                        }
                        try {
                            Thread.sleep(30);
                            repaint();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }.start();


    }

public void paint(Graphics g){

       g.drawImage(bg,0,0,800,600,null);

       g.drawImage(pipe1.img,pipe1.x,pipe1.y,pipe1.w,pipe1.h,null);
       g.drawImage(pipe2.img,pipe1.x,pipe1.y+400,pipe2.w,pipe2.h,null);
       g.drawImage(pipe3.img,pipe3.x,pipe3.y,pipe3.w,pipe3.h,null);
       g.drawImage(pipe4.img,pipe3.x,pipe3.y+400,pipe4.w,pipe4.h,null);
    g.setColor(Color.red);
    g.setFont(new Font("楷体", Font.BOLD, 25));
    g.drawString("score: "+score, 10, 30);
       g.drawImage(land.img,land.x,land.y,500,75,null);

       g.drawImage(bird.img,bird.x,bird.y,null);
       if(start==false&&gameover==false){
           g.drawImage(title,200,20,null);
           g.drawImage(ready,100,100,null);
           g.drawImage(tutorial,130,300,null);
       }
       if(gameover==true){
           g.drawImage(over,100,185,null);
           g.setColor(Color.red);
           g.setFont(new Font("楷体", Font.BOLD, 25));
           g.drawString("tap anywhere to", 50, 350);
           g.drawString("restart this bird's life", 50, 400);
       }
  }
}
