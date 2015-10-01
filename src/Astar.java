import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kristoffer on 30/09/2015.
 */
public class Astar {

    public List<List<Node>> findPath(Map map, String algorithm){
        //Find the start and end coordinates
        int xStart = map.getStartX();
        int yStart = map.getStartY();
        int xGoal = map.getGoalX();
        int yGoal = map.getGoalY();

        //Create open- and closed lists to keep track of where we have been and where we should look next
        List<Node> open = new ArrayList<Node>();
        List<Node> closed = new ArrayList<Node>();

        //Create root node and add to the open list
        Node current = new Node(null, xStart, yStart, 0, distance(xStart,yStart,xGoal,yGoal));
        open.add(current);

        //If the open list ever get empty means that there is no possible path to the target
        while (!open.isEmpty()){

            //Select algorithm to run
            if(algorithm.equals("a*")){
                Collections.sort(open, openSorter);
            }else if(algorithm.equals("bfs")){
                //Removing the sort makes the A* become BFS
            }else if(algorithm.equals("dijkstra")){
                //Sorting the open list according to gCost makes the A* become Dijkstra's Algorithm
                Collections.sort(open, dijkstraSorter);
            }

            //Select the first node in the open list and check if we are at the goal
            current = open.get(0);
            if (current.getX() == xGoal && current.getY() == yGoal){
                List<Node> path = new ArrayList<Node>();

                //Construct the path from goal to start
                while(current.getParent() != null){
                    path.add(current);
                    current = current.getParent();
                }

                //Return the path and the open- and closed lists
                List<List<Node>> lists = new ArrayList();
                lists.add(path);
                lists.add(open);
                lists.add(closed);
                return lists;
            }

            //If we are not at the goal, move the current node from open to closed list
            open.remove(current);
            closed.add(current);

            //Find the coordinates of the neighbour nodes
            for (int i = 1; i < 9; i+=2) {
                if (i == 4) continue;
                int x = current.getX();
                int y = current.getY();
                int xi = (i % 3) -1;
                int yi = (i / 3) -1;
                int nextX = x + xi;
                int nextY = y + yi;

                //MapCost = 0 means we cannot go there(Obstacle or edge of map)
                if(map.getCostAt(nextX,nextY)>0){
                    //Calculate gCost and fCost of the neighbouring node
                    double gCost = current.getgCost() + distanceCost(x,y,nextX,nextY, map);
                    double hCost = distance(nextX,nextY,xGoal,yGoal);
                    //Create the neighbouring node
                    Node node = new Node(current,nextX,nextY,gCost,hCost);
                    //Ignore the neighbouring if it is in the closed list and the gCost is higher than current gCost
                    if(coordInList(closed, nextX, nextY) && gCost >= current.getgCost() ) continue;
                    //Add the neighbouring node to the open list
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

    private Comparator<Node> dijkstraSorter = new Comparator<Node>() {
        public int compare(Node n1, Node n2) {
            if(n2.getgCost()<n1.getgCost()) return 1;
            if(n2.getgCost() > n1.getgCost()) return -1;
            return 0;
        }
    };
}
