package db;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class MySQLConnection {
	private static String url = "jdbc:mysql://localhost/pokerorm?user=root&password=";
	private static Dao<Users, Integer> userDao;
	private static Dao<Results, Integer> resultDao;
	private static ConnectionSource c = null;

	public static void run(Users u, Results r) throws Exception {
		

		try {
			c = new JdbcConnectionSource(url);

			//MySQLConnection.setupDatabase(c);

			MySQLConnection.insertIntoDB(c, u, r);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				c.close();
			}
		}

	}

	public static void insertIntoDB(ConnectionSource c, Users u, Results r) {
		try {
			
			Users user = u;
			userDao.create(user);

			Results result = r;
			resultDao.create(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void setupDatabase(ConnectionSource c) {

		try {
			userDao = DaoManager.createDao(c, Users.class);
			resultDao = DaoManager.createDao(c, Results.class);

			TableUtils.createTableIfNotExists(c, Users.class);
			TableUtils.createTableIfNotExists(c, Results.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static int getHighestId() throws IOException {
		try {	
		c = new JdbcConnectionSource(url);
		setupDatabase(c);
		QueryBuilder<Users, Integer> qb = userDao.queryBuilder();
		qb.selectRaw("MAX(userID)");
		GenericRawResults<String[]> results;
		results = userDao.queryRaw(qb.prepareStatementString());
		String[] values = ((GenericRawResults<String[]>) results).getFirstResult();
		c.close();
		return Integer.parseInt(values[0]);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
