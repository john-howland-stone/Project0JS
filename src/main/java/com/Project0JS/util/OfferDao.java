package com.Project0JS.util;

import com.Project0JS.model.Offer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferDao implements DaoInterface<Offer, Integer> {

    private static OfferDao instance;

    private OfferDao(){}

    public static OfferDao getInstance(){
        if(instance == null){
            instance = new OfferDao();
        }
        return instance;
    }

    @Override
    public int create(Offer offer) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into JS0_offers values (?,?,?,?)");
            ps.setInt(1, offer.getOfferId());
            ps.setString(2, offer.getUser_id());
            ps.setInt(3, offer.getCar_id());
            ps.setFloat(4, offer.getPrice());
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
    public int save(Offer offer) {
        return 0;
    }

    @Override
    public GenericArrayList<Offer> getAll() {
        String sql = "select * from JS0_offers";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            GenericArrayList<Offer> returnvalue = new GenericArrayList<>();
            while (rs.next()) {
                returnvalue.add(new Offer(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
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
            PreparedStatement ps = conn.prepareStatement("delete from JS0_offers where offerID=?");
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

    public void AcceptOffer (String ownerID,int carID, double price) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("select accept_offer(?,?,?)");
            ps.setString(1, ownerID);
            ps.setInt(2, carID);
            ps.setDouble(3, price);
            ps.execute();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error communicating with the database, closing application to preserve data integrity");
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Offer offer) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("update JS0_offers set offerID=?, userID=?,carID=?, price=? where offerID=?");
            ps.setInt(1, offer.getOfferId());
            ps.setString(2, offer.getUser_id());
            ps.setInt(3, offer.getCar_id());
            ps.setDouble(4, (offer.getPrice()));
            ps.setInt(5, (offer.getOfferId()));
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
    public boolean RemoveOffersOnCar(int carId) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("delete from JS0_offers where carID=?");
            ps.setInt(1, carId);
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
