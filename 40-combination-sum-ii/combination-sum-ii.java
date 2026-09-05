class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        subSequence(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    public void subSequence(int start, int target, int[] candidates, List<Integer> dp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(dp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // Prune if sum exceeds target

            dp.add(candidates[i]);
            subSequence(i + 1, target - candidates[i], candidates, dp, res);  // i+1: each element used once
            dp.remove(dp.size() - 1);
        }
    }
}
