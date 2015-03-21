CC150 chap4: Trees and Graphs
========

## Check if a binary tree is balanced
* recursively check on left/right subtree
* more efficiently, use a helper function to return actual height if balanced and return -1 otherwise

## Check if a binary tree is a BST
* use in-order traversal: next element must be larger than current element
* recursively check if current element is in allowed range

## Given a sorted array, create a BST with minimum height
* use middle element in the array as root
* recursively create subtree on left/right subarray

## Generate a linkedlist for nodes at each level
* BFS: for each level, visit parents current level, then find children at next level
* pre-order: recursively build list for each level

## Determine if there is a route between two nodes in a directed graph
* BFS approach
* remember to mark node visited to avoid loop

## Find in-order successor of a node in the tree
* if node has right subtree, then return leftmost child of right subtree
* if node does not have right subtree, then
  (a) if node is its parent's left child, then return parent node
  (b) if node is right child, then return untraversed ancestor node

## Find first common ancestor of two given nodes in bianry tree
* if node has a link to parent, keep move up along the tree and mark parent as visited until one node reaches a visited parent
* if node has no link to parent, starting from the root, keep branching until two nodes are on different subtree
* if no link to parents, define a function that 
       (a) return x(y) if subtree has x but not y(x)
       (b) return null if subtree doesn't have both x and y
       (c) otherwise, return common ancestor

## Determine if a small binary tree is a subtree of a large binary tree
* use tree traversal: if tree2's preorder and inorder traversal is a substring of tree1's preoder and inorder traversal, then tree2 is a subtree
* branching: branch the large tree, if a node is equal to the root of small tree,
check if the node has the small tree as subtree

## Print all paths in a binary tree which sum to a given value
* use array to store node value at each level
* after placing a new value in the array, check if sum is found
* continue probing on left and right subtree.