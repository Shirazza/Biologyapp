package com.example.shira.biologyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class credits extends AppCompatActivity {

    TextView credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        credits= (TextView) findViewById(R.id.credits);
        String s="כל הזכויות ליצירת האפליקציה שמורות לשירז זפרני" + "\n מכיתה יא5" + "\n התמונות נלקחו מגוגל תמונות" +
                "\n המידע נלקח מסיכומים הנכתבו על ידי לאה קרמני";
        credits.setText(s);
        finish();
    }
}
