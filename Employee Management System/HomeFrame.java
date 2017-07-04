import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mu.*;

public class HomeFrame extends JFrame
{

JPanel jp;
JButton add,modify,delete,view;

public HomeFrame()
{

super("Employee Records Management");
setSize(400,200);
setResizable(false);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

jp=new JPanel();
jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

add=new JButton("Add");
modify=new JButton("Modify");
delete=new JButton("Delete");
view=new JButton("View");


jp.add(add);
jp.add(modify);
jp.add(delete);
jp.add(view);
add(jp);

setLocationRelativeTo(null);
setVisible(true);


addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
int output=JOptionPane.showConfirmDialog(new JDialog(),"Do you want to exit");
if(output==JOptionPane.YES_OPTION)
{
System.exit(1);
}

}
});


//control goes from one window to another window

add.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){

AddFrame a = new AddFrame();
dispose();

}
});

modify.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){

UpdateFrame a = new UpdateFrame();
dispose();

}
});


delete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){

DeleteFrame a = new DeleteFrame();
dispose();

}
});


view.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){

ViewFrame a = new ViewFrame();
dispose();

}
});


}//constructor endsss



public static void main(String args[])
{


HomeFrame h= new HomeFrame();
}
}








