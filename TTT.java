import java.util.*;

class TTT {

    static final int EMPTY = 0, NONE = 0, USER = 1, COMPUTER = 2, STALEMATE = 3;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

      int turn = USER;
      int[][] board = new int[3][3];
      int move;
      int winner;

      print_board(board);

      while (true) {

        if (turn == USER) {

          System.out.println();
          System.out.println("Your move (X)");
          move = -1;

          while ( move < 0 || move > 9 || board[move / 3][move % 3] != EMPTY) {

            System.out.println("ENTER 0-8: ");
            move = sc.nextInt();
            System.out.println();


          }

        } else {

          move = computer_move(board);

          System.out.println();
          System.out.println("AI Input: " + move);
          System.out.println();


        }

        board[(int)(move / 3)][move % 3] = turn;

        print_board(board);
        winner = checkWinner(board);

        if (winner != NONE)
          break;

        //Turn change

        if (turn == USER) {

          turn = COMPUTER;

        } else {

          turn = USER;

        }

      }

      //Outcome of the game

      switch (winner) {

        case USER:
          System.out.println("You've Won!");
          break;

        case COMPUTER:
          System.out.println("AI Won!");
          break;

        default:
          System.out.println("Tied!");
          break;

      }

    }

    //Printing the board on console

    public static void print_board(int[][] board) {

      System.out.print(printChar(board[0][0]));
      System.out.print("|");

      System.out.print(printChar(board[0][1]));
      System.out.print("|");

      System.out.println(printChar(board[0][2]));
      System.out.println("-----");

      System.out.print(printChar(board[1][0]));
      System.out.print("|");

      System.out.print(printChar(board[1][1]));
      System.out.print("|");

      System.out.println(printChar(board[1][2]));
      System.out.println("-----");

      System.out.print(printChar(board[2][0]));
      System.out.print("|");

      System.out.print(printChar(board[2][1]));
      System.out.print("|");

      System.out.println(printChar(board[2][2]));

    }

    //Character assignment for players on the board

    public static char printChar(int b) {

      switch (b) {

        case EMPTY:
          return ' ';

        case USER:
          return 'X';

        case COMPUTER:
          return 'O';

      }

      return ' ';
    }

    //Outcome of the game

    public static int checkWinner(int[][] board) {

      if ((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]))
        return board[0][0];

      if ((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]))
        return board[1][0];

      if ((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]))
        return board[2][0];

      if ((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]))
        return board[0][0];

      if ((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]))
        return board[0][1];

      if ((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]))
        return board[0][2];

      if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
        return board[0][0];

      if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
        return board[0][2];

      if (board[0][0] == EMPTY ||
          board[0][1] == EMPTY ||
          board[0][2] == EMPTY ||
          board[1][0] == EMPTY ||
          board[1][1] == EMPTY ||
          board[1][2] == EMPTY ||
          board[2][0] == EMPTY ||
          board[2][1] == EMPTY ||
          board[2][2] == EMPTY)

        return NONE;

      return STALEMATE;

    }

    public static int computer_move(int[][] board) {

      int move = (int)(Math.random() * 9);

      while (board[move / 3][move % 3] != EMPTY)
        move = (int)(Math.random() * 9);

      return move;

    }

}