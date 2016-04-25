/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteendb.db.mngmt;

import canteendb.db.DatabaseConnection;
import canteendb.db.beans.AvailableItemsBeans;
import canteendb.db.beans.LoginDetailsBean;
import canteendb.db.beans.StaffDetailsBean;
import canteendb.db.beans.StockDetailsBean;
import canteendb.db.beans.PurchasedItemBean;
import canteendb.db.beans.fooditemlist;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author project
 */
public class UserManagement {

    DatabaseConnection connection = null;

    public UserManagement() {
        connection = new DatabaseConnection();
    }

    public void registerUser(LoginDetailsBean loginDetailsBean, StaffDetailsBean staffDetailsBean) throws ClassNotFoundException, SQLException {
        String qry = "INSERT INTO login_details VALUES('" + loginDetailsBean.getUsername()
                + "','" + loginDetailsBean.getPassword() + "','" + loginDetailsBean.getType()
                + "')";
        connection.getConnection().createStatement().executeUpdate(qry);
        qry = "INSERT INTO Staff_Details VALUES('" + staffDetailsBean.getUsername() + "','"
                + staffDetailsBean.getName() + "','"
                + staffDetailsBean.getAge() + "','"
                + staffDetailsBean.getGender() + "','"
                + staffDetailsBean.getAddress() + "','"
                + staffDetailsBean.getBloodgroup() + "','"
                + staffDetailsBean.getPhno() + "','"
                + staffDetailsBean.getMailid() + "')";
        connection.getConnection().createStatement().executeUpdate(qry);
    }

    
    
    
    
    public ArrayList<StaffDetailsBean> getAllUsers() throws ClassNotFoundException, SQLException {
        String qry = "SELECT user_name , Phone_number FROM Staff_Details";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        ArrayList<StaffDetailsBean> StaffDetailsBean = new ArrayList<StaffDetailsBean>();
        while (rs.next()) {
            StaffDetailsBean detailsBean = new StaffDetailsBean();
            detailsBean.setName(rs.getString("user_name"));
            detailsBean.setPhno(rs.getString("Phone_number"));
            StaffDetailsBean.add(detailsBean);
        }
        return StaffDetailsBean;
    }

   public String login(LoginDetailsBean detailsBean) throws ClassNotFoundException, SQLException {
        String qry = "SELECT type FROM login_details WHERE user_name='" + detailsBean.getUsername() + "' "
                + " AND password = '" + detailsBean.getPassword() + "'";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        if (rs.next()) {
            return rs.getString("type");
        } else {
            return null;
        }
    }
   
   
   
      public String duplicate(LoginDetailsBean detailsBean) throws ClassNotFoundException, SQLException {
        String qry = "SELECT user_name FROM login_details WHERE user_name='" + detailsBean.getUsername() + "' ";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        if (rs.next()) {
            return rs.getString("userName");
        } else {
            return null;
        }
    }
   
   public void deleteUser(String name) throws ClassNotFoundException, SQLException {
        String qry = "DELETE FROM Staff_Details WHERE name='" + name + "'";
        connection.getConnection().createStatement().executeUpdate(qry);
    }

    public StaffDetailsBean getStaffDetail(String name) throws ClassNotFoundException, SQLException {
        String qry = "SELECT * FROM Staff_Details WHERE name='"+name+"'";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        StaffDetailsBean StaffDetailsBean = new StaffDetailsBean();
        if(rs.next()){
            StaffDetailsBean.setUsername(rs.getString("username"));
            StaffDetailsBean.setName(rs.getString("name"));
            StaffDetailsBean.setPhno(rs.getString("phno"));
            StaffDetailsBean.setAddress(rs.getString("address"));
        }
        return StaffDetailsBean;
    }
    
     public void updateUser(StaffDetailsBean StaffDetailsBean) throws ClassNotFoundException, SQLException {
        String qry = "UPDATE Staff_Details SET user_name=?, Phone_number=?, address=? WHERE name=?";
        PreparedStatement ps = connection.getConnection().prepareStatement(qry);
        ps.setString(1, StaffDetailsBean.getName());
        ps.setString(2, StaffDetailsBean.getPhno());
        ps.setString(3, StaffDetailsBean.getAddress());
        ps.setString(4, StaffDetailsBean.getName());
        ps.executeUpdate();
    }

    public boolean isexist(String uname) throws ClassNotFoundException, SQLException {
        String qry = "SELECT user_name FROM Staff_Details WHERE user_name = '" + uname + "'";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public ArrayList<AvailableItemsBeans> getAvailableItems() throws ClassNotFoundException, SQLException {
        String qry = "SELECT id , NAME , RATE FROM Available_Items";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        ArrayList<AvailableItemsBeans> AvailableItemsBeans = new ArrayList<AvailableItemsBeans>();
        while (rs.next()) {
            AvailableItemsBeans detailsBean = new AvailableItemsBeans();
            detailsBean.setId(rs.getString("id"));
            detailsBean.setName(rs.getString("NAME"));
            detailsBean.setRate(rs.getString("RATE"));
            AvailableItemsBeans.add(detailsBean);
        }
        return AvailableItemsBeans;
    }

        public ArrayList<AvailableItemsBeans> getBillDetails() throws ClassNotFoundException, SQLException {
        String qry = "SELECT NAME , RATE FROM Available_Items";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        ArrayList<AvailableItemsBeans> AvailableItemsBeans = new ArrayList<AvailableItemsBeans>();
        while (rs.next()) {
            AvailableItemsBeans detailsBean = new AvailableItemsBeans();
            detailsBean.setId(rs.getString("id"));
            detailsBean.setName(rs.getString("NAME"));
            detailsBean.setRate(rs.getString("RATE"));
            AvailableItemsBeans.add(detailsBean);
        }
        return AvailableItemsBeans;
    }
    
      /*  public ArrayList<fooditemlist> getbill() throws ClassNotFoundException, SQLException {
        String qry = "SELECT Name,Rate,Qty,Total FROM Bill";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        ArrayList<fooditemlist> fooditemlist = new ArrayList<fooditemlist>();
        while (rs.next()) {
            fooditemlist fooditemlist = new fooditemlist();
            fooditemlist.setName(rs.getString("Name"));
            fooditemlist.setRate(rs.getString("Rate"));
            fooditemlist.setQty(rs.getString("Qty"));
            fooditemlist.setTotal(rs.getString("Total"));
            fooditemlist.add(fooditemlist);
        }
        return fooditemlist;
    }*/

   
    
    public ArrayList<StockDetailsBean> getStock() throws ClassNotFoundException, SQLException {
        String qry = "SELECT MATERIAL FROM stock ";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        ArrayList<StockDetailsBean> StockDetailsBean = new ArrayList<StockDetailsBean>();
        while (rs.next()) {
            StockDetailsBean detailsBean = new StockDetailsBean();
            detailsBean.setMaterial(rs.getString("MATERIAL"));
            StockDetailsBean.add(detailsBean);
        }
        return StockDetailsBean;
    }




   public ArrayList<PurchasedItemBean> getPurchase() throws ClassNotFoundException, SQLException {
        String qry = "SELECT Material,Quantity,Prize FROM Purchased_Items ";
        ResultSet rs = connection.getConnection().createStatement().executeQuery(qry);
        ArrayList<PurchasedItemBean> PurchasedItemBean = new ArrayList<PurchasedItemBean>();
        while (rs.next()) {
            PurchasedItemBean ItemBean = new PurchasedItemBean();
            ItemBean.setMat(rs.getString("MATERIAL"));
            PurchasedItemBean.add(ItemBean);
        }
        return PurchasedItemBean;
    }
   
   }