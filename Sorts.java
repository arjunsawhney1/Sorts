/*
 * NAME: Arjun Sawhney
 */
import java.util.ArrayList;

/**
 * Sorts class
 * @param <T> Generic type
 * @author Arjun Sawhney
 * @since  05/02/2020
 */
public class Sorts<T extends Comparable<? super T>> {

    private static final int HALF_LIST = 2;

    /**
     * This method performs insertion sort on the input arraylist
     *
     * @param list  The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end   The final index of the subsection of Arraylist we want to sort
     */
    public void InsertionSort(ArrayList<T> list, int start, int end) {
        // Pointer variable to check previous numbers in list
        int j = 0;
        // Inserting list[i] into the appropriate position in the sorted part
        // Each iteration ends when numbers[i] is in the correct position
        for (int i = start; i <= end; i++) {
            j = i;
            // Keep swapping with previous number while previous number is smaller
            while ((j > start) && (list.get(j).compareTo(list.get(j - 1)) < 0)) {
                T temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                --j;
            }
        }
    }

    /**
     * This method performs merge sort on the input arraylist
     *
     * @param list  The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end   The final index of the subsection of Arraylist we want to sort
     */
    public void MergeSort(ArrayList<T> list, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / HALF_LIST;
            MergeSort(list, start, mid);
            MergeSort(list, mid + 1, end);

            merge(list, start, mid, end);
        }
    }

    /**
     * merge helper function for MergeSort
     *
     * @param arr The arraylist we want to sort
     * @param l   left-most index we want to merge
     * @param m   the middle index we want to merge
     * @param r   right-most index we want to merge
     */
    private void merge(ArrayList<T> arr, int l, int m, int r) {
        int mergedSize = r - l + 1;

        ArrayList<T> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            } else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    /**
     * This method performs quick sort on the input arraylist
     *
     * @param list  The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end   The final index of the subsection of Arraylist we want to sort
     */
    public void QuickSort(ArrayList<T> list, int start, int end) {
        // Base case. If there are 0 or 1 elements to sort, partition is already sorted
        if (start >= end) {
            return;
        }
        // Partition the data within the array. Value j returned from partitioning is the
        // location of the last element in the low partition
        int j = partition(list, start, end);
        // Recursively sort low partition (start to j) and high partition (j + 1 to end)
        QuickSort(list, start, j);
        QuickSort(list, j + 1, end);
    }

    /**
     * partition helper function for QuickSort
     *
     * @param arr The arraylist we want to sort
     * @param l   left-most index we want to merge
     * @param h   right-most index we want to merge
     */
    private int partition(ArrayList<T> arr, int l, int h) {
        // Boolean value to decide when partition is complete
        boolean done = false;
        // We pick the middle element as the pivot
        int midpoint = l + (h - l) / HALF_LIST;
        T pivot = arr.get(midpoint);

        // Iterate until partition is complete
        while (!done) {
            // Increment l pointer while elements to the left of the midpoint are smaller than the
            // pivot
            while (arr.get(l).compareTo(pivot) < 0) {
                ++l;
            }
            // Decrement h pointer while elements to the right of midpoint are greater than the
            // pivot
            while (arr.get(h).compareTo(pivot) > 0) {
                --h;
            }
            // If the left pointer overtakes the right pointer, all numbers are partitioned and
            // we can return h
            if (l >= h) {
                done = true;
            } else {
                // Swap numbers arr[l] and arr[h] to correctly partition last elements. Update l
                // and h
                T temp = arr.get(l);
                arr.set(l, arr.get(h));
                arr.set(h, temp);
                ++l;
                --h;
            }
        }

        return h;
    }

    /**
     * This method performs a modified QuickSort that switches to insertion sort after a certain
     * cutoff
     *
     * @param list   The arraylist we want to sort
     * @param start  The initial index on subsection of Arraylist we want to sort
     * @param end    The final index of the subsection of Arraylist we want to sort
     * @param cutoff the minimum length of an subsection of the arraylist such that we switch to
     *               Insertion Sort
     */
    public void Modified_QuickSort(ArrayList<T> list, int start, int end, int cutoff) {
        // perform a recursive Quick Sort on the input arraylist until the section of array you
        // are sorting is small enough. If the length of the sub-array <= cutoff, perform
        // insertion sort on that sub-array
        if ((end - start + 1) <= cutoff) {
            InsertionSort(list, start, end);
            return;
        }

        // Partition the data within the array. Value j returned from partitioning is the
        // location of the last element in the low partition
        int j = partition(list, start, end);
        // Recursively sort low partition (start to j) and high partition (j + 1 to end)
        Modified_QuickSort(list, start, j, cutoff);
        Modified_QuickSort(list, j + 1, end, cutoff);
    }

    /**
     * This method performs a Naive TimSort that switches to insertion sort if the list size is
     * smaller than the length of initial splits
     *
     * @param list  The arraylist we want to sort
     * @param start The initial index on subsection of Arraylist we want to sort
     * @param end   The final index of the subsection of Arraylist we want to sort
     * @param param The length of the initial splits that are sorted prior to merging
     */
    public void TimSort(ArrayList<T> list, int start, int end, int param) {
        // If param >= length of array to be sorted, default to insertion sort
        if ((end - start + 1) <= param) {
            InsertionSort(list, start, end);
        } else {
            // Sort sub-arrays of size param using Insertion Sort
            for (int i = start; i <= end; i += param) {
                // If last sub-array has size < param, InsertionSort only till end to avoid 
                // IndexOutOfBoundsException
                InsertionSort(list, i, Math.min(i + param - 1, end));
            }

            // Size of merged sub-arrays. Initialized to size of first sub-array
            int size = param;
            // While size of merged sub-arrays is less than size of list to be sorted
            while (size < (end - start + 1)) {
                // At each iteration, increment start index by size of the merged sub-arrays.
                // Each iteration will merge sets of two pairs of sub-arrays
                for (int i = start; i <= end; i += size * HALF_LIST) {
                    // Calculate middle index by incrementing start by size of merged sub-arrays.
                    // Mid is the index of the last element in previous sub-array. Choose minimum
                    // of this index and end to avoid IndexOutOfBoundsException
                    int mid = Math.min(i + size - 1, end);
                    // Calculate the end index for the sweep by choosing the minimum value from
                    // mid + size of merged sub-arrays and end
                    int right = Math.min(mid + size, end);
                    // Merge sub-arrays using merge helper function
                    merge(list, i, mid, right);
                }
                // Increase the size of the merged sub-arrays by a factor of 2
                size *= HALF_LIST;
            }
        }
    }
}
