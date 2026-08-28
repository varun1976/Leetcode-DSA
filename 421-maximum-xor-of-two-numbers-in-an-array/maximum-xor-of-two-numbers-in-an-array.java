class TrieNode{
    TrieNode child[]=new TrieNode[2];
}

class Trie{
    TrieNode root;
    Trie(){
        root=new TrieNode();
    }

    public void insert(int num){
        TrieNode node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.child[bit]==null)
                node.child[bit]=new TrieNode();
            node=node.child[bit];
        }
    }

    public int getMax(int num){
        int maxi=0;
        TrieNode node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.child[1-bit]!=null){
                maxi=maxi|(1<<i);
                node=node.child[1-bit];
            }
            else{
                node=node.child[bit];
            } 
        }
        return maxi;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie=new Trie();
        int maxi=0;
        for(int num:nums) trie.insert(num);
        for(int num:nums) maxi=Math.max(maxi,trie.getMax(num));
        return maxi;
    }
}