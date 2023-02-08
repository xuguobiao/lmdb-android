package com.openland.lmdb;

import android.text.TextUtils;

/**
 * @author Kido
 * @create 2/8/23 2:48 PM
 */
public class LMDBTransaction {
    private final long id;
    private final LMDBJNI jni;

    public LMDBTransaction(long id, LMDBJNI jni) {
        this.id = id;
        this.jni = jni;
    }

    public final LMDBDatabase openDatabase() {
        return this.openDatabase(null);
    }

    public final LMDBDatabase openDatabase(String name) {
        if (TextUtils.isEmpty(name)) {
            name = "default";
        }
        return new LMDBDatabase(this.jni.openDatabase(this.id, name), this.jni);
    }

    public final void commit() {
        this.jni.commitTx(this.id);
    }

    public final void abort() {
        this.jni.abortTx(this.id);
    }

    public final long getId() {
        return this.id;
    }


}
