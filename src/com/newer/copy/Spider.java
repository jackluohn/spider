package com.newer.copy;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider implements Runnable {

	private String url;
	private List<Film> films;

	public Spider(String url, List<Film> films) {
		this.url = url;
		this.films = films;
	}

	@Override
	public void run() {
		try {
			Document doc = Jsoup.connect(url).timeout(60000).get();

			Elements elms = doc.select("#live-list-content");

			for (Element e : elms) {
				Film film = new Film();
				String title = e.select("#live-list-content #mes span[class=dy-name ellipsis fl]").text();
				
				String path = e.select("#live-list-content #imgbox img").attr("src");
//				String title = e.select(".title").text();
//				String quote = e.select(".quote .inq").text();
//				String rating = e.select(".star .rating_num").text();
//				String info = e.select(".bd p").first().text();
//				String link = e.select("a").first().attr("href");

				film.setTitle(title);
//				film.setTitle(title);
				film.setPath(path);
//				film.setQuote(quote);
//				film.setRating(Double.parseDouble(rating));
//				film.setInfo(info);
//				film.setLink(link);

				films.add(film);
//				System.out.println(Thread.currentThread().getName() + " 抓取 " + id);
			}
			System.out.println("爬虫 " + Thread.currentThread() + " over");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
