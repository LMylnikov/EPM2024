package jMDIForm;

import figure.figures;
import java.awt.Dialog;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

public class Properties extends JInternalFrame  {
    private DefaultListModel<String> listModelInn; //для отображения списка входных переменных
    private DefaultListModel<String> listModelOut; //для отображения списка входных переменных
    int lid = 1; //счетчик для переменных
    int delIndIn = -1; //Индекс для удаления
    int delIndOut = -1; //Индекс для удаления
    Point2D p; //текущая точка
    String typeAdd; //in или out;
    figures figOnWork; //текущая фигура
    public ArrayList<String> saveInVariable = new ArrayList(); // Лист со входными переменными для сохранения
    public ArrayList<String> saveOutVariable = new ArrayList(); // Лист с выходными переменными для сохранения
    public Properties(String title, Boolean resizable, Boolean closable, Boolean maximizable, Boolean iconifiable, String file, figures fig) {
        super(title, false, closable, false, false);
        initComponents();
        
        listModelInn = new DefaultListModel<>(); //лист модел для вход переменных
        inItems.setModel(listModelInn); //привязываем лист входных эл и лист модел
        
        listModelOut = new DefaultListModel<>(); //лист модел для выход переменных
        outItems.setModel(listModelOut); //привязываем лист выходных эл и лист модел
        
        figOnWork = fig; //Связываем оригинальную и вспомогательную фигуру-копию
        saveInVariable = figOnWork.getInVariable();
        saveOutVariable = figOnWork.getOutVariable();
        // Заполняем поля от фигуры
        this.setTitle(fig.getNameF()); // Устанавливаем заголовок как имя объекта
        nameTextField.setText(fig.getNameF()); //устанавливаем имя фигуры
        descriptionTextField.setText(fig.getDescriptionF());   //устанавливаем описание фигуры
        codeTextField.setText(fig.getCodeF()); // Установка текста кода фигуры
        // Заполняем списки переменными фигуры
        for (String inVar : saveInVariable){ 
            listModelInn.addElement(inVar);
        }
        for (String outVar : saveOutVariable){
            listModelOut.addElement(outVar);
        }   
        addInInList.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "none");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addingWindowFrame = new javax.swing.JFrame();
        awAdd = new javax.swing.JToggleButton();
        awBack = new javax.swing.JToggleButton();
        awText = new javax.swing.JLabel();
        awTextField = new javax.swing.JTextField();
        mainBodyTabbedPanel = new javax.swing.JTabbedPane();
        mainPanel = new javax.swing.JPanel();
        descriptionTextField = new java.awt.TextField();
        nameTextField = new java.awt.TextField();
        nameLabel = new java.awt.Label();
        label6 = new java.awt.Label();
        codePanel = new javax.swing.JScrollPane();
        codeTPanel = new javax.swing.JPanel();
        codeTextField = new java.awt.TextField();
        variablePanel = new javax.swing.JPanel();
        outVariableLabel = new java.awt.Label();
        inVariableLabel = new java.awt.Label();
        inVariableList = new javax.swing.JScrollPane();
        inItems = new javax.swing.JList<>();
        outVariableList = new javax.swing.JScrollPane();
        outItems = new javax.swing.JList<>();
        addInInList = new javax.swing.JButton();
        removeFromInList = new javax.swing.JButton();
        addInOutList = new javax.swing.JButton();
        removeFromOutList = new javax.swing.JButton();

        addingWindowFrame.setAlwaysOnTop(true);
        addingWindowFrame.setIconImages(null);
        addingWindowFrame.setMaximumSize(new java.awt.Dimension(269, 165));
        addingWindowFrame.setMinimumSize(new java.awt.Dimension(269, 165));
        addingWindowFrame.setName("addVar"); // NOI18N
        addingWindowFrame.setPreferredSize(new java.awt.Dimension(269, 165));
        addingWindowFrame.setResizable(false);
        addingWindowFrame.setSize(new java.awt.Dimension(269, 165));

        awAdd.setBackground(new java.awt.Color(204, 255, 204));
        awAdd.setText("Создать");
        awAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                awAddActionPerformed(evt);
            }
        });

        awBack.setBackground(new java.awt.Color(255, 204, 204));
        awBack.setText("Отмена");
        awBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                awBackActionPerformed(evt);
            }
        });

        awText.setText("Введите название для переменной");

        awTextField.setText("X");
        awTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                awTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                awTextFieldFocusLost(evt);
            }
        });
        awTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                awTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addingWindowFrameLayout = new javax.swing.GroupLayout(addingWindowFrame.getContentPane());
        addingWindowFrame.getContentPane().setLayout(addingWindowFrameLayout);
        addingWindowFrameLayout.setHorizontalGroup(
            addingWindowFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingWindowFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addingWindowFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addingWindowFrameLayout.createSequentialGroup()
                        .addComponent(awBack, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(awAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addingWindowFrameLayout.createSequentialGroup()
                        .addComponent(awText, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addComponent(awTextField))
                .addContainerGap())
        );
        addingWindowFrameLayout.setVerticalGroup(
            addingWindowFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingWindowFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(awText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(awTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(addingWindowFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(awAdd)
                    .addComponent(awBack))
                .addContainerGap())
        );

        addingWindowFrame.getAccessibleContext().setAccessibleDescription("");
        addingWindowFrame.getAccessibleContext().setAccessibleParent(variablePanel);

        setResizable(true);
        setMinimumSize(new java.awt.Dimension(560, 130));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                formAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });

        descriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTextFieldActionPerformed(evt);
            }
        });

        nameTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                nameTextFieldInputMethodTextChanged(evt);
            }
        });
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyTyped(evt);
            }
        });

        nameLabel.setText("Имя");

        label6.setText("Описание");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 171, Short.MAX_VALUE))
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainBodyTabbedPanel.addTab("Основные", mainPanel);

        codeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout codeTPanelLayout = new javax.swing.GroupLayout(codeTPanel);
        codeTPanel.setLayout(codeTPanelLayout);
        codeTPanelLayout.setHorizontalGroup(
            codeTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(codeTPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        codeTPanelLayout.setVerticalGroup(
            codeTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(codeTPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        codePanel.setViewportView(codeTPanel);

        mainBodyTabbedPanel.addTab("Код", codePanel);

        outVariableLabel.setText("Выходные");

        inVariableLabel.setText("Входные");

        inItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inItemsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inItemsMousePressed(evt);
            }
        });
        inVariableList.setViewportView(inItems);

        outItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outItemsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                outItemsMousePressed(evt);
            }
        });
        outVariableList.setViewportView(outItems);

        addInInList.setBackground(new java.awt.Color(204, 255, 204));
        addInInList.setText("Add");
        addInInList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInInListActionPerformed(evt);
            }
        });

        removeFromInList.setBackground(new java.awt.Color(255, 204, 204));
        removeFromInList.setText("Del");
        removeFromInList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromInListActionPerformed(evt);
            }
        });

        addInOutList.setBackground(new java.awt.Color(204, 255, 204));
        addInOutList.setText("Add");
        addInOutList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInOutListActionPerformed(evt);
            }
        });

        removeFromOutList.setBackground(new java.awt.Color(255, 204, 204));
        removeFromOutList.setText("Del");
        removeFromOutList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromOutListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout variablePanelLayout = new javax.swing.GroupLayout(variablePanel);
        variablePanel.setLayout(variablePanelLayout);
        variablePanelLayout.setHorizontalGroup(
            variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(variablePanelLayout.createSequentialGroup()
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(variablePanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(removeFromInList, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addInInList, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(variablePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inVariableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inVariableList, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(variablePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(variablePanelLayout.createSequentialGroup()
                                .addComponent(outVariableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))
                            .addComponent(outVariableList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, variablePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeFromOutList, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addInOutList, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        variablePanelLayout.setVerticalGroup(
            variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(variablePanelLayout.createSequentialGroup()
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outVariableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inVariableLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outVariableList, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inVariableList, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInOutList)
                    .addComponent(removeFromOutList)
                    .addComponent(addInInList)
                    .addComponent(removeFromInList))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        mainBodyTabbedPanel.addTab("Переменные", variablePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainBodyTabbedPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainBodyTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void removeFromOutListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromOutListActionPerformed
        saveOutVariable.remove(delIndOut); //Удаляем элемент с выбранным индексом в фигуре
        listModelOut.remove(delIndOut); //Удаляем элемент с выбранным индексом в списке
        delIndOut = -1; //обнуляем индекс
        removeFromOutList.setEnabled(false);
    }//GEN-LAST:event_removeFromOutListActionPerformed

    private void addInOutListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInOutListActionPerformed
        awTextField.setText("Y"+lid); //Автоматическое подставление имени х+номер
        typeAdd = "out";
        //Показываем окно ввода и деактивируем остальные окна
        addingWindowFrame.setVisible(true);
        addingWindowFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addingWindowFrame.setLocationRelativeTo(this);
        mainBodyTabbedPanel.setEnabled(false);
        removeFromInList.setEnabled(false);
        removeFromOutList.setEnabled(false);
    }//GEN-LAST:event_addInOutListActionPerformed

    private void removeFromInListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromInListActionPerformed
        saveInVariable.remove(delIndIn); //Удаляем элемент с выбранным индексом в фигуре
        listModelInn.remove(delIndIn); //Удаляем элемент с выбранным индексом в списке
        delIndIn = -1; //обнуляем индекс
        removeFromInList.setEnabled(false); //Выключкаем кнопку удаления
        
    }//GEN-LAST:event_removeFromInListActionPerformed

    private void addInInListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInInListActionPerformed
        awTextField.setText("X"+lid); //Автоматическое подставление имени х+номер
        typeAdd = "in";
        //Показываем окно ввода и деактивируем остальные окна
        addingWindowFrame.setVisible(true);
        addingWindowFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addingWindowFrame.setLocationRelativeTo(this);
        mainBodyTabbedPanel.setEnabled(false);
        removeFromInList.setEnabled(false);
        removeFromOutList.setEnabled(false);
        
    }//GEN-LAST:event_addInInListActionPerformed

    private void codeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeTextFieldActionPerformed

    private void descriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTextFieldActionPerformed

    private void awBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_awBackActionPerformed
        // Прячем окно ввода и активируем остальные окна
        addingWindowFrame.setVisible(false);
        mainBodyTabbedPanel.setEnabled(true);
//        removeFromInList.setEnabled(true);
//        removeFromOutList.setEnabled(true);
    }//GEN-LAST:event_awBackActionPerformed

    private void awTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_awTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_awTextFieldActionPerformed

    private void awAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_awAddActionPerformed
        if (typeAdd == "in"){ //проверяем что добавляем в список вход пер
            listModelInn.addElement(awTextField.getText()); //добавялем элемент с введённым названием в список вход
            saveInVariable.add(awTextField.getText()); //добавялем элемент с введённым названием в фигуру
        }
        if (typeAdd == "out"){ //проверяем что добавляем в список выход пер
            listModelOut.addElement(awTextField.getText()); //добавялем элемент с введённым названием в список выход
            saveOutVariable.add(awTextField.getText());//добавялем элемент с введённым названием в фигуру
        }
        lid+=1; //добавляем уникальный индекс для авто добавления элементов
        // Прячем окно ввода и активируем остальные окна
        addingWindowFrame.setVisible(false); 
        mainBodyTabbedPanel.setEnabled(true);
        
    }//GEN-LAST:event_awAddActionPerformed

    private void inItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inItemsMouseClicked
        
    }//GEN-LAST:event_inItemsMouseClicked

    private void inItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inItemsMousePressed
        //Выюор элеимента для удаления в списке вход. пер
        p = evt.getPoint();
        if (inItems.contains((Point) p) == true){
            delIndIn = inItems.locationToIndex((Point) p); //проверяем индекс на котором произошло нажатие (можно изменить на клик)
            if (delIndIn != -1){
                    removeFromInList.setEnabled(true);
            }
            else{
                    removeFromInList.setEnabled(false);
            } 
        }
    }//GEN-LAST:event_inItemsMousePressed

    private void outItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outItemsMouseClicked
        
    }//GEN-LAST:event_outItemsMouseClicked

    private void awTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_awTextFieldFocusGained
        //Добавляем возможность добавления через кнопку ентер
        awTextField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
        awTextField.getActionMap().put("enterAction", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                awAddActionPerformed(e);
            }
        });
    }//GEN-LAST:event_awTextFieldFocusGained

    private void outItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outItemsMousePressed
        //Выюор элеимента для удаления в списке выход. пер
        p = evt.getPoint();
        if (outItems.contains((Point) p) == true){
            delIndOut = outItems.locationToIndex((Point) p); //проверяем индекс на котором произошло нажатие (можно изменить на клик)
            if (delIndOut != -1){
                    removeFromOutList.setEnabled(true);
            }
            else{
                    removeFromOutList.setEnabled(false);
            }
        }
    }//GEN-LAST:event_outItemsMousePressed

    private void awTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_awTextFieldFocusLost
        //Убираем возможность добавления через кнопку ентер при закрытии окна
        awTextField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "none");
        awTextField.getActionMap().put("enterAction", null);
    }//GEN-LAST:event_awTextFieldFocusLost

    private void formAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorMoved
        
        
    }//GEN-LAST:event_formAncestorMoved

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        // Сохранение изменений в основной фигуре.figOnWork
        figOnWork.setInVariable(saveInVariable);
        figOnWork.setOutVariable(saveOutVariable);
        figOnWork.setNameF(nameTextField.getText());
        figOnWork.setDescriptionF(descriptionTextField.getText());
        figOnWork.setCodeF(codeTextField.getText());
    }//GEN-LAST:event_formAncestorRemoved

    private void nameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldKeyTyped

    private void nameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldKeyPressed

    private void nameTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_nameTextFieldInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldInputMethodTextChanged

    private void nameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyReleased
        this.setTitle(nameTextField.getText()); //Устанавливаем тайтлу окна название фигуры после изменения поля фигуры
    }//GEN-LAST:event_nameTextFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInInList;
    private javax.swing.JButton addInOutList;
    private javax.swing.JFrame addingWindowFrame;
    private javax.swing.JToggleButton awAdd;
    private javax.swing.JToggleButton awBack;
    private javax.swing.JLabel awText;
    private javax.swing.JTextField awTextField;
    private javax.swing.JScrollPane codePanel;
    private javax.swing.JPanel codeTPanel;
    private java.awt.TextField codeTextField;
    private java.awt.TextField descriptionTextField;
    private javax.swing.JList<String> inItems;
    private java.awt.Label inVariableLabel;
    private javax.swing.JScrollPane inVariableList;
    private java.awt.Label label6;
    private javax.swing.JTabbedPane mainBodyTabbedPanel;
    private javax.swing.JPanel mainPanel;
    private java.awt.Label nameLabel;
    private java.awt.TextField nameTextField;
    private javax.swing.JList<String> outItems;
    private java.awt.Label outVariableLabel;
    private javax.swing.JScrollPane outVariableList;
    private javax.swing.JButton removeFromInList;
    private javax.swing.JButton removeFromOutList;
    private javax.swing.JPanel variablePanel;
    // End of variables declaration//GEN-END:variables
}
