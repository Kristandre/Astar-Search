import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map map = new Map("boards/board-2-2.txt");
        Astar aStar = new Astar();
        List<Node> path = aStar.findPath(map);
        List<String> lines = map.mapLines;
        System.out.println("Path length: " + path.size());
        int y = 0;
        for(String line: lines){
            String newLine ="";
            for (int x = 0; x < line.length(); x++) {
                if(map.getGoalX()==x && map.getGoalY() == y){
                    newLine += "B";
                }else if(aStar.coordInList(path, x,y)) {
                    newLine += "+";
                }else{
                    newLine += line.charAt(x);
                }
            }
            System.out.println(newLine);
            y++;
        }
    }


}
