package ui.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

import static ui.swing.CelltPane.*;

public class TestPane extends JPanel{

        // public static List<EventPane>  listEventPanel = new ArrayList<EventPane>();
         public static Map<CelltPane,Position> mapCellPan = new LinkedHashMap<>();
         public static int counterVertical = 0;

    public   TestPane(){


         setLayout(new GridBagLayout());
         GridBagConstraints  gbc = new GridBagConstraints();
         for(int row = 0; row<6 ; row++){
             for(int col = 0 ; col < 6 ; col++){
                 gbc.gridx=col;
                 gbc.gridy = row;
                 CelltPane eventpane = new CelltPane(this,row,col,false);

                  Border border = null;
                  border = new MatteBorder(1, 1, 1, 1, Color.lightGray);
                  String position = ""+row+"; "+col;
                 JLabel label = new JLabel(position);
                  eventpane.add(label);
                  eventpane.setBorder(border);
                  mapCellPan.put(eventpane,new Position(row,col));
                 //listEventPanel.add(eventpane);
                  add(eventpane,gbc);

             }
        }

    }

    public static void getPossibleMouvesVertical(Map<CelltPane,Position> map){
        for (Map.Entry<CelltPane, Position> entry : map.entrySet()) {
            if(CelltPane.searchAdjVertical(entry.getValue().getX(), entry.getValue().getY())!=null){
                System.out.println(counterVertical);
                counterVertical++;
            }
        }
        System.out.println(counterVertical);
        counterVertical=0;
    }








    public static Map<CelltPane,Position> getMapCellPan() {

        return mapCellPan;
    }





    public static CelltPane getCelltPaneByPosition(int row, int col) {
        for (CelltPane cell : mapCellPan.keySet()) {
            Position position = mapCellPan.get(cell);
            if (position.getX() == row && position.getY() == col) {
                return cell;
            }
        }
        return null; // Return null if not found
    }








}
