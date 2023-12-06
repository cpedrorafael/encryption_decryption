package encryptdecrypt;

public class UnicodeEncryption extends EncryptionAlgorithm {
    @Override
    public String encrypt(String data, int key) {
        char[] arr = data.toCharArray();
        shiftArray(arr, key);
        return new String(arr);
    }

    @Override
    public String decrypt(String data, int key) {
        char[] arr = data.toCharArray();
        shiftArray(arr, key * -1);
        return new String(arr);
    }

    private void shiftArray(char[] arr, int shift) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (arr[i] + shift);
        }
    }
}
