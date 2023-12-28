package helper;

import helper.QueryBuilder.Mode;
import helper.objects.AppsProfile;
import helper.objects.UserSettings;
import helper.objects.WebToAPK;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author staff
 */
public class DBTransactions {

    private String filename;
    ArrayList<String> dataList = null;
    QueryBuilder qb = new QueryBuilder();

    private boolean delete_specific(String table_name, int id) {
        qb.addConditional(new Conditional("id", id));
        String sql = qb.generate(Mode.DELETE, table_name, null);
        boolean succeed = false;

        System.out.println(sql);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            //pstmt.setInt(1, id);
            // execute the delete statement
            int rowKena = pstmt.executeUpdate();

            if (rowKena != 0) {
                succeed = true;
            }

            qb.clearAllConditions();
            this.disconnect();

        } catch (Exception e) {
            System.out.println("Error at delete_specific() " + e.getMessage());
        }

        return succeed;
    }

    private boolean delete_specific(String table_name, Conditional c) {
        qb.addConditional(c);
        String sql = qb.generate(Mode.DELETE, table_name, null);
        boolean succeed = false;

        System.out.println(sql);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            //pstmt.setInt(1, id);
            // execute the delete statement
            int rowKena = pstmt.executeUpdate();

            if (rowKena != 0) {
                succeed = true;
            }

            qb.clearAllConditions();
            this.disconnect();

        } catch (Exception e) {
            System.out.println("Error at delete_specific() " + e.getMessage());
        }

        return succeed;
    }

    private boolean delete_all(String table_name) {

        String sql = qb.generate(Mode.DELETE, table_name, null);
        boolean succeed = false;

        System.out.println(sql);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            //pstmt.setInt(1, id);
            // execute the delete statement
            int rowKena = pstmt.executeUpdate();

            if (rowKena != 0) {
                succeed = true;
            }

            qb.clearAllConditions();
            this.disconnect();

        } catch (Exception e) {
            System.out.println("Error at delete_all() " + e.getMessage());
        }

        return succeed;
    }

    public ArrayList<WebToAPK> select_all_WebToAPK() {
        // String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_ALL, DBTableDefinition.TABLE_WEB_TO_APK, null);
        ArrayList<WebToAPK> result = new ArrayList<WebToAPK>();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {
                WebToAPK item = new WebToAPK();
                item.setId(rs.getInt("id"));
                item.setAppname(rs.getString("app_name"));
                item.setQueue_id(rs.getString("queue_id"));
                item.setUrl(rs.getString("url"));
                item.setStatus(rs.getString("status"));
                item.setSubmitted_date(rs.getString("submitted_date"));
                item.setCompleted_date(rs.getString("completed_date"));
                item.setDownload_link(rs.getString("download_link"));

                result.add(item);
            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_all_WebToAPK() " + e.getMessage());
        }

        return result;
    }

    public ArrayList<AppsProfile> select_all_AppProfile() {
        // String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_ALL, DBTableDefinition.TABLE_APPS_PROFILE, null);
        ArrayList<AppsProfile> result = new ArrayList<AppsProfile>();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {
                AppsProfile item = new AppsProfile();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setVersion(rs.getString("version"));
                item.setPlatform_Type(rs.getString("platform_type"));
                item.setDescription(rs.getString("description"));

                result.add(item);
            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_all_AppProfile() " + e.getMessage());
        }

        return result;
    }

    public AppsProfile select_specific_AppProfile(int id) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        qb.addConditional(new Conditional("id", id));
        String sql = qb.generate(Mode.SELECT_SPECIFIC, DBTableDefinition.TABLE_APPS_PROFILE, null);
        AppsProfile item = new AppsProfile();

        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {

                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPlatform_Type(rs.getString("platform_type"));
                item.setVersion(rs.getString("version"));
                item.setDescription(rs.getString("description"));

            }

            qb.clearAllConditions();
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_specific_AppProfile() " + e.getMessage());
        }

        return item;
    }

    public UserSettings select_specific_UserSettings(int id) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        qb.addConditional(new Conditional("id", id));
        String sql = qb.generate(Mode.SELECT_SPECIFIC, DBTableDefinition.TABLE_USER_SETTINGS, null);
        UserSettings item = new UserSettings();

        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {

                item.setId(rs.getInt("id"));
                item.setCheck_updates(rs.getString("check_updates"));
                item.setUsername(rs.getString("username"));
                item.setPass(rs.getString("pass"));
                item.setEmail(rs.getString("email"));
                item.setContact(rs.getString("contact"));
                item.setRemember_me(rs.getInt("remember_me"));

            }

            qb.clearAllConditions();
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_specific_UserSettings() " + e.getMessage());
        }

        return item;
    }
    
    public WebToAPK select_specific_WebToAPK(int id) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        qb.addConditional(new Conditional("id", id));
        String sql = qb.generate(Mode.SELECT_SPECIFIC, DBTableDefinition.TABLE_WEB_TO_APK, null);
        WebToAPK item = new WebToAPK();

        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {

                item.setId(rs.getInt("id"));
                item.setAppname(rs.getString("app_name"));
                item.setQueue_id(rs.getString("queue_id"));
                item.setUrl(rs.getString("url"));
                item.setStatus(rs.getString("status"));
                item.setSubmitted_date(rs.getString("submitted_date"));
                item.setCompleted_date(rs.getString("completed_date"));
                item.setDownload_link(rs.getString("download_link"));

            }

            qb.clearAllConditions();
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_specific_WebToAPK() " + e.getMessage());
        }

        return item;
    }

    public boolean update_WebToAPK(WebToAPK data) {
        qb.addConditional(new Conditional("id", data.getId()));
        qb.setSkippedColumn("id");

        String sql = qb.generate(Mode.UPDATE, DBTableDefinition.TABLE_WEB_TO_APK, AppsProfile.class);

        boolean sukses = false;

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, data.getAppname());
            pstmt.setString(2, data.getUrl());
            pstmt.setString(3, data.getSubmitted_date());
            pstmt.setString(4, data.getQueue_id());
            pstmt.setString(5, data.getStatus());
            pstmt.setString(6, data.getCompleted_date());
            pstmt.setString(7, data.getDownload_link());

            // update 
            int baris = pstmt.executeUpdate();
            if (baris != 0) {
                sukses = true;
            }

            qb.clearAllConditions();
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at update_WebToAPK() " + e.getMessage());
        }

        return sukses;
    }
    
    public boolean update_UserSettings(UserSettings data) {
        qb.addConditional(new Conditional("id", data.getId()));
        qb.setSkippedColumn("id");

        String sql = qb.generate(Mode.UPDATE, DBTableDefinition.TABLE_USER_SETTINGS, UserSettings.class);

        boolean sukses = false;

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, data.getUsername());
            pstmt.setString(2, data.getPass());
            pstmt.setString(3, data.getContact());
            pstmt.setString(4, data.getEmail());
            pstmt.setString(5, data.getCheck_updates());
            pstmt.setInt(6, data.getRemember_me());

            // update 
            int baris = pstmt.executeUpdate();
            if (baris != 0) {
                sukses = true;
            }

            qb.clearAllConditions();
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at update_UserSettings() " + e.getMessage());
        }

        return sukses;
    }

    public boolean update_AppProfile(AppsProfile data) {
        qb.addConditional(new Conditional("id", data.getId()));
        qb.setSkippedColumn("id");

        String sql = qb.generate(Mode.UPDATE, DBTableDefinition.TABLE_APPS_PROFILE, AppsProfile.class);

        boolean sukses = false;

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, data.getName());
            pstmt.setString(2, data.getVersion());
            pstmt.setString(3, data.getPlatform_Type());
            pstmt.setString(4, data.getDescription());

            // update 
            int baris = pstmt.executeUpdate();
            if (baris != 0) {
                sukses = true;
            }

            qb.clearAllConditions();
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at update_AppProfile() " + e.getMessage());
        }

        return sukses;
    }

    public void insert_WebToAPK(WebToAPK data) {

        // String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, DBTableDefinition.TABLE_WEB_TO_APK, WebToAPK.class);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, data.getId());
            pstmt.setString(2, data.getAppname());
            pstmt.setString(3, data.getUrl());
            pstmt.setString(4, data.getSubmitted_date());
            pstmt.setString(5, data.getQueue_id());
            pstmt.setString(6, data.getStatus());
            pstmt.setString(7, data.getCompleted_date());
            pstmt.setString(8, data.getDownload_link());

            pstmt.executeUpdate();

            this.disconnect();
        } catch (SQLException e) {
            System.out.println("Error at insert_WebToAPK() " + e.getMessage());
        }
    }
    
     public void insert_AppProfile(AppsProfile data) {

        // String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, DBTableDefinition.TABLE_APPS_PROFILE, AppsProfile.class);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, data.getId());
            pstmt.setString(2, data.getName());
            pstmt.setString(3, data.getVersion());
            pstmt.setString(4, data.getPlatform_Type());
            pstmt.setString(5, data.getDescription());

            pstmt.executeUpdate();

            this.disconnect();
        } catch (SQLException e) {
            System.out.println("Error at add_data_AppProfile() " + e.getMessage());
        }
    }

    public boolean delete_specific_WebToAPK(int id) {
        return this.delete_specific(DBTableDefinition.TABLE_WEB_TO_APK, id);
    }
    
     public boolean delete_specific_AppProfile(int id) {
        return this.delete_specific(DBTableDefinition.TABLE_APPS_PROFILE, id);
    }

    public DBTransactions(String fname) {
        filename = fname;
    }

    private String getFileDBPath() {
        return filename;
    }

    Connection conn = null;

    public void connect() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:" + getFileDBPath();
            // create a connection to the database  
            conn = DriverManager.getConnection(url);

            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error at disconnect() " + ex.getMessage());
        }
    }

}
