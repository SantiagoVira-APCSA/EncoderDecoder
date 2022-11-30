/**
 * The Decoder class creates an object with a certain alphabet and shift amount. The object can then be used to decode
 * a message.
 */
public class Decoder {
    private String alphabet;
    private int shift;

    public String toString() {
        String message = "Alphabet: " + alphabet + "\nShift amount: " + shift;
        return Main.textSurrounder(Main.textSurrounder(message, " "), "=");
    }

    public Decoder() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = 1;
    }

    public Decoder(String alphabet) {
        this.alphabet = alphabet;
        this.shift = 1;
    }

    public Decoder(int shift) {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = shift;
    }

    public Decoder(String alphabet, int shift) {
        this.alphabet = alphabet;
        this.shift = shift;
    }

    public String decode(String message) {
        String notSecret = "";

        for (int i = 0; i < message.length(); i++) {
            String letter = message.substring(i, i + 1);
            if (alphabet.contains(letter)) {
                int idx = alphabet.indexOf(letter);
                int newIdx = (idx - shift) >= 0 ? (idx - shift) : alphabet.length() - Math.abs(idx - shift);
                notSecret += alphabet.substring(newIdx, newIdx + 1);
            }
        }

        return notSecret;
    }

    public void printDecode(String message) {
        System.out.println("Decoded message: " + decode(message));
    }
}