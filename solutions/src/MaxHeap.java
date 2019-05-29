import java.util.Arrays;

/**
 * @author : dx
 * @date : 2019/5/29
 * Description :
 */
public class MaxHeap {
    protected double A[];
    protected int heapsize;

    public MaxHeap() {
    }

    public MaxHeap(double A[]) {
        buildMaxHeap(A);
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int left(int i) {
        return 2 * i + 1;
    }

    protected int right(int i) {
        return 2 * i + 2;
    }

    protected void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l <= heapsize - 1 && A[l] > A[i])
            largest = l;
        if (r <= heapsize - 1 && A[r] > A[largest])
            largest = r;
        if (largest != i) {
            double temp = A[i];
            // swap
            A[i] = A[largest];
            A[largest] = temp;
            this.maxHeapify(largest);
        }
    }

    public void buildMaxHeap(double[] A) {
        this.A = A;
        this.heapsize = A.length;

        for (int i = parent(heapsize - 1); i >= 0; i--)
            maxHeapify(i);
    }

    public void heapsort(double[] A) {
        buildMaxHeap(A);

        int step = 1;
        for (int i = A.length - 1; i > 0; i--) {
            double temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            heapsize--;
            System.out.println("Step: " + (step++) + Arrays.toString(A));
            maxHeapify(0);
        }
    }

    public static void main(String[] args) {
        //a sample input
        double[] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(A));
        MaxHeap maxhp = new MaxHeap();
        maxhp.heapsort(A);
        System.out.println("Output: " + Arrays.toString(A));

    }
}
