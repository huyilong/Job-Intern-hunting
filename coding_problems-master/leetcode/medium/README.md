

Summary of some [LeetCode](https://oj.leetcode.com/problems/) problems marked as medium in difficulty.

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

<a name="Lists"/>

### Lists

* Linked List Cycle:

Use fast/slow runner technique. Fast and slow runner will eventually meet if a cycle exists. Otherwise, fast runner will hit null

* Swap Node Pair:

Use two pointers to adjacent nodes and link two nodes to previous swapped list

* Linked List Cycle 2:

Fast/slow runner techinuqe

* Partition List:

Use two lists to store two partitions, traverse the original list and add nodes to correct list

* Add Two Numbers:

Use two pointers


<a name="Arrays"/>

### Arrays

* Single Number:

If additional space allowed, use a hashset to store(first time) and remove(second time) elements. If space not allowed, use XOR operation since y XOR y = 0;

* Search Insert Position:n

Simple array traversal

* Minimum Rotated Sorted Array:

The first element such that arr[i-1]>arr[i] is the min element.

* Set Matrix Zeroes:

Use first row and column to mark rows and columns to be set to 0, but need to check if need to zero out first row and column first

* Rotate Matrix:

Rotate layer by layer.

* Cotainer with Most Water:

Use two pointers for left and right side of the container. Note that volume of the container always depends on the shortest side.

* Remove Duplicate from Sorted Array 2:

Use two pointers, one for inserting index, another to find next different element

* Two Sum:

Use two pointers and no additional space; Another approacth is to use hashmap to store visited value and corresponding index and check if needed counterpart is in the map

* 3 Sum:

Sort the array first, try elements in the sorted array as a, then use two pointers on the remaining right subarray to find b,c such that b+c=-a (sorting because we can consider a:small,b:mid,c:large).
Skip duplicates while moving pointers.

* 3 Sum Closest:

Similar to threeSum, just need to update final result white traversing

* 4 Sum:

Similar to 3Sum, just add another loop between outside for loop and inside while loop. Another approach: for every pair of two numbers in the array, store the sums and the index pairs in a hashmap, then perform lookup in hashmap to find two pairs that sum to the target


<a name="Strings"/>

### Strings

* Reverse Words in a String:

Use str.split("\\s+") to split on whitespaces

* Anagrams:

Sort strings first and use hashmap to store sorted string and its anagrams

* Longest Substring Without Repeating Character:

Use two pointers to bound the substring and use boolean array to mark characters used in the substring

* Longest Palindromic Substring:

Try each possible centers and keep expanding and check if palindrome exists around the center

<a name="Trees"/>

### Trees

* Binary Tree Inorder Traversal:

Use a stack to store parent nodes. Traverse to the left until reaching a leaf, then pop parent node from stack and switch to parent's right subtree.

* Binary Tree Preorder Traversal:

Use a stack to store roots. Visit root first, then store root of right subtree into stack, switch to visit left subtree until reaching a leaf, then pop right subtree from stack and visit

* Populate Next Right Pointer:

First connect two children of the same parent, then connect neighbor children of neighbor parents, and finally do recursion on left/right subtrees

* Sorted Array to BST:

Build root using middle element, and build left/right child using recursion on left/right subarrays

* Sum Root to Leaf Numbers:

Use DFS to sum from bottom up.

* BST Iterator:

Use a stack to store trace while branching to left. Switch iterator to right child after calling next() to prepare for next round.

* Path Sum 2:

Use a list to try all paths, remove the node from list to try next node


<a name="Math and Integers"/>

### Math and Integers

* Single Number 2:

Sum up bit at each position and modulo 3 to get single number

* Integer to Roman:

First build mapping between integer values and Roman numerals including subtractive notations. Then use modulo operation to convert bases to Roman numerals


<a name="Stack"/>

### Stack

* Simplify Path:

Use a stack to push directories, if see ../, then pop from stack to go back. Need to split by / first, use str.split("\\/+") to group multiple / as one.

* Reverse Polish Notation:

Use a stack to store numbers, if see an operator, pop two numbers from stack, perform the operation and push result onto stack

* BinaryTreeLevelorderZigzag:

Use two stacks, one to store node in current level and another one to store nodes in next level. Use a boolean to flag if we will visit from right next time, if so push left child first and then right child. Alternate order after visiting each level.

<a name="Dynamic Programming"/>

### Dynamic Programming

* Unique Binary Trees:

Suppose tree[i]=#trees given value i, then tree[i]+=(#left tree)*(#right tree) for each possible root value j=1,2,3..i

* Maximum SubArray:

Dynamic programming -- track max_so_far and upate max_end_here; Divide and conquer -- max(max left subarray, max right subarray, max subarray crossing midpoint)

* Best Time to Buy and Sell Stock:

Track min price to buy stock and track max profit to sell stock

* Best Time to Buy and Sell Stock 2:

Perform a transaction whenver price goes down in adjacent days


<a name="Divide and Conquer"/>

### Divide and Conquer

* Find Peak Element:

Divide-and-Conquer, check if mid element is a peak, otherwise check if mid is smaller than left/right neighbor, then left/right subarray must contain a peak element(due to locally raising)

<a name="Sorting and Searching"/>

### Sorting and Searching

* Sort Colors:

One simple approach is to do a counting sort, and rewrite the array by number of different elements. An improvement is to use two pointers pointer to the positions to insert red and blue elements. While traversing the array, move elements into its belonged region and upate boundary pointers.

* Search 2D Matrix:

First do binary search on rows and do binary search on selected rows.

* Pow(x,n):

Do a binary search on power n

* Sqrt(x):

Try numbers from 0-x using binary search

* Divide Two Integers:

 Use left-shift to double the divisor every time(, and if divisor exceeds dividend, subtract previous shifted value from divident, reset counter, and continue shifting.

* Search Rotated Sorted Array 2 (with duplicates):

In previous problem, we use A[low] <= A[mid] to confirm that A[low]~A[mid] is an increasing sequence under the condition that no duplicates exist. But now we can get the same conclusion if duplicate occurs.To improve the previous approach, just test A[low] < A[mid] to ensure increasing sequence and move low forward if A[low]=A[mid]. Alternatively, we can just do a linear scan to search for target.

* Sort List:

Use merge sort--sort left and right half list and then merge two sorted lists using two pointers. Note that merge sort approach uses recursion, which results in O(lgn) stack space.

<a name="Backtracking"/>

### Backtracking

* Permutation:

Add a origin not in the list, use recursion to generate all possible permutations starting at origin, then remove origin to try next element as origin. Once list size is equal to array length, we know we get a permutation.

* Combinations:

Similar idea to permutation, but only limit list size to k.

* Generate Parenthesis:

DFS--invariant is #left<#right, and if #left=n, can only add right parentheses. For normal cases, continue to add left parentheses and then add right parentheses

* Letter Combinations of a Phone Number:

Add origin, generate combinations, then remove origin to prepare for next element

<a name="BFS and DFS"/>

### BFS and DFS

* Word Ladder:

BFS--for words in each level, try each possible letter a-z on each position of the word; Use queue to store words in a level and use a hashset to mark visited words.
