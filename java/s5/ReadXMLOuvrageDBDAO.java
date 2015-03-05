/**
 * @Author :
 * Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 * Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 */

package s5;

import java.sql.*;
import s5.DataBaseConnection;

public class ReadXMLOuvrageDBDAO {

	public static void insertData(Book book) throws SQLException {
		//Save books to database
		Connection c = DataBaseConnection.getConnection();
		try {
			c.setAutoCommit(false);
			PreparedStatement psPersist = c
					.prepareStatement("insert into book(title, language, year, editor, pageNumber, author, genre)  values (?, ?, ?, ?, ?, ?, ?)");

			psPersist.setString(1, book.getTitle());
			psPersist.setString(2, book.getLanguage());
			psPersist.setString(3, book.getYear());
			psPersist.setString(4, book.getEditor());
			psPersist.setString(5, book.getPageNumber());
			psPersist.setString(6, book.getAuthorCombineName());
			psPersist.setString(7, book.getGenre());

			psPersist.executeUpdate();

			psPersist.close();

			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			c.setAutoCommit(true);
			throw e;
		}

		c.setAutoCommit(true);
		c.close();
	}
}
