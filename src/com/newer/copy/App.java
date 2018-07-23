package com.newer.copy;

import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.Gson;

public class App {

	public static void main(String[] args) {

		String url = "https://www.douyu.com/directory/game/yz";

		List<Film> films = Collections.synchronizedList(new LinkedList<>());

		ExecutorService pool = Executors.newCachedThreadPool();

		pool.execute(new Spider(url, films));
//		for (int i = 1; i < 10; i++) {
//			url = String.format("https://www.douyu.com/directory/game/yz", 25 * i);
//			pool.execute(new Spider(url, films));
//		}
		pool.shutdown();

		// CODE
//		System.out.println(films.size());

		while (true) {
			if (pool.isTerminated()) {
				writeData(films);
//				System.out.println(films.size());
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static void writeData(List<Film> films) {
		System.out.println(films.size());
//		Collections.sort(films);

		for (Film film : films) {
			System.out.println(film);
		}
		String json = new Gson().toJson(films);
		try (FileWriter out = new FileWriter("250.json")) {
			out.write(json);
			System.out.println(" 写 JSON 完成");
		} catch (Exception e) {
		}

		ExecutorService pool = Executors.newFixedThreadPool(4);
////		pool = Executors.newCachedThreadPool();
//		
		for (Film film : films) {
			pool.execute(new ImgLoader(film));
		}
		pool.shutdown();

	}
}
