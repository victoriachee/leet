package practice.ModdedBinarySearch;

public class OrderAgnosticBinarySearch {

    /**
     * https://www.geeksforgeeks.org/order-agnostic-binary-search/
     * 
     * The binarySearch function searches for a target element in a sorted array using binary search
     * algorithm, considering both ascending and descending order.
     * 
     * @param arr The `arr` parameter is an array of integers in which you want to perform the binary
     * search.
     * @param start The `start` parameter in the `binarySearch` method represents the starting index of
     * the subarray where the binary search will be performed. It indicates the beginning of the range
     * within which the search for the target element `x` will take place.
     * @param end The `end` parameter in the `binarySearch` method represents the index of the last
     * element in the array `arr` that you want to search within. It indicates the end of the range
     * where the binary search algorithm will look for the element `x`.
     * @param x The parameter `x` in the `binarySearch` method represents the element that you are
     * searching for within the array. The method will search for this element `x` within the given
     * array `arr` between the indices `start` and `end`. If the element `x` is found in
     * @return The binarySearch method returns the index of the element `x` in the given array `arr` if
     * it is found, or -1 if the element is not present in the array.
     */
    public static int binarySearch(int arr[], int start, int end, int x){
        //1. Check if ascending
        boolean ascending = arr[start] < arr[end];

        while (start <= end) {
            //2. Check if x is at middle, return middle index
            int middle = start + (end - start) / 2;
            if (arr[middle] == x) {
                return middle;
            }

            //3. If ascending order
            if (ascending) {
                //If x is more than middle, ignore left half
                if (arr[middle] < x) {
                    start = middle + 1;
                } else {
                //If x is less than middle, ignore right half
                    end = middle - 1;
                }
            } else {
            //4. If descending order
                //If x is less than middle, ignore left half
                if (arr[middle] > x) {
                    start = middle + 1;
                } else {
                //If x is more than middle, ignore right half
                    end = middle - 1;
                }
            }
        }
        //5. Element cannot be found
        return -1;

    }
    public static void main(String[] args) {
        // Test cases
        int[] ascendingArr = {1, 3, 5, 7, 9, 11};
        int[] descendingArr = {11, 9, 7, 5, 3, 1};

        int target1 = 7;
        int target2 = 4;

        System.out.println("Index of " + target1 + " in ascending array: " + binarySearch(ascendingArr, 0, ascendingArr.length - 1, target1));
        System.out.println("Index of " + target2 + " in ascending array: " + binarySearch(ascendingArr, 0, ascendingArr.length - 1, target2));

        System.out.println("Index of " + target1 + " in descending array: " + binarySearch(descendingArr, 0, descendingArr.length - 1, target1));
        System.out.println("Index of " + target2 + " in descending array: " + binarySearch(descendingArr, 0, descendingArr.length - 1, target2));
    }
}
