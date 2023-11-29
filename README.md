### But : Développer une application Java qui implémente le jeu du Domineering ( Appelé aussi  Stop-Gate or Crosscram) et  met en oeuvre les algorithmes de recherche adversiales et les heuristiques vus dans le cours.


Principe du jeu:
Le plateau est constitué d'un arrangement rectangulaire de carrés mais peut avoir n'importe quelle dimension de nxm carrés. Il y a deux joueurs qui, à tour de rôle, placent un domino occupant deux cases sur le plateau, un limité à placer ses pièces dans une orientation verticale et l'autre limité à placer ses pièces dans une orientation horizontale. Le jeu continue jusqu'à ce qu'il n'y ait plus d'espace approprié pour qu'un des joueurs puisse placer un de ses dominos sur le plateau. Le joueur qui a effectué le dernier  coup légal remporte la partie; il ne peut pas y avoir de match nul.


L’application doit prendre en considération ce qui suit :
Permettre au joueur de demander de l'aide un nombre fini de fois
Fixer la complexité du jeu
Fixer la stratégie du jeu pour la machine et lors de la demande d'aide
Fixer l'heuristique à utliliser (Proposez au moins deux)
Reprendre la hiérarchie des classes Java vue en classe (voir l'attachement)
Remplacer la méthode  alphaBetaHelper(...) pour tenir compte de la version de la stratégie alpha-beta décrite dans la diapostive 18 du cours.
Permettre de jouer à deux ou contre la machine
Donner la possibilité de sauvegarder la partie et de la reprendre ultérieurement
Rejouer des parties sauvegardées