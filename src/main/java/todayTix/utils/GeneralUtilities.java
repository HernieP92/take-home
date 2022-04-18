package todayTix.utils;



import todayTix.logs.Log;

import java.io.File;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

public class GeneralUtilities {
    private GeneralUtilities() {
        throw new IllegalStateException("Utility class");
    }

    public static String uuidGenerator(){
        return String.valueOf(UUID.randomUUID());
    }

    public static String bearerTokenGenerator() {
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder base64Encoder = Base64.getUrlEncoder();
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public static String currentDateGenerator(String dateFormat) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    public static void createDirectory(String path) {
        new File(path).mkdir();
        path="ubicación del directorio creado: ".concat(path);
        Log.LOGGER.info(path);
    }

    public static void deleteFile(String path){
        File file = new File(path);
        path="ubicación del archivo a eliminar: ".concat(path);
        Log.LOGGER.info(path);
        if(file.exists()) {
            if(file.delete()) {
                Log.LOGGER.info("No se pudo eliminar el archivo");
            }else{
                Log.LOGGER.info("archivo eliminado");
            }
        }else{
            Log.LOGGER.info("no se encontró el archivo");
        }
    }

    public static int randomNumberGeneratorByLength(int length) {
        int maxNum=(int) Math.pow( 10,length)-1;
        new String(new char[3]).replace("\0", "#");
        return randomNumberGenerator(maxNum);
    }
    public static int randomNumberGenerator(int maxNum) {
        Random rand = new SecureRandom();
        return rand.nextInt(maxNum);
    }

    public static void main(String[] args) {
        System.out.println("as");
    }

    public static String generateCurrentDate(String dateFormat) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
