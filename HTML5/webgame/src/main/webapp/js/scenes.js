var game = this.game || (this.game={});
var createjs = createjs || {};

var scene = {
		node: document.querySelector('.scene'),
		show: function() {
			this.node.classList.remove('out');
			this.node.classList.add('in');
		},
		hide: function() {
			this.node.classList.remove('in');
			this.node.classList.add('out');
		}
};

(function(game, cjs) {
	var startScene = game.startScene = Object.create(scene);
	startScene.node = document.getElementById('start-scene');
	startScene.setup = function() {
		game.stage_start.addChild(new lib.Backgroud);
		game.stage_start.addChild(new lib.Title);
		game.stage_start.addChild(new lib.StartText);
	    game.stage_start.addChild(new lib.Des);
	    
	    game.stage_start.enableMouseOver();
	    game.stage_start.update();
	};

	var gameOverScene = game.gameOverScene = Object.create(scene);
	gameOverScene.node = document.getElementById('gameover-scene');
	gameOverScene.setup = function() {
		game.stage_finish.addChild(new lib.Backgroud);
		game.stage_finish.addChild(new lib.FinishText);
		game.stage_finish.addChild(new lib.RegameText);
		game.stage_finish.addChild(new lib.ExitText);
		
		game.stage_finish.update();
	};
}).call(this, game, createjs);