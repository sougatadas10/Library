package com.foo
@Grab( 'mysql:mysql-connector-java:8.0.28' )
//@GrabConfig(systemClassLoader=true)
import groovy.sql.Sql;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import com.mysql.jdbc.*

class DBConnection{
  
  def getConnection(def context) {
    //MysqlDataSource ds = new MysqlDataSource()
    //ds.user = 'root'
    //ds.password = 'root@pass'
    //ds.url = 'jdbc:mysql://127.0.0.1:3306/employee'
    //Sql sql=Sql.newInstance(ds)
    //def rows = sql.execute "select count(*) from employee.employee_master;"
    //context.println rows.dump()
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/employee','root', 'root@pass', 'com.mysql.jdbc.Driver')
    sql.query('SELECT employee_id, employee_name FROM employee_master') { 
      resultSet ->
      while (resultSet.next()) {
        def first = resultSet.getString(1)
        def last = resultSet.getString('employee_name')
      }
    }
  }
}
