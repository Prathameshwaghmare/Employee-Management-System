import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mu.*;


class UpdateFrame extends JFrame
{
JPanel jp1,jp2;
JLabel id,name;
JTextField tid,tname; 
JButton update,back;





public UpdateFrame()
{

super("Update Employees");
setSize(400,200);
setResizable(false);

jp1= new JPanel();
jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

update=new JButton("Update");
back=new JButton("Back");
id=new JLabel("Id");
name=new JLabel("Name");
tid=new JTextField(5);
tname=new JTextField(10);

jp1.add(id);
jp1.add(tid);
jp1.add(name);
jp1.add(tname);
add(jp1);

jp2=new JPanel();
jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

jp2.add(update);
jp2.add(back);

add(jp2,BorderLayout.SOUTH);
setLocationRelativeTo(null);
setVisible(true);




//if we close this window Control goes to homeframe window...

addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent we){

HomeFrame h = new HomeFrame();

}});






//eventHandling 

back.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent ae){

HomeFrame a= new HomeFrame();
dispose();

}});












update.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent ae){


DatabaseHandler db = new DatabaseHandler();

String id= tid.getText();
String name=tname.getText();


if(id.length()==0|name.length()==0)
{
Sound.allfieldsmandatory();
JOptionPane.showMessageDialog(new JDialog(),"All fields are mandatory");
return;
}

name = tname.getText();
if (!name.matches("[a-zA-Z_]+")) {
         Sound.validname();
    JOptionPane.showMessageDialog(jp1,"Please enter valid name");
 	    tname.setText("");
    	    tname.requestFocus();
}



id = tid.getText();
if (!id.matches("[0-9]+")) {
       Sound.validnumber();
    JOptionPane.showMessageDialog(jp1,"Please enter valid number");
	    tid.setText("");
            tid.requestFocus();

}

if(id.matches("[0-9]+")&(name.matches("[a-zA-Z_]+")))
{
    if(db.checkExists(Integer.parseInt(id))){

db.update(Integer.parseInt(id),name);
tid.setText("");
tname.setText("");
    }

else{
               Sound.recordnotfound();
          JOptionPane.showMessageDialog(jp1,"Record does not EXISTS");

			  		tid.setText("");
 					tname.setText("");
		         		tid.requestFocus();
					tname.requestFocus();
}
    

}

}});


} //end of constructor





}