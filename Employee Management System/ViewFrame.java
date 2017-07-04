import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
JTextArea ta;
JScrollPane sp1;
public ViewFrame()
{

super("View All Employees");
setSize(400,200);
setResizable(false);

ta=new JTextArea(10,10);
ta.setEditable(false);

sp1=new JScrollPane(ta);
sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

add(sp1);

DatabaseHandler qe= new DatabaseHandler();
String s= qe.query();
ta.setText(s);

setLocationRelativeTo(null);
setVisible(true);

//if we close window homeframe window will open

addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent we){

HomeFrame h = new HomeFrame();

}});



}

}