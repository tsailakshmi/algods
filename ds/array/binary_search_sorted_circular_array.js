// Binary Search on a Sorted Circular Array.
var input = [9, 10, 1, 2, 3, 4, 5, 6, 7, 8];

function binarySearch (arr, ele, firstIndex, lastIndex) {
  if (!arr || !arr.length || (lastIndex < firstIndex))
    return -1;

  var middleIndex = Math.ceil((firstIndex + lastIndex)/2);
  
  var firstElement = arr[firstIndex];
  
  if (arr[middleIndex] == ele) {
    return middleIndex;
  }
  
  var subArrayLength = firstIndex + lastIndex + 1;
  if (subArrayLength == 1)
    return -1;
  
  if (ele >= firstElement || ele < arr[middleIndex]) {
    return binarySearch(arr, ele, firstIndex, middleIndex - 1);
  } else {
    return binarySearch(arr, ele, middleIndex + 1, lastIndex);
  }
}


console.log("1 -> " + binarySearch(input, 1, 0, input.length - 1));
console.log("11 -> " + binarySearch(input, 11, 0, input.length - 1));
console.log("10 -> " + binarySearch(input, 10, 0, input.length - 1));
console.log("-1 -> " + binarySearch(input, -1, 0, input.length - 1));
console.log("9 -> " + binarySearch(input, 9, 0, input.length - 1));

