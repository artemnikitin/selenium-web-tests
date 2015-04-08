package exness;

public enum Sections {

    CONVERTER("converter"),
    CALCULATOR("calculator");

    private final String type;

    Sections(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
