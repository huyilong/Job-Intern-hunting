# Breadth First Search

+ Word Ladder(edit distance between two words)
  - use two queues: one to store explored words, another to store corresponding distances
  - every time, poll one word from queue, try each character for each position, if new word is in dictionary, store it and its distance into queues
  - repeat until target found

+ Word Ladder2 (find all paths for word transformation)




+ Surrounded Region
  - if a spot is connected to spots on the border, then it does not belong to surrounded region
  - scan all spots on the border and perform BFS to mark all connected spots with some special character #, then after scanning, rest of spots belong to the surrounded region
  - set spots in surrounded region to other character, reset # to original character

+ Clone Graph
  - use a queue to store neighbors to visit
  - use a hashmap to store (original, copy) pairs
  - when visiting a node, if its neighbor has been copied and therefore in the hashmap, simply add the copy to node's neighbor list; otherwise make a copy of its neighbor and store into the map and enqueue the neighbor

+ Binary Tree Level Order Traversal
  - use two queues: one to store nodes at current level, another to store child nodes for the next level
  - use a list to store nodes at a level to add it to result list after finishing traversing a level
  - use BFS, after completing a level, update currLevel to be nextLevel, add list of nodes to result

+ Binary Tree Level Order Bottom
  - use same method above, but keep adding level list to the front of result list
  + recursive approach
    - use result list to retrieve corresponding list for current visiting level
    - create a new list for the level if not exist before; otherwise, use index to retrieve from the result list
    - recursively call function on left and right child

+ Binary Tree Zig Zag Level Order
  - use two stacks to store nodes in current and next level
  - use a boolean to track traversing order of current level (left to right, or right to left), flip the value for each level
  - if order of current level is from left to right, first push left child and then right child; otherwise, do the opposite


+ Some tips
  - to store position (i,j), we can either store it as a pair or we can store it as a code; for example, we can compute code as `code = i*col+j`, then to retrieve position information, we can compute `rowIdx(i) = code/col` and `colIdx(j) = code%col`
  - before clearing contents, make a copy if we want to store contents elsewhere
