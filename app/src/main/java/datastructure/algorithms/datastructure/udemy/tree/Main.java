package datastructure.algorithms.datastructure.udemy.tree;

/**
 *          25
 *        20  27
 *      15 22 26 30
 *       17     29 32
 * Traversal
 * - level - visit nodes on each level = 25, 20, 27, 15, 22, 26, 30, 29, 32
 * - pre-order - visit the root of every subtree first = 25, 20, 15, 22, 27, 26, 30, 29, 32
 * - post-order - visit the root of every subtree last = 15, 22, 20, 26, 29, 32, 30 ,27, 25
 * - in-order - visit left child, then root, then right child = 15, 20, 22, 25, 26, 27, 29, 30, 32
 *
 * Delete
 * 1. Node is a leaf
 * 2. Node has one child
 * 3. Node has two children
 *  - need to figure out what the replacement node will be
 *  - want minimal disruption to the existing tree structure
 *  - can take the replacement node from the deleted node's left subtree or right subtree
 *  - if taking it from the left subtree, we have to take the largest value in the left subtree
 *  - if taking it from the right subtree, we have to take the smallest value in the right subtree
 *  - choose one and stick to it
 */
public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);

//        tree.traversInOrder();
//        System.out.println();

        tree.traversPreOrder();

//        System.out.println(tree.get(27));
//        System.out.println(tree.get(17));
//        System.out.println(tree.get(8888));

//        System.out.println(tree.max());
//        System.out.println(tree.min());

//        tree.delete(15);
//        tree.traversInOrder();
//        System.out.println();

//        tree.delete(27);
//        tree.traversInOrder();
//        System.out.println();

//        tree.delete(25);
//        tree.traversInOrder();
//        System.out.println();
    }
}
