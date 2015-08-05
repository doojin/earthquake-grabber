package br.dmppka.usgsgrabber;

public class ResponseFormat {

    public static ResponseFormat XML = new ResponseFormat(1L, "xml");

    private long id;
    private String value;

    private ResponseFormat(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseFormat that = (ResponseFormat) o;
        return this.id == that.getId();

    }
}