package com.openland.lmdb;


/**
 * @author Kido
 * @create 2/8/23 2:39 PM
 */
final class LMDBJNI {

    // Environment

    public final native long createEnv();

    public final native void openEnv(long envId, String path);

    public final native void closeEnv(long envId);

    // Transactions

    public final native long beginTx(long envId, boolean readonly);

    public final native void commitTx(long txId);

    public final native void abortTx(long txId);

    // Database

    public final native long openDatabase(long txId, String name);

    // Operations

    public final native void put(long txId, long dbId, String key, String value);

    public final native String get(long txId, long dbId, String key);

}
