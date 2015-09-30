import java.util.Comparator;

public class Node {

    private Node parent;
    private int x,y;
    private double fCost, gCost, hCost;

    public Node (Node parent, int x, int y, double gCost, double hCost) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.gCost = gCost;
        this.hCost = hCost;
        this.fCost = gCost + hCost;
    }



    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getfCost() {
        return fCost;
    }

    public double getgCost() {
        return gCost;
    }

    public void setgCost(double gCost) {
        this.gCost = gCost;
    }

    public double gethCost() {
        return hCost;
    }

    public void sethCost(double hCost) {
        this.hCost = hCost;
    }

    public void setfCost(double fCost) {
        this.fCost = fCost;
    }
}
