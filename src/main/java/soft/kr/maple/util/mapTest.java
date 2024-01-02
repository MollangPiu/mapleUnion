package soft.kr.maple.util;

import java.util.HashMap;

public class mapTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("test", "apple");
        map.put("banana", "fluat");

        String str = (String) map.toString().substring(1, map.toString().length()-1);
        str = str.replace(", ","&");

    }
}
