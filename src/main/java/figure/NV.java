package figure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class NV extends figures{
//    int s, x, y;
    public static Color BackgroundColor = Color.WHITE;
    public static Color TextColor = Color.BLACK;    
    public NV(int x, int y, int s) {
        this.x=x + s/4;
        this.y=y + s/4;
        this.s=s;
        this.nameF = "NV" + this.id;
    }
    Font font = new Font("Arial", Font.BOLD, 24);
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        shape = new RoundRectangle2D.Double(x-s/2, y-s/4, s, s/2, 30, 500);
        Font font = new Font("Arial", Font.BOLD, (int)(24*s/100));//Иванов А.А. перемещен в конструктор для обновления при перерисовке        
        g2.setFont(font);
        g2.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        g2.setColor(BackgroundColor);
        g2.fill(shape);
        g2.setColor(TextColor);
        g2.setStroke(new BasicStroke(2));
        g2.draw(shape);
        g2.drawString("NV", x-15*s/100, y+9*s/100);//Иванов А.А. надпись центруется с учетом масштаба
    } 
}
