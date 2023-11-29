package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.*;
import java.util.List;


public class CelltPane extends JPanel {

    private Color defaultBackground;
    int row;
    int col;
    public boolean cliked;
    private static TestPane testPane;
    private CelltPane searchPane;

     public static boolean   hasWinner = false;


    private static int counterVertical= 0 ;
    private static  int counterHorizontal= 0 ;

    private static char role;// role 'v' or 'h'


    public static boolean vertical  =true ;
    public static boolean horizontal =false;

   // public static List<LinkedHashMap<Position,Position>> possiblesMovesVerticale;
   // public static List<LinkedHashMap<Position,Position>> possiblesMovesHorizontal;

    public static List<CelltPane> possiblesMovesVerticale;
    public static List<CelltPane> possiblesMovesHorizontal;


    public CelltPane(TestPane testPane,int row , int col , boolean cliked){

        possiblesMovesVerticale=new ArrayList<>();
        possiblesMovesHorizontal = new ArrayList<>();
        this.col = col;
        this.row = row;
        CelltPane.testPane =testPane;
        this.cliked=cliked;
        role='v';
        game();
    }


     //

    public void game(){

       initializeMouseListener();


    }




    public void initializeMouseListener() {
        addMouseListener(new MouseAdapter() {


            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                defaultBackground = getBackground();
                //searchPane = searchAdj(row,col);

                System.out.println("row : "+row+" , col : "+col);


                    if(role=='v'){
                        if(!isCliked() && !searchPane.isCliked()){
                            searchPane.cliked=true;
                            setCliked(true);
                            searchPane.setBackground(Color.blue);
                            searchPane.cliked=true;
                            setCliked(true);
                            setBackground(Color.blue);
                            role='h';
                        }else{
                            System.out.println("impossible de colorer");
                        }
                    }else{
                         //min max
                        if(!isCliked() && !searchPane.isCliked()){
                            searchPane.cliked=true;
                            setCliked(true);
                            searchPane.setBackground(Color.GREEN);
                            searchPane.cliked=true;
                            setCliked(true);
                            setBackground(Color.GREEN);
                            role='v';
                        }else{
                            System.out.println("impossible de colorer");
                        }

                }

                }

                // minmax();


            @Override
            public void mouseEntered(MouseEvent e) {


                super.mouseEntered(e);
                defaultBackground = getBackground();
                System.out.println(defaultBackground);

                if(counterVertical==0 || counterHorizontal==0){
                    checkWiner();
                }


                if(role=='v'){
                    searchPane = searchAdjVertical(row,col);
                    // chercher board adj vertical

                    if(searchPane==null){
                        System.out.println("perdooonaaa is clicked");
                    }else{
                        if(!isCliked() && !searchPane.isCliked()){
                            searchPane.setBackground(Color.blue);
                            setBackground(Color.blue);

                        } else if (!isCliked() && searchPane.isCliked()) {
                            System.out.println("impossible de colorer");
                        } else {
                            System.out.println("impossible de colorer");
                        }
                    }

                    //  int res =   minmax(testPane,10,false);
                    //  System.out.println("resultttttttttttt :  "+res);

                    //minimaxMove();
                }else {

                    searchPane = searchAdjHorizontal(row,col); // chercher board adj horizontal
                    if(searchPane==null){
                        System.out.println("perdooonaaa is clicked");
                    }else{
                        if(!isCliked() && !searchPane.isCliked()){
                            searchPane.setBackground(Color.GREEN);
                            setBackground(Color.GREEN);
                        }else{
                            System.out.println("impossible de colorer");
                        }
                    }


                }



            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(searchPane==null){
                    System.out.println("on ne peut pas exit car nous avons pas entred !");
                }else{
                    if(!isCliked() && !searchPane.isCliked()){
                        searchPane.setBackground(defaultBackground);
                        setBackground(defaultBackground);
                    }
                }




            }
        });
    }











    @Override
    public Dimension getPreferredSize(){
        return new Dimension(100,100);
    }












    /**
     * searchAdjVertical
     * */




    public static CelltPane searchAdjVertical(int row, int col){

        Map<CelltPane,Position> map = TestPane.getMapCellPan();
        // gestion Exceptions de manier statique :

             for (Map.Entry<CelltPane, Position> entry : map.entrySet()) {
                 // chercher la valeur adjacent vertical +1
                 if(entry.getValue().getX()==row+1 && entry.getValue().getY()==col){
                     if(!entry.getKey().isCliked()){
                         System.out.println("@@@@@ Valeur x: " + entry.getValue().getX()+" Valeur Y: "+entry.getValue().getY());
                         return entry.getKey();
                     }
             /**
                     else  {
                         // si la cellul +1 isCliked on va verifier la cellul -1
                         for (Map.Entry<CelltPane, Position> item : map.entrySet()){
                             if(item.getValue().getX()==row-1 && item.getValue().getY()==col){
                                 if(!item.getKey().isCliked()){
                                     //counterVertical--;
                                     return item.getKey();
                                 }
                             }
                         }


                     }*/
             }
         }



        return null;

    }




    public static CelltPane searchAdjHorizontal(int row, int col){
        Map<CelltPane,Position> map = TestPane.getMapCellPan();


            for (Map.Entry<CelltPane, Position> entry : map.entrySet()) {

                if(entry.getValue().getX()==row && entry.getValue().getY()==col+1){
                    if(!entry.getKey().isCliked()){
                        System.out.println("@@@@@ Valeur x: " + entry.getValue().getX()+" Valeur Y: "+entry.getValue().getY());
                        return entry.getKey();
                    }
                    /**
                    else{
                        for (Map.Entry<CelltPane, Position> item : map.entrySet()){
                            if(item.getValue().getX()==row && item.getValue().getY()==col-1){
                                if(!item.getKey().isCliked()){
                                    counterHorizontal--;
                                    return item.getKey();
                                }
                            }
                        }
                    }*/


            }
        }

        return null;

    }






    public static void getPossibleMouvesVertical(){

        possiblesMovesVerticale.clear();

        counterVertical=0;
        int c = 0;
        Map<CelltPane,Position> map = TestPane.getMapCellPan();
        for (Map.Entry<CelltPane, Position> entry : map.entrySet()) {
             if(!entry.getKey().cliked){

                  if(searchAdjVertical(entry.getValue().getX(),entry.getValue().getY())!=null){

                      c++;
                      CelltPane adjacentVerticale = searchAdjVertical(entry.getValue().getX(),entry.getValue().getY());
                      System.out.println(entry.getValue().getX()+" , "+entry.getValue().getY());
                      System.out.println(adjacentVerticale.row+" , "+adjacentVerticale.col);

                      possiblesMovesVerticale.add(entry.getKey());


                      //entry.getKey().setBackground(Color.red);
                      //adjacentVerticale.setBackground(Color.yellow);
                      System.out.println("=======================: "+c);
                       counterVertical++;
                  }
             }
        }

    }


    public static void getPossibleMouvesHorizontal(){

        possiblesMovesHorizontal.clear();
        counterHorizontal=0;
        Map<CelltPane,Position> map = TestPane.getMapCellPan();
        for (Map.Entry<CelltPane, Position> entry : map.entrySet()) {
            if(!entry.getKey().cliked){
                if(searchAdjHorizontal(entry.getValue().getX(),entry.getValue().getY())!=null){
                    CelltPane adjacentHorizontal = searchAdjHorizontal(entry.getValue().getX(),entry.getValue().getY());
                    possiblesMovesHorizontal.add(entry.getKey());
                    counterHorizontal++;
                }
            }
        }

    }

    public static int checkWiner(){
        int cellVide = 0;
        // 2 : v wen, -2 : h wen , 0 , Tie 1
        Map<CelltPane,Position> map = TestPane.getMapCellPan();
        if(counterHorizontal==0 && counterVertical==0){
            for (Map.Entry<CelltPane, Position> entry : map.entrySet()) {
                if(!entry.getKey().isCliked()){
                    cellVide++;
                }
            }
            if(cellVide==0){
                System.out.println("il n'y a pas de gagnant");
                return 0;
            }else{

                if(role=='v'){
                    System.out.println("Horizontal gagnant !");
                    return 2;
                }
                else if (role=='h'){
                    System.out.println("Vertical gagnant !");
                    return -2;
                }
            }
        } else if (counterHorizontal!=0 && counterVertical==0) {
            System.out.println("Vertical gagnant !");
            // h is wen
            return -2;
        } else if (counterHorizontal==0 && counterVertical!=0) {
            System.out.println("Vertical gagnant !");
            // v is wen
            return 2;
        }
        return 0;
    }





    public void setCliked(boolean cliked) {
          this.cliked = cliked;
          getPossibleMouvesHorizontal();
          getPossibleMouvesVertical();
          System.out.println("counter horizontal -> ---- "+counterHorizontal);
          System.out.println("counter vertical -> ---- "+counterVertical);

    }

    public boolean isCliked() {
        return cliked;
    }



    // MINIMAX
    static int minmax(TestPane pane, int depth, boolean isMaximizing) {
        int result = checkWiner();
        if (result != 1 || depth == 10) {
            return result;
        }

        if (isMaximizing) {
            int maxScore = Integer.MIN_VALUE;


                    getPossibleMouvesVertical();
                    List<CelltPane> listVertical = possiblesMovesVerticale;
                    Iterator<CelltPane> itr = listVertical.listIterator();
                    while (itr.hasNext()){
                        if(!itr.next().isCliked()){
                            CelltPane adjVertecal=searchAdjVertical(itr.next().row,itr.next().col);

                            adjVertecal.setCliked(true);
                            itr.next().setCliked(true);
                            int score =minmax(pane,depth+1,false);
                            itr.next().setCliked(false);
                            adjVertecal.setCliked(false);
                            maxScore = Math.max(score, maxScore);
                        }
            }
            return maxScore;
        } else {
            int minScore = Integer.MAX_VALUE;

                    getPossibleMouvesHorizontal();
                    List<CelltPane> listVertical = possiblesMovesHorizontal;
                    Iterator<CelltPane> itr = listVertical.listIterator();
                    while (itr.hasNext()){
                        if(!itr.next().isCliked()){
                            CelltPane adjVertecal=searchAdjHorizontal(itr.next().row,itr.next().col);

                            adjVertecal.setCliked(true);
                            itr.next().setCliked(true);
                            int score =minmax(pane,depth+1,true);
                            itr.next().setCliked(false);
                            adjVertecal.setCliked(false);
                            minScore = Math.min(score, minScore);
                        }
                    }

            return minScore;
        }
    }


    static int[] findBestMove(TestPane pane) {
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                    // logique de max
                getPossibleMouvesVertical();
                List<CelltPane> listVertical = possiblesMovesVerticale;
                Iterator<CelltPane> itr = listVertical.listIterator();
                while (itr.hasNext()){
                    if(!itr.next().isCliked()){
                        CelltPane adjVertecal=searchAdjVertical(itr.next().row,itr.next().col);

                        adjVertecal.setCliked(true);
                        itr.next().setCliked(true);
                        int moveVal =minmax(pane,0,false);
                        itr.next().setCliked(false);
                        adjVertecal.setCliked(false);

                        if(moveVal > bestVal){
                            bestMove[0]=itr.next().row;
                            bestMove[1]=itr.next().col;
                        }

                    }
                }
                //=============

            }
        }

        return bestMove;
    }






}
