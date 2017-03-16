/*
Two HashMaps are used, one to store <key, value> pair, another store the <key, node>.
Use doubly linked list to keep the frequent of each key. In each double linked list node, 
keys with the same count are saved using java built in LinkedHashSet. This can keep the order.
Every time, one key is referenced, first find the current node corresponding to the key, 
if the following node exist and the frequent is larger by one, add key to the keys of the following node, 
else create a new node and add it following the current node.
All operations are guaranteed to be O(1).
*/

public class LFUCache {
    // 构建doubly linked list，freqNode按照frequency数从小到大排列
    private freqNode head = null;
    private int capacity;
    // for storage of key and its value (key, value)
    private Map<Integer, Integer> valueMap;
    // for storage of key and its mapping freqNode
    private Map<Integer, freqNode> freqMap;
    
    // freqNode,双端序列node
    class freqNode{
        int freq = 0;
        LinkedHashSet<Integer> keys = null;
        freqNode pre, next;
        public freqNode(int freq) {
            this.freq = freq;
            keys = new LinkedHashSet<>();
            pre = null;
            next = null;
        }
    }
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        // 如果valueMap里存在key
        if (valueMap.containsKey(key)) {
            // freq数+1
            increaseCount(key);
            return valueMap.get(key);
        }
        // 如果valueMap里不存在，返回-1
        return -1;
    }
    
    // increase frequency of a key
    private void increaseCount(int key) {
        // 得到当前freqNode
        freqNode node = freqMap.get(key);
        // 删去当前freqNode的LinkedHashSet里的key
        node.keys.remove(key);
        
        // 把key加入到下一个freqNode(count+1)里
        // 如果下一个freqNode不存在
        if (node.next == null) {
            node.next = new freqNode(node.freq + 1);
            node.next.pre = node;
            // 不要忘记把key加入到新的freqNode里
            node.next.keys.add(key);
        // 如果下一个freqNode(count+1)存在，直接加入到此freqNode里
        } else if (node.next.freq == node.freq + 1) {
            node.next.keys.add(key);
        // 如果下一个freqNode存在，但不是(count+1)
        } else {
            freqNode tmp = new freqNode(node.freq + 1);
            // 不要忘记把key加入到新的freqNode里
            tmp.keys.add(key);
            tmp.next = node.next;
            node.next.pre = tmp;
            node.next = tmp;
            tmp.pre = node;
        }
        
        // 不要忘记把新的(key,freqNode) pair放进freqMap
        freqMap.put(key, node.next);
        // 如果当前node的keys为空，将其删除
        if (node.keys.size() == 0) {
            remove(node);
        }
    }
    
    private void remove(freqNode node) {
        // 先处理当前freqNode的前一个
        // node是doubly linked list的head
        if (node.pre == null) {
            head = node.next;
        } else {
            node.pre.next = node.next;
        }
        
        // 处理当前freqNode的后一个
        if (node.next != null) {
            node.next.pre = node.pre;
        }
    }
    
    public void put(int key, int value) {
        // 此LFU容量为0
        if (capacity == 0) {
            return;
        }
        // 如果已经存在此key，重置此key的value值
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
        // 如果不存在此key，分两种情况
        } else {
            // 没有达到capacity上限时
            if (valueMap.size() < capacity) {
                valueMap.put(key, value);
            // 当已经达到capacity上限时：先踢走最不常用的旧元素；加入新的元素
            } else {
                // 需要把频率最低最不常用的踢走
                removeOld();
                valueMap.put(key, value);
            }
            // 把key加入到freq = 0的freqNode里
            addToHead(key);
        }
        increaseCount(key);
    }
    
    // 踢走最不常用的(invalidate the least frequently used item)
    private void removeOld() {
        // 如果doubly linked list为空，直接返回值
        if (head == null) {
            return;
        }
        // 取出head(频率最低的freqNode)里最早放入的key(即最不常用的)
        int old = 0;
        for (int n: head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        // 若取出后freqNode为空
        if (head.keys.size() == 0) {
            // 移走此freqNode
            remove(head);
        }
        // 不要忘记把valueMap/freqMap里对应的pair移走
        valueMap.remove(old);
        freqMap.remove(old);
    }
    
    // 将key放入双端序列的头部
    private void addToHead(int key) {
        // 如果此时序列为空
        if (head == null) {
            head = new freqNode(0);
            head.keys.add(key);
        // 如果此时序列不为空，但是头部的freqNode其freq!=1
        } else if (head.freq > 0) {
            // 新加入一个freq=0的freqNode
            freqNode node = new freqNode(0);
            // 不要忘记更新node的前后node状态
            node.keys.add(key);
            node.next = head;
            head.pre = node;
            // 将head置为当前node
            head = node;
        // 如果此时序列不为空且头freqNode的freq=0
        } else {
            head.keys.add(key);
        }
        // 不要忘记把(key, head)pair放入freqMap
        freqMap.put(key, head);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */