package com.foo
//@Grab( 'mysql:mysql-connector-java:5.1.27' )
@Grab( 'mysql:mysql-connector-java:8.0.20')
//@Grab(group='mysql',module='mysql-connector-java',version='8.0.20')

import groovy.sql.Sql;
import java.sql.Driver;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
//import org.mysql.jdbc.JDBCDataSource
//import com.mysql.jdbc.*
class DBConnection{
  
  def getConnection(def context) {
    //MysqlDataSource ds = new MysqlDataSource()
    //JDBCDataSource ds = new JDBCDataSource()
    //ds.user = 'root'
    //ds.password = 'root@pass'
    //ds.url = 'jdbc:mysql://host.docker.internal:3306/employee?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT"'  
    //Sql sql=Sql.newInstance(ds)
    
    /**def url = 'jdbc:mysql:host.docker.internal:3306:employee'
    def user = 'root'
    def password = 'root@pass'
    def driver = 'org.mysql.cj.jdbcDriver'
    def sql = Sql.newInstance(url, user, password, driver)**/
    //Class.forName("com.mysql.jdbc.Driver").newInstance()
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    Connection con = DriverManager.getConnection("jdbc:mysql://host.docker.internal:3306/employee", "root", "root@pass");
    context.println("Connection established: "+con);

 
    //def sql = Sql.newInstance("jdbc:mysql://host.docker.internal:3306/employee", "root", "root@pass", "com.mysql.jdbc.Driver")
    
    //sql.firstRow('SELECT employee_id, employee_name FROM employee_master')
    
   
    }
  }
