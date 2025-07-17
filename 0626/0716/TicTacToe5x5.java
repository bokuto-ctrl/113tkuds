import java.util.Scanner;
public class TicTacToe5x5 {
static final int SIZE = 5;
    static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();

        System.out.println("=== 5x5 井字遊戲 ===\n");
        printBoard();

        char currentPlayer = 'X';
        int moves = 0;

        while (true) {
            int row = -1, col = -1;

            while (true) {
                System.out.printf("玩家 %c 請輸入位置 (row col): ", currentPlayer);
                if (scanner.hasNextInt()) row = scanner.nextInt();
                else { scanner.next(); continue; }
                if (scanner.hasNextInt()) col = scanner.nextInt();
                else { scanner.next(); continue; }

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("座標超出範圍，請重新輸入！");
                } else if (board[row][col] != '.') {
                    System.out.println("該位置已有棋子，請重新輸入！");
                } else {
                    break; // 合法輸入
                }
            }

            board[row][col] = currentPlayer;
            moves++;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", currentPlayer, row, col);
            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.printf("玩家 %c 獲勝！\n", currentPlayer);
                break;
            }

            if (moves == SIZE * SIZE) {
                System.out.println("平手！");
                break;
            }

            // 換玩家
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    // 初始化棋盤
    static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    // 印出棋盤
    static void printBoard() {
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++)
            System.out.print(col + " ");
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 勝利判斷
    static boolean checkWin(char player) {
        // 橫排
        for (int i = 0; i < SIZE; i++) {
            boolean win = true;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != player) {
                    win = false; break;
                }
            }
            if (win) return true;
        }

        // 直排
        for (int j = 0; j < SIZE; j++) {
            boolean win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != player) {
                    win = false; break;
                }
            }
            if (win) return true;
        }

        // 主對角線
        boolean winDiag = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != player) {
                winDiag = false; break;
            }
        }
        if (winDiag) return true;

        // 反對角線
        boolean winAnti = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != player) {
                winAnti = false; break;
            }
        }
        return winAnti;
    }
}
