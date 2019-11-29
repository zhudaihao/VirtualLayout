package cn.zdh.virtuallayout.bean;

public class GridBean {
    private int  image;
    private String content;

    public GridBean(int image, String content) {
        this.image = image;
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
