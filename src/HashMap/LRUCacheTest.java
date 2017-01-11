package HashMap;

/**
 * Created by tharun on 1/11/17.
 * Problem description : https://leetcode.com/problems/lru-cache/
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class DLLNode {
    int key;
    int value;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;

    public DoublyLinkedList() {
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addToFront(DLLNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void moveToFront(DLLNode node) {
        deleteNode(node);
        addToFront(node);
    }

    public void deleteNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class LRUCache {
    DoublyLinkedList list;
    HashMap<Integer, DLLNode> cache;
    int numOfElements;
    int capacity;

    public LRUCache(int capacity) {
        this.list = new DoublyLinkedList();
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.numOfElements = 0;
    }

    public int get(int key) {
        // System.out.println(cache.get(key));
        if (cache.get(key) != null) {
            DLLNode node = cache.get(key);
            list.moveToFront(node);
            return node.value;
        }
        return -1; // raise exception instead;
    }

    public void set(int key, int value) {
        if (cache.get(key) != null) {
            DLLNode node = cache.get(key);
            node.value = value;
            list.moveToFront(node);
            // cache.put(key, node);
        } else {
            DLLNode node = new DLLNode(key, value);
            list.addToFront(node);
            cache.put(key, node);
            numOfElements++;
        }

        if (numOfElements > capacity) {
            DLLNode lastNode = list.tail.prev;
            cache.remove(lastNode.key);
            list.deleteNode(lastNode);
            numOfElements--;
        }
    }
}

public class LRUCacheTest {
    @Test
    public void testKeyNotFound() {
        LRUCache cache = new LRUCache(1);
        assertEquals(-1, cache.get(1));
    }

    @Test
    public void testLRUCache() {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 2);
        cache.set(2, 1);
        assertEquals(2, cache.get(1));

        cache.set(3, 2);
        assertEquals(-1, cache.get(2));
    }
}
