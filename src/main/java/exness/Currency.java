package exness;

public enum Currency {

    USD("USD"),
    EUR("EUR"),
    CHF("CHF");

    private final String type;

    Currency(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
