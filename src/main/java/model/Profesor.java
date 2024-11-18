package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

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

    @BsonProperty("subjects")
    private List subjects;

    @BsonProperty("title")
    private String title;


    public void mostrarDatos(){
        System.out.println("\trating= " + rating);
        System.out.println("\tage= " + age);
        System.out.println("\tname= " + name);
        System.out.println("\tgender= " + gender);
        System.out.println("\temail= " + email);
        System.out.println("\tphone= " + phone);
        System.out.println("\tsubjects= " + subjects);
        System.out.println("\ttitle= " + title + "\n");
    }
}
