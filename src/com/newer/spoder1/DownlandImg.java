package com.newer.spoder1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class DownlandImg implements Runnable{

	Film film;
	
	public DownlandImg(Film film) {
		this.film = film;
	}
	
	@Override
	public void run() {
			File path = new File("豆瓣电影IMG");
			if(!path.exists())
				path.mkdir();
			
			String name = String.format("%03d_%s.jpg", film.getId(), film.getTitle().split(" ")[0]);
			try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(path, name)));) {
				byte[] data = new OkHttpClient.Builder().build()
					.newCall(new Request.Builder().url(film.getPoster()).build())
					.execute()
					.body()
					.bytes();
				out.write(data);
				out.flush();
				out.close();
				System.out.println(Thread.currentThread().getName() + " 下载了  " + film.getTitle() + "的海报");
			} catch (IOException e) {
				e.printStackTrace();
			}
//			System.out.println(Thread.currentThread().getName() + " is over");	
	}
	
}
