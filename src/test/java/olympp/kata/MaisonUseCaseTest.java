package olympp.kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class MaisonUseCaseTest {

    private final SolverService solver = new SolverService();

    @Test
    void should_return_nbrPiece_par_codePostal() {
        // given
        Maison maison1 = new Maison(1, 0, 0, 0,75014);
        Maison maison2 = new Maison(3, 0, 0, 0,75014);
        Maison maison3 = new Maison(8, 0, 0, 0,75015);
        List<Maison> maisons = List.of(maison1, maison2, maison3);

        // when
        Map<Integer, Integer> nbPieceParCodePostal = solver.getNbPieceParCodePostal(maisons);

        // then
        Map<Integer, Integer> expected = Map.of(75014, 4, 75015, 8);
        Assertions.assertThat(nbPieceParCodePostal).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    void should_return_maison_avec_max_piece_par_etage(){
        // given
        Maison maison1 = new Maison(1, 0, 1, 0,75014);
        Maison maison2 = new Maison(3, 0, 2, 0,75014);
        Maison maison3 = new Maison(8, 0, 3, 0,75015);
        List<Maison> maisons = List.of(maison1, maison2, maison3);

        // when
        Maison result = solver.getMaisonWithMaxPieceParEtage(maisons);

        // then
        Assertions.assertThat(result).isEqualTo(maison3);
    }

    @Test
    void should_return_maison_plus_chaud_par_code_postal() {
        // given
        Maison maison1 = new Maison(1, 0, 1, 5,75014);
        Maison maison2 = new Maison(3, 0, 2, 35,75014);
        Maison maison3 = new Maison(8, 0, 3, 2,75015);
        Maison maison4 = new Maison(8, 0, 3, 2,75015);

        List<Maison> maisons = List.of(maison1, maison2, maison3, maison4);

        // when
        Map<Integer, List<Maison>> result = solver.getMaisonPlusChaudParCodePostal(maisons);

        // then
        Map<Integer, List<Maison>> expected = Map.of(75014, List.of(maison2), 75015, List.of(maison3, maison4));
        Assertions.assertThat(result).containsExactlyInAnyOrderEntriesOf(expected);
    }
}
