class LRUCache {
    Deque<Integer> queue;
    HashMap<Integer,Integer> map;
    int noOfFrames;
    LRUCache(int capacity) {
        noOfFrames = capacity;
        queue = new LinkedList<>();
        map  = new HashMap<>();
    }
    
    int get(int key) {
        if(map.containsKey(key))
        {
            queue.remove(key);
            queue.addFirst(key);
        }
        return map.getOrDefault(key,-1);
        
    }
    
    void put(int key, int value) {
        if(map.containsKey(key))
        {
            map.put(key,value);
            queue.remove(key);
            queue.addFirst(key);
            return;
        }
            if(queue.size()==noOfFrames)
            {
                int last = queue.removeLast();
                map.remove(last);
            }
            queue.addFirst(key);
            map.put(key,value);
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */