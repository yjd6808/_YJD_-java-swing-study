package book_manager_program;

public class ProgramMain {

	public static void main(String[] args) {
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "hr";
//		String password = "1234";
//		try {
//			Class.forName(driver);
//			System.out.println("jdbc driver �ε� ����");
//			DriverManager.getConnection(url, user, password);
//			System.out.println("����Ŭ ���� ����");
//		} catch (ClassNotFoundException e) {
//			System.out.println("jdbc driver �ε� ����");
//		} catch (SQLException e) {
//			System.out.println("����Ŭ ���� ����");
//			e.printStackTrace();
//		}
		
		new LibraryManagerConnectorForm();
	}
}
