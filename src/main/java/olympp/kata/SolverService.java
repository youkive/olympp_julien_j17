package olympp.kata;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolverService {
    public List<Person> getHommeAgeSupp18(List<Person> persons) {
        return persons.stream().filter(person -> person.getAge() >= 18 && person.getGenre() == Genre.HOMME).toList();
    }


    public List<String> getUniqNomPrenom(List<Person> persons) {
        return persons.stream().distinct().map(Person::getPrenomNom).toList();
    }

    public Double getAverageAge(List<Person> persons) {
        return persons.stream().mapToInt(Person::getAge).average().getAsDouble();

    }

    public Integer getMedianAge(List<Person> persons) {
        return persons.stream().mapToInt(Person::getAge).sorted().limit(persons.size() / 2 + 1).max().getAsInt();
    }

    public Map<Integer, Integer> getNbPieceParCodePostal(List<Maison> maisons) {
        return maisons.stream()
                .collect(Collectors.groupingBy(Maison::getCodePostal))
                .entrySet().stream()
                .map(entry -> Map.entry(entry.getKey(), entry.getValue().stream().mapToInt(Maison::getNbPieces).sum()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Maison getMaisonWithMaxPieceParEtage(List<Maison> maisons) {
        return maisons.stream().min((m1, m2) -> m2.getNbPiecesParEtage() - m1.getNbPiecesParEtage()).get();
    }

    public Map<Integer, List<Maison>> getMaisonPlusChaudParCodePostal(List<Maison> maisons) {
        return maisons.stream().collect(Collectors.groupingBy(Maison::getCodePostal))
                .entrySet().stream()
                .map(entry -> {
                    int maxTemp = entry.getValue().stream().mapToInt(Maison::getTemperature).max().getAsInt();
                    return Map.entry(entry.getKey(), entry.getValue().stream().filter(maison -> maison.getTemperature() == maxTemp).toList());
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
