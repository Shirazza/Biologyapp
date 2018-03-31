package com.example.shira.biologyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class systemConInfo extends AppCompatActivity implements View.OnCreateContextMenuListener{

    ImageView theSystem;
    TextView theInfo;
    Button backtoSI;
    Intent gi, go;
    String filen,str;
    int sys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_con_info);
        theSystem= (ImageView) findViewById(R.id.theSystem);
        theInfo= (TextView) findViewById(R.id.theInfo);
        backtoSI= (Button) findViewById(R.id.backtoSI);

        gi=getIntent();
        filen= gi.getStringExtra("the file");
        sys= gi.getIntExtra("num", 0);

        switch(sys){
            case 1: theSystem.setImageResource(R.drawable.bloods2); break;
            case 2: theSystem.setImageResource(R.drawable.airs2); break;
            case 3: theSystem.setImageResource(R.drawable.endocrines2); break;
            case 4: theSystem.setImageResource(R.drawable.pees2); break;
            case 5: theSystem.setImageResource(R.drawable.foods2); break;
            case 6: theSystem.setImageResource(R.drawable.immunes2);
        }

        InputStream is= null;
        try {
            is = openFileInput(filen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader tmp= new InputStreamReader(is);
        BufferedReader reader=new BufferedReader(tmp);
        StringBuffer buffer=new StringBuffer();
        try {
            while ((str=reader.readLine()) != null){
                buffer.append(str+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        theInfo.setText(buffer);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.add("קרדיטים");
    }

    public boolean onContextItemSelected(MenuItem item){
        String op= item.getTitle().toString();
        if(op.equals("קרדיטים")){
            Intent gocred= new Intent(this, credits.class);
            startActivity(gocred);
        }
        return  super.onContextItemSelected(item);}

    public void backtoSI(View view) {
      go= new Intent(this, systemInfo.class);
      startActivity(go);
      finish();
    }
}
