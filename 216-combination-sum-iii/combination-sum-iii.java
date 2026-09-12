class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int k, int target,List<Integer> ds,List<List<Integer>> res) {
        if (ds.size() == k) {
            if (target == 0)
                res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target) break;
            ds.add(i);
            backtrack(i + 1, k, target - i, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}