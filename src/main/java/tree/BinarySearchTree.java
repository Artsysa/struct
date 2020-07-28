package tree;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/3/30 16:40
 * @Month:03
 */
@NoArgsConstructor
public class BinarySearchTree<E> {

    public Node<E> root;
    //比较器
    CompareTree<E> compareTree;


    public BinarySearchTree(CompareTree<E> compareTree) {
        this.compareTree = compareTree;
    }

    @Data
    @Accessors(chain = true)
    static final class Node<E>{
        Node<E> right;
        Node<E> left;
        Node<E> parent;

       // Node<E> parent;
        E e;
        public Node(E e) {
            this.e = e;
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
       Node<E> node=  new Node<>(element);
        //判断是否有根节点
        if(root==null){
            this.root=node;
            this.root.parent=null;
            return true;
        }
        Node<E> temp=null,newroot=root;
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
           return true;
    }


    public int compare(E e1,E e2){
            return compareTree.compare(e1,e2);

    }


    /*
    * @function：前序遍历
    * @author lyq
    * @progress
    * @date 2020/3/30
    * @param
    * @return
    */
    public void preprint(Node node){
        if(node==null)return ;
        System.out.print(node.e+" ");
        preprint(node.right);
        preprint(node.left);
    }


    /*
    * @function：中遍历
    * @author lyq
    * @progress
    * @date 2020/3/30
    * @param
    * @return
    */
    public void inorderprint(Node node){
        if(node==null)return;
        inorderprint(node.left);
        System.out.print(node.e+" ");
        inorderprint(node.right);
    }


    /*
    * @function：后
    * @author lyq
    * @progress
    * @date 2020/3/30
    * @param
    * @return
    */
    public void postprint(Node node){
        if(node==null)return;
        postprint(node.left);
        postprint(node.right);
        System.out.print(node.e+" ");
    }


    /*
    * @function：层级遍历
    * @author lyq
    * @progress
    * @date 2020/3/30
    * @param
    * @return
    */
    public void levelprint(Node node){
        Queue<Node<E>> queue=new LinkedBlockingQueue<>();
        queue.offer(node);
        Node<E> temp=node;
        while(true){
            Node<E> now = queue.poll();
            if(now==null) return;
            System.out.print(now.e+" ");
            if(now.left!=null){
                queue.offer(now.left);
            }
            if(now.right!=null){
                queue.offer(now.right);
            }
        }
    }



    /*
     * @function：层级 获取树的深度
     * @author lyq
     * @progress
     * @date 2020/3/30
     * @param
     * @return
     */
    public int levelheight(Node node){
        Queue<Node<E>> queue=new LinkedBlockingQueue<>();
        queue.offer(node);
        Node<E> temp=node;
        int height=0,count=1;
        while(true){
            Node<E> now = queue.poll();
            if(now==null) return height;

            if(now.left!=null){
                queue.offer(now.left);
            }
            if(now.right!=null){
                queue.offer(now.right);
            }
            if(--count==0) {
                height++;
                count=queue.size();
            }

        }
    }
    /*
    * @function：递归求树的深度
    * @author lyq
    * @progress
    * @date 2020/3/30
    * @param
    * @return
    */
    public int heightrecursion(Node node){
        if(node==null) return 0;
        return 1+Math.max(heightrecursion(node.right),heightrecursion(node.left));
    }


   /*
   * @function：查找某个节点
   * @author lyq
   * @progress
   * @date 2020/3/31
   * @param
   * @return
   */
    public Node<E> getNode(Node<E> node){
        Node<E> tmp=root;
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
    * @function：供外面调用获取节点
    * @author lyq
    * @progress
    * @date 2020/3/31
    * @param
    * @return
    */
    public Node<E> getNode(E e){
        return getNode(new Node<>(e));
    }
    /*
    * @function：获取中序遍历的前驱节点
    * @author lyq
    * @progress
    * @date 2020/3/31
    * @param
    * @return
    */
    public Node<E> preNode(Node<E> node){
        Node<E> tmp=null;
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
     * @function：获取中序遍历的后驱节点
     * @author lyq
     * @progress
     * @date 2020/3/31
     * @param
     * @return
     */
    public Node<E> behindNode(Node<E> node){
        Node<E> tmp=null;
        //如果当前节点是根节点并且不存在左子树则无前驱节点
        if(node.parent==null&&node.right==null) return null;

            //如果当前节点的左节点不为空，程序往下遍历其左节点的所有右节点，直到最后一个节点
        else if(node.right!=null){
            tmp=node.right;
            while(tmp.left!=null){
                tmp=tmp.left;
            }
            return tmp;
        }
        //(node.left==null&&node.parent!=null)如果左节点为空并且父节点不为空
        else {

            while(node.parent!=null&&node.parent.left!=node){
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
     public boolean remove(Node<E> node){
         if(node==null) return false;

         //如果当前节点是根节点并且无左右子树直接删除
         if(node.parent==null&&node.left==null&&node.right==null){
             node.right=null;
             node.left=null;
             return true;
         }
         //isleaf2 判断当前节点是否是度为2
          boolean isleaf2=node.right!=null&&node.left!=null;
         Node<E> pre=null;
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
             Node<E> next=node.left==null?node.right:node.left;
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
    public boolean remove(E e){
        return remove(getNode(e));
    }
    public  boolean isValidBST(Node root) {
        return search(root);
    }
    public  boolean search(Node<Integer> root){
         if(root==null) return true;
         if(root.left==null&&root.right!=null){
             return root.e<=root.right.e;
         }else if(root.left!=null&&root.right==null){
             return root.e>=root.left.e;
         }else if(root.left==null&&root.right==null)
             return true;
        search(root.left);
        search(root.right);
        if(root.e>root.left.e&&root.e<root.right.e) return true;
        else return false;
    }
}



class test{


    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>((e1,e2)->{return e1-e2;});
        int[] num=new int[]{9,11,10,12};//int[]{7,4,9,2,5,8,11,1,3,10,12};
        for (int i = 0; i < num.length; i++) {
            tree.add(num[i]);
        }
        tree.inorderprint(tree.root);
        System.out.println();
       // System.out.println(tree.levelheight(tree.root));
       // System.out.println(tree.behindNode(tree.getNode(12)).e);

        System.out.println(tree.remove(9));
        tree.inorderprint(tree.root);

    }
}

