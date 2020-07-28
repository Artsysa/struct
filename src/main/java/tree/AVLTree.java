package tree;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/4/24 15:06
 * @Month:04
 */
public class AVLTree<E> {


    private AVLNode<E> root;
    //比较器
    CompareTree<E> compareTree;

    public AVLTree(CompareTree<E> compareTree) {
        this.compareTree = compareTree;
    }

   final  class AVLNode<E>{
        AVLNode<E> right;
        AVLNode<E> left;
        AVLNode<E> parent;
        int height;
        E e;
        public AVLNode(E e) {
            this.e = e;
            this.height=1;
        }
        public boolean isLeftChrild(){
            return this.parent!=null&&this.parent.left==this?true:false;
        }
        public boolean isRightChrild(){
            return this.parent!=null&&this.parent.right==this?true:false;
        }
        public int balancefactor(){
           int leftfactor=left==null?0:left.height;
           int rightfactor=right==null?0:right.height;
           return Math.abs(leftfactor-rightfactor);
        }
        public boolean isbalance(){
            return balancefactor()>1?false:true;
        }
        public void updateheight(){
            this.height=Math.max(left==null?0:left.height,right==null?0:right.height)+1;
        }

       /**
        * 获取当前节点下左右节点中最高的节点
        * @return
        */
        public  AVLNode<E> getMaxTallNode(){
            int leftfactor=left==null?0:left.height;
            int rightfactor=right==null?0:right.height;
            int differvalue=leftfactor-rightfactor;
            return differvalue>=0?left:right;
        }
    }

    /**
     * 进行调整平衡同时更新高度
     * @param node
     */
    public void affteradd(AVLNode<E> node){
        while((node=node.parent)!=null){
            //是否平衡
            if(node.isbalance()){
                node.updateheight();
            }else{//不平衡
             balance(node);
             return;
            }
        }
    }

    /**
     *          n
     *        /   \
     *       p     a
     *     /
     *    r
     * <p>find unbalanced node and set balancefactor<p/>
     */
    public void balance(AVLNode<E> node){
        AVLNode<E> p = node.getMaxTallNode();
        AVLNode<E> r = p.getMaxTallNode();
        if(p.isLeftChrild()){
            //L
            if(r.isLeftChrild()){
                //LL
                LL(node);
            }else{
                //LR
                RR(p);
                LL(node);
            }
        }else{
            //R
            if(r.isRightChrild()){
                //RR
                RR(node);
            }else{
                //RL
                LL(p);
                RR(node);
            }
        }
    }

    /**         |                |
     *          n                p
     *        /   \            /   \
     *       p     a    -->   r     n          <p>left roated<p/>
     *     /                         \
     *    r                           a
     */
    public void LL(AVLNode<E> node){
        AVLNode<E> p=node.left,pr=p.right;
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
            root=p;
        }
        node.parent=p;
        if(pr!=null){
            pr.parent=node;
        }

        node.updateheight();
        p.updateheight();

    }
    /**         |                 |
     *          n                 a
     *        /   \             /   \
     *       p     a    -->    n     r         <p>right roated<p/>
     *              \        /
     *               r      p
     */
    public void RR(AVLNode<E> node){
        AVLNode<E> a=node.right,al=a.left;
        a.left=node;
        node.right=al;
        //maintain node of parent
        a.parent=node.parent;
        if(node.isLeftChrild()){
            node.parent.left=a;
        }else if(node.isRightChrild()){
            node.parent.right=a;
        }else{
            root=a;
        }
        node.parent=a;
        if(al!=null){
            al.parent=node;
        }

        node.updateheight();
        a.updateheight();

    }


    /*
     * @function：添加元素
     * @author lyq
     * @progress
     * @date 2020/3/30
     * @param
     * @return
     */
    public boolean add(E element){
        AVLNode<E> node=  new AVLNode<>(element);
        //判断是否有根节点
        if(root==null){
            this.root=node;
            this.root.parent=null;
            affteradd(node);
            return true;
        }
        AVLNode<E> temp=null,newroot=root;
        while (newroot!=null){
            temp=newroot;
            if(compare(newroot.e,element)>0){
                newroot=newroot.left;
            }else if(compare(newroot.e,element)<0){
                newroot=newroot.right;
            }else{
                newroot=node;
                return true;
            }
        }

        if(compare(temp.e,element)>0){
            temp.left=node;
        }else{
            temp.right=node;
        }
        //将当前插入的node节点的父节点设置为前一个
        node.parent=temp;
        affteradd(node);
        return true;
    }


    public int compare(E e1,E e2){
        return compareTree.compare(e1,e2);

    }

    /*
     * @function：获取中序遍历的前驱节点
     * @author lyq
     * @progress
     * @date 2020/3/31
     * @param
     * @return
     */
    public AVLNode<E> preNode(AVLNode<E> node){
        AVLNode<E> tmp=null;
        //如果当前节点是根节点并且不存在左子树则无前驱节点
        if(node.parent==null&&node.left==null) return null;

            //如果当前节点的左节点不为空，程序往下遍历其左节点的所有右节点，直到最后一个节点
        else if(node.left!=null){
            tmp=node.left;
            while(tmp.right!=null){
                tmp=tmp.right;
            }
            return tmp;
        }
        //(node.left==null&&node.parent!=null)如果左节点为空并且父节点不为空
        else {

            while(node.parent!=null&&node.parent.right!=node){
                node=node.parent;
            }
            return node.parent;
        }
    }

    /*
     * @function：删除节点
     * @author lyq
     * @progress
     * @date 2020/3/31
     * @param
     * @return
     */
    public boolean remove(AVLNode<E> node){
        if(node==null) return false;

        //如果当前节点是根节点并且无左右子树直接删除
        if(node.parent==null&&node.left==null&&node.right==null){
            node.right=null;
            node.left=null;
            return true;
        }
        //isleaf2 判断当前节点是否是度为2
        boolean isleaf2=node.right!=null&&node.left!=null;
        AVLNode<E> pre=null;
        //处理度为2的节点，将其值换成前驱节点，同时在下一步操作中，只需要删除其前驱节点即可
        if(isleaf2){
            //获取前驱节点
            pre=preNode(node);
            //将前驱节点的值赋给当前要删除的节点
            node.e=pre.e;
            node=pre;
        }
        boolean isleaf1=node.right!=null||node.left!=null;

        if(isleaf1){
            //获取度为1的下一个节点
            AVLNode<E> next=node.left==null?node.right:node.left;
            //将下一个节点的父节点对接到要删除的节点的父节点上。
            next.parent=node.parent;
            //如果父节点为空，则当前节点即为根节点
            if(node.parent==null)
                root=next;
                //判断删除的节点是父节点的左子树还是右子树， true为右子树，false为左子树
            else if(node.parent.left==node?false:true)
                node.parent.right=next;
            else
                node.parent.left=next;
            return true;
        }else{//处理度为0的点w
            //判断删除的节点是父节点的左子树还是右子树， true为右子树，false为左子树
            if(node.parent.left==node?false:true)
                node.parent.right=null;
            else
                node.parent.left=null;
            return true;
        }

    }

    /*
     * @function：层级遍历
     * @author lyq
     * @progress
     * @date 2020/3/30
     * @param
     * @return
     */
    public void levelprint() {
        AVLNode<E> node=this.root;
        Queue<AVLNode<E>> queue = new LinkedBlockingQueue<>();
        queue.offer(node);
        AVLNode<E> temp = node;
        while (true) {
            AVLNode<E> now = queue.poll();
            if (now == null) return;
            System.out.print(now.height + "-" + now.e + " ");
            if (now.left != null) {
                queue.offer(now.left);
            }
            if (now.right != null) {
                queue.offer(now.right);
            }
        }
    }
}
class d{


    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>((e1,e2)->{return e1-e2;});
        int[] num=new int[]{7,4,9,2,5,8,11,1,3,10,12};
        for (int i = 0; i < num.length; i++) {
            tree.add(num[i]);
        }
        //tree.inorderprint(tree.root);
        tree.levelprint();
        tree.add(13);
        System.out.println();
        tree.levelprint();
        // System.out.println(tree.levelheight(tree.root));
        // System.out.println(tree.behindNode(tree.getNode(12)).e);

       // System.out.println(tree.remove(9));
        //tree.inorderprint(tree.root);

    }
}