package jMDIForm;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    private int cellSize;
    private int xOffset = 20; // Смещение по X
    private int yOffset = 20; // Смещение по Y
    private int thickLineSpacing = 5; // Каждая пятая линия будет толстой
    public static Color color = Color.GRAY;

    public GridPanel(int cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g); // Вызов метода paintGrid для отрисовки сетки
    }

    private void paintGrid(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Установка серого цвета для сетки
        g2d.setColor(color);

        // Определяем размеры панели
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Определяем начальные координаты для рисования сетки с учетом смещения
        int startX = xOffset;
        int startY = yOffset;

        // Рисуем буквенные обозначения столбцов
        for (int i = 0; i < panelWidth / cellSize; i++) {
            char columnChar = (char) ('A' + i);  // Начинаем с буквы 'A' и увеличиваем на i
            g2d.drawString(String.valueOf(columnChar), startX + cellSize * i * 5 + cellSize / 2 + 37, startY - 5);
        }

        // Рисуем числовые обозначения строк
        for (int i = 0; i < panelHeight / cellSize; i++) {
            g2d.drawString(String.valueOf(i + 1), startX - 15, startY + cellSize * i * 5 + cellSize / 2 + 45);
        }

        // Отрисовываем вертикальные линии сетки
        for (int x = startX; x <= panelWidth + cellSize; x += cellSize) {
            if ((x - startX) % (cellSize * thickLineSpacing) == 0) {
                g2d.setStroke(new BasicStroke(2)); // Устанавливаем толщину линии 2
            } else {
                g2d.setStroke(new BasicStroke(1)); // Возвращаем стандартную толщину линии
            }
            g2d.drawLine(x, startY, x, panelHeight);
        }

        // Отрисовываем горизонтальные линии сетки
        for (int y = startY; y <= panelHeight + cellSize; y += cellSize) {
            if ((y - startY) % (cellSize * thickLineSpacing) == 0) {
                g2d.setStroke(new BasicStroke(2)); // Устанавливаем толщину линии 2
            } else {
                g2d.setStroke(new BasicStroke(1)); // Возвращаем стандартную толщину линии
            }
            g2d.drawLine(startX, y, panelWidth, y);
        }
    }
}
