package study.spring.mongo;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories(basePackages = "study.spring.mongo.db")
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		// 데이터베이스 명 지정
		return "testboarddb ";
	}

	@Override
	public Mongo mongo() throws Exception {
		// 클라이언트 생성
		MongoCredential credential = MongoCredential.createMongoCRCredential(
				"test"
				, "testboarddb "
				, "testttt".toCharArray());
		return new MongoClient(new ServerAddress("ds057934.mlab.com", 57934)
				, Arrays.asList(credential));
	}

}
