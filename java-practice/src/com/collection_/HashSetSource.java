package com.collection_;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set="+hashSet);
    }
        /*
        1.执行 HashSet()
            public HashSet() {
                map = new HashMap<>();
            }
        2.执行add()
            public boolean add(E e) {//e=java
                return map.put(e, PRESENT)==null; //(static) PRESENT = new Object()
            }
        3.执行 put()，该方法会执行hash(key)得到对应的hash值 算法h = key.hashCode() ^ (h >>> 16)
            public V put(K key, V value) { //key = "java"  value = PRESENT
                return putVal(hash(key), key, value, false, true);
            }
        4.执行 putVal
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;  //定义辅助变量
                //table 就是 HashMap 的一个数组，类型是Node[]
                //if 语句表示如果当前table为null，或者大小=0，就进行第一次扩容，到16个空间大小
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
                //(1)根据key，得到hash去计算该key应该存放到table表的哪个索引位置，并把这个位置的对象，赋给p
                //(2)判断 p 是否为 null
                //(2.1)如果 p 为 null，表示还没有存放元素，就创建一个Node(key="java",value=PRESENT)
                //(2.2)就放在该位置 tab[i] = newNode(hash, key, value, null)
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    Node<K,V> e; K k;  //定义辅助变量
                    //如果当前索引位置对应的链表的第一个元素和准备添加的key的hash值是同一个对象
                    //并且满足下面两个条件之一：
                    //(1)(k = p.key) == key：准备加入的key 和 p 指向的Node节点的key是同一个对象
                    //(2)p 指向的Node节点的key的equals()和准备加入的key比较后相同
                    //就不能加入
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    //再判断 p 是不是红黑树，如果是红黑树，就调用 putTreeVal 来进行添加
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    //如果table对应索引位置已经是一个链表，就使用for循环比较
                    //(1)依次和该链表的每一个元素比较后，都不相同，则加入到该链表的最后
                    //   注意：在把元素添加到链表后，立即判断该链表是否已经到达8个节点，如果到达，则调用 treeifyBin()，
                    //   if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY):
                    //   如果table到达64，则进行树化，否则进行扩容
                    //(2)依次和该链表的每一个元素比较过程中，如果比较相同，则break
                    else {
                        for (int binCount = 0; ; ++binCount) {
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null;
            }
         */
}
