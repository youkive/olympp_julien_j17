package olympp.kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonUseCasesTest {

    private final SolverService solverService = new SolverService();

    @Test
    void should_get_homme_avec_age_supp_18() {
        // given
        Person person1 = new Person(17, "irrelevant", "irrelevant", Genre.HOMME);
        Person person2 = new Person(18, "irrelevant", "irrelevant", Genre.FEMME);
        ;
        Person person3 = new Person(18, "irrelevant", "irrelevant", Genre.HOMME);
        List<Person> persons = List.of(person1, person2, person3);

        // when
        List<Person> reponse = solverService.getHommeAgeSupp18(persons);

        // then
        Assertions.assertThat(reponse).containsExactly(person3);
    }

    @Test
    void should_return_distinct_nom_prenom() {
        // given
        Person person1 = new Person(1, "dupont", "bryan", Genre.HOMME);
        Person person2 = new Person(1, "dupont", "johnson", Genre.HOMME);
        Person person3 = new Person(1, "dupont", "bryan", Genre.HOMME);
        List<Person> persons = List.of(person1, person2, person3);

        // when
        List<String> uniqNomPrenom = solverService.getUniqNomPrenom(persons);

        // then
        Assertions.assertThat(uniqNomPrenom).containsExactlyInAnyOrder("bryan dupont" , "johnson dupont");
    }

    @Test
    void should_get_average_age() {
        // given
        Person person1 = new Person(12, "irrelevant", "irrelevant", Genre.HOMME);
        Person person2 = new Person(17, "irrelevant", "irrelevant", Genre.HOMME);
        Person person3 = new Person(16, "irrelevant", "irrelevant", Genre.HOMME);
        List<Person> persons = List.of(person1, person2, person3);
        // when
        Double averageAge = solverService.getAverageAge(persons);

        // then
        Assertions.assertThat(averageAge).isEqualTo(15);
    }

    @Test
    void should_get_median_age() {
        // given
        Person person1 = new Person(12, "irrelevant", "irrelevant", Genre.HOMME);
        Person person2 = new Person(17, "irrelevant", "irrelevant", Genre.HOMME);
        Person person3 = new Person(16, "irrelevant", "irrelevant", Genre.HOMME);
        List<Person> persons = List.of(person1, person2, person3);
        // when
        Integer averageAge = solverService.getMedianAge(persons);

        // then
        Assertions.assertThat(averageAge).isEqualTo(16);
    }


}
