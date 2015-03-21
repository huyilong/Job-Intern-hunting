# Sort

+ Sort List
  - use merge sort
  - find the middle element and unlink to get two separated lists, sort each list and then merge

+ Sort colors
  - use counting sort because of small number of elements
  - use two pointers from both direction
    + set up three pointers to control the boundary of three regions
    + use one pointer to iterate, if see a 0, move it to left region; if see a 1, move it to right region; otherwise, continue iterating until the pointer hits the right region boundary
    + when swapping into left/right region, need to check if the pointer is already inside the region