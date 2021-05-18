package de.ardania.xcraftads.persistence;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class Ad implements Serializable {

    private UUID uuid;
    private String message;
    private int broadcasts;
}
