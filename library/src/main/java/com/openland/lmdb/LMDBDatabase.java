package com.openland.lmdb;

/**
 * @author Kido
 * @create 2/8/23 2:46 PM
 */
public class LMDBDatabase {
    private final long id;
    private final LMDBJNI jni;

    public LMDBDatabase(long id, LMDBJNI jni) {
        this.id = id;
        this.jni = jni;
    }

    public final void put(LMDBTransaction tx, String key, String value) {
        this.jni.put(tx.getId(), this.id, key, value);
    }

    public final String get(LMDBTransaction tx, String key) {
        return this.jni.get(tx.getId(), this.id, key);
    }

    public final long getId() {
        return this.id;
    }

}
