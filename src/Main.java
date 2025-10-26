private static final char[][] MAPPING = {
        {'7', '8', '9'},
        {'4', '5', '6'},
        {'1', '2', '3'}
};

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    do {
        System.out.println("Хотите сыграть еще раз? (да/нет)");
    } while (scanner.nextLine().toLowerCase().matches("д(а)?"));

    System.out.println("Спасибо за игру!");
    scanner.close();
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