h1. Chapter 5 Stream Operations and Pipelines

최신 Java 릴리스 (8 및 9)에서 콜렉션 API는 스트림 도입과 람다 표현식을 이용한 내부 반복에 대한 주요 개혁을 실시했습니다. 이 장에서는 파이프 라인을 만들기 위해 스트림을 활용하고 컬렉션에서 여러 작업을 연결하는 방법을 보여줍니다. 또한 이러한 작업을 병렬로 수행하는 방법을 알려 드리고자합니다. 우리는 다음과 같은 조리법을 다룰 것입니다 :

* 새 팩토리 메서드를 사용하여 컬렉션 객체 만들기
* 스트림에서 생성 및 작동
* 스트림에서 연산 파이프 라인 만들기
* 스트림의 병렬 계산

[[5_1 Introduction]]
[[5_2 Using the new factory methods to create collection objects]]