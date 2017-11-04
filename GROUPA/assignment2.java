
package assignment2;

import java.sql.*;
import java.util.*;

public class Connect {
   // JDBC driver name and database URL  
   static final String DB_URL = "jdbc:mysql://192.168.5.125:3306/te3250db";

   //  Database credentials
   static final String USER = "te3250";
   static final String PASS = "te3250";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   Scanner s = new Scanner(System.in);
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
	  ResultSet rs = null;
      char y= 'y';
      while(y=='y')
      {
    	  int ch;
    	  System.out.println("1 for index, 2 for view and 3 for sequences");
    	  ch=s.nextInt();
    	  String table_name;
    	  switch(ch)
    	  {
    	  case 1 : 
    	  {
    		  System.out.println("1 for showing index keyname & index type, 2 for creating index");
    		  int cho;
    		  cho = s.nextInt();
    		  switch(cho)
    		  {
    		  case 1 :
    		  {
    			  System.out.println("Show the index keyname and indextype present in table. Input tablename");
    			  table_name=s.next();                    //take table name from user to show indices present in that table
    			  System.out.println(table_name);
        		  sql = "show index from"+ " " +table_name;
        		  System.out.println(sql);
        		  rs = stmt.executeQuery(sql);
        		  while(rs.next())                       //loop over result set till end of rows and display data accordingly
        		  {
        			  String key= rs.getString("Key_Name");
        			  String IndexType=rs.getString("Index_Type");
        			  System.out.print(key);
        			  System.out.println(" " + IndexType);
        		  }
        		  break;
    		  }
    		  case 2 :
    		  {
    			  String index_name;
    			  System.out.println("Create index from table. Input tablename, indexname and parameters respectively");
    			  table_name = s.next();           // take table name index name and parameters from user to create a index         
    			  index_name =s.next();
    			  String parameters;
    			  parameters=s.next();
    			  sql = "create index "+index_name+" on "+table_name+" ("+parameters+")";
    			  System.out.println(sql);
    			  int r;
    			  r=stmt.executeUpdate(sql);
    			  break;
    		  }
    		  }
    		  
    		  break;
    	  }
    	  
    	  case 2 :
    	  {
    		  System.out.println("1 for create view, 2 for show view and 3 for delete view");
    		  int cho;
    		  cho= s.nextInt();
    		 switch(cho)
    		 {
    		 case 1 :
    		 {
    			 System.out.println("Creating view for table. Input tablename, viewname and columnname");
    			 table_name = s.next();                                       //create a view for a particular table and a particular column name
    			 String view_name=s.next();
                 String column_name =s.next();
    			 sql= "create view "+view_name+" as select "+column_name+" from "+table_name;
    			 System.out.println(sql);
    			 int r;
    			 r=stmt.executeUpdate(sql);
    			 break;
    		 }
    		 case 2 :
    		 {
    			 System.out.println("Enter view name");    //display data of view
    			 String view_name = s.next();
    			 sql = "select * from "+ view_name;
    			 System.out.println(sql);
    			 rs=stmt.executeQuery(sql);
    			 break;
    		 }
    		 case 3 :
    		 {
    			 System.out.println("Enter view to be dropped");   //delete view
    			 String view_name = s.next();
    			 sql = "drop view "+ view_name;
    			 System.out.println(sql);
    			 int r;
    			 r = stmt.executeUpdate(sql);
    			 break;
    		 }
    		 }
 
    		  break;
    	  }
    	  
    	  case 3 :
    	  {
    		  System.out.println("1 for creating sequence, 2 for inserting in sequence, 3 for deleting table and 4 for showing sequence");
    		  int cho;
    		  cho = s.nextInt();
    		  switch(cho)
    		  {
    		  case 1 :
    		  {
        		  System.out.println("Creating sequence..");   //create predefined sequence
        		  System.out.println("Creating new table");
        		  sql = "CREATE TABLE Roll_no(no INT AUTO_INCREMENT, PRIMARY KEY(no), name VARCHAR(140))";
        		  int r =stmt.executeUpdate(sql);
    			  break;
    		  }
    		  case 2 :
    		  {
    			  System.out.println("Entering new data in sequence");   //enter data in sequence
    			  System.out.println("Enter name");
    			  String name = s.next();
    			  sql = "insert into Roll_no values (null, '"+ name + "')";
    			  System.out.println(sql);
    			  int r = stmt.executeUpdate(sql);
    			  break;
    		  }
    		  case 3 :
    		  {
    			  System.out.println("Deleting sequence");  //delete sequence
    			  sql = "drop table Roll_no";
    			  int r = stmt.executeUpdate(sql);
    			  break;
    		  }
    		  case 4 :
    		  {
    			  System.out.println("Showing table");       //show data in sequence
    			  sql = "select * from Roll_no";
    			  rs = stmt.executeQuery(sql);
    			  while(rs.next())
    			  {
    				  int roll_no = rs.getInt("no");
    				  String name = rs.getString("name");
    				  System.out.print(roll_no);
    				  System.out.println(" " + name);
    			  }
    			  break;
    		  }
    		  default :
    			  System.out.println("Wrong choice");
    			  break;
    		  }
    		 
    		 break;
    	  }
    	  
    	  default :
    	  {
    		  System.out.println("Wrong choice");
    		  break;
    	  }
    	  }
    	  System.out.println("Continue? (y/n)");
    	  y = s.next().charAt(0);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se)
   {
	   													//Handle errors for JDBC
      se.printStackTrace();
   }
   catch(Exception e){
	   													//Handle errors for Class.forName
      e.printStackTrace();
   }
   finally
   {
	   												//finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }
      catch(SQLException se2){
      }
      																	// nothing we can do
      try
      {
         if(conn!=null)
            conn.close();
      }
      catch(SQLException se){
         se.printStackTrace();
      }																	//end finally try
   }																		//end try
   System.out.println("Goodbye!");
}																		//end main
}																			//end FirstExample









/*output
Connecting to database...
Creating statement...
1 for index, 2 for view and 3 for sequences
1
1 for showing index keyname & index type, 2 for creating index
1
Show the index keyname and indextype present in table. Input tablename
professors
professors
show index from professors
PRIMARY BTREE
dept_id BTREE
prof_name BTREE
prof_name BTREE
prof BTREE
city_name BTREE
Continue? (y/n)
y
1 for index, 2 for view and 3 for sequences
3
1 for creating sequence, 2 for inserting in sequence, 3 for deleting table and 4 for showing sequence
4
Showing table
Continue? (y/n)
y
1 for index, 2 for view and 3 for sequences
3
1 for creating sequence, 2 for inserting in sequence, 3 for deleting table and 4 for showing sequence
2
Entering new data in sequence
Enter name
samridhi
insert into Roll_no values (null, 'samridhi')
Continue? (y/n)
y
1 for index, 2 for view and 3 for sequences
3
1 for creating sequence, 2 for inserting in sequence, 3 for deleting table and 4 for showing sequence
4
Showing table
1 samridhi
Continue? (y/n)
y
1 for index, 2 for view and 3 for sequences
2
1 for create view, 2 for show view and 3 for delete view
2
Enter view name
professors_shifts
select * from professors_shifts
Continue? (y/n)
y
1 for index, 2 for view and 3 for sequences
1
1 for showing index keyname & index type, 2 for creating index
2
Create index from table. Input tablename, indexname and parameters respectively
departments
dept_name
dept_name
create index dept_name on departments (dept_name)
com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Duplicate key name 'dept_name'Goodbye!

	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:526)
	at com.mysql.jdbc.Util.handleNewInstance(Util.java:406)
	at com.mysql.jdbc.Util.getInstance(Util.java:381)
	at com.mysql.jdbc.SQLError.createSQLException(SQLError.java:1030)
	at com.mysql.jdbc.SQLError.createSQLException(SQLError.java:956)
	at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3491)
	at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3423)
	at com.mysql.jdbc.MysqlIO.sendCommand(MysqlIO.java:1936)
	at com.mysql.jdbc.MysqlIO.sqlQueryDirect(MysqlIO.java:2060)
	at com.mysql.jdbc.ConnectionImpl.execSQL(ConnectionImpl.java:2536)
	at com.mysql.jdbc.StatementImpl.executeUpdate(StatementImpl.java:1564)
	at com.mysql.jdbc.StatementImpl.executeUpdate(Stateme 
ntImpl.java:1485)
	at assignment2.Connect.main(Connect.java:75)

*/
