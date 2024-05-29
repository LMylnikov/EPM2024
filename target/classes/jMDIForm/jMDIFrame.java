package jMDIForm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import EPM.mdi;
import figure.*;
import java.awt.Cursor;
import java.awt.Shape;
import java.awt.geom.Point2D;
import static java.lang.Math.abs;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;


public class jMDIFrame extends JInternalFrame {

//    DatabaseHandler dbHandler = new DatabaseHandler();

    public int s;
    public final int k = 100;
    public ArrayList<figures> all = new ArrayList();//массив хранящий фугуры по порядку расположения !
    public int x;//координаты мыши
    public int y;
    Point2D p;// текущая точка
    int id;//index of current object
    int dx = 0;//смещенные координаты курсора относительно фигуры при захвате объекта
    int dy = 0;
    public static int oldX, oldY;//coordinates before moving
    int newX, newY;//новые координаты после преобразований
    static double zoom = 1;// коэффициент масштаба
    Shape ss;
    boolean touch;
    
    boolean change_idx=false; //Индикатор который показывает были или нет изменения в схеме
    boolean draw_idx=true; //Показывает можно рисовать или нет
    
    public String fileName=""; // Имя файла в котором храниться схема
   
    long thisTimeFirstClick;//начальный замер времени
    
    public jMDIFrame(String title, Boolean resizable, Boolean closable, Boolean maximizable, Boolean iconifiable, String file) {
        super(title, resizable, closable, maximizable, iconifiable);
        initComponents();

        // Добавляем GridPanel на jPanel1
        jPanel1.add(new GridPanel(20)); // 20 - это размер ячейки сетки
    }

    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rcMenu = new javax.swing.JPopupMenu();
        jMenuItemDelette = new javax.swing.JMenuItem();
        jMenuItemClear = new javax.swing.JMenuItem();
        canvas1 = new java.awt.Canvas();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        zminus = new javax.swing.JButton();
        jSize = new javax.swing.JTextField();
        zplus = new javax.swing.JButton();

        jMenuItemDelette.setText("Delette");
        rcMenu.add(jMenuItemDelette);

        jMenuItemClear.setText("Clear All");
        jMenuItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        rcMenu.add(jMenuItemClear);

        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane1MouseWheelMoved(evt);
            }
        });
        jScrollPane1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jScrollPane1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                moveobj(evt);
            }
        });
        jPanel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                Resizing(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));
        jScrollPane1.setViewportView(jPanel1);

        zminus.setText("-");
        zminus.setEnabled(true);
        zminus.setPreferredSize(new java.awt.Dimension(27, 23));
        zminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zminusActionPerformed(evt);
            }
        });

        jSize.setEditable(false);
        jSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jSize.setText("1");
        jSize.setToolTipText("");

        zplus.setText("+");
        zplus.setEnabled(true);
        zplus.setPreferredSize(new java.awt.Dimension(27, 23));
        zplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zplusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(zminus, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSize, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zplus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zplus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zminus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSize, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Вставляем элемент S
    private void SActionPerformed(java.awt.event.ActionEvent evt) {                                  
    s = k;
    
    // Получаем размеры панели
    int panelWidth = jPanel1.getWidth();
    int panelHeight = jPanel1.getHeight();

    // Рассчитываем размеры видимой области панели
    int visibleWidth = jScrollPane1.getViewport().getViewRect().width;
    int visibleHeight = jScrollPane1.getViewport().getViewRect().height;

    // Максимальное значение скроллера
    int maxScrollX = jScrollPane1.getHorizontalScrollBar().getMaximum();
    int maxScrollY = jScrollPane1.getVerticalScrollBar().getMaximum();
        
    // Получаем текущее положение скроллеров
    int scrollX = jScrollPane1.getHorizontalScrollBar().getValue();
    int scrollY = jScrollPane1.getVerticalScrollBar().getValue();

    // Рассчитываем координаты центра видимой области панели относительно текущего положения скроллеров
    int centerX = panelWidth / maxScrollX * scrollX + visibleWidth / 2 - s / 4;
    int centerY = panelHeight / maxScrollY * scrollY + visibleHeight / 2 - s / 4;

    // Рассчитываем координаты центра фигуры
    int x = centerX;
    int y = centerY;

    // Создаем экземпляр фигуры и устанавливаем его координаты
    S1 Sn = new S1(x, y, s);
    
    // Добавляем фигуру на панель
    jPanel1.removeAll();
    all.add(0, Sn);
    for (figures c : all) { 
        jPanel1.add(c); 
    }
    jPanel1.add(new GridPanel(20)); // Добавляем сетку перед добавлением фигур
    jPanel1.revalidate();    
    jPanel1.repaint();
    
    // Устанавливаем флаг изменения
    change_idx=true;
    ButtonActivated();
}

    
    //Вставляем элемент V
    private void VActionPerformed(java.awt.event.ActionEvent evt) {                                  
        s = k;
        // Получаем размеры панели
        int panelWidth = jPanel1.getWidth();
        int panelHeight = jPanel1.getHeight();

        // Рассчитываем размеры видимой области панели
        int visibleWidth = jScrollPane1.getViewport().getViewRect().width;
        int visibleHeight = jScrollPane1.getViewport().getViewRect().height;

        // Максимальное значение скроллера
        int maxScrollX = jScrollPane1.getHorizontalScrollBar().getMaximum();
        int maxScrollY = jScrollPane1.getVerticalScrollBar().getMaximum();

        // Получаем текущее положение скроллеров
        int scrollX = jScrollPane1.getHorizontalScrollBar().getValue();
        int scrollY = jScrollPane1.getVerticalScrollBar().getValue();

        // Рассчитываем координаты центра видимой области панели относительно текущего положения скроллеров
        int centerX = panelWidth / maxScrollX * scrollX + visibleWidth / 2 - s / 4;
        int centerY = panelHeight / maxScrollY * scrollY + visibleHeight / 2 - s / 4;

        // Рассчитываем координаты верхнего левого угла фигуры
        int x = centerX;
        int y = centerY;
    
        V Vn = new V(x, y, s);
        Vn.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        Vn.setVisible(true);
        Vn.setOpaque(false); // Сделаем фигуру прозрачной

        jPanel1.removeAll();
        all.add(0, Vn);
        for (figures b : all) { jPanel1.add(b); }
        jPanel1.add(new GridPanel(20)); // Добавляем сетку перед добавлением фигур
        jPanel1.revalidate();    
        jPanel1.repaint();
        
        change_idx=true;
        ButtonActivated();
    }   
    
    //Вставляем элемент R
    private void RActionPerformed(java.awt.event.ActionEvent evt) {                                  
        s = k;
        // Получаем размеры панели
        int panelWidth = jPanel1.getWidth();
        int panelHeight = jPanel1.getHeight();

        // Рассчитываем размеры видимой области панели
        int visibleWidth = jScrollPane1.getViewport().getViewRect().width;
        int visibleHeight = jScrollPane1.getViewport().getViewRect().height;

        // Максимальное значение скроллера
        int maxScrollX = jScrollPane1.getHorizontalScrollBar().getMaximum();
        int maxScrollY = jScrollPane1.getVerticalScrollBar().getMaximum();

        // Получаем текущее положение скроллеров
        int scrollX = jScrollPane1.getHorizontalScrollBar().getValue();
        int scrollY = jScrollPane1.getVerticalScrollBar().getValue();

        // Рассчитываем координаты центра видимой области панели относительно текущего положения скроллеров
        int centerX = panelWidth / maxScrollX * scrollX + visibleWidth / 2 - s / 4;
        int centerY = panelHeight / maxScrollY * scrollY + visibleHeight / 2 - s / 4;

        // Рассчитываем координаты верхнего левого угла фигуры
        int x = centerX;
        int y = centerY;
        
        R Rn = new R(x, y, s);
        Rn.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        Rn.setVisible(true);
        
        jPanel1.removeAll();
        all.add(0, Rn);
        for (figures b : all) { jPanel1.add(b); }
        jPanel1.add(new GridPanel(20)); // Добавляем сетку перед добавлением фигур
        jPanel1.revalidate();         
        jPanel1.repaint();

        change_idx=true;
        ButtonActivated();
    }  
    
    //Вставляем элемент NV
    private void NVActionPerformed(java.awt.event.ActionEvent evt) {                                   
        s = k;
        // Получаем размеры панели
        int panelWidth = jPanel1.getWidth();
        int panelHeight = jPanel1.getHeight();

        // Рассчитываем размеры видимой области панели
        int visibleWidth = jScrollPane1.getViewport().getViewRect().width;
        int visibleHeight = jScrollPane1.getViewport().getViewRect().height;

        // Максимальное значение скроллера
        int maxScrollX = jScrollPane1.getHorizontalScrollBar().getMaximum();
        int maxScrollY = jScrollPane1.getVerticalScrollBar().getMaximum();

        // Получаем текущее положение скроллеров
        int scrollX = jScrollPane1.getHorizontalScrollBar().getValue();
        int scrollY = jScrollPane1.getVerticalScrollBar().getValue();

        // Рассчитываем координаты центра видимой области панели относительно текущего положения скроллеров
        int centerX = panelWidth / maxScrollX * scrollX + visibleWidth / 2 - s / 4;
        int centerY = panelHeight / maxScrollY * scrollY + visibleHeight / 2 - s / 4;

        // Рассчитываем координаты верхнего левого угла фигуры
        int x = centerX;
        int y = centerY;
        
        NV NVn = new NV(x, y, s);
        NVn.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        NVn.setVisible(true);
        
        jPanel1.removeAll();
        all.add(0, NVn);
        for (figures b : all) { jPanel1.add(b); }
        jPanel1.add(new GridPanel(20)); // Добавляем сетку перед добавлением фигур
        jPanel1.revalidate();         
        jPanel1.repaint();

        change_idx=true;
        ButtonActivated();
    }                                  

    //Вставляем элемент условие (IF)
    private void DActionPerformed(java.awt.event.ActionEvent evt) {                                  
        s = k;
        // Получаем размеры панели
        int panelWidth = jPanel1.getWidth();
        int panelHeight = jPanel1.getHeight();

        // Рассчитываем размеры видимой области панели
        int visibleWidth = jScrollPane1.getViewport().getViewRect().width;
        int visibleHeight = jScrollPane1.getViewport().getViewRect().height;

        // Максимальное значение скроллера
        int maxScrollX = jScrollPane1.getHorizontalScrollBar().getMaximum();
        int maxScrollY = jScrollPane1.getVerticalScrollBar().getMaximum();

        // Получаем текущее положение скроллеров
        int scrollX = jScrollPane1.getHorizontalScrollBar().getValue();
        int scrollY = jScrollPane1.getVerticalScrollBar().getValue();

        // Рассчитываем координаты центра видимой области панели относительно текущего положения скроллеров
        int centerX = panelWidth / maxScrollX * scrollX + visibleWidth / 2 - s / 4;
        int centerY = panelHeight / maxScrollY * scrollY + visibleHeight / 2 - s / 4;

        // Рассчитываем координаты верхнего левого угла фигуры
        int x = centerX;
        int y = centerY;
        
        //d dn = new d(x, y, s);
        d dn = new d(x, y, (int)(s*zoom));
        dn.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        dn.setVisible(true);

        jPanel1.removeAll();
        all.add(0, dn);
        for (figures b : all) { jPanel1.add(b); }
        jPanel1.add(new GridPanel(20)); // Добавляем сетку перед добавлением фигур
        jPanel1.revalidate();         
        jPanel1.repaint();

        change_idx=true;
        ButtonActivated();
    }                                 
    
      
    
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        oldX = evt.getX();
        oldY = evt.getY();
        p = evt.getPoint();
        boolean is_dc = false;
        for (figures currentFigure : all) {
            ss = currentFigure.getShape();
            if (ss.contains(p) == true) {   
                //if (figures.doubleCl == true){ //если уже был клик на фигуру
                if (evt.getClickCount() == 2){ //если уже был клик на фигуру
                   long thisTimeSecondClick = System.currentTimeMillis();   //время второго клика               
                   if (abs(thisTimeSecondClick - thisTimeFirstClick) < 400){ //если разница в кликах невелика
                        PropertiesDialog pDialog = new PropertiesDialog(null, true,currentFigure);
                        pDialog.setVisible(true);
                        is_dc = true;
                   }
                   else{ //Иначе ничиго                           
                   }               
                }
                else{ //Есди не было первого клика
                    thisTimeFirstClick = System.currentTimeMillis(); //Берем время первого клика             
                } //Далее код для переноса фигуры, не относ к двойному клику

                all.remove(currentFigure);
                all.add(0, currentFigure);
                
                //установить новые координты для x и y, прибавить к координате значение положения скроллера
                
                
                jPanel1.removeAll();  
                for (JComponent c : all) { jPanel1.add(c); } 
                jPanel1.add(new GridPanel(20)); // Добавляем сетку перед добавлением фигур
          
                // Нажате правой кнопки
                if (evt.isPopupTrigger() ){ 
                    // create a popup menu
                    //JPopupMenu pm = new JPopupMenu("Message");
 
                    // create a label
                    //JLabel l = new JLabel("this is the popup menu");
 
                    // add the label to the popup
                    //pm.add(l);
            
            
                    //JFrame f = new JFrame("Popup");
 
                    // set the size of the frame
                    //f.setSize(400, 400);
 
                    // add the popup to the frame
                    rcMenu.show(this, oldX, oldY);
                    
                }
                jPanel1.revalidate();         
                jPanel1.repaint();
                ButtonActivated();
                break;
            }
        }
        touch = ss.contains(p) == true;
        
    }//GEN-LAST:event_jPanel1MousePressed

    private void Resizing(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_Resizing
        //        p=evt.getPoint();
        //        zoom=evt.getUnitsToScroll();
        //
        //            jPanel1.repaint();
    }//GEN-LAST:event_Resizing

    private void moveobj(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveobj
        figures b = all.get(0);
    ss = b.getShape();
    if (touch == true) {
        
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        dx = -oldX + b.getXX();
        dy = -oldY + b.getYY();
        newX = evt.getX() + dx;
        newY = evt.getY() + dy;

        // Рассчитываем правую и нижнюю границы видимой области панели
        int visibleWidth = jScrollPane1.getViewport().getViewRect().width;
        int visibleHeight = jScrollPane1.getViewport().getViewRect().height;
        int rightBorder = jScrollPane1.getHorizontalScrollBar().getValue() + visibleWidth;
        int bottomBorder = jScrollPane1.getVerticalScrollBar().getValue() + visibleHeight;

        // Рассчитываем текущие размеры панели
        int panelWidth = jPanel1.getWidth();
        int panelHeight = jPanel1.getHeight();

        // Проверяем, выходит ли фигура за границы видимой области
        boolean outOfBoundsX = newX > rightBorder;
        boolean outOfBoundsY = newY > bottomBorder;

        if (outOfBoundsX || outOfBoundsY) {
            // Рассчитываем на сколько фигура выходит за границы
            int distanceX = outOfBoundsX ? Math.max(0, newX - rightBorder) + 100: 0;
            int distanceY = outOfBoundsY ? Math.max(0, newY - bottomBorder) + 100 : 0;

            // Проверяем, выходит ли фигура за границы размера панели           
            boolean outOfPanelBounds = newX > panelWidth || newY > panelHeight;

            if (outOfPanelBounds) {
                // Увеличиваем размеры панели на это расстояние
                jPanel1.setPreferredSize(new Dimension(
                    jPanel1.getPreferredSize().width + distanceX ,
                    jPanel1.getPreferredSize().height + distanceY
                ));

                // Перерисовываем панель
                jPanel1.revalidate();
            }
        }

        // Устанавливаем новые координаты для фигуры
        b.setXX(newX);
        b.setYY(newY);
        change_idx = true; 
        jPanel1.revalidate(); 
        jPanel1.repaint();
        oldX = evt.getX();
        oldY = evt.getY();
        ButtonActivated();
        }
       

    }//GEN-LAST:event_moveobj

  //  private void SaveInDb(ArrayList<figures> all, String saveName) {
  //      //// код для сохранения всех элементов
 //
 //       //с тем же названием нет, пока такой случай не обработан.
 //       System.out.println("start saving");
 //       for (figures f : all) { //Перебираем все фигуры и заносим данные в функцию
 //           Figure_s fig = new Figure_s();
//
  //          String gType = f.getClass().toString();
  //          gType = gType.replace("class figure.", "");
  //          fig.setX_pos(Integer.toString(f.getXX()));
  //          fig.setY_pos(Integer.toString(f.getYY()));
  //          fig.setShape(gType);
  //          fig.setSize(Integer.toString(f.getSises()));
  //          fig.setId(Integer.toString(f.getId()));
//
 //           //System.out.println(f.getClass().toString() + " ;" + f.getSises() + " , " + f.getXX() + " , " + f.getYY() );
 //           //        String gX_pos = Integer.toString(f.getXX());
 //           //        String gY_pos = Integer.toString(f.getYY());
 //           //        String gSize = Integer.toString(f.getSises());
 //           //        String gId = Integer.toString(f.getId());
 //           dbHandler.addFig(saveName, fig/*gX_pos,gY_pos,gType,gSize,gId*/);
 //       }
 //       System.out.println("end saving");
 //   }

//    private ArrayList<figures> LoadFromDb(ArrayList<figures> all, String saveName) {
//        DatabaseHandler dbHandler = new DatabaseHandler();
//        ResultSet resSet = dbHandler.getFigure(saveName);
//        try {
//            while (resSet.next()) { //Пробегаемся по всем найденым фигурам
//                Figure_s fig = new Figure_s();
//                fig.setX_pos(resSet.getNString(3));
//                fig.setY_pos(resSet.getNString(4));
//                fig.setShape(resSet.getNString(5));
//                fig.setSize(resSet.getNString(6));
//                readSaveData rs = new readSaveData();
//                all = rs.getElement(all, fig.getShape(), fig.getX_pos(), fig.getY_pos(), fig.getSize()/*Sshape,Sx,Sy,Ss*/); //Заносим фигуру в список используемых в проекте фигур
//            }
//        } catch (SQLException error) {
//            error.printStackTrace();
//        }
//        return all;
//    }





    //Сохранение файла
    public void SaveInJSON(String fn) {
        try {

            // Создаем список для хранения объектов Figure_s
            List<Figure_s> figuresList = new ArrayList<>();
            for (figures f : all) {
                Figure_s fig = new Figure_s();
                String gType = f.getClass().toString();
                //System.out.println(f.getShape().toString());
                gType = gType.replace("class figure.", "");
                fig.setX_pos(Integer.toString(f.getXX()));
                fig.setY_pos(Integer.toString(f.getYY()));
                fig.setShape(gType);
                fig.setSize(Integer.toString(f.getSises()));
                fig.setId(Integer.toString(f.getId()));
                // Добавляем объект Figure_s в список
                figuresList.add(fig);
            }
            
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get(fn).toFile(), figuresList);
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(jMDIFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    // *** Загружаем модель из файла JSON ***
    public void LoadFromJSON(String saveName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Читаем JSON из файла в виде строки
            //String jsonString = Files.readString(Paths.get(saveName));
            Path filePath = Path.of(saveName);
            String jsonString = Files.readString(filePath);
            
            
            //File file = new File(saveName);
            //String content = FileUtils.readFileToString(file, "UTF-8");
            
            
            
            
            //String jsonString;
            //jsonString = objectMapper.readValue(Paths.get(saveName));// . .read readValue(Paths.get(saveName));
            // Преобразуем JSON в список объектов Figure_s
            List<Figure_s> figuresList;
            figuresList = objectMapper.readValue(jsonString, new TypeReference<List<Figure_s>>() { });
            jPanel1.removeAll();
            jPanel1.revalidate(); 
            jPanel1.repaint();
            all.clear();
            // Преобразуем объекты Figure_s в объекты Figure
            for (Figure_s fig : figuresList) {
                readSaveData rs = new readSaveData();
                all = rs.getElement(all, fig.getShape(), fig.getX_pos(), fig.getY_pos(), fig.getSize()/*Sshape,Sx,Sy,Ss*/); //Заносим фигуру в список используемых в проекте фигур
            }
            // Выводим результат
            for (figures b : all) { //добавляем фигуры
                b.setSize(jPanel1.getWidth(), jPanel1.getHeight());
                b.setVisible(true);
                jPanel1.add(b);
            }
            jPanel1.revalidate(); 
            jPanel1.repaint();
            fileName = saveName;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
       ButtonActivated();
    }  

    //Рисование сетки / миллимитровки
    private void paintGrid(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Определяем размер ячейки сетки
        int cellSize = 20;

        // Определяем размеры панели
        int panelWidth = jPanel1.getWidth();
        int panelHeight = jPanel1.getHeight();

        // Определяем начальные координаты для рисования сетки
        int startX = 0;
        int startY = 0;

        // Отрисовываем вертикальные линии сетки
        for (int x = startX; x <= panelWidth; x += cellSize) {
            g2d.drawLine(x, 0, x, panelHeight);
        }

        // Отрисовываем горизонтальные линии сетки
        for (int y = startY; y <= panelHeight; y += cellSize) {
            g2d.drawLine(0, y, panelWidth, y);
        }       
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        
        if (change_idx){
            Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            int dialogResult = JOptionPane.showConfirmDialog (this, "Project wasn't saved. Would you like to save your project?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(image));
            if (dialogResult == JOptionPane.YES_OPTION) {
               if (!("".equals(fileName))) {
                   SaveInJSON(fileName);
               } else {
                   JFileChooser SaveChooser = new javax.swing.JFileChooser();
                   SaveChooser.setDialogTitle("Specify a file to save");
                   SaveChooser.setCurrentDirectory(new File("."));
                   SaveChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                   SaveChooser.setFileFilter(new FileNameExtensionFilter("Event-driven Process Methodology", "epm"));
                   SaveChooser.approveSelection();
                   int option = SaveChooser.showSaveDialog(this);

                    Field field2 = null;
        
                    if(option != JFileChooser.CANCEL_OPTION) {
            
                        File file1 = SaveChooser.getSelectedFile(); 
                        String file = null;
            
                        try {
                            file = file1.getCanonicalPath();
                        } catch (IOException ex) {
                            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        fileName=file;
                        SaveInJSON(fileName);
                     }                   
                   
               } 
            }
        }
        
        change_idx=false;
        draw_idx=false;
        ButtonActivated();
    }//GEN-LAST:event_formInternalFrameClosing

    //Отпускание нажатой кнопки мыши
    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        // Когда закончили перетаскивать объект и отпкстили мышку снова делаем курсор-стрелочку
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jPanel1MouseReleased

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        // очищаем все
        //mdi.jMenuIt
        //emClear.clearActionPerformed(evt);
        //jPanel1.clear
        
        //нужно сделать вызов из jPanel чтобы не переписывать несколько раз
        
        //jPanel1.removeAll();
        //jPanel1.repaint();
        //all.clear();
        zoom = 1;
        //ButtonActivated();
        
    }//GEN-LAST:event_clearActionPerformed

    private void jScrollPane1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane1MouseWheelMoved
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jScrollPane1MouseWheelMoved

    private void jScrollPane1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jScrollPane1CaretPositionChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane1CaretPositionChanged

    private void zminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zminusActionPerformed
        //начало работы Иванова А.А. изменение масштаба и его мин значение
        if (zoom >0.25)
        {
            zoom = zoom - 0.15;
        } else {
            return;
        }
        //конец работы Иванова А.А.
        s = (int) (k * zoom);
        x = jPanel1.getWidth();
        y = jPanel1.getHeight();

        for (figures b : all) {
            b.setS(s);
            oldX = b.getXX();
            oldY = b.getYY();
            //            dx = (int) zoom * abs((x / 2 - oldX));
            //            if (oldX > x / 2) {
                //                newX = oldX - dx;
                //            } else {
                //                newX = oldX + dx;
                //            }
            //            dy = (int) zoom * abs((y / 2 - oldY));
            //            if (oldY > y / 2) {
                //                newY = oldY - dy;
                //            } else {
                //                newY = oldY + dy;
                //            }
            //Начало работы Иванова А.А. изменение координат объектов
            //смещение от центра
            dx = oldX - x/2;
            dy = oldY - y/2;

            //смещаем к центру
            newX = oldX - dx;
            newY = oldY - dy;

            dx = (int)(dx*(zoom-0.13)/zoom);
            dy = (int)(dy*(zoom-0.13)/zoom);

            //прибавляем новое смещение
            newX += dx;
            newY += dy;

            b.setXX(newX);
            b.setYY(newY);
        }

        jSize.setText(String.format("%.2f", zoom));
        //Конец работы Иванова А.А.
        jPanel1.repaint();
    }//GEN-LAST:event_zminusActionPerformed

    private void zplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zplusActionPerformed
        //начало работы Иванова А.А. максимальное значение масштаба и шаг
        if (zoom < 3.9)
        {
            zoom = zoom + 0.15;
        } else {
            return;
        }
        //конец работы работы Иванова А.А.
        s = (int) (k * zoom);
        x = jPanel1.getWidth();
        y = jPanel1.getHeight();

        for (figures b : all) {
            b.setS(s);
            oldX = b.getXX();
            oldY = b.getYY();
            //            dx = (int) zoom * abs((x / 2 - oldX));
            //            if (oldX > x / 2) {
                //                newX = oldX + dx;
                //            } else {
                //                newX = oldX - dx;
                //            }
            //            dy = (int) zoom * abs((y / 2 - oldY));
            //            if (oldY > y / 2) {
                //                newY = oldY + dy;
                //            } else {
                //                newY = oldY - dy;
                //            }
            //начало работы Иванова А.А. изменение координат объектов
            dx = oldX - x/2; //смещение от центра
            dy = oldY - y/2;

            //смещаем к центру
            newX = oldX - dx;
            newY = oldY - dy;

            //умножаем смещение на zoom
            dx = (int)(dx/(zoom-0.15)*zoom);
            dy = (int)(dy/(zoom-0.15)*zoom);

            //прибавляем новое смещение
            newX += dx;
            newY += dy;

            b.setXX(newX);
            b.setYY(newY);
        }

        jSize.setText(String.format("%.2f", zoom));
        //Конец работы Иванова А.А.
        jPanel1.repaint();
    }//GEN-LAST:event_zplusActionPerformed

    
  // Активация / деактивация кнопки Save 
  public void ButtonActivated() {                                            
        if (change_idx) {
            mdi.Save.setEnabled(true); 
            mdi.jButtonSave.setEnabled(true);
            mdi.Saveas.setEnabled(true);
        } else {
           mdi.Save.setEnabled(false); 
           mdi.jButtonSave.setEnabled(false);
           mdi.Saveas.setEnabled(false);
        }
        
        if (draw_idx) {
           mdi.jButtonS.setEnabled(true);
           mdi.jButtonV.setEnabled(true); 
           mdi.jButtonNV.setEnabled(true);
           mdi.jButtonR.setEnabled(true);
           mdi.jButtonIF.setEnabled(true);
           mdi.jMenuItemS.setEnabled(true);
           mdi.jMenuItemV.setEnabled(true);
           mdi.jMenuItemR.setEnabled(true);
           mdi.jMenuItemNV.setEnabled(true);
           mdi.jMenuItemIF.setEnabled(true);
           mdi.jMenuItemClear.setEnabled(true);
        } else {
           mdi.jButtonS.setEnabled(false);
           mdi.jButtonV.setEnabled(false); 
           mdi.jButtonNV.setEnabled(false);
           mdi.jButtonR.setEnabled(false);
           mdi.jButtonIF.setEnabled(false);
           mdi.jMenuItemS.setEnabled(false);
           mdi.jMenuItemV.setEnabled(false);
           mdi.jMenuItemR.setEnabled(false);
           mdi.jMenuItemNV.setEnabled(false);
           mdi.jMenuItemIF.setEnabled(false);
           mdi.jMenuItemClear.setEnabled(false);            
        }
    }          
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JMenuItem jMenuItemClear;
    private javax.swing.JMenuItem jMenuItemDelette;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSize;
    private javax.swing.JPopupMenu rcMenu;
    private javax.swing.JButton zminus;
    private javax.swing.JButton zplus;
    // End of variables declaration//GEN-END:variables

}
