package com.suthar.jay.testapp;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_main);
        LL = findViewById(R.id.LL);

        LL.setOnTouchListener(new View.OnTouchListener() {
            StringBuilder res = new StringBuilder();

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    int loc[] = new int[2];
                    LL.getLocationOnScreen(loc);
                    int h = LL.getHeight();
                    int w = LL.getWidth();
                    int ractW = w / 3;
                    int racrH = h / 4;
                    mRectangle r1 = new mRectangle(racrH, ractW, loc[0], 0);
                    mRectangle r2 = new mRectangle(racrH, ractW, loc[0] + ractW, 0);
                    mRectangle r3 = new mRectangle(racrH, ractW, loc[0] + ractW + ractW, 0);
                    mRectangle r4 = new mRectangle(racrH, ractW, loc[0], 0 + racrH);
                    mRectangle r5 = new mRectangle(racrH, ractW, loc[0] + ractW, 0 + racrH);
                    mRectangle r6 = new mRectangle(racrH, ractW, loc[0] + ractW + ractW, 0 + racrH);
                    mRectangle r7 = new mRectangle(racrH, ractW, loc[0], 0 + racrH + racrH);
                    mRectangle r8 = new mRectangle(racrH, ractW, loc[0] + ractW, 0 + racrH + racrH);
                    mRectangle r9 = new mRectangle(racrH, ractW, loc[0] + ractW + ractW, 0 + racrH + racrH);
                    mRectangle rStar = new mRectangle(racrH, ractW, loc[0], 0 + racrH + racrH + racrH);
                    mRectangle r0 = new mRectangle(racrH, ractW, loc[0] + ractW, 0 + racrH + racrH + racrH);
                    mRectangle rHash = new mRectangle(racrH, ractW, loc[0] + ractW + ractW, 0 + racrH + racrH + racrH);
                    int x = Math.round(motionEvent.getX());
                    int y = Math.round(motionEvent.getY());
                    if (r1.contains(x, y)) {
                        res.append(1);
                    } else if (r2.contains(x, y)) {
                        res.append(2);
                    } else if (r3.contains(x, y)) {
                        res.append(3);
                    } else if (r4.contains(x, y)) {
                        res.append(4);
                    } else if (r5.contains(x, y)) {
                        res.append(5);
                    } else if (r6.contains(x, y)) {
                        res.append(6);
                    } else if (r7.contains(x, y)) {
                        res.append(7);
                    } else if (r8.contains(x, y)) {
                        res.append(8);
                    } else if (r9.contains(x, y)) {
                        res.append(9);
                    } else if (r0.contains(x, y)) {
                        res.append(0);
                    } else if (rStar.contains(x, y)) {
                        res.delete(0, res.length());
                        Toast.makeText(getApplicationContext(), "Clear", Toast.LENGTH_SHORT).show();
                    } else if (rHash.contains(x, y)) {
                        res.append("#");
                    } else {
                        return false;
                    }

                    if (res.length() >= "123456789".length()) {
                        if (res.toString().equals("123456789")) {
                            Toast.makeText(getApplicationContext(), "Enter", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        });


    }
}
