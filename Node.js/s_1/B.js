module.exports.name = 'B';

module.exports.run = function (name) {
    this.name = name;
    console.log(name + " is running...");
}

exports.stop = function () {
    console.log(this.name + " is stopped!");
}