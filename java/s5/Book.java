/**
 * @Author :
 * Romy Ardianto (romy.ardianto@telecom-bretagne.eu)
 * Lisa Maliphol (lisa.maliphol@telecom-bretagne.eu)
 */

package s5;

public class Book {

	private int id;
	private String title;
	private String language;
	private String year;
	private String editor;
	private String pageNumber;
	private String authorFirstName;
	private String authorName;
	private String authorCombineName;
	private String genre;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorCombineName() {
		return authorCombineName;
	}
	public void setAuthorCombineName(String authorCombineName) {
		this.authorCombineName = authorCombineName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book:: ID="+this.id + " \n\t Title=" + this.title + " \n\t Language=" + this.language + " \n\t Editor=" + this.editor + " \n\t Year=" + this.year +
				" \n\t Page Number=" + this.pageNumber + " \n\t Author First Name=" + this.authorFirstName + 
				" \n\t Author Name=" + this.authorName + " \n\t Author Combine Name=" + this.authorCombineName +
				" \n\t Genre=" + this.genre;
	}

}