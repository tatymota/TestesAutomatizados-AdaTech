package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


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

//----------------------------------------------------




