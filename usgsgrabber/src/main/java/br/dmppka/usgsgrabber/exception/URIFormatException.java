package br.dmppka.usgsgrabber.exception;

public class URIFormatException extends RuntimeException {

    public URIFormatException(String uri) {
        super("Wrong URI format: " + uri);
    }
}