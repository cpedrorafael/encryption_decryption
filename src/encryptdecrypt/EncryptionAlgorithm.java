package encryptdecrypt;

public abstract class EncryptionAlgorithm {
    public abstract String encrypt(String data, int key);
    public abstract String decrypt(String data, int key);
}

