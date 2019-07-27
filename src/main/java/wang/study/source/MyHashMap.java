package wang.study.source;


import java.util.*;

public class MyHashMap<K, V> extends AbstractMap<K, V> {

    // 默认负载因子
    static final Float DEFAULT_LOAD_FACTOR = 0.75f;

    // 最大容量
    static final Integer MAXIMUM_CAPACITY = 200;

    // 负载因子
    Float loadFactor;

    // 容量
    int capacity;

    // 当前size
    transient int size;

    // 自动扩容阀值
    int threshold;

    transient Node[] table;

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, Float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity:" + initialCapacity);

        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;

        if (loadFactor < 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor:" + loadFactor);

        // 计算出大于initialCapacity的最小的2的n次方
        int tmpCapacity = 1;
        while (tmpCapacity < initialCapacity) {
            tmpCapacity <<= 1;
        }

        this.capacity = tmpCapacity;
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
        table = new Node[capacity];
    }

    @Override
    public V put(K key, V value) {
        // 如果key为null,调用putForNullKey.
        if (key == null)
            return putForNullKey(value);

        int hash = hash(key.hashCode());

        int i = indexFor(hash, capacity);

        for (Node<K, V> e = table[i]; e != null; e = e.next) {
            Object k;

            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        // 将key,value添加至i处
        addEntry(hash, key, value, i);
        return value;
    }

    // key 为 null 插入到第一个节点
    private V putForNullKey(V value) {
        return value;
    }

    /**
     * 将key,value添加至i处
     * @param hash hash值
     * @param key key值
     * @param value value值
     * @param bucketIndex 数组中的位置
     */
    void addEntry(int hash, K key, V value, int bucketIndex) {
        Node<K, V> e = table[bucketIndex];
        table[bucketIndex] = new Node<>(hash, key, value, e);
        if (size++ >= threshold)
            resize();
    }

    void resize() {
        //如果旧的容量已经是系统默认最大容量了，那么将阈值设置成整形的最大值
        if (capacity == MAXIMUM_CAPACITY) {
            threshold = MAXIMUM_CAPACITY;
            return;
        }

        int newCapacity = capacity * 2;
        Node[] newTable = new Node[newCapacity];

        // 将旧的数据迁移到新的表中
        transfer(newTable);

        capacity = newCapacity;
        table = newTable;
        threshold = tableSizeFor(capacity);
    }

    /**
     * 将旧表中的数据转换到新表中
     * @param newTable 新表
     */
    void transfer(Node[] newTable) {
        // 旧的table
        Node[] src = table;
        int newCapacity = newTable.length;

        for (int i = 0; i < capacity; i++) {
            Node<K, V> e = src[i];
            if (e != null) {
                src[i] = null;
                do {
                    // 头插法
                    Node<K, V> next = e.next;
                    int j = indexFor(e.hash, newCapacity);
                    e.next = newTable[j];
                    newTable[j] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    static int indexFor(int h, int length) {
        return h % (length - 1);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;

        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Entry) obj;
                return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
            }
            return false;
        }
    }
}
