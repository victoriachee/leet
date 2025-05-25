package _HackerRank;

public class D3CaesarCipher {

    /**
     * Encrypts a message using the Caesar Cipher with a given shift.
     *
     * @param message The message to be encrypted.
     * @param shift   The shift value for encryption.
     * @return The encrypted message.
     */
    public static String encrypt(String message, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                // 'base' is the starting character of the case ('A' for uppercase, 'a' for lowercase).
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                // Represents relative position in the alphabet. 
                // ASCIIval(ch) - ASCIIval(base) = positions ch is away from start of the alphabet.
                // '% 26' ensures result stays within the bounds of the alphabet during shifting.
                // '+ base' adjusts result back to ASCII of actual character.
                char encryptedChar = (char) ((ch - base + shift) % 26 + base); 
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    /**
     * Decrypts a message using the Caesar Cipher with a given shift.
     *
     * @param encryptedMessage The message to be decrypted.
     * @param shift            The shift value for decryption.
     * @return The decrypted message.
     */
    public static String decrypt(String encryptedMessage, int shift) {
        // To decrypt, use the opposite shift by subtracting the original shift from 26.
        return encrypt(encryptedMessage, 26 - shift);
    }

    /**
     * Main method demonstrating the usage of CaesarCipher class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Example Usage
        String originalMessage = "Hello, World!";
        int shift = 3;

        String encryptedMessage = encrypt(originalMessage, shift);
        System.out.println("Encrypted: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted: " + decryptedMessage);
    }
    
}
