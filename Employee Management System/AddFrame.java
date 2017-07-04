import mu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



class AddFrame extends JFrame
{
JPanel jp1,jp2;
JLabel id,name;
JTextField tid,tname; 
JButton add,back;






public AddFrame()
{

super("Add Employees");
setSize(400,200);
setResizable(false);

jp1= new JPanel();
jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

add=new JButton("Add");
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

jp2.add(add);
jp2.add(back);

add(jp2,BorderLayout.SOUTH);
setLocationRelativeTo(null);
setVisible(true);

//if we close window homeframe window will open

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



add.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent ae){

DatabaseHandler db = new DatabaseHandler();

String id= tid.getText().trim();

String name = tname.getText().trim();


/*
if(id.length()!=0 && name.length()!=0)
{
       if(id.matches("[0-9]+"))
	{
           if(name.matches("[a-z A-Z]+"))
			{
			DatabaseHandler db = new DatabaseHandler();
       			db.insert(Integer.parseInt(id),name);

			}  
			 else
			   {
                           		JOptionPane.showMessageDialog(jp1,"Name Must Contain Alphabets only");
					   tname.setText("");
				           tname.requestFocus();
			   }
	}
	   else
		
  		{
                  JOptionPane.showMessageDialog(jp1,"ID Must Contain Digits only");
						    tid.setText("");
					            tid.requestFocus();
		}
	    
 }else
	
	{
	JOptionPane.showMessageDialog(jp1,"All FIELDS are MANDATORY");		
	}		   
 


*/


if(id.length()==0|name.length()==0)
{


Sound.allfieldsmandatory();

JOptionPane.showMessageDialog(new JDialog(),"All fields are mandatory");
return;


}

if (!id.matches("[0-9]+")) {

                    Sound.validnumber();
		    JOptionPane.showMessageDialog(jp1,"Please enter valid number");

	    tid.setText("");
            tid.requestFocus();

}

if (!name.matches("[a-zA-Z_]+")) {

         Sound.validname();
	    JOptionPane.showMessageDialog(jp1,"Please enter valid name");

 	    tname.setText("");
    	    tname.requestFocus();
}

if(id.matches("[0-9]+")&(name.matches("[a-zA-Z_]+")))
   {
  if(db.checkExists(Integer.parseInt(id))){
            
             Sound.recordexists();
           JOptionPane.showMessageDialog(jp1,"already Id present");

            tid.setText("");
	    tid.requestFocus();
            tname.setText("");
            tname.requestFocus();
}
else{


db.insert(Integer.parseInt(id),name);
tid.setText("");
tname.setText("");


}
}





}});


}



}