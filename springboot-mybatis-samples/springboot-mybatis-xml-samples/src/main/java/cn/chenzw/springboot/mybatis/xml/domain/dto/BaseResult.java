package cn.chenzw.springboot.mybatis.xml.domain.dto;

/**
 * 基础响应对象
 * @param <T>
 */
public class BaseResult<T> {
    private Integer code;
    private String message;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
