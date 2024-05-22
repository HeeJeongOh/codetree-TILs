import java.util.*;

public class Main {
    // Function to check if the selected subset causes a carry
    static boolean checkCarry(int[] sample) {
        int maxLength = 0;
        for (int num : sample) {
            int length = String.valueOf(num).length();
            maxLength = Math.max(maxLength, length);
        }
        
        for (int pos = 0; pos < maxLength; pos++) {
            int columnSum = 0;
            for (int num : sample) {
                String numStr = String.valueOf(num);
                int digitIndex = numStr.length() - 1 - pos;
                if (digitIndex >= 0) {
                    columnSum += numStr.charAt(digitIndex) - '0';
                }
            }
            if (columnSum >= 10) {
                return false;
            }
        }
        return true;
    }

    // Recursive function to find the maximum subset without carry
    static int combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            ArrayList<Integer> selected = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    selected.add(arr[i]);
                }
            }
            int[] subset = selected.stream().mapToInt(i -> i).toArray();
            if (checkCarry(subset)) {
                return subset.length;
            }
            return 0;
        }
        
        for (int i = start; i < n; i++) {
            visited[i] = true;
            int result = combination(arr, visited, i + 1, n, r - 1);
            if (result > 0) return result;  // Return immediately if a valid subset is found
            visited[i] = false;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Iterate from largest to smallest subset size
        for (int r = n; r > 0; r--) {
            boolean[] visited = new boolean[n];
            int result = combination(nums, visited, 0, n, r);
            if (result > 0) {
                System.out.println(result);
                break;
            }
        }
    }
}