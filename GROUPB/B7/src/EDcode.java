import java.io.IOException;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;


public class EDcode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client;
		
		Scanner sc = new Scanner(System.in);
		int choice;
		try {
			client = new MongoClient("localhost",27017);
			System.out.println("Connection successful");
			
			DB db = client.getDB("crimedb");
			System.out.println("Database selected successfully");
			
			DBCollection collection = db.getCollection("crime_db");
			System.out.println("Collection selected");
			
			do{
				System.out.println("1:INSERT AN ENTRY\n2:DISPLAY ENTRIES");
				choice = sc.nextInt();
				
				switch(choice)
				{
				case 1:
					//ENCODING
					JSONObject obj = new JSONObject();
					
				    System.out.println("ENTER NAME : ");
					obj.put("name",sc.next());
					System.out.println("ENTER AGE: ");
					obj.put("age",sc.next());
					
					StringWriter out = new StringWriter();
					try {
						obj.writeJSONString(out);
						String jsonString = out.toString();
						System.out.println("ENCODING: "+jsonString);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							
					BasicDBObject mydoc = (BasicDBObject)JSON.parse(obj.toJSONString());
					collection.insert(mydoc);
					
				    break;
				case 2:
					//DECODING
					DBCursor cursor = collection.find();
					String JSONString = null;
					StringBuilder sb= new StringBuilder();
				
					while(cursor.hasNext())
					{
						DBObject obj2 = cursor.next();
						System.out.println("NAME:"+obj2.get("name")+" "+"AGE: "+obj2.get("age"));
					}
					
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
