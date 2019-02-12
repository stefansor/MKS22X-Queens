public class Driver{
  public static void main(String args[]){

        //testing the add and remove functions not too rigorous but minimum
        // I would say
        //commented out at add and remove queen are private
        /*QueenBoard q = new QueenBoard(7);
        System.out.println(q);
        q.addQueen(3,0);
        System.out.println(q);
        q.addQueen(3,1);
        System.out.println(q);
        q.removeQueen(3,0);
        System.out.println(q);*/

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
        //also commented out as clear is private 
        /*
        System.out.println(one.solve());
        one.clear();*/

        //tested countSolutions and the numbers crunched seem right
        //so by this olgic I can seemingly safely assume solve() works
        // as intended
        System.out.println(zero.countSolutions());
        System.out.println(one.countSolutions());
        System.out.println(two.countSolutions());
        System.out.println(three.countSolutions());
        System.out.println(four.countSolutions());
        System.out.println(five.countSolutions());
        System.out.println(six.countSolutions());
        System.out.println(seven.countSolutions());
        System.out.println(eight.countSolutions());
        System.out.println(nine.countSolutions());


        //check to make sure countSolutions keeps the board clear and it does
        System.out.println(nine);

  }
}
