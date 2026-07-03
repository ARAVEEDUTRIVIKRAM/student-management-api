package com.trivikram.springbootdemo.exception;

// RunTime Exception is like built in parernt that represents errors occurring during the execution of the program.
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        // Super is to refer the parent class ( Runtimeexception)
        super(message);
    }


}
