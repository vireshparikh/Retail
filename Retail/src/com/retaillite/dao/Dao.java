package com.retaillite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import com.retaillite.pojo.Cart;
import com.retaillite.pojo.Customer;
import com.retaillite.pojo.Order;
import com.retaillite.pojo.Product;
import com.retaillite.pojo.Queue;
import com.retaillite.pojo.Store;

public class Dao {

	private static BasicDataSource dataSource = null;
	private Connection con = null;
	DbConn db;

	public Dao() {
		DbConn db = new DbConn();
		try {
			dataSource = db.getDataSource();
		} catch (Exception e) {

		}
	}

	public Customer getCustomer(String number) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Customer cust = new Customer();
		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement(
					"select  customer_name, customer_number ,customer_email_id,customer_Oauth , customer_device_id from customer where customer_number=?");

			ps.setString(1, number);
			rs = ps.executeQuery();
			while (rs.next()) {
				cust.setCustomer_name(rs.getString(1));
				cust.setCustomer_number(rs.getString(2));
				cust.setCustomer_email_id(rs.getString(3));
				cust.setCustomer_Oauth(rs.getString(4));
				cust.setCustomer_device_id(rs.getString(5));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return cust;
	}

	public Store getStoreDetails(String number) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Store str = new Store();
		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement(
					"select Store_UID, Stor_Address_Line1, Stor_Address_Line2, Store_Zip, Store_QR_Code  from store where store_uid=?");

			ps.setString(1, number);
			rs = ps.executeQuery();
			while (rs.next()) {
				str.setStore_UID(rs.getInt(1));
				str.setStor_Address_Line1(rs.getString(2));
				str.setStor_Address_Line2(rs.getString(3));
				str.setStore_Zip(rs.getString(4));
				str.setStore_QR_Code(rs.getString(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;
		}
		return str;
	}

	public Product getProductDetails(String upcNum) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Product prd = new Product();
		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement(
					"select product_upc , product_name , product_desc , product_rrp , product_sp , product_disc_code , product_qr_code from product where product_upc=?");

			ps.setString(1, upcNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				prd.setProduct_UPC(rs.getString(1));
				prd.setProduct_Name(rs.getString(2));
				prd.setProduct_Desc(rs.getString(3));
				prd.setProduct_RRP(rs.getDouble(4));
				prd.setProduct_SP(rs.getDouble(5));
				prd.setProduct_Disc_Code(rs.getString(6));
				prd.setProduct_QR_Code(rs.getString(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return prd;
	}

	public boolean saveCart(Cart crt) {
		System.out.println("In Dao " + crt.getCart_Customer_Number());

		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String insquery = "insert into Cart values (cart_id.nextval,?,?,?,?,?)";
			ps = con.prepareStatement(insquery);
			// ps.setString(1, crt.getCart_UID());
			ps.setString(1, crt.getCart_Customer_Number());
			ps.setString(2, crt.getProduct_UPC());
			ps.setInt(3, crt.getCart_Quantity());
			ps.setDouble(4, crt.getCart_Total());
			ps.setString(5, "N");
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return true;
	}

	public boolean updateCart(Cart crt) {
		System.out.println("In Update Cart Dao " + crt.getCart_Customer_Number());

		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String updquery = "update Cart set cart_quantity =? , cart_total =? where cart_Uid =? and cart_customer_number = ? and product_upc = ?";
			ps = con.prepareStatement(updquery);
			ps.setInt(1, crt.getCart_Quantity());
			ps.setDouble(2, crt.getCart_Total());
			ps.setInt(3, crt.getCart_UID());
			ps.setString(4, crt.getCart_Customer_Number());
			ps.setString(5, crt.getProduct_UPC());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return true;

	}

	public boolean deleteCart(Integer crt_id, String telNum, String upc) {
		System.out.println("In Delete Cart Dao " + telNum);

		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String delquery = "delete from Cart  where cart_Uid =? and cart_customer_number = ? and product_upc = ?";
			ps = con.prepareStatement(delquery);
			ps.setInt(1, crt_id);
			ps.setString(2, telNum);
			ps.setString(3, upc);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			;
		}
		return true;

	}

	public List<Cart> getCartDetails(String telNum) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Cart> lst = new ArrayList<Cart>();
		// JSONArray jsonArray = new JSONArray();
		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement(
					"select cart_uid , cart_customer_number , product_desc , cart_quantity , cart_total , cart_order_paid_flag from cart crt join product prd on crt.product_upc = prd.product_upc where cart_customer_number=?");

			ps.setString(1, telNum);
			rs = ps.executeQuery();
			while (rs.next()) {

				Cart crt = new Cart();
				crt.setCart_UID(rs.getInt(1));
				crt.setCart_Customer_Number(rs.getString(2));
				crt.setProduct_UPC(rs.getString(3));
				crt.setCart_Quantity(rs.getInt(4));
				crt.setCart_Total(rs.getDouble(5));
				crt.setCart_Order_Paid_Flag(rs.getString(6));
				lst.add(crt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return lst;
	}

	public Order getOrderDetails(String telNum) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Order ord = null;

		try {
			ord = new Order();
			con = dataSource.getConnection();
			ps = con.prepareStatement(
					"select ORDER_UID,CART_CUSTOMER_NUMBER,ORDER_TOTAL,ORDER_PAYMENT_AMOUNT,ORDER_PAYMENT_METHOD,ORDER_DELIVERY_STATUS_FLAG from orders where CART_CUSTOMER_NUMBER = ?");

			ps.setString(1, telNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				ord.setOrder_UID(rs.getInt(1));
				ord.setCart_Customer_Number(rs.getString(2));
				ord.setOrder_Total(rs.getDouble(3));
				ord.setOrder_Payment_Amount(rs.getDouble(4));
				ord.setOrder_Payment_Method(rs.getString(5));
				ord.setOrder_Delivery_Status_Flag(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return ord;
	}

	public boolean saveOrder(Order ord) {
		System.out.println("In Order" + ord.getCart_Customer_Number());

		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String insquery = "insert into orders values (order_id.nextval, ? , ? , ? , ?, 'N' )";
			ps = con.prepareStatement(insquery);
			// ps.setString(1, crt.getCart_UID());
			ps.setString(1, ord.getCart_Customer_Number());
			ps.setDouble(2, ord.getOrder_Total());
			ps.setDouble(3, ord.getOrder_Payment_Amount());
			ps.setString(4, ord.getOrder_Payment_Method());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return true;
	}

	public boolean updateOrder(Order ord) {
		System.out.println("In Update Cart Dao " + ord.getCart_Customer_Number());

		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String updquery = "update Orders set order_total =? , order_payment_amount =? where order_Uid =? and cart_customer_number = ?";
			ps = con.prepareStatement(updquery);
			ps.setDouble(1, ord.getOrder_Total());
			ps.setDouble(2, ord.getOrder_Payment_Amount());
			ps.setInt(3, ord.getOrder_UID());
			ps.setString(4, ord.getCart_Customer_Number());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return true;
	}

	public boolean deleteOrder(Order ord) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveQueue(Queue que) {
		System.out.println("In Queue" + que.getCq_Customer_Number());

		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String insquery = "insert into checkout_queue values (seq_checkout_queue.nextval, ? , ? , getdate() , null )";
			ps = con.prepareStatement(insquery);
			// ps.setString(1, crt.getCart_UID());
			ps.setString(1, que.getCq_Customer_Number());
			ps.setString(2, "AWAITING");

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return true;
	}

	public boolean updateQueue(Queue que) {
		System.out.println("In Delete Queue Dao " + que.getCq_Customer_Number());

		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String delquery = "update checkout_queue set CQ_STATUS=? , ENDDATE_TIME=getdate()  where cq_Uid =? and CQ_CUSTOMER_NUMBER = ? ";
			ps = con.prepareStatement(delquery);
			ps.setString(1, que.getCq_Status());
			ps.setInt(2, que.getCq_UID());
			ps.setString(3, que.getCq_Customer_Number());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return true;
	}

	public boolean deleteQueue(Queue que) {
		System.out.println("In Delete Cart Dao " + que.getCq_Customer_Number());

		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String delquery = "delete from checkout_queue  where cq_Uid =? and CQ_CUSTOMER_NUMBER = ? ";
			ps = con.prepareStatement(delquery);
			ps.setInt(1, que.getCq_UID());
			ps.setString(2, que.getCq_Customer_Number());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return true;
	}

	public List<Queue> getQueueList() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Queue> lst = new ArrayList<Queue>();

		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement(
					"select CQ_UID ,CQ_CUSTOMER_NUMBER, CQ_STATUS from checkout_queue where cq_status in ('AWAITING','PROCESSING') ORDER BY CQ_UID ");

			rs = ps.executeQuery();
			while (rs.next()) {
				Queue que = new Queue();
				que.setCq_UID(rs.getInt(1));
				que.setCq_Customer_Number(rs.getString(2));
				que.setCq_Status(rs.getString(3));
				lst.add(que);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return lst;
	}

	public boolean updateQueueList(String qc_id, String stat) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Queue> lst = new ArrayList<Queue>();

		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement(
					"update checkout_queue set cq_status=? , ENDDATE_TIME=getdate() where CQ_UID=?;");
			ps.setString(1, stat);
			ps.setString(2, qc_id);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
			;
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			;
		}
		return true;
	}
}
