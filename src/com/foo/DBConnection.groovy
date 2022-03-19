package com.foo
libraryResource 'mysql-connector-java-8.0.28.jar'
import groovy.sql.Sql

class DBConnection{
  
  def getConnection() {
    Class.forName("com.mysql.jdbc.Driver")
    def sql = Sql.newInstance("jdbc:mysql://localhost:3306/employee", "root","root@pass", "com.mysql.jdbc.Driver")
    //def rows = sql.execute "select count(*) from test_table;"
    //echo rows.dump()
  }
}
