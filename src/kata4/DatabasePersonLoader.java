/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class DatabasePersonLoader implements PersonLoader {

    private final Connection connection;

    public DatabasePersonLoader(Connection connection) {
        this.connection = connection;
    }

    DatabasePersonLoader(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public Person[] load() {
        try {
            return processPeople(connection.createStatement().executeQuery("SELECT * FROM people"));
        } catch (SQLException ex) {
            return new Person[0];
        }
    }

    private Person[] processPeople(ResultSet resultSet) throws SQLException {
        ArrayList<Person>personList = new ArrayList<>();
        
        while(resultSet.next())
            personList.add(processPerson(resultSet));
        return personList.toArray(new Person[personList.size()]);
    }

    private Person processPerson(ResultSet resultSet) throws SQLException {
        return new Person(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("company_name"),
                resultSet.getString("address"),
                resultSet.getString("city"),
                resultSet.getString("state"),
                new Mail (resultSet.getString("email")),
                resultSet.getString("web"));
    }
}
    
