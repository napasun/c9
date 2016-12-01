INHERITANCE
===========

INHERITANCE
-----------

 기존의 표시 객체를 확장하는 새로운 클래스 정의를 작성하면 캡슐화 된 재사용 가능한 시각적 요소가 제공되므로 쉽게 수행 할 수 있습니다. 이 튜토리얼은 클래스를 확장하는 한 가지 방법을 보여줍니다. 그러나 다른 많은 옵션이 있습니다. 가장 편한 옵션을 사용하십시오. 여기에서 배우는 교훈을 적용하십시오.
> Creating new class definitions that extend existing display objects provides encapsulated, easily reusable visual elements, and it's easy to do. This tutorial shows one method of extending a class, but there are many other options - use the one that's most comfortable for you, but apply the lessons you learn here.

 Container를 확장하는 Button 클래스를 만듭니다.
> We'll create a Button class, that extends Container.

```
(function() {
 
function Button(label) {
    this.Container_constructor();
    this.label = label;
}
var p = createjs.extend(Button, createjs.Container);
 
p.draw = function() {
    this.Container_draw();
    // add custom logic here.
}
 
window.Button = createjs.promote(Button, "Container");
}());
```

#### The constructor

 3 행은 새로운 Button 인스턴스를 생성 할 때 호출 될 생성자 함수를 정의합니다. 4 행은 promotion에 의해 설정된 메소드 별칭을 통해 Container의 생성자를 호출합니다. 수퍼 클래스의 생성자를 호출하는 것은 새 인스턴스가 올바르게 설정되었는지 확인하는 데 매우 중요합니다. 5 행은 생성자에 전달 된 매개 변수를 기반으로 인스턴스 속성 값을 설정합니다.
> Line 3 defines the constructor function which will be called when we create new Button instances. Line 4 calls Container's constructor, via a method alias that was set up by promote (more on that shortly). Calling the super class's constructor is very important to ensure new instances are set up correctly. Line 5 just sets the value of an instance property based on a parameter passed to the constructor.

#### Using createjs.extend()

 7 행은 Button을 Container 클래스에서 확장하거나 Container 클래스에서 상속합니다. 이렇게하면 컨테이너가 프로토 타입 체인에 추가되어 Button에서 모든 메서드를 사용할 수있게됩니다.
> Line 7 makes Button extend, or inherit from, the Container class. This adds Container to it's prototype chain, making all of its methods available in Button.

 extend 메소드는 새 프로토 타입을 다시 전달합니다. 새 프로토 타입은 새 변수 p에 할당하여 쉽게 액세스 할 수 있습니다.
> The extend method passes back the new prototype, which we assign to a new variable p for easy access.

#### Adding methods

 9-12 행은 Button의 프로토 타입에 새로운 그리기 메소드를 설정합니다.이 메소드는 Container의 기존 그리기 메소드를 대체합니다. 생성자와 마찬가지로, 그것은 승격에 의해 추가 된 특별한 메소드를 사용하여 슈퍼 클래스의 메소드 버전을 호출 할 수 있습니다.
> Lines 9-12 set up a new draw method on Button's prototype, which overrides an existing draw method on Container. Just like with the constructor, it can call its super class's version of the method using a special method that was added by promote.

#### Using createjs.promote()

 14 번째 줄은 promotor를 호출합니다.이 메소드는 Button에서 오버라이드 된 모든 메소드를 생성자를 포함하여 식별하고이를 prefix_methodName 형식의 새 이름으로 Button으로 승격합니다. Container_draw와 같이 보이는 승격 된 메소드의 결과로 나타나는 접두사로 "Container"를 지정했습니다. 이렇게하면 인스턴스 범위에서 수퍼 클래스 메서드를 호출하는 쉽고 높은 성능의 방법을 얻을 수 있습니다.
> Line 14 calls promote, which identifies all of the methods in Container that were overridden in Button (including the constructor) and promotes them into Button with a new name in the format prefix_methodName. We specified "Container" as the prefix which results in promoted methods that look like Container_draw. This gives you an easy and highly performant way to call super class methods in the instance scope.

 promote 메서드는 클래스를 반환하고 응용 프로그램에서 사용할 수 있도록 전역 / 창 범위에 할당합니다.
> The promote method returns the class, which is then assigned into the global/window scope to make it available for our application.


FINISHING UP
------------

 이제 클래스를 인스턴스화하여 다른 표시 객체와 마찬가지로 표시 목록에 추가 할 수 있습니다.
> Now the class can be instantiated, and added to the display list like any other display object.

```
var myButton = new Button("label");
stage.addChild(myButton);
```