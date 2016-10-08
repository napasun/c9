# CHAPTER18 WebSocket과 STOMP를 사용하여 메시징하기


웹 소켓(WebSocket)은 단일 소켓을 통해서 풀듀플렉스(full-duplex) 통신을 제공하는 프로토콜이다.

스프링 4.0은 웹 소켓 통신을 지원한다.

* 메시지 전송과 수신을 위한 하위 레벨 API
* 스프링 MVC 컨트롤러에서의 메시지 처리을 위한 사위 레벨 API
* 메시지 전송을 위한 메시지 템플릿
* 브라우저, 서버, 프록시에서 웹 소켓 지원 부족을 지원하기 위한 SockJS

## 스프링의 하위 레벨 웹 소켓 API 사용하기

* 하위 레벨 웹 소켓을 지원하기 위해서 WebSocketHandler를 구현한 클래스를 작성한다.
* AbstractWebSocketHandler는 WebSocketHandler의 추상화 구현체이다.
 * handleTextMessage()
 * handleBinaryMessage()
 * handlePongMessage()
 * afterConnectionEstablished : 연결 시작
 * afterConnectionClosed : 연결 종료
* 웹소켓 활성화를 위해 WebSocketConfigurer 인터페이스를 구현한다.
 * registerWebSocketHandlers() 메소드에서 메시지 핸들러를 등록한다.
* SockJS : 웹 소켓을 지원하지 않는 브라우저, 서버를 대체하기 위해 사용

## STOMP 메시징 작업하기

 웹 소켓을 직접 사용하는것은 TCP 소켓만을 사용하는 웹 애플리케이션을 개발하는 것과 많이 비슷하다.
 TCP 소켓 상위에 존재하는 요청-응답 모델의 HTTP와 마찬가지로 STOMP는 웹 소켓 상위에 메시지 시맨틱을 정의하기 위한프레임 기반의 유선 모맷을 놓는다.
 
* AbstractWebSocketMessageBrokerConfigurer 구현
* @EnableWebSocketMessageBroker 애너테이션
* 스프링 웹 메시징은 메시지 브로커로 처리된다.
* registerStompEndpoints(), StompEndpointRegistry.addEndpoint() 사용하여 엔드포인트를 설정한다.
* enableSimpleBroker() 메소드를 사용하여 인메모리 브로커를 설정한다.
* enableStompBrokerRelay() 메소드를 사용하여 STOMP 브로커로 교체한다.
* 604쪽에 서버설정 포트15672

## 클라이언트로부터의 STOMP 메시지 처리

* STOMP와 웹 소켓은 HTTP의 요청-응답 접근법과 반대인 비동기 메시징이다.
* 606쪽 표 18.1 스프링은 몇개의 메시지 변환기를 사용하여 메시지 페이로드를 자바 타입으로 변환한다.
* @MessageMapping과 @SubsribeMapping애너테이션을 제공한다.
* @SubsribeMapping의 주된 용례는 요청-응답 패턴 구현이다.요청-응답 태턴에서클라이언트는 해당 목적에 대한1회 응답이 예상되는 구독을 한다.

## 클라이언트로 메시지 보내기

1. 메시지 또는 구독
2. 메시징 템플릿 사용하기

* 응답 메시지를 보내고자 한다면 void가 아닌 다른 반환 형식을 사용한다.
* @MessageMapping 애너테이션된 메소드가 반환 값을 가질 때, 반환 객체는 변환되고(메시지 변환기를 통해)  STOMP 프레임의 페이로드에 놓이며 브로커로 전달된다.
* @SubscribeMapping : 브로커를 통하지 않는 다.