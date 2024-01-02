package soft.kr.maple.util;

public enum StatusEnum {
    OK(200, "OK"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    NOT_FOUND(404, "NOT_FOUND");


    StatusEnum(int statusCode, String codeMessage) {
        this.statusCode = statusCode;
        this.codeMessage = codeMessage;
    }

    int statusCode;
    String codeMessage;



}
