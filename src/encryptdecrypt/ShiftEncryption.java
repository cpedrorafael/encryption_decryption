package encryptdecrypt;

public class ShiftEncryption extends EncryptionAlgorithm {
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
            if(Character.isAlphabetic(arr[i]))
                if(Character.isUpperCase(arr[i])){
                    int shifted = arr[i] - 'A';
                    shifted = shifted < 0 ? 26 + shifted : shifted;
                    int rotated = (shifted + shift) % 26;
                    int shiftedBack = rotated + 'A';
                    arr[i] = (char) shiftedBack;
                }
                else{
                    int shifted = arr[i] - 'a' + shift;
                    shifted = shifted < 0 ? 26 + shifted : shifted;
                    int rotated = shifted % 26;
                    int shiftedBack = rotated + 'a';
                    arr[i] = (char) shiftedBack;
                }

        }
    }
}
