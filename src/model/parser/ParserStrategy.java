/***********************************************************************
 * Module:  ParserStrategy.java
 * Author:  Notebook
 * Purpose: Defines the Interface ParserStrategy
 ***********************************************************************/

package model.parser;

import model.XMLModel;

public interface ParserStrategy {

	void parseXMLModel(String location, XMLModel model);

}