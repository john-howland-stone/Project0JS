package com.Project0JS.util;

import com.Project0JS.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDao implements DaoInterface<Car, Integer> {

    private static CarDao instance;

    private CarDao(){}

    public static CarDao getInstance(){
        if(instance == null){
            instance = new CarDao();
        }
        return instance;
    }

    @Override
    public int create(Car car) {

        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into JS0_cars values (?,?,-1.0,3,'__LOT')");
            ps.setInt(1, car.getCarID());
            ps.setString(2, car.getMake());
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
    public int save(Car car) {
        return 0;
    }

    @Override
    public GenericArrayList<Car> getAll() {
        String sql = "select * from JS0_cars";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            GenericArrayList<Car> returnvalue = new GenericArrayList<>();
            while (rs.next()) {
                returnvalue.add(new Car(rs.getInt(1), rs.getString(2),
                        rs.getFloat(3),rs.getInt(4),rs.getString(5)));
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
    public boolean remove(Integer id) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("delete from JS0_cars where carID=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            ps.close();
            return i > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error communicating with the database, closing application to preserve data integrity");
            System.exit(-1);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Car car) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("update JS0_cars set carID=?, make=?,price=?,numpaymentsremaining=?,ownerID=? where carID=?");
            ps.setInt(1, car.getCarID());
            ps.setString(2, car.getMake());
            ps.setDouble(3, (car.getPrice()));
            ps.setInt(4, car.getNumPaymentsRemaining());
            ps.setString(5, car.getOwnerID());
            ps.setInt(6, (car.getCarID()));
            int i = ps.executeUpdate();
            ps.close();
            return i > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error communicating with the database, closing application to preserve data integrity");
            System.exit(-1);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
