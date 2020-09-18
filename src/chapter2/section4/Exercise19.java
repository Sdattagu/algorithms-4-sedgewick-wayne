/*
    Implement the constructor MaxPQ that takes an array of items as argument,
    using the bottom-up heap construction method described on page 323 in the text.
*/

package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19 {
    private int[] priorityQueue;

    public Exercise19(int[] items) {
        int n = items.length - 1;
        for (int k = n / 2; k >= 1; k--) {
            sink(items, k, n);
        }
        priorityQueue = items;
    }

    private void sink(int[] items, int k, int n) {
        while (2 * k <= n) {
            int leftChild = 2 * k;
            if (leftChild < n) {
                int rightChild = leftChild + 1;
                if (items[leftChild] < items[rightChild]) {
                    if (items[k] < items[rightChild]) {
                        exch(items, k, rightChild);
                        k = rightChild;
                    } else {
                        break;
                    }
                } else if (items[leftChild] > items[rightChild]) {
                    if (items[k] < items[leftChild]) {
                        exch(items, k, leftChild);
                        k = leftChild;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private void exch(int[] items, int k, int child) {
        int tmp = items[k];
        items[k] = items[child];
        items[child] = tmp;
    }

    public void getPriorityQueue() {
        for (int item :
                priorityQueue) {
            StdOut.println(item);
        }
    }

    public static void main(String[] args) {
        int[] items = {0, 3, 1, 2, 7, 5, 9, 8, 6, 4};
        Exercise19 maxPQ = new Exercise19(items);
        maxPQ.getPriorityQueue();
    }
}
