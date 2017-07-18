
package smfilewizard;

import java.io.*;
import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class SMWizard {
    public static void main(String[] args) throws IOException {    

JTextField field1 = new JTextField();
JTextField field2 = new JTextField();
JTextField field3 = new JTextField();
JTextField field4 = new JTextField();
JTextField field5 = new JTextField();
JTextField field6 = new JTextField();
JTextField field7 = new JTextField();
JTextField field8 = new JTextField();
JTextField field9 = new JTextField();
JTextField field10 = new JTextField();
JTextField field11 = new JTextField();
BrowseFileChooser field12 = new BrowseFileChooser("Browse");
JTextField field13 = new JTextField();
JTextField field14 = new JTextField();
JTextField field15 = new JTextField();
JTextField field16 = new JTextField("YES");
JTextField field17 = new JTextField("100.000");
JTextField field18 = new JTextField();
JTextField field19 = new JTextField();
JTextField field20 = new JTextField();

Object[] message = {
    "(*)#TITLE:", field1,
    "#SUBTITLE:", field2,
    "(*)#ARTIST:", field3,
    "#TITLETRANSLIT:", field4,
    "#SUBTITLETRANSLIT:", field5,
    "#ARTISTTRANSLIT:", field6,
    "#CREDIT:", field7,
    "#BANNER:", field8,
    "#BACKGROUND:", field9,
    "#LYRICSPATH:", field10,
    "#CDTITLE:", field11,
    "#MUSIC:", field12,
    "#OFFSET:", field13,
    "#SAMPLESTART:", field14,
    "#SAMPLELENGTH:", field15,
    "#SELECTABLE:", field16,
    "#BPMS:0.000=", field17,
    "#STOPS:", field18,
    "#BGCHANGES:", field19,
    "#NOTES:", field20
};
boolean Done = false;
JFileChooser chooser = new JFileChooser();

//        chooser.setApproveButtonText("APPROVE");
        chooser.setDialogTitle("Select your StepMania/Songs/[Group] folder");
        chooser.setCurrentDirectory(new File("C:/"));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("No directory chosen");
            System.exit(0);
        }
        System.out.println(chooser.getSelectedFile());
        
int option = JOptionPane.showConfirmDialog(null, message, "SMFile Wizard", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

if (option == JOptionPane.OK_OPTION && Done == true)
{   
    //<editor-fold defaultstate="collapsed" desc="array">
    String[] value = new String[20];
    value[0] = "#TITLE:" + field1.getText()+ ";";
    value[1] = "#SUBTITLE:" + field2.getText() + ";";
    value[2] = "#ARTIST:" + field3.getText() + ";";
    value[3] = "#TITLETRANSLIT:" + field4.getText() + ";";
    value[4] = "#SUBTITLETRANSLIT:" + field5.getText() + ";";
    value[5] = "#ARTISTTRANSLIT:" + field6.getText() + ";";
    value[6] = "#CREDIT:" + field7.getText() + ";";
    value[7] = "#BANNER:" + field8.getText() + ";";
    value[8] =  "#BACKGROUND:" + field9.getText() + ";";
    value[9] = "#LYRICSPATH:" + field10.getText() + ";";
    value[10] = "#CDTITLE:" + field11.getText() + ";";
    value[11] = "#MUSIC:" + field12.chooser.getDescription(field12.chooser.getSelectedFile()) + ";";
    value[12] = "#OFFSET:" + field13.getText() + ";";
    value[13] = "#SAMPLESTART:" + field14.getText() + ";";
    value[14] = "#SAMPLELENGTH:" + field15.getText() + ";";
    value[15] = "#SELECTABLE:" + field16.getText() + ";";
    value[16] = "#BPMS:0.000=" + field17.getText() + ";";
    value[17] = "#STOPS:" + field18.getText() + ";";
    value[18] = "#BGCHANGES:" + field19.getText() + ";";
    value[19] = "#NOTES:" + field20.getText() + ";";
    //</editor-fold>
    
    File smdir = new File (chooser.getSelectedFile()+"\\"+field3.getText()+" - "+field1.getText());
    smdir.mkdirs();
    File sm = new File (smdir +"\\"+ field1.getText()+".sm");
    
    //<editor-fold defaultstate="collapsed" desc="create file">
    if (sm.createNewFile()){
        System.out.println("File created.");
    }
    else{
        System.out.println("Failed to create file.");
    }
    //</editor-fold>

    System.out.println(sm);
    
    PrintWriter output = new PrintWriter
                            (new BufferedWriter
                            (new OutputStreamWriter                               
                            (new FileOutputStream(sm, true), "UTF-8")));
    
    for (int i = 0; i <= 19; i++){
        System.out.println(value[i]);
        output.println(value[i]);
        output.flush();
        }
    output.close();
   
    
    File mp3file = field12.chooser.getSelectedFile();    
    Path mp3FROM = mp3file.toPath();
    Path mp3TO = smdir.toPath(); 
    System.out.println("FROM: "+mp3FROM+" TO: "+mp3TO); 
//    Files.copy(sourcePath, targetPath.resolve(basePath.relativize(sourcePath));
    try{
    Files.copy(mp3FROM, mp3TO.resolve(mp3FROM.getFileName()), StandardCopyOption.REPLACE_EXISTING);
    }
    catch(IOException e){
        e.printStackTrace();
    }

    }
    }   
}