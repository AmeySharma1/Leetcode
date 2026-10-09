class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val>=low && node.val<=high){
                sum += node.val;
            }
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);

        }
        return sum;
    }
}
