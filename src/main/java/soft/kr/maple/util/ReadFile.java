package soft.kr.maple.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\MHS\\Desktop\\mapleUnion\\maple_api_key.txt"));
        String str;
        if((str = reader.readLine()) != null && str.startsWith("test") && str.length() > 100) {
            System.out.println(str);
        }


        reader.close();
    }

    /**
     * maple_api_key 호출하기
     * @return 메모장의 maple_api_key 호출
     * @throws IOException
     */
    public static String readApi() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\MHS\\Desktop\\mapleUnion\\maple_api_key.txt"));
        String str;

        if((str = reader.readLine()) != null && str.startsWith("test") && str.length() > 100) {

            return str;
        }


        reader.close();

        return "error";
    }
}
