function f1() {
    document.writeln("f1() was called </br>")
    f2()
    document.writeln("f1() is returning </br>")
}
function f2() {
    document.writeln("f2() was called </br>")
    f3()
    document.writeln("f2() is returning </br>")
}
function f3() {
    document.writeln("f3() was called </br>")
    document.writeln("f3() is returning </br>")
}

f1()

cardstack = [ ]
cardstack.push("5 of diamonds")
console.log(cardstack, "</br>")
cardstack.push("2 of spades")
console.log(cardstack, "</br>")
cardstack.push("jack of hearts")
console.log(cardstack, "</br>")
cardstack.push("ace of clubs")
console.log(cardstack, "</br>")
cardstack.pop()
console.log(cardstack)