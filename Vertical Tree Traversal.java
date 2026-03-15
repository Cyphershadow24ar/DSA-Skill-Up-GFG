// PROBLEM : Vertical Tree Traversal

// SOLUTION :

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        int min = 0, max = 0;

        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {

            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            if(!map.containsKey(hd))
                map.put(hd, new ArrayList<>());

            map.get(hd).add(curr.data);

            min = Math.min(min, hd);
            max = Math.max(max, hd);

            if(curr.left != null)
                q.add(new Pair(curr.left, hd - 1));

            if(curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        for(int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}
