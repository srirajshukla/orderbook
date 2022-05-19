## Directory Structure
1. /lib - Contains implementation for Double Linked List, Binary Search Tree and OrderBook
2. /src - Contains test of these structures

## Description of the Data Structure
The various price levels are stored as nodes in a BST. At each price level, for various orders, a Double Linked List is maintained. Reference to each price and order is stored in a Hashmap. 

## Asymptotic Analysis of various operations

### Time Complexity
| Operation | Time Complexity |
| :-------- | :-------------- |
| Insertion | O(log n) for new price level, then  O(1) for each order |
| Deletion | O(1) |
| Search | O(1) |
| Traversing entire OrderBook | O(n+m) (n is no of price levels and m is number of order) |
| OrderBook for a specific price level | O(m) (m is number of orders at a price level)|
| Best Bid | O(1) |
| Best Ask | O(1) |



### Space Complexity
Total space taken by the Orderbook is - 
1. The tree and the double linked list - this will never be more than O(2*n), as in the worst case each price level will have a single order.
2. The HashMap - There will be two hashmaps, in the worst case, hashmaps will be in the order of O(n) for each price level. 

## Rough Memory Uses
Memory Uses of the Orderbook structure for different values of total order N calculated by 
```java
         long memory = runtime.totalMemory() - runtime.freeMemory();
```

| N | Memory Uses (Bytes) | Memory Uses (MegaBytes) |
|---|-------------------|-----------------------|
| 100 | 412698 | 0 |
| 1000 | 484392 | 0 |
| 10000 | 1191112 | 1 |
| 50000 | 4529864 | 4 |

