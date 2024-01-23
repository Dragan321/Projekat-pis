/***********************************************************************
 * Module:  SAXParser.java
 * Author:  Notebook
 * Purpose: Defines the Class SAXParser
 ***********************************************************************/

package model.parser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import model.XMLModel;

	public class SAXParser implements ParserStrategy {

		SAXParserFactory factory;
		javax.xml.parsers.SAXParser parser;

		public SAXParser() {
			factory = SAXParserFactory.newInstance();
			try {
				parser = factory.newSAXParser();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
		}

		public void parseXMLModel(String location, XMLModel model) {
			// TODO Auto-generated method stub
		}

	}