
package Model;

import DBContext.DBConnection;
import Entities.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostModel {
    private DBConnection db;

    public PostModel() {
        db = new DBConnection();
    }
    
    public Post show(int id) throws Exception {
        Post post = null;
        
        String query = "SELECT * FROM posts WHERE id = ?";
        Connection con = db.getConnection();
        
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, id);
        
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            post = parse(rs);
        }
        
        return post;
    }
    
    public ArrayList<Post> listTop(int n) throws Exception {
        ArrayList<Post> items = new ArrayList<Post>();
        
        String query = "SELECT TOP (?) * FROM posts ORDER BY id ASC";
        Connection con = db.getConnection();
        
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, n);
        
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            items.add(parse(rs));
        }
        
        return items;
    }
    
    private Post parse(ResultSet rs) throws SQLException {
        Post item = new Post();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setContent(rs.getString("content"));
        item.setCreated_at(rs.getDate("created_at"));
        item.setImage(rs.getString("image"));
        item.setType(rs.getInt("type"));
        return item;
    }
}
