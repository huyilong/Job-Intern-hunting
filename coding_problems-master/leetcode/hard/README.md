

Summary of some [LeetCode](https://oj.leetcode.com/problems/) problems marked as hard in difficulty.

Solutions are on my [Github](https://github.com/startupjing/coding_problems)

<!-- more -->

Contents:

- [Lists](#Lists)

- [Arrays](#Arrays)

- [Strings](#Strings)

- [Trees](#Trees)

- [Math and Integers](#Math and Integers)

- [Stack](#Stack)

- [Dynamic Programming](#Dynamic Programming)

- [Sorting and Searching](#Sorting and Searching)

- [Backtracking](#Backtracking)

- [BFS and DFS](#BFS and DFS)


<a name="Arrays"/>

### Arrays

* Trapping Rain Water:

Set bar separately from left and right. Then for each position i, the volume of water stored at the position is min(left,right)-arr[i]


<a name="Trees"/>

### Trees

* Binary Tree Postorder Traversal:

Use stack to store parent nodes and mark last visiited node. When parent node is not null, keep branching to the left; Otherwise, if last visit node is coming from left child and right child is not null, then switch to traverse the right subtree. If not, visit parent.



<a name="Sorting and Searching"/>

### Sorting and Searching

* Search Rotated Sorted Array:

Compare middle element and left/right boundary element to knwo if the subarray is sorted, then check if element is in the sorted array, otherwise change to search in the other array

