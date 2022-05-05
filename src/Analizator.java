import java.io.*;
import java.util.Scanner;

public class Analizator {
    public static  final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',','"', '\'', ':', '!', '?', ' '};
     static Scanner scanner = new Scanner(System.in);
    private static int key;
    static String filepath;
    public static File file = new File("Example.txt");
    public static void main(String[] args) throws Exception {

        System.out.println("Выберите режим программы:\n" +
                "1.Шифровка текста\n" +
                "2.Расшифровка текста с помощью ключа\n" +
                "3.Расшифровка текста с помощью brute force (перебор всех вариантов)\n"+
                "4.Выход");
        int i = scanner.nextInt();
        switch (i) {
            case 1 :
                System.out.println("Введите адрес файла");
                scanner.nextLine();
                filepath = scanner.nextLine();
                System.out.println("Введите ключ шифра для шифрования текста");
                key = scanner.nextInt();
                try (BufferedReader Reader = new BufferedReader(new FileReader (filepath));
                     BufferedWriter Writer = new BufferedWriter(new FileWriter (file))) {
                    CaesarCipher.Code(Reader,Writer,key);
                }
            break;
            case 2 :
                System.out.println("Введите адрес файла");
                scanner.nextLine();
                filepath = scanner.nextLine();
                System.out.println("Введите ключ шифра для расшифровки текста");
                key = scanner.nextInt();
                try (BufferedReader reader = new BufferedReader(new FileReader (filepath));
                     BufferedWriter writer = new BufferedWriter(new FileWriter (file))) {
                    CaesarCipher.DeCode(reader, writer, key);
                }
            break;
            case 3 : System.out.println("Введите адрес файла");
                scanner.nextLine();
                filepath = scanner.nextLine();
                try (BufferedReader reader = new BufferedReader(new FileReader (filepath));
                          BufferedWriter writer = new BufferedWriter(new FileWriter (file))) {
                BruteForce.bruteforce(reader, writer);
                }
            break;
            case 4 : System.exit(0);
        }
    }
}
