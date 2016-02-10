/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Business.Order;
import Interfaces.UserDaoInterface;
import Business.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class UserDao extends Dao implements UserDaoInterface {

    @Override
    public ArrayList<User> FindAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<User> users = new ArrayList();

        try {
            con = getConnection();

            String query = "SELECT * FROM user";

            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("userid"));
                u.setfName(rs.getString("fName"));
                u.setlName(rs.getString("lName"));
                u.setAddress(rs.getString("address"));
                u.setCounty(rs.getString("county"));
                u.setCountry(rs.getString("country"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setPasswordHashed(rs.getString("pass"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));

                users.add(u);

            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return users;     // users may be null 
    }

    @Override
    public User getUserById(int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        ArrayList<User> users = new ArrayList();

        try {
            con = this.getConnection();
            String query = "SELECT * FROM user WHERE userID = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();

                u.setUserId(rs.getInt("userID"));
                u.setfName(rs.getString("fName"));
                u.setlName(rs.getString("lName"));
                u.setAddress(rs.getString("address"));
                u.setCounty(rs.getString("county"));
                u.setCountry(rs.getString("country"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setPasswordHashed(rs.getString("pass"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));

                return u;
            }
        } catch (SQLException e) {
            u = null;
        } catch (NullPointerException ex) {
            u = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the findUserById method:\n" + e.getMessage());
            }
        }
        return u;     // users may be null 
    }

    // this method returns a list of users depending on the first name or the last name
    @Override
    public ArrayList<User> getUserByName(String fName, String lName) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        ArrayList<User> users = new ArrayList();
        if (fName.length() < 1 || lName.length() < 1) {
            return null;
        }
        try {
            con = this.getConnection();

            String query = "SELECT * FROM user WHERE fName like ? or lName like ?";

            ps = con.prepareStatement(query);

            ps.setString(1, "%" + fName + "%");
            ps.setString(2, "%" + lName + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                u = new User();

                u.setUserId(rs.getInt("userID"));
                u.setfName(rs.getString("fName"));
                u.setlName(rs.getString("lName"));
                u.setAddress(rs.getString("address"));
                u.setCounty(rs.getString("county"));
                u.setCountry(rs.getString("country"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setPasswordHashed(rs.getString("pass"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));

                users.add(u);
            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return users;
    }

    @Override
    public User login(String email, char[] userPassword) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            con = this.getConnection();

            if (userPassword == null) {
                return null;
            }

            String pass = new User().getHash(userPassword);

            String query = "SELECT * FROM user WHERE email = ? and pass = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, pass);

            rs = ps.executeQuery();

            if (rs.next()) {
                u = new User();

                u.setUserId(rs.getInt("userID"));
                u.setfName(rs.getString("fName"));
                u.setlName(rs.getString("lName"));
                u.setAddress(rs.getString("address"));
                u.setCounty(rs.getString("county"));
                u.setCountry(rs.getString("country"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setPasswordHashed(rs.getString("pass"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));

                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return u;     // u may be null 
    }

    @Override
    public boolean registerNewUser(User nUser) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (nUser == null) {
            return false;
        }

        try {
            con = this.getConnection();

            String query = "INSERT INTO User VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);

            if (nUser.getUserId() < 0) {
                ps.setString(1, "NULL");
            } else {
                ps.setInt(1, nUser.getUserId());
            }

            ps.setString(2, nUser.getfName());
            ps.setString(3, nUser.getlName());
            ps.setString(4, nUser.getAddress());
            ps.setString(5, nUser.getCounty());
            ps.setString(6, nUser.getCountry());
            ps.setString(7, nUser.getEmail());
            ps.setString(8, nUser.getPhone());
            ps.setString(9, nUser.getPassword());

            if (nUser.getIsIsAdmin()) {
                ps.setInt(10, 1);
            } else {
                ps.setInt(10, 0);
            }

            ps.execute();

            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                return false;
            }
        }
    }

    @Override
    public boolean deleteUser(int userID) {
        Connection con = null;
        PreparedStatement ps = null;

        if (userID < 0) {
            return false;
        }

        try {
            con = getConnection();

            String query = "DELETE FROM user WHERE userID = ?";

            ps = con.prepareStatement(query);

            ps.setInt(1, userID);

            ps.execute();

            return true;
        } catch (SQLException e) {
            
            ArrayList<Order> lst = new OrderDao().getAllOrders();
            boolean deleted = false;
            for (Order item : lst) {
                if (item.getUserId() == userID) {
                    deleted = new OrderProductDao().deleteOrderProductById(item.getOrderId());
                    if (deleted) {
                        deleted = new OrderDao().deleteOrderById(item.getOrderId());
                    }
                }
            }
            if (deleted) {
                
                return deleteUser(userID);
            }

            return false;
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                return false;
            }
        }
    }

    @Override
    public boolean editUserDetails(User nUser) {
        Connection con = null;
        PreparedStatement ps = null;

        if (nUser == null) {
            return false;
        }

        try {
            con = getConnection();

            String query = "UPDATE User SET fName = ?, lName = ?, address = ?, county = ?, country = ?, email = ?, phone = ?, pass = ?, isAdmin = ? WHERE userID = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, nUser.getfName());
            ps.setString(2, nUser.getlName());
            ps.setString(3, nUser.getAddress());
            ps.setString(4, nUser.getCounty());
            ps.setString(5, nUser.getCountry());
            ps.setString(6, nUser.getEmail());
            ps.setString(7, nUser.getPhone());
            ps.setString(8, nUser.getPassword());
            ps.setBoolean(9, nUser.getIsIsAdmin());
            ps.setInt(10, nUser.getUserId());

            ps.execute();
            int i = ps.executeUpdate();

            if (i != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

}
