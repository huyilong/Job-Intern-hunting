# LinkedList techniques

+ Corner cases to check in the list:
  - head is null
  - only one node in the list (head.next==null)
  - given input does not match list structure (exp. exceed length of list)

+ Cycle in the list:
  - detect: use fast/slow runner until fast or fast.next reaches null, then no cycle exists; if slow and fast runner meets while moving, then cycle exists.
  - find head of the cycle: suppose the cycle exists and its perimeter is L, when fast and slow runner meets, fast runner travels a + b + n*L where n is the number of cycles fast runner has gone through and slow runner only travels a + b. Then we know that 2(a+b) = a+b+n*L, which gives a=n*L-b and this means if we move one runner to the list head and leave the other one at the meeting point, after moving them at the same speed for same steps, they will meet the loop head. 

+ Intersection of two lists:
  - compute difference in lengths, move pointers to the same front, then move pointers at same speed to check if they will meet
  - traverse one of list to the end and make a cycle by linking last element and head, then problem becomes finding the loop head if intersection exists; since we know the length of one lists(i.e. the length of cycle), we can move pointer of another list by this amount and put another pointer at the head, move them at the same speed to check if they will meet; at last, remove the cycle in the list

+ Find n-th last node in the list:
  - use two pointers, one(p1) stays at the head, and move another one(p2) n steps ahead; then move them at the same speed until p2 becomes null. at this time, p1 is the n-th last node in the list. Be careful when the node we want is the head, in this case, when we move p2 n steps forward, it will become null so that we can quickly recognize the case. Lastly, the given n value may exceed the length of list, this can be recognized while moving p2 forwards, it becomes null but reduced n is still positive. 

+ Merge sorted lists:
  - merge two lists: create a dummy head, use two pointers to traverse two lists and select smaller node to attach to the result list

  - merge multiple lists: one approach is to use heap(priority queue), after removing the smallest node from heap, enqueue the next element in the same list; another approach is from the idea of merge sort, keep dividing lists in half and eventually reduce to the problem of merging two sorted lists as above

+ Sort list:
  - merge sort: apply fast/slow runner to find the middle element and separate into two sublists, recursively call sort on each sublists and eventually reduced to the problems of mergign two sorted lists as above
  - insertion sort: use two pointers, one to traverse each node in the list as a card to insert, another to go through cards in the hand to find the position to insert the card; create a dummy head to simplify dealing with head node; basically, separate list into two parts, one is like cards currently in hand(sorted), another one is card deck to draw cards and insert into hand

+ Deep copy of list:
  - use hashmap: first time, we traverse the original list and make copies of the nodes to only build the singly linkedlis structure without random pointers; also, we store (original,copy) pairs into the hashmap; note that we use a hashmap because we cannot connect nodes by random pointers(we might not visited the referenced node yet); during the second the second, we traverse the two lists again and add random pointers using hashmap to the copy list
  - without hashmap: for the first round, traverse the orignal list and build a cyclic structure oscillating between original and copy nodes (i.e. A->A'->B->B'...); for the second round, we add random pointers by node.next.random = node.random.next; for the third round, we need to detach two lists, and to do this, use A.next = A'.next and A'.next = A'.next.next

+ Sorted list to BST:
  - build the tree from root to leaf: build root using middle node, then use recursion to build left/right subtree using left/right sublist
  - build the tree bottom up: use a static pointer, build left subtree using recusion, this will continue to reach the first node(in-order) in the first left subtree, which corresponds to first node in the list; similarly, we forward the static pointer as the subtree is being built

+ Reverse list:
  - whole list: first reverse head and its next node; then use two pointers, one pointing to current node, another pointing previous node, temporarily store node after current node, set current node point to previous node, then update pointers for next round
  - partial list: first find left and right boundary for the partial list and use method above to reverse only the list in the range
  - reverse adjacent nodes(swap adjacent pairs): use two pointers, one pointing to the node before current pair, another pointing to the first node in the pair; swap operation continues if both nodes in current pair are not null
  - reverse k group: borrow the idea used in the partial list, keeping finding left and right boundary for each group and perform reverse operation in this partial list and then continue to next group

+ Rotate list:
  - use runner/walker technique to locate the rotation point(walker) and end of list(runner), nodes between these two pointers are moved to the front of list and rotation point becomes the last node in the list; note that if given rotation value exceeds list length, perform a modulo operation and run pointers again

+ Remove duplicates:
  - sorted list: usually use two pointers to track current number and next number
  - unsorted lists: use merge sort to sort list first and use simple approach as above


+ Reorder list:
  - separate into two lists of equal length, reverse the second list, and then merge with the first list

+ Easy problems:
  - add two numbers represented by lists in reverse order
  - partition list: create a new list picking smaller nodes in the original list and then merge with left-over in the original list

+ Common errors:
  - Null pointer: when use node or node.next, be sure to check if it might be null at first
  - Infinite loop: conditions about pointer always satisfied
  - Decrement counter: while traversing the list, other than moving pointers, remember to decrement counter value if necessary