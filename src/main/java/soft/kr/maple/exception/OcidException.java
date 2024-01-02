package soft.kr.maple.exception;

import java.io.Serializable;

public class OcidException extends RuntimeException implements Serializable {

    public OcidException() {
        super("캐릭터 접속이 필요합니다.");

    }

}
