package trg.talentsprint.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BeautyDao {
	public  int save(BeautyProdutcs bp) {
		int status = 0;
		PreparedStatement ps = null;
		try {
			Connection con = DaoUtility.getConnection();
			ps = con.prepareStatement("insert into beauty(name,description,price) values (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, bp.getName());
			ps.setString(2, bp.getDescription());
			ps.setInt(3, bp.getPrice());
			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public  int update(BeautyProdutcs bp) {
		int status = 0;
		try {
			Connection con = DaoUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update beauty set name=?,description=?,price=? where id=?");
			ps.setString(1, bp.getName());
			ps.setString(2, bp.getDescription());
			ps.setInt(3, bp.getPrice());
			ps.setInt(4, bp.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public  int save1(BeautyProdutcs bp) {
		int status = 0;
		PreparedStatement ps = null;
		try {
			Connection con = DaoUtility.getConnection();
			ps = con.prepareStatement("insert into beauty(name,description,price) values (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, bp.getName());
			ps.setString(2, bp.getDescription());
			ps.setInt(3, bp.getPrice());
			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public  int delete(int id) {
		int status = 0;
		try {
			Connection con = DaoUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from beauty where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public  BeautyProdutcs getBeautyProductsId(int id) {
		BeautyProdutcs bp = new BeautyProdutcs();
		try {
			Connection con = DaoUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from beauty where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bp.setId(rs.getInt(1));
				bp.setName(rs.getString(2));
				bp.setDescription(rs.getString(3));
				bp.setPrice(rs.getInt(4));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bp;
	}

	public  List<BeautyProdutcs> getBeautyProductsList() throws ClassNotFoundException, SQLException {
		List<BeautyProdutcs> list = new ArrayList<BeautyProdutcs>();
		Connection con = DaoUtility.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from beauty");
		BeautyProdutcs bp;
		while (rs.next()) {
			bp = new BeautyProdutcs();
			bp.setId(rs.getInt(1));
			bp.setName(rs.getString(2));
			bp.setDescription(rs.getString(3));
			bp.setPrice(rs.getInt(4));
			list.add(bp);

		}

		return list;

	}

}
