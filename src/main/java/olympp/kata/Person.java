package olympp.kata;

import java.util.Objects;

public class Person {

    private final Integer age;

    private final String nom;

    private final String prenom;

    private final Genre genre;

    public Person(Integer age, String nom, String prenom, Genre genre) {
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
    }

    public String getPrenomNom() {
        return this.prenom + " " + this.nom;
    }

    public Integer getAge() {
        return age;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(nom, person.nom) && Objects.equals(prenom, person.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }
}
