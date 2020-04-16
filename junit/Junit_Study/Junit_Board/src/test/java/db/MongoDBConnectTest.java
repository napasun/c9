package db;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.MongoClient;

public class MongoDBConnectTest {
	@Test
	public void newConnectTest() {	
		MongoClient db = MongoDBConnect.newConnect("mongodb://test:testttt@ds057934.mongolab.com:57934/testboarddb");
	}
	
	@Test(expected=UnknownHostException.class)
	public void newConnectExceptionTest() {	
		MongoClient nulldb = MongoDBConnect.newConnect("mongodb://test:testttt@ds0457934.mongolab.com:57934/testboarddb");
	}
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testIndex() {
	   int[] array = new int[0];
	   int var = array[0];
	}
}
