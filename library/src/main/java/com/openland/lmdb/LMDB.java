package com.openland.lmdb;


import android.content.Context;

/**
 * @author Kido 
 * @create 2/8/23 2:12 PM
 */
public class LMDB {

    private static final class Holder {
        private static final LMDB INSTANCE = new LMDB();
    }

    public static LMDB getInstance() {
        return Holder.INSTANCE;
    }

    private LMDBJNI mJNI;

    private LMDB() {
        System.loadLibrary("lmdbjni");
        mJNI = new LMDBJNI();
    }

    public void init() {
        // do something.
    }

    private LMDBJNI getJni() {
        return mJNI;
    }

    public final LMDBEnvironment createEnvironment(Context context) {
        String path = context.getFilesDir().getAbsolutePath() + "/app_lmdb.db";
        return createEnvironment(path);
    }

    public final LMDBEnvironment createEnvironment(String path) {
        long id = this.getJni().createEnv();
        this.getJni().openEnv(id, path);
        return new LMDBEnvironment(id, this.getJni());
    }


}
