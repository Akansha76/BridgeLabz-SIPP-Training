package StringBuilderBuffer;

public class FindRotationPoint {
    public static int findRotationIndex(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // Index of the smallest element
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 2, 3, 4, 5};
        int index = findRotationIndex(arr);
        System.out.println("Rotation point index: " + index);
    }
}

