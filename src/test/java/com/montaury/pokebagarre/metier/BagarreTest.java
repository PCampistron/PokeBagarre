package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.erreurs.ErreurPokemonNonRenseigne;
import com.montaury.pokebagarre.webapi.PokeBuildApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class BagarreTest {
    private static Bagarre bagarre;
    private static PokeBuildApi pokeBuildApi;

    @BeforeAll
    static void prepare()
    {
        pokeBuildApi = Mockito.mock(PokeBuildApi.class);

        bagarre = new Bagarre();
    }

    @Test
    void tester_demarrer_nom1_vide()
    {
        Throwable thrown = catchThrowable(() -> bagarre.demarrer("", "Carapuce") );
        assertThat(thrown).isInstanceOf(ErreurPokemonNonRenseigne.class).hasMessage("Le premier pokemon n'est pas renseigne");
    }

    @Test
    void tester_demarrer_nom2_vide()
    {
        Throwable thrown = catchThrowable(() -> bagarre.demarrer("Carapuce", "") );
        assertThat(thrown).isInstanceOf(ErreurPokemonNonRenseigne.class).hasMessage("Le second pokemon n'est pas renseigne");
    }

    @Test
    void tester_recuperation_nom_bagarre()
    {
        /*

        // GIVEN
        var futurVainqueur = new Pokemon("Pikachu", null, null);
        Pokemon pokemon;

        // WHEN
        Mockito.when(pokeBuildApi.recupererParNom("pikachu")).thenReturn(CompletableFuture.completedFuture(new Pokemon("pikachu", "url1", new Stats(1, 2))));

        // THEN
        assertThat(futurVainqueur).satisfies(pokemon->{assertThat(pokemon.getNom()).isEqualTo("Pikachu");}) ;

         */
    }
}