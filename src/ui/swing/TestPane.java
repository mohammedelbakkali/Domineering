package ui.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class TestPane extends JPanel{

        // public static List<EventPane>  listEventPanel = new ArrayList<EventPane>();
         public static Map<EventPane,Position> mapEventPanel = new HashMap<>();

    public   TestPane(){


         setLayout(new GridBagLayout());
         GridBagConstraints  gbc = new GridBagConstraints();
         for(int row = 0; row<6 ; row++){
             for(int col = 0 ; col < 6 ; col++){
                 gbc.gridx=col;
                 gbc.gridy = row;
                  EventPane eventpane = new EventPane(this,row,col);

                  Border border = null;
                  border = new MatteBorder(1, 1, 1, 1, Color.lightGray);
                  String position = ""+row+"; "+col;
                 JLabel label = new JLabel(position);
                  eventpane.add(label);
                  eventpane.setBorder(border);
                  this.mapEventPanel.put(eventpane,new Position(row,col));
                 //listEventPanel.add(eventpane);
                  add(eventpane,gbc);

             }
        }

    }


    public static Map<EventPane,Position> getMapEventPanel() {

        return mapEventPanel;
    }
}
