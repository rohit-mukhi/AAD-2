public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 3, 2, 7, 1, 8, 9};
        mergeSort(arr, 0, arr.length-1);
        for(int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int idx=0;

        while(left <=mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }

        while(left <= mid) {
            temp[idx++] = arr[left++];
        }

        while(right <= high) {
            temp[idx++] = arr[right++];
        }

        for(int i=0; i<temp.length; i++) {
            arr[low+i] = temp[i];
        }
    }
}
