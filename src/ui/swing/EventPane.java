package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class EventPane extends JPanel {

    private Color defaultBackground;
    int row;
    int col;
    public boolean cliked;
    private TestPane testPane;
    private EventPane searchPane;
    public EventPane(TestPane testPane,int row , int col , boolean cliked){


        this.col = col;
        this.row = row;
        this.testPane=testPane;
        this.cliked=cliked;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                defaultBackground = getBackground();
                //searchPane = searchAdj(row,col);

                System.out.println("row : "+row+" , col : "+col);
                searchPane.setBackground(Color.GREEN);
                searchPane.cliked=true;
                setCliked(true);
                setBackground(Color.GREEN);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                defaultBackground = getBackground();
                searchPane = searchAdj(row,col);
                if(isCliked()==false && searchPane.isCliked()==false){
                    searchPane.setBackground(Color.GREEN);
                    setBackground(Color.GREEN);
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(isCliked()==false && searchPane.isCliked()==false ){
                    searchPane.setBackground(defaultBackground);
                    setBackground(defaultBackground);
                }



            }
        });
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(100,100);
    }

    public EventPane searchAdj(int row , int col){

        Map<EventPane,Position> map = testPane.getMapEventPanel();
        for (Map.Entry<EventPane, Position> entry : map.entrySet()) {

            if(entry.getValue().getX()==row-1 && entry.getValue().getY()==col){
                System.out.println("@@@@@ Valeur x: " + entry.getValue().getX()+" Valeur Y: "+entry.getValue().getY());
                return entry.getKey();
            }
        }

        return null;

    }


    public void setCliked(boolean cliked) {
        this.cliked = cliked;
    }

    public boolean isCliked() {
        return cliked;
    }
}
