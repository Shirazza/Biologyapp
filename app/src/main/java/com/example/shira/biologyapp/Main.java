package com.example.shira.biologyapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main extends AppCompatActivity implements View.OnCreateContextMenuListener {

    AlertDialog.Builder adb;
    Button gotoSI;
    EditText name;
    String st;
    RadioButton Op1;
    RadioButton Op2;
    Intent t, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        gotoSI= (Button) findViewById(R.id.gotoSI);
        Op1= (RadioButton) findViewById(R.id.Op1);
        Op2= (RadioButton) findViewById(R.id.Op2);
        t= new Intent(this, systemInfo.class);
        t2= new Intent(this, betweenSystems.class);
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
        return  super.onContextItemSelected(item);
    }

    public void gotoSI(View view) {
        st=name.getText().toString();
        adb=new AlertDialog.Builder(this);
        adb.setTitle("המשך הפעילות");
        if (Op1.isChecked())
            adb.setMessage("שלום,"+ st+ ". בחרת במידע על מערכות. האם אתה בטוח שאתה רוצה להמשיך?");
        else
            adb.setMessage("שלום,"+ st+ ". בחרת במידע על קשרים בין מערכות. האם אתה בטוח שאתה רוצה להמשיך?");
        adb.setIcon(R.drawable.qmark);
        adb.setPositiveButton("כן", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(Op1.isChecked()){
                   t.putExtra("name", st);
                   startActivity(t);
                }
                else{
                    t2.putExtra("name", st);
                    startActivity(t2);
                }

            }
        });
        adb.setNegativeButton("לא", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              dialogInterface.cancel();
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }
}
