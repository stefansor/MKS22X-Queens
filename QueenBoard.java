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


  public boolean solve(){
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

  public int countSolutions(){
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














  public static void main(String[] args){

    //testing the add and remove functions not too rigorous but minimum
    // I would say
    QueenBoard q = new QueenBoard(7);
    System.out.println(q);
    q.addQueen(3,0);
    System.out.println(q);
    q.addQueen(3,1);
    System.out.println(q);
    q.removeQueen(3,0);
    System.out.println(q);

    QueenBoard zero = new QueenBoard(0);
    QueenBoard one = new QueenBoard(1);
    QueenBoard two = new QueenBoard(2);
    QueenBoard three = new QueenBoard(3);
    QueenBoard four = new QueenBoard(4);
    QueenBoard five = new QueenBoard(5);
    QueenBoard six = new QueenBoard(6);
    QueenBoard seven = new QueenBoard(7);
    QueenBoard eight = new QueenBoard(8);
    QueenBoard nine = new QueenBoard(9);


    //testing solve
    System.out.println(one.solve());
    one.clear();

    //tested countSoltuoi
    System.out.println(one.countSolutions());
    System.out.println(two.countSolutions());
  }


}
