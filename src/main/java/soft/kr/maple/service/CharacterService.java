package soft.kr.maple.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import soft.kr.maple.exception.TestException;
import soft.kr.maple.util.GetHttpClient;
import soft.kr.maple.util.NowTime;

import java.net.http.HttpClient;
import java.util.HashMap;

@Service
public class CharacterService {

    /**
     * 캐릭터 등록
     */
    public void insertCharcter(String character_id) throws TestException, Exception {

        String ocid = GetHttpClient.ocidFind(character_id); //OCID 값 가져오기

        HashMap<String, String> map = new HashMap<>();
        map.put("ocid", ocid);
        map.put("date", NowTime.yesterdayNow());

        //메이플 정보 불러오기
        JSONObject jsonObject = GetHttpClient.getHttpClient("/maplestory/v1/character/basic", map);
        System.out.println("test");
        System.out.println(jsonObject);
    }
}
