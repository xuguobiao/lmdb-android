package com.openland.lmdb.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.openland.lmdb.LMDB;
import com.openland.lmdb.LMDBDatabase;
import com.openland.lmdb.LMDBEnvironment;
import com.openland.lmdb.LMDBTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LMDB.getInstance().init();

        LMDBEnvironment env = LMDB.getInstance().createEnvironment(this);
        LMDBTransaction tx = env.startTransaction();
        LMDBDatabase db = tx.openDatabase();
        db.put(tx, "kido1", "kido1 value 测试");
        db.put(tx, "kido2", "kido2 value 测试");
        tx.commit();

        tx = env.startTransaction(true);
        String v = db.get(tx, "kido1");
        android.util.Log.d("kido", "kido1->" + v);
        tx.abort();
        env.close();

    }
}