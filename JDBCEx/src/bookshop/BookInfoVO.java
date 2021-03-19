package bookshop;

public class BookInfoVO {

	private Long bookId;
	private String title;
	private String pubs;
	private String pubDate;
	private String authorId;
	
//	public BookInfoVO(long bookId, String title, String pubs, String pubDate, String authorId) {
//	}

	public BookInfoVO(Long bookId, String title, String pubs, String pubDate, String authorId) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;	
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	@Override
	public String toString() {
		return "BookInfoVO [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubdate=" + pubDate + ", authorId=" + authorId + "]";
	}
	
	
}