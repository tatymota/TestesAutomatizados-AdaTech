package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;

import static org.example.VotoObrigatorio.vote;
import static org.junit.jupiter.api.Assertions.*;

class VotoObrigatorioTest {

    @Test
    void votoObrigatorio() {
        String votoObrigatorio = "Voto Obrigatório";
        assertEquals(votoObrigatorio, vote(18));
        assertEquals(votoObrigatorio, vote(35));
        assertEquals(votoObrigatorio, vote(70));
    }

    @Test
    void votoObrigatorioComAssertAll() {
        String votoObrigatorio = "Voto Obrigatório";
        assertAll(
                () -> assertEquals(vote(18), votoObrigatorio),
                () -> assertEquals(vote(35), votoObrigatorio),
                () ->  assertEquals(vote(70), votoObrigatorio)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = { 18, 35, 70})
    void oVotoEhObrigatorio(int idade) {
        String votoObrigatorio = "Voto Obrigatório";
        assertEquals(votoObrigatorio, vote(idade));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "15, Sem direito a votar",
            "16, Voto facultativo",
            "17, Voto facultativo",
            "18, Voto Obrigatório",
            "30, Voto Obrigatório",
            "70, Voto Obrigatório",
            "71, Voto facultativo",
            "80, Voto facultativo"})
    void quemPodeVotarCsvSource(int idade, String expected) {
        String result = vote(idade);
        assertEquals(result, expected);
    }

    private static Stream<Arguments> voteConditions() {
        return Stream.of(
                Arguments.of(15, "Sem direito a votar"),
                Arguments.of(16, "Voto facultativo"),
                Arguments.of(17, "Voto facultativo"),
                Arguments.of(18, "Voto Obrigatório"),
                Arguments.of(30, "Voto Obrigatório"),
                Arguments.of(70, "Voto Obrigatório"),
                Arguments.of(71, "Voto facultativo"),
                Arguments.of(80, "Voto facultativo")
        );
    }
    @ParameterizedTest
    @MethodSource("voteConditions")
    public void testMethodSourceVoto (int idade, String expected){
        String result = VotoObrigatorio.vote(idade);
        assertEquals(result, expected);
    }






    @Test
    void votoFacultativo() {
       String votoFacultativo = "Voto facultativo";
       assertEquals(votoFacultativo, vote(16));
        assertEquals(votoFacultativo, vote(17));
        assertEquals(votoFacultativo, vote(71));
    }

    @ParameterizedTest
    @ValueSource(ints = { 16, 17, 71})
    void oVotoEhFacultativo(int idade) {
        String votoFacultativo = "Voto facultativo";
        assertEquals(votoFacultativo, vote(idade));
    }

    @Test
    void semDireitoAVoto() {
        String semDireitoAVoto = "Sem direito a votar";
        assertEquals(semDireitoAVoto, vote(15));
    }
    @ParameterizedTest
    @ValueSource(ints = { 15, 14})
    void naoPodeVotar(int idade) {
        String semDireitoAVoto = "Sem direito a votar";
        assertEquals(semDireitoAVoto, vote(idade));
    }
}





