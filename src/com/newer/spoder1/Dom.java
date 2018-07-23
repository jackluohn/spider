package com.newer.spoder1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
//www web
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Dom {

	// Simple-XML

	public void XML(List<Film> films) {

		try {

			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			Element root = doc.createElement("film-list");
			for (int i = 0; i < films.size(); i++) {
				Element film = doc.createElement("film");
				root.appendChild(film);

				if (films.get(i).title == null) {

				} else {
					Element title = doc.createElement("title");
					film.appendChild(title);

					Text text = doc.createTextNode(films.get(i).title);
					title.appendChild(text);
				}

				if (films.get(i).poster == null) {

				}else {
				Element poster = doc.createElement("poster");
				poster.appendChild(doc.createTextNode(films.get(i).poster));
				film.appendChild(poster);
				}
				
				if (films.get(i).director == null) {

				}else {
				Element director = doc.createElement("director");
				director.appendChild(doc.createTextNode(films.get(i).director));
				film.appendChild(director);
				}

				if (films.get(i).scriptwriter == null) {

				}else {
				Element scriptwriter = doc.createElement("scriptwriter");
				scriptwriter.appendChild(doc.createTextNode(films.get(i).scriptwriter));
				film.appendChild(scriptwriter);
				}
				
				Element actors = doc.createElement("actors");
				film.appendChild(actors);
				if (films.get(i).actor == null) {

				}else {
				Element actor = doc.createElement("actor");
				actor.appendChild(doc.createTextNode(films.get(i).actor));
				actors.appendChild(actor);
				}

				
				if (films.get(i).language == null) {

				}else {
				 Element language = doc.createElement("language");
				 language.appendChild(doc.createTextNode(films.get(i).language));
				 film.appendChild(language);
				}
				
				if (films.get(i).commentNum == null) {

				}else {
				 Element commentNum = doc.createElement("commentNum");
				 commentNum.appendChild(doc.createTextNode(films.get(i).commentNum));
				 film.appendChild(commentNum);
				}

				if (films.get(i).queto == null) {

				}else {
				Element queto = doc.createElement("queto");
				queto.appendChild(doc.createTextNode(films.get(i).queto));
				film.appendChild(queto);
				}

				if (films.get(i).type == null) {

				}else {
				Element type = doc.createElement("type");
				type.appendChild(doc.createTextNode(films.get(i).type));
				film.appendChild(type);
				}

				if (films.get(i).makePlace == null) {

				}else {
				Element makePlace = doc.createElement("makePlace");
				makePlace.appendChild(doc.createTextNode(films.get(i).makePlace));
				film.appendChild(makePlace);
				}

				// Element releaseTime = doc.createElement("releaseTime");
				// releaseTime.appendChild(doc.createTextNode(films.get(i).releaseTime));
				// film.appendChild(releaseTime);

				
				film.setAttribute("grade", films.get(i).grade);
//				film.
			}
			doc.appendChild(root);

			// DOM 内存中
			// film --

			// 序列化
			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			// 输入DOM
			// 输出 文件/网络
			transformer.transform(new DOMSource(doc), new StreamResult(new File("豆瓣250.xml")));

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
