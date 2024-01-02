package soft.kr.maple.util;

public class ResponseMessage {

    private StatusEnum status;
    private int statusCode;
    private String message;
    private Object data;

    public ResponseMessage() {
        this.status = StatusEnum.OK;
        this.data = null;
        this.message = "성공";
    }

    public int getStatusCode() {
        return status.statusCode;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
