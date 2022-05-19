
/**
 * A Node for the BinarySearchTree.
 * The key is the price level.
 * Contains a reference to the double link list for the orders
 * at this price level.
 */
class BSNode {
    int key;
    BSNode left, right, parent;
    DoubleLinkedList ll;

    public BSNode(int key, BSNode left, BSNode right, BSNode parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.ll = new DoubleLinkedList();
    }
}

/**
 * 
 */
public class BinarySearchTree {
    BSNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BSNode insert(int key){
        BSNode newNode = new BSNode(key, null, null, null);
        if(root == null){
            root = newNode;
        }
        else{
            BSNode curr = root;
            BSNode parent = null;
            while(curr != null){
                parent = curr;
                if(key < curr.key){
                    curr = curr.left;
                }
                else{
                    curr = curr.right;
                }
            }
            if(key < parent.key){
                parent.left = newNode;
            }
            else{
                parent.right = newNode;
            }
            newNode.parent = parent;
        }
        return newNode;
    }

    public BSNode search(int key){
        BSNode curr = root;
        while(curr != null){
            if(curr.key == key){
                return curr;
            }
            else if(key < curr.key){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        return null;
    }

    public BSNode minimum(BSNode root){
        BSNode curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    public BSNode maximum(BSNode root){
        BSNode curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr;
    }

    public BSNode successor(BSNode node){
        if(node.right != null){
            return minimum(node.right);
        }
        BSNode curr = node.parent;
        while(curr != null && node == curr.right){
            node = curr;
            curr = curr.parent;
        }
        return curr;
    }

    public BSNode predecessor(BSNode node){
        if(node.left != null){
            return maximum(node.left);
        }
        BSNode curr = node.parent;
        while(curr != null && node == curr.left){
            node = curr;
            curr = curr.parent;
        }
        return curr;
    }

    public void delete(int key){
        BSNode node = search(key);
        if(node == null){
            return;
        }
        if(node.left == null){
            transplant(node, node.right);
        }
        else if(node.right == null){
            transplant(node, node.left);
        }
        else{
            BSNode min = minimum(node.right);
            if(min.parent != node){
                transplant(min, min.right);
                min.right = node.right;
                min.right.parent = min;
            }
            transplant(node, min);
            min.left = node.left;
            min.left.parent = min;
        }
    }

    public void transplant(BSNode u, BSNode v){
        if(u.parent == null){
            root = v;
        }
        else if(u == u.parent.left){
            u.parent.left = v;
        }
        else{
            u.parent.right = v;
        }
        if(v != null){
            v.parent = u.parent;
        }
    }


    public void print(BSNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        root.ll.print();
        print(root.left);
        print(root.right);
    }
}
