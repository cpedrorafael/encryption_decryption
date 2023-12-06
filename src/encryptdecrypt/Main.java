package encryptdecrypt;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main {
    public static void main(String[] args) {
        Map<String, String> argMap = getStringStringMap(args);

        String dataArgInput = argMap.get("-data");

        String in = argMap.get("-in");

        if(dataArgInput.isEmpty() && in.isEmpty()){
            System.out.println();
            return;
        }

        File input = new File(in);

        String fileData = "";

        if(input.exists()){
            try{
                fileData = new String(Files.readAllBytes(Paths.get(in)));
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        String inputData = dataArgInput.isEmpty() ? fileData : dataArgInput;

        int shift = Integer.parseInt(argMap.get("-key"));

        String mode = argMap.get("-mode");

        EncryptionAlgorithm algorithm = EncryptionAlgorithmFactory.getAlgorithm(argMap.get("-alg"));

        String output = mode.equals("enc") ? algorithm.encrypt(inputData, shift) : algorithm.decrypt(inputData, shift);

        String outFilePath = argMap.get("-out");

        try(var writer = new java.io.FileWriter(outFilePath)) {
            writer.write(output);
        }catch (Exception e){
            System.out.println(output);
        }
    }

    private static Map<String, String> getStringStringMap(String[] args) {
        String paramName = "";
        Map<String, String> argMap = new HashMap<>();
        argMap.put("-mode", "enc");
        argMap.put("-key", "0");
        argMap.put("-data", "");
        argMap.put("-in", "");
        argMap.put("-out", "");

        for(int i = 0; i < args.length; i++){
            if(i % 2 == 0){
                paramName = args[i];
            }else{
                argMap.put(paramName, args[i]);
                paramName = "";
            }
        }
        return argMap;
    }

}
