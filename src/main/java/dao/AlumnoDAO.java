package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import database.MongoDBConnection;
import model.Alumno;
import org.bson.conversions.Bson;

public class AlumnoDAO {
    MongoCollection coleccionAlumnos;

    public AlumnoDAO(){
        coleccionAlumnos = new MongoDBConnection().getAlumnosCollection();
    }


    public void insertarUsuarioAlumno(Alumno alumno){
        MongoCollection collection = new MongoDBConnection().getAlumnosCollection();
        collection.insertOne(alumno);
    }


    public void getElementosAlumno(){
        MongoCollection collection = new MongoDBConnection().getAlumnosCollection();
        FindIterable<Alumno> iterable1 = collection.find();
        MongoCursor<Alumno> cursor = iterable1.cursor();

        while(cursor.hasNext()){
            Alumno alumno = cursor.next();
            alumno.mostrarDatos();
        }
    }


    public void buscarAlumno(String email) {
        Bson filtrado = Filters.eq("email", email);

        FindIterable<Alumno> iterable = coleccionAlumnos.find(filtrado);
        MongoCursor<Alumno> cursor = iterable.cursor();

        if (cursor.hasNext()) {
            while (cursor.hasNext()) {
                Alumno alumno = cursor.next();
                alumno.mostrarDatos();
            }
        } else {
            System.out.println("No se encontró ningún alumno con ese email");
        }
    }


    public void eliminarAlumno(){
        Bson filtrado = Filters.gte("calificaation" , 5 );

        DeleteResult borrado = coleccionAlumnos.deleteMany(filtrado);
        if(borrado.getDeletedCount()>0) {
            System.out.println("Se han eliminado correctamente");
        }else {
            System.out.println("No se encontró ningún alumno con esa nota");
        }
    }
}
