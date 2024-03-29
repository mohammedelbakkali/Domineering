import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
public class TestGrid02 {
    public static void main(String[] args) {
        new TestGrid02();
    }
    public TestGrid02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    public class TestPane extends JPanel {
        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 6; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;
                    CellPane cellPane = new CellPane();
                    Border border = null;
                    border = new MatteBorder(1, 1, 1, 1, Color.black);
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                }
            }
        }
    }
    public class CellPane extends JPanel {
        private Color defaultBackground;
        public CellPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.GREEN);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.GREEN);
                }
            });
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}