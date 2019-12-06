package book_manager_program;

import java.sql.DriverManager;
import java.sql.SQLException;

import book_manager_stringutil.LibrarySystemStringUtil;

public class ProgramMain {

	public static void main(String[] args) {
		 LibrarySystemStringUtil.getFullDateString();
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jd_library_system";
		String password = "1234";
		try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
		System.out.println("오라클 연결 실패");
			e.printStackTrace();
		}
		
		new LibraryManagerConnectorForm();
	}
}
