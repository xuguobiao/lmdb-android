package com.openland.lmdb;

/**
 * @author Kido
 * @create 2/8/23 2:45 PM
 */
public class LMDBEnvironment {
    private final long id;
    private final LMDBJNI jni;

    public LMDBEnvironment(long id, LMDBJNI jni) {
        super();
        this.id = id;
        this.jni = jni;
    }

    public final LMDBTransaction startTransaction() {
        return this.startTransaction(false);
    }

    public final LMDBTransaction startTransaction(boolean readonly) {
        return new LMDBTransaction(this.jni.beginTx(this.id, readonly), this.jni);
    }

    public final void close() {
        this.jni.closeEnv(this.id);
    }

    public final long getId() {
        return this.id;
    }


}
