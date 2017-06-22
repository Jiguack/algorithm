var _ = require('underscore');

const COUNT = 10;
const MIN = 1;
const MAX = 100000;

var values = [];
var count = 0;

function getRandomInt() {
  return Math.floor(Math.random() * (MAX - MIN)) + MIN;
}


function makeValues(count) {
  for(var i = 0; i < count; i++)
    values.push(getRandomInt());
}

function mergeSort(a) {
  if (a.length < 2)
    return a;

  var mid = 0;
  var leftArray = 0;
  var rightArray = 0;

  mid = a.length / 2;

  leftArray = a.slice(0, mid); //mid-th is not included
  rightArray = a.slice(mid, a.length);

  return merge(mergeSort(leftArray), mergeSort(rightArray));
}

function merge(left, right) {
  var result = [];
  while (left.length && right.length) {
    count++;
    if (left[0] > right[0]) {
      result.push(right[0])
      right.shift();
    } else {
      result.push(left[0])
      left.shift();
    }
  }

  if (left.length)
    result = result.concat(left)

  if (right.length)
    result = result.concat(right)

  return result;
}

count = 0;
makeValues(COUNT);
console.log(values)
var result = mergeSort(values)
console.log(result)
console.log('=>'+ count)
