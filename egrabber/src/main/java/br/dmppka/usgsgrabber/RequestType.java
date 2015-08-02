package br.dmppka.usgsgrabber;

public class RequestType {

    public static RequestType CSV = new RequestType(1L, "csv");
    public static RequestType GEO_JSON = new RequestType(2L, "geojson");
    public static RequestType KML = new RequestType(3L, "kml");
    public static RequestType TEXT = new RequestType(4L, "text");
    public static RequestType XML = new RequestType(5L, "xml");

    private long id;
    private String value;

    private RequestType(long id, String value) {
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

        RequestType that = (RequestType) o;

        return this.id == that.getId();

    }
}