import java.util.*;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char c = (char)((ch - 'A' + shift) % 26 + 'A');
                result.append(c);
            }
            else if (Character.isLowerCase(ch)) {
                char c = (char)((ch - 'a' + shift) % 26 + 'a');
                result.append(c);
            }
            else {
                result.append(ch); // spaces, numbers, symbols
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String message = sc.nextLine();

        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(message, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);
        sc.close();
    }
}
 
    

