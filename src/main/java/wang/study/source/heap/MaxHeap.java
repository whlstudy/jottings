package wang.study.source.heap;

import java.util.Arrays;

/**
 * @author whl
 * @date 2019/11/10 7:21 下午
 * <p>
 * 简单实现大根堆
 */
public class MaxHeap {
    int[] arr;
    int size;

    public MaxHeap() {
        arr = new int[8];
    }

    private void resize() {
        int[] temp = Arrays.copyOf(arr, arr.length);
        int newLen = arr.length * 2;
        arr = new int[newLen];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }

    public void add(Integer x) {
        if (size < arr.length) arr[size++] = x;
        else {
            resize();
            arr[size++] = x;
        }

        rebuild();
    }

    private void rebuild() {
        int index = size - 1;
        int pIndex;
        while (index >= 0) {
            pIndex = (index - 1) / 2;
            if (arr[index] > arr[pIndex]) {
                int temp = arr[pIndex];
                arr[pIndex] = arr[index];
                arr[index] = temp;

                index = pIndex;
            } else {
                break;
            }
        }
    }

    // get the head of heap
    public Integer head() throws Exception {
        if (size <= 0)
            throw new Exception("No numbers!");
        return arr[0];
    }

    // delete the head of heap
    public void remove() {
        // use the last one substitute for the first one
        int lastIndex = size - 1;
        int lastNumber = arr[lastIndex];
        arr[lastIndex] = 0;
        arr[0] = lastNumber;

        // adjust
        adjust();

    }

    private void adjust() {
        int parent = 0;
        int left, right;
        while (parent < size) {
            left = 2 * parent + 1;
            right = 2 * parent + 2;
            if ((left < arr.length && arr[parent] < arr[left]) || (right < arr.length && arr[parent] < arr[right])) {
                int temp = arr[parent];
                if (arr[left] > arr[right]) {
                    arr[parent] = arr[left];
                    arr[left] = temp;
                    parent = left;
                } else {
                    arr[parent] = arr[right];
                    arr[right] = temp;
                    parent = right;
                }
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        MaxHeap heap = new MaxHeap();
        heap.add(10);
        heap.add(8);
        heap.add(2);
        heap.add(5);
        heap.add(20);
        heap.add(49);
        heap.add(32);
        heap.add(1);
        heap.add(29);
        heap.add(100);
        heap.add(200);
        heap.remove();

        System.out.println(heap.head());
    }
}
