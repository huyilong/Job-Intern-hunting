# Bucket Sort

+ Idea
  - partition array into buckets
  - sort each bucket, or recursively call bucket sort
  - merge sorted buckets

+ Optimization
  - first partition into unsorted buckets, put unsorted elements in the buckets into the original array, then run insertion sort over the entire array
    + insertion sort's performance is based on how far element is from its final position in sorted order
    + cache friendly because of contiguous use of memory

+ Variants
  - Generic bucket sort
    + find max, divide into n buckets with size M/n
    + use insertion sort in each bucket
    + expected linear time
    + bad performance when many elements fall into a single bucket(clustering)
  - Histogram sort(counting sort)
    + first count the number of elements that will fall into each bucket
    + use the information to arrange buckets in place
    + no space overhead for bucket storage

+ Analysis
  - when bucket size is 1, equivalent to counting sort
  - when use two buckets, equivalent to quick sort, but random choice of pivot in quicksort makes it more resistant to clustering problem
  


