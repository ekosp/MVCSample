package com.ekosp.mvcsample;

/**
 * Created by Eko Setyo Purnomo on 08-Mar-18.
 * Find me on https://ekosp.com
 * Or email me directly to ekosetyopurnomo@gmail.com
 */

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class MVCSplash extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_splash);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent
                            ("com.ekosp.mvcsample.MVCView");
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}