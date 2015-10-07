/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badapple;
import javax.imageio.*; // for ImageIO
import java.io.*; // for File
import java.awt.image.*; // for BufferedImage
import javax.swing.*; // for JFrame
import java.awt.event.*; //for ActionListener
import java.awt.*; // for FileDialog
/**
 *
 * @author Takenaka
 */
public class BadApple extends Canvas{

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws InterruptedException {
    // TODO code application logic here
    //for(int i=1;i<1368;i++) {   
    Frame frame = new Frame("AWTDemo");
    frame.addWindowListener(new AdapterDemo());
    //frame.setSize(1500,1000);
    frame.setSize(900,800);
    
    BadApple canvas = new BadApple();
    frame.add(canvas, BorderLayout.CENTER);
    
    frame.setVisible(true);
    
}

public void paint(Graphics g) { 
        
        int i = 360;
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
            char [] b = new char[height];
            int anum;
            
            
            for (int y = 0; y < height; y+=10) {
                int nownum = 0;
                for (int x = 0; x < width; x+=8) {
                    if(pixel[y][x]<-10){
                      //System.out.print(" @");
                        a[nownum]='=';
                        nownum+=1;
                    }
                    else{
                      //System.out.print("  ");
                        a[nownum]='#';
                        nownum+=1;
                    }
                }
                g.drawChars(a, 0, width, 20, 20+y);
                //break;
                //System.out.println(" ");
             }
            




//System.out.println(pixel);
            /*if(i!=1)
              System.out.println(" ");
            for (int y = 0; y < height; y+=10) {
                for (int x = 0; x < width; x+=8) {
                    if(pixel[y][x]<-10)
                      System.out.print(" @");
                    else
                      System.out.print("  ");
                }
                System.out.println(" ");
             }*/
            
            //Thread.currentThread().sleep(5);//毫秒
        } catch (IOException e) {
            e.printStackTrace();
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