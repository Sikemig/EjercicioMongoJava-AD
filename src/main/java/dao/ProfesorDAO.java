package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import database.MongoDBConnection;
import model.Profesor;
import org.bson.conversions.Bson;

public class ProfesorDAO {
    MongoCollection coleccionProfesores;

    public ProfesorDAO(){
        coleccionProfesores = new MongoDBConnection().getProfesoresCollection();
    }

    public void insertarUsuarioProfesor(Profesor profesor){
        MongoCollection collection = new MongoDBConnection().getProfesoresCollection();
        collection.insertOne(profesor);
    }


    public void getElementosProfesor(){
        MongoCollection collection = new MongoDBConnection().getProfesoresCollection();
        FindIterable<Profesor> iterable1 = collection.find();
        MongoCursor<Profesor> cursor = iterable1.cursor();

        while(cursor.hasNext()){
            Profesor profesor = cursor.next();
            profesor.mostrarDatos();
        }
    }

    public void getProfesoresEdad(int edad1, int edad2){
        Bson filtrado = Filters.and(Filters.gte("age", edad1),
                Filters.lte("age", edad2)
        );

        FindIterable<Profesor> iterable1 = coleccionProfesores.find(filtrado);
        MongoCursor<Profesor> cursor = iterable1.cursor();

        if (cursor.hasNext()) {
            while (cursor.hasNext()) {
                Profesor profesor = cursor.next();
                profesor.mostrarDatos();
            }
        } else {
            System.out.println("No se encontró ningún profesor entre esas edades");
        }
    }


    public void actualizarProfesor(String email, double calificacion){
        Bson filtrado = Filters.eq("email", email);

        Bson update = Updates.set("rating", calificacion);

        FindIterable<Profesor> iterable = coleccionProfesores.find(filtrado);
        MongoCursor<Profesor> cursor = iterable.cursor();

        if (cursor.hasNext()) {
            UpdateResult resultado = coleccionProfesores.updateOne(filtrado, update);
            System.out.println("Se ha modificado correctamente");
        } else {
            System.out.println("No se encontró ningún profesor con ese email");
        }
    }


}
