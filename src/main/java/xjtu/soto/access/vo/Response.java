package xjtu.soto.access.vo;

import lombok.Getter;
import lombok.Setter;

public class Response {
    @Setter
    private boolean success;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private Object body;


    /**
     * 响应处理是否成功
     * @return
     */
    public boolean isSuccess() {
        return success;
    }

    public Response() {
    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }
}
