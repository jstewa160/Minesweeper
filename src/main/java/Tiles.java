public class Tiles {
    boolean mine;
    boolean flag;
    boolean hiddenTile;
    boolean checked;
    int neighbours = 0;
    int gridSquareType = 0;

    public Tiles(boolean mine, boolean flag, boolean hiddenTile, boolean checked,
                 int neighbours, int gridSquareType)
    {
        this.mine = false;
        this.flag = flag;
        this.hiddenTile = hiddenTile;
        this.checked = checked;
        this.neighbours = neighbours;
    }



    public boolean isHiddenTile() {
        return hiddenTile;
    }

    public boolean isFlag() {
        return flag;
    }

    public boolean isMine(){
        return mine;
    }

    public int neighboursCount() {
        neighbours = neighbours + 1;
        return neighbours;
    }

    public int getNeighbours(){ return neighbours; }
}
