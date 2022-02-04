package datastructure.udemy.heap;

/**
 * A complete binary tree
 * must satisfy the heap property
 * max heap : every parent is greater than or equal to its children
 * min heap : every parent is less than or equal to its children
 *
 * children are added at each level from left to right
 * usually implemented as arrays
 * the maximum or minimum value will always be at the root of the tree - the advantage of using a heap
 * heapify: process of converting a binary tree into a heap - this often has to be done after an insertion or deletion
 * no required ordering between siblings
 *
 * Heaps as Arrays
 * We can store binary heaps as arrays
 * we put the root at array[0]
 * we then traverse each level from left to right,
 * and so the left child of the root would go into array[1],
 * its right child would to into array[2], etc.
 * [22, 19, 18, 15, 3, 14, 4, 12] - max heap
 *              22
 *            19  18
 *          15 3 14 4
 *        12
 * [3, 4, 12, 14, 15, 18, 19, 22] - min heap
 *              3
 *            4  12
 *         14 15 18 19
 *       22
 * For the node at array[i]:
 *
 * left child = 2i + 1
 * right child = 2i + 2
 * parent = floor((i-1)/2)
 *
 * Insert into Heap
 * Always add new items to the end of the array
 * Then we have to fix the heap (heapfify)
 * we compare the new item against its parent
 * if the item is greater than its parent, we swap it with its parent
 * we then rinse and repeat
 *
 * Delete
 * Must choose a replacement value
 * will take the rightmost value, so that the tree remains complete
 * then we must heapify the heap
 * when replacement value is greater than parent, fix heap above.
 * otherwise, fix heap below
 * Fix heap above - same as insert. swap replacement value with parent
 * Fix heap below - swap the replacement value with the larger of its two children
 * Rinse and repeat in both cases until the replacement value is in its correct position
 * will only need to fix up or down, not both
 *
 *              80
 *            75  60
 *          68 55 40 52
 *        67
 *  Delete 75, replacement value: 67
 *
 *              80
 *            67  60
 *          68 55 40 52
 *  Now, this is not a heap
 *  so swap 67 and 68
 *
 *              80
 *            68  60
 *          67 55 40 52
 */
public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

//        heap.delete(1);
        heap.delete(5);

        heap.printHeap();

        System.out.println(heap.peek());

        heap.delete(0);
        heap.printHeap();

        System.out.println(heap.peek());
    }
}
