package cn.ahnu.edu.ahnudb.message;

/**
 * 数据库set请求消息，不可变对象
 * Created by sunyong on 2017/7/17.
 */
public class SetRequest {
    private final String key;
    private final String value;

    public SetRequest(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
