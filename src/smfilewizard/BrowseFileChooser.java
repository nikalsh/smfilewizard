package smfilewizard;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BrowseFileChooser extends JPanel implements ActionListener {
   JButton go;
   JFileChooser chooser;
   String choosertitle;

  public BrowseFileChooser(String btext) {
    go = new JButton(btext);
    go.addActionListener(this);
    add(go);
   }
  public BrowseFileChooser() {
    go = new JButton();
    go.addActionListener(this);
    add(go);
   }

  public void actionPerformed(ActionEvent e) {            
    chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    //    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      System.out.println("getCurrentDirectory(): " 
         +  chooser.getCurrentDirectory());
      System.out.println("getSelectedFile() : " 
         +  chooser.getSelectedFile());
      }
    else {
      System.out.println("No Selection ");
      }
     }

  public Dimension getPreferredSize(){
    return new Dimension(50, 50);
    }
}
