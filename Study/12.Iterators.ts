namespace s12 {
// for ..in은 키목록을 반환한다.
// for ..of는 속성값을 반환한다.
let list = [4, 5, 6];

for (let i in list) {
   console.log(i); // "0", "1", "2",
}

for (let i of list) {
   console.log(i); // "4", "5", "6"
}


}