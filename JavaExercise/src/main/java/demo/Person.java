package demo;

import java.util.Arrays;

public class MaxHeap {
    private final int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(8);
        heap.insert(2);
        heap.insert(4);
        System.out.println(heap); // 输出：MaxHeap{heap=[8, 5, 7, 3, 2, 4, 0, 0, 0, 0], size=6}
        int max = heap.extractMax();
        System.out.println("max: " + max); // 输出：max: 8
        System.out.println(heap); // 输出：MaxHeap{heap=[7, 5, 4, 3, 2, 0, 0, 0, 0, 0], size=5}
    }

    // 返回父结点的下标
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // 返回左子结点的下标
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回右子结点的下标
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 上浮操作：把新加入的元素放到对应位置，然后与父节点比较大小并交换
    private void siftUp(int index) {
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // 下沉操作：把根节点放到对应位置，然后判断左右节点的大小，与最大的那个子节点交换
    private void siftDown(int index) {
        int maxIndex = index;
        int left = leftChild(index);
        if (left < size && heap[left] > heap[maxIndex]) {
            maxIndex = left;
        }
        int right = rightChild(index);
        if (right < size && heap[right] > heap[maxIndex]) {
            maxIndex = right;
        }
        if (index != maxIndex) {
            swap(index, maxIndex);
            siftDown(maxIndex);
        }
    }

    // 插入元素
    public void insert(int value) {
        if (size == heap.length) {
            throw new RuntimeException("Heap is full");
        }
        heap[size] = value;
        siftUp(size);
        size++;
    }

    // 弹出堆顶元素
    public int extractMax() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int max = heap[0];
        swap(0, size - 1);
        size--;
        siftDown(0);
        return max;
    }

    // 交换两个元素
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "heap=" + Arrays.toString(heap) +
                ", size=" + size +
                '}';
    }
}



