/**
 * The Decoder class creates an object with a certain alphabet and shift amount. The object can then be used to decode
 * a message.
 */
public class Decoder {
    private String alphabet;
    private int shift;

    /**
     * toString method for the Decoder class
     *
     * @return returns a string containing the alphabet and shift amount being used surrounded in a border of =
     */
    public String toString() {
        String message = "Alphabet: " + alphabet + "\nShift amount: " + shift;
        return Main.textSurrounder(Main.textSurrounder(message, " "), "=");
    }

    /**
     * Constructor for the Decoder class. Default constructor, no parameters. Sets the alphabet to the
     * lowercase english alphabet and sets the shift amount to 1.
     */
    public Decoder() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = 1;
    }

    /**
     * Constructor for the Decoder class. Sets the shift amount to 1.
     *
     * @param alphabet represents the special alphabet to use.
     */
    public Decoder(String alphabet) {
        this.alphabet = alphabet;
        this.shift = 1;
    }

    /**
     * Constructor for the Decoder class. Sets the alphabet to the
     * the lowercase english alphabet.
     *
     * @param shift represents the amount to shift.
     */
    public Decoder(int shift) {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = shift;
    }

    /**
     * Constructor for the Decoder class.
     *
     * @param alphabet represents the special alphabet to use.
     * @param shift    represents the amount to shift.
     */
    public Decoder(String alphabet, int shift) {
        this.alphabet = alphabet;
        this.shift = shift;
    }

    /**
     * A method to decode the message. Takes a message parameter and shifts it by the designated shift amount using the
     * specified alphabet.
     *
     * @param message Represents the message to decode.
     * @return Returns the decoded message.
     */
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

    /**
     * A method to print the decoded message.
     *
     * @param message Represents the message to print.
     */
    public void printDecode(String message) {
        System.out.println("Decoded message: " + decode(message));
    }
}