package Java.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    private static StringBuilder builder = new StringBuilder("");
    private static int i;
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            //StringBuilder builder = new StringBuilder();
            int nSize = Integer.parseInt(reader.readLine().trim());
            for (int j = 0; j < nSize; j++) {
                String number;
                while ((number = reader.readLine()) != null) {
                    String result = getDataTypes(number, DataTypes.BYTE);
                    if (result.isEmpty()) {
                        System.out.println(number + " can't be fitted anywhere.");
                    } else {
                        System.out.println(number + " can be fitted in:");
                        System.out.println(result);
                    }
                    builder = new StringBuilder("");
                    i = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    enum DataTypes {
        BYTE,
        SHORT,
        INT,
        LONG
    }
    private static String getDataTypes(String number, DataTypes type) {
        try {
            switch (type.ordinal()) {
                case 0: {
                    Byte nByte = Byte.parseByte(number);
                    builder.append("* byte").append("\n");
                    i++;
                }
                case 1: {
                    Short nShort = Short.parseShort(number);
                    builder.append("* short").append("\n");
                    i++;
                }
                case 2: {
                    Integer nInteger = Integer.parseInt(number);
                    builder.append("* int").append("\n");
                    i++;
                }
                case 3: {
                    Long nLong = Long.parseLong(number);
                    builder.append("* long");
                    i++;
                }
                default: {
                    break;
                }
            }
        } catch (NumberFormatException e) {
            if (i == 3) return builder.toString();
            getDataTypes(number, DataTypes.values()[++i]);
        }

        return builder.toString();
    }
}
