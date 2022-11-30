/**
 * The Encoder class creates an object with a certain alphabet and shift amount. The object can then be used to encode
 * a message.
 */
public class Encoder {
    private String alphabet;
    private int shift;

    /**
     * toString method for the Encoder class
     *
     * @return returns a string containing the alphabet and shift amount being used surrounded in a border of =
     */
    public String toString() {
        String message = "Alphabet: " + alphabet + "\nShift amount: " + shift;
        return Main.textSurrounder(Main.textSurrounder(message, " "), "=");
    }

    /**
     * Constructor for the Encoder class. Default constructor, no parameters. Sets the alphabet to the
     * lowercase english alphabet and sets the shift amount to 1.
     */
    public Encoder() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = 1;
    }

    /**
     * Constructor for the Encoder class. Sets the shift amount to 1.
     *
     * @param alphabet represents the special alphabet to use.
     */
    public Encoder(String alphabet) {
        this.alphabet = alphabet;
        this.shift = 1;
    }

    /**
     * Constructor for the Encoder class. Sets the alphabet to the
     * the lowercase english alphabet.
     *
     * @param shift represents the amount to shift.
     */
    public Encoder(int shift) {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = shift;
    }

    /**
     * Constructor for the Encoder class.
     *
     * @param alphabet represents the special alphabet to use.
     * @param shift    represents the amount to shift.
     */
    public Encoder(String alphabet, int shift) {
        this.alphabet = alphabet;
        this.shift = shift;
    }

    /**
     * A method to encode the message. Takes a message parameter and shifts it by the designated shift amount using the
     * specified alphabet.
     *
     * @param message Represents the message to encode.
     * @return Returns the encoded message.
     */
    public String encode(String message) {
        String secret = "";

        for (int i = 0; i < message.length(); i++) {
            String letter = message.substring(i, i + 1);
            if (alphabet.contains(letter)) {
                int idx = alphabet.indexOf(letter);
                int newIdx = (idx + shift) % alphabet.length();
                secret += alphabet.substring(newIdx, newIdx + 1);
            }
        }

        return secret;
    }

    /**
     * A method to print the encoded message.
     *
     * @param message Represents the message to print.
     */
    public void printEncode(String message) {
        System.out.println("Encoded message: " + encode(message));
    }
}
