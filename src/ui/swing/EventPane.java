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


    private int counterVertical= 0 ;
    private int counterHorizontal= 0 ;


    public boolean vertical  = true;
    public boolean horizontal = false;

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


          if(!isCliked() && !searchPane.isCliked()){
              searchPane.cliked=true;
              setCliked(true);
              if(vertical){
                  searchPane.setBackground(Color.blue);
                  searchPane.cliked=true;
                  setCliked(true);
                  setBackground(Color.blue);
                  // ------
                  counterVertical++;
              }else{
                  searchPane.setBackground(Color.GREEN);
                  searchPane.cliked=true;
                  setCliked(true);
                  setBackground(Color.GREEN);
                  // ------
                  counterHorizontal++;
              }
          }else{
              System.out.println("impossible de colorer");
          }


            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                defaultBackground = getBackground();
                System.out.println(defaultBackground);
                if(vertical){
                    searchPane = searchAdjVertical(row,col);
                    if(!isCliked() && !searchPane.isCliked()){
                        searchPane.setBackground(Color.blue);
                        setBackground(Color.blue);
                    }else {
                        System.out.println("impossible de colorer");
                    }
                }else {
                    searchPane = searchAdjHorizontal(row,col);
                    if(!isCliked() && !searchPane.isCliked()){
                        searchPane.setBackground(Color.GREEN);
                        setBackground(Color.GREEN);
                    }else{
                        System.out.println("impossible de colorer");
                    }
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

    public EventPane searchAdjVertical(int row , int col){

        Map<EventPane,Position> map = testPane.getMapEventPanel();
        for (Map.Entry<EventPane, Position> entry : map.entrySet()) {

            if(entry.getValue().getX()==row-1 && entry.getValue().getY()==col){
                System.out.println("@@@@@ Valeur x: " + entry.getValue().getX()+" Valeur Y: "+entry.getValue().getY());
                return entry.getKey();
            }
        }

        return null;

    }


    public EventPane searchAdjHorizontal(int row , int col){

        Map<EventPane,Position> map = testPane.getMapEventPanel();
        for (Map.Entry<EventPane, Position> entry : map.entrySet()) {

            if(entry.getValue().getX()==row && entry.getValue().getY()+1==col){
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
