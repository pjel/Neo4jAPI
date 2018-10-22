package edu.comillas.mibd18;

import org.neo4j.graphdb.*;

public class BD_DeleteNodesEmbeddedExample {

    public static void main(String[] args) {
        //TODO Crear la conexión con la base de datos embebida "/home/icai/tmp/dataNeo/data/databases/dbPrueba.db"
        GraphDatabaseService graphDb = null;

        try ( Transaction tx = graphDb.beginTx() )
        {

            ResourceIterator<Node> ri =graphDb.getAllNodes().iterator();
            while (ri.hasNext()){
                Node n = ri.next();
                for (Relationship r : n.getRelationships()) {
                    r.delete();
                }
                n.delete();
            }

            tx.success();
        }

        //TODO Cerra conexion

    }

}
