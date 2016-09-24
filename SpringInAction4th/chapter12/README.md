# CHAPTER12 NoSQL 데이터베이스 사용하기

## MongoDB

* @EnableMongoRepositories 애너테이션으로 자동 저장소 활성화
 * 데이터베이스를 액세스할 수 있는 MongoClient를 설정해야 한다.
 * 데이터베이스에 액세스하기 위한 템플린 기반 데이터 액세스를 수행하기 위햇 MongoTemplate이 필요하다.
* 직접 빈을 설정하는 방식과 AbstractMongoConfiguration해당 클래스를 확장하여 getDatabaseName()과 mongo() 메소드를 오버라이드한다.
* org.springframework.data:spring-data-mongodb
* org.mongodb:mongo-java-driver
* MongoCredential 자격만들기 (유저, DB명, 비밀번호)
* 엔티티 애너테이션 404쪽 표 12.1
 * @Document -> @Entity, @Id -> @Id
* 저장소 작성하기
 * MongoRepository<도메인, 기본키 객체타입> 상속 받아 구현
 * 탬플릿에서 기본적으로 제공하는 함수들 410쪽 표 12.2
 * 맞춤형 쿼리
 * @Query : 퀴리 직접 입력
 
## Neo4j

* @EnableNeo4jRepositories
 * Neo4jConfig(), graphDatabaseService()
* org.springframework.data:spring-data-neo4j
* 엔티티 애너테이션 418쪽 표 12.3
 * @NodeEntity
 * GraphId
* 저장소 구현 : GraphRepository 클래스 상속

## Redis

* RedisConnectionFactory빈 선언 : 연결팩토리 설정
* RedisTemplate<> 빈 선언 : 탬플릿을 사용하기 위해 설정 <키 타입, 값 객체 타입>
* 탬플릿 기본 함수 433쪽 표 12.5
* org.springframework.data:spring-data-redis
