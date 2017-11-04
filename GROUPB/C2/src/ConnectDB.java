import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ConnectDB {

	/**
	 * @param args
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/te3256db";
	
	static final String USER = "te3256";
	static final String PASS = "te3256";
	
	static Connection conn =null;
	static Statement stmt =null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Long acc_no;
		String fname,lname;
		int age;
		float balance;
		String address;
		String type;
		
		String sql=null;
		ResultSet rs;
		
		
		int choice;
		try {
			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			do{
				System.out.println("1:INSERT AN ENTRY\n2:REMOVE AN ENTRY\n3:UPDATE AN ENTRY\n4:SHOW ENTRIES\n");
				choice = sc.nextInt();
				
				switch(choice)
				{
				case 1:
					  System.out.println("ENTER ACCOUNT NO:");
		              acc_no = sc.nextLong();
		              
		              System.out.println("ENTER FIRST NAME:");
		              fname = sc.next();
		              
		              System.out.println("ENTER LAST NAME:");
		              lname = sc.next();
					
		              System.out.println("ENTER AGE:");
		              age = sc.nextInt();
		              
		              System.out.println("ENTER BALANCE:");
		              balance = sc.nextFloat();
		              
		              System.out.println("ENTER THE ADDRESS:");
		              address = sc.next();
		              
		              System.out.println("ENTER THE TYPE OF ACCOUNT:");
		              type = sc.next();
		         
			          sql = "insert into Bank values("+acc_no+",'"+fname+"','"+lname+"',"+age+","+balance+",'"+address+"','"+type+"');";
			         stmt.executeUpdate(sql);         
		             break;
				case 2:
					System.out.println("ENTER THE ACC-NO:");
					acc_no = sc.nextLong();
					sql = "delete from Bank where acc_no = "+Long.toString(acc_no);
					stmt.executeUpdate(sql);
					break;
				case 3:
					System.out.println("ENTER THE ACC-NO:");
					acc_no = sc.nextLong();
					System.out.println("Credit into account(C)/Debit into account(D)");
					char c = sc.next().charAt(0);
					float amount;
					if(c=='C')
					{
						System.out.println("Enter the amount to credit:");
						amount = sc.nextFloat();
						sql = "update Bank set balance= balance + "+Float.toString(amount)+"where acc_no ="+Long.toString(acc_no)+";";
					}
					
					if(c=='D')
					{
						
						System.out.println("Enter the amount to credit:");
						amount = sc.nextFloat();
						sql = "update Bank set balance= balance - "+Float.toString(amount)+"where acc_no ="+Long.toString(acc_no)+";";
						
					}
					stmt.executeUpdate(sql);
					break;
					
				case 4:
					 sql = "select * from Bank ;";
					 rs = stmt.executeQuery(sql);
					 System.out.println("ACC_NO\tFIRST-NAME\tLAST_NAME\tAGE\tBALANCE\tADDRESS\tTYPE");
					 while(rs.next())
					 {
						 System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t"+rs.getFloat(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\n");
					 }
					break;
				
				
				}
				
				
				System.out.println("Do you want to continue ? (Y/N)");
			}while(sc.next().charAt(0)=='Y');
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
