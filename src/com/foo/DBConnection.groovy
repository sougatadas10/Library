package com.foo
@Grab( 'mysql:mysql-connector-java:5.1.27' )

import groovy.sql.Sql;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import com.mysql.jdbc.*
class DBConnection{
  
  def getConnection(def context) {
    MysqlDataSource ds = new MysqlDataSource()
    ds.user = 'root'
    ds.password = 'root@pass'
    ds.url = 'jdbc:mysql://host.docker.internal:3306/employee?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT"'  
    Sql sql=Sql.newInstance(ds)
    
    sql.firstRow('SELECT employee_id, employee_name FROM employee_master')
    
   
    }
  }
