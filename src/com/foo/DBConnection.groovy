package com.foo
@Grab( 'mysql:mysql-connector-java:5.1.27' )
//@GrabConfig(systemClassLoader=true)
import groovy.sql.Sql;
import java.util.ServiceLoader;
import java.sql.Driver;
import java.sql.DriverManager;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import com.mysql.jdbc.*
import groovy.sql.*

class DBConnection{
  
  def getConnection(def context) {
    //context.libraryResource 'mysql-connector-java-8.0.28.jar'
    //Class.forName("com.mysql.jdbc.Driver")
    //DriverManager.registerDriver(new com.mysql.jdbc.Driver())
    //ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
    //d=Class.forName("com.mysql.jdbc.Driver").newInstance()
    //context.println d.class // class com.mysql.jdbc.Driver
    //def sql = Sql.newInstance("jdbc:mysql://localhost:3306/employee", "root","root@pass", "com.mysql.jdbc.Driver")
    //def rows = sql.execute "select count(*) from test_table;"
    //echo rows.dump()
    MysqlDataSource ds = new MysqlDataSource()
    ds.user = 'root'
    ds.password = "root@pass"
    ds.url = 'jdbc:mysql://localhost:3306/test'

    Sql sql=Sql.newInstance(ds)
  }
}
