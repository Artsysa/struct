package tree;

import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/4/26 8:04
 * @Month:04
 */
public class RedBlackTree<E> {
    private RBNode<E> root;
    //比较器
    CompareTree<E> compareTree;

    public static final boolean RED=true;
    public static final boolean BLACK=false;

    public RedBlackTree(CompareTree<E> compareTree) {
        this.compareTree = compareTree;
    }

    final  class RBNode<E>{
        RBNode<E> right;
        RBNode<E> left;
        RBNode<E> parent;
        boolean color;
        E e;
        public RBNode(E e) {
            this.e = e;
            this.color=RED;
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
        public RBNode<E> colorof(boolean color){
            this.color=color;
            return this;
        }

        /**
         * 找到兄妹节点
         * @return
         */
        public RBNode<E> sibling(){
            if(isLeftChrild()){
                return this.parent.right;
            }else if(isRightChrild()){
                return this.parent.left;
            }else{
                return null;
            }
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
    public boolean add(E element){
        RBNode<E> node=  new RBNode<>(element);
        //判断是否有根节点
        if(root==null){
            this.root=node;
            this.root.parent=null;
            affteradd(node);
            return true;
        }
        RBNode<E> temp=null,newroot=root;
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

    /**
     * 修复红黑树性质
     * @param node
     */
    private void affteradd(RBNode<E> node){
        //如果当前是根节点则直接染黑色即可
        if(node.parent==null){
            node.colorof(BLACK);
            return;
        }
        //要添加的节点的父节点是黑色则直接返回即可
        if(node.parent.isBlack())
            return;


        RBNode<E> grand =node.parent.parent;
        //如果叔父节点为红色，则需要上溢，并且可能导致祖父节点继续上溢直到根节点
        RBNode<E> uncle=node.parent.sibling();
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
    public void LL(RBNode<E> node){
        RBNode<E> p=node.left,pr=p.right;
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
    }
    /**         |                 |
     *          n                 a
     *        /   \             /   \
     *       p     a    -->    n     r         <p>right roated<p/>
     *              \        /
     *               r      p
     */
    public void RR(RBNode<E> node){
        RBNode<E> a=node.right,al=a.left;
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
    }

    /**
     * 删除节点后修复红黑树性质
     * @param node
     * @param o
     */
    private void afterremove(RBNode<E> node, RBNode<E> replacenode) {
        //如果删除的节点是红色则直接删除
        if(node.isRed()) return;
        //如果替代的节点为红色则直接改为黑色即可
        if(replacenode!=null&&replacenode.isRed()){
            replacenode.colorof(BLACK);
        }
        //LL,LR情况，兄弟节点是不是为红色，如果是红色，需要先将兄弟的儿子转化为兄弟节点
        //先找到兄弟节点，因为删除节点时候讲左或右置为空
        RBNode<E> sibling = node.parent.left==null?node.parent.right:node.parent.left;
        //判断删除的节点是否是右边
        boolean isright=node.parent.right==null||node.isRightChrild();
        //删除的节点为右边
        if(isright){
            //兄弟节点为红色要先处理
            /**
             *       red<---root                  red-->root
             *      /   \       \         -->    /     /   \
             *   child3 child1  child2       child3 child1  child2
             *
             */
            if(sibling.isRed()){
                sibling.colorof(BLACK);
                node.parent.colorof(RED);
                LL(node.parent);
                sibling=node.parent.left;
            }

            //兄弟节点是黑色

            //判断兄弟是否两边没有子节点
            if((sibling.left==null&&sibling.right==null)
                    ||(sibling.left.isBlack()&&sibling.right.isBlack())){
                //判断是否当前父节点为黑色，如果是黑色则产生下溢
                boolean  parentisblack=node.parent.color==BLACK;
                sibling.colorof(RED);
                node.parent.colorof(BLACK);
                if(parentisblack){//产生下溢
                    afterremove(node.parent,null);
                }
            }else{//兄弟有至少一个红色的节点，则可以进行LL,LR，首先处理LR将LR转化为LL，之后统一处理LL即可

                //如果不是LL情况则先转化为LL在统一处理
                if(sibling.left==null||sibling.left.isBlack()){
                    RR(sibling);
                    sibling=node.parent.left;
                }

                sibling.colorof(node.parent.color);
                node.parent.colorof(BLACK);
                sibling.left.colorof(BLACK);
                LL(node.parent);
            }

        }else{//在左边

            //兄弟节点为红色要先处理
            /**
             *       red<---root                  red-->root
             *      /   \       \         -->    /     /   \
             *   child3 child1  child2       child3 child1  child2
             *
             */
            if(sibling.isRed()){
                sibling.colorof(BLACK);
                node.parent.colorof(RED);
                RR(node.parent);
                sibling=node.parent.right;
            }

            //兄弟节点是黑色

            //判断兄弟是否两边没有子节点
            if((sibling.left==null&&sibling.right==null)
                    ||(sibling.left.isBlack()&&sibling.right.isBlack())){
                //判断是否当前父节点为黑色，如果是黑色则产生下溢
                boolean  parentisblack=node.parent.color==BLACK;
                sibling.colorof(RED);
                node.parent.colorof(BLACK);
                if(parentisblack){//产生下溢
                    afterremove(node.parent,null);
                }
            }else{//兄弟有至少一个红色的节点，则可以进行LL,LR，首先处理LR将LR转化为LL，之后统一处理LL即可

                //如果不是LL情况则先转化为LL在统一处理
                if(sibling.right==null||sibling.right.isBlack()){
                    LL(sibling);
                    sibling=node.parent.right;
                }

                sibling.colorof(node.parent.color);
                node.parent.colorof(BLACK);
                sibling.right.colorof(BLACK);
                RR(node.parent);
            }

        }

    }
    public int compare(E e1,E e2){
        return compareTree.compare(e1,e2);

    }


    public void levelprint() {
        RBNode<E> node=this.root;
        Queue<RBNode<E>> queue = new LinkedBlockingQueue<>();
        queue.offer(node);
        RBNode<E> temp = node;
        while (true) {
            RBNode<E> now = queue.poll();
            if (now == null) return;
            System.out.print(now.color + "_" + now.e + " ");
            if (now.left != null) {
                queue.offer(now.left);
            }
            if (now.right != null) {
                queue.offer(now.right);
            }
        }
    }

    /*
     * @function：获取中序遍历的前驱节点
     * @author lyq
     * @progress
     * @date 2020/3/31
     * @param
     * @return
     */
    public  RBNode<E>  preNode(RBNode<E> node){
        RBNode<E>  tmp=null;
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
     * @function：供外面调用获取节点
     * @author lyq
     * @progress
     * @date 2020/3/31
     * @param
     * @return
     */
    public RBNode<E> getNode(E e){
        return getNode(new RBNode<E>(e));
    }
    /*
     * @function：查找某个节点
     * @author lyq
     * @progress
     * @date 2020/3/31
     * @param
     * @return
     */
    public RBNode<E> getNode(RBNode<E> node){
        RBNode<E> tmp=root;
        while(tmp!=null){
            if(compare(tmp.e,node.e)>0){
                tmp=tmp.left;
            }else if(compare(tmp.e,node.e)<0){
                tmp=tmp.right;
            }else{
                return tmp;
            }
        }
        return null;
    }
    /*
     * @function：删除节点
     * @author lyq
     * @progress
     * @date 2020/3/31
     * @param
     * @return
     */
    public boolean remove(RBNode<E> node){
        if(node==null) return false;

        //如果当前节点是根节点并且无左右子树直接删除
        if(node.parent==null&&node.left==null&&node.right==null){
            node.right=null;
            node.left=null;
            return true;
        }
        //isleaf2 判断当前节点是否是度为2
        boolean isleaf2=node.right!=null&&node.left!=null;
        RBNode<E> pre=null;
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
            RBNode<E> next=node.left==null?node.right:node.left;
            //将下一个节点的父节点对接到要删除的节点的父节点上。
            next.parent=node.parent;
            //如果父节点为空，则当前节点即为根节点
            if(node.parent==null){
                root=next;
                afterremove(node,null);
            }

                //判断删除的节点是父节点的左子树还是右子树， true为右子树，false为左子树
            else if(node.parent.left==node?false:true)
                node.parent.right=next;
            else
                node.parent.left=next;
            afterremove(node,next);
            return true;
        }else{//处理度为0的点w
            //判断删除的节点是父节点的左子树还是右子树， true为右子树，false为左子树
            if(node.parent.left==node?false:true)
                node.parent.right=null;
            else
                node.parent.left=null;
            afterremove(node,null);
            return true;
        }

    }



    public boolean remove(E e){
        return remove(getNode(e));
    }

}


class t{


    public static void main(String[] args) throws IOException {
        RedBlackTree<Integer> tree = new RedBlackTree<>((e1,e2)->{return e1-e2;});
        int[] num=new int[]{7,4,9,2,5,8,11,1,3,10,12};
        for (int i = 0; i < num.length; i++) {
            tree.add(num[i]);
        }
        //tree.inorderprint(tree.root);
        tree.levelprint();
        int de=1;
        while((de=new Scanner(System.in).nextInt())!=0){
            System.out.println();
            tree.remove(de);
            tree.levelprint();
        }

        // System.out.println(tree.levelheight(tree.root));
        // System.out.println(tree.behindNode(tree.getNode(12)).e);

        // System.out.println(tree.remove(9));
        //tree.inorderprint(tree.root);

    }
}