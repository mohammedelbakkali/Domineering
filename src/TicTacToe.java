import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        printBoard(board);

        Scanner scanner = new Scanner(System.in);

        while (!isGameOver(board)) {
            // Tour du joueur
            playerMove(board, scanner);
            printBoard(board);

            if (isGameOver(board)) {
                System.out.println("Le joueur a gagné!");
                break;
            }

            // Tour de l'IA (Minimax)
            int[] aiMove = minimaxMove(board);
            System.out.println("L'IA a joué en position : " + (aiMove[0] + 1) + ", " + (aiMove[1] + 1));
            board[aiMove[0]][aiMove[1]] = 'O';
            printBoard(board);

            if (isGameOver(board)) {
                System.out.println("L'IA a gagné!");
                break;
            }
        }

        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println("Tableau actuel : ");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playerMove(char[][] board, Scanner scanner) {
        System.out.println("Entrez votre mouvement (ligne colonne) : ");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;

        // Vérifier si le mouvement est valide
        while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Mouvement invalide. Entrez à nouveau : ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        }

        board[row][col] = 'X';
    }

    public static boolean isGameOver(char[][] board) {
        return hasContestantWon(board, 'X') || hasContestantWon(board, 'O') || isBoardFull(board);
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        // Vérifier les lignes et les colonnes
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // Vérifier les diagonales
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
      //  System.out.println("Match nul!");
        return true;
    }

    public static int[] minimaxMove(char[][] board) {
        int[] bestMove = {-1, -1};
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = '0';
                    int score = minimax(board, 0, false);
                    board[i][j] = ' '; // Annuler le mouvement

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    private static int minimax(char[][] board, int depth, boolean isMaximizing) {
        if (hasContestantWon(board, 'X')) {
            return -1;
        } else if (hasContestantWon(board, 'O')) {
            return 1;
        } else if (isBoardFull(board)) {
            return 0;
        }

        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int eval = minimax(board, depth + 1, false);
                        board[i][j] = ' '; // Annuler le mouvement
                        maxEval = Math.max(maxEval, eval);
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int eval = minimax(board, depth + 1, true);
                        board[i][j] = ' '; // Annuler le mouvement
                        minEval = Math.min(minEval, eval);
                    }
                }
            }
            return minEval;
        }
    }
}
