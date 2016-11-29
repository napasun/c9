(function(){
	var game = this.game || (this.game={});
  
	game.BlockShape = (function() {	//블록 하나 그리기
	  function BlockShape(num, patten) {
		  createjs.Container.call(this);
		  game.Block.blocknum = num;
		  
		  game.Block.blockModel = lib.p.block.model[num];
		  
		  var shape = new createjs.Shape()
		  
		  shape.graphics
		  	.f(game.Block.blockModel.color)
		  	.dr(lib.p.block.size * game.Block.blockModel.patten[patten][0] + 4
					,lib.p.block.size * game.Block.blockModel.patten[patten][1] + 4
					, lib.p.block.size - 2, lib.p.block.size - 2)
			.dr(lib.p.block.size * game.Block.blockModel.patten[patten][2] + 4
					,lib.p.block.size * game.Block.blockModel.patten[patten][3] + 4
					, lib.p.block.size - 2, lib.p.block.size - 2)
			.dr(lib.p.block.size * game.Block.blockModel.patten[patten][4] + 4
					,lib.p.block.size * game.Block.blockModel.patten[patten][5] + 4
					, lib.p.block.size - 2, lib.p.block.size - 2)
			.dr(lib.p.block.size * game.Block.blockModel.patten[patten][6] + 4
					,lib.p.block.size * game.Block.blockModel.patten[patten][7] + 4
					, lib.p.block.size - 2, lib.p.block.size - 2);
			
			
			this.addChild(shape);
	  }
	  BlockShape.prototype = Object.create(createjs.Container.prototype);

	  return BlockShape;
  }) ();
}).call(this);

(function(){
	var game = this.game || (this.game={});

	var Block = game.Block = (function(){
		function randomInt() {
	        return Math.floor(Math.random() * 7);
	    }
		
		function Block(){
			game.Block.patten = 0;
			game.BlockShape.call(this, randomInt(), Block.patten);
		}
		
		var p = Block.prototype = Object.create(game.BlockShape.prototype);
		
		Block.prototype.blockMove = function() {
			this.y += this.speed;
		}
		
		Block.prototype.speed = 0;
		
		return Block;
	})();
}).call(this);