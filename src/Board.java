import java.util.Random;
import java.util.Scanner;

public class Board {
    static int maxsize = 10;
    static Tiles[][] tileStorage = new Tiles[maxsize + 2][maxsize + 2];
    static int xpart;
    static int ypart;
    static int gridSquareNum = 0;
    String[][] grid = new String[maxsize + 2][maxsize + 2];

    public Board() {

        //hiddenBoard();
        //populateHiddenWithMines();
        //visualBoard();

        for(int i = 1; i < tileStorage[1].length; i++){
            for(int j = 1; j < tileStorage[1].length; j++){
                tileStorage[i][j].mine = mineAdd();
            }
        }

        //tileStorage[6][6].mine = true;
        if (tileStorage[5][5].mine) {
            System.out.println("Hello!");
        }
    }

    public void hiddenBoard(){
        for (int i = 1; i < tileStorage[1].length; i++) {
            for (int j = 1; j < tileStorage[1].length; j++) {
                tileStorage[i][j] = new Tiles(true, false,
                        true, false, 0, gridSquareNum);
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

                System.out.print(tileStorage[i][j].checked);
            }
        }
    }
    public void boardUpdate() {
        for(int i = 1; i < tileStorage.length - 1; i++){
            System.out.println();
            for(int j = 1; j < tileStorage[1].length - 1; j++){

                if(tileStorage[i][j].mine && !tileStorage[i][j].hiddenTile && tileStorage[i][j].checked){
                    grid[i][j] = "[ X ]";
                    System.out.print(grid[i][j]);
                }
                if(tileStorage[i][j].flag){
                    grid[i][j] = "[ F ]";
                    System.out.print(grid[i][j]);
                }
                if(!tileStorage[i][j].hiddenTile && !tileStorage[i][j].mine && tileStorage[i][j].checked){
                    grid[i][j] = "[   ]";
                    System.out.print(grid[i][j]);
                }
                if(tileStorage[i][j].hiddenTile){
                    grid[i][j] = "[ | ]";
                    System.out.print(grid[i][j]);
                }
                System.out.print(tileStorage[i][j].mine);
            }

        }
    }

    public void userInputTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter x: ");
        xpart = sc.nextInt();
        System.out.println("\nEnter y: ");
        ypart = sc.nextInt();

        //tileStorage[xpart][ypart].hiddenTile = false;
        tileStorage[xpart][ypart].checked = true;



        //int neighbourCount = neighbourMinesForHiddenBoard();
        //System.out.println("\nNeighbours: " + neighbourCount);
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

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((xpart + i >= 0) && (xpart + i < maxsize)) {
                    if ((ypart + j >= 0) && (ypart + j < maxsize)) {
                        if (tileStorage[xpart + i][ypart + j].mine == true) {
                            neighboursCount = tileStorage[xpart][ypart].neighbours;
                        }
                    }
                }
            }
        }
        return neighboursCount;
    }

    public int getGridSquareNum(){
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

    }



}