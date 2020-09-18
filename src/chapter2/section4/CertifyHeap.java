package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

public class CertifyHeap {

    public static void main(String[] args) {

        Comparable[] pq = {0, 4, 2, 3, 1, 5, 6, 7};
        StdOut.println(CertifyHeap.certify(pq));

    }

    public static boolean certify(Comparable[] pq) {
        return certify(1, pq);
    }

    public static boolean certify(int k, Comparable[] pq) {
        if (2 * k >= pq.length && 2 * k + 1 >= pq.length) {
            // No children
            return true;
        } else {
            boolean leftIsMin = false;
            boolean rightIsMin = false;
            if (pq[k].compareTo(pq[2 * k]) < 0) {
                leftIsMin = certify(2 * k, pq);
            }
            if (pq[k].compareTo(pq[2 * k + 1]) < 0) {
                rightIsMin = certify(2 * k + 1, pq);
            }
            return leftIsMin && rightIsMin;
        }
    }
}

