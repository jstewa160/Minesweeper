public class Tiles {
    static boolean mine;
    boolean flag;
    boolean hiddenTile;
    boolean checked;
    int neighbours = 0;

    public Tiles(boolean mine, boolean flag, boolean hiddenTile,
                 int neighbours)
    {
        this.mine = false;
        this.flag = flag;
        this.hiddenTile = hiddenTile;
    }



    public boolean isHiddenTile() {
        return hiddenTile;
    }

    public boolean isFlag() {
        return flag;
    }

    public static boolean isMine(){
        return mine;
    }

    public int neighboursCount() {
        neighbours = neighbours + 1;
        return neighbours;
    }

    public int getNeighbours(){ return neighbours; }
}
