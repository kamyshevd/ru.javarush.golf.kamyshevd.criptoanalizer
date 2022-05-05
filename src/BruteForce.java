import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BruteForce {
    static int counter = 0;
    static int linecounter = 0;
    public static int key;
    public static List<Character> arrayList = new ArrayList<>();

    public static String bruteforce(BufferedReader Reader, BufferedWriter Writer) throws Exception {
        while (Reader.ready() ) {
            String string = Reader.readLine();
            linecounter++;
            if (string == null) {
                continue;
            }
            for (char character : string.toCharArray()) {
                if (CaesarCipher.containsAlphabet(character, Analizator.ALPHABET) && character != ' ') {
                    arrayList.add(character);
                }
            }
        }
        for (key = 1; key < Analizator.ALPHABET.length; key++) {
            for (char character : arrayList) {
                int originalAlphabetPosition = character - 'а';
                int newAlphabetPosition = (originalAlphabetPosition - key) % Analizator.ALPHABET.length;
                char newCharacter = (char) ('а' + newAlphabetPosition);
                if (newCharacter == 'а' || newCharacter == 'о' || newCharacter == 'e') {
                    counter++;
                }
            }
            double structure = (double) counter / arrayList.size() * 100;
            System.out.println(structure);
            if (structure >= 30 && structure <= 40) {
                System.out.println(key);
                System.out.println(arrayList);
                for (char character : arrayList) {
                    char newCharacter = (char) (character - key) ;
                    Writer.write(newCharacter);
                }
                break;
            } else {
                continue;
            }
        }
        return Analizator.file.toString();
    }
}
  /*  public static String bruteforce(BufferedReader Reader, BufferedWriter Writer) throws Exception {
        if (Reader == null) return "";
        for (int key = 0; key < Analizator.Alphabet.length; key++) {
            for (int i = 0; i < linecounter; i++) {
                String string = Reader.readLine();
                for (char character : string.toCharArray()) {
                    for (int j = 0; j < text.length; j++) {
                        if (CaesarCipher.containsAlphabet(character, Analizator.Alphabet)) {
                            int originalAlphabetPosition = character - 'а';
                            int newAlphabetPosition = (originalAlphabetPosition - key) % Analizator.Alphabet.length;
                            char newCharacter = (char) ('а' + newAlphabetPosition);
                            if (newCharacter == 'а' || newCharacter == 'о' || newCharacter == 'e') {
                                counter = counter + 1;ч
                                text[j] = newCharacter;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        }
        if (((counter/text.length)*100 >= 20) && ((counter/text.length)*100 <=30)) {
            return Analizator.file.toString();
    }
}*/
