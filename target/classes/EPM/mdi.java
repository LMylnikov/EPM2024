package EPM;

//import com.tomtessier.scrollabledesktop.JScrollableDesktopPane;
import com.sun.jdi.Method;
import figure.figures;
import figure.NV;
import figure.R;
import figure.V;
import figure.S1;
import figure.b;
import figure.d;

import jMDIForm.jMDIFrame;
import java.awt.Color;
import javax.swing.JColorChooser;
import java.awt.Dimension;
import java.awt.PopupMenu;
////import com.mycompany.mdi.groupJDBC.artifactJDBC.*;
//import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;
//import java.beans.PropertyVetoException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.Action;
//import javax.swing.ActionMap;
//import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
//import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

//import java.sql.ResultSet;
//import java.sql.Statement;
//import javax.swing.UIManager;

//import sqlCon.DatabaseHandler; //обращение к нашему классу

//import javax.swing.Scrollable;
//import javax.swing.TransferHandler;



public class mdi extends javax.swing.JFrame {
    private static final int FRAME_OFFSET = 20;
    private int c=0; // номер нового создаваемого mdi для вычисления смещения
    private PopupMenu jMDIFrame;
    public mdi() {
         try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        initComponents();
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        setSize (sSize);
    }
    //часть для вырезки, вставки, копирования и удаления
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OpenChooser = new javax.swing.JFileChooser();
        SaveChooser = new javax.swing.JFileChooser();
        Info = new javax.swing.JOptionPane();
        jDialog1 = new javax.swing.JDialog();
        jDesktopPane = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonNew = new javax.swing.JButton();
        jButtonOpen = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonRun = new javax.swing.JButton();
        jButtonStep = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButtonS = new javax.swing.JButton();
        jButtonV = new javax.swing.JButton();
        jButtonNV = new javax.swing.JButton();
        jButtonR = new javax.swing.JButton();
        jButtonIF = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Saveas = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemS = new javax.swing.JMenuItem();
        jMenuItemV = new javax.swing.JMenuItem();
        jMenuItemNV = new javax.swing.JMenuItem();
        jMenuItemR = new javax.swing.JMenuItem();
        jMenuItemIF = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemClear = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuOptions = new javax.swing.JMenu();
        jMenuItemSettings = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Cascade = new javax.swing.JMenuItem();
        Tile = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        Info.setMessage("That's our programm. First versoin.");
        Info.setToolTipText("");
        Info.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jDesktopPane.setBackground(java.awt.SystemColor.windowBorder);
        jDesktopPane.setAutoscrolls(true);
        jDesktopPane.setMinimumSize(new java.awt.Dimension(800, 400));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        jButtonNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/new3.gif"))); // NOI18N
        jButtonNew.setText("New");
        jButtonNew.setFocusable(false);
        jButtonNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonNew);

        jButtonOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open3.gif"))); // NOI18N
        jButtonOpen.setText("Open");
        jButtonOpen.setFocusable(false);
        jButtonOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonOpen);

        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save3.gif"))); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.setEnabled(false);
        jButtonSave.setFocusable(false);
        jButtonSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonSave);
        jToolBar1.add(jSeparator1);

        jButtonRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/run3.gif"))); // NOI18N
        jButtonRun.setText("Run");
        jButtonRun.setEnabled(false);
        jButtonRun.setFocusable(false);
        jButtonRun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRun.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonRun);

        jButtonStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/step3.gif"))); // NOI18N
        jButtonStep.setText("Step");
        jButtonStep.setEnabled(false);
        jButtonStep.setFocusable(false);
        jButtonStep.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonStep.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonStep);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/stop3.gif"))); // NOI18N
        jButton1.setText("Stop");
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator2);

        jButtonS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/S2.gif"))); // NOI18N
        jButtonS.setText("S");
        jButtonS.setEnabled(false);
        jButtonS.setFocusable(false);
        jButtonS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonS);

        jButtonV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/V2.gif"))); // NOI18N
        jButtonV.setText("V");
        jButtonV.setEnabled(false);
        jButtonV.setFocusable(false);
        jButtonV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonV);

        jButtonNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NV2.gif"))); // NOI18N
        jButtonNV.setText("NV");
        jButtonNV.setEnabled(false);
        jButtonNV.setFocusable(false);
        jButtonNV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNVActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonNV);

        jButtonR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/R2.gif"))); // NOI18N
        jButtonR.setText("R");
        jButtonR.setEnabled(false);
        jButtonR.setFocusable(false);
        jButtonR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonR);

        jButtonIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IF2.gif"))); // NOI18N
        jButtonIF.setText("IF");
        jButtonIF.setEnabled(false);
        jButtonIF.setFocusable(false);
        jButtonIF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonIF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIFActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonIF);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jMenuBar1.setAlignmentY(0.5F);
        jMenuBar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.META_DOWN_MASK));
        New.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/new2.gif"))); // NOI18N
        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        jMenu1.add(New);

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_DOWN_MASK));
        Open.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open2.gif"))); // NOI18N
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_DOWN_MASK));
        Save.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save2.gif"))); // NOI18N
        Save.setText("Save");
        Save.setEnabled(false);
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jMenu1.add(Save);

        Saveas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Saveas.setText("Save as ...");
        Saveas.setEnabled(false);
        Saveas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveasActionPerformed(evt);
            }
        });
        jMenu1.add(Saveas);

        quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_DOWN_MASK));
        quit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        quit.setText("Exit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        jMenu1.add(quit);

        jMenuBar1.add(jMenu1);

        jMenuEdit.setText("Edit");
        jMenuEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItemS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/S1.gif"))); // NOI18N
        jMenuItemS.setText("Insert S");
        jMenuItemS.setEnabled(false);
        jMenuItemS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemS);

        jMenuItemV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/V1.gif"))); // NOI18N
        jMenuItemV.setText("Insert V");
        jMenuItemV.setEnabled(false);
        jMenuItemV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemV);

        jMenuItemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NV1.gif"))); // NOI18N
        jMenuItemNV.setText("Insert NV");
        jMenuItemNV.setEnabled(false);
        jMenuItemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNVActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemNV);

        jMenuItemR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/R1.gif"))); // NOI18N
        jMenuItemR.setText("Insert R");
        jMenuItemR.setEnabled(false);
        jMenuItemR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemR);

        jMenuItemIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IF1.gif"))); // NOI18N
        jMenuItemIF.setText("Insert IF");
        jMenuItemIF.setEnabled(false);
        jMenuItemIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIFActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemIF);
        jMenuEdit.add(jSeparator3);

        jMenuItemClear.setText("Clear all");
        jMenuItemClear.setEnabled(false);
        jMenuItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClearActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemClear);

        jMenuBar1.add(jMenuEdit);

        jMenu4.setText("Simulation");
        jMenu4.setEnabled(false);
        jMenu4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu4);

        jMenuOptions.setText("Options");

        jMenuItemSettings.setText("Settings");
        jMenuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSettingsActionPerformed(evt);
            }
        });
        jMenuOptions.add(jMenuItemSettings);

        jMenuBar1.add(jMenuOptions);

        jMenu5.setText("Window");
        jMenu5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        Cascade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Cascade.setText("Cascade");
        Cascade.setEnabled(false);
        Cascade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CascadeActionPerformed(evt);
            }
        });
        jMenu5.add(Cascade);

        Tile.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Tile.setText("Tile");
        Tile.setEnabled(false);
        Tile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TileActionPerformed(evt);
            }
        });
        jMenu5.add(Tile);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Help");
        jMenu6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        About.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        jMenu6.add(About);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 800, 492);
    }// </editor-fold>//GEN-END:initComponents

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        String title = "New Model " + c; 
        Boolean resizable = true; 
        Boolean closable = true; 
        Boolean maximizable = false; 
        Boolean iconifiable = true; 
        
        jMDIFrame iFrame =  new jMDIFrame(title, resizable, closable,  maximizable, iconifiable,null); 
        iFrame.setPreferredSize(new Dimension(800, 700));
        iFrame.setSize(iFrame.getPreferredSize());
        
        iFrame.setResizable(true);
        iFrame.pack();
        iFrame.setLocation(20*c, 20*c);
     
        
        
        jDesktopPane.add(iFrame);

        iFrame.toFront();
        iFrame.setVisible(true);
        
         Cascade.setEnabled(true);
         Tile.setEnabled(true);
         
        c++;
        

    }//GEN-LAST:event_NewActionPerformed
// /*
    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        
        OpenChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //OpenChooser.setCurrentDirectory(OpenChooser.getCurrentDirectory());
        OpenChooser.setCurrentDirectory(new File("."));
        OpenChooser.setFileFilter(new FileNameExtensionFilter("Event-driven Process Methodology", "epm"));
        int option = OpenChooser.showOpenDialog(this);
        //.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        if(option == JFileChooser.APPROVE_OPTION) {
            
            String title = OpenChooser.getSelectedFile().getName(); 
            String file = OpenChooser.getSelectedFile().getAbsolutePath();
            
            Boolean resizable = true; 
            Boolean closable = true; 
            Boolean maximizable = false; 
            Boolean iconifiable = true; 
        
            jMDIFrame iFrame =  new jMDIFrame(file, resizable, closable,  maximizable, iconifiable,null); 
            iFrame.setPreferredSize(new Dimension(800, 700));
            iFrame.setSize(iFrame.getPreferredSize());
        
            iFrame.setResizable(true);
            iFrame.pack();
            iFrame.setLocation(20*c, 20*c);
        
            jDesktopPane.add(iFrame);

            iFrame.toFront();
            iFrame.setVisible(true);
        
            Cascade.setEnabled(true);
            Tile.setEnabled(true);
         
            c++;
            
            iFrame.LoadFromJSON(file);
            
        }
        
    }//GEN-LAST:event_OpenActionPerformed

    private void SaveasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveasActionPerformed

        // 1. Вытаскиваем имя файла из активного окна
        JInternalFrame iFrame = jDesktopPane.getSelectedFrame();        
        Field field = null;
        try {
            field = iFrame.getClass().getDeclaredField("fileName");
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        field.setAccessible(true);
        
        Object fn = "";
        try {
            fn = field.get(iFrame);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }

        SaveChooser.setDialogTitle("Specify a file to save");// ("+fn+")");
        SaveChooser.setCurrentDirectory(new File("."));
        SaveChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        SaveChooser.setFileFilter(new FileNameExtensionFilter("Event-driven Process Methodology", "epm"));
        SaveChooser.approveSelection();
        int option = SaveChooser.showSaveDialog(iFrame);

        //.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        
        Field field2 = null;
        
        if(option != JFileChooser.CANCEL_OPTION) {
            
            File file1 = SaveChooser.getSelectedFile(); 
            String file = null;
            
            try {
                file = file1.getCanonicalPath();
            } catch (IOException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                field2 = iFrame.getClass().getDeclaredField("fileName");
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            }
            field2.setAccessible(true);
        
            try {
                field2.set(iFrame, file);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            // 3. Вызываем метод сохранения из активного окна            
            try {
                java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("SaveInJSON", String.class);
                method.setAccessible(true);
                method.invoke(iFrame, file);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            iFrame.setTitle(file);
            
            
            // 2. Устанавливаем флаг изменений
            try {
                field2 = iFrame.getClass().getDeclaredField("change_idx");
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            }
            field2.setAccessible(true);
        
            try {
                field2.set(iFrame, false);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } 
            // 2.
               
            // 4. Вызываем метод обновления состояния кнопок
            try {
              java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("ButtonActivated");
              method.setAccessible(true);
              method.invoke(iFrame);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            }
            // 4.
        } else {
            
                        // 2. Устанавливаем флаг изменений
            try {
                field2 = iFrame.getClass().getDeclaredField("change_idx");
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            }
            field2.setAccessible(true);
        
            try {
                field2.set(iFrame, true);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } 
            // 2.
               
            // 4. Вызываем метод обновления состояния кнопок
            try {
              java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("ButtonActivated");
              method.setAccessible(true);
              method.invoke(iFrame);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            }
            // 4.
            
        }
    }//GEN-LAST:event_SaveasActionPerformed

    private void TileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TileActionPerformed
        JInternalFrame allFrames[] = jDesktopPane.getAllFrames();
        //manager.setNormalSize();
        int frameHeight = getBounds().height / allFrames.length;
        int y = 0;
        for (JInternalFrame allFrame : allFrames) {
            allFrame.setSize(getBounds().width, frameHeight);
            allFrame.setLocation(0, y);
            y = y + frameHeight;
        }
    }//GEN-LAST:event_TileActionPerformed

    private void CascadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CascadeActionPerformed
        int x = 0;
        int y = 0;
        JInternalFrame allFrames[] = jDesktopPane.getAllFrames();

        //manager.setNormalSize(); вывод на весь экран
        int frameHeight = (getBounds().height - 5) - allFrames.length * FRAME_OFFSET;
        int frameWidth = (getBounds().width - 5) - allFrames.length * FRAME_OFFSET;
        for (int i = allFrames.length - 1; i >= 0; i--) {
            allFrames[i].setSize(frameWidth, frameHeight);
            allFrames[i].setLocation(x, y);
            x = x + FRAME_OFFSET;
            y = y + FRAME_OFFSET;
        }    
    }//GEN-LAST:event_CascadeActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        Info.showInternalMessageDialog(jDesktopPane, " Event-driven Process Methodology Editor"
                + "\n Version: in dev process"
                + "\n Copyright (C) 2023-24", "About", JOptionPane.INFORMATION_MESSAGE,null);

    }//GEN-LAST:event_AboutActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
    System.exit(0);
    }//GEN-LAST:event_quitActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        
        Dimension frameSize = getSize();
        jDesktopPane.setSize(frameSize);
        
    }//GEN-LAST:event_formComponentResized

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed

        // 1. Вытаскиваем имя файла из активного окна
        JInternalFrame iFrame = jDesktopPane.getSelectedFrame();        
        Field field = null;
        try {
            field = iFrame.getClass().getDeclaredField("fileName");
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        field.setAccessible(true);
        
        Object fn = "";
        try {
            fn = field.get(iFrame);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 1. Конец
        
        // 2. Устанавливаем флаг изменений
        Field field2 = null;
        try {
            field2 = iFrame.getClass().getDeclaredField("change_idx");
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        field2.setAccessible(true);
        
        try {
            field2.set(iFrame, false);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        } 
        // 2.
        
        // 3. Вызываем метод сохранения из активного окна
        if (fn != "") {
            try {
                java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("SaveInJSON", String.class);
                method.setAccessible(true);
                method.invoke(iFrame, fn);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // сохраняем под новым именем т.к. имя еще не задано
            this.SaveasActionPerformed(evt);
        }
        // 3.
        
        // 4. Вызываем метод обновления состояния кнопок
        try {
            java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("ButtonActivated");
            method.setAccessible(true);
            method.invoke(iFrame);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 4.

    }//GEN-LAST:event_SaveActionPerformed

    //Вставляем объект S
    private void jButtonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSActionPerformed
        JInternalFrame iFrame = jDesktopPane.getSelectedFrame();        
        try {
            java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("SActionPerformed", java.awt.event.ActionEvent.class);
            method.setAccessible(true);
            method.invoke(iFrame, evt);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSActionPerformed

    
    //Вставляем объект R
    private void jButtonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRActionPerformed
        JInternalFrame iFrame = jDesktopPane.getSelectedFrame();        
        try {
            java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("RActionPerformed", java.awt.event.ActionEvent.class);
            method.setAccessible(true);
            method.invoke(iFrame, evt);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_jButtonRActionPerformed

    private void jButtonIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIFActionPerformed
        // TODO add your handling code here:
        JInternalFrame iFrame = jDesktopPane.getSelectedFrame();        
        try {
            java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("DActionPerformed", java.awt.event.ActionEvent.class);
            method.setAccessible(true);
            method.invoke(iFrame, evt);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jButtonIFActionPerformed

    private void jButtonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVActionPerformed
        // TODO add your handling code here:
         JInternalFrame iFrame = jDesktopPane.getSelectedFrame();        
        try {
            java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("VActionPerformed", java.awt.event.ActionEvent.class);
            method.setAccessible(true);
            method.invoke(iFrame, evt);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }//GEN-LAST:event_jButtonVActionPerformed

    private void jMenuItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClearActionPerformed
        // TODO add your handling code here:
         JInternalFrame iFrame = jDesktopPane.getSelectedFrame();        
        try {
            java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("clearActionPerformed", java.awt.event.ActionEvent.class);
            method.setAccessible(true);
            method.invoke(iFrame, evt);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }                
        
    }//GEN-LAST:event_jMenuItemClearActionPerformed

    private void jButtonNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNVActionPerformed
        // TODO add your handling code here:
          JInternalFrame iFrame = jDesktopPane.getSelectedFrame();        
        try {
            java.lang.reflect.Method method = iFrame.getClass().getDeclaredMethod("NVActionPerformed", java.awt.event.ActionEvent.class);
            method.setAccessible(true);
            method.invoke(iFrame, evt);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(mdi.class.getName()).log(Level.SEVERE, null, ex);
        }                
         
        
    }//GEN-LAST:event_jButtonNVActionPerformed

    private void jMenuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSettingsActionPerformed
        // TODO add your handling code here:
        jDialog1.setSize(400, 300);
        jDialog1.setLocation((jDesktopPane.getWidth()-jDialog1.getWidth())/2, (jDesktopPane.getHeight()-jDialog1.getHeight())/2);
        jDialog1.setVisible(true);

    }//GEN-LAST:event_jMenuItemSettingsActionPerformed

//    //Начало работы Иванова А.А. настройка цвета
//    //меню настроек
//    private void jMenuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {                                                  
//        jDialog1.setSize(400, 300);
//        jDialog1.setLocation((jDesktopPane.getWidth()-jDialog1.getWidth())/2, (jDesktopPane.getHeight()-jDialog1.getHeight())/2);
//        jDialog1.setVisible(true);
//    }                                                 
//    //изменение цвета
    private void jChangeColorSActionPerformed(java.awt.event.ActionEvent evt) {                                              
        S1.BackgroundColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        jDesktopPane.repaint();
    }                                             

    private void jChangeColorVActionPerformed(java.awt.event.ActionEvent evt) {                                              
        V.BackgroundColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        jDesktopPane.repaint();
    }                                             

    private void jChangeColorNVActionPerformed(java.awt.event.ActionEvent evt) {                                               
        NV.BackgroundColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        jDesktopPane.repaint();
    }                                              

    private void jChangeColorRActionPerformed(java.awt.event.ActionEvent evt) {                                              
        R.BackgroundColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        jDesktopPane.repaint();
    }                                             

    private void jChangeColorIFActionPerformed(java.awt.event.ActionEvent evt) {                                               
        d.BackgroundColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        jDesktopPane.repaint();
    }                                              

    private void jChangeColorGridActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        //grid.Color = selectedColor; //в будущем изменение переменной, отвечающей за цвет сетки
        jDesktopPane.repaint();
    }                                                

    private void jChangeTextColorSActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        S1.TextColor = selectedColor;
        jDesktopPane.repaint();
    }                                                 

    private void jChangeTextColorVActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        V.TextColor = selectedColor;
        jDesktopPane.repaint();
    }                                                 

    private void jChangeTextColorNVActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        NV.TextColor = selectedColor;
        jDesktopPane.repaint();
    }                                                  

    private void jChangeTextColorRActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        R.TextColor = selectedColor;
        jDesktopPane.repaint();
    }                                                 

    private void jChangeTextColorIFActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        d.TextColor = selectedColor;
        jDesktopPane.repaint();
    }                                                  
//Конец работы Иванова А.А.
    
    
    
    public static void main(String args[]) throws Exception{
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenuItem Cascade;
    private javax.swing.JOptionPane Info;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JFileChooser OpenChooser;
    public static javax.swing.JMenuItem Save;
    private javax.swing.JFileChooser SaveChooser;
    public static javax.swing.JMenuItem Saveas;
    private javax.swing.JMenuItem Tile;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    public static javax.swing.JButton jButtonIF;
    public static javax.swing.JButton jButtonNV;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonOpen;
    public static javax.swing.JButton jButtonR;
    private javax.swing.JButton jButtonRun;
    public static javax.swing.JButton jButtonS;
    public static javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonStep;
    public static javax.swing.JButton jButtonV;
    private javax.swing.JButton jChangeColorGrid;
    private javax.swing.JButton jChangeColorIF;
    private javax.swing.JButton jChangeColorNV;
    private javax.swing.JButton jChangeColorR;
    private javax.swing.JButton jChangeColorS;
    private javax.swing.JButton jChangeColorV;
    private javax.swing.JButton jChangeTextColorIF;
    private javax.swing.JButton jChangeTextColorNV;
    private javax.swing.JButton jChangeTextColorR;
    private javax.swing.JButton jChangeTextColorS;
    private javax.swing.JButton jChangeTextColorV;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    public static javax.swing.JMenuItem jMenuItemClear;
    public static javax.swing.JMenuItem jMenuItemIF;
    public static javax.swing.JMenuItem jMenuItemNV;
    public static javax.swing.JMenuItem jMenuItemR;
    public static javax.swing.JMenuItem jMenuItemS;
    private javax.swing.JMenuItem jMenuItemSettings;
    public static javax.swing.JMenuItem jMenuItemV;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem quit;
    // End of variables declaration//GEN-END:variables
    
    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }
        
//        DatabaseHandler dbHandler = new DatabaseHandler();

        @Override
        public void run() {
            
            new mdi().setVisible(true);
        }
    }
}


