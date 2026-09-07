/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        HashMap<Node, Node> clonedNodes = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node clonedNode = new Node(node.val);
        clonedNodes.put(node, clonedNode);
        queue.add(node);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for(Node neighbor : currentNode.neighbors) {
                if(!clonedNodes.containsKey(neighbor)) {
                    clonedNodes.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                clonedNodes.get(currentNode).neighbors.add(clonedNodes.get(neighbor));
            }
        }

        return clonedNode;
    }
}