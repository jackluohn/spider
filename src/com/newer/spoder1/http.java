package com.newer.spoder1;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class http {

	public static void main(String[] args) {

//		url();

		// apache common HttpClient

		// okhttp
		
		try {
			new OkHttpClient.Builder().build()
				.newCall(new Request.Builder().url("").build())
				.execute()
				.body()
				.string();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		new OkHttpClient().newCall(request);
	}

	private static void url() {
		// URLConnection

		try {
			URL url = new URL("http://james.apache.org/");
			// TCP
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setReadTimeout(10000);
			conn.setConnectTimeout(10000);

			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestMethod("GET"); // POST

			// conn.setRequestProperty(, value);

			InputStream in = conn.getInputStream();

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];

			int size;
			while (-1 != (size = in.read(buf))) {
				out.write(buf, 0, size);
			}

			byte[] data = out.toByteArray();
			String text = new String(data, 0, data.length, "utf-8");

			FileOutputStream fout = new FileOutputStream("abc.txt");
			fout.write(text.getBytes("utf-8"));
			fout.close();
			System.out.println("ok");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
