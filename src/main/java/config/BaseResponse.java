package config;

public class BaseResponse<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T result;

    public BaseResponse(BaseResponseMessage baseResponseMessage) {
        this.success = baseResponseMessage.getSuccess();
        this.code = baseResponseMessage.getCode();
        this.message = baseResponseMessage.getMessage();
    }
    public BaseResponse(BaseResponseMessage baseResponseMessage, T result) {
        this.success = baseResponseMessage.getSuccess();
        this.code = baseResponseMessage.getCode();
        this.message = baseResponseMessage.getMessage();
        this.result = result;

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
