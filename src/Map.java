import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristoffer on 30/09/2015.
 */
public class Map {
    String mapPath;
    int startX, startY, goalX, goalY;
    int mapHeight, mapWidth;

    ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();

    List<String> mapLines;

    public Map(String mapPath) {
        this.mapPath = mapPath;
        generateMap();
    }

    private void generateMap(){
        try{
            this.mapLines = Files.readAllLines(Paths.get(this.mapPath),
                    StandardCharsets.UTF_8);
            int i = 0;
            this.mapHeight = mapLines.size();
            this.mapWidth = mapLines.get(0).length();
            for(String line:mapLines){
                map.add(new ArrayList<Integer>());
                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j);
                    if(c == '.'){
                        map.get(i).add(1);
                    }else if(c == '#'){
                        map.get(i).add(0);
                    }else if(c == 'A'){
                        startX = j;
                        startY = i;
                        map.get(i).add(1);
                    }else if(c == 'B'){
                        goalX = j;
                        goalY = i;
                        map.get(i).add(1);
                    }else if(c == 'w'){
                        map.get(i).add(100);
                    }else if(c == 'm'){
                        map.get(i).add(50);
                    }else if(c == 'f'){
                        map.get(i).add(10);
                    }else if(c == 'g'){
                        map.get(i).add(5);
                    }else if(c == 'r'){
                        map.get(i).add(1);
                    }
                }
                i++;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("hei");
        }
    }

    int getCostAt(int x, int y){
        if(x > mapWidth -1 || x < 0 || y > mapHeight -1 || y < 0) return 0;
        return map.get(y).get(x);
    }
    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getGoalX() {
        return goalX;
    }

    public void setGoalX(int goalX) {
        this.goalX = goalX;
    }

    public int getGoalY() {
        return goalY;
    }

    public void setGoalY(int goalY) {
        this.goalY = goalY;
    }
}
