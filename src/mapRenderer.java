import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by Kristoffer on 01/10/2015.
 */
public class MapRenderer extends JPanel {
    java.util.List<String> map;
    java.util.List<Node> path, closed, open;
    int height, width;
    boolean renderLists;
    Astar a;

    public MapRenderer(java.util.List<String> map, java.util.List<java.util.List<Node>> result, boolean renderLists){
        this.renderLists = renderLists;
        this.map = map;
        this.path = result.get(0);
        this.open = result.get(1);
        this.closed = result.get(2);
        a = new Astar();
        this.height = map.size()*30+40;
        this.width = map.get(0).length()*30;
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        //Renders a color for different map symbols. Checks if the coordinate is part of the open or closed list
        int i = 0;
        for(String line:map){
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if(c == '.'){
                    g.setColor(Color.WHITE);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == '#'){
                    g.setColor(Color.BLACK);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'A'){
                    g.setColor(Color.BLUE);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'B'){
                    g.setColor(Color.RED);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == '+') {
                    g.setColor(Color.YELLOW);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'w'){
                    g.setColor(new Color(83,118,176));
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'm'){
                    g.setColor(Color.GRAY);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'f'){
                    g.setColor(new Color(15,94,11));
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'g'){
                    g.setColor(new Color(77,232,152));
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'r'){
                    g.setColor(new Color(102,88,51));
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(open,j,i)){
                        g.setColor((Color.YELLOW));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }else if(renderLists && a.coordInList(closed,j,i)){
                        g.setColor((new Color(175,14,175)));
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }
            }
            i++;
        }
    }

    public void render(){
        JFrame f = new JFrame("Map");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.setSize(width, height);
        f.setVisible(true);
    }
}
