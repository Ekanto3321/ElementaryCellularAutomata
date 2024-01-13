import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private int w=610,h=1000;
    double frameRate = 5.0;
    double timePerFrame = 1000000000.0/frameRate;
    double lastFrame = 0;

    public static int[] cells = new int[61];
    public static ArrayList<int[]> a = new ArrayList<int[]>();

    public void updateCells(){
        int cell, left, right;

        for (int i = 0; i < 61; i++) {
            if(i==0){
                cell = cells[i];
                left = cells[60];
                right = cells[i+1];
            }
            else if(i==60){
                cell = cells[i];
                left = cells[i-1];
                right = cells[0];
            }
            else{
                cell = cells[i];
                left = cells[i-1];
                right = cells[i+1];
            }

                 if(left==0&&cell==0&&right==0)cells[i]=1;
            else if(left==0&&cell==0&&right==1)cells[i]=0;
            else if(left==0&&cell==1&&right==0)cells[i]=0;
            else if(left==0&&cell==1&&right==1)cells[i]=1;
            else if(left==1&&cell==0&&right==0)cells[i]=0;
            else if(left==1&&cell==0&&right==1)cells[i]=0;
            else if(left==1&&cell==1&&right==0)cells[i]=1;
            else if(left==1&&cell==1&&right==1)cells[i]=0;
        }
        a.add(cells);
    }
    public Main(){

    for (int i = 0; i < 60; i++){
        cells[i]=0;
        if(i==31)cells[i]=1;
    }
    DrawingPane p = new DrawingPane(h,w);
    setSize(w,h);
    setTitle("Test");
    setDefaultCloseOperation(3);
//    setResizable(false);
    setVisible(true);
    setLocationRelativeTo(null);
    setBackground(Color.black);
    add(p);

    }


    private void loop() {
        int frame = 0;
        while(true){
            if(System.nanoTime() - lastFrame >= timePerFrame){
                lastFrame=System.nanoTime();
                repaint();
                updateCells();
//                if(frame==5){
//                    for (int j = 0; j < 5; j++) {
//                        for (int i = 0; i < 61; i++) {
//                            System.out.print(a.get(j)[i]+ " ");
//                        }
//                        System.out.println();
//                    }
//                }
//
//                frame++;
            }
        }
    }

    public static void main(String[] args) {
        new Main().loop();
    }

}