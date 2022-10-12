import java.util.Random;
import java.util.Scanner;

public class Board {
    static int maxsize = 10;
    static Tiles[][] tileStorage = new Tiles[maxsize + 2][maxsize + 2];
    static int xpart;
    static int ypart;
    //String[][] grid;
    //int maxCount = 20;
    String[][] grid = new String[maxsize + 2][maxsize + 2];

    public Board() {
        hiddenBoard();

        //Tiles tiles = new Tiles();
        //int neighboursCount = tileStorage[xpart][ypart].getNeighbours();



        for(int i = 1; i < tileStorage.length; i++){
            //System.out.println("\n");
            for(int j = 1; j < tileStorage[0].length; j++){
                tileStorage[i][j].mine = mineAdd();
                //System.out.print(tileStorage[i][j].mine+ " ");
            }
        }

        tileStorage[5][5].mine = false;
        //tileStorage[5][4].mine = true;
        if (tileStorage[5][5].mine) {
            System.out.println("Hello!");
        }

    }

    /*public void boardUpdate() {
        for(int i = 1; i < tileStorage.length-1; i++){
            for(int j = 1; i < tileStorage[0].length-1; j++){
                if(!tileStorage[i][j].hiddenTile){
                    grid[i][j] = " ";
                }
                if(!tileStorage[i][j].mine){
                    grid[i][j] = "X";
                }

            }
        }
    }*/

    public void hiddenBoard(){

        for (int i = 1; i < tileStorage.length; i++) {
            System.out.println();
            for (int j = 1; j < tileStorage[0].length; j++) {

                tileStorage[i][j] = new Tiles(false, false,
                        true, 0);


                /*if (tileStorage[i][j].hiddenTile) {
                    grid[i][j] = "0";
                }
                if (tileStorage[i][j].flag) {
                    grid[i][j] = "1";
                }
                if (tileStorage[i][j].mine) {
                    grid[i][j] = "X";
                }
                System.out.print(grid[i][j] + " ");*/

            }
        }
    }

    public void userInputTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter x: ");
        xpart = sc.nextInt();
        System.out.println("\nEnter y: ");
        ypart = sc.nextInt();

        /*if (tileStorage[xpart][ypart].mine) {
            System.out.println("\nBaBaBaBAAAAAAAAAAAAAAMMMM!!!");
            tileStorage[xpart][ypart].hiddenTile = false;
        } else {
            System.out.print("\nNo Mine For You!");
        }*/
        int neighbourCount = neighbourMines();
        System.out.println("\nNeighbours: " + neighbourCount);
    }

    public static boolean mineAdd() {
        Random rand = new Random();
        int upper = 4;
        int lower = 0;
        int mine = rand.nextInt(4);
        if (mine == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int neighbourMines() {
        int neighboursCount = 0;
        boolean tileMine = false;

        for (int i = -1; i <= 1; i++) {
            //System.out.println("\n");

            for (int j = -1; j <= 1; j++) {

                //tileMine = tileStorage[xpart + i][ypart + j].mine;

                //System.out.print(tileStorage[xpart + i][ypart + j].mine);

                if ((xpart + i >= 0) && (xpart + i < maxsize)) {
                    if ((ypart + j >= 0) && (ypart + j < maxsize)) {
                        //tileStorage[xpart + i][ypart + j].mine = false;
                        if (tileStorage[xpart + i][ypart + j].mine == true) {
                            tileStorage[xpart][ypart].neighboursCount();
                            neighboursCount = tileStorage[xpart][ypart].neighbours;
                            System.out.println(neighboursCount);
                            System.out.print(tileStorage[xpart + i][ypart + j].mine);
                        }
                    }
                }
            }
        }
        return neighboursCount;
    }





}