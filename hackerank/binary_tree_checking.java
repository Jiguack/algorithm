/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    ArrayList<Integer> al = new ArrayList<Integer>();

    void addList(int m) {
        al.add(m);
    }

    boolean isGoodList() {
        for (int i=0; i < al.size(); i++) {
            if (i>0)
                if (al.get(i-1) >= al.get(i))
                    return false;
        }
        return true;
    }

    boolean checkBST(Node root) {
        boolean ret_l = true;
        boolean ret_r = true;

        if (root.left == null
           && root.right == null) {
            addList(root.data);
            return true;
        }

        if (root.left != null) {
            if (root.left.data >= root.data)
                return false;
            else
                ret_l = checkBST(root.left);
        }

        addList(root.data);

        if (root.right != null) {
            if (root.right.data <= root.data)
                return false;
            else
                ret_r = checkBST(root.right);
        }

        return (isGoodList() && ret_l && ret_r);
    }
