package com.openland.lmdb;

/**
 * @author Kido
 * @create 2/8/23 2:21 PM
 */
public class LMDBException extends Exception {
    private final int id;

    public final int getId() {
        return this.id;
    }

    public LMDBException(String message, int id) {
        super(message);
        this.id = id;
    }
}
