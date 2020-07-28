package map;

import tree.RedBlackTree;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
 * @breif:hashmap
 * @Author: lyq
 * @Date: 2020/4/28 11:29
 * @Month:04
 */
public class ArMap<K,V> implements Ar<K,V>{
    public static final boolean RED=true;
    public static final boolean BLACK=false;
    public static final Integer CAPACITY=1 << 4;
    RBNode<K,V>[] table;
    int size;


    public ArMap(){
        table=new RBNode[CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clean() {

    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public V put(K k, V v) {
        int hash = hash(k);
        RBNode<K, V> root = table[hash];
        //当前索引根节点为空
        if(root==null){
            root=new RBNode<>(k,v);
            table[hash]=root;
            size++;
            affteradd(root);
            return null;
        }
        RBNode<K, V> add = add(k, v);
        affteradd(add);

        return null;
    }

    /**
     * 比较  map的核心方法
     * @param k
     * @param k1
     * @return
     */
    private int compare(K k, K k1) {
        int h1=k==null?0:k.hashCode();
        int h2=k1==null?0:k1.hashCode();
        //hash不同
        if(h1-h2!=0)return h1-h2;

        //hash相同 并且值也一样,直接覆盖
        if(Objects.equals(k,k1))
        return 0;

        //hash相同，equal不同 比较类型
        if(k!=null&k1!=null){
            String s1 = k.getClass().toString();
            String s2 = k1.getClass().toString();
            if(s1.compareTo(s2)!=0) return s1.compareTo(s2);

            //同一类,是否实现比较接口
            if(k instanceof Comparable){
                return ((Comparable) k).compareTo(k1);
            }
        }

        //比较内存地址

        return System.identityHashCode(k)-System.identityHashCode(k1);
    }

    /**
     * 计算hash值
     * k.hashCode()^(k.hashCode()>>>16
     * 这个含义表示k的hash值需要在次将高16位和低16位进行混合运算
     *
     * @param k
     * @return
     */
    int hash(K k){
        return k==null?0:(k.hashCode()^(k.hashCode()>>>16))&(table.length-1);
    }
    /**
     * 计算hash值
     * k.hashCode()^(k.hashCode()>>>16
     * 这个含义表示k的hash值需要在次将高16位和低16位进行混合运算
     *
     * @param k
     * @return
     */
    int hash(RBNode<K,V> node){
        return node==null?0:(node.hash^(node.hash>>>16))&(table.length-1);
    }

    final  class RBNode<K,V>{
        RBNode<K,V> right;
        RBNode<K,V> left;
        RBNode<K,V> parent;
        boolean color;
        int hash;
        K k;
        V v;
        public RBNode(K k,V v) {
            this.k = k;
            this.v = v;
            this.color=RED;
            this.hash=k==null?0:k.hashCode();
        }
        public boolean isLeftChrild(){
            return this.parent!=null&&this.parent.left==this?true:false;
        }
        public boolean isRightChrild(){
            return this.parent!=null&&this.parent.right==this?true:false;
        }
        public boolean isRed(){
            return this.color;
        }
        public boolean isBlack(){
            return !this.color;
        }

        /**
         * 染色
         * @param color
         * @return
         */
        public RBNode<K,V> colorof(boolean color){
            this.color=color;
            return this;
        }

        /**
         * 找到兄妹节点
         * @return
         */
        public RBNode<K,V> sibling(){
            if(isLeftChrild()){
                return this.parent.right;
            }else if(isRightChrild()){
                return this.parent.left;
            }else{
                return null;
            }
        }
    }

    /**
     * 修复红黑树性质
     * @param node
     */
    private void affteradd(RBNode<K,V> node){
        //如果当前是根节点则直接染黑色即可
        if(node.parent==null){
            node.colorof(BLACK);
            return;
        }
        //要添加的节点的父节点是黑色则直接返回即可
        if(node.parent.isBlack())
            return;

        RBNode<K,V> grand =node.parent.parent;
        //如果叔父节点为红色，则需要上溢，并且可能导致祖父节点继续上溢直到根节点
        RBNode<K,V> uncle=node.parent.sibling();
        //不存在叔父，则为LL,RR,LR,RL这些情况
        if(uncle==null){
            if(node.parent.isLeftChrild()){//L
                grand.colorof(RED);
                if(node.isLeftChrild()){//LL
                    node.parent.colorof(BLACK);
                }else{//LR
                    node.colorof(BLACK);
                    RR(node.parent);
                }
                LL(grand);
            }else{//R
                grand.colorof(RED);
                if(node.isRightChrild()){//RR
                    node.parent.colorof(BLACK);
                }else{//RL
                    node.colorof(BLACK);
                    LL(node.parent);
                }
                RR(grand);
            }
        }
        else if(uncle.isRed()){
            node.parent.sibling().colorof(BLACK);
            node.parent.colorof(BLACK);
            grand.colorof(RED);
            affteradd(grand);
            return ;
        }

    }


    /**         |                |
     *          n                p
     *        /   \            /   \
     *       p     a    -->   r     n          <p>left roated<p/>
     *     /                         \
     *    r                           a
     */
    public void LL(RBNode<K,V> node){
        RBNode<K,V> p=node.left,pr=p.right;
        p.right=node;
        node.right=pr;
        //维护父节点
        p.parent=node.parent;
        //判断node在父节点的左右
        if(node.isRightChrild()){
            node.parent.right=p;
        }else if(node.isLeftChrild()){
            node.parent.left=p;
        }else{
            //n为根节点
            table[hash(node)]=p;
        }
        node.parent=p;
        if(pr!=null){
            pr.parent=node;
        }
    }
    /**         |                 |
     *          n                 a
     *        /   \             /   \
     *       p     a    -->    n     r         <p>right roated<p/>
     *              \        /
     *               r      p
     */
    public void RR(RBNode<K,V> node){
        RBNode<K,V> a=node.right,al=a.left;
        a.left=node;
        node.right=al;
        //maintain node of parent
        a.parent=node.parent;
        if(node.isLeftChrild()){
            node.parent.left=a;
        }else if(node.isRightChrild()){
            node.parent.right=a;
        }else{
            table[hash(node)]=a;
        }
        node.parent=a;
        if(al!=null){
            al.parent=node;
        }
    }

    /*
     * @function：添加元素
     * @author lyq
     * @progress
     * @date 2020/3/30
     * @param
     * @return
     */
    public RBNode<K,V> add(K k,V v){
        RBNode<K,V> node=  new RBNode<>(k,v);

        RBNode<K,V> temp=null,newroot=table[hash(node)];
        do{
            int c=compare(newroot.k,k);
            temp=newroot;
            if(c>0){
                newroot=newroot.left;
            }else if(c<0){
                newroot=newroot.right;
            }else{
                newroot=node;
                return node;
            }
        }while (newroot!=null);

        if(compare(temp.k,k)>0){
            temp.left=node;
        }else{
            temp.right=node;
        }
        //将当前插入的node节点的父节点设置为前一个
        node.parent=temp;
        return node;
    }


}

class T{
    public static void main(String[] args) {
        ArMap<String,Integer> map=new ArMap<>();
        map.put("jav",1);
        map.put("jav",1);
        System.out.println(map.size());
    }
}