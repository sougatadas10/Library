package com.foo
//@Grab( 'mysql:mysql-connector-java:5.1.27' )
@Grab( 'mysql:mysql-connector-java:8.0.11')

import groovy.sql.Sql;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import org.mysql.jdbc.JDBCDataSource
import com.mysql.jdbc.*
class DBConnection{
  
  def getConnection(def context) {
    //MysqlDataSource ds = new MysqlDataSource()
    JDBCDataSource ds = new JDBCDataSource()
    ds.user = 'root'
    ds.password = 'root@pass'
    ds.url = 'jdbc:mysql://host.docker.internal:3306/employee?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT"'  
    Sql sql=Sql.newInstance(ds)
    
    /**def url = 'jdbc:mysql:host.docker.internal:3306:employee'
    def user = 'root'
    def password = 'root@pass'
    def driver = 'org.mysql.cj.jdbcDriver'
    def sql = Sql.newInstance(url, user, password, driver)**/
    
    sql.firstRow('SELECT employee_id, employee_name FROM employee_master')
    
   
    }
  }
