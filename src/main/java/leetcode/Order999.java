package leetcode;

/*
 * @breif:
 *
在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。

车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。

返回车能够在一次移动中捕获到的卒的数量。
 * @Author: lyq
 * @Date: 2020/3/26 9:34
 * @Month:03
 */
public class Order999 {
    int count =0,row=7,column=0;

    public static void main(String[] args) {

        Order999 pb = new Order999();
        char[][] board = {
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        pb.numRookCaptures(board);

        System.out.println(pb.count);
        for(int i=0;i<=pb.row;i++){
            for(int y=0;y<pb.column;y++){
                System.out.print(board[i][y]+"\t");
            }
            System.out.println();
        }
    }

    public  int numRookCaptures(char[][] board) {
        column=board[7].length;
        for(int i=0;i<=row;i++){
            for(int y=0;y<column;y++){
                if(board[i][y]=='R'){
                    recursionup(board,i,y);
                    recursiondown(board,i,y);
                    recursionleft(board,i,y);
                    recursionright(board,i,y);
                    return count;
                }
            }
        }
        return count;
    }

    public boolean recursionup(char[][] board,int x,int y){
        if(x==row||x==-1||y==column||y==-1){
            return false;
        }
        if(board[x][y]=='B'){
            return false;
        }
        if(board[x][y]=='p'){
            count++;
            return false;
        }

        recursionup(board,x-1,y);

        return false;
    }
    public boolean recursiondown(char[][] board,int x,int y){
        if(x==row||x==-1||y==column||y==-1){
            return false;
        }
        if(board[x][y]=='B'){
            return false;
        }
        if(board[x][y]=='p'){
            count++;
            return true;
        }
        board[x][y]='2';
        recursiondown(board,x+1,y);
        return false;
    }
    public boolean recursionleft(char[][] board,int x,int y){
        if(x==row||x==-1||y==column||y==-1){
            return false;
        }
        if(board[x][y]=='B'){
            return false;
        }
        if(board[x][y]=='p'){
            count++;
            return true;
        }
        board[x][y]='2';
        recursionleft(board,x,y+1);
        return false;
    }
    public boolean recursionright(char[][] board,int x,int y){
        if(x==row||x==-1||y==column||y==-1){
            return false;
        }
        if(board[x][y]=='B'){
            return false;
        }
        if(board[x][y]=='p'){
            count++;
            return true;
        }
        board[x][y]='2';
        recursionright(board,x,y-1);
        return false;

    }
}
