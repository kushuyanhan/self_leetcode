/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuemaomao
 *
 */
public class LRU {
	public static void main(String[] args) {
		System.out.println();
		LRUCache obj = new LRUCache(2);
		obj.put(1,1);
		obj.put(2,2);
		System.out.println(obj.get(1));
		obj.put(3,3);
		System.out.println(obj.get(2));
		obj.put(4,4);
		System.out.println(obj.get(1));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
		
	}
}
class LRUCache {
    private class Node{
       Node prev;
       Node next;
       int key;
       int value;

       public Node(int key, int value) {
           this.key = key;
           this.value = value;
           this.prev = null;
           this.next = null;
       }
   }
   private int capacity;
   private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
   private Node head = new Node(-1, -1);
   private Node tail = new Node(-1, -1);
   
   public LRUCache(int capacity) {
       this.capacity = capacity;
       tail.prev = head;
       head.next = tail;
   }
   
   public int get(int key) {
        // write your code here
       if (!hs.containsKey(key)) {
           return -1;
       }

       // remove current
       Node current = hs.get(key);
       current.prev.next = current.next;
       current.next.prev = current.prev;

       // move current to tail
       move_to_tail(current);

       return hs.get(key).value;
   }
   
   public void put(int key, int value) {
       if (get(key) != -1) {  // // get（） 这个方法会把key挪到最末端，因此，不需要再调用 move_to_tail,这里不用map来判断的原因是，每次get()的节点要从原来的位置删掉，并且把get() 的节点从当前位置移动到tail, 而这2步在get()中已经做到了， 所以直接用get() 来判断。如果只用map() 来判断，还要在这里写上面的删除和挪到tail 的步骤。
           hs.get(key).value = value;
           return;
       }

       if (hs.size() == capacity) {
           hs.remove(head.next.key);
           head.next = head.next.next;
           head.next.prev = head;
       }

       Node insert = new Node(key, value);
       hs.put(key, insert);
       move_to_tail(insert);
   }
   
    private void move_to_tail(Node current) {
       current.prev = tail.prev;
       tail.prev = current;
       current.prev.next = current;
       current.next = tail;
   }
}