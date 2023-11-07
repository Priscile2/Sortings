public class MergeSort {
    int[] a = new int[10];

    public void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid); // Recursively sort the left subarray
            mergeSort(mid + 1, high); // Recursively sort the right subarray
            merge(low, mid, high); // Merge the sorted subarrays
        }
    }

    public void merge(int low, int mid, int high) {
        int n1 = mid - low + 1; // Calculate the size of the left subarray
        int n2 = high - mid; // Calculate the size of the right subarray

        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary left and right arrays
        for (int i = 0; i < n1; i++) {
            left[i] = a[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = a[mid + 1 + j];
        }

        int i = 0, j = 0;

        // Merge the two subarrays while sorting
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[low] = left[i];
                i++;
            } else {
                a[low] = right[j];
                j++;
            }
            low++;
        }

        // Copy any remaining elements from left and right subarrays
        while (i < n1) {
            a[low] = left[i];
            i++;
            low++;
        }
        while (j < n2) {
            a[low] = right[j];
            j++;
            low++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.a = new int[]{12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        mergeSort.printArray();

        mergeSort.mergeSort(0, mergeSort.a.length - 1);

        System.out.println("\nSorted array:");
        mergeSort.printArray();
    }

    public void printArray() {
        for (int value : a) {
            System.out.print(value + " ");
        }
    }
}
