package encryptdecrypt;

public class EncryptionAlgorithmFactory {
    public static EncryptionAlgorithm getAlgorithm(String algorithm) {
        return switch (algorithm) {
            case "unicode" -> new UnicodeEncryption();
            default -> new ShiftEncryption();
        };
    }
}
