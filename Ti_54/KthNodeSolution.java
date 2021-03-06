import java.util.ArrayList;

public class KthNodeSolution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode pHead;

    // 查找树
    public void put(int e) {
        pHead = put(pHead, e);
    }

    private TreeNode put(TreeNode node, int e) {
        if (node == null) {
            return new TreeNode(e);
        }

        if (e < node.val) {
            node.left = put(node.left, e);
        } else if (e > node.val) {
            node.right = put(node.right, e);
        } else {
        }
        return node;
    }

    // 方法1：将中序遍历序列全部遍历完找出第k个
    TreeNode KthNode1(TreeNode pRoot, int k) {
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        KthNode(pRoot, arrayList);
        if (k <= 0 || k > arrayList.size()) {
            return null;
        }
        return arrayList.get(k - 1);
    }

    ArrayList<TreeNode> KthNode(TreeNode pRoot, ArrayList<TreeNode> arrayList) {
        if (pRoot == null) {
            return null;
        }
        KthNode(pRoot.left, arrayList);
        arrayList.add(pRoot);
        KthNode(pRoot.right, arrayList);
        return arrayList;
    }

    // 方法2：在中序遍历过程中找到第k大结点就直接返回
    // java中如何在遍历过程中改变k的值？无指针地址&k
    TreeNode KthNode2(TreeNode pRoot, int k) {
        // TODO:
        return null;
    }

    public static void main(String[] args) {
        KthNodeSolution kthNodeSolution = new KthNodeSolution();
        kthNodeSolution.put(5);
        kthNodeSolution.put(3);
        kthNodeSolution.put(7);
        kthNodeSolution.put(2);
        kthNodeSolution.put(4);
        kthNodeSolution.put(6);
        kthNodeSolution.put(8);

        TreeNode res = kthNodeSolution.KthNode1(kthNodeSolution.pHead, 7);
        if (res == null){
            System.out.println(res);
        }else {
            System.out.println(res.val);
        }
    }
}
