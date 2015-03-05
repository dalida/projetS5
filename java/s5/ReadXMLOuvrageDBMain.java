/**
 * @Author :
 * Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 * Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 */

package s5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import s5.Book;

public class ReadXMLOuvrageDBMain {

	public static void main(String[] args) throws SQLException {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			ReadXMLOuvrageDB handler = new ReadXMLOuvrageDB();
			File file = new File("OUVRAGES_MODIF.xml");
			InputStream inputStream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(inputStream,
					"UTF-8");

			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
			saxParser.parse(is, handler);
			//Get Book list
			List<Book> bookList = handler.getBookList();

			//print employee information
			for(Book book : bookList) {
				System.out.println(book);
				ReadXMLOuvrageDBDAO.insertData(book);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
