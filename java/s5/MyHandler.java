/**
 * @Author :
 * Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 * Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 */

package s5;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

	boolean tagFname = false;
	boolean tagLname = false;
	boolean tagEmail = false;
	boolean tagDep = false;
	boolean tagSalary = false;
	boolean tagAddress = false;

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (attributes.getLength() > 0) {

			String tag = "<" + qName;
			for (int i = 0; i < attributes.getLength(); i++) {

				tag += " " + attributes.getLocalName(i) + "="
						+ attributes.getValue(i);
			}

			tag += ">";
			System.out.println(tag);

		} else {

			System.out.println("<" + qName + ">");
		}

		if (qName.equalsIgnoreCase("firstname")) {
			tagFname = true;
		}

		if (qName.equalsIgnoreCase("lastname")) {
			tagLname = true;
		}

		if (qName.equalsIgnoreCase("email")) {
			tagEmail = true;
		}

		if (qName.equalsIgnoreCase("department")) {
			tagDep = true;
		}

		if (qName.equalsIgnoreCase("salary")) {
			tagSalary = true;
		}

		if (qName.equalsIgnoreCase("address")) {
			tagAddress = true;
		}

	}

	public void characters(char ch[], int start, int length)
			throws SAXException {

		if (tagFname) {
			System.out.println(new String(ch, start, length));
			tagFname = false;
		}

		if (tagLname) {
			System.out.println(new String(ch, start, length));
			tagLname = false;
		}

		if (tagEmail) {
			System.out.println(new String(ch, start, length));
			tagEmail = false;
		}

		if (tagDep) {
			System.out.println(new String(ch, start, length));
			tagDep = false;
		}

		if (tagSalary) {
			System.out.println(new String(ch, start, length));
			tagSalary = false;
		}

		if (tagAddress) {
			System.out.println(new String(ch, start, length));
			tagAddress = false;
		}

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		System.out.println("</" + qName + ">");

	}

}