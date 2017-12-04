package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {
	private static String url = "jdbc:sqlite:C:/Users/Skeiker123/Desktop/Schule/4. Klasse/SWP/SQLite Driver/Pokerprojekt/testDB.db";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			String url = "jdbc:sqlite:C:/Users/Skeiker123/Desktop/Schule/4. Klasse/SWP/SQLite Driver/Pokerprojekt/testDB.db";

			conn = DriverManager.getConnection(url);

			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	public static void createTables() {

		String sql1 = "create table if not exists User (\n" + "	userID int primary key, \n"
				+ "	userName text not null, \n" + "	userRegistrationDate int not null \n" + ");";

		String sql2 = "create table if not exists Results(\r\n" + "	beginDateTimeOfTest int primary key,\r\n"
				+ "	endDateTimeOfTest int ,\r\n" + "	userID int not null,\r\n" + "	nrPairs int not null,\r\n"
				+ "	nrTriples int not null,\r\n" + "	nrPoker int not null,\r\n" + "	nrTwoPairs int not null,\r\n"
				+ "	nrFlush int not null,\r\n" + "	nrStraightFlush int not null,\r\n"
				+ "	nrRoyalFlush int not null,\r\n" + "	nrFullHouse int not null	\r\n" + ")";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql1);
			stmt.execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// stmt.execute(sql2);

	}

	public static void insertResults(int beginDateTimeOfTest, int endDateTimeOfTest, int userId, int nrPairs,
			int nrTriples, int nrPoker, int nrTwoPairs, int nrFlush, int nrStraightFlush, int nrRoyalFlush,
			int nrFullHouse) {
		String sql2 = "INSERT INTO Results(beginDateTimeOfTest,endDateTimeOfTest,userID,nrPairs,nrTriples,"
				+ "nrPoker,nrTwoPairs,nrFlush,nrStraightFlush,nrRoyalFlush,nrFullHouse) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setInt(1, beginDateTimeOfTest);
			pstmt.setInt(2, endDateTimeOfTest);
			pstmt.setInt(3, userId);
			pstmt.setInt(4, nrPairs);
			pstmt.setInt(5, nrTriples);
			pstmt.setInt(6, nrPoker);
			pstmt.setInt(7, nrTwoPairs);
			pstmt.setInt(8, nrFlush);
			pstmt.setInt(9, nrStraightFlush);
			pstmt.setInt(10, nrRoyalFlush);
			pstmt.setInt(11, nrFullHouse);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getHighestUserId() {
		int userId = 0;
		String sql = "Select max(userID) from User;";

		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				userId = rs.getInt(1);
				System.out.println("UserID aus Datenbank entnommen");
			}
			return userId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	public static void insertUser(int userId, String name, int registrationDate) {

		String sql2 = "INSERT INTO User(userID,userName,userRegistrationDate) VALUES(?,?,?)";

		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setInt(1, userId);
			pstmt.setString(2, name);
			pstmt.setInt(3, registrationDate);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (getConnection() instanceof Connection) {
			System.out.println("Verbindung wurde hergestellt.");
		}
		createTables();
	}
}
