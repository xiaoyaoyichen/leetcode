package 简单.叶子相似的树;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, seq1);
        }
        List<Integer> seq2 = new ArrayList<>();
        if (root2 != null) {
            dfs(root2, seq2);
        }
        return Objects.equals(seq1, seq2);
    }


    public void dfs(TreeNode root, List<Integer> seq) {
        if (root.left == null && root.right == null) {
            seq.add(root.val);
        }
        if (root.left != null) {
            dfs(root.left, seq);
        }
        if (root.right != null) {
            dfs(root.right, seq);
        }
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