var game = this.game || (this.game={});
var createjs = createjs || {};

(function(game, cjs){
	game.canvas_start = document.getElementById('canvas_start');
	game.canvas_game = document.getElementById('canvas_game');
	game.canvas_finish = document.getElementById('canvas_gameover');
	
	game.stage_start = new cjs.Stage(game.canvas_start);
	game.stage_game = new cjs.Stage(game.canvas_game);
	game.stage_finish = new cjs.Stage(game.canvas_finish);
	game.board = new game.Board(0);
	game.scoreShape = new score.Score();
	game.speed = 0;
	game.winCount = 0;
	game.winGoal = 0;
	
	game.flow = {
			currentLevel : 0,
			startOver: function() {		//시작화면
				game.startScene.show();
				game.gameScene.hide();
				game.gameOverScene.hide();
			},
			startGame: function() {		//게임화면
				game.winCount = 0;
				game.winGoal = game.winTimes[game.flow.currentLevel];
				game.board.setLevel(game.flow.currentLevel);
				game.speed = game.speedLevels.startSpeed[game.flow.currentLevel];
				cjs.Ticker.setPaused(false);
				game.startScene.hide();
				game.gameScene.show();
				game.gameOverScene.hide();
			},
			gameOver: function() {		//게임오버
				cjs.Ticker.setPaused(true);
				game.scoreShape.init();
				game.startScene.hide();
				game.gameScene.hide();
				game.gameOverScene.show();
			},
			nextLevel: function() {
				game.flow.currentLevel += 1;
				game.board.setLevel(game.flow.currentLevel);
				this.startGame();
			}
	}

	var init = function() {
		//game.winGoal = game.winTimes[game.flow.currentLevel];
		
		cjs.EventDispatcher.initialize(game);
		
		game.startScene.setup();
		game.gameScene.setup();
		game.gameOverScene.setup();
		
		cjs.Ticker.setPaused(true);
		cjs.Ticker.setFPS(lib.p.fps);
		cjs.Ticker.addEventListener('tick', game.stage_game);
		cjs.Ticker.addEventListener('tick', game.tick);
	}
	
	
	game.tick = function(){
		if (cjs.Ticker.getPaused()) { return; }
		
		game.gameScene.block.blockMove();
		game.gameScene.blockCollision();
		
		
		/*game.winCount += 1;
		
		if (game.winCount >= game.winGoal) {
			game.flow.nextLevel();
		}*/
		
		game.stage_game.update();
	};
	
	init();
}).call(this, game, createjs);


/**
 * TODO
 * 시간
 * 스테이지 처리, 스테이지 클리어 조건
 * 블록 미리보기
 * 블록 떨어지는 속도 증가 
 * 스코어 이너DB
 * 무한모드
 * 컴퓨터 대전
 */