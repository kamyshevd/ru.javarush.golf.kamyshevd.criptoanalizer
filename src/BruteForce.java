import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    static int counter = 0;
    public static int key;
    public static List<Character> arrayList = new ArrayList<>();

    public static void bruteForce(BufferedReader Reader, BufferedWriter Writer) throws Exception {
        while (Reader.ready()) {
            String line = Reader.readLine().toLowerCase();
            if (line == null) {
                continue;
            }
            for (char character : line.toCharArray()) {
                    arrayList.add(character);
                }
            arrayList.add('\n');
        }
        for (key = 1; key < Analizator.ALPHABET.length; key++) {
            for (char character : arrayList) {
                if (CaesarCipher.containsAlphabet(character, Analizator.ALPHABET)) {
                    int originalposition = Analizator.ALPHABETLIST.indexOf(character);
                    int newposition = (originalposition - key)% Analizator.ALPHABET.length;
                    if (newposition<0) { newposition = Analizator.ALPHABETLIST.size() + newposition; }
                    char newchar = Analizator.ALPHABETLIST.get(newposition);
                    if (newchar == 'а' || newchar == 'о' || newchar == 'e') {
                        counter++;
                    }
                }
            }
            double structure = (double) counter / arrayList.size() * 100;
            if (structure >= 10 && structure <= 30) {
                System.out.println("Доля букв а,о,е в структуре текста = " + structure);
                System.out.println("Ключ расшифровки - " + key);
                for (char character : arrayList) {
                    if (CaesarCipher.containsAlphabet(character, Analizator.ALPHABET)) {
                        int originalposition = Analizator.ALPHABETLIST.indexOf(character);
                        int newposition = (originalposition - key)% Analizator.ALPHABET.length;
                        if (newposition<0) { newposition = Analizator.ALPHABETLIST.size() + newposition; }
                        char newchar = Analizator.ALPHABETLIST.get(newposition);
                        Writer.write(newchar);
                    } else {
                        Writer.write(character);
                    }
                }
                Writer.write("\n");
                counter = 0;
            } else {
                counter =0;
                continue;
            }
        }
    }
}
