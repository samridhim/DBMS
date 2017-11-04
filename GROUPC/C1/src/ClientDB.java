import java.net.UnknownHostException;
import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


public class ClientDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int choice;
		try {
			MongoClient client = new MongoClient("localhost",27017);
			System.out.println("Connection successful");
			
			DB db = client.getDB("crimedb");
			System.out.println("Database selected successfully");
			
			DBCollection collection = db.getCollection("crime_db");
			System.out.println("Collection selected");
			
			
			do{
				System.out.println("1:INSERT AN ENTRY\n2:REMOVE AN ENTRY \n3:UPDATE AN ENTRY \n4:SHOW ALL ENTRIES");
				choice = sc.nextInt();
				
				switch(choice)
				{
				case 1:
					BasicDBObject ins = new BasicDBObject();
					System.out.println("ENTER NAME : ");
					ins.put("name",sc.next());
					System.out.println("ENTER AGE: ");
					ins.put("age",sc.nextInt());
					collection.insert(ins);		
				    break;
				case 2:
					System.out.println("ENTER AGE WHOSE ENTRIES TO BE DELETED:");
					BasicDBObject ins1 = new BasicDBObject();
					ins1.put("age",sc.nextInt());
					collection.remove(ins1);
					break;
				case 3:
					System.out.println("ENTER INITIAL AGE");
					int ini = sc.nextInt();
					System.out.println("ENTER UPDATED AGE");
					int finl = sc.nextInt();
					BasicDBObject ins2 = new BasicDBObject();
					ins2.put("age",new Integer(ini));
					BasicDBObject ins3 = new BasicDBObject();
					ins3.append("$set", new BasicDBObject().append("age", new Integer(finl)));
					collection.update(ins2, ins3, false, true);
					break;
				case 4:
					DBCursor cursor = collection.find();
					while(cursor.hasNext())
						System.out.println(cursor.next());
					break;
				
				}
				
				System.out.println("Do you want to continue ?(Y/N)");
				
			}while(sc.next().charAt(0)=='Y');
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
