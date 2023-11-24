import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class clsCanvasPanel extends JPanel {
    private static final int intRows = 10;
    private static final int intCols = 10;
    private List<JPanel> jpllist = new ArrayList<JPanel>();
    public clsCanvasPanel() {
        /*
         *
         * Add eventListener to individual JPanel within CanvasPanel
         *
         *
         * TODO :
         * 1) mousePressed --> update Temperature and HeatConstant of clsElement Class
         * 2) start a new thread and
         * 3) call clsElement.run() method
         *
         *
         * Right Now : it updates the colours of the JPanel
         * */
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JPanel panel = (JPanel) e.getSource();
                Component[] components = panel.getComponents();
                for (Component component : components) {
                    component.setVisible(!component.isVisible());
                    component.setBackground(new Color(255,255,0));
                }
                panel.revalidate();
                panel.repaint();
            }
        };
//TODO : refactoring
        GridLayout gdlyPlates = new GridLayout();
        gdlyPlates.setColumns(intCols);
        gdlyPlates.setRows(intRows);
        gdlyPlates.setHgap(0);
        gdlyPlates.setVgap(0);
        setLayout(gdlyPlates);
//TODO : refactoring
        for (int row = 0; row < intRows; row++) {
            for (int col = 0; col < intCols; col++) {
                JPanel panel = new JPanel(new GridBagLayout());
                panel.setOpaque(false);
                JPanel jl = new JPanel();
                jl.setVisible(true);
                panel.add(jl);
                panel.addMouseListener(mouseListener);
                jpllist.add(panel);
                add(panel);
            }
        }
    }
}