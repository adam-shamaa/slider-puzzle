
public class MinPQ < Key extends Comparable > {
    private Key[] pq = (Key[]) new Comparable[2]; //binary-heap - start index at 1 to simplify calculations                        
    private int currentIndex; //index of last node in the binary-heap
    public void insert(Key val) {
        if (currentIndex >= pq.length / 2) { //check if array should be resized
            resizePQ(pq.length * 2); //resize array to twice of the current array length
        }
        pq[++currentIndex] = val; //insert key at the end of the tree and re-validate heap using swim()
        swim(currentIndex);
    }

    public Key delMin() {
        Key returnVal = pq[1]; //lowest key located at root
        pq[1] = pq[currentIndex--];
        pq[currentIndex + 1] = null; //place key located the end of the tree to the root and re-validate heap using sink()
        sink(1);
        if (currentIndex <= pq.length / 4) { //check if array should be resized
            resizePQ(pq.length / 2); //resize array to half of the current array length
        }
        return returnVal;
    }

    private void swim(int k) { //bottom-up re-validation of binary heap
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) { //top-down re-validation of binary heap
        while (2 * k <= currentIndex) {
            int j = 2 * k;
            if (j < currentIndex && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void resizePQ(int size) {
        Key[] temp = (Key[]) new Comparable[size]; //init new array
        for (int i = 0; i <= currentIndex; i++) { //copy each key
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public boolean isEmpty() {
        return currentIndex == 0;
    }

    public int size() {
        return currentIndex;
    }

    private boolean greater(int indexA, int indexB) {
        return pq[indexA].compareTo(pq[indexB]) > 0;
    }

    private void exch(int indexA, int indexB) {
        Key temp = pq[indexA];
        pq[indexA] = pq[indexB];
        pq[indexB] = temp;
    }
}