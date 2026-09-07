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

// //DFS
// class Solution {
//     HashMap<Node, Node> map = new HashMap<>();

//     public Node cloneGraph(Node node) {
//         if(node == null) return null;
//         return clone(node);
//     }

//     public Node clone(Node node) {
//         if(map.containsKey(node)) {
//             return map.get(node);
//         }

//         Node copy = new Node(node.val);
//         map.put(node, copy);

//         for(Node nei : node.neighbors) {
//             copy.neighbors.add(clone(nei));
//         }

//         return copy;
//     }
// }