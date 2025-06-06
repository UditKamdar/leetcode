class Solution {
    private int[][] directions = {
        {-1,-1}, {-1,0}, {-1,1},
        {0,-1},  {0,1},
        {1,-1}, {1,0}, {1,1}
    };
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                int countLiveNeighbours = count(board,i,j);

                if(board[i][j] == 1){
                    if(countLiveNeighbours < 2 || countLiveNeighbours > 3){
                        board[i][j] = 2;
                    }
                } else {
                    if(countLiveNeighbours == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i =0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                board[i][j] %= 2;
            }
        }

    }


    public int count(int[][] board, int r, int c){
        int cnt = 0;

        for(int[] dir: directions){
            int row = r + dir[0];
            int col = c + dir[1];

            if( row >=0 && row < board.length && col>= 0 && col < board[0].length){
                if(board[row][col] == 1 || board[row][col] == 2){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}



//Method 2 - Using two different loops
    //public void gameOfLife(int[][] board) {
    //     for(int i = 0; i < board.length; i++){
    //         for(int j = 0; j < board[i].length; j++){
    //             encode(board,i,j);
    //         }
    //     }

    //     for(int i =0; i < board.length; i++){
    //         for(int j =0; j < board[i].length; j++){
    //             update(board,i,j);
    //         }
    //     }
    // }

    // public void encode(int[][] board, int row, int col){
    //     int activeCnt = 0;
    //     for(int[] dir : directions){
    //         int neighR = row + dir[0];
    //         int neighC = col + dir[1];

    //         if(neighR >= 0 && neighR < board.length && neighC >=0 && neighC < board[0].length){
    //             int val = board[neighR][neighC];
    //             if(dir[0] == -1 || (dir[0] == 0 && dir[1] == -1)){
    //                 val = val/10;
    //             }
                
    //             if(val == 1){
    //                 activeCnt++;
    //             }
    //         }
    //     }         
    //     board[row][col] =   board[row][col] * 10 + activeCnt;
    // }

    // public void update(int[][] board, int row, int col){
    //     int isAlive = board[row][col]/10;
    //     int activeCnt = board[row][col]%10;

    //     if(isAlive == 1 && (activeCnt < 2 || activeCnt > 3)){
    //         board[row][col] = 0;
    //     } else if (isAlive == 1 && (activeCnt == 2 || activeCnt == 3)){
    //         board[row][col] = 1;
    //     } else if( isAlive == 0 && activeCnt == 3){
    //         board[row][col] = 1;
    //     } else {
    //         board[row][col] = isAlive;
    //     }
    // }
