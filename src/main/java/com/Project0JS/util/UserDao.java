package com.Project0JS.util;

import com.Project0JS.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements DaoInterface<User, String> {

        private static UserDao instance;

        private UserDao(){}

        public static UserDao getInstance(){
            if(instance == null){
                instance = new UserDao();
            }
            return instance;
        }

    @Override
    public int create(User user) {
            try (ConnectionSession sess = new ConnectionSession()) {
                Connection conn = sess.getActiveConnection();
                PreparedStatement ps = conn.prepareStatement("insert into JS0_users values (?,?,false)");
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassword());
                int i = ps.executeUpdate();
                ps.close();
                return i;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error communicating with the database, closing application to preserve data integrity");
                System.exit(-1);
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

    @Override
        public int save(User u) {
                return -1;
        }

        @Override
        public GenericArrayList<User> getAll() {
            String sql = "select * from JS0_users";
            try (
                    ConnectionSession sess = new ConnectionSession();
                    PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)
            ) {
                ResultSet rs = ps.executeQuery();
                GenericArrayList<User> returnvalue = new GenericArrayList<>();
                while (rs.next()) {
                   returnvalue.add(new User(rs.getString(1),rs.getString(2),rs.getBoolean(3)));
                }
                return returnvalue;
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error communicating with the database, closing application to preserve data integrity");
                System.exit(-1);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return null;
        }

        @Override
        public boolean remove(String id) {
            return false;
        }

        @Override
        public boolean update(User user) {
            return false;
        }
}
