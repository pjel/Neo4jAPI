package edu.comillas.mibd18;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Value;

import static org.neo4j.driver.Values.parameters;

public class AB_ExecuteStatementExample {
    public static void main(String[] args){
        //TODO conectarse a el servidor neo4j del docker local
        Driver driver = null;

        try ( Session session = driver.session() )
        {
            String catId="";
            String catName="";
            String description="";

            String statement = "CREATE (c:Category {categoryID: $catId, categoryName: $catName, description: $description})";
            Value p = parameters( "catId", catId, "catName",catName, "description",description);

            session.run( statement,p);


            statement = "MATCH (c:Category {categoryID:$catId}) DELETE c";
            p = parameters( "catId", catId);
            //TODO ejecutar en la sesion


            statement = "MERGE (c:Category {categoryID: $catId, categoryName: $catName, description: $description})";
            p = parameters( "catId", catId, "catName",catName, "description",description);
            //TODO ejecutar en la sesion
        }

        //TODO cerrar la conexión
    }
}
