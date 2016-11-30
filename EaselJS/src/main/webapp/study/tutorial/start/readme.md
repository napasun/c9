# EASELJS 시작하기


### SETTING UP YOUR HTML DOCUMENT

```
<!DOCTYPE html>
<html>
<head>
    <script src="http://code.createjs.com/easeljs-0.8.1.min.js"></script>
    <script>
        function init() {
            // code here.
        }
    </script>
</head>
<body onload="init();">
    <canvas id="demoCanvas" width="500" height="300">
        alternate content
    </canvas>
</body>
</html>
```

The script tag on line 4 includes the EaselJS library in our document so that we can work with it. We have a few options for how we do this:

1. link to a local copy of the compiled library.
2. link to the compiled library on the the CreateJS CDN (as in this example). This allows the library to be cached for users across all sites that use the library, but only stable versions of the library are available.
3. link to individual, uncompiled source files (in the /src/ directory). This can be very useful for debugging and learning about the library, because you will get more useful errors. However, you must make sure they are loaded in the correct order, which you can find in /build/config.js

The script tag on line 5 contains an empty function that will be called when the page loads. Line 7 is where we are going to put the javascript we'll be writing a bit later.

The canvas tag on line 12 has an id so that we can reference it easily, and a defined width and height. It's important to understand that the width & height attributes here set the pixel dimensions of the canvas. If you change the width & height with CSS, it will scale the canvas and your graphics could look fuzzy or pixelated.



### SETTING UP THE STAGE

```
var stage = new createjs.Stage("demoCanvas");
```

This line creates a new Stage and points it at our canvas. The stage contains all of the display objects we will be painting to our canvas. You can either pass the ID of the canvas you want to use, or a reference to it.

You'll notice that the Stage class definition is inside of the createjs namespace. This keeps all of the classes in CreateJS from colliding with other libraries' classes. You can configure this namespace if you like, just point the createjs var somewhere else before loading the library.



### CREATING A SHAPE

Next, we'll create a Shape object, tell it to draw a red circle, position it, and add it to our stage.

```
var circle = new createjs.Shape();
circle.graphics.beginFill("red").drawCircle(0, 0, 50);
circle.x = 100;
circle.y = 100;
stage.addChild(circle);
```

Line 1 creates a new Shape instance. Shapes are display objects that draw vector graphics to our canvas. All display objects share common properties for positioning and transforming them on the canvas, such as x & y on lines 3 & 4.

Shapes also have a special property called graphics, which points to a Graphics instance, which holds all of the methods we use to define our vector shapes. In this case, we are telling the graphics object to draw a circle with radius 50, centered at 0,0 (relative to the shape's position), and filled with red.

In order for a display object to be drawn, we need to add it to the stage, as shown in line 5.

EaselJS also supports shortcuts to let you chain together your calls. In fact, if you really wanted to you could write all of the above code in a single line:

```
stage.addChild(new createjs.Shape()).set({x:100,y:100}).graphics.f("red").dc(0,0,50);

```


### UPDATING THE STAGE

We've set up our display list, but it isn't drawn to the canvas until we tell the stage to update:

```
stage.update();
```

This tells the stage to clear the canvas, then run through all of its children and draw them to the canvas. You can see the working demo below. Be sure to open it up and check out the complete code.


