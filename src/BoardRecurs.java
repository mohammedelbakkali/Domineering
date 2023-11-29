public class BoardRecurs {
    public char[][] tab;
    public int counter = 0;
    public BoardRecurs(){
           this.tab = new char[3][3];
           for(int i = 0 ; i < 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    this.tab[i][j]='_';
                }
           }
    }


    public void display(String text){
        System.out.println(" ----------------  "+text);
        for (int i = 0 ; i<3 ; i++){
             for(int j = 0 ; j<3  ; j++){
                  System.out.print(this.tab[i][j]+" ");
             }
             System.out.println(" ");
        }
    }

    public int verifier(char [][] board){
          for(int i = 0 ; i< 3 ; i++){
               if(board[0][i]=='x') return 1;
              else if(board[1][i]=='x') return -1;
               else if(board[2][i]=='x') return 0;
          }

          return 0;
    }


    public int aff(){
        if(verifier(this.tab)==1){
            System.out.println("condition vérifier");
            return 1;
        }
        if(verifier(this.tab)==-1) return -1;
        if(verifier(this.tab)==-1) return 1;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(this.tab[i][j]=='_'){
                    this.tab[i][j]='X';
                    this.display("avant récursivité");
                     int a =   aff();

                    counter++;
                    System.out.println("INstruction  :  "+counter);
                    this.display("après récursivité");
                    this.tab[i][j]='O';

                }
            }

        }
        return 1;
    }
    public static void main(String[] args) {
        BoardRecurs a = new BoardRecurs();
        a.aff();
    }
}
