package de.ardania.xcraftads.persistence;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Order {
    RANDOM,
    SORTED;

    public static Order fromString(String orderName) throws NoSuchElementException {
        return Arrays.stream(values())
            .filter(order -> order.name().equalsIgnoreCase(orderName))
            .findAny()
            .orElseThrow(
                () -> new NoSuchElementException("Unknown order \"" + orderName + "\"")
            );
    }
}
