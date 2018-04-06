package code.explore.algorithm;

public class EightQueue {
    private static int[][] chessboard = new int[8][8];

    private static int count=0;
    public static void main(String[] args) {
        play(0);
    }

    private static void show(int[][] chessboard){
        System.out.println("---------------第"+(++count)+"种--------------");
        for(int i = 0 ; i < chessboard.length ; i++){
            for(int j = 0 ; j < chessboard[i].length ; j++){
                System.out.print(chessboard[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean check(int x, int y){
        //上
        for(int i = x-1 ; i >= 0 ; i--){
            if(chessboard[i][y]==1){
                return false;
            }
        }
        //右上
        for(int i = x-1, j =y-1 ; i >= 0&&j>=0 ; i--,j--){
            if(chessboard[i][j]==1){
                return false;
            }
        }
        //左上
        for(int i = x-1,j=y+1 ; i >=0&&j<8; i--,j++){
            if(chessboard[i][j]==1){
                return false;
            }
        }
        return true;
    }

    private static void play(int row){
        for(int i = 0 ; i < 8 ; i++){
            if(check(row,i)){
                chessboard[row][i] = 1;
                if(row==7){
                    show(chessboard);
                }else{
                    play(row+1);
                }
                chessboard[row][i] = 0;
            }
        }
    }
}
