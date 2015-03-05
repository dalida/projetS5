/**
 * @Author :
 * Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 * Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 */

package s5;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Use SAX Parser to display all books
 */
public class ReadXMLOuvrage {
	private String currentElement;
	private int bookCount = 1;
	boolean tag101 = false;
	boolean tag101Codea = false;
	boolean tag210 = false;
	boolean tag210Codec = false;
	boolean tag210Coded = false;
	boolean tag215 = false;
	boolean tag215Codea = false;
	boolean tag700 = false;
	boolean tag700Codea = false;
	boolean tag700Codeb = false;
	boolean tag995 = false;
	boolean tag995Codek = false;

	// Constructor
	public ReadXMLOuvrage() {
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			File file = new File("OUVRAGES_MODIF.xml");
			InputStream inputStream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(inputStream,
					"UTF-8");

			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
			saxParser.parse(is, new MyHandler());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Entry main method
	public static void main(String args[]) {
		new ReadXMLOuvrage();
	}

	/*
	 * Inner class for the Callback Handlers.
	 */
	class MyHandler extends DefaultHandler {
		// Callback to handle element start tag
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			currentElement = qName;
			if (currentElement.equals("record")) {
				System.out.println("Book " + bookCount);
				bookCount++;
			}
			if (currentElement.equals("datafield")) {
				String tag = attributes.getValue("tag");
				// Tag for Language
				if (tag.equals("101"))
					tag101 = true;

				// Tag for Year, Editor
				if (tag.equals("210"))
					tag210 = true;

				// Tag for Page Number
				if (tag.equals("215"))
					tag215 = true;

				// Tag for Author
				if (tag.equals("700"))
					tag700 = true;

				// Tag for Genre
				if (tag.equals("995"))
					tag995 = true;
			}
			if (currentElement.equals("subfield")) {
				String code = attributes.getValue("code");
				// Tag for Language
				if (tag101)
					if (code.equals("a"))
						tag101Codea = true;

				// Tag for Editor and Year
				if (tag210) {
					if (code.equals("c"))
						tag210Codec = true;
					if (code.equals("d"))
						tag210Coded = true;
				}

				// Tag for Page Number
				if (tag215)
					if (code.equals("a"))
						tag215Codea = true;

				// Tag for Author (Nom)
				if (tag700)
					if (code.equals("a"))
						tag700Codea = true;

				// Tag for Author (Prenom)
				if (tag700)
					if (code.equals("b"))
						tag700Codeb = true;

				// Tag for Genre
				if (tag995)
					if (code.equals("k"))
						tag995Codek = true;
			}
		}

		// Callback to handle element end tag
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			currentElement = "";
		}

		// Callback to handle the character text data inside an element
		@Override
		public void characters(char[] chars, int start, int length)
				throws SAXException {
			// Tag for Language
			if (tag101Codea) {
				System.out.println("\tLanguage:\t"
						+ new String(chars, start, length));
				tag101 = false;
				tag101Codea = false;
			}

			// Tag for Editor
			if (tag210Codec) {
				System.out.println("\tEditor:\t"
						+ new String(chars, start, length));
				tag210Codec = false;
			}

			// Tag for Year
			if (tag210Coded) {
				System.out.println("\tYear:\t"
						+ new String(chars, start, length));
				tag210 = false;
				tag210Coded = false;
			}

			// Tag for Page Number
			if (tag215Codea) {
				System.out.println("\tPage Number:\t"
						+ new String(chars, start, length));
				tag215 = false;
				tag215Codea = false;
			}

			// Tag for Author (Nom)
			if (tag700Codea) {
				System.out.println("\tAuthor (Nom):\t"
						+ new String(chars, start, length));
				tag700Codea = false;
			}

			// Tag for Author (Prenom)
			if (tag700Codeb) {
				System.out.println("\tAuthor (Prenom):\t"
						+ new String(chars, start, length));
				tag700 = false;
				tag700Codeb = false;
			}

			// Tag for Genre
			if (tag995Codek) {
				System.out.println("\tGenre:\t"
						+ new String(chars, start, length));
				tag995 = false;
				tag995Codek = false;
			}
		}
	}
}