//package JGraphFrame;
//
//import jMDIForm.DrawComp;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.geom.Line2D;
//import java.io.BufferedReader;
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.InputStreamReader;
//import java.util.Random;
//import java.util.Scanner;
//import javax.swing.JComponent;
//import javax.swing.JPanel;
//import javax.swing.JScrollBar;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.text.BadLocationException;
//import javax.swing.text.DefaultHighlighter;
//import javax.swing.text.Highlighter;
//
//
//public class JGraphFrame extends javax.swing.JPanel {
//
//    public JGraphFrame(){
//        //initComponents()
//        super();
//    }
//
//    public void paint(Graphics g){
//        //super();
//        //
//        //Graphics  g = jScrollGraphPane.getGraphics();
//
//        g.setColor(Color.CYAN);
//        g.fillRect(0,0,640,480);
//        g.setColor(Color.RED);
//        g.drawRect(0,0,640,480);
//        g.setColor(Color.BLACK);
//        g.drawLine(50,400,600,400);
//        //g.draw(Some Component);
//        //jScrollGraphPane.paint(g);
//    }
//
//}
//
//
//public class GraphViz
//{
//   /**
//    * The dir. where temporary files will be created.
//    */
//   //private static String TEMP_DIR = "/tmp"; // Linux
//   private static String TEMP_DIR = "c:/temp"; // Windows
//
///**
//    * Where is your dot program located? It will be called externally.
//    */
//  // private static String DOT = "/usr/bin/dot"; // Linux
//   private static String DOT = "D:\\Program Files\\Graphviz2.30\\bin\\dot.exe"; // Windows
//
///**
//    * The source of the graph written in dot language.
//    */
// private StringBuilder graph = new StringBuilder();
//
///**
//    * Constructor: creates a new GraphViz object that will contain
//    * a graph.
//    */
//   public GraphViz() {
//   }
//
///**
//    * Returns the graph's source description in dot language.
//    * @return Source of the graph in dot language.
//    */
//   public String getDotSource() {
//      return graph.toString();
//   }
//
///**
//    * Adds a string to the graph's source (without newline).
//    */
//   public void add(String line) {
//      graph.append(line);
//   }
//
///**
//    * Adds a string to the graph's source (with newline).
//    */
//   public void addln(String line) {
//      graph.append(line + "\n");
//   }
//
///**
//    * Adds a newline to the graph's source.
//    */
//   public void addln() {
//      graph.append('\n');
//   }
//
///**
//    * Returns the graph as an image in binary format.
//    * @param dot_source Source of the graph to be drawn.
//    * @param type Type of the output image to be produced, e.g.: gif, dot, fig, pdf, ps, svg, png.
//    * @return A byte array containing the image of the graph.
//    */
//   public byte[] getGraph(String dot_source, String type)
//   {
//      File dot;
//      byte[] img_stream = null;
//
//      try {
//         dot = writeDotSourceToFile(dot_source);
//         if (dot != null)
//         {
//            img_stream = get_img_stream(dot, type);
//            if (dot.delete() == false)
//               System.err.println("Warning: " + dot.getAbsolutePath() + " could not be deleted!");
//            return img_stream;
//         }
//         return null;
//      } catch (java.io.IOException ioe) { return null; }
//   }
//
///**
//    * Writes the graph's image in a file.
//    * @param img   A byte array containing the image of the graph.
//    * @param file  Name of the file to where we want to write.
//    * @return Success: 1, Failure: -1
//    */
//   public int writeGraphToFile(byte[] img, String file)
//   {
//      File to = new File(file);
//      return writeGraphToFile(img, to);
//   }
//
///**
//    * Writes the graph's image in a file.
//    * @param img   A byte array containing the image of the graph.
//    * @param to    A File object to where we want to write.
//    * @return Success: 1, Failure: -1
//    */
//   public int writeGraphToFile(byte[] img, File to)
//   {
//      try {
//         FileOutputStream fos = new FileOutputStream(to);
//         fos.write(img);
//         fos.close();
//      } catch (java.io.IOException ioe) { ioe.printStackTrace();return -1; }
//      return 1;
//   }
//
///**
//    * It will call the external dot program, and return the image in
//    * binary format.
//    * @param dot Source of the graph (in dot language).
//    * @param type Type of the output image to be produced, e.g.: gif, dot, fig, pdf, ps, svg, png.
//    * @return The image of the graph in .gif format.
//    */
//   private byte[] get_img_stream(File dot, String type)
//   {
//      File img;
//      byte[] img_stream = null;
//
//try {
//         img = File.createTempFile("graph_", "."+type, new File(GraphViz.TEMP_DIR));
//         Runtime rt = Runtime.getRuntime();
//
//         // patch by Mike Chenault
//         String[] args = {DOT, "-T"+type, dot.getAbsolutePath(), "-o", img.getAbsolutePath()};
//         Process p = rt.exec(args);
//
//         p.waitFor();
//
//FileInputStream in = new FileInputStream(img.getAbsolutePath());
//         img_stream = new byte[in.available()];
//         in.read(img_stream);
//         // Close it if we need to
//         if( in != null ) in.close();
//
//if (img.delete() == false)
//            System.err.println("Warning: " + img.getAbsolutePath() + " could not be deleted!");
//      }
//      catch (java.io.IOException ioe) {
//         System.err.println("Error:    in I/O processing of tempfile in dir " + GraphViz.TEMP_DIR+"\n");
//         System.err.println("       or in calling external command");
//         ioe.printStackTrace();
//      }
//      catch (java.lang.InterruptedException ie) {
//         System.err.println("Error: the execution of the external program was interrupted");
//         ie.printStackTrace();
//      }
//
//return img_stream;   }
//   /**
//    * Writes the source of the graph in a file, and returns the written file
//    * as a File object.
//    * @param str Source of the graph (in dot language).
//    * @return The file (as a File object) that contains the source of the graph.
//    */
//   public File writeDotSourceToFile(String str) throws java.io.IOException
//   {
//      File temp;
//      try {
//         temp = File.createTempFile("graph_", ".dot.tmp", new File(GraphViz.TEMP_DIR));
//         FileWriter fout = new FileWriter(temp);
//         fout.write(str);
//         fout.close();
//      }
//      catch (Exception e) {
//         System.err.println("Error: I/O error while writing the dot source to temp file!");
//         return null;
//      }
//      return temp;
//   }
//
///**
//    * Returns a string that is used to start a graph.
//    * @return A string to open a graph.
//    */
//   public String start_graph() {
//      return "digraph G {" ;
//   }
//
///**
//    * Returns a string that is used to end a graph.
//    * @return A string to close a graph.
//    */
//   public String end_graph() {
//      return "}";
//   }
//
///**
//    * Read a DOT graph from a text file.
//    *
//    * @param input Input text file containing the DOT graph
//    * source.
//    */
//   public void readSource(String input)
//   {
//    StringBuilder sb = new StringBuilder();
//
//    try
//    {
//     FileInputStream fis = new FileInputStream(input);
//     DataInputStream dis = new DataInputStream(fis);
//     BufferedReader br = new BufferedReader(new InputStreamReader(dis));
//     String line;
//     while ((line = br.readLine()) != null) {
//      sb.append(line);
//     }
//     dis.close();
//    }
//    catch (Exception e) {
//     System.err.println("Error: " + e.getMessage());
//    }
//
//    this.graph = sb;
//   }
//
//} // end of class GraphViz
//
//public class DrawComp extends JComponent {
//
//    public void paintComponent(Graphics g){
//        Graphics2D g2 = (Graphics2D)g;
//
//        Random ran = new Random();
//        int ranNum = ran.nextInt(10);
//        System.out.println(ranNum);
//        double length = 100 * ranNum;
//        g2.draw(new Line2D.Double(10, 10, length, length));
//    }
//}