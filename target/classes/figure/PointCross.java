package figure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class PointCross extends points {

    private Rectangle2D r;
    private double x, y, w, h;
    private Point2D p1, p2, p3, p4;
    private ArrayList<Point2D> point = new ArrayList<>();
    private int ss = 20;  // Размер крестика
    
    public PointCross(Rectangle2D r) {
        this.r = r;
        this.x = r.getCenterX();
        this.y = r.getCenterY();
        this.w = r.getWidth();
        this.h = r.getHeight();
        
        // Определяем 4 точки вокруг прямоугольника
        this.p1 = new Point2D.Double(x - w / 2, y);
        this.p2 = new Point2D.Double(x, y - h / 2);
        this.p3 = new Point2D.Double(x + w / 2, y);
        this.p4 = new Point2D.Double(x, y + h / 2);
        
        // Добавляем точки в список
        this.point.add(p1);
        this.point.add(p2);
        this.point.add(p3);
        this.point.add(p4);
    }
    
    Font font = new Font("Arial", Font.BOLD, 24);

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.RED);  // Устанавливаем цвет крестиков
        g2.setStroke(new BasicStroke(3));  // Толщина линии крестиков

        // Рисуем крестик (две пересекающиеся линии) в каждой точке
        for (Point2D b : point) {
            double x = b.getX();
            double y = b.getY();
            double halfSize = ss / 2.0;

            // Рисуем линии, формирующие крестик
            g2.drawLine((int) (x - halfSize), (int) (y - halfSize), (int) (x + halfSize), (int) (y + halfSize));
            g2.drawLine((int) (x - halfSize), (int) (y + halfSize), (int) (x + halfSize), (int) (y - halfSize));
        }
    }
}