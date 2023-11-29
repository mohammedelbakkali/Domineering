package ui.swing;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import static ui.swing.CelltPane.*;

public class TestGrid {
    public static TestPane p;

    public TestGrid() {
          p = new TestPane();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Créer un TestPane


                // Créer un JFrame
                JFrame frame = new JFrame("Domineering");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Créer une barre de menu
                //=======================================
                JMenuBar menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("Fichier");
                JMenu sauvegarder = new JMenu("Sauvegarder");
                JMenu nouveau  = new JMenu("Nouveau partie");
                JMenu listeJeu  = new JMenu("liste des parties enregistrées");
                JMenuItem exitMenuItem = new JMenuItem("Quitter");
                JMenu partie1  = new JMenu("partie 1");
                //=======================================
                JMenuItem newGame = new JMenuItem("new");

                // Ajouter un écouteur d'événements pour le menu Quitter
                newGame.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      //  DisplayPanelBord(p);
                    }
                });

                // Ajouter les éléments de menu au menu
                listeJeu.add(partie1);
                fileMenu.add(exitMenuItem);
                nouveau.add(newGame);
                //=======================================
                // Ajouter le menu Fichier à la barre de menu
                menuBar.add(fileMenu);
                menuBar.add(sauvegarder);
                menuBar.add(nouveau);
                menuBar.add(listeJeu);
                // Définir la barre de menu pour le frame
                frame.setJMenuBar(menuBar);
                // Définir la disposition et ajouter le TestPane au frame
                frame.setLayout(new BorderLayout());
                frame.add(p, BorderLayout.CENTER);

                // Pack et afficher le frame
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Afficher les coordonnées de chaque EventPane
            }
        });
    }

    public static void main(String[] args) {
        new TestGrid();



    }

    public static void DisplayPanelBord(TestPane p) {
        // Récupérer la carte d'EventPane à Position depuis TestPane
        Map<CelltPane, Position> map = p.getMapCellPan();

        // Afficher les coordonnées de chaque EventPane
        for (Map.Entry<CelltPane, Position> entry : map.entrySet()) {
            System.out.println("Valeur x : " + entry.getValue().getX() + " Valeur Y : " + entry.getValue().getY());
            entry.getKey().cliked=false;

            Color customColor = new Color(238, 238, 238);

            entry.getKey().setBackground(customColor);

        }
    }




}
