public class SudokuSolver {
    private static final int BOARD_SIZE = 9;
    private static final int[][] BOARD_TO_SOLVE = {
        {8,0,0,0,0,0,0,0,0},
        {0,0,3,6,0,0,0,0,0},
        {0,7,0,0,9,0,2,0,0},
        {0,5,0,0,0,7,0,0,0},
        {0,0,0,0,4,5,7,0,0},
        {0,0,0,1,0,0,0,3,0},
        {0,0,1,0,0,0,0,6,8},
        {0,0,8,5,0,0,0,1,0},
        {0,9,0,0,0,0,4,0,0},
    };

    private int[][] board;

    public SudokuSolver() {
        this.board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = BOARD_TO_SOLVE[i][j];
            }
        }
    }
    public static void main(String [] args) {
        SudokuSolver solver = new SudokuSolver();
        solver.printBoard();
        solver.solve();
        solver.printBoard();
    }

    private boolean solve() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                // Search an empty cell
                if (board[row][col] == 0) {
                    // Try possible numbers
                    for (int number = 1; number <= BOARD_SIZE; number++) {
                        if (isValid(row, col, number)) {
                            board[row][col] = number;
                            
                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int row, int column, int number) {
        return (!checkRow(row, number) && !checkColumn(column, number) && !checkBox(row, column, number));
    }

    private boolean checkRow(int row, int number) {
        for (int column = 0; column < BOARD_SIZE; column++) {
            if (board[row][column] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int column, int number) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board[row][column] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean checkBox(int row, int column, int number) {
        int currRow = row - (row % 3);
        int currCol = column - (column % 3);

        for (int i = currRow; i < currRow + 3; i++) {
            for (int j = currCol; j < currCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}