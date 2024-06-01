package ren.lawliet.Java;

/**
 * @author Coaixy
 * @createTime 2024-06-01
 * @packageName ren.lawliet.Java
 */

public class MsgType {
    public String type;
    public String nickname;
    public String content;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Type: " + type + " Nickname: " + nickname + " Content: " + content;
    }
}
