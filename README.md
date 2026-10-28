# DAA_LAB_CODES

Design and Analysis of Algorithms (DAA)

This repository contains Java implementations of the problems covered in the Design and Analysis of Algorithms (DAA) Lab.

The codes are organized according to the lab sessions and problem numbers for easy reference and practice.

---

## Table of Contents

- [Experiment 1: Sorting & Linear Array Algorithms](#experiment-1-sorting--linear-array-algorithms)
  - [1a. Insertion Sort — Iterative](#1a-insertion-sort--iterative)
  - [1b. Insertion Sort — Recursive](#1b-insertion-sort--recursive)
  - [1c. Dutch National Flag — Sort 0s, 1s, and 2s](#1c-dutch-national-flag--sort-0s-1s-and-2s)
  - [1d. Majority Element](#1d-majority-element)
- [Experiment 2: Two-Pointer & Divide-and-Conquer Search/Sort](#experiment-2-two-pointer--divide-and-conquer-searchsort)
  - [2a. Union of Two Sorted Arrays](#2a-union-of-two-sorted-arrays)
  - [2b. Intersection of Two Sorted Arrays](#2b-intersection-of-two-sorted-arrays)
  - [2c. Search in a Rotated Sorted Array](#2c-search-in-a-rotated-sorted-array)
  - [2d. Merge Sort](#2d-merge-sort)
  - [2e. Count Inversions Using Merge Sort](#2e-count-inversions-using-merge-sort)
- [Experiment 3: Matrix Algorithms & Binary Search Applications](#experiment-3-matrix-algorithms--binary-search-applications)
  - [3a. Matrix Multiplication](#3a-matrix-multiplication)
  - [3b. Strassen's Matrix Multiplication](#3b-strassens-matrix-multiplication)
  - [3c. Allocate Minimum Pages](#3c-allocate-minimum-pages)
  - [3d. Median of Two Sorted Arrays](#3d-median-of-two-sorted-arrays)
- [Experiment 4: Divide-and-Conquer, Quickselect & Array Problems](#experiment-4-divide-and-conquer-quickselect--array-problems)
  - [4a. Maximum Product Subarray](#4a-maximum-product-subarray)
  - [4b. Kth Largest Element using Quickselect](#4b-kth-largest-element-using-quickselect)
  - [4c. Nth Fibonacci Number](#4c-nth-fibonacci-number)
  - [4d. Smallest Missing Positive Integer](#4d-smallest-missing-positive-integer)
- [Experiment 5: Heap Operations & Selection Algorithms](#experiment-5-heap-operations--selection-algorithms)
  - [5a. Heap Sort](#5a-heap-sort)
  - [5b. Rearrange String](#5b-rearrange-string)
  - [5c. Merge K Sorted Arrays](#5c-merge-k-sorted-arrays)
  - [5d. Median of Medians / Deterministic Selection](#5d-median-of-medians--deterministic-selection)
- [Experiment 6: Non-Comparison Sorting & Greedy/Sliding Window](#experiment-6-non-comparison-sorting--greedysliding-window)
  - [6a. Counting Sort](#6a-counting-sort)
  - [6b. Bucket Sort](#6b-bucket-sort)
  - [6c. Count Subarrays with Exactly K Distinct Elements](#6c-count-subarrays-with-exactly-k-distinct-elements)
  - [6d. Minimize Array Sum After K Operations](#6d-minimize-array-sum-after-k-operations)
- [Experiment 7: Hashing & String Matching](#experiment-7-hashing--string-matching)
  - [7a. Hash Table Implementation](#7a-hash-table-implementation)
  - [7b. Relative Sorting](#7b-relative-sorting)
  - [7c. Minimum Window Substring](#7c-minimum-window-substring)
- [Experiment 8: Tree Data Structures & Binary Search Trees](#experiment-8-tree-data-structures--binary-search-trees)
  - [8a. Binary Search Tree Construction](#8a-binary-search-tree-construction)
  - [8b. Lowest Common Ancestor](#8b-lowest-common-ancestor)
  - [8c. Largest BST in a Binary Tree](#8c-largest-bst-in-a-binary-tree)
- [Experiment 9: Greedy Graphs & Dynamic Programming](#experiment-9-greedy-graphs--dynamic-programming)
  - [9a. Prim's Minimum Spanning Tree](#9a-prims-minimum-spanning-tree)
  - [9b. Count Nodes in a Complete Binary Tree](#9b-count-nodes-in-a-complete-binary-tree)
  - [9c. Longest Palindromic Subsequence](#9c-longest-palindromic-subsequence)
- [Experiment 10: Shortest Paths, DP & Bottleneck Optimization](#experiment-10-shortest-paths-dp--bottleneck-optimization)
  - [10a. Dijkstra's Shortest Path Algorithm](#10a-dijkstras-shortest-path-algorithm)
  - [10b. Stock Buy and Sell with Transaction Fee](#10b-stock-buy-and-sell-with-transaction-fee)
  - [10c. Maximum Bottleneck Path](#10c-maximum-bottleneck-path)
- [Experiment 11: All-Pairs Shortest Path & Graph Optimization](#experiment-11-all-pairs-shortest-path--graph-optimization)
  - [11a. Bellman–Ford Algorithm](#11a-bellmanford-algorithm)
  - [11b. Floyd–Warshall Algorithm](#11b-floydwarshall-algorithm)
  - [11c. City with the Fewest Reachable Neighbors](#11c-city-with-the-fewest-reachable-neighbors)
- [How to Compile and Run](#how-to-compile-and-run)

---

## Experiment 1: Sorting & Linear Array Algorithms

### 1a. Insertion Sort — Iterative
- **Source Code:** [`Experiment-1/InsertionSortIterative.java`](./Experiment-1/InsertionSortIterative.java)
- **Description:** Iteratively builds the sorted array one element at a time by repeatedly picking the next element and inserting it into its correct position within the already sorted prefix.
- **Time Complexity:** $O(n^2)$ worst and average case, $O(n)$ best case (already sorted).
- **Space Complexity:** $O(1)$ auxiliary space.

### 1b. Insertion Sort — Recursive
- **Source Code:** [`Experiment-1/InsertionSortRecursive.java`](./Experiment-1/InsertionSortRecursive.java)
- **Description:** Recursively sorts the first $n-1$ elements of the array, then inserts the $n$-th element into its sorted position within the prefix.
- **Time Complexity:** $O(n^2)$ worst and average case, $O(n)$ best case.
- **Space Complexity:** $O(n)$ auxiliary space due to the recursion call stack.

### 1c. Dutch National Flag — Sort 0s, 1s, and 2s
- **Source Code:** [`Experiment-1/DutchNationalFlag.java`](./Experiment-1/DutchNationalFlag.java)
- **Description:** Partitions an array of 0s, 1s, and 2s into three groups in a single pass using three pointers (`low`, `mid`, `high`).
- **Time Complexity:** $O(n)$ single pass.
- **Space Complexity:** $O(1)$ auxiliary space.

### 1d. Majority Element
- **Source Code:** [`Experiment-1/MajorityElement.java`](./Experiment-1/MajorityElement.java)
- **Description:** Implements Boyer-Moore Voting Algorithm to find the element that appears strictly more than $\lfloor n / 2 \rfloor$ times, followed by a second verification pass.
- **Time Complexity:** $O(n)$.
- **Space Complexity:** $O(1)$ auxiliary space.

---

## Experiment 2: Two-Pointer & Divide-and-Conquer Search/Sort

### 2a. Union of Two Sorted Arrays
- **Source Code:** [`Experiment-2/UnionTwoSortedArrays.java`](./Experiment-2/UnionTwoSortedArrays.java)
- **Description:** Uses the two-pointer technique to traverse two sorted arrays simultaneously and print their set union in sorted order without duplicates.
- **Time Complexity:** $O(n + m)$.
- **Space Complexity:** $O(1)$ auxiliary space.

### 2b. Intersection of Two Sorted Arrays
- **Source Code:** [`Experiment-2/IntersectionTwoSortedArrays.java`](./Experiment-2/IntersectionTwoSortedArrays.java)
- **Description:** Uses two pointers to find common elements between two sorted arrays, skipping duplicates.
- **Time Complexity:** $O(n + m)$.
- **Space Complexity:** $O(1)$ auxiliary space.

### 2c. Search in a Rotated Sorted Array
- **Source Code:** [`Experiment-2/SearchRotatedSortedArray.java`](./Experiment-2/SearchRotatedSortedArray.java)
- **Description:** Modified binary search that determines which half of the array is normally sorted and checks whether the target lies within that half.
- **Time Complexity:** $O(\log n)$.
- **Space Complexity:** $O(1)$ auxiliary space.

### 2d. Merge Sort
- **Source Code:** [`Experiment-2/MergeSort.java`](./Experiment-2/MergeSort.java)
- **Description:** Classic divide-and-conquer sorting algorithm that splits the array into two halves, recursively sorts each half, and merges the two sorted halves.
- **Time Complexity:** $O(n \log n)$ in best, worst, and average cases.
- **Space Complexity:** $O(n)$ auxiliary space.

### 2e. Count Inversions Using Merge Sort
- **Source Code:** [`Experiment-2/CountInversions.java`](./Experiment-2/CountInversions.java)
- **Description:** Enhances Merge Sort to count inversions (pairs $(i, j)$ such that $i < j$ and $arr[i] > arr[j]$) in $O(n \log n)$ time by counting remaining elements in the left subarray when an element from the right subarray is picked.
- **Time Complexity:** $O(n \log n)$.
- **Space Complexity:** $O(n)$ auxiliary space.

---

## Experiment 3: Matrix Algorithms & Binary Search Applications

### 3a. Matrix Multiplication
- **Source Code:** [`Experiment-3/MatrixMultiplication.java`](./Experiment-3/MatrixMultiplication.java)
- **Description:** Standard iterative matrix multiplication of matrix $A$ ($r_1 \times c_1$) and matrix $B$ ($r_2 \times c_2$). Validates that $c_1 = r_2$ before computation.
- **Time Complexity:** $O(r_1 \cdot c_1 \cdot c_2)$.
- **Space Complexity:** $O(r_1 \cdot c_2)$ for the product matrix.

### 3b. Strassen's Matrix Multiplication
- **Source Code:** [`Experiment-3/StrassensMatrixMultiplication.java`](./Experiment-3/StrassensMatrixMultiplication.java)
- **Description:** Divide-and-conquer matrix multiplication reducing 8 recursive subproblems to 7 ($P_1$ through $P_7$). Supports arbitrary matrix dimensions and non-powers of two by automatically padding to the next power of two ($2^k$) and unpadding the final result.
- **Time Complexity:** $O(n^{\log_2 7}) \approx O(n^{2.807})$.
- **Space Complexity:** $O(n^2)$ recursive allocations.

### 3c. Allocate Minimum Pages
- **Source Code:** [`Experiment-3/AllocateMinimumPages.java`](./Experiment-3/AllocateMinimumPages.java)
- **Description:** Allocates contiguous books to $M$ students such that the maximum number of pages assigned to any student is minimized. Uses binary search on answer between $\max(\text{pages})$ and $\sum \text{pages}$.
- **Time Complexity:** $O(N \log(\sum \text{pages}))$.
- **Space Complexity:** $O(1)$ auxiliary space.

### 3d. Median of Two Sorted Arrays
- **Source Code:** [`Experiment-3/MedianOfTwoSortedArrays.java`](./Experiment-3/MedianOfTwoSortedArrays.java)
- **Description:** Finds the median of two sorted arrays in logarithmic time by binary searching the partition point on the smaller array such that all elements on the left are $\le$ elements on the right.
- **Time Complexity:** $O(\log(\min(n, m)))$.
- **Space Complexity:** $O(1)$ auxiliary space.

---

## Experiment 4: Divide-and-Conquer, Quickselect & Array Problems

### 4a. Maximum Product Subarray
- **Source Code:** [`Experiment-4/MaximumProductSubarray.java`](./Experiment-4/MaximumProductSubarray.java)
- **Description:** Dynamic programming approach tracking both running maximum and minimum products at each index to correctly handle negative values and zeros in $O(n)$ time.
- **Time Complexity:** $O(n)$.
- **Space Complexity:** $O(1)$ auxiliary space.

### 4b. Kth Largest Element using Quickselect
- **Source Code:** [`Experiment-4/KthLargestElement.java`](./Experiment-4/KthLargestElement.java)
- **Description:** Finds the $k$-th largest element using randomized 3-way Quickselect (Dutch National Flag partition), preventing $O(n^2)$ degradation when arrays contain many duplicate values.
- **Time Complexity:** $O(n)$ average case, $O(n^2)$ worst case.
- **Space Complexity:** $O(1)$ auxiliary space.

### 4c. Nth Fibonacci Number
- **Source Code:** [`Experiment-4/NthFibonacciNumber.java`](./Experiment-4/NthFibonacciNumber.java)
- **Description:** Implements Matrix Exponentiation ($\begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix}^n$) using repeated squaring to compute $F(n)$ in $O(\log n)$ time, alongside an iterative $O(n)$ dynamic programming solution.
- **Time Complexity:** $O(\log n)$ via Matrix Exponentiation; $O(n)$ via DP.
- **Space Complexity:** $O(\log n)$ recursion stack.

### 4d. Smallest Missing Positive Integer
- **Source Code:** [`Experiment-4/SmallestMissingPositiveInteger.java`](./Experiment-4/SmallestMissingPositiveInteger.java)
- **Description:** Finds the first missing positive integer using cyclic sort (in-place bucket placement) to place each value $x \in [1, n]$ at index $x - 1$ in $O(n)$ time and $O(1)$ auxiliary space.
- **Time Complexity:** $O(n)$.
- **Space Complexity:** $O(1)$ auxiliary space.

---

## Experiment 5: Heap Operations & Selection Algorithms

### 5a. Heap Sort
- **Source Code:** [`Experiment-5/HeapSort.java`](./Experiment-5/HeapSort.java)
- **Description:** Constructs a Max-Heap from the array in $O(n)$ time, then repeatedly swaps the root with the last unsorted element and heapifies the reduced heap.
- **Time Complexity:** $O(n \log n)$ in best, worst, and average cases.
- **Space Complexity:** $O(1)$ in-place auxiliary space.

### 5b. Rearrange String
- **Source Code:** [`Experiment-5/RearrangeString.java`](./Experiment-5/RearrangeString.java)
- **Description:** Rearranges characters of a string so that no two adjacent characters are identical using a Max-Heap based on character frequencies. Correctly detects when valid rearrangement is impossible (when $\max(\text{freq}) > \lceil n/2 \rceil$).
- **Time Complexity:** $O(n \log k)$ where $k \le 256$ is alphabet size.
- **Space Complexity:** $O(k)$ auxiliary space.

### 5c. Merge K Sorted Arrays
- **Source Code:** [`Experiment-5/MergeKSortedArrays.java`](./Experiment-5/MergeKSortedArrays.java)
- **Description:** Merges $K$ sorted arrays into a single sorted array using a Min-Heap of size $K$ storing the current smallest element from each array.
- **Time Complexity:** $O(N \log K)$ where $N$ is total elements across all $K$ arrays.
- **Space Complexity:** $O(K)$ auxiliary space.

### 5d. Median of Medians / Deterministic Selection
- **Source Code:** [`Experiment-5/MedianOfMedians.java`](./Experiment-5/MedianOfMedians.java)
- **Description:** Implements the Blum-Floyd-Pratt-Rivest-Tarjan (BFPRT) deterministic selection algorithm. Divides the array into groups of 5, recursively finds the median of medians as a balanced pivot, and partitions with 3-way partitioning to guarantee linear worst-case time.
- **Time Complexity:** $O(n)$ worst-case guaranteed.
- **Space Complexity:** $O(\log n)$ recursion stack.

---

## Experiment 6: Non-Comparison Sorting & Greedy/Sliding Window

### 6a. Counting Sort
- **Source Code:** [`Experiment-6/CountingSort.java`](./Experiment-6/CountingSort.java)
- **Description:** Stable non-comparison sorting algorithm for integers. Calculates frequencies, computes prefix sums, and places elements backwards to maintain stability. Handles negative integers by offsetting with the minimum value.
- **Time Complexity:** $O(n + k)$ where $k = \max - \min + 1$.
- **Space Complexity:** $O(n + k)$ auxiliary space.

### 6b. Bucket Sort
- **Source Code:** [`Experiment-6/BucketSort.java`](./Experiment-6/BucketSort.java)
- **Description:** Distributes floating-point numbers over an arbitrary range $[min, max]$ into $n$ buckets, sorts individual buckets, and concatenates them.
- **Time Complexity:** $O(n + k)$ average case, $O(n^2)$ worst case.
- **Space Complexity:** $O(n + k)$ auxiliary space.

### 6c. Count Subarrays with Exactly K Distinct Elements
- **Source Code:** [`Experiment-6/CountSubarraysWithKDistinct.java`](./Experiment-6/CountSubarraysWithKDistinct.java)
- **Description:** Computes the number of contiguous subarrays containing exactly $K$ distinct elements by evaluating $\text{atMost}(K) - \text{atMost}(K - 1)$ using a two-pointer sliding window and frequency map.
- **Time Complexity:** $O(n)$.
- **Space Complexity:** $O(k)$ auxiliary space.

### 6d. Minimize Array Sum After K Operations
- **Source Code:** [`Experiment-6/MinimizeArraySum.java`](./Experiment-6/MinimizeArraySum.java)
- **Description:** Uses a Max-Heap to iteratively select the largest element in the array and halve it ($\lfloor x / 2 \rfloor$) across $K$ operations, achieving the maximum possible reduction in the total sum.
- **Time Complexity:** $O(n + K \log n)$.
- **Space Complexity:** $O(n)$ auxiliary space.

---

## Experiment 7: Hashing & String Matching

### 7a. Hash Table Implementation
- **Source Code:** [`Experiment-7/HashTableImplementation.java`](./Experiment-7/HashTableImplementation.java)
- **Description:** Complete Hash Table implementation with Separate Chaining for collision resolution. Supports `insert`, `search`, `delete`, `display`, and dynamic rehashing when the load factor exceeds $0.75$.
- **Time Complexity:** $O(1)$ average for insert, search, and delete; $O(n)$ worst case.
- **Space Complexity:** $O(n + \text{capacity})$.

### 7b. Relative Sorting
- **Source Code:** [`Experiment-7/RelativeSorting.java`](./Experiment-7/RelativeSorting.java)
- **Description:** Sorts array $A_1$ such that the relative order of elements follows array $A_2$. Elements of $A_1$ not present in $A_2$ are placed at the end in sorted ascending order using a frequency hash map.
- **Time Complexity:** $O(n_1 \log n_1 + n_2)$.
- **Space Complexity:** $O(n_1)$ auxiliary space.

### 7c. Minimum Window Substring
- **Source Code:** [`Experiment-7/MinimumWindowSubstring.java`](./Experiment-7/MinimumWindowSubstring.java)
- **Description:** Finds the smallest substring of $S$ that contains all characters of $T$ (with frequency) using an optimal two-pointer sliding window and character count arrays.
- **Time Complexity:** $O(|S| + |T|)$.
- **Space Complexity:** $O(1)$ auxiliary space (fixed ASCII array).

---

## Experiment 8: Tree Data Structures & Binary Search Trees

### 8a. Binary Search Tree Construction
- **Source Code:** [`Experiment-8/BinarySearchTreeConstruction.java`](./Experiment-8/BinarySearchTreeConstruction.java)
- **Description:** Full BST implementation supporting node insertion, search, three-case node deletion (leaf, one child, two children using in-order successor), and tree traversals (In-order, Pre-order, Post-order, Level-order).
- **Time Complexity:** $O(h)$ where $h$ is tree height ($O(\log n)$ balanced, $O(n)$ worst case).
- **Space Complexity:** $O(h)$ recursion stack.

### 8b. Lowest Common Ancestor
- **Source Code:** [`Experiment-8/LowestCommonAncestor.java`](./Experiment-8/LowestCommonAncestor.java)
- **Description:** Finds the Lowest Common Ancestor (LCA) of two given nodes in a Binary Search Tree by identifying the split point where one value lies to the left and the other lies to the right.
- **Time Complexity:** $O(h)$ where $h$ is tree height.
- **Space Complexity:** $O(h)$ recursion stack.

### 8c. Largest BST in a Binary Tree
- **Source Code:** [`Experiment-8/LargestBSTInBinaryTree.java`](./Experiment-8/LargestBSTInBinaryTree.java)
- **Description:** Optimal bottom-up post-order traversal finding the size of the largest subtree that is a valid Binary Search Tree. Returns a state tracking `isBST`, subtree `size`, `min`, and `max`.
- **Time Complexity:** $O(n)$ linear time.
- **Space Complexity:** $O(h)$ recursion stack.

---

## Experiment 9: Greedy Graphs & Dynamic Programming

### 9a. Prim's Minimum Spanning Tree
- **Source Code:** [`Experiment-9/PrimsAlgorithm.java`](./Experiment-9/PrimsAlgorithm.java)
- **Description:** Finds the Minimum Spanning Tree (MST) of a weighted undirected graph using a PriorityQueue (Min-Heap) and adjacency list representation. Gracefully warns if the graph is disconnected.
- **Time Complexity:** $O((V + E) \log V)$.
- **Space Complexity:** $O(V + E)$.

### 9b. Count Nodes in a Complete Binary Tree
- **Source Code:** [`Experiment-9/CountNodesCompleteBinaryTree.java`](./Experiment-9/CountNodesCompleteBinaryTree.java)
- **Description:** Leverages complete tree geometry to count nodes faster than $O(n)$ by comparing leftmost and rightmost heights. If equal, the subtree has $2^h - 1$ nodes; otherwise recurses on left and right children.
- **Time Complexity:** $O(\log^2 n)$.
- **Space Complexity:** $O(\log n)$ recursion stack.

### 9c. Longest Palindromic Subsequence
- **Source Code:** [`Experiment-9/LongestPalindromicSubsequence.java`](./Experiment-9/LongestPalindromicSubsequence.java)
- **Description:** Computes the length of the Longest Palindromic Subsequence (LPS) using 2D Dynamic Programming and reconstructs the actual palindromic subsequence string by backtracking through the DP table.
- **Time Complexity:** $O(n^2)$.
- **Space Complexity:** $O(n^2)$ for the DP table.

---

## Experiment 10: Shortest Paths, DP & Bottleneck Optimization

### 10a. Dijkstra's Shortest Path Algorithm
- **Source Code:** [`Experiment-10/DijkstrasAlgorithm.java`](./Experiment-10/DijkstrasAlgorithm.java)
- **Description:** Single-source shortest path algorithm on directed/undirected graphs using a Min-Heap. Strictly validates that edge weights are non-negative, and reconstructs the full shortest path to every reachable vertex.
- **Time Complexity:** $O((V + E) \log V)$.
- **Space Complexity:** $O(V + E)$.

### 10b. Stock Buy and Sell with Transaction Fee
- **Source Code:** [`Experiment-10/StockBuySellWithFee.java`](./Experiment-10/StockBuySellWithFee.java)
- **Description:** Dynamic programming state machine tracking `cash` (max profit without stock) and `hold` (max profit with stock) across trading days to maximize profit while paying a fixed fee per transaction.
- **Time Complexity:** $O(n)$.
- **Space Complexity:** $O(1)$ auxiliary space.

### 10c. Maximum Bottleneck Path
- **Source Code:** [`Experiment-10/MaximumBottleneckPath.java`](./Experiment-10/MaximumBottleneckPath.java)
- **Description:** Modified Dijkstra algorithm using a Max-Heap to find the path between source and target that maximizes the minimum edge capacity along the path (the widest path problem).
- **Time Complexity:** $O((V + E) \log V)$.
- **Space Complexity:** $O(V + E)$.

---

## Experiment 11: All-Pairs Shortest Path & Graph Optimization

### 11a. Bellman–Ford Algorithm
- **Source Code:** [`Experiment-11/BellmanFordAlgorithm.java`](./Experiment-11/BellmanFordAlgorithm.java)
- **Description:** Single-source shortest path algorithm that supports negative edge weights by relaxing all edges $V - 1$ times. Performs a $V$-th pass to detect and report negative-weight cycles reachable from the source.
- **Time Complexity:** $O(V \cdot E)$.
- **Space Complexity:** $O(V)$ auxiliary space.

### 11b. Floyd–Warshall Algorithm
- **Source Code:** [`Experiment-11/FloydWarshallAlgorithm.java`](./Experiment-11/FloydWarshallAlgorithm.java)
- **Description:** All-Pairs Shortest Path dynamic programming algorithm using an adjacency matrix. Safely avoids integer overflow for unreachable vertices and detects negative-weight cycles ($dist[i][i] < 0$).
- **Time Complexity:** $O(V^3)$.
- **Space Complexity:** $O(V^2)$ for distance and path reconstruction matrices.

### 11c. City with the Fewest Reachable Neighbors
- **Source Code:** [`Experiment-11/CityWithFewestNeighbors.java`](./Experiment-11/CityWithFewestNeighbors.java)
- **Description:** Computes all-pairs shortest paths using Floyd-Warshall to count the number of reachable cities within a given distance threshold. Correctly implements the tie-breaking rule returning the city with the **greatest numerical index** when counts are tied.
- **Time Complexity:** $O(n^3)$.
- **Space Complexity:** $O(n^2)$.

---

## How to Compile and Run

Every program is an independent, complete, executable Java file with its own `main` method.

### 1. Prerequisites
Ensure you have the Java Development Kit (JDK 17 or higher recommended) installed:
```bash
javac -version
java -version
```

### 2. Compiling Any Program
Navigate to the root of the repository or the respective experiment directory:
```bash
# Example: Compiling Strassen's Matrix Multiplication
javac Experiment-3/StrassensMatrixMultiplication.java
```

### 3. Running the Program
Run the compiled class file:
```bash
# Running from repository root:
java -cp Experiment-3 StrassensMatrixMultiplication

# Or navigate directly into the experiment folder:
cd Experiment-3
javac StrassensMatrixMultiplication.java
java StrassensMatrixMultiplication
```

### 4. Compiling an Entire Experiment
To compile all programs within an experiment at once:
```bash
javac Experiment-3/*.java
```

---

## Repository Structure

```text
DAA_LAB_CODES/
├── README.md
├── .gitignore
├── 1a. Insertion Sort — Iterative
├── 1b. Insertion Sort — Recursive
├── 1c. Dutch National Flag — Sort 0s, 1s and 2s
├── 1d. Majority Element
├── 2a. Union of Two Sorted Arrays
├── 2b. Intersection of Two Sorted Arrays
├── 2c. Search in a Rotated Sorted Array
├── 2d. Merge Sort
├── 2e. Count Inversions Using Merge Sort
├── Experiment-1/
│   ├── InsertionSortIterative.java
│   ├── InsertionSortRecursive.java
│   ├── DutchNationalFlag.java
│   └── MajorityElement.java
├── Experiment-2/
│   ├── UnionTwoSortedArrays.java
│   ├── IntersectionTwoSortedArrays.java
│   ├── SearchRotatedSortedArray.java
│   ├── MergeSort.java
│   └── CountInversions.java
├── Experiment-3/
│   ├── MatrixMultiplication.java
│   ├── StrassensMatrixMultiplication.java
│   ├── AllocateMinimumPages.java
│   └── MedianOfTwoSortedArrays.java
├── Experiment-4/
│   ├── MaximumProductSubarray.java
│   ├── KthLargestElement.java
│   ├── NthFibonacciNumber.java
│   └── SmallestMissingPositiveInteger.java
├── Experiment-5/
│   ├── HeapSort.java
│   ├── RearrangeString.java
│   ├── MergeKSortedArrays.java
│   └── MedianOfMedians.java
├── Experiment-6/
│   ├── CountingSort.java
│   ├── BucketSort.java
│   ├── CountSubarraysWithKDistinct.java
│   └── MinimizeArraySum.java
├── Experiment-7/
│   ├── HashTableImplementation.java
│   ├── RelativeSorting.java
│   └── MinimumWindowSubstring.java
├── Experiment-8/
│   ├── BinarySearchTreeConstruction.java
│   ├── LowestCommonAncestor.java
│   └── LargestBSTInBinaryTree.java
├── Experiment-9/
│   ├── PrimsAlgorithm.java
│   ├── CountNodesCompleteBinaryTree.java
│   └── LongestPalindromicSubsequence.java
├── Experiment-10/
│   ├── DijkstrasAlgorithm.java
│   ├── StockBuySellWithFee.java
│   └── MaximumBottleneckPath.java
└── Experiment-11/
    ├── BellmanFordAlgorithm.java
    ├── FloydWarshallAlgorithm.java
    └── CityWithFewestNeighbors.java
```
