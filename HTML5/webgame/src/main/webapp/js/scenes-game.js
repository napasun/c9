var game = this.game || (this.game={});
var createjs = createjs || {};

(function(game, cjs) {
	var gameScene = game.gameScene = Object.create(scene);
	gameScene.node = document.getElementById('game-scene');
	gameScene.block = null;
	gameScene.setup = function() 
	{
		window.onkeydown = function(e) {
			if (e.keyCode === lib.p.keys.left) {
				if (game.board.blockWallCollision(gameScene.block.x - lib.p.block.size, game.Block.patten)
						&& !game.board.blockHorizontalCollision(gameScene.block.x, gameScene.block.y, "left"))
					gameScene.block.x -= lib.p.block.size
			} else if (e.keyCode === lib.p.keys.right) {
				if (game.board.blockWallCollision(gameScene.block.x + lib.p.block.size, game.Block.patten)
						&& !game.board.blockHorizontalCollision(gameScene.block.x, gameScene.block.y, "right"))
					gameScene.block.x += lib.p.block.size
			} else if (e.keyCode === lib.p.keys.down) {
					gameScene.block.y += 15
			} else if (e.keyCode === lib.p.keys.up) {
					//TODO 다시 그리기 개선 가능한 지 확인
					if (game.board.blockWallCollision(gameScene.block.x, game.Block.patten+1 == 4 ? 0 : game.Block.patten+1)){
						
						game.Block.patten += 1;
						if (game.Block.patten === 4) {
							game.Block.patten = 0;
						}
						
						gameScene.block.children[0].graphics.c()
						.f(game.Block.blockModel.color)
						.dr(lib.p.block.size * game.Block.blockModel.patten[game.Block.patten][0] + 4
								, lib.p.block.size * game.Block.blockModel.patten[game.Block.patten][1] + 4
								, lib.p.block.size - 2, lib.p.block.size - 2)
						.dr(lib.p.block.size * game.Block.blockModel.patten[game.Block.patten][2] + 4
								, lib.p.block.size * game.Block.blockModel.patten[game.Block.patten][3] + 4
								, lib.p.block.size - 2, lib.p.block.size - 2)
						.dr(lib.p.block.size * game.Block.blockModel.patten[game.Block.patten][4] + 4
								, lib.p.block.size * game.Block.blockModel.patten[game.Block.patten][5] + 4
								, lib.p.block.size - 2, lib.p.block.size - 2)
						.dr(lib.p.block.size * game.Block.blockModel.patten[game.Block.patten][6] + 4
								, lib.p.block.size * game.Block.blockModel.patten[game.Block.patten][7] + 4
								, lib.p.block.size - 2, lib.p.block.size - 2);
					}
			} else if (e.keyCode == lib.p.keys.space) {
				gameScene.block.speed = game.speedLevels.maxSpeed;
			} else if (e.keyCode == lib.p.keys.p) {
				cjs.Ticker.setPaused(!cjs.Ticker.getPaused());
			}
			//game.stage_game.update();	//프레임이 낮을 경우 적용
			e.preventDefault();

			return false;
		};

		//게임화면 그리기
		game.stage_game.addChild(new lib.Backgroud);
		game.stage_game.addChild(game.scoreShape);
		
		game.board.setup();
	   
		gameScene.block = new game.Block();
		gameScene.block.speed = game.speedLevels.startSpeed[game.flow.currentLevel];
		game.stage_game.addChild(gameScene.block);
		
		game.stage_game.update();
	};

	gameScene.blockAdd = function() {
		gameScene.block = new game.Block();
		gameScene.block.speed = game.speedLevels.startSpeed[game.flow.currentLevel];
		game.stage_game.addChild(gameScene.block);
	};
	gameScene.blockCollision = function() {
		if (!game.board.blockFloorCollision(gameScene.block.y)
				|| game.board.blockVerticalCollision(gameScene.block.x, gameScene.block.y)) {
			game.board.stop(gameScene.block.x, gameScene.block.y);
			game.board.lineRemove();
			game.board.draw();
			
			game.stage_game.removeChild(gameScene.block);
			
			if (game.board.gameOver()) {
				game.flow.gameOver();
			}
			
			gameScene.blockAdd();
		}
	};
}).call(this, game, createjs);
