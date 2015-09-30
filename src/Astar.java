import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kristoffer on 30/09/2015.
 */
public class Astar {

    public List<Node> findPath(Map map){
        int xStart = map.getStartX();
        int yStart = map.getStartY();
        int xGoal = map.getGoalX();
        int yGoal = map.getGoalY();
        List<Node> open = new ArrayList<Node>();
        List<Node> closed = new ArrayList<Node>();
        Node current = new Node(null, xStart, yStart, 0, distance(xStart,yStart,xGoal,yGoal));
        open.add(current);
        while (!open.isEmpty()){
            Collections.sort(open, openSorter);
            current = open.get(0);
            if (current.getX() == xGoal && current.getY() == yGoal){
                List<Node> path = new ArrayList<Node>();
                while(current.getParent() != null){
                    path.add(current);
                    current = current.getParent();
                }
                return path;
            }
            open.remove(current);
            closed.add(current);
            for (int i = 0; i < 9; i++) {
                if (i == 4) continue;
                int x = current.getX();
                int y = current.getY();
                int xi = (i % 3) -1;
                int yi = (i / 3) -1;
                int nextX = x + xi;
                int nextY = y + yi;
                if(map.getCostAt(nextX,nextY)>0){
                    double gCost = current.getgCost() + distanceCost(x,y,nextX,nextY, map);
                    double hCost = distance(nextX,nextY,xGoal,yGoal);
                    Node node = new Node(current,nextX,nextY,gCost,hCost);
                    if(coordInList(closed, nextX, nextY) && gCost >= current.getgCost() ) continue;
                    if(!coordInList(open, nextX, nextY)) open.add(node);
                }

            }
        }
        return null;
    }

    public boolean coordInList(List<Node> list, int x, int y){
        for(Node n:list){
            if(n.getX() == x && n.getY() == y) return true;
        }
        return false;
    }

    private static double distanceCost(int x0, int y0, int x1, int y1, Map map){

        return (Math.sqrt(Math.pow((x0-x1),2)+Math.pow((y0-y1),2)))*map.getCostAt(x1,y1);
    }
    private static double distance(int x0, int y0, int x1, int y1){

        return (Math.sqrt(Math.pow((x0-x1),2)+Math.pow((y0-y1),2)));
    }

    private Comparator<Node> openSorter = new Comparator<Node>() {
        public int compare(Node n1, Node n2) {
            if(n2.getfCost()<n1.getfCost()) return 1;
            if(n2.getfCost() > n1.getfCost()) return -1;
            return 0;
        }
    };
}
