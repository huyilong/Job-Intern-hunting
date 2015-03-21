CC150 chap3: Stacks and Queues
========

## Helper class file
* Node
* Stack
* Queue

## Implement a stack that returns min in O(1) time
* use additional stack to track min element

## Sort a stack using only stacks
* use one additional stack
* keep poping from original stack and insert into right place in 
  the additional stack

## Implement MyQueue class using two stacks
* when enqueue, push to s1
* when dequeue, pop from s2(if s2 is empty, transfer elements in s1 to s2)

## Implement SetOfStacks with operation push,pop,popAt
* use array of stacks with certain threshold
* popAt(): afer poping from intermediate stack, transfer elements
           from other stacks to fill in the blank

## Hanoi Tower
* Recursive approach: initial tower, buffer, destination
* move n-1 elements from initial tower to buffer using destination as a buffer
* move bottom element to destination directly
* move n-1 elements from buffer to desination using initial tower as a buffer

## Implement three stacks using a single array
* fixed division
* flexible division