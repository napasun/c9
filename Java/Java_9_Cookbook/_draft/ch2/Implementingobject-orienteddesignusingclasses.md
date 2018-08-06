# Implementing object-oriented design using classes - 클래스를 사용하여 객체 지향 디자인 구현

이 레시피에서는 객체 / 클래스와 캡슐화의 두 가지 OOD 개념을 배웁니다.

## 준비하기

객체라는 용어는 일반적으로 이러한 데이터에 적용 할 수있는 데이터와 프로 시저의 결합을 나타냅니다. 데이터도 절차도 필요하지 않지만 그 중 하나는 일반적으로 항상 존재합니다. 데이터를 객체 속성이라고하며 프로 시저를 메서드라고합니다. 속성은 객체의 상태를 캡처합니다. 메소드는 객체의 동작을 설명합니다. 모든 객체에는 클래스로 정의되는 유형이 있습니다 (다음 참조). 객체는 클래스의 인스턴스라고도합니다.

~~~
The term class is a collection of the definitions of properties and methods that will be present in each of its instances--the objects created based on this class. Encapsulation is the hiding of object properties and methods that should not be accessible by other objects.
~~~

캡슐화는 속성 및 메서드 선언에서 Java 키워드 **private** 또는 **protected** 로 구현됩니다.

## How to do it... 하는 방법

1. horsePower 속성을 사용하여 Engine 클래스 만들기, 이 프로퍼티의 값을 설정하는 setHorsePower() 메서드, 그리고 차량의 속도를 계산하는 getSpeedMph() 메소드, 차량이 움직이기 시작한 이후의 시간, 차량 중량 및 엔진 출력에 기초하여,

```java
public class Engine { 
    private int horsePower; 

    public void setHorsePower(int horsePower) { 
        this.horsePower = horsePower; 
    } 
    
    public double getSpeedMph(double timeSec, 
                            int weightPounds) { 
        double v = 2.0*this.horsePower*746; 
        v = v*timeSec*32.17/weightPounds; 
        return Math.round(Math.sqrt(v)*0.68); 
    } 
}
```

2. Create the Vehicle class:

```java
public class Vehicle { 
    private int weightPounds; 
    private Engine engine; 

    public Vehicle(int weightPounds, Engine engine) { 
        this.weightPounds = weightPounds; 
        this.engine = engine; 
    } 

    public double getSpeedMph(double timeSec){ 
        return this.engine.getSpeedMph(timeSec, weightPounds); 
    } 
} 
```

3. 다음 클래스를 사용할 응용 프로그램을 만듭니다.

```java
public static void main(String... arg) { 
    double timeSec = 10.0; 
    int horsePower = 246; 
    int vehicleWeight = 4000; 

    Engine engine = new Engine(); 
    engine.setHorsePower(horsePower); 
    Vehicle vehicle = new Vehicle(vehicleWeight, engine); 
    
    System.out.println("Vehicle speed (" + timeSec + " sec)=" + vehicle.getSpeedMph(timeSec) + " mph"); 
} 
```

## How it works...

앞의 응용 프로그램은 다음과 같은 결과를 출력합니다.

![](https://www.packtpub.com/graphics/9781786461407/graphics/d45e2575-81f2-4f7d-ae1c-48ad71b80b0d.png)

보시다시피 매개 변수없이 Engine 클래스의 기본 생성자를 호출하고 힙에 새로 생성 된 객체에 메모리를 할당한 Java 키워드 new를 사용하여 engine 객체를 만들었습니다.

두 번째 객체 인 Vehicle은 두 개의 매개 변수를 사용하여 Vehicle 클래스의 명시적으로 정의된 생성자로 만들어졌습니다. 생성자의 두 번째 매개 변수는 setHorsePower() 메서드를 사용하여 246으로 설정된 값으로 horsePower 속성을 전달하는 엔진 객체입니다.

또한 Vehicle 클래스의 getSpeedMph() 메서드에서 수행되므로 engine 객체에 액세스 할 수 있는 다른 모든 객체에서 호출 할 수 있는 getSpeedMph() 메서드가 포함되어 있습니다.

Vehicle 클래스의 getSpeedMph () 메서드는 엔진 속성에 할당 된 값의 존재 여부에 의존한다는 점을 알아 두는 것이 좋습니다. Vehicle 클래스의 객체는 속도 계산을 Engine 클래스의 객체에 위임합니다. 후자가 설정되어 있지 않으면 (예 : Vehicle () 생성자에서 null이 전달됨) 런타임에 NullPointerException이 발생합니다. 이를 피하기 위해 Vehicle () 생성자에서 이 값의 존재 여부를 확인할 수 있습니다.

```java
if(engine == null){ 
   throw new RuntimeException("Engine" + " is required parameter."); 
}   
```

또는 Vehicle 클래스의 getSpeedMph () 메소드를 검사 할 수 있습니다.

```java
if(getEngine() == null){ 
  throw new RuntimeException("Engine value is required."); 
} 
```

이 방법으로, 우리는 NullPointerException의 모호함을 피하고 사용자에게 문제의 원인을 정확히 알려줍니다.

주목할 수 있듯이 getSpeedMph() 메서드는 Engine 클래스에서 제거하고 Vehicle 클래스에서 완전히 구현할 수 있습니다.

```java
public double getSpeedMph(double timeSec){
  double v = 2.0 * this.engine.getHorsePower() * 746;
  v = v * timeSec * 32.174 / this.weightPounds;

  return Math.round(Math.sqrt(v) * 0.68);
}
```

이렇게 하려면 Vehicle 클래스의 getSpeedMph() 메서드에서 사용할 수 있도록 공용 메서드 getHorsePower()를 Engine 클래스에 추가해야 합니다. 지금은 getSpeedMph() 메소드를 Engine 클래스에 남겨 두었습니다.

이것은 당신이 해야하는 설계 결정 중 하나입니다. Engine 클래스의 객체가 Vehicle이 아닌 다른 클래스의 객체로 전달된다고 생각하면 getSpeedMph() 메서드를 Engine 클래스에 유지해야합니다. 그렇지 않으면 Vehicle 클래스가 속도 계산을 담당 할 것이라고 생각하면 (이는 엔진이 아닌 차량의 속도이기 때문에 의미가 있음) Vehicle 클래스 내에 이 메서드를 구현해야합니다.

## There's more...

Java는 클래스를 확장하고 서브 클래스가 기본 클래스의 모든 기능에 액세스 할 수 있게 합니다. 예를 들어, 속도에 대해 질문 할 수 있는 모든 객체가 Vehicle 클래스에서 파생 된 하위 클래스에 속하는지 결정할 수 있습니다. 이 경우 Car는 다음과 같이 보일 수 있습니다.

```java
public class Car extends Vehicle {
  private int passengersCount;
  
  public Car(int passengersCount, int weightPounds, 
             Engine engine){
    super(weightPounds, engine);
    this.passengersCount = passengersCount;
  }
  
  public int getPassengersCount() {
    return this.passengersCount;
  }
}
```

이제 Vehicle 클래스를 Car 클래스로 대체하여 테스트 코드를 변경할 수 있습니다.

public static void main(String... arg) { 
  double timeSec = 10.0; 
  int horsePower = 246; 
  int vehicleWeight = 4000; 
  
  Engine engine = new Engine(); 
  engine.setHorsePower(horsePower); 
  Vehicle vehicle = new Car(4, vehicleWeight, engine); 
  
  System.out.println("Car speed (" + timeSec + " sec) = " + 
                     vehicle.getSpeedMph(timeSec) + " mph"); 
} 

실행하면 Vehicle 클래스의 객체와 동일한 값을 생성합니다.

![](https://www.packtpub.com/graphics/9781786461407/graphics/0906ff56-b275-47f1-b7e8-fcbd66932403.png)

다형성 때문에 Car 클래스의 개체에 대한 참조를 Vehicle이라는 기본 클래스의 참조에 할당 할 수 있습니다. Car 클래스의 객체에는 자체 유형 인 Car와 기본 클래스의 유형 인 Vehicle이라는 두 가지 유형이 있습니다.

Java에서 클래스는 여러 개의 인터페이스를 구현할 수도 있으며 이러한 클래스의 객체도 구현 된 각 인터페이스 유형을 갖습니다. 우리는 이후의 요리법에서 이에 대해 이야기 할 것입니다.

동일한 기능을 위해 응용 프로그램을 설계하는 데 보통 여러 가지 방법이 있습니다. 그것은 모두 프로젝트의 요구와 개발 팀이 채택한 스타일에 달려 있습니다. 그러나 어떤 맥락에서든 디자인의 명확성은 당신이 의도를 전달하는 데 도움이 될 것입니다. 좋은 디자인은 코드의 품질과 수명에 기여합니다.