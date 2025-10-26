private static final char[][] MAPPING = {
        {'7', '8', '9'},
        {'4', '5', '6'},
        {'1', '2', '3'}
};

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    do {
        playGame(scanner);
        System.out.println("Хотите сыграть еще раз? (да/нет)");
    } while (scanner.nextLine().toLowerCase().matches("д(а)?"));

    System.out.println("Спасибо за игру!");
    scanner.close();
}
private static void playGame(Scanner scanner) {
    System.out.println("Соответствие клеток номерам 1-9:");
    printTable(MAPPING);

    char[][] table = new char[3][3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            table[i][j] = ' ';
        }
    }

    char currentPlayer = new Random().nextBoolean() ? 'X' : '0';

    while (true) {
        makeMove(table, currentPlayer, scanner);
        printTable(table);

        if (checkWin(table, currentPlayer)) {
            System.out.println((currentPlayer == 'X' ? "Первый" : "Второй") + " игрок выиграл!");
            return;
        }

        if (isDraw(table)) {
            System.out.println("Ничья!");
            return;
        }

        currentPlayer = (currentPlayer == 'X') ? '0' : 'X';
    }
}
private static void printTable(char[][] table) {
    for (int i = 0; i < 3; i++) {
        System.out.println("-------------");
        for (int j = 0; j < 3; j++) {
            System.out.print("| " + table[i][j] + " ");
        }
        System.out.println("|");
    }
    System.out.println("-------------\n");
}
private static void makeMove(char[][] table, char symbol, Scanner scanner) {
    String playerName = symbol == 'X' ? "Первый игрок" : "Второй игрок";

    while (true) {
        System.out.println(playerName + ", введите номер клетки (1-9):");
        String input = scanner.nextLine();

        if (input.length() == 1) {
            char digit = input.charAt(0);
            if (digit >= '1' && digit <= '9') {
                if (placeSymbol(table, digit, symbol)) {
                    return;
                }
            }
        }
        System.out.println("Неверный ввод! Пожалуйста, введите число от 1 до 9.");
    }
}
private static boolean placeSymbol(char[][] table, char digit, char symbol) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (MAPPING[i][j] == digit && table[i][j] == ' ') {
                table[i][j] = symbol;
                return true;
            }
        }
    }
    System.out.println("Эта клетка уже занята! Попробуйте другую!");
    return false;
}
private static boolean checkWin(char[][] table, char symbol) {
    for (int i = 0; i < 3; i++) {
        if ((table[i][0] == symbol && table[i][1] == symbol && table[i][2] == symbol) ||
                (table[0][i] == symbol && table[1][i] == symbol && table[2][i] == symbol)) {
            return true;
        }
    }

    return (table[0][0] == symbol && table[1][1] == symbol && table[2][2] == symbol) ||
            (table[0][2] == symbol && table[1][1] == symbol && table[2][0] == symbol);
}
private static boolean isDraw(char[][] table) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (table[i][j] == ' ') {
                return false;
            }
        }
    }
    return true;
}