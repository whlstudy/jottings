package wang.study.netty.POJO;

import org.msgpack.annotation.Message;


/**
 * @author whl
 * @date 2019/10/11 8:12 下午
 */
@Message
public class UserInfo {

    private String userName;

    private int userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
