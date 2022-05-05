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

    public static String Code(BufferedReader reader, BufferedWriter writer, int key) throws IOException {
        while (reader.ready()) {
            String string = reader.readLine();
            for (char character : string.toCharArray()) {
                if (containsAlphabet(character, Analizator.ALPHABET) && character != ' ') {
                    int originalAlphabetPosition = character - 'а';
                    int newAlphabetPosition = (originalAlphabetPosition + key) % Analizator.ALPHABET.length;
                    char newCharacter = (char) ('а' + newAlphabetPosition);
                    writer.write(newCharacter);
                } else {
                    continue;
                }
            }
            writer.write("\n");
        }
        return Analizator.file.toString();
    }
    public static String DeCode(BufferedReader reader, BufferedWriter writer, int key) throws IOException {
        while (reader.ready()) {
            String string = reader.readLine();
            for (char character : string.toCharArray()) {
                    if (containsAlphabet(character, Analizator.ALPHABET) && character != ' ') {
                        int originalAlphabetPosition = character - 'а';
                        int newAlphabetPosition = (originalAlphabetPosition - key) % Analizator.ALPHABET.length;
                        char newCharacter = (char) ('а' + newAlphabetPosition);
                        writer.write(newCharacter);
                    } else {
                        continue;
                    }
                }
            writer.write("\n");
        }
        return Analizator.file.toString();
    }
}


