package figure;

import static figure.figures.id;
import static figure.figures.nextId;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.util.prefs.Preferences;
import java.util.prefs.BackingStoreException;

public class S1 extends figures {

    String str = "S";
    public static Color BackgroundColor;
    public static Color TextColor;

    //Применение прошлых настроек
    static {
        // Проверяем, существует ли узел
        try {
            if (!prefs.nodeExists("")) {
                // Узел не существует - устанавливаем значения по умолчанию и сохраняем их
                BackgroundColor = Color.WHITE;
                TextColor = Color.BLACK;

                prefs.putInt("S1BackgroundColor", BackgroundColor.getRGB());
                prefs.putInt("S1TextColor", TextColor.getRGB());
            } else {
                // Узел существует - загружаем значения
                BackgroundColor = new Color(prefs.getInt("S1BackgroundColor", Color.WHITE.getRGB()));
                TextColor = new Color(prefs.getInt("S1TextColor", Color.BLACK.getRGB()));
            }
        } catch (BackingStoreException e) {
            e.printStackTrace();
            // В случае ошибки устанавливаем значения по умолчанию
            BackgroundColor = Color.WHITE;
            TextColor = Color.BLACK;
        }
    }

    public S1(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.absoluteX = (int) (x);
        this.absoluteY = (int) (y);
        this.s = s;
//        id = nextId.incrementAndGet();
//        id=idChange(c);
        this.nameF = "S" + this.id;
    }

    //Font font = new Font("Arial", Font.BOLD, 24);
    @Override
    public void paintComponent(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, (int) (24 * s / 100));//Иванов А.А. перемещен в конструктор для обновления при перерисовке
        Graphics2D g2 = (Graphics2D) g;
        // s=(int) (zoom*s);
        // shape = new RoundRectangle2D.Double(x-s/2, y-s/4, s, s/2, 50, 100);
        shape = new Ellipse2D.Double(x, y, s / 2, s / 2);
        //shape = new Ellipse2D.Double(x-s, y-s/2, s/2, s/2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(BackgroundColor);
        g2.fill(shape);
        g2.setColor(TextColor);
        g2.setStroke(new BasicStroke(2));
        g2.draw(shape);
        g2.setFont(font);
        g2.drawString(str, (x) + 17 * s / 100, (y) + 34 * s / 100);// в дальнейшем кнопка //Иванов А.А. надпись центруется с учетом масштаба
        rec = shape.getBounds2D();
    }
}
