import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by Kristoffer on 01/10/2015.
 */
public class MapRenderer extends JPanel {
    java.util.List<String> map;
    java.util.List<Node> path;
    int height, width;
    Astar a;
    public MapRenderer(java.util.List<String> map, java.util.List<Node> path){
        this.map = map;
        this.path = path;
        a = new Astar();
        this.height = map.size()*30+40;
        this.width = map.get(0).length()*30;
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

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
                    }
                }else if(c == '#'){
                    g.setColor(Color.BLACK);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'A'){
                    g.setColor(Color.BLUE);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'B'){
                    g.setColor(Color.RED);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == '+') {
                    g.setColor(Color.YELLOW);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'w'){
                    g.setColor(new Color(83,118,176));
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'm'){
                    g.setColor(Color.GRAY);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'f'){
                    g.setColor(new Color(15,94,11));
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'g'){
                    g.setColor(new Color(77,232,152));
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }else if(c == 'r'){
                    g.setColor(new Color(102,88,51));
                    g.fillRect(j * 30, i * 30, 30, 30);
                    if(a.coordInList(path,j,i)){
                        g.setColor(Color.BLACK);
                        g.fillRect(j * 30+12, i * 30+12, 5, 5);
                    }
                }
            }
            i++;
            System.out.println(i);
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
