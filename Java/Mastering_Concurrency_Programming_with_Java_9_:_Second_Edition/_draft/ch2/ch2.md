# Chapter 2 Working with Basic Elements - Threads and Runnables 기본 요소 - 스레드 및 실행 파일 사용

실행 스레드는 동시 응용 프로그램의 핵심입니다. 언어와 상관없이 동시 응용 프로그램을 구현할 때 동기화 요소 (예 : 세마포어)를 사용하지 않는 한 비결정적 순서로 병렬로 실행되는 다른 실행 스레드를 만들어야 합니다. Java에서는 두 가지 방법으로 실행 스레드를 만들 수 있습니다.
Execution threads are the core of concurrent applications. When you implement a concurrent application, no matter the language, you have to create different execution threads that run in parallel in a non-deterministic order unless you use a synchronization element (such as a semaphore). In Java you can create execution threads in two ways:

* Thread 클래스 확장하기
* Runnable 인터페이스의 구현

이 장에서는 이러한 요소를 사용하여 Java로 동시 응용 프로그램을 구현하는 방법을 학습합니다. 다음 주제를 다룹니다.

Java의 스레드 : 특성 및 상태
Thread 클래스와 Runnable 인터페이스
첫 번째 예 : 행렬 곱셈
두 번째 예 : 파일 검색

[[2_1 Threads in Java]]
[[2_2 First example matrix multiplication]]
[[2_3 Second example - file search]]

# Summary

이 장에서는 Java에서 실행 스레드를 생성하는 가장 기본적인 요소 인 <span style="color:red">Runnable</span> 인터페이스와 <span style="color:red">Thread</span> 클래스를 제시했습니다. Java로 스레드를 생성하는 방법에는 두 가지가 있습니다.

* <span style="color:red">Thread</span> 클래스의 확장과 <span style="color:red">run()</span> 메소드의 오버라이드
* <span style="color:red">Runnable</span> 인터페이스를 구현해, 그 클래스의 오브젝트를 <span style="color:red">Thread</span> 클래스의 constructor에 건네줍니다.

두 번째 메커니즘은 첫 번째 메커니즘보다 선호되므로 유연성이 더 많습니다.

우리는 또한 <span style="color:red">Thread</span> 클래스가 스레드에 대한 정보를 얻거나, 우선 순위를 변경하거나, finalization을 기다리는 것을 허용하는 여러 가지 메소드가 있다는 것을 배웠다. 우리는 이 두 가지 방법을 모두 두 개의 예에서 사용했습니다. 하나는 행렬을 곱하고 다른 하나는 디렉토리에서 파일을 검색하는 예제입니다. 두 경우 모두 동시성이 더 나은 성능을 제공하지만 동시 버전의 알고리즘을 구현할 때는 주의해야한다는 것을 배웠습니다. 동시성을 사용하는 방법에 대한 나쁜 선택은 우리에게 나쁜 성능을 줄 수 있습니다.

다음 장에서는 Executor 프레임 워크를 소개합니다. 그러면 스레드 생성 및 관리에 대한 걱정없이 동시성 응용 프로그램을 만들 수 있습니다.