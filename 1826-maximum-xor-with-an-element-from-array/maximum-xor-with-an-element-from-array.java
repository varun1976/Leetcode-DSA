class TrieNode {
    TrieNode child[] = new TrieNode[2];
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode node = root;

        for(int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if(node.child[bit] == null)
                node.child[bit] = new TrieNode();

            node = node.child[bit];
        }
    }

    public int getMax(int num) {
        int maxi = 0;
        TrieNode node = root;

        for(int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if(node.child[1 - bit] != null) {
                maxi |= (1 << i);
                node = node.child[1 - bit];
            } else {
                node = node.child[bit];
            }
        }

        return maxi;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        Integer[] indices = new Integer[queries.length];
        for(int i = 0; i < queries.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> queries[a][1] - queries[b][1]);

        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);
        Trie trie = new Trie();
        int j = 0;
        for(int index : indices) {
            int x = queries[index][0];
            int m = queries[index][1];

            while(j < nums.length && nums[j] <= m) {
                trie.insert(nums[j]);
                j++;
            }

            if(j > 0) {
                answer[index] = trie.getMax(x);
            }
        }

        return answer;
    }
}