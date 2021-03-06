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
    if(board[r][c] != 0 || r < 0 || r >= board.length
    || c < 0 || c >= board.length){
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

  private boolean removeQueen(int r, int c){
    if(board[r][c] != -1 || r < 0 || r >= board.length
    || c < 0 || c >= board.length){
      return false;
    }
    else{
      for(int i = 0; i < board.length; i++){
        if(r - i < board.length && r - i >= 0
        && c + i < board.length){
          board[r - i][c + i] -= 1;
        }
        if(r < board.length && c + i < board.length){
          board[r][c + i] -= 1;
        }
        if(r + i < board.length && c + i < board.length){
          board[r + i][c + i] -= 1;
        }
      }
      board[r][c] = 0;
      return true;
    }
  }




  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String str = "";
    for(int i = 0; i < board.length; i++){
      for(int j= 0; j < board.length; j++){
        /*if(board[i][j] > 0){//debugging purposes
          str = str + "*";
        }*/
        if(board[i][j] >= 0){
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

  private void clear(){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        board[i][j] = 0;
      }
    }
  }


  /**
    *@return false when the board is not solveable and leaves the board filled with zeros;
    *        true when the board is solveable, and leaves the board in a solved state
    *@throws IllegalStateException when the board starts with any non-zero value
    */
  public boolean solve(){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if(board[i][j] != 0){
          throw new IllegalStateException("Board must be cleared before finding a solution");
        }
      }
    }
    return help(0);
  }

  public boolean help(int col){
    if(col >= board.length){
      return true;
    }
    for(int i = 0; i < board.length; i++){
      if(this.addQueen(i, col)){
        if(help(col + 1)){
          return true;
        }
        this.removeQueen(i, col);
      }
    }
    this.clear();
    return false;
  }







  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if(board[i][j] != 0){
          throw new IllegalStateException("Board must be cleared before finding all solutions");
        }
      }
    }
    return help2(0);
  }

  public int help2(int col){
    if(col >= board.length){
      return 1;
    }
    int sum = 0;
    for(int i = 0; i < board.length; i++){
      if(this.addQueen(i, col)){
        sum += help2(col + 1);
        this.removeQueen(i, col);
      }
    }
    return sum;
  }

}
