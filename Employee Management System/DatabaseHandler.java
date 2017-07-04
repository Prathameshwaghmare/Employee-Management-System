import javax.swing.*;
import java.sql.*;
import mu.*;

class DatabaseHandler{


static Connection con;





public static void getConnection()
{

try{

Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pradnya007");

}

catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),""+e);


}//end of catch

}//end of getConnection













public void insert(int id,String name)
{

try
{

getConnection();

String q= "insert into employee values(?,?)";

PreparedStatement pst = con.prepareStatement(q);
pst.setInt(1,id);
pst.setString(2,name);

int i=pst.executeUpdate();
  

Sound.recordadded();
JOptionPane.showMessageDialog(new JDialog(),"1 Record Added");


}// end of try block

catch(Exception e)
{

Sound.recordexists();
JOptionPane.showMessageDialog(new JDialog(),"Record Already Exists");

}//end of catch


}//end of insert method














public String query()
{
StringBuffer sb = new StringBuffer();

try
{

getConnection();

String q="select * from employee order by id";

Statement st = con.createStatement();

ResultSet rs = st.executeQuery(q);

sb.append("ID:"+"\t"+"NAME:"+"\n");

while(rs.next())
{
sb.append(rs.getString(1)+"\t"+rs.getString(2)+"\n");
}//end of while


rs.close();

}//end of try

catch(Exception e){

JOptionPane.showMessageDialog(new JDialog()," "+e);

}//end of catch

return sb.toString();
} //end of query method














public void delete(int id)
{

try
{

getConnection();

String q= "delete FROM employee where id = (?)";

PreparedStatement pst = con.prepareStatement(q);
pst.setInt(1,id);

int i=pst.executeUpdate();


Sound.recorddelete();
JOptionPane.showMessageDialog(new JDialog(),"1 Record deleted");


}// end of try block

catch(Exception e)
{

Sound.recordnotfound();
JOptionPane.showMessageDialog(new JDialog(),"Record not found");

}//end of catch


}//end of delete method



public boolean checkExists(int id){
try{
getConnection();
String existance = "select * from employee where id=" + id;
Statement stmt= con.createStatement();
ResultSet resultSet = stmt.executeQuery(existance);
if(resultSet.next()){
   return true;
 }
}
catch(Exception e){

JOptionPane.showMessageDialog(new JDialog(),"" + e);
}
return false;
}











public void update(int id,String name)
{

try
{

getConnection();

String q= "update employee set name=(?) where id=(?)";
  
 
PreparedStatement pst = con.prepareStatement(q);
pst.setString(1,name);
pst.setInt(2,id);

int i=pst.executeUpdate();

Sound.updaterecord();

JOptionPane.showMessageDialog(new JDialog(),"1 Record Updated");


}// end of try block

catch(Exception e)
{

Sound.recordnotfound();
JOptionPane.showMessageDialog(new JDialog(),"Record not found");
}//end of catch


}//end of update method


}

