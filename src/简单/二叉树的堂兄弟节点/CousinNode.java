package 简单.二叉树的堂兄弟节点;

public class CousinNode {

    private int x;
    private TreeNode xParent;
    private int xDepth;
    private boolean xFound;

    private int y;
    private TreeNode yParent;
    private int yDepth;
    private boolean yFound;


    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }


    public void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xParent = parent;
            xFound = true;
            xDepth = depth;
        }
        if (node.val == y) {
            yParent = parent;
            yFound = true;
            yDepth = depth;
        }

        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);
        dfs(node.right, depth + 1, node);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
