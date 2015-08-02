package br.dmppka.usgsgrabber.exception;

public class DateParseException extends RuntimeException {

    public DateParseException(String date) {
        super("Error while parsing date: " + date);
    }
}