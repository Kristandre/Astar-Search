import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Select map
        Map map = new Map("boards/board-2-3.txt");
        Astar aStar = new Astar();
        //Select "a*", "bfs" or "dijkstra" algorithm
        List<List<Node>> result = aStar.findPath(map, "a*");
        //Render the result. True if you want to see the open and closed lists. Open = Yellow squared, closed = pink squares
        MapRenderer mr = new MapRenderer(map.mapLines, result, true);
        mr.render();
    }


}
