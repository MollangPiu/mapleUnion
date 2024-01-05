package soft.kr.maple.service;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import soft.kr.maple.exception.TestException;
import soft.kr.maple.mapper.OcidDao;
import soft.kr.maple.util.GetHttpClient;
import soft.kr.maple.util.NowTime;

import java.util.HashMap;

@Service
public class CharacterService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    OcidDao ocidDao = new OcidDao();

    /**
     * 캐릭터 등록
     */
    public void insertCharcter(String character_id) throws TestException, Exception {

        JSONObject obj = GetHttpClient.ocidFind(character_id); //OCID 값 가져오기
        if(!String.valueOf(obj.get("status")).equals("200")) {
            logger.error("캐릭터를 찾을 수 없음");
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("ocid", String.valueOf(obj.get("ocid")));
        map.put("date", NowTime.toDayNow());

        /**
         * 백업용
         */
        int maxCnt = ocidDao.maxInt();
        logger.info("maxCnt {}", maxCnt);
        ocidDao.regist(maxCnt, (String) obj.get("ocid"));


        //메이플 정보 불러오기
        JSONObject jsonObject = GetHttpClient.getHttpClient("/maplestory/v1/character/basic", map);
        System.out.println(jsonObject);
    }
}
