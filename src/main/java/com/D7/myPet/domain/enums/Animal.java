package com.D7.myPet.domain.enums;

public enum Animal {
    CACHORRO(0),
    GATO(1),
    AVE(2),
    PEIXE(3);

    private final int valor;
    private Animal(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }


}
