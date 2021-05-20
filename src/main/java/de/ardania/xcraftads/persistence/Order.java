package de.ardania.xcraftads.persistence;

public enum Order {
    RANDOM,
    SORTED,
    UNKNOWN;

    public static Order getOrderFromString(String orderName) {
        if (RANDOM.name().equalsIgnoreCase(orderName)) {
            return RANDOM;
        } else if (SORTED.name().equalsIgnoreCase(orderName)) {
            return SORTED;
        } else {
            return UNKNOWN;
        }
    }
}
