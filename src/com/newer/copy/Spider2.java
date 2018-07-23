package com.newer.copy;
//package com.newer.spider2;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class Spider2 implements Runnable {
//
//	private String url;
//	private List<Film> films;
//	private Film film;
//
//	public Spider2(Film film) {
//		url = film.getLink();
//		this.film = film;
//	}
//
//	@Override
//	public void run() {
//		try {
//			Document doc = Jsoup.connect(url).timeout(60000).get();
//
//			Elements elms = doc.select(".#info");
//
//			for (Element e : elms) {
//				Film film = new Film();
//				String time = e.select("p1").text();
//				System.out.println(time);
////				String path = e.select(".pic img").attr("src");
////				String title = e.select(".title").text();
////				String quote = e.select(".quote .inq").text();
////				String rating = e.select(".star .rating_num").text();
////				String info = e.select(".bd p").first().text();
////				String link = e.select("a").first().attr("href");
//
////				film.setId(Integer.parseInt(id));
////				film.setTitle(title);
////				film.setPath(path);
////				film.setQuote(quote);
////				film.setRating(Double.parseDouble(rating));
////				film.setInfo(info);
////				film.setLink(link);
////
////				films.add(film);
////				System.out.println(Thread.currentThread().getName() + " 抓取 " + id);
////			}
////			System.out.println("爬虫 " + Thread.currentThread() + " over");
////
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////	}
//
//}
//	}
//}
