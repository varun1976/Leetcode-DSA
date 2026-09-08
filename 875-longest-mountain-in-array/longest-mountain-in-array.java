class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length, ans = 0, i = 1;

        while (i < n - 1) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) { //consider as peak

                int l = i, r = i;
                while (l > 0 && arr[l - 1] < arr[l]) l--;
                while (r < n - 1 && arr[r] > arr[r + 1]) r++;
                ans = Math.max(ans, r - l + 1);
                i = r;
            } else {
                i++;
            }
        }

        return ans;
    }
}