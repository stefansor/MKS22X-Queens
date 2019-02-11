public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }
  }

  private boolean addQueen(int r, int c){
    if(board[r][c] != 0){
      return false;
    }
    ///can be made using only one loop
    //look at note book light pencil to finish this
    else{
      for(int i = 0; i < board.length; i++){
        if(r - i < board.length && r - i >= 0
        && c + i < board.length){
          board[r - i][c + i] += 1;
        }
        if(r < board.length && c + i < board.length){
          board[r][c + i] += 1;
        }
        if(r + i < board.length && c + i < board.length){
          board[r + i][c + i] += 1;
        }
      }
      board[r][c] = -1;
      return true;
    }
    // make it so that it can also return false when there is already a number
  }




  //private boolean removeQueen(int r, int c);

  public String toString(){
    String str = "";
    for(int i = 0; i < board.length; i++){
      for(int j= 0; j < board.length; j++){
        if(board[i][j] > 0){
          str = str + "*";
        }
        if(board[i][j] == 0){
          str = str + "_";
        }
        if(board[i][j] == -1){
          str = str + "Q";
        }
      }
      str = str + "\n";
    }
    return str;
  }

  public static void main(String[] args){
    QueenBoard q = new QueenBoard(4);
    System.out.println(q);
    q.addQueen(3,0);
    System.out.println(q);
  }


}
