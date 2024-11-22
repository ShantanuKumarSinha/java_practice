package shann.java.problems.linkedList.doubleLinkedList.lru.cache;

import static shann.java.problems.linkedList.doubleLinkedList.utility.DoubelLinkedListUtilityClass.printNextValuesFromDoubelLinkedListUtilityClass;
import static shann.java.problems.linkedList.doubleLinkedList.utility.DoubelLinkedListUtilityClass.printPreviousValuesFromDoubelLinkedListUtilityClass;

import java.util.HashMap;
import java.util.Map;
import shann.java.problems.linkedList.doubleLinkedList.utility.ListNode;

public class LRUCache {
  Map<Integer, ListNode> map = new HashMap<>();
  ListNode head = new ListNode(-1);
  ListNode tail = new ListNode(-1);

  public static void main(String[] args) {
    int capacity = 3;
    LRUCache lruCache = new LRUCache();
    lruCache.head.next = lruCache.tail;
    lruCache.tail.prev = lruCache.head;
    lruCache.add(capacity, 2);
    lruCache.add(capacity, 3);
    lruCache.add(capacity, 4);
    lruCache.add(capacity, 5);

    printNextValuesFromDoubelLinkedListUtilityClass(lruCache.head);
    printPreviousValuesFromDoubelLinkedListUtilityClass(lruCache.tail);
  }

  private void add(int capacity, int key) {
    if (search(key)) {
      var curr = map.get(key);
      remove(curr);
      ListNode newNode = new ListNode(key);
      insertAtLast(newNode);
      map.put(key, newNode);
    } else {
      if (map.size() == capacity) {
        var temp = head.next;
        remove(temp);
        map.remove(temp.val);
        var newNode = new ListNode(key);
        insertAtLast(newNode);
        map.put(key, newNode);
      } else {
        var newNode = new ListNode(key);
        insertAtLast(newNode);
        map.put(key, newNode);
      }
    }
  }

  private boolean search(int key) {
    return map.containsKey(key);
  }

  private void remove(ListNode temp) {
    var prev = temp.prev;
    var next = temp.next;
    prev.next = next;
    next.prev = prev;
    temp.next = null;
    temp.prev = null;
  }

  private void insertAtLast(ListNode newNode) {
    var temp = tail.prev;
    tail.prev = newNode;
    temp.next = newNode;
    newNode.prev = temp;
    newNode.next = tail;
  }
}
