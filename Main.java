/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> level_queue = new LinkedList<>();

        level_queue.add(root);
        level_queue.add(null);

        List<Double> avg_list = new ArrayList<>();


        while (level_queue.peek() != null) {

            double sum = 0;
            int nodes = 0;

            while (level_queue.peek() != null) {

                TreeNode node = level_queue.poll();

                sum += node.val;
                nodes++;

                if (node.left != null) level_queue.add(node.left);
                if (node.right != null) level_queue.add(node.right);
            }

            level_queue.add(level_queue.poll());
            avg_list.add(sum / nodes);
        }

        return avg_list;

    }

}