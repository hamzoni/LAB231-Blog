
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
    
    public int countAll() throws Exception {
        String query = "SELECT COUNT(*) AS c FROM posts";
        Connection con = db.getConnection();
        
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        
        int count = 0;
        while (rs.next()) count = rs.getInt("c");
        
        if (rs != null) rs.close();
        if (pstm != null) pstm.close();
        if (con != null) con.close();
        
        return count;
    }
    
    public ArrayList<Post> listAll(int page, int total) throws Exception {
        ArrayList<Post> results = new ArrayList<Post>();
        
        String query = "SELECT * FROM posts ORDER BY created_at DESC";
        query += " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        Connection con = db.getConnection();
        
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, page * total);
        pstm.setInt(2, total);
        
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            results.add(parse(rs));
        }
        
        if (rs != null) rs.close();
        if (pstm != null) pstm.close();
        if (con != null) con.close();
        
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
        
        if (rs != null) rs.close();
        if (pstm != null) pstm.close();
        if (con != null) con.close();
        
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
        
        if (rs != null) rs.close();
        if (pstm != null) pstm.close();
        if (con != null) con.close();

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
