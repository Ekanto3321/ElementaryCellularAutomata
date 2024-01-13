import javax.swing.*;
import java.awt.*;

public class DrawingPane extends JPanel {
    int height;
    int width;
    int fr=0;
    DrawingPane(int height, int width){
        this.height=height;
        this.width=width;
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.white);
        for (int j = 0; j < Main.a.size(); j++) {
            for (int i = 0; i < 61; i++) {
                if(Main.a.get(j)[i]==0)g.fillRect(i*10,j*10,10,10);
            }
        }

        g.setColor(Color.darkGray);
        for (int i = 0; i < 100; i++) {
            g.drawLine(0,i*10,width,i*10);
        }
        for (int i = 0; i < 61; i++) {
            g.drawLine(i*10,0,i*10,height);
        }

        Toolkit.getDefaultToolkit().sync();
    }
}
