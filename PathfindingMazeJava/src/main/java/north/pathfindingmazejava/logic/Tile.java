package north.pathfindingmazejava.logic;

public class Tile implements Comparable<Tile> {

    private int value; // Might be used for algorithms
    private int x;
    private int y;
    private boolean start;
    private boolean end;
    private boolean checked;
    private boolean blocked;
    
    
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.start = false;
        this.end = false;
        this.blocked = false;
        this.checked = false;
        this.value = 1; // Might be used for algorithms
    }
    
    public Tile(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.start = false;
        this.end = false;
        this.blocked = false;
        this.checked = false;  
    }
    
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
    
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isChecked() {
        return checked;
    }

    public boolean isEnd() {
        return end;
    }

    public boolean isStart() {
        return start;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }    
    
    @Override
    public int compareTo(Tile other) {
        if (other.getValue() > this.getValue()) {
            return 1;
        }
        return -1;
    } 
    
    
    public boolean equal(Tile other) {
        if (this.x == other.getX() && this.y == other.getY()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

}
