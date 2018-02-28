
package Entities;

import Utility.Tool;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class Post {
    private int id;
    private String name;
    private String content;
    private Date created_at;
    private String image;
    private int type;
    
    public static final int TEXT = 0;
    public static final int POEM = 1;
    public static final int ALBUM = 2;

    public Post() {
    }
    
    public String getImage(HttpServletRequest request) {
        if (image.contains("http")) return image;
        return Tool.getImageDir(request) + image;
    }
    
    public String getDisplayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(created_at);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
