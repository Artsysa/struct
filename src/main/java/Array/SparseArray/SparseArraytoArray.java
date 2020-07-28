package Array.SparseArray;

/*
稀疏数组和数组的相互转换
 */
public class SparseArraytoArray {

    public static void main(String[] args) {
        SparseArraytoArray sparseArraytoArray = new SparseArraytoArray();
        int array[][] =new int[11][11];

        array[1][2]=1;
        array[2][4]=2;
        array[4][5]=100;
        //获取到数组中值非0个个数
        System.out.println("array is .....->");
        int count = sparseArraytoArray.print(array);
        int sparseArray[][] =new int [ count+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=count;
        //数组转稀疏数组
        sparseArraytoArray.arraytosparsearray(array,sparseArray);
        sparseArraytoArray.printSparse(sparseArray);
        System.out.println("sparsearray to arry ....->");
        sparseArraytoArray.print(sparseArraytoArray.sparsearraytoarray(sparseArray));
    }


    /*
    sparsearry to array
     */
    public int[][] sparsearraytoarray(int sparseArray[][]){
        int row=0,column=0;
        int array[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int[] rows:sparseArray
             ) {
            if(row==0){
                for (int columns:rows
                     ) {
                    column++;
                }
            }
            row++;
        }
        for(int i=1;i<row;i++){
            int r=0,c=0;
            for(int j=0;j<column;j++){
               if(j==0){
                   r=sparseArray[i][j];
               }else if(j==1){
                   c=sparseArray[i][j];
               }else{
                   array[r][c]=sparseArray[i][j];
               }
            }
        }
        return array;
    }

    /*
    array to sparsearry
     */

    public void arraytosparsearray(int array[][],int sparseArray[][]){
        int row=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(array[i][j]!=0){
                    row++;
                    sparseArray[row][0]=i;
                    sparseArray[row][1]=j;
                    sparseArray[row][2]=array[i][j];
                }
            }
        }
    }

/*
遍历
 */
    public int print(int array[][]){
        int i=0;
        for (int[] row:array
             ) {
            for (int column:row
                 ) {
                if(column!=0)
                    i++;
                System.out.print(column+"\t");
            }
            System.out.println();
        }
        return  i;
    }

    public void printSparse(int sparseArray[][]){
        System.out.println("array to sparsearray  ..----->");
        for (int[] rows:sparseArray
        ) {
            for (int column:rows
            ) {
                System.out.print(column+"\t");
            }
            System.out.println();
        }
    }
}
