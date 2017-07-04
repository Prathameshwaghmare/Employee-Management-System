import mu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class DeleteFrame extends JFrame
{



JPanel jp1,jp2;
JLabel id;
JTextField tid; 
JButton delete,back;




public DeleteFrame()
{

super("Delete Employees");
setSize(400,200);
setResizable(false);

jp1= new JPanel();
jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

delete=new JButton("Delete");
back=new JButton("Back");
id=new JLabel("Id");
tid=new JTextField(5);

jp1.add(id);
jp1.add(tid);
add(jp1);

jp2=new JPanel();
jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

jp2.add(delete);
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




delete.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent ae){

DatabaseHandler db = new DatabaseHandler();

String id= tid.getText();



try{
if(id.length()!=0)
	{  
	   if(db.checkExists(Integer.parseInt(id))){
			if(!id.matches("[0-9]+")) {
	                                
				/*	
				   JOptionPane.showMessageDialog(jp1,"Please enter number");
			      	     tid.setText("");
				      tid.requestFocus();
				*/

					
				}else{
					db.delete(Integer.parseInt(id));
}
	      }else{      
                        Sound.recordnotfound();
			JOptionPane.showMessageDialog(jp1,"ID does not EXISTS");

			  		tid.setText("");
		         		tid.requestFocus();
	            }
}else{
                   Sound.allfieldsmandatory();
		JOptionPane.showMessageDialog(new JDialog(),"ID Field is EMPTY");
     }	


}

catch(Exception e){
                 
                     Sound.validnumber();
                
  		JOptionPane.showMessageDialog(new JDialog(),"Please Enter Number");
                 tid.setText("");
		  tid.requestFocus();
}



}});

}



}