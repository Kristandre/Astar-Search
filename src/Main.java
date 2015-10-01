import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map map = new Map("boards/board-1-4.txt");
        Astar aStar = new Astar();
        List<Node> path = aStar.findPath(map);
        List<String> lines = map.mapLines;
        List<String> newMap = new ArrayList<String>();
        MapRenderer mr = new MapRenderer(lines, path);
        mr.render();
    }


}
