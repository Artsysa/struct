package tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;
import java.util.Stack;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/3/18 10:19
 * @Month:03
 */
public class BinaryTree {
    Node<Integer> root ;

    public void createTree(){

        root=createnode(root);
    }

    public Node<Integer> createnode(Node<Integer> node){
          Integer id;
        id=new Scanner(System.in).nextInt();
        if(id==0){
            return null;
        }else{
           node = new Node<>();
            node.t=id;
          node.right=createnode(node);
          node.left=createnode(node);
        }
        return node;
    }

    public boolean prePrint(Node<Integer> node){
        if(node==null){
            return false;
        }
        System.out.println(node);
        if(prePrint(node.right)){
            return true;
        }
        if(prePrint(node.left)){
            return true;
        }
        return false;
    }
    public boolean midPrint(Node<Integer> node){
        if(node==null){
            return false;
        }
        if(prePrint(node.right)){
            System.out.println(node);
            return true;
        }
        System.out.println(node);
        if(prePrint(node.left)){
            System.out.println(node);
            return true;
        }
        return false;
    }
    public boolean afterPrint(Node<Integer> node){
        if(node==null){
            return false;
        }
        if(prePrint(node.right)){
            System.out.println(node);
            return true;
        }
        if(prePrint(node.left)){
            System.out.println(node);
            return true;
        }
        System.out.println(node);
        return false;
    }
}



@Data
@AllArgsConstructor
@NoArgsConstructor
class Node<T>{
    T t;
    Node<T> right;
    Node<T> left;

}


class Test{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        //tree.createTree();
        //tree.afterPrint(tree.root);
       //System.out.println(tree.root);
        char[][] c=new char[3][4];
        c[0][0]='B';
        System.out.println(c[2].length);
        System.out.println(c[0][0]=='B');

    }
}