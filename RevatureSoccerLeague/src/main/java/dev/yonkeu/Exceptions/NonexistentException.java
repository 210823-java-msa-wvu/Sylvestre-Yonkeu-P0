package dev.yonkeu.Exceptions;

public class NonexistentException extends RuntimeException{
    public NonexistentException(){
        super ("User doesn't exist. Try again");
    }

}
