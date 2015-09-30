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
public class BadApple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          int Height,Width;
            try {
            BufferedImage image = ImageIO.read(new File("D://test2.jpg"));
            final int width = image.getWidth();
            final int height = image.getHeight();
            final int[][] pixel = new int[height][width];
 
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    pixel[y][x] = image.getRGB(x, y);
                 }
            }
            //System.out.println(pixel);
            for (int y = 0; y < height; y+=50) {
                for (int x = 0; x < width; x+=50) {
                    if(pixel[y][x]<-10)
                      System.out.print("  ");
                    else
                      System.out.print(" @");
                 }
                
                System.out.println(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    
}
}