/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badapple;
import javax.imageio.*; 
import java.io.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import java.util.logging.Level;
import java.util.logging.Logger;


public class BadApple extends Canvas{

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws InterruptedException {
    
    // TODO code application logic here
    //for(int i=1;i<4372;i++) {   
    Frame frame = new Frame("AWTDemo");
    frame.addWindowListener(new AdapterDemo());
    //frame.setSize(1500,1000);
    frame.setSize(900,800);
    
    
    BadApple canvas = new BadApple();
    frame.add(canvas, BorderLayout.CENTER);
    
    frame.setVisible(true);
    
}

public void paint(Graphics g) { 
        
    for(int i=0;i<4372;i++) 
    {   
       int Height,Width;
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\Takenaka\\Desktop\\test123\\BadApple ("+i+").jpg"));
            final int width = image.getWidth();
            final int height = image.getHeight();
            final int[][] pixel = new int[height][width];
 
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    pixel[y][x] = image.getRGB(x, y);
                 }
            }  

            char [] a = new char[width];
            char [] b = new char[width];
            
            
            int pictureOK = 0;
            for (int y = 0; y < height; y+=10) {
                int nownum = 0;
                for (int x = 0; x < width; x+=8) {
                    if(pixel[y][x]<-10){
                      //System.out.print(" @");
                        a[nownum]='=';
                        b[nownum]=' ';
                        nownum+=1;
                        pictureOK+=1;
                    }
                    else{
                      //System.out.print("  ");
                        a[nownum]='#';
                        b[nownum]=' ';
                        nownum+=1;
                        pictureOK+=1;
                    }
                }
                
                g.drawChars(a, 0, width, 20, 20+y);
                
                System.out.println(pictureOK);
                //g.fillRect(0, 0, width, height);
               // Thread.currentThread().sleep(2000);
               // if(i%2==0 && pictureOK>=8000)
               //   g.clearRect(0, 0, width, height*2);
                if(i%2==0)
                    g.dispose();
             }
        
        } catch (IOException e) {
            e.printStackTrace();
        //} catch (InterruptedException ex) {
            //Logger.getLogger(BadApple.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.invalidate();
        this.validate();
        this.revalidate();
        //this.revalidate();
        //this.update(g);
    }
    
}

//}
    /*int i = 265;
     int Height,Width;
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\Takenaka\\Desktop\\test123\\BadApple ("+i+").jpg"));
            final int width = image.getWidth();
            final int height = image.getHeight();
            final int[][] pixel = new int[height][width];
 
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    pixel[y][x] = image.getRGB(x, y);
                 }
            }  
            //System.out.println(pixel);
            for (int y = 0; y < height; y+=15) {
                for (int x = 0; x < width; x+=12) {
                    if(pixel[y][x]<-10)
                      System.out.print("  ");
                    else
                      System.out.print(" @");
                }
                System.out.println(" ");
             }
            Thread.currentThread().sleep(25);//毫秒
        } catch (IOException e) {
            e.printStackTrace();
        }*/

}
//}

class AdapterDemo extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

