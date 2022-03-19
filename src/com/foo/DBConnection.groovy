package com.foo
@Grab( 'mysql:mysql-connector-java:5.1.27' )
//@GrabConfig(systemClassLoader=true)
import groovy.sql.Sql;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import com.mysql.jdbc.*

class DBConnection{
  
  def getConnection(def context) {
    MysqlDataSource ds = new MysqlDataSource()
    ds.user = 'root'
    ds.password = 'root@pass'
    ds.url = 'jdbc:mysql://localhost:3306/employee'
    Sql sql=Sql.newInstance(ds)
    def rows = sql.execute "select count(*) from employee.employee_master;"
    //context.println rows.dump()
  }
}
