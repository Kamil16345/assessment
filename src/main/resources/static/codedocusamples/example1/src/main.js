var Test = function() {
    this.doc = document;
    this.win = window;
    this.body = this.doc.getElementsByTagName("body")[0];
    this.head = this.doc.getElementsByTagName("head")[0];

	this.changeButton = document.getElementById("changeButton");
	$_jsutil.dom_addEventListener(this.changeButton, "click", $_jsutil.function_bind(this.changeContent, this));
	

	//$#codeExampleStart:initialRendering
	this.canvas = document.getElementById("tutorial");
	this.context = this.canvas.getContext("2d");
	
	this.context.fillRect(0,0,150,150);
	this.context.fillStyle = "#FF0000";
	this.context.fillRect(100,100,100,100);
	//$#codeExampleEnd:initialRendering	
	

	this.interval = 30;
	this.duration = 3000;
	this.minX = -100;
	this.maxX = 300;
	
	
	this.updateCallback = $_jsutil.function_bind(this.update, this);
	this.updateCallback();
//	this.out = document.getElementById("out");
//	this.out.value = "" + this.getData();

	this.changed = false;

}

Test.prototype.update = function() {
	//$#codeExampleStart:animation
	var pos = (new Date().getTime() % this.duration) / this.duration;
	
	this.context.clearRect(0,0,600,600);
	var dx = this.maxX - this.minX;
	var x = parseInt(this.minX + pos * dx);
	
	this.paint(x);
	//console.log("pos: " + pos  + " x: " + x);
	
	this.win.setTimeout(this.updateCallback, this.interval);
	//$#codeExampleEnd:animation	
}

Test.prototype.paint = function(x) {
	//$#codeExampleStart:repaint
	this.context.fillStyle = "#FF0000";
	this.context.fillRect(x,100,100,100);		
	
	if (this.changed) {
		this.context.fillStyle = "#00FF00";
		this.context.fillRect(x,200,75,75);		
	}
	//$#codeExampleEnd:repaint	
} 

Test.prototype.changeContent = function() {
	this.changed = !this.changed;
}

Test.prototype.getData = function() {
	if (this.canvas.toDataURL) {
		return this.canvas.toDataURL();
	}
	return this.canvas.innerHTML;
}

window.onload = function() {
    test = new Test();
}
