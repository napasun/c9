# Chapter 1 The First Step - Concurrency Design Principles

컴퓨터 시스템 사용자는 항상 시스템의 성능을 향상 시키고자 합니다. 그들은 고품질의 비디오, 보다 나은 비디오 게임 및 더 빠른 네트워크 속도를 원합니다. 몇 년 전, 프로세서는 속도를 향상시켜 사용자에게 더 나은 성능을 제공했습니다. 그러나 이제 프로세서는 속도를 높이지 않습니다. 대신 운영 체제가 한 번에 둘 이상의 작업을 실행할 수 있도록 더 많은 코어를 추가합니다. 이것을 동시성이라고 합니다. 동시성 프로그래밍에는 컴퓨터에서 여러 작업이나 프로세스를 동시에 실행하고 데이터 손실이나 불일치 없이 컴퓨터간에 통신 및 동기화하는 모든 도구와 기술이 포함됩니다. 이 장에서는 다음 내용을 다룹니다.

* 기본 동시성 개념 - Basic concurrency concepts
* 동시성 응용 프로그램에서 발생할 수 있는 문제 - Possible problems in concurrent applications
* 동시성 알고리즘을 설계하는 방법론 - A methodology to design concurrent algorithms
* Java Concurrency API - Java Concurrency API
* 동시성 디자인 패턴 - Concurrency design patterns
* 동시성 알고리즘을 설계하는 데 필요한 팁과 트릭 - Tips and tricks to design concurrency algorithms