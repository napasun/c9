var game = this.game || (this.game={});
var createjs = createjs || {};

(function(game, cjs) {
	game.speedLevels = {
		startSpeed : [0.5, 1, 1.5]
		, addSpeedTerm : 10
		, maxSpeed : lib.p.block.size - 1
	};
	game.winTimes = [60, 60,50];
	game.boardLevels = [
	  [
	    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    , [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	  ]
	  , 
	  [
	    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [1, 0, 1, 0, 1, 0, 1, 0, 1, 0]
		, [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
	  ]
	  , 
	  [
	    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		, [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
		, [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
		, [1, 0, 1, 0, 1, 0, 1, 0, 1, 0]
		, [1, 0, 1, 0, 1, 0, 1, 0, 1, 0]
		, [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
		, [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
		, [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
	  ]
	];
	
	
	var Board = game.Board = (function () {
		function Board(lev) {
			this.data = new Array(20);
			
			for (var i = 0; i < 20; i ++) {
				this.data[i] = game.boardLevels[lev][i].concat();
			}
 		}
		
		game.stageBoard = new cjs.Shape(); 
		
		Board.prototype.setup = function (lev) {
			game.stage_game.addChild(game.stageBoard);
		}
		
		Board.prototype.setLevel = function(lev) {
			this.data = new Array(20);
			
			for (var i = 0; i < 20; i ++) {
				this.data[i] = game.boardLevels[lev][i].concat();
			}
			
			if (game.boardLevels-1 < lev)
				lev = game.boardLevels-1;
			
			game.stageBoard.graphics.c().beginFill('black');
			
			for (var i = 0; i < this.data.length; i++) {
				for (var j = 0; j < this.data[i].length; j++) {
					if (this.data[i][j]) {
						
						game.stageBoard.graphics.drawRect(j * lib.p.block.size + 4
								, i * lib.p.block.size + 4
								, lib.p.block.size - 2, lib.p.block.size - 2);
					}
				}
			}
		}
		
		Board.prototype.draw = function() {
			game.stageBoard.graphics.c().beginFill('black');
			
			for (var i = 0; i < this.data.length; i++) {
				for (var j = 0; j < this.data[i].length; j++) {
					if (this.data[i][j]) {
						
						game.stageBoard.graphics.drawRect(j * lib.p.block.size + 4
								, i * lib.p.block.size + 4
								, lib.p.block.size - 2, lib.p.block.size - 2);
					}
				}
			}
		}
		
		Board.prototype.blockWallCollision = function (x, patten) {	//벽 충돌
			for (var i = 0; i < 8; i = i+2) {
				if((x / lib.p.block.size + 1) + game.Block.blockModel.patten[patten][i] > lib.p.widthCount
						|| x / lib.p.block.size + game.Block.blockModel.patten[patten][i] < 0)
					return false;
			}
			return true;
		};
		Board.prototype.blockFloorCollision = function(y) {	//바닥 충돌
			for (var i = 1; i < 8; i = i+2) {
				if((y / lib.p.block.size + 1) + game.Block.blockModel.patten[game.Block.patten][i] > lib.p.heightCount)
					return false;
			}
			return true;
		}
		
		Board.prototype.blockVerticalCollision = function (x, y) {	//블록끼리 상하 충돌
				for (var z = 0; z < 8; z = z+2) {
					if (this.data[Math.floor(y / lib.p.block.size) + game.Block.blockModel.patten[game.Block.patten][z+1] + 1]
					[Math.floor(x / lib.p.block.size) + game.Block.blockModel.patten[game.Block.patten][z]] === 1)
						return true;
				}
			return false;
		}
		
		Board.prototype.blockHorizontalCollision = function (x, y, direction) {	//블록끼리 좌우 충돌
			for (var z = 0; z < 8; z = z+2) {
				if (direction === "left" 
					&& Math.floor(x / lib.p.block.size) + game.Block.blockModel.patten[game.Block.patten][z] != 0) {
					if (this.data[Math.floor(y / lib.p.block.size) + game.Block.blockModel.patten[game.Block.patten][z+1]]
					[Math.floor(x / lib.p.block.size) + game.Block.blockModel.patten[game.Block.patten][z]-1] === 1)
						return true;
				} else if (Math.floor(x / lib.p.block.size) + game.Block.blockModel.patten[game.Block.patten][z] != 9) {
					if (this.data[Math.floor(y / lib.p.block.size) + game.Block.blockModel.patten[game.Block.patten][z+1]]
					[Math.floor(x / lib.p.block.size) + game.Block.blockModel.patten[game.Block.patten][z]+1] === 1)
						return true;
				}
			}
			return false;
		}
		
		Board.prototype.stop = function(x, y) {	//블록 하나 이동 끝
			for (var z = 0; z < 8; z = z+2) {
				var j = x / lib.p.block.size + game.Block.blockModel.patten[game.Block.patten][z];
				var i = Math.floor(y / lib.p.block.size + game.Block.blockModel.patten[game.Block.patten][z+1]);
				this.data[i][j] = 1;
			}
		
			game.scoreShape.add(100);
			//TODO 블럭 속도 올리기, 최고 속도일 경우 그대로, 스페이스 키 속도 복구
		}
		
		Board.prototype.lineRemove = function() {
			var count = 0;
			for (var i = 0; i < this.data.length; i++) {
				count = 0;
				for (var j = 0; j < this.data[i].length; j++) {
					if (this.data[i][j] == 0)
						break;
					count++;
				}
				if (count == 10) {
					for (var k = i; k > 1; k--) {
						this.data[k] = this.data[k-1].concat(); 
					}
					this.data[0] = [0,0,0,0,0,0,0,0,0,0].concat();
					game.scoreShape.add(1000);
				}
			}
		}
		
		Board.prototype.gameOver = function() {
			for (var j = 0; j < this.data[0].length; j++) {
				if (this.data[0][j]) {
					return true;
				}
			}
			return false;
		}
		
		Board.prototype.gameWin = function() {
			game.winTimes[game.flow.currentLevel]
		}
		
		return Board;
	})();
}).call(this, game, createjs);
