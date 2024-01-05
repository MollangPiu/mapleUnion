package soft.kr.maple.util;

public enum ErrorCode {

    //TESET
    OK(200, "OK", "OK");

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }


    private final String code;
    private final String message;
    private int status;


}
