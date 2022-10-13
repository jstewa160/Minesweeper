import java.util.Scanner;

public class MineSweepaz {

        public static void main(String[] args) {
            System.out.println("Start");
            Board gameBoard = new Board();
            gameBoard.hiddenBoard();
            gameBoard.populateHiddenWithMines();
            gameBoard.neighbourMinesForHiddenBoard();
            gameBoard.visualBoard();

            while(true){
                gameBoard.userInputTest();
                gameBoard.hiddenBoardUpdate();
                gameBoard.boardUpdate();
            }

        }

}
