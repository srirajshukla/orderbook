import java.util.HashMap;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        // app.testBST();
        // app.testDLL();
        app.testOBook();
    }

    public void testDLL() throws Exception {
        DoubleLinkedList dll = new DoubleLinkedList();

        HashMap<Integer, ListNode> map = new HashMap<>();

        for(int i=0; i<100; i++){
            ListNode ptr = dll.add(i*i);
            map.put(i, ptr);
        }

        ListNode onep = map.get(1);
        System.out.println(onep.next.key);
        dll.remove(4);
        dll.print();
        System.out.println(onep.next.key);

        for(int i=0; i<100; i++){
            int v = (i+20)%100;
            ListNode ptr = map.get(v);
            System.out.println(v + " : " + ptr.key);
        }
    }

    public void testBST() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        HashMap<Integer, BSNode> map = new HashMap<>();

        for(int i=0; i<100; i++){
            int r = (int) Math.rint(Math.random()*100);
            BSNode n = bst.insert(r);
            n.ll.add(r*r);
            map.put(r, n);
        }

        bst.print(bst.root);

        for(int i=0; i<100; i++){
            int r = (int) Math.rint(Math.random()*100);
            if (map.containsKey(r)){
                BSNode n = map.get(r);
                System.out.println(r + " : " + n.key);
                n.ll.print();
            } else {
                System.out.println(r + " : " + "null");
            }
        }
    }

    public void testOBook() throws Exception {
        OBook obook = new OBook();

        Random r = new Random();
        int lowPrice = 30;
        int highPrice = 40;

        for(int i=0; i<100; i++){
            int price = r.nextInt(highPrice-lowPrice) + lowPrice;
            int orderId = i;
            obook.newOrder(orderId, price);
        }

        obook.tree.print(obook.tree.root);

        obook.priceMap.get(35).ll.print();
        System.out.println(obook.priceMap.get(35).ll.head.key);
    }
}
