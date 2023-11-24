import javax.swing.*;

public class MenuSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Création de la barre de menu
        JMenuBar menuBar = new JMenuBar();

        // Création du menu
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("help");
        JMenu save = new JMenu("save");
        JMenu saveas = new JMenu("save as");
        // Création de l'élément de menu
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem saveMenuItem = new JMenuItem("save");

        // Ajout de l'élément de menu au menu
        fileMenu.add(exitMenuItem);
        fileMenu.add(saveMenuItem);

        // Ajout du menu à la barre de menu
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        menuBar.add(save);
        menuBar.add(saveas);
        // Définition de la barre de menu pour la fenêtre
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        // Affichage de la fenêt
    }
}
