package EPM;

//import com.tomtessier.scrollabledesktop.JScrollableDesktopPane;
import com.sun.jdi.Method;
import figure.figures;
import figure.NV;
import figure.R;
import figure.V;
import figure.S1;
//import figure.b;
import figure.d;
import jMDIForm.GridPanel;
import jMDIForm.jMDIFrame;
import java.awt.Color;
import javax.swing.JColorChooser;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
////import com.mycompany.mdi.groupJDBC.artifactJDBC.*;
//import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleValue;
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
        
        if (!GridPanel.prefs.getBoolean("isVisible", true)) {
            GridPanel.color = new Color (240, 240, 240);
            jChangeColorGrid.setEnabled(false);
        }
        
    }
    //часть для вырезки, вставки, копирования и удаления
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OpenChooser = new javax.swing.JFileChooser();
        SaveChooser = new javax.swing.JFileChooser();
        Info = new javax.swing.JOptionPane();
        jDialogSettings = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSTextColor = new javax.swing.JPanel();
        jVTextColor = new javax.swing.JPanel();
        jNVTextColor = new javax.swing.JPanel();
        jRTextColor = new javax.swing.JPanel();
        jIFTextColor = new javax.swing.JPanel();
        jChangeTextColorS = new javax.swing.JButton();
        jChangeTextColorV = new javax.swing.JButton();
        jChangeTextColorNV = new javax.swing.JButton();
        jChangeTextColorR = new javax.swing.JButton();
        jChangeTextColorIF = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSColor = new javax.swing.JPanel();
        jVColor = new javax.swing.JPanel();
        jNVColor = new javax.swing.JPanel();
        jRColor = new javax.swing.JPanel();
        jIFColor = new javax.swing.JPanel();
        jChangeColorS = new javax.swing.JButton();
        jChangeColorV = new javax.swing.JButton();
        jChangeColorNV = new javax.swing.JButton();
        jChangeColorR = new javax.swing.JButton();
        jChangeColorIF = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jGridColor = new javax.swing.JPanel();
        jChangeColorGrid = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jColorChooser1 = new javax.swing.JColorChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jMenuItemColorSettings = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Cascade = new javax.swing.JMenuItem();
        Tile = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        Info.setMessage("That's our programm. First versoin.");
        Info.setToolTipText("");
        Info.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jDialogSettings.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        jDialogSettings.setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape line"));
        jPanel2.setPreferredSize(new java.awt.Dimension(170, 170));

        jSTextColor.setBackground(S1.TextColor);
        jSTextColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSTextColor.setMaximumSize(new java.awt.Dimension(10, 10));
        jSTextColor.setPreferredSize(new java.awt.Dimension(25, 25));
        jSTextColor.setRequestFocusEnabled(false);
        jSTextColor.setSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout jSTextColorLayout = new javax.swing.GroupLayout(jSTextColor);
        jSTextColor.setLayout(jSTextColorLayout);
        jSTextColorLayout.setHorizontalGroup(
            jSTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jSTextColorLayout.setVerticalGroup(
            jSTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jVTextColor.setBackground(V.TextColor);
        jVTextColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jVTextColor.setBounds(new java.awt.Rectangle(0, 0, 10, 10));
        jVTextColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jVTextColorLayout = new javax.swing.GroupLayout(jVTextColor);
        jVTextColor.setLayout(jVTextColorLayout);
        jVTextColorLayout.setHorizontalGroup(
            jVTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jVTextColorLayout.setVerticalGroup(
            jVTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jNVTextColor.setBackground(NV.TextColor);
        jNVTextColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jNVTextColor.setBounds(new java.awt.Rectangle(0, 0, 10, 10));
        jNVTextColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jNVTextColorLayout = new javax.swing.GroupLayout(jNVTextColor);
        jNVTextColor.setLayout(jNVTextColorLayout);
        jNVTextColorLayout.setHorizontalGroup(
            jNVTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jNVTextColorLayout.setVerticalGroup(
            jNVTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jRTextColor.setBackground(R.TextColor);
        jRTextColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jRTextColor.setBounds(new java.awt.Rectangle(0, 0, 10, 10));
        jRTextColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jRTextColorLayout = new javax.swing.GroupLayout(jRTextColor);
        jRTextColor.setLayout(jRTextColorLayout);
        jRTextColorLayout.setHorizontalGroup(
            jRTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jRTextColorLayout.setVerticalGroup(
            jRTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jIFTextColor.setBackground(d.TextColor);
        jIFTextColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jIFTextColor.setBounds(new java.awt.Rectangle(0, 0, 10, 10));
        jIFTextColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jIFTextColorLayout = new javax.swing.GroupLayout(jIFTextColor);
        jIFTextColor.setLayout(jIFTextColorLayout);
        jIFTextColorLayout.setHorizontalGroup(
            jIFTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jIFTextColorLayout.setVerticalGroup(
            jIFTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jChangeTextColorS.setText("S");
        jChangeTextColorS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeTextColorSActionPerformed(evt);
            }
        });

        jChangeTextColorV.setText("V");
        jChangeTextColorV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeTextColorVActionPerformed(evt);
            }
        });

        jChangeTextColorNV.setText("NV");
        jChangeTextColorNV.setPreferredSize(new java.awt.Dimension(23, 23));
        jChangeTextColorNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeTextColorNVActionPerformed(evt);
            }
        });

        jChangeTextColorR.setText("R");
        jChangeTextColorR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeTextColorRActionPerformed(evt);
            }
        });

        jChangeTextColorIF.setText("IF");
        jChangeTextColorIF.setPreferredSize(new java.awt.Dimension(23, 23));
        jChangeTextColorIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeTextColorIFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jNVTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeTextColorNV, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeTextColorR, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jIFTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeTextColorIF, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeTextColorS, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jVTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeTextColorV, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeTextColorS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jVTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeTextColorV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNVTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeTextColorNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeTextColorR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIFTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeTextColorIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape filling"));

        jSColor.setBackground(S1.BackgroundColor);
        jSColor.setBackground(S1.BackgroundColor);
        jSColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jSColorLayout = new javax.swing.GroupLayout(jSColor);
        jSColor.setLayout(jSColorLayout);
        jSColorLayout.setHorizontalGroup(
            jSColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jSColorLayout.setVerticalGroup(
            jSColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jVColor.setBackground(V.BackgroundColor);
        jVColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jVColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jVColorLayout = new javax.swing.GroupLayout(jVColor);
        jVColor.setLayout(jVColorLayout);
        jVColorLayout.setHorizontalGroup(
            jVColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jVColorLayout.setVerticalGroup(
            jVColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jNVColor.setBackground(NV.BackgroundColor);
        jNVColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jNVColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jNVColorLayout = new javax.swing.GroupLayout(jNVColor);
        jNVColor.setLayout(jNVColorLayout);
        jNVColorLayout.setHorizontalGroup(
            jNVColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jNVColorLayout.setVerticalGroup(
            jNVColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jRColor.setBackground(R.BackgroundColor);
        jRColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jRColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jRColorLayout = new javax.swing.GroupLayout(jRColor);
        jRColor.setLayout(jRColorLayout);
        jRColorLayout.setHorizontalGroup(
            jRColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jRColorLayout.setVerticalGroup(
            jRColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jIFColor.setBackground(d.BackgroundColor);
        jIFColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jIFColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jIFColorLayout = new javax.swing.GroupLayout(jIFColor);
        jIFColor.setLayout(jIFColorLayout);
        jIFColorLayout.setHorizontalGroup(
            jIFColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jIFColorLayout.setVerticalGroup(
            jIFColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jChangeColorS.setText("S");
        jChangeColorS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeColorSActionPerformed(evt);
            }
        });

        jChangeColorV.setText("V");
        jChangeColorV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeColorVActionPerformed(evt);
            }
        });

        jChangeColorNV.setText("NV");
        jChangeColorNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeColorNVActionPerformed(evt);
            }
        });

        jChangeColorR.setText("R");
        jChangeColorR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeColorRActionPerformed(evt);
            }
        });

        jChangeColorIF.setText("IF");
        jChangeColorIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeColorIFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeColorS, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jVColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeColorV, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeColorR, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jNVColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeColorNV, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jIFColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChangeColorIF, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSColor, 24, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeColorS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jVColor, 24, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeColorV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNVColor, 24, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeColorNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRColor, 24, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeColorR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIFColor, 24, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeColorIF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Grid"));

        jGridColor.setBackground(GridPanel.color);
        jGridColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jGridColor.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jGridColorLayout = new javax.swing.GroupLayout(jGridColor);
        jGridColor.setLayout(jGridColorLayout);
        jGridColorLayout.setHorizontalGroup(
            jGridColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jGridColorLayout.setVerticalGroup(
            jGridColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jChangeColorGrid.setText("Color");
        jChangeColorGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeColorGridActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Show grid");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addGap(39, 39, 39)
                .addComponent(jGridColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jChangeColorGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jChangeColorGrid)
                    .addComponent(jGridColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogSettingsLayout = new javax.swing.GroupLayout(jDialogSettings.getContentPane());
        jDialogSettings.getContentPane().setLayout(jDialogSettingsLayout);
        jDialogSettingsLayout.setHorizontalGroup(
            jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialogSettingsLayout.setVerticalGroup(
            jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSettingsLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton10.setText("jButton10");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(1, 1));

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

        jMenuItemColorSettings.setText("Settings ...");
        jMenuItemColorSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemColorSettingsActionPerformed(evt);
            }
        });
        jMenuOptions.add(jMenuItemColorSettings);

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
            // 2. 
            // 2. 
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
            // 4.
            // 4.
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
            // 2. 
            // 2. 
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
            // 4.
            // 4.
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
        Info.showInternalMessageDialog(jDesktopPane, " Event-driven Process Methodology Modeller"
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
        // 1. Конец
        // 1. Конец
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
        // 2. 
        // 2. 
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
        // 4.
        // 4.
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
//Начало работы Иванова А.А. настройка цвета
    //меню настроек
    private void jMenuItemColorSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemColorSettingsActionPerformed
        //jDesktopPane.repaint();
        jDialogSettings.setSize(290, 360);
        jDialogSettings.setTitle("Settings");
        jDialogSettings.setLocation((jDesktopPane.getWidth()-jDialogSettings.getWidth())/2, (jDesktopPane.getHeight()-jDialogSettings.getHeight())/2);
        
        if (GridPanel.isVisible) {
          jCheckBox1.setSelected(true);   
        } else {
          jCheckBox1.setSelected(false); 
        }
        
        jDialogSettings.setVisible(true);
    }//GEN-LAST:event_jMenuItemColorSettingsActionPerformed

    Color gridColor = GridPanel.color;
    private void jChangeColorIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeColorIFActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Pick color", Color.BLACK);
        d.BackgroundColor = selectedColor;
        jIFColor.setBackground(selectedColor);
        //jIFColor.setBackground(d.BackgroundColor);
        //figures.prefs.putInt("IFBackgroundColor", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeColorIFActionPerformed

    private void jChangeColorRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeColorRActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Pick color", Color.BLACK);
        R.BackgroundColor = selectedColor;
        jRColor.setBackground(selectedColor);
        //jRColor.setBackground(R.BackgroundColor);
        //figures.prefs.putInt("RBackgroundColor", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeColorRActionPerformed

    private void jChangeColorNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeColorNVActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Pick color", Color.BLACK);
        NV.BackgroundColor = selectedColor;
        jNVColor.setBackground(selectedColor);
        //jNVColor.setBackground(NV.BackgroundColor);
        //NV.prefs.putInt("BackgroundColor", selectedColor.getRGB());
        //figures.prefs.putInt("NVBackgroundColor", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeColorNVActionPerformed

    private void jChangeColorVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeColorVActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Pick color", Color.BLACK);
        V.BackgroundColor = selectedColor;
        jVColor.setBackground(selectedColor);
        //jVColor.setBackground(V.BackgroundColor);
        //figures.prefs.putInt("VBackgroundColor", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeColorVActionPerformed

   // private void jChangeColorSActionPerformed(java.awt.event.ActionEvent evt) {                                              
   //     Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
   //     S.BackgroundColor = selectedColor;
   //     jSColor.setBackground(selectedColor);
        //jDesktopPane.repaint();
   // }                                             
    private void jChangeColorGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeColorGridActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Pick color", Color.BLACK);
        GridPanel.color = selectedColor;
        jGridColor.setBackground(selectedColor);
        //GridPanel.prefs.putInt("color", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeColorGridActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jDialogSettings.setVisible(false);        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jDialogSettings.setVisible(false); 
        jDesktopPane.repaint();
        
        if (GridPanel.isVisible == true)
            GridPanel.prefs.putInt("color", GridPanel.color.getRGB());
        GridPanel.prefs.putBoolean("isVisible", GridPanel.isVisible);
        
        figures.prefs.putInt("IFBackgroundColor", d.BackgroundColor.getRGB());
        figures.prefs.putInt("IFTextColor", d.TextColor.getRGB());
        figures.prefs.putInt("S1BackgroundColor", S1.BackgroundColor.getRGB());
        figures.prefs.putInt("S1TextColor", S1.TextColor.getRGB());
        figures.prefs.putInt("VBackgroundColor", V.BackgroundColor.getRGB());
        figures.prefs.putInt("VTextColor", V.TextColor.getRGB());
        figures.prefs.putInt("NVBackgroundColor", NV.BackgroundColor.getRGB());
        figures.prefs.putInt("NVTextColor", NV.TextColor.getRGB());
        figures.prefs.putInt("RBackgroundColor", R.BackgroundColor.getRGB());
        figures.prefs.putInt("RTextColor", R.TextColor.getRGB());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

            if (jCheckBox1.isSelected()) {
                GridPanel.isVisible = true;
                //GridPanel.prefs.putBoolean("isVisible", true);
                GridPanel.color = new Color(GridPanel.prefs.getInt("color", Color.GRAY.getRGB()));
                jChangeColorGrid.setEnabled(true);                
            } else {
                GridPanel.isVisible = false;      
                //GridPanel.prefs.putBoolean("isVisible", false);
                gridColor = GridPanel.color;
                GridPanel.color = jDesktopPane.getSelectedFrame().getBackground();
                jChangeColorGrid.setEnabled(false);
            }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jChangeColorSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeColorSActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        S1.BackgroundColor = selectedColor;
        jSColor.setBackground(selectedColor);
        //figures.prefs.putInt("S1BackgroundColor", selectedColor.getRGB());  
 
       // TODO add your handling code here:
    }//GEN-LAST:event_jChangeColorSActionPerformed

    private void jChangeTextColorSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeTextColorSActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        S1.TextColor = selectedColor;
        jSTextColor.setBackground(selectedColor);
        //figures.prefs.putInt("S1TextColor", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeTextColorSActionPerformed

    private void jChangeTextColorVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeTextColorVActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        V.TextColor = selectedColor;
        jVTextColor.setBackground(selectedColor);
        //figures.prefs.putInt("VTextColor", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeTextColorVActionPerformed

    private void jChangeTextColorNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeTextColorNVActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        NV.TextColor = selectedColor;
        jNVTextColor.setBackground(selectedColor);
        //figures.prefs.putInt("NVTextColor", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeTextColorNVActionPerformed

    private void jChangeTextColorRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeTextColorRActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        R.TextColor = selectedColor;
        jRTextColor.setBackground(selectedColor);
        //figures.prefs.putInt("RTextColor", selectedColor.getRGB());
        //jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeTextColorRActionPerformed

    private void jChangeTextColorIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeTextColorIFActionPerformed
        Color selectedColor = jColorChooser1.showDialog(this, "Выберите цвет", Color.BLACK);
        d.TextColor = selectedColor;
        jIFTextColor.setBackground(selectedColor);
        //figures.prefs.putInt("IFTextColor", selectedColor.getRGB());
        // jDesktopPane.repaint();
    }//GEN-LAST:event_jChangeTextColorIFActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JDialog jDialogSettings;
    private javax.swing.JPanel jGridColor;
    private javax.swing.JPanel jIFColor;
    private javax.swing.JPanel jIFTextColor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    public static javax.swing.JMenuItem jMenuItemClear;
    public static javax.swing.JMenuItem jMenuItemColorSettings;
    public static javax.swing.JMenuItem jMenuItemIF;
    public static javax.swing.JMenuItem jMenuItemNV;
    public static javax.swing.JMenuItem jMenuItemR;
    public static javax.swing.JMenuItem jMenuItemS;
    public static javax.swing.JMenuItem jMenuItemV;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JPanel jNVColor;
    private javax.swing.JPanel jNVTextColor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jRColor;
    private javax.swing.JPanel jRTextColor;
    private javax.swing.JPanel jSColor;
    private javax.swing.JPanel jSTextColor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel jVColor;
    private javax.swing.JPanel jVTextColor;
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


