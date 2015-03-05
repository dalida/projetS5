/**
 * @Author :
 * Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 * Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 */

package s5;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import s5.Book;

/*
 * Inner class for the Callback Handlers.
 */
public class ReadXMLOuvrageDB extends DefaultHandler {

	private int id;
	boolean tag101;
	boolean tag101Codea;
	boolean tag200;
	boolean tag200Codea;
	boolean tag210;
	boolean tag210Codec;
	boolean tag210Coded;
	boolean tag215;
	boolean tag215Codea;
	boolean tag700;
	boolean tag700Codea;
	boolean tag700Codeb;
	boolean tag995;
	boolean tag995Codek;

	//List to hold Book object
	private List<Book> bookList = null;
	private Book book = null;

	//temporary value in characters method
	private String tmpValue;

	//getter method for book list
	public List<Book> getBookList() {
		return bookList;
	}

	// Callback to handle element start tag
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		String currentElement = qName;
		if (currentElement.equals("record")) {
			book = new Book();
			book.setId(id);
			id++;
			//initialize list
			if (bookList == null)
				bookList = new ArrayList<>();
		}
		if (currentElement.equals("datafield")) {
			String tag = attributes.getValue("tag");

			// Tag for Language
			if (tag.equals("101")) {
				tag101 = true;
			} else {
				tag101 = false;
			}

			// Tag for Title
			if (tag.equals("200")) {
				tag200 = true;
			} else {
				tag200 = false;
			}

			// Tag for Year, Editor
			if (tag.equals("210")) {
				tag210 = true;
			} else {
				tag210 = false;
			}

			// Tag for Page Number
			if (tag.equals("215")) {
				tag215 = true;
			} else {
				tag215 = false;
			}

			// Tag for Author
			if (tag.equals("700")) {
				tag700 = true;
			} else {
				tag700 = false;
			}

			// Tag for Genre
			if (tag.equals("995")) {
				tag995 = true;
			} else {
				tag995 = false;
			}
		}
		if (currentElement.equals("subfield")) {
			String code = attributes.getValue("code");
			// Tag for Language
			if (tag101) {
				if (code.equals("a")) {
					tag101Codea = true;
				}
			}

			// Tag for Title
			if (tag200) {
				if (code.equals("a")) {
					tag200Codea = true;
					//					tag101 = false;
				}
			}

			// Tag for Editor and Year
			if (tag210) {
				if (code.equals("c")) {
					tag210Codec = true;
				}
				if (code.equals("d")) {
					tag210Coded = true;
				}
			}

			// Tag for Page Number
			if (tag215) {
				if (code.equals("a")) {
					tag215Codea = true;
				}
			}

			// Tag for Author (Nom)
			if (tag700) {
				if (code.equals("a")) {
					tag700Codea = true;
				}
			}

			// Tag for Author (Prenom)
			if (tag700) {
				if (code.equals("b")) {
					tag700Codeb = true;
				}
			}

			// Tag for Genre
			if (tag995) {
				if (code.equals("k")) {
					tag995Codek = true;
				}
			}
		}
	}

	// Callback to handle element end tag
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		// Tag for Language
		if (tag101Codea) {
			book.setLanguage(tmpValue);
			tag101 = false;
			tag101Codea = false;
		}

		// Tag for Title
		if (tag200Codea) {
			book.setTitle(tmpValue);
			tag200 = false;
			tag200Codea = false;
		}

		// Tag for Editor
		if (tag210Codec) {
			book.setEditor(tmpValue);
			tag210Codec = false;
		}

		// Tag for Year
		if (tag210Coded) {
			book.setYear(tmpValue);
			tag210 = false;
			tag210Coded = false;
		}

		// Tag for Page Number
		if (tag215Codea) {
			book.setPageNumber(tmpValue);
			tag215 = false;
			tag215Codea = false;
		}

		// Tag for Author (Nom)
		if (tag700Codea) {
			book.setAuthorName(tmpValue);
			tag700Codea = false;
		}

		// Tag for Author (Prenom)
		if (tag700Codeb) {
			book.setAuthorFirstName(tmpValue);
			book.setAuthorCombineName(book.getAuthorFirstName() + " " + book.getAuthorName());
			tag700 = false;
			tag700Codeb = false;
		}

		// Tag for Genre
		if (tag995Codek) {
			book.setGenre(tmpValue);
			tag995 = false;
			tag995Codek = false;
		}

		if (qName.equals("record")) {
			//add Employee object to list
			bookList.add(book);
		}
	}

	// Callback to handle the character text data inside an element
	@Override
	public void characters(char[] chars, int start, int length)
			throws SAXException {

		tmpValue = new String(chars, start, length);
	}
}
