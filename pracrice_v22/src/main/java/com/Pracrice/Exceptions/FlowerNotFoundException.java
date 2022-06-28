package com.Pracrice.Exceptions;

public class FlowerNotFoundException extends RuntimeException{

    FlowerNotFoundException(int ID){
        super("Could not find flower"+ID);
    }
}
