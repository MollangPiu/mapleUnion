package soft.kr.maple.util;


import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soft.kr.maple.exception.TestException;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

public class GetHttpClient {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    static final String NEXON_API = "http://open.api.nexon.com";

    void test() {

        String encodeResult = URLEncoder.encode("test");

        String url = "http://open.api.nexon.com";
        String api = "/maplestory/v1/id";
        String api_key = "test_4fd27ccf423b1c10d4ef4c44e5acbbdf5740bfbd1edf943d2869d8c78d68553425aa51a9e4e5ee5a693836b476ee8d3e";

        String param = "?character_name="+encodeResult;
        try {

            //Http Clienrt 생성
            CloseableHttpClient httpClient = HttpClients.createDefault();

            //get URL 설정
            HttpGet httpGet = new HttpGet(url+api+param);

            //header 값 전송
            httpGet.addHeader("x-nxopen-api-key", api_key);
            httpGet.addHeader("Content-type", "application/json");

            //get 요청
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            String json = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 캐릭터 이름을 ocid로 변환
     * @param characterName 캐릭터 이름
     * @return String Maple에서 사용 된 ocid 값
     */
    public static JSONObject ocidFind(String characterName) {

        String result = "error";
        JSONObject obj = new JSONObject();

        try {
            //캐릭터 이름 인코딩
            String encodeCharacterName = URLEncoder.encode(characterName);

            //Http Clienrt 생성
            CloseableHttpClient httpClient = HttpClients.createDefault();

            //get URL 설정
            //캐릭터이름 조회
            HttpGet httpGet = new HttpGet(NEXON_API + "/maplestory/v1/id" + "?character_name=" + encodeCharacterName);

            String apiKey = ReadFile.readApi();
            if (apiKey.equals("error")) {
                throw new IOException("API KEY ERROR");
            }

            //header 값 전송
            httpGet.addHeader("x-nxopen-api-key", apiKey);
            httpGet.addHeader("Content-type", "application/json");

            //get 요청
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            HttpEntity responseEntity = httpResponse.getEntity();

            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(EntityUtils.toString(httpResponse.getEntity(), "UTF-8"));
            obj.put("status", 200);

            System.out.println(obj.get("ocid"));
            System.out.println(obj.get("status"));

        }
        catch (IOException e) {
            obj.put("status", 502);
            System.out.println("API_ERROR");
        }
        catch (ParseException e) {
            obj.put("status", 502);
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            obj.put("status", 500);
            e.printStackTrace();
        }

        return obj;
    }

    public static void main(String[] args) {

        GetHttpClient getHttpClient = new GetHttpClient();

        HashMap<String, String> param = new HashMap<>();
        param.put("ocid", "dc94e1d53b97df9aebc1b2eb5899e9aaefe8d04e6d233bd35cf2fabdeb93fb0d");
        param.put("date", "2024-01-01");

    }


    public static JSONObject getHttpClient(String apiUrl, HashMap<String, String> paramMap) throws TestException, Exception {

        String result = "error";
        JSONObject obj = new JSONObject();

        String param = paramMap.toString().substring(1, paramMap.toString().length() - 1);
        param = param.replace(", ", "&");

        String url = "http://open.api.nexon.com";
        //apiUrl = "/maplestory/v1/id";

        //Http Clienrt 생성
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //get URL 설정
        HttpGet httpGet = new HttpGet(NEXON_API + apiUrl + "?" + param);

        String apiKey = ReadFile.readApi();
        if (apiKey.equals("error")) {
            throw new IOException("API KEY ERROR");
        }

        //header 값 전송
        httpGet.addHeader("x-nxopen-api-key", apiKey);
        httpGet.addHeader("Content-type", "application/json");

        //get 요청
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(result);
        obj.put("status", 200);

        httpClient.close();
        httpResponse.close();

        return obj;
    }
}
