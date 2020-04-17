function Cube(n) {
    var side = 0;


    this.getSide = function() { return side; };
    this.setSide = function(n) {
        if (isNaN(n) === true) { return; }
        side = Math.abs(n);
    };


    if (n===undefined)
        this.setSide(0);
    else
        this.setSide(n);
};


var c = new Cube(10);
c.getSide(); // this should be 10
//c = new Cube();
//c.getSide(); // this should be 0