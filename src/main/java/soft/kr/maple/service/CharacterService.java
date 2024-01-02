package soft.kr.maple.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import soft.kr.maple.util.GetHttpClient;
import soft.kr.maple.util.NowTime;

import java.net.http.HttpClient;
import java.util.HashMap;

@Service
public class CharacterService {

    /**
     * 캐릭터 등록
     */
    public void insertCharcter(String character_id) {

        String ocid = GetHttpClient.ocidFind(character_id); //OCID 값 가져오기

        HashMap<String, String> map = new HashMap<>();
        map.put("ocid", ocid);
        map.put("date", NowTime.yesterdayNow());

        GetHttpClient.getHttpClient("/maplestory/v1/character/basic", map);
    }
}
