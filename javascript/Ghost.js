var Ghost = function() {
    this.color = ["white","yellow","purple","red"][Math.floor(Math.random() * 4)];
};
​
ghost = new Ghost();
ghost.color //=> "white" or "yellow" or "purple" or "red"