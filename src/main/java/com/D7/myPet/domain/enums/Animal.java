package com.D7.myPet.domain.enums;

public enum Animal {
    CACHORRO(0),
    GATO(1),
    AVE(2),
    PEIXE(3);

    private final int code;
    private Animal(int valor) {
        this.code = valor;
    }

    public int getCode() {
        return this.code;
    }

    public static Animal valueOff(int code){
        for(Animal value: Animal.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Animal code");
    }


}
