package me.aheadlcx.domain;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午4:30
 */
public class Cate {

    private String pic;
    private String content;

    public Cate() {
    }

    public String getPic() {
        return pic;
    }

    public String getContent() {
        return content;
    }

    public Cate setPic(String pic) {
        this.pic = pic;
        return this;
    }

    public Cate setContent(String content) {
        this.content = content;
        return this;
    }
}
