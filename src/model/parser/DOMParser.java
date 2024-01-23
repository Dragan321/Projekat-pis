/***********************************************************************
 * Module:  DOMParser.java
 * Purpose: Defines the Class DOMParser
 ***********************************************************************/

package model.parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.XMLModel;
import model.databaseAccess.DBConfiguration;
import model.databaseAccess.DbType;
import model.databaseModel.*;

public class DOMParser implements ParserStrategy {

	@Override
	public void parseXMLModel(String location, XMLModel xmlModel) {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();

			xmlModel.setDocument(builder.parse(location));

			XPathFactory factory = XPathFactory.newInstance();
			xmlModel.setXpath(factory.newXPath());

			xmlModel.setExpression(xmlModel.getXpath().compile("/database"));
			Node bazaPodataka = (Node) xmlModel.getExpression().evaluate(xmlModel.getDocument(), XPathConstants.NODE);
						
			xmlModel.setExpression(xmlModel.getXpath().compile("connection"));
			Node dbConfig = (Node) xmlModel.getExpression().evaluate(bazaPodataka, XPathConstants.NODE);
			
			xmlModel.setDbConfiguration(new DBConfiguration());
			xmlModel.getDbConfiguration().setAddress(dbConfig.getAttributes().getNamedItem("address").getNodeValue());
			xmlModel.getDbConfiguration().setDbName(dbConfig.getAttributes().getNamedItem("database").getNodeValue());
			xmlModel.getDbConfiguration().setPort(dbConfig.getAttributes().getNamedItem("port").getNodeValue());
			xmlModel.getDbConfiguration().setUser(dbConfig.getAttributes().getNamedItem("username").getNodeValue());
			xmlModel.getDbConfiguration().setPassword(dbConfig.getAttributes().getNamedItem("password").getNodeValue());
			if (dbConfig.getAttributes().getNamedItem("database_type").getNodeValue().equalsIgnoreCase("MSSQL")) {
				xmlModel.getDbConfiguration().setDbType(DbType.MsSQL_JTDS);
			}
			
			xmlModel.setRootPaket(new PackageModel());
			xmlModel.getRootPaket().setKod(null);
			xmlModel.getRootPaket().setNaziv(bazaPodataka.getAttributes().getNamedItem("name").getNodeValue());
			
			xmlModel.setExpression(xmlModel.getXpath().compile("package"));
			NodeList paketi = (NodeList) xmlModel.getExpression().evaluate(bazaPodataka, XPathConstants.NODESET);

			subPacks(paketi, xmlModel.getRootPaket(), xmlModel);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Privatna rekurzivna funkcija u kojoj se vrsi smijestanje cvorova dom-a u neku
	 * unutrasnju strukturu.
	 * 
	 * @param paketi
	 * @param rootPaket
	 * @throws XPathExpressionException
	 */
	private void subPacks(NodeList paketi, TreeElement rootPaket, XMLModel xmlModel) throws XPathExpressionException {
		for (int i = 0; i < paketi.getLength(); i++) {
			PackageModel pomPaket = new PackageModel();
			pomPaket.setKod(null);
			pomPaket.setNaziv(paketi.item(i).getAttributes().getNamedItem("name").getNodeValue());
			rootPaket.addElement(pomPaket);

			xmlModel.setExpression(xmlModel.getXpath().compile("package"));
			NodeList podpaketi = (NodeList) xmlModel.getExpression().evaluate(paketi.item(i), XPathConstants.NODESET);

			subPacks(podpaketi, pomPaket, xmlModel);

			xmlModel.setExpression(xmlModel.getXpath().compile("table"));
			NodeList tabele = (NodeList) xmlModel.getExpression().evaluate(paketi.item(i), XPathConstants.NODESET);

			for (int j = 0; j < tabele.getLength(); j++) {
				TableModel pomTabela = new TableModel();

				pomPaket.addElement(pomTabela);

				pomTabela.setKod(tabele.item(j).getAttributes().getNamedItem("code").getNodeValue());
				pomTabela.setNaziv(tabele.item(j).getAttributes().getNamedItem("name").getNodeValue());

				xmlModel.setExpression(xmlModel.getXpath().compile("column"));
				NodeList kolone = (NodeList) xmlModel.getExpression().evaluate(tabele.item(j), XPathConstants.NODESET);

				for (int k = 0; k < kolone.getLength(); k++) {

					ColumnModel pomKolona = new ColumnModel();

					pomKolona.setKod(kolone.item(k).getAttributes().getNamedItem("code").getNodeValue());
					pomKolona.setNaziv(kolone.item(k).getTextContent());

					boolean pomBool = false;

					if (kolone.item(k).getAttributes().getNamedItem("nullable").getNodeValue().equals("true")) {
						pomBool = true;
					}

					pomKolona.setNullable(pomBool);

					pomBool = false;

					if (kolone.item(k).getAttributes().getNamedItem("primary").getNodeValue().equals("true")) {
						pomBool = true;
					}

					pomKolona.setPrimary(pomBool);

					pomTabela.addElement(pomKolona);
				}

				xmlModel.setExpression(xmlModel.getXpath().compile("references"));
				NodeList reference = (NodeList) xmlModel.getExpression().evaluate(tabele.item(j),
						XPathConstants.NODESET);

				for (int k = 0; k < reference.getLength(); k++) {
					TableModel refTabela = new TableModel();
					refTabela.setKod(reference.item(k).getAttributes().getNamedItem("refTable").getNodeValue());

					pomTabela.addReferenca(refTabela);

					xmlModel.setExpression(xmlModel.getXpath().compile("refColumn"));
					NodeList refKolone = (NodeList) xmlModel.getExpression().evaluate(reference.item(k),
							XPathConstants.NODESET);
					for (int l = 0; l < refKolone.getLength(); l++) {
						ColumnModel refK = new ColumnModel();
						refK.setKod(refKolone.item(l).getTextContent());
						refTabela.addElement(refK);
					}

				}

				CRUDOperationModel crud = new CRUDOperationModel();
				
				xmlModel.setExpression(xmlModel.getXpath().compile("crud/create"));
				Node create = (Node) xmlModel.getExpression().evaluate(tabele.item(j), XPathConstants.NODE);

				crud.setCreateSProc(create.getTextContent());

				xmlModel.setExpression(xmlModel.getXpath().compile("crud/retrieve"));
				Node retrieve = (Node) xmlModel.getExpression().evaluate(tabele.item(j), XPathConstants.NODE);

				crud.setRetrieveSProc(retrieve.getTextContent());

				xmlModel.setExpression(xmlModel.getXpath().compile("crud/update"));
				Node update = (Node) xmlModel.getExpression().evaluate(tabele.item(j), XPathConstants.NODE);

				crud.setUpdateSProc(update.getTextContent());

				xmlModel.setExpression(xmlModel.getXpath().compile("crud/delete"));
				Node delete = (Node) xmlModel.getExpression().evaluate(tabele.item(j), XPathConstants.NODE);

				crud.setDeleteSProc(delete.getTextContent());
				
				pomTabela.setCrudOperation(crud);
			}
		}

	}

}