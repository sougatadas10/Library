package com.foo
@Grab('mysql:mysql-connector-java:8.0.28')
import groovy.sql.Sql;
import java.util.ServiceLoader;
import java.sql.Driver;

class DBConnection{
  
  def getConnection(def context) {
    //context.libraryResource 'mysql-connector-java-8.0.28.jar'
    Class.forName("com.mysql.jdbc.Driver")
    ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
    def sql = Sql.newInstance("jdbc:mysql://localhost:3306/employee", "root","root@pass", "com.mysql.jdbc.Driver")
    //def rows = sql.execute "select count(*) from test_table;"
    //echo rows.dump()
  }
}
