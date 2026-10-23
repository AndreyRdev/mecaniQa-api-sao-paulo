package br.com.mecaniQA.api.exception;

public class ErroPersistenciaException extends RuntimeException {
    public ErroPersistenciaException(String message, Throwable cause) { super(message, cause); }
}
