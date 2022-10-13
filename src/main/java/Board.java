import java.util.Random;
import java.util.Scanner;

public class Board {
    static int maxsize = 10;
    Tiles[][] tileStorage = new Tiles[maxsize + 2][maxsize + 2];

    static int gridSquareNum = 0;
    String[][] grid = new String[maxsize + 2][maxsize + 2];

    //int[][] nearbyMinesGrid = new int[maxsize + 2][maxsize + 2];

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
                    if(val == 0){
                        grid[i][j] = "[   ]";
                    }else{
                        grid[i][j] = "[ "+ val + " ]";
                    }

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
        String flagOrReveal;

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter y: ");
        xpart = sc.nextInt();
        System.out.println("\nEnter x: ");
        ypart = sc.nextInt();
        System.out.println("\nWhat do you want to place? [F]lag, [R]eveal Tile");
        Scanner ss = new Scanner(System.in);
        flagOrReveal = ss.nextLine();
        if(flagOrReveal.equals("F")){
            tileStorage[xpart][ypart].flag = true;
        } else if (flagOrReveal.equals("R")) {
            tileStorage[xpart][ypart].hiddenTile = false;
            tileStorage[xpart][ypart].flag = false;
        }

        if(!tileStorage[xpart][ypart].hiddenTile){
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    if(tileStorage[xpart + i][ypart + j] == null){
                        break;
                    }
                     else if(tileStorage[xpart + i][ypart + j].hiddenTile
                            && !tileStorage[xpart + i][ypart + j].mine
                            && tileStorage[xpart + i][ypart + j].neighbours <= 0)
                    {
                        tileStorage[xpart + i][ypart + j].hiddenTile = false;
                    }
                }
            }
        }

    }

    public static boolean mineAdd() {
        Random rand = new Random();
        int upper = 6;
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

        for (int i = 1; i < tileStorage[1].length-1; i++) {
            for (int j = 1; j < tileStorage[1].length-1; j++) {
                for(int x = -1; x <= 1; x++){
                    for(int y = -1; y <= 1; y++){
                        if(tileStorage[i + x][j + y] == null){
                            break;
                        }
                        else if(tileStorage[i + x][j + y].mine){
                            tileStorage[i][j].neighbours++;
                        }
                    }
                }

            }
        }
        return neighboursCount;
    }




}