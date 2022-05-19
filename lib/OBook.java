import java.util.HashMap;

public class OBook {
    BinarySearchTree tree;
    HashMap<Integer, ListNode> orderMap = new HashMap<>();
    HashMap<Integer, BSNode> priceMap = new HashMap<>();

    public OBook() {
        tree = new BinarySearchTree();
    }

    public void newOrder(int orderId, int price){
        if (priceMap.containsKey(price)){
            BSNode node = priceMap.get(price);
            ListNode ptr = node.ll.add(orderId);
            orderMap.put(orderId, ptr);
        }
        else{
            BSNode node = tree.insert(price);
            ListNode ptr = node.ll.add(orderId);
            orderMap.put(orderId, ptr);
            priceMap.put(price, node);
        }
    }
}
