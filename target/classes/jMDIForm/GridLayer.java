package jMDIForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

class GridLayer extends JComponent {
    private static final int CELL_SIZE = 20; // Размер ячейки сетки

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        Dimension size = getSize();
        g.setColor(Color.LIGHT_GRAY);

        // Отрисовываем вертикальные линии сетки
        for (int x = 0; x < size.width; x += CELL_SIZE) {
            g.drawLine(x, 0, x, size.height);
        }

        // Отрисовываем горизонтальные линии сетки
        for (int y = 0; y < size.height; y += CELL_SIZE) {
            g.drawLine(0, y, size.width, y);
        }
    }
}
