package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

        @BsonProperty("rating")
        private double rating;

        @BsonProperty("age")
        private int age;

        @BsonProperty("name")
        private String name;

        @BsonProperty("gender")
        private String gender;

        @BsonProperty("email")
        private String email;

        @BsonProperty("phone")
        private String phone;

        @BsonProperty("calificaation")
        private int calificaation;

        @BsonProperty("higher_grade")
        private String higher_grade;


        public void mostrarDatos(){
                System.out.println("\trating= " + rating);
                System.out.println("\tage= " + age);
                System.out.println("\tname= " + name);
                System.out.println("\tgender= " + gender);
                System.out.println("\temail= " + email);
                System.out.println("\tphone= " + phone);
                System.out.println("\tcalificaation= " + calificaation);
                System.out.println("\thigher_grade= " + higher_grade + "\n");
        }
}
