import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Scanner;


public class TicTacToe {
    public static void main(String[] args) {
        Game();
    }

    public static void Game() {
        String[] gameState = empty();
        String status = get_status(gameState);
        String nextPlayer = "X";

        while (status.equals("Game not finished")) {
            board(gameState);
            process(gameState, nextPlayer);
            status = get_status(gameState);
            nextPlayer = nextPlayer.equals("X") ? "O" : "X";
        }

        board(gameState);
        System.out.println(status);
    }

    public static String[][] Rows(String[] gameState) {
        String[][] rows = new String[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(gameState, i * 3, rows[i], 0, 3);
        }
        return rows;
    }

    public static String[][] Cols(String[] gameState) {
        String[][] cols = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cols[i][j] = gameState[i + 3 * j];
            }
        }
        return cols;
    }

    public static boolean available(String[] gameState) {
        return Arrays.asList(gameState).contains(" ");
    }

    public static boolean col_X(String[] gameState) {
        return colOf("X", gameState);
    }

    public static boolean row_O(String[] gameState) {
        return rowOf("O", gameState);
    }

    public static boolean right_diagonal_OfXs(String[] gameState) {
        return right_diag_O("X", gameState);
    }

    public static boolean diagonal_OfXs(String[] gameState) {
        return right_diagonal_OfXs(gameState) || left_diagonal_OfXs(gameState);
    }

    public static boolean diagonal_OfOs(String[] gameState) {
        return right_diag_Os(gameState) || left_diagonal_OfOs(gameState);
    }

    public static boolean line(String player, String[] line) {
        String[] expectedLine = new String[]{player, player, player};
        return Arrays.equals(line, expectedLine);
    }

    public static boolean lines(String player, String[][] lines) {
        for (String[] line : lines) {
            if (line(player, line)) {
                return true;
            }
        }
        return false;
    }

    public static boolean right_diag_O(String player, String[] gameState) {
        return line(player, get_right_diagonal(gameState));
    }

    public static boolean right_diag_Os(String[] gameState) {
        return right_diag_O("O", gameState);
    }

    public static boolean left_diagonal_OfXs(String[] gameState) {
        return left_diagonal_Of("X", gameState);
    }

    public static boolean left_diagonal_OfOs(String[] gameState) {
        return left_diagonal_Of("O", gameState);
    }

    public static void board(String[] gameState) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", gameState[3 * i + j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean left_diagonal_Of(String player, String[] gameState) {
        return line(player, get_left_diagonal(gameState));
    }

    public static boolean Owins(String[] gameState) {
        return row_O(gameState) || col_OfOs(gameState) || diagonal_OfOs(gameState);
    }

    public static boolean col_OfOs(String[] gameState) {
        return colOf("O", gameState);
    }

    public static boolean rowOf(String player, String[] gameState) {
        return lines(player, Rows(gameState));
    }
    public static boolean colOf(String player, String[] gameState) {
        return lines(player, Cols(gameState));
    }

    public static void process(String[] game_state, String player) {
        try {
            System.out.print("Enter the coordinates: ");
            place coordinates = user_action();
            make_user_action(coordinates, game_state, player);
        } catch (exception_action e) {
            System.out.println("Coordinates should be from 1 to 3!");
            process(game_state, player);
        } catch (exception_place e) {
            System.out.println("This cell is occupied! Choose another one!");
            process(game_state, player);
        } catch (InputMismatchException e) {
            System.out.println("You should enter numbers!");
            process(game_state, player);
        }
    }

    public static String[] get_right_diagonal(String[] gameState) {
        return new String[]{gameState[0], gameState[4], gameState[8]};
    }

    public static String[] get_left_diagonal(String[] gameState) {
        return new String[]{gameState[2], gameState[4], gameState[6]};
    }

    public static int count(String player, String[] gameState) {
        int count = 0;
        for (String move : gameState) {
            if (move.equals(player)) {
                count++;
            }
        }
        return count;
    }

    public static boolean wrong(String[] gameState) {
        int movesDiff = count("X", gameState) - count("O", gameState);
        return movesDiff < -1 || movesDiff > 1;
    }

    public static String get_status(String[] state) {
        String status = "Unknown game state";

        if (impossible(state)) {
            status = "Impossible";
        } else if (notEnd(state)) {
            status = "Game not finished";
        } else if (Xwins(state)) {
            status = "X wins";
        } else if (Owins(state)) {
            status = "O wins";
        } else if (Draw(state)) {
            status = "Draw";
        }

        return status;
    }

    public static place user_action() throws exception_action {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt() - 1;
        int x = scanner.nextInt() - 1;
        return new place(x, y);
    }

    public static void make_user_action(place coordinates, String[] gameState, String player)
            throws exception_place {
        String target = gameState[coordinates.y * 3 + coordinates.x];

        if (target.equals("X") || target.equals("O")) {
            throw new exception_place();
        }

        gameState[coordinates.y * 3 + coordinates.x] = player;
    }

    public static String[] empty() {
        String[] board = new String[9];
        Arrays.fill(board, " ");
        return board;
    }
}


class exception_action extends Exception {
}

class exception_place extends Exception {
}

class place {
    public final int x;
    public final int y;

    place(int x, int y) throws exception_action {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            throw new exception_action();
        }
        this.x = x;
        this.y = y;
    }
}
