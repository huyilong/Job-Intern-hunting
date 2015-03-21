CC150 chap2: Linked Lists
========

## Helper class file
* ListNode
* DoublyList

## Remove duplicate in linked list
* use two pointers, one to go through each data, one to remove duplicate

## Find kth last element in singly list
* runner technique
* move one pointer k-1 steps ahead, then move both pointers at the same time

## Delete middle node given only access to that node
* copy data into middle node
* "remove" middle node by bypassing next node

## Partition the list using given value
* create two lists that store nodes with data less and more than the value
* merge two lists
* set next pointer to null while traversing original list

## Sum two list in (reverse) order
* simple scan and compute sum and carryon bit
* to perform in order sum, convert into reverse order sum

## Find loop head of a circular linked list
* slow/fast runner technique

## Determine if a singly list is palindrome
* reverse the list and then compare
* find midpoint and use stack
