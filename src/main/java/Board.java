import java.util.Random;
import java.util.Scanner;

public class Board {
    static int maxsize = 10;
    Tiles[][] tileStorage = new Tiles[maxsize + 2][maxsize + 2];

    static int gridSquareNum = 0;
    String[][] grid = new String[maxsize + 2][maxsize + 2];

    int[][] nearbyMinesGrid = new int[maxsize + 2][maxsize + 2];

    public Board() {

        //hiddenBoard();
        //populateHiddenWithMines();
        //visualBoard();

        /*for(int i = 1; i < tileStorage[1].length; i++){
            for(int j = 1; j < tileStorage[1].length; j++){
                tileStorage[i][j].mine = mineAdd();
            }
        }*/

    }

    public void hiddenBoard(){
        for (int i = 1; i < tileStorage[1].length; i++) {
            for (int j = 1; j < tileStorage[1].length; j++) {
                tileStorage[i][j] = new Tiles(true, false,
                        true, false, 0, gridSquareNum);
                System.out.print(tileStorage[i][j].mine);
            }
        }
    }

    public void visualBoard(){
        for (int i = 1; i < tileStorage[1].length - 1; i++){
            System.out.println();
            for (int j = 1; j < tileStorage[1].length - 1; j++){
                //if(tileStorage[i][j].hiddenTile){
                    grid[i][j] = "[ | ]";
                    System.out.print(grid[i][j]);
                //}
            }
        }
    }

    public void populateHiddenWithMines(){
        for(int i = 1; i < tileStorage[1].length - 1; i++){
            for (int j = 1; j < tileStorage[1].length - 1; j++){
                tileStorage[i][j].mine = mineAdd();
                //tileStorage[i][j].gridSquareType = 3;
                System.out.print(tileStorage[i][j].mine);
            }
        }
    }

    public void hiddenBoardUpdate(){
        for(int i = 1; i < tileStorage[1].length - 1; i++){
            for(int j = 1; j < tileStorage[1].length -1; j++){

                //System.out.print(tileStorage[i][j].checked);
            }
        }
    }
    public void boardUpdate() {
        for(int i = 1; i < tileStorage.length - 1; i++){
            System.out.println();
            for(int j = 1; j < tileStorage[1].length - 1; j++){

                if(tileStorage[i][j].mine && !tileStorage[i][j].hiddenTile){
                    grid[i][j] = "[ X ]";
                    System.out.print(grid[i][j]);
                }
                else if(tileStorage[i][j].flag){
                    grid[i][j] = "[ F ]";
                    System.out.print(grid[i][j]);
                }
                else if(!tileStorage[i][j].hiddenTile && !tileStorage[i][j].mine){
                    int val = tileStorage[i][j].neighbours;
                    grid[i][j] = "[   ]";
                    System.out.print(grid[i][j]);
                }
                else if(tileStorage[i][j].hiddenTile){
                    grid[i][j] = "[ | ]";
                    System.out.print(grid[i][j]);
                }
                //System.out.print(tileStorage[i][j].mine);
            }

        }
    }

    public void userInputTest() {

        int xpart;
        int ypart;

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter x: ");
        xpart = sc.nextInt();
        System.out.println("\nEnter y: ");
        ypart = sc.nextInt();

        tileStorage[xpart][ypart].hiddenTile = false;


    }

    public static boolean mineAdd() {
        Random rand = new Random();
        int upper = 4;
        int lower = 0;
        int mine = rand.nextInt(lower, upper);
        if (mine == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int neighbourMinesForHiddenBoard() {
        int neighboursCount = 0;
        boolean tileMine = false;

        for (int i = 1; i < tileStorage[1].length; i++) {
            for (int j = 1; j < tileStorage[1].length; j++) {
                for(int x = -1; x <= 1; x++){
                    for(int y = -1; y <= 1; y++){
                        if(tileStorage[x][y].mine){
                            neighboursCount++;
                        }
                    }
                }

            }
        }
        return neighboursCount;
    }

    /*public int nearby(){
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(tileStorage[i][j].mine){

                }
            }
        }
    }*/

    /*public int getGridSquareNum(){
        if(tileStorage[xpart + 1][ypart + 1].gridSquareType == 0){
            gridSquareNum = 0;
        }
        if(tileStorage[xpart + 1][ypart + 1].gridSquareType == 1){
            gridSquareNum = 1;
        }
        if(tileStorage[xpart + 1][ypart + 1].gridSquareType == 2){
            grid[xpart + 1][ypart + 1] = "[ F ]";
            gridSquareNum = 2;
        }
        if(tileStorage[xpart + 1][ypart + 1].gridSquareType == 3){
            grid[xpart + 1][ypart + 1] = "[ x ]";
            gridSquareNum = 3;
        }
        return gridSquareNum;

    }*/



}