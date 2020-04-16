package db;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoSocketException;

public class MongoDBConnect {
	public static MongoClient newConnect(String url) {
		MongoClientURI client = new MongoClientURI(url);
		
		MongoClient monClient = new MongoClient(client);
		
		return monClient;	
	}
	
	public void connect() {
		MongoClient monClient = new MongoClient("ds057934.mongolab.com",57934);
  
		DB db = monClient.getDB("testboarddb"); //DB이름
		DBCollection collection = db.getCollection("boardgroup"); //콜렉션

		BasicDBObject doc = new BasicDBObject(); //document 생성
		   
		//doc안에 필드,밸류값 넣기
		doc.put("name","test"); 
		doc.put("class","smart");
		   
		collection.insert(doc); //콜렉션에 생성한 document 삽입하기
		   
		   
		//쿼리문을 담기위한 document 생성
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "test");
		   
		DBCursor cursor = collection.find(searchQuery); //쿼리날리기
		   
		//있는 값을 반복문을 이용하여 모두 콘솔에 뿌리기
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		   
		System.out.println("finished..");
	}
	
	public static void main(String[] args) {
		MongoClientURI client = new MongoClientURI("mongodb://test:testttt@ds057934.mongolab.com:57934/testboarddb");
		
		MongoClient monClient = new MongoClient(client);
		//Mongo mon = new Mongo(host, port)
		DB db = monClient.getDB("testboarddb"); //DB이름
		
		DBCollection collection = db.getCollection("boardgroup"); //콜렉션
			
		
		
		BasicDBObject searchQuery = new BasicDBObject();
		//searchQuery.put("boardNum", boardGroup.getBoardNum());
		   
		DBCursor cursor = collection.find(searchQuery); //쿼리날리기
		List<DBObject> list = cursor.toArray();
		System.out.println(list.size());
		System.out.println(list.get(0).get("boardNum"));
		System.out.println(list.get(0).get("boardName"));
		
		
		
	//	WriteConcern w = new WriteConcern(1,2000);

		
		
		System.out.println(monClient);
		System.out.println(db);
		System.out.println(collection);
		
		BasicDBObject doc = new BasicDBObject(); //document 생성
		
		doc.put("boardNum", 100);
		doc.put("boardName", "test00");
		
		collection.insert(doc);
	}
}
