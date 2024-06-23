package point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import java.awt.geom.Point2D;
import javax.swing.JComponent;

public class Arrow extends JComponent{
    public double x1, x2, y1, y2;
    public Arrow(Point2D c1, Point2D c2) {
        this.x1 = c1.getX();
        this.y1 = c1.getY();
        this.x2 = c2.getX();
        this.y2 = c2.getY();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        drawArrow(g, x1, y1, x2, y2);
    }
    
    private void drawArrow(Graphics g, double x1, double y1, double x2, double y2) {
        Graphics2D g2d = (Graphics2D) g.create();
        double dx = x2 - x1;
        double dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx * dx + dy * dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.rotate(angle);
        g2d.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g2d.drawLine(0, 0, len, 0);
        g2d.fillPolygon(new int[] {len, len - 10, len - 10, len},
                        new int[] {0, -5, 5, 0}, 4);
    }
}
