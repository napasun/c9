EASELJS 충돌처리
================

HITTEST
-------

 hitTest 함수을 호출하는 오브젝트와 지정된 포인트가 충돌이 일어날 경우 true를 리턴한다. (ie. if it will draw to that pixel). 특정 오브젝트가 마우스와 충돌이 있어나는 지 확인할 수 있다.

```
myDisplayObject.hitTest(localX, localY);
```

 다음 데모에서는 circle.hitTest (stage.mouseX, stage.mouseY)를 호출하여 마우스가 빨간색 원 위에 있는지 확인합니다.

```
var stage, circle;
		function init() {
			stage = new createjs.Stage("demoCanvas");
			
			circle = stage.addChild(new createjs.Shape());
			circle.graphics.beginFill("red").drawCircle(50,50,50);
			circle.x = 0;
			circle.y = 0;
			
			createjs.Ticker.on("tick", tick);
		}
		
		function tick(event) {
			circle.alpha = 0.2;
			if (circle.hitTest(stage.mouseX, stage.mouseY)) {
			circle.alpha = 1;
			}
			stage.update(event);
		}
```

 이 간단한 구현은 원이 이동 또는 변형되지 않았을 때 잘 동작하지만 hitTest는 전달 된 위치가 로컬 좌표 공간에있을 것으로 예상합니다. stage.mouseX 및 stage.mouseY 위치는 전역 (스테이지) 좌표입니다.

<hr/>

GLOBALTOLOCAL
-------------

 전역 위치를 로컬 위치로 변환하기 위해 globalToLocal 메소드를 사용할 수 있습니다. 이 메서드는 전역 x 및 y 값을 사용하고 대상 객체의 연결된 변환 (즉, 부모 변환 포함)을 사용하여 변환 된 x 및 y 속성이있는 객체를 반환합니다.
> To convert a global position into a local one, we can use the globalToLocal method. This method takes a global x & y value, and returns an object with x & y properties that have been transformed using the target object's concatenated transformation (ie. including its parent transformations).

```
var pt = myDisplayObject.globalToLocal(stage.mouseX, stage.mouseY);
console.log(pt.x, pt.y);
```

 이 코드는 스테이지 마우스 위치를 로컬 위치로 변환하여 콘솔에 출력합니다. 아래의 데모는이 동일한 코드를 적용하여 변형 된 모양이 마우스 아래에있을 때를 확인합니다.
> This code converts the stage mouse position into a local position and outputs it to the console. The demo below applies this same code to check when transformed shapes are under the mouse.

```
var stage, holder;
		function init() {
			stage = new createjs.Stage("demoCanvas");
			holder = stage.addChild(new createjs.Container());
			holder.x = holder.y = 150;
			
			for (var i=0; i<25; i++) {
				var shape = new createjs.Shape();
				shape.graphics.beginFill(createjs.Graphics.getHSL(Math.random()*360,100,50)).drawCircle(0,0,30);
				shape.x = Math.random()*300-150;
				shape.y = Math.random()*300-150;
				holder.addChild(shape); 
			}
			
			createjs.Ticker.on("tick", tick);
		}
		
		function tick(event) {
			holder.rotation += 3;
			var l = holder.getNumChildren();
			for (var i=0; i<l; i++) {
				var child = holder.getChildAt(i);
				child.alpha = 0.1;
				var pt = child.globalToLocal(stage.mouseX, stage.mouseY);
				if (stage.mouseInBounds && child.hitTest(pt.x, pt.y)) {
					child.alpha = 1;
				}
			}
			
			stage.update(event);
```

<hr/>

LOCALTOLOCAL
------------

 globalToLocal 메서드는 스테이지 위치를 확인하는 경우 훌륭하게 작동하지만 변형 된 다른 객체의 한 점에 대해 hitTest를 확인하려는 경우에는 어떻게해야합니까?
> This code converts the stage mouse position into a local position and outputs it to the console. The demo below applies this same code to check when transformed shapes are under the mouse.

 하나의 객체의 좌표 공간에서 다른 객체의 좌표 공간으로 포인트를 변환하기 위해 localToGlobal과 대응하는 globalToLocal을 사용할 수 있지만, localToLocal 메소드는 코드를 약간 줄여서 똑같은 작업을 수행합니다.
> You could use localToGlobal and then its counterpart globalToLocal to convert the point from one object's coordinate space to another's, but the localToLocal method does the same thing with a little less code.

```
var pt = objA.localToLocal(posX, posY, objB);
console.log(pt.x, pt.y); // the position local to objB
```

 다음 예제에서는 회전 암의 위치 (100,0)를 타겟 도형에 대한 상대적인 위치로 변환하여 해당 점이 타겟을 교차 할 때 표시하는 데 사용되는 것을 보여줍니다.
> The following example show this being used to convert a position (100,0) on a rotating arm into a position relative to a target shape, to show when that point intersects the target. 


```
var stage, arm;
		function init() {
			stage = new createjs.Stage("demoCanvas");
			
			target = stage.addChild(new createjs.Shape());
			target.graphics.beginFill("red").drawCircle(0,0,45)
				.beginFill("white").drawCircle(0,0,30)
				.beginFill("red").drawCircle(0,0,15);
			target.x = 100;
			target.y = 180;
			
			arm = stage.addChild(new createjs.Shape());
			arm.graphics.beginFill("black").drawRect(-2,-2,100,4)
				.beginFill("blue").drawCircle(100,0,8);
			arm.x = 180;
			arm.y = 100;
			
			createjs.Ticker.on("tick", tick);
		}
		
		function tick(event) {
			arm.rotation += 2;
			
			target.alpha = 0.2;
			var pt = arm.localToLocal(100,0,target);
			if (target.hitTest(pt.x, pt.y)) {
				target.alpha = 1;
			}
			
			stage.update(event);
		}
```
