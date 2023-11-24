import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;
public class GridBagLayoutExample extends JFrame{
    GridBagLayout GridBagLayoutgrid;
    public static void main(String[] args) {
        GridBagLayoutExample a = new GridBagLayoutExample();
    }
    public GridBagLayoutExample() {
        GridBagLayoutgrid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setTitle("GridBag Layout Example");


        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(new Button(" One"), gbc);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(new Button(" tow"), gbc);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(new Button(" tree"), gbc);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(new Button(" four"), gbc);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(new Button(" five"), gbc);

        setSize(300, 300);
        setPreferredSize(getSize());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}  