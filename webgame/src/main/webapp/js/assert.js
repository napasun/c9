(function (lib, cjs) {
	var p;
	lib.properties = {
		keys : {
			left : 37
			, right : 39
			, up : 38
			, down : 40
			, p : 80
			, space : 32
			, enter : 13
			, esc : 27
		}
		, block : {
			size : 40
			, model : [{
					color : 'red'
					, patten : [[0, 0, 1, 0, 2, 0, 3, 0]
			    		, [1, -1, 1, 0, 1, 1, 1, 2]
			    		, [0, 0, 1, 0, 2, 0, 3, 0]
			    		, [1, -1, 1, 0, 1, 1, 1, 2]]
				}, {
					color : 'blue'
					, patten : [[0, 0, 1, 0, 0, -1, 1, -1]
						, [0, 0, 1, 0, 0, -1, 1, -1]
						, [0, 0, 1, 0, 0, -1, 1, -1]
						, [0, 0, 1, 0, 0, -1, 1, -1]]
				}, {
					color : 'green'
					, patten : [[0, 0, 1, 0, 2, 0, 1, -1]
						, [0, 0, 1, 0, 1, 1, 1, -1]
						, [0, 0, 1, 0, 2, 0, 1, 1]
						, [1, 1, 1, 0, 2, 0, 1, -1]]
				}, {
					color : 'silver'
						, patten : [[0, 0, 1, 0, 2, 0, 0, -1]
							,[-1, 0, 0, 0, 0, -1, 0, -2]
							,[-2, 0, -1, 0, 0, 0, 0, 1]
							,[0, 0, 1, 0, 0, 1, 0, 2]]
				}, {
					color : 'yellow'
						, patten : [[0, 0, 1, 0, 2, 0, 2, -1]
							, [1, 0, 2, 0, 2, 1, 2, 2]
							, [2, 0, 3, 0, 4, 0, 2, 1]
							, [2, 0, 2, -1, 2, -2, 3, 0]]
				}, {
					color : 'purple'
						, patten : [[0, 0, 1, 0, 1, -1, 2, -1]
							,[0, 0, 1, 0, 1, 1, 0, -1]
							,[0, 0, 1, 0, 1, -1, 2, -1]
					    	,[0, 0, 1, 0, 1, 1, 0, -1]]
				}, {
					color : 'lime'
						, patten : [[1, 0, 1, -1, 0, -1, 2, 0]
							,[1, 0, 0, 1, 0, 0, 1, -1]
							,[1, 0, 1, -1, 0, -1, 2, 0]
							,[1, 0, 0, 1, 0, 0, 1, -1]]
				}
			]
		}
		, gameScreen : {
			stroke : 2
			, strokeColor : 'black'
			, x : 2
			, y : 2
		}
		, fps : 40
		, widthCount : 10
		, heightCount : 20
	};
	
	
	(lib.Backgroud = function() {
		this.initialize();
		
		this.gameScreen = new cjs.Shape();
		this.gameScreen.graphics
			.setStrokeStyle(lib.properties.gameScreen.stroke)
			.beginStroke(lib.properties.gameScreen.strokeColor)
			.drawRect(lib.properties.gameScreen.x
					, lib.properties.gameScreen.y
					, lib.properties.block.size * lib.properties.widthCount + lib.properties.gameScreen.stroke
					, lib.properties.block.size * lib.properties.heightCount + lib.properties.gameScreen.stroke);
		
		this.addChild(this.gameScreen);
	}).prototype = p = new cjs.Container();
	
	(lib.Title = function() {
		this.initialize();
		
		this.title = new createjs.Text("Tetris", '48px Impact', 'black');
	    this.title.textBaseline = 'middle';
	    this.title.textAlign = 'center';
	    this.title.x = lib.properties.block.size * lib.properties.widthCount/2;
	    this.title.y = lib.properties.block.size * lib.properties.heightCount/5;
	    
		this.addChild(this.title);
	}).prototype = p = new cjs.Container();
	
	(lib.StartText = function() {
		this.initialize();
		
		this.startText = new cjs.Text("Game Start", '40px Impact', 'blue');
		
		this.startText.textBaseline = 'middle';
		this.startText.textAlign = 'center';
		this.startText.x = lib.properties.block.size * lib.properties.widthCount/2;
		this.startText.y = lib.properties.block.size * lib.properties.heightCount/2 - 30;
	    
		this.startText.addEventListener('click', game.flow.startGame);
		this.startText.addEventListener('mouseOver', function(event) {
	    	console.log('mouseOver');
	    });
		
		this.addChild(this.startText);
	}).prototype = p = new cjs.Container();
	
	(lib.FinishText = function() {
		this.initialize();
		
		this.finishText = new cjs.Text("Game Over", '48px Impact', 'black');
		
		this.finishText.textBaseline = 'middle';
		this.finishText.textAlign = 'center';
		this.finishText.x = lib.properties.block.size * lib.properties.widthCount/2;
		this.finishText.y = lib.properties.block.size * lib.properties.heightCount/2 - 30;
		
		this.addChild(this.finishText);
	}).prototype = p = new cjs.Container();
	
	(lib.RegameText = function() {
		this.initialize();
		
		this.RegameText = new cjs.Text("Regame", '30px Impact', 'blue');
		
		this.RegameText.textBaseline = 'middle';
		this.RegameText.textAlign = 'center';
		this.RegameText.x = lib.properties.block.size * lib.properties.widthCount/2;
		this.RegameText.y = lib.properties.block.size * lib.properties.heightCount/4 * 3 - 40;
		this.RegameText.addEventListener('click', game.flow.startGame);
		
		this.addChild(this.RegameText);
	}).prototype = p = new cjs.Container();
	
	(lib.ExitText = function() {
		this.initialize();
		
		this.exitText = new cjs.Text("Exit", '30px Impact', 'red');
		
		this.exitText.textBaseline = 'middle';
		this.exitText.textAlign = 'center';
		this.exitText.x = lib.properties.block.size * lib.properties.widthCount/2;
		this.exitText.y = lib.properties.block.size * lib.properties.heightCount/4 * 3;
		this.exitText.addEventListener('click', game.flow.startOver);
		
		this.addChild(this.exitText);
	}).prototype = p = new cjs.Container();
	
	(lib.Des = function() {
		this.initialize();
		
		this.des = new createjs.Text("P버튼 정지\n\nSpace 내리기", '24px Impact', 'black');
	    this.des.textBaseline = 'middle';
	    this.des.textAlign = 'center';
	    this.des.x = lib.properties.block.size * lib.properties.widthCount/2;
	    this.des.y = lib.properties.block.size * lib.properties.heightCount/6 * 4;
	    
		this.addChild(this.des);
	}).prototype = p = new cjs.Container();
	
	(lib.TestScreen = function () {
		this.initialize();
		
		this.testBlock = new createjs.Shape();
	    this.testBlock.graphics
	    .beginFill("red");
	    
	    for (var i = 0; i < lib.properties.widthCount; i++) {
	    	for (var j = 0; j < lib.properties.heightCount; j++) {
	    		this.testBlock.graphics.drawRect(lib.properties.block.size*i + lib.properties.gameScreen.stroke*2
	    				, lib.properties.block.size*j + lib.properties.gameScreen.stroke*2
	    				, lib.properties.block.size - 2
	    				, lib.properties.block.size - 2);
	    	}
	    }
	    
	    this.addChild(this.testBlock);
	}).prototype = p = new cjs.Container();
	lib.p = lib.properties;
})(lib = lib||{}, createjs = createjs||{});
var lib, createjs;