package board.dao.boardgroup;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoSocketException;

import board.model.board.boardgroup.BoardGroup;
import db.MongoDBConnect;

public class BoardGroupDao {
	private MongoClient client;
	private DB db;
	private DBCollection collection;
	
	private void connect() {
		client = MongoDBConnect.newConnect("mongodb://test:testttt@ds057934.mongolab.com:57934/testboarddb");
		db = client.getDB("testboarddb");
		collection = db.getCollection("boardgroup"); //콜렉션
	}
	
	public void cleanConnect() {
		client.close();
	}
	
	public BoardGroupDao() {		
		client = MongoDBConnect.newConnect("mongodb://test:testttt@ds057934.mongolab.com:57934/testboarddb");
		db = client.getDB("testboarddb");
		collection = db.getCollection("boardgroup"); //콜렉션
	}
	
	public BoardGroupDao(String url, String dbName, String conllectionName) {
		client = MongoDBConnect.newConnect(url);
		db = client.getDB(dbName);
		collection = db.getCollection(conllectionName); //콜렉션
	}
	
	public void insertBoard(BoardGroup boardGroup) {
		BasicDBObject doc = new BasicDBObject(); //document 생성
		   
		doc.put("boardNum", boardGroup.getBoardNum());
		doc.put("boardName", boardGroup.getBoardName());
		   
		collection.insert(doc);
	}
	
	public List<BoardGroup> selectBoardList(Integer boardNum) {
		BasicDBObject searchQuery = new BasicDBObject();
		ArrayList<BoardGroup> returnList = new ArrayList<BoardGroup>();
		
		if (boardNum != null && !boardNum.equals(0)) {
			searchQuery.put("boardNum", boardNum);
		}
		   
		DBCursor cursor = collection.find(searchQuery); //쿼리날리기
		List<DBObject> list =  cursor.toArray();
		//Column[] columnList = BoardGroup.Column.values();
		
		for (DBObject object : list) {
			BoardGroup bg = new BoardGroup();
			bg.setBoardNum(Integer.parseInt(String.valueOf(object.get("boardNum"))));
			bg.setBoardName((String) object.get("boardName"));
			returnList.add(bg);
		}
		
		return returnList;
	}
	
	public List<BoardGroup> selectBoardList(BoardGroup boardGroup) {
		BasicDBObject searchQuery = new BasicDBObject();
		ArrayList<BoardGroup> returnList = new ArrayList<BoardGroup>();
		
		if (boardGroup.getBoardNum() != null && !boardGroup.getBoardNum().equals(0)) {
			searchQuery.put("boardNum", boardGroup.getBoardNum());
		}
		
		if (!boardGroup.getBoardName().equals("")) {
			searchQuery.put("boardName", boardGroup.getBoardName());
		}
		   
		DBCursor cursor = collection.find(searchQuery); //쿼리날리기
		List<DBObject> list =  cursor.toArray();
		//Column[] columnList = BoardGroup.Column.values();
		
		for (DBObject object : list) {
			BoardGroup bg = new BoardGroup();
			bg.setBoardNum(Integer.parseInt(String.valueOf(object.get("boardNum"))));
			bg.setBoardName((String) object.get("boardName"));
			returnList.add(bg);
		}
		
		return returnList;
	}
	
	public void deleteBoardGroup(Integer boardNum) {
		BasicDBObject deleteQuery = new BasicDBObject();
		deleteQuery.put("boardNum", boardNum);
		
		collection.remove(deleteQuery);
	}
}
