import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,./;'[]\\=-`~!@#$%^&*()_+{}|:\"?><";
        Scanner input = new Scanner(System.in);

        // Get user option for encoding or decoding
        String option = "";
        while (!option.startsWith("e") && !option.startsWith("d")) {
            System.out.print("> Do you want to (e)ncode or (d)ecode: ");
            option = input.nextLine().toLowerCase();
        }
        boolean encoding = option.equals("e");

        // Get the message
        System.out.print("> Enter your secret message: ");
        String message = input.nextLine();

        // Get the shift amount
        System.out.print("> Enter the amount to shift (-1 for random): ");
        int shift = input.nextInt() % alphabet.length();
        input.nextLine();
        if (shift == -1) {
            shift = (int) (Math.random() * (alphabet.length() + 1));
        }

        // Create an Encoder or Decoder object to handle the message
        if (encoding) {
            Encoder encoder = new Encoder(alphabet, shift);
            System.out.println();
            encoder.printEncode(message);
            System.out.println();
            System.out.println(encoder.toString());
        } else {
            Decoder decoder = new Decoder(alphabet, shift);
            System.out.println();
            decoder.printDecode(message);
            System.out.println();
            System.out.println(decoder.toString());
        }

        // Close the scanner
        input.close();
    }

    /**
     * Text surrounder function for extra beautification. Takes a message and surrounds it with a certain character.
     *
     * @param str Represents the message to surround.
     * @param s   Represents the character to use to surround the message.
     * @return Returns a message surrounded in a box of the character.
     */
    public static String textSurrounder(String str, String s) {
        //Put your code here!
        String[] lines = str.split("\n");
        int longest = 0;
        for (String line : lines) {
            if (line.length() > longest) {
                longest = line.length();
            }
        }
        String result = s.repeat(longest + 2) + "\n";
        for (String line : lines) {
            result += s + line + " ".repeat(longest - line.length()) + s + "\n";
        }
        result += s.repeat(longest + 2);

        return result;
    }
}