package com.trinhha.demo.itblog.Exception;

import lombok.extern.java.Log;

@Log
public class InvalidWordException extends Exception {

    private static final long serialVersionUID = -3128681006635769411L;

    public InvalidWordException(String message) {
        super(message);
    }
}
