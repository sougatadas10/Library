package com.foo
@Grab(group='mysql', module='mysql-connector-java', version='5.1.6')
import mysql.mysql-connector-java
import groovy.sql.Sql

class DBConnection{
  
  def getConnection(def context) {
    //context.libraryResource 'mysql-connector-java-8.0.28.jar'
    Class.forName("com.mysql.jdbc.Driver")
    def sql = Sql.newInstance("jdbc:mysql://localhost:3306/employee", "root","root@pass", "com.mysql.jdbc.Driver")
    //def rows = sql.execute "select count(*) from test_table;"
    //echo rows.dump()
  }
}
