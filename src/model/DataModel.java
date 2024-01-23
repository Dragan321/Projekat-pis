package model;

import java.util.*;

public class DataModel {
   public DbResultSet resultSet;
   public XMLModel xmlModel;

   public DataModel(DbResultSet resultSet, XMLModel xmlModel) {
      super();
      this.resultSet = resultSet;
      this.xmlModel = xmlModel;
   }

   public DbResultSet getResultSet() {
      return resultSet;
   }

   public void setResultSet(DbResultSet resultSet) {
      this.resultSet = resultSet;
   }

   public XMLModel getXmlModel() {
      return xmlModel;
   }

   public void setXmlModel(XMLModel xmlModel) {
      this.xmlModel = xmlModel;
   }



}