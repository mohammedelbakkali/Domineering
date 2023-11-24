package ui.swing;


import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestGrid {



    public TestGrid(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestPane p = new TestPane();
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(p);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                DisplayPanelBord(p);
            }
        });


    }


    public static void main(String[] args) {
        new TestGrid();

    }


    public static void DisplayPanelBord(TestPane p){

        Map<EventPane,Position> map = p.getMapEventPanel();
        for (Map.Entry<EventPane, Position> entry : map.entrySet()) {
            System.out.println("Valeur x: " + entry.getValue().getX()+" Valeur Y: "+entry.getValue().getY());
        }
    }
}
