package jMDIForm;

import figure.figures;
import java.awt.Dialog;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class PropertiesDialog extends javax.swing.JDialog {

    private DefaultListModel<String> listModelInn; //для отображения списка входных переменных
    private DefaultListModel<String> listModelOut; //для отображения списка входных переменных
    int delIndIn = -1; //Индекс для удаления
    int delIndOut = -1; //Индекс для удаления
    Point2D p; //текущая точка
    String typeAdd; //in или out;
    figures figOnWork; //текущая фигура
    public ArrayList<String> saveInVariable = new ArrayList(); // Лист со входными переменными для сохранения
    public ArrayList<String> saveOutVariable = new ArrayList(); // Лист с выходными переменными для сохранения
    
    int SWorkIndex;//выбранный тип работы 0-поток пуассона, 1- периодическая
    int VProperties; // выбранный пункт в V фигуре 0-экспонента, 1-элеиент, 2-1шаг, 3-логарифм, 4-xlog
    
    public PropertiesDialog(java.awt.Frame parent, boolean modal,  figures fig) {
        super(parent, modal);
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
        
        Swork.setSelectedIndex(fig.getSwork());
        SWorkIndex = Swork.getSelectedIndex();
        mainBodyTabbedPanel.addTab("Основные",mainPanel); // добавление нужных окон делаем через этот метод
        switch (fig.getClass().toString().replace("class figure.", "")) {//устанавливаем спец свойства
            case "S1":
                mainBodyTabbedPanel.addTab("Свойства S",SpropertiesPanel); // добавление нужных окон делаем через этот метод
                if (SWorkIndex == 0) {
                    probabilityLabel.setEnabled(true);
                    Slikelihood.setEnabled(true);
                    Slikelihood.setText(figOnWork.getLikelihood());//устанавливаем значение вероятнсти
                } else if (SWorkIndex == 1) {
                    periodLabel.setEnabled(true);
                    Speriod.setEnabled(true);
                    Speriod.setText(figOnWork.getPeriod());//устанавливаем значение периода
                }
                break;
            case "V":
                for (Enumeration<AbstractButton> buttons = properties.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.getText().equals(figOnWork.getVSelected())) {
                        button.setSelected(true);
                        break;
                    }
                }
                mainBodyTabbedPanel.addTab("Свойства V",VpropertiesPanel); // добавление нужных окон делаем через этот метод
                break;
            case "O":
                mainBodyTabbedPanel.addTab("Свойства O",OpropertiesPanel); // добавление нужных окон делаем через этот метод
                Ocoef.setText(fig.getCoef());//утсанавливаем значение коэффициента эффективности
                break;
        }
        
        
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

    private PropertiesDialog(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        properties = new javax.swing.ButtonGroup();
        SpropertiesPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Swork = new javax.swing.JComboBox<>();
        probabilityLabel = new javax.swing.JLabel();
        periodLabel = new javax.swing.JLabel();
        Slikelihood = new javax.swing.JFormattedTextField();
        Speriod = new javax.swing.JFormattedTextField();
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
        VpropertiesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        expButton = new javax.swing.JRadioButton();
        xButton = new javax.swing.JRadioButton();
        stepButton = new javax.swing.JRadioButton();
        logButton = new javax.swing.JRadioButton();
        xlogButton = new javax.swing.JRadioButton();
        OpropertiesPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Ocoef = new javax.swing.JFormattedTextField();
        mainBodyTabbedPanel = new javax.swing.JTabbedPane();
        cancelPropBut = new javax.swing.JButton();
        savePropBut = new javax.swing.JButton();

        SpropertiesPanel.setEnabled(false);

        jLabel2.setText("Работа элемента");

        Swork.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Поток Пуассона", "Периодическая" }));
        Swork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SworkActionPerformed(evt);
            }
        });

        probabilityLabel.setText("Вероятность:");
        probabilityLabel.setEnabled(false);

        periodLabel.setText("Период:");
        periodLabel.setEnabled(false);

        Slikelihood.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.###"))));
        Slikelihood.setToolTipText("0,1 - 10");
        Slikelihood.setEnabled(false);
        Slikelihood.setMaximumSize(new java.awt.Dimension(133, 23));
        Slikelihood.setMinimumSize(new java.awt.Dimension(70, 23));
        Slikelihood.setName(""); // NOI18N
        Slikelihood.setPreferredSize(new java.awt.Dimension(70, 23));
        Slikelihood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SlikelihoodActionPerformed(evt);
            }
        });
        Slikelihood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SlikelihoodKeyTyped(evt);
            }
        });

        Speriod.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        Speriod.setToolTipText("1-1000");
        Speriod.setEnabled(false);
        Speriod.setMaximumSize(new java.awt.Dimension(133, 23));
        Speriod.setMinimumSize(new java.awt.Dimension(70, 23));
        Speriod.setPreferredSize(new java.awt.Dimension(70, 23));
        Speriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SperiodActionPerformed(evt);
            }
        });
        Speriod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SperiodKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout SpropertiesPanelLayout = new javax.swing.GroupLayout(SpropertiesPanel);
        SpropertiesPanel.setLayout(SpropertiesPanelLayout);
        SpropertiesPanelLayout.setHorizontalGroup(
            SpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpropertiesPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(SpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SpropertiesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Swork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SpropertiesPanelLayout.createSequentialGroup()
                        .addGroup(SpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(probabilityLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(periodLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(SpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Speriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slikelihood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        SpropertiesPanelLayout.setVerticalGroup(
            SpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpropertiesPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(SpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Swork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(probabilityLabel)
                    .addComponent(Slikelihood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(SpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodLabel)
                    .addComponent(Speriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

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
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
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
                        .addGap(0, 195, Short.MAX_VALUE))
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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
                                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(inVariableList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outVariableList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(variablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInOutList)
                    .addComponent(removeFromOutList)
                    .addComponent(addInInList)
                    .addComponent(removeFromInList))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        VpropertiesPanel.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setText("Сложность алгоритма");

        properties.add(expButton);
        expButton.setText("Экспонента (exp(x))");

        properties.add(xButton);
        xButton.setText("Элемент (х)");
        xButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButtonActionPerformed(evt);
            }
        });

        properties.add(stepButton);
        stepButton.setText("1 шаг (1)");

        properties.add(logButton);
        logButton.setText("Логарифм (log(x))");

        properties.add(xlogButton);
        xlogButton.setText("xlog(x)");

        javax.swing.GroupLayout VpropertiesPanelLayout = new javax.swing.GroupLayout(VpropertiesPanel);
        VpropertiesPanel.setLayout(VpropertiesPanelLayout);
        VpropertiesPanelLayout.setHorizontalGroup(
            VpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VpropertiesPanelLayout.createSequentialGroup()
                .addGroup(VpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VpropertiesPanelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(VpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xlogButton)
                            .addComponent(logButton)
                            .addComponent(stepButton)
                            .addComponent(xButton)
                            .addComponent(expButton)))
                    .addGroup(VpropertiesPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        VpropertiesPanelLayout.setVerticalGroup(
            VpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VpropertiesPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xlogButton)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        OpropertiesPanel.setVerifyInputWhenFocusTarget(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Коэффициент эффективности:");

        Ocoef.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.#"))));
        Ocoef.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Ocoef.setToolTipText("0,1-10");
        Ocoef.setActionCommand("<Not Set>");
        Ocoef.setDoubleBuffered(true);
        Ocoef.setMaximumSize(new java.awt.Dimension(133, 23));
        Ocoef.setMinimumSize(new java.awt.Dimension(70, 23));
        Ocoef.setPreferredSize(new java.awt.Dimension(70, 23));
        Ocoef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OcoefKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout OpropertiesPanelLayout = new javax.swing.GroupLayout(OpropertiesPanel);
        OpropertiesPanel.setLayout(OpropertiesPanelLayout);
        OpropertiesPanelLayout.setHorizontalGroup(
            OpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpropertiesPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(Ocoef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        OpropertiesPanelLayout.setVerticalGroup(
            OpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpropertiesPanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(OpropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Ocoef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cancelPropBut.setText("Отмена");
        cancelPropBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPropButActionPerformed(evt);
            }
        });

        savePropBut.setText("Сохранить");
        savePropBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePropButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainBodyTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cancelPropBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(savePropBut))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainBodyTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savePropBut)
                    .addComponent(cancelPropBut))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        figOnWork.setNameF(nameTextField.getText());
//        figOnWork.setDescriptionF(descriptionTextField.getText());
//        figOnWork.setCodeF(codeTextField.getText()); //Раньше при закрытии окна сохранялись параметры фигуры, теперь при нажатии на кнопку
// РАСКОМЕНТИРОВАТЬ ЕСЛИ НУЖНО СОХРАНЕНЕ АВТОМАТИЧЕСКОЕ ПОСЛЕ ЗАКРЫТИЯ ОКНА!
    }//GEN-LAST:event_formWindowClosing

    private void removeFromOutListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromOutListActionPerformed
        saveOutVariable.remove(delIndOut); //Удаляем элемент с выбранным индексом в фигуре
        listModelOut.remove(delIndOut); //Удаляем элемент с выбранным индексом в списке
        delIndOut = -1; //обнуляем индекс
        removeFromOutList.setEnabled(false);
    }//GEN-LAST:event_removeFromOutListActionPerformed

    private void addInOutListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInOutListActionPerformed
        String initialValue = "Y"+ (saveOutVariable.size()+1);
        //Показываем окно ввода и деактивируем остальные окна
        String varName = (String) JOptionPane.showInputDialog(null, "Введите название переменной:", "Создание выходной переменной", JOptionPane.PLAIN_MESSAGE, null, null, initialValue);
        // Проверяем, было ли что-то введено
        if (!(varName.isEmpty() || varName.length()>=20)) {
            if (saveOutVariable.contains(varName)){
                JOptionPane.showMessageDialog(null, "Переменная с таким названием уже существует!");
            }
            else{
                listModelOut.addElement(varName); //добавялем элемент с введённым названием в список вход
                saveOutVariable.add(varName); //добавялем элемент с введённым названием в фигуру
            }
        } else {
            JOptionPane.showMessageDialog(null, "Данная длина переменной недоступна.","Ошибка",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addInOutListActionPerformed

    private void removeFromInListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromInListActionPerformed
        saveInVariable.remove(delIndIn); //Удаляем элемент с выбранным индексом в фигуре
        listModelInn.remove(delIndIn); //Удаляем элемент с выбранным индексом в списке
        delIndIn = -1; //обнуляем индекс
        removeFromInList.setEnabled(false); //Выключкаем кнопку удаления
    }//GEN-LAST:event_removeFromInListActionPerformed

    private void addInInListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInInListActionPerformed
        String initialValue = "X"+ (saveInVariable.size()+1);
        //Показываем окно ввода и деактивируем остальные окна
        String varName = (String) JOptionPane.showInputDialog(null, "Введите название переменной:", "Создание входной переменной", JOptionPane.PLAIN_MESSAGE, null, null, initialValue);
        // Проверяем, было ли что-то введено
        if (!(varName.isEmpty() || varName.length()>=20)) {
            if (saveInVariable.contains(varName)){
                JOptionPane.showMessageDialog(null, "Переменная с таким названием уже существует!");
            }
            else{
                listModelInn.addElement(varName); //добавялем элемент с введённым названием в список вход
                saveInVariable.add(varName); //добавялем элемент с введённым названием в фигуру
            }
        } else {
            JOptionPane.showMessageDialog(null, "Данная длина переменной недоступна.","Ошибка",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addInInListActionPerformed

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

    private void outItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outItemsMouseClicked

    }//GEN-LAST:event_outItemsMouseClicked

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

    private void inItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inItemsMouseClicked

    }//GEN-LAST:event_inItemsMouseClicked

    private void codeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeTextFieldActionPerformed

    private void nameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldKeyTyped

    private void nameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyReleased
        this.setTitle(nameTextField.getText()); //Устанавливаем тайтлу окна название фигуры после изменения поля фигуры
    }//GEN-LAST:event_nameTextFieldKeyReleased

    private void nameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldKeyPressed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed

    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void nameTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_nameTextFieldInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldInputMethodTextChanged

    private void descriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTextFieldActionPerformed

    private void savePropButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePropButActionPerformed
        //Сохранение параметров фигуры на кнопку
        figOnWork.setNameF(nameTextField.getText());
        figOnWork.setDescriptionF(descriptionTextField.getText());
        
        figOnWork.setCodeF(codeTextField.getText());
        
        figOnWork.setCoef(Ocoef.getText());
        
        figOnWork.setLikelihood(Slikelihood.getText());
        figOnWork.setPeriod(Speriod.getText());
        figOnWork.setSwork(Swork.getSelectedIndex());
        
        for (Enumeration<AbstractButton> buttons = properties.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                figOnWork.setVSelected(button.getText());
            }
        }

        this.dispose();
    }//GEN-LAST:event_savePropButActionPerformed

    private void cancelPropButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPropButActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelPropButActionPerformed

    private void SlikelihoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SlikelihoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SlikelihoodActionPerformed

    private void SlikelihoodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SlikelihoodKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_SlikelihoodKeyTyped

    private void SperiodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SperiodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SperiodActionPerformed

    private void SperiodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SperiodKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_SperiodKeyTyped

    private void xButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xButtonActionPerformed

    private void OcoefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OcoefKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_OcoefKeyTyped

    private void SworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SworkActionPerformed
        SWorkIndex = Swork.getSelectedIndex();
        if (SWorkIndex == 0) {
            periodLabel.setEnabled(false);
            Speriod.setEnabled(false);
            probabilityLabel.setEnabled(true);
            Slikelihood.setEnabled(true);
            Slikelihood.setText("0,5");
            Speriod.setText("");
        } else if (SWorkIndex == 1) {
            probabilityLabel.setEnabled(false);
            Slikelihood.setEnabled(false);
            periodLabel.setEnabled(true);
            Speriod.setEnabled(true);
            Slikelihood.setText("");
            Speriod.setText("5");
        }
    }//GEN-LAST:event_SworkActionPerformed
 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PropertiesDialog dialog = new PropertiesDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField Ocoef;
    private javax.swing.JPanel OpropertiesPanel;
    private javax.swing.JFormattedTextField Slikelihood;
    private javax.swing.JFormattedTextField Speriod;
    private javax.swing.JPanel SpropertiesPanel;
    private javax.swing.JComboBox<String> Swork;
    private javax.swing.JPanel VpropertiesPanel;
    private javax.swing.JButton addInInList;
    private javax.swing.JButton addInOutList;
    private javax.swing.JButton cancelPropBut;
    private javax.swing.JScrollPane codePanel;
    private javax.swing.JPanel codeTPanel;
    private java.awt.TextField codeTextField;
    private java.awt.TextField descriptionTextField;
    private javax.swing.JRadioButton expButton;
    private javax.swing.JList<String> inItems;
    private java.awt.Label inVariableLabel;
    private javax.swing.JScrollPane inVariableList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private java.awt.Label label6;
    private javax.swing.JRadioButton logButton;
    private javax.swing.JTabbedPane mainBodyTabbedPanel;
    private javax.swing.JPanel mainPanel;
    private java.awt.Label nameLabel;
    private java.awt.TextField nameTextField;
    private javax.swing.JList<String> outItems;
    private java.awt.Label outVariableLabel;
    private javax.swing.JScrollPane outVariableList;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JLabel probabilityLabel;
    private javax.swing.ButtonGroup properties;
    private javax.swing.JButton removeFromInList;
    private javax.swing.JButton removeFromOutList;
    private javax.swing.JButton savePropBut;
    private javax.swing.JRadioButton stepButton;
    private javax.swing.JPanel variablePanel;
    private javax.swing.JRadioButton xButton;
    private javax.swing.JRadioButton xlogButton;
    // End of variables declaration//GEN-END:variables
}
