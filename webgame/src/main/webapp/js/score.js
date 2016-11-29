(function (score, cjs) {
	var s;
	(score.Score = function() {
		this.initialize();
		
		this.score = new createjs.Text("0", '24px Impact', 'black');
		this.score.textBaseline = 'middle';
	    this.score.textAlign = 'center';
	    this.score.x = lib.p.block.size * lib.p.widthCount + 100;
	    this.score.y = 30;
	    
	    this.addChild(this.score);
	}).prototype = s = new cjs.Container();
	
	score.Score.prototype.init = function(n) {
		this.children[0].text = 0;
	}
	
	score.Score.prototype.add = function(n) {
		this.children[0].text = Number(this.children[0].text) + n;
	}
	
})(score = score||{}, createjs = createjs||{});
var score, createjs;