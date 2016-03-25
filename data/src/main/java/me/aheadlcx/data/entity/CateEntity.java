package me.aheadlcx.data.entity;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:41
 */
public class CateEntity {
    private String pic;
    private String content;

    public CateEntity() {
    }

    public String getPic() {
        return pic;
    }

    public String getContent() {
        return content;
    }

    public CateEntity setPic(String pic) {
        this.pic = pic;
        return this;
    }

    public CateEntity setContent(String content) {
        this.content = content;
        return this;
    }
}
