package org.example;

public class VotoObrigatorio {

    public static String vote(int idade){
        if (idade >= 18 && idade <= 70 ) return "Voto Obrigatório";
        else if ((idade >= 16 &&  idade < 18) || (idade > 70)) return "Voto facultativo";
        else if (idade <= 0) return "Digite uma idade válida (deve ser maior do que zero)";
        else return "Sem direito a votar";
    }
}
