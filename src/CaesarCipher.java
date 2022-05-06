import java.io.*;

public class CaesarCipher {
    static boolean containsAlphabet(char c, char[] array) {
        for (char x : Analizator.ALPHABET) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

    public static void Code(BufferedReader reader, BufferedWriter writer, int key) throws IOException {
        while (reader.ready()) {
            String line = reader.readLine().toLowerCase();
            for (char character : line.toCharArray()) {
                if (containsAlphabet(character, Analizator.ALPHABET)) {
                    int originalposition = Analizator.ALPHABETLIST.indexOf(character);
                    int newposition = (originalposition + key)% Analizator.ALPHABET.length;
                    char newchar = Analizator.ALPHABETLIST.get(newposition);
                    writer.write(newchar);
                } else {
                    writer.write(character);
                    continue;
                }
            }
            writer.write("\n");
        }
    }
    public static void DeCode(BufferedReader reader, BufferedWriter writer, int key) throws IOException {
        while (reader.ready()) {
            String line = reader.readLine().toLowerCase();
            for (char character : line.toCharArray()) {
                    if (containsAlphabet(character, Analizator.ALPHABET)) {
                        int originalposition = Analizator.ALPHABETLIST.indexOf(character);
                        int newposition = (originalposition - key)% Analizator.ALPHABET.length;
                        if (newposition<0) { newposition = Analizator.ALPHABETLIST.size() + newposition; }
                        char newchar = Analizator.ALPHABETLIST.get(newposition);
                        writer.write(newchar);
                    } else {
                        writer.write(character);
                        continue;
                    }
                }
            writer.write("\n");
        }
    }
}


