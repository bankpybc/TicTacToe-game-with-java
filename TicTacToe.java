public class TicTacToe {
    public static void main(String[] args) {
        final char player1 = 'X';
        final char player2 = 'O';
        String [][] gameBoard_test =  {{" ","|"," ","|"," "},{"-","+","-","+","-"},{" ","|"," ","|"," "},{"-","+","-","+","-"},{" ","|"," ","|"," "}};
       // printGameBoard(gameBoard);
        GameBoard gameBoard = new GameBoard();
    }
    public static void printGameBoard(String[][] gameBoard) {
        for (String[] r : gameBoard) {
            for (String c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void CheckWinCondition(){

    }
}
