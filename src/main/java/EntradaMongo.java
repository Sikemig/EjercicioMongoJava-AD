import dao.AlumnoDAO;
import dao.ProfesorDAO;
import model.Alumno;
import model.Profesor;

import java.util.ArrayList;
import java.util.Scanner;

public class EntradaMongo {
    // Declaramos las colecciones y el scanner fuera del metodo main para poder utilizarlo en los metodos
    private static AlumnoDAO alumnoDAO = new AlumnoDAO();
    private static ProfesorDAO profesorDAO = new ProfesorDAO();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int opcion = 0;

        do {
            mostrarMenu(); // Mostramos el menu impreso
            opcion=scanner.nextInt();

            switch (opcion){ // Para no ensuciar el codigo mucho vamos a intentar hacer métodos
                case 1:
                    insertarProfesor();
                    break;
                case 2:
                    insertarAlumno();
                    break;
                case 3:
                    buscarTodos();
                    break;
                case 4:
                    buscarProfes();
                    break;
                case 5:
                    buscarAlumnos();
                    break;
                case 6:
                    buscarAlumnoEmail();
                    break;
                case 7:
                    buscarProfesorEdad();
                    break;
                case 8:
                    actualizarProfe();
                    break;
                case 9:
                    bajaAlumnosAprobados();
                    break;
                case 10:
                    System.out.println("Finalizando programa");
                    break;
            }

        } while (opcion!=10);

    }


    private static void mostrarMenu(){
        System.out.println("Por favor, elija que desee hacer:");
        System.out.println("1.- Añadir profesor");
        System.out.println("2.- Añadir alumno");
        System.out.println("3.- Mostrar todos los profesores y alumnos");
        System.out.println("4.- Mostrar profesores");
        System.out.println("5.- Mostrar alumnos");
        System.out.println("6.- Buscar alumno por email");
        System.out.println("7.- Buscar profesor en un rango de edad");
        System.out.println("8.- Actualizar calificación el profesor identificado por email");
        System.out.println("9.- Dar de baja alumnos que hayan sacado un 5 o más");
        System.out.println("10.- Salir del programa");
    }

    private static void insertarProfesor(){
        System.out.println("Por favor, inserte los datos del profesor:");
        System.out.println("rating:");
        double rating = scanner.nextDouble();
        System.out.println("Edad:");
        int edad = scanner.nextInt();
        System.out.println("Nombre:");
        String nombre = scanner.next();
        System.out.println("Género:");
        String genero = scanner.next();
        System.out.println("Email:");
        String email = scanner.next();
        System.out.println("Teléfono:");
        String tel = scanner.next();
        System.out.println("Titulación:");
        String titulo = scanner.next();

        System.out.println("Añade las materias que imparte, escriba FIN no añadir más");
        ArrayList<String> materias = new ArrayList<>();
        while(!scanner.next().equalsIgnoreCase("fin")){
            System.out.println("Inserte materia");
            String materia = scanner.next();
            materias.add(materia);
        }

        profesorDAO.insertarUsuarioProfesor(new Profesor(rating,edad,nombre,genero,email,tel,materias,titulo));
    }

    private static void insertarAlumno(){
        System.out.println("Por favor, inserte los datos del alumno:");
        System.out.println("rating:");
        double rating = scanner.nextDouble();
        System.out.println("Edad:");
        int edad = scanner.nextInt();
        System.out.println("Nombre:");
        String nombre = scanner.next();
        System.out.println("Género:");
        String genero = scanner.next();
        System.out.println("Email:");
        String email = scanner.next();
        System.out.println("Teléfono:");
        String tel = scanner.next();
        System.out.println("Calificación:");
        int calificacion = scanner.nextInt();
        System.out.println("Curso en el que está matriculado:");
        String curso = scanner.next();

        alumnoDAO.insertarUsuarioAlumno(new Alumno(rating,edad,nombre,genero,email,tel,calificacion,curso));
    }

    private static void buscarTodos(){
        System.out.println("Mostrando todas las personas del centro");
        System.out.println("PROFESORES:");
        profesorDAO.getElementosProfesor();
        System.out.println("ALUMNOS:");
        alumnoDAO.getElementosAlumno();
    }

    private static void buscarProfes(){
        System.out.println("Mostrando PROFESORES:");
        profesorDAO.getElementosProfesor();
    }

    private static void buscarAlumnos(){
        System.out.println("Mostrando ALUMNOS:");
        alumnoDAO.getElementosAlumno();
    }


    private static void buscarAlumnoEmail(){
        System.out.println("Por favor, inserte el email del alumno:");
        String emailAlumno = scanner.next();
        alumnoDAO.buscarAlumno(emailAlumno);
    }

    private static void buscarProfesorEdad(){
        System.out.println("Vamos a buscar profesores entre 2 edades:");

        System.out.println("Por favor, inserte la edad más baja");
        int edad1 = scanner.nextInt();

        System.out.println("Por favor, inserte la edad más alta");
        int edad2 = scanner.nextInt();

        profesorDAO.getProfesoresEdad(edad1,edad2);
    }

    private static void actualizarProfe(){
        System.out.println("Se va a actualizar el rating del profesor:");
        System.out.println("Inserte el email del profesor a modificar");
        String emailProfe = scanner.next();
        System.out.println("Cual va a ser el nuevo rating del profesor");
        double rating = scanner.nextDouble();
        profesorDAO.actualizarProfesor(emailProfe, rating);
    }

    private static void bajaAlumnosAprobados(){
        System.out.println("Dando de baja a los alumnos aprobados");
        alumnoDAO.eliminarAlumno();
    }
}
