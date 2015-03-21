LeetCode-Easy
========

Contents:

- [Lists](#Lists)

- [Arrays](#Arrays)

- [Strings](#Strings)

- [Trees](#Trees)

- [Math and Integers](#Math and Integers)

- [Stack](#Stack)

- [Dynamic Programming](#Dynamic Programming)

<a name="Lists"/>

### Lists

* Intersection of two LinkedLists

If the problem allows us to mark the nodes visited, then we can simply mark the nodes as we traverse the list. Once a list sees a visited node, then it is the intersection. However, if this is not allowed, we can first count the number of nodes in each list(len1 and len2), and then compute the difference(diff=len1-len2). Then we move the head of the longer list diff steps ahead so that now two lists have same length left. Then we start to traverse the two lists at the same speed. Once they reach at the same node, then it is the intersection.

* Remove Nth Node from the End of List

Use two pointers with one is always n steps ahead of another. Move two pointers at the same speed until find the nth last node.

* Merge Sorted List

Use two pointers, one on each list.

* Remove Duplicates Sorted List

Use two pointers, one points to the node before duplicate, another to find next different element.


<a name="Arrays"/>

### Arrays

* Majority Element:

One approach is to use two loops to find maxCount and corresponding element(or use hashmap to store frequency for each element).
Another approach is to use Moore's Voting algorithm, which operates in O(n) time. 

* Remove Element:

Use two pointers(front and tail). If element found, replace it with tail element and move tail pointer backward. Otherwise, move front pointer forward.

* Merge Sorted Array

Use two pointers, one on each array, and add larger element to the end of longer array.

* Valid Sudoku

Simple matrix traversal and check each rule


<a name="Strings"/>

### Strings

* Compare two version numbers:

First, we can use str.split("\\.") to split on dots and then compare the versions. Note that two version can have different length.

* String to Integer:

First, we need skip some leading whitespace if necessary(Character.isWhitespace(str.charAt(i))). Then determine the sign. To compute integer value, find last digit and append it to the result. At every step, we need to check if current result overflows. To be more specific, before evaluating num = num*10 + lastDigit, we need to check if num>Integer.MAX_VALUE/10 or num==Integer.MAX_VALUE && lastDigit>=8. If so, overflow/underflow occurs.

* Longest Common Prefix:

Simply scan each character of each string at the same time. 

* Valid Palindrome

One approach is to use StringBuffer to build a string without non-alphanumeric values and use two pointers to compare. Another approach to directly use two pointers to compare and skip any non-alphanumeric values. 

* Length of Last Word

Split by whitespace using str.split("\\s+") 

* Count and Say

Append result to StringBuffer when reach a different element

* Implement strStr()

Use two pointers, one for each string. Use two loops to compare characters.

* ZigZag Conversion

For the first and last row, step size is 2(nRows-1); For ith middle row, step size is adjusted by 2i


<a name="Trees"/>

### Trees

* Balanced Binary Tree: 

One approach is to compute dpeth and recursively call the method on subtrees, and this will take O(n) space and O(n^2) time. But this is not very efficient because we have repeatedly compute depth for some nodes. To make it more efficient, instead of returning a boolean, we can use a helper function return an integer(-1 for not balance and non-zero value for depth). Now this will take O(n) time.

* Path Sum:

This problem only deals with root-to-leaf path. So we can recursively call on left/right subtrees with reduced sum. Note that the base case is to check if current node is a leaf and if sum becomes zero.

* Max Depth Binary Tree:

Simply use rcursion

* Min Depth Binary Tree:

Two ways to consider this problem: DFS and BFS. To do DFS, we use recursion. If a node is a leaf, min depth is 1. If a node has an empty subtree and a non-empty subtree, compute depth of the non-empty subtree. To ignore computing the depth of empty subtree, one approach is to use control flow(if-statement) and another way is to return Integer.MAX_VALUE and be ignored when performing Math.min() function. To do BFS, return depth once we reach a leaf. BFS works well when tree is highly unbalanced because we don't need to traverse to the end.

* Same Tree:

Simply use recursion

* Binary Tree Level Order Traversal:

Use a queue to store nodes at a level, while polling nodes from current level, enqueue children on the next level

* Binary Tree Level Order Traversal 2:

Simliar to solution above, just reverse the order when appending to the final result

* Symmetric Tree:

Create a helper function to check if two trees(t1 and t2) are symmetric(t1.lefttree=t2.righttree and t1.righttree==t2.lefttree)


<a name="Math and Integers"/>

### Math and Integers

* Reverse Integer:

To do this, we simply use the modulo and division to find the last digit and append it to the result. But we also need to take care of the case when overflow/underflow occurs. 

* Palindrome Number:

There are several general approach to consider: (a)convert to string and then manipulate (b) reverse the integer and then compare; to combat the overflow/underflow, consider store value into a type larger than int. However, the best approach is to compare two ends at the same time and then chopping them off from the integer. First, we compute the order of the highest digit using a while loop. To chop off the highest and lowest digit, do num=(num%order)/10 and order/=100.

* Roman to Integer:

Simply follow the definition but need to take care of subtractive notation.

* Pascal's Triangle:

Use the patter: currentList(i) = prevList(i-1) + prevList(i) except currList(1)=currList(end)=1

* Pascal's Triangle 2:

One approach is to use the same patter as above and return just the specified row. Another optimized solution is to use C(n,k+1) = C(n,k)*(n-k)/(k+1).

* Excel Sheet Column Number

Equivalent to base-26 calculation(A-1, B-2, ...)

* Excel Sheet Column Title

Convert decimal to base-26 and assign corresponding letter

* Factorial Trailing Zeros

Note that one pair of 2 and 5 makes a trailing zero, so just count number of factor 2 and 5 in numbers from 1 to n.

* Plus One

Add one to the lowest digit, if carry on, add 1 to higher digit. If all digits are 9, add a digit 1 at the front.

* Add Binary

Simply follow binary operation, use StringBuffer


<a name="Stack"/>

### Stack

* Min Stack:

We can use two stacks: one(s1) to store data, another(s2) to track min element. Whenever we push an element to stack, check the top element of s2. If it is larger than or equal to the pushed element, then we have a new min element, so also push it to s2. Whenever pop from s1, we also need to check with s2 to see if the element popped is the min element. If so, pop it from s2.

* Valid Parentheses:

While traversing the string, if see a left parentheses, push it to stack; if see a right parentheses, compare it to the top element from stack to check if matched. 


<a name="Dynamic Programming"/>

### Dynamic Programming

* Climb Stairs

Suppose arr[i] = number of ways to climb n steps in either one or two steps, then arr[i] = arr[i-1] + arr[i-2]

