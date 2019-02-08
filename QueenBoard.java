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
    board[r][c] = -1;
    ///can be made using only one loop
    //look at note book light pencil to finish this
    for(int i = 0; i < board.length; i++){
      if(r - i < board.length && c + i < board.length){
        board[r - i][c + i] += 1;
      }
    }
  }




  //private boolean removeQueen(int r, int c);

  public String toString(){
    String str = "";
    for(int i = 0; i < board.length; i++){
      for(int j= 0; j < board.length; j++){
        if(board[i][j] >= 0){
          str = str + "_";
        }
        else{
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
    q.addQueen(1,2);
    System.out.println(q);
  }


}
