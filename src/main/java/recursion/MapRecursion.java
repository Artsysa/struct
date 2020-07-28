package recursion;

/*
 * @breif:迷宫回溯
 * @Author: ArDaBao
 * @Date: 2020/3/17 10:28
 * @Month:03
 */
public class MapRecursion {

    int[][] map=new int[9][10];

    public  MapRecursion(){
        for(int i=0;i<9;i++){
            for (int j=0;j<10;j++){
                if(i==0||i==8){
                    map[i][j]=1;
                }
                if(j==0||j==9){
                    map[i][j]=1;
                }
            }
        }
        map[2][1]=1;
        map[2][2]=1;
        map[2][3]=1;
        map[2][4]=1;
        map[1][6]=1;
        map[2][6]=1;
        map[3][6]=1;
        map[4][6]=1;
        map[4][5]=1;
        map[4][4]=1;
        map[4][3]=1;


    }

    public void print(){
        System.out.println("********************************************");
        for(int i=0;i<9;i++){
            System.out.print("*"+"\t");
            for (int j=0;j<10;j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println("*");
        }
        System.out.println("********************************************");
    }

    public boolean recursion(int x,int y){

         if(map[7][1]==2){
             return true;
         }
             else{
             if(map[x][y]==0){
                 map[x][y]=2;
                 //print();
                 if(recursion(x,y+1)){//向右走
                     return true;
                 }else if(recursion(x+1,y)){//向下走
                     return true;
                 }else if(recursion(x,y-1)){//向左走
                     return true;
                 }else if(recursion(x-1,y)){//向上走
                     return true;
                 }else{
                     return false;
                 }
             }else if(map[x][y]==1){
                 return false;
             }else if(map[x][y]==2){
                 return false;
             }else {
                 map[x][y]=3;
                 return false;
             }
         }

    }

    public static void main(String[] args) {
        MapRecursion map = new MapRecursion();
       // map.print();
        map.recursion(1,1);
        map.print();

    }
}
