# Sorting Algorithms

+ O(n^2) algorithms
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
+ O(nlogn) algorithms
  - Merge Sort
+ O(n) algorithms
  - Bucket Sort

### Bucket Sort
+ The idea is to partition an array into a number of buckets, and each bucket is sorted individually either using another sorting algorithm or recursively apply bucket sort.

+ The procedure is as follow:
  - set up an array of empty bucekts
  - go through original array, put each element in corresponding bucket
  - sort each non-empty bucket
  - visit buckets in order and put elements back into original array

+ Analysis
  - Time O(n)
  - Space O(n)

+ Drawbacks
  - how to handle duplicates: store duplicates into linkedlist or counting sort
  - must know min and max value in the original array
  - enough memory


### Bubble Sort
+ The idea is to compare each item wth the item next to it, and swap positions if needed. The algorithm repeats until we have a pass without swapping any elements.

+ Analysis
  - Time O(n^2);
  - Space O(1)

### Selection Sort
+ The idea is to select the smallest element of remaining array and then swap it to the front.

+ Analysis 
  - Time O(n^2)
  - Space O(1)


### Insertion Sort
+ The idea is to remove one entry at a time and insert it into the correct position in the sorted part.

+ Analysis 
  - Time O(n^2)
  - Space O(1)

### Merge Sort
+ Use divide and conquer paradigm
+ Procedure
  - divide array into two subarrays
  - sort each subarray
  - merge sorted subarrays into one
+ Analysis
  - Time O(nlogn)
  - Space O(nlogn)

