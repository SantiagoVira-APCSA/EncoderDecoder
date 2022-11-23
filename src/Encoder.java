public class Encoder {
    private String alphabet;
    private int shift;

    public String toString() {
        String message = "Alphabet: " + alphabet + "\nShift amount: " + shift;
        return Main.textSurrounder(Main.textSurrounder(message, " "), "=");
    }

    public Encoder() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = 1;
    }

    public Encoder(String alphabet) {
        this.alphabet = alphabet;
        this.shift = 1;
    }

    public Encoder(String alphabet, int shift) {
        this.alphabet = alphabet;
        this.shift = shift;
    }

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

    public void printEncode(String message) {
        System.out.println("Encoded message: " + encode(message));
    }
}
