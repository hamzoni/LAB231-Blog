
package Model;

import DBContext.DBConnection;
import Entities.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostModel {
    private DBConnection db;

    public PostModel() {
        db = new DBConnection();
    }
    
    public HashMap<Integer, HashMap<Integer, ArrayList<Post>>> listAll() throws Exception {
        HashMap<Integer, HashMap<Integer, ArrayList<Post>>> results = new HashMap<Integer, HashMap<Integer, ArrayList<Post>>>();
        
        String query = "SELECT *, year(created_at) as y, month(created_at) as m FROM posts ORDER BY created_at ASC";
        Connection con = db.getConnection();
        
        PreparedStatement pstm = con.prepareStatement(query);
        
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            int y = rs.getInt("y");
            int m = rs.getInt("m");
            
            if (!results.containsKey(y)) results.put(y, new HashMap<Integer, ArrayList<Post>>());
            if (!results.get(y).containsKey(m)) results.get(y).put(m, new ArrayList<Post>());
            results.get(y).get(m).add(parse(rs));
        }
        
        return results;
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
