package com.newer.copy;

public class Film  {

//	private int id;
	private String title;
//	private String info;
//	private double rating;
//	private String quote;
	private String path;
//	private String link;

//	public String getLink() {
//		return link;
//	}
//
//	public void setLink(String link) {
//		this.link = link;
//	}

	public Film() {
	}

//	public String getInfo() {
//		return info;
//	}
//
//	public void setInfo(String info) {
//		this.info = info;
//	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public double getRating() {
//		return rating;
//	}
//
//	public void setRating(double rating) {
//		this.rating = rating;
//	}

//	public String getQuote() {
//		return quote;
//	}
//
//	public void setQuote(String quote) {
//		this.quote = quote;
//	}
//
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", path=" + path + "]";
	}

//	@Override
	

//	@Override
//	public int compareTo(Film o) {
//		return id - o.id;
//	}

}
