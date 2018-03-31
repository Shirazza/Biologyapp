package com.example.shira.biologyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class betweenSystems extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener{

    Intent get, gm;
    String pName, conInfo;
    TextView HnameC, information;
    ListView options;
    String [] systems={"הקשר בין מערכת ההובלה למערכת הנשימה", "הקשר בין מערכת הנשימה למערכת העיכול", "הקשר בין מערכת ההובלה למערכת העיכול", "הקשר בין מערכת ההובלה למערכת ההפרשה הפנימית","הקשר בין מערכת ההבולה למערכת ההפרשה החיצונית" ,"הקשר בין מערכת ההובלה למערכת החיסון"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_between_systems);

        HnameC=(TextView) findViewById(R.id.HnameC);
        information=(TextView) findViewById(R.id.information);
        options=(ListView) findViewById(R.id.options);

        get= getIntent();
        pName= get.getStringExtra("name");
        HnameC.setText("שלום"+ pName+", בחר קשר בין מערכות:");

        options.setOnItemClickListener(this);
        options.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp= new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, systems);
        options.setAdapter(adp);
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

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        switch (position){
            case 1: { conInfo="אחד מהתפקידים החשובים של מערכת הדם הוא לספק לתאים את החמצן המשמש לנשימה התאית, זהו התהליך הנותן אנרגיה לגוף ובלעדיו לא ייתכנו חיים. במקביל מערכת הדם מסלקת מהתאים פחמן-דו-חמצני הנפלט בתהליך הנשימה התאית ומהווה פסולת. האוויר המכיל חמצן חודר לריאות דרך הקנה ועד לנאדיות הקטנות שם דרך הקרומים של הנאדיות וכלי הדם העדינים החמצן והפחמן הדו-חמצני עוברים פעפוע על פי מפל הריכוזים מהנאדיות לדם (חמצן) ומהדם לנאדיות (פחמן דו חמצני).";
                      information.setText(conInfo); break;}
            case 2: { conInfo="מערכת הנשימה משתתפת במערכת העיכול על ידי אספקת אנרגיה לתאים. החמצן שנקלט בריאות מפעפע דרך מערכת ההובלה לתוך תאי הגוף ובתאים מתקיימת הנשימה התאית מה שמספק לתאים את האנרגיה לפירוק של אבות המזון.";
                information.setText(conInfo); break;}
            case 3: { conInfo="המרכיבים של אבות המזון נספגים במעי הדק למערכת ההובלה משם הם מובלים לכל התאים ונספגים מהנימים אל תוך תאי הגוף על ידי מעבר חומרים. הדבר מאפשר למערכת העיכול להעביר אנרגיה לתאים דרך מערכת ההובלה.";
                information.setText(conInfo); break;}
            case 4: { conInfo="ההורמונים השונים מופרשים מבלוטות הפרשה פנימיות שונות אל הדם (כמו הלבלב, ההיפתלמוס), ההורמונים מועברים דרך הדם אל כל חלקי הגוף ונקשרים לתאי המטרה שלהם על מנת להפעיל אותם. ";
                information.setText(conInfo); break;}
            case 5: { conInfo="תפקידה של מערכת ההפרשה הוא לסנן את הדם ולהפריש החוצה את כל החומרים המומסים בדם שהם פסולת. הדם עובר מהנימים אל הקופסית בנפרונים שבכליה ובשלב השני חוזרים חומרים מן האבובית שבנפרון שבכליה חזרה אל הדם.";
                    information.setText(conInfo); break;}
            case 6: { conInfo="תאי הדם הלבנים שהם המרכיב העיקרי של מערכת החיסון של הגוף אחראיים להגנה על הגוף מגורמים זרים העלולים לפלוש אליו. תאי הדם הלבנים זורמים בפלסמה שבדם והם מסוגלים לצאת דקך דפנות כלי הדם ולנדוד ברקמות כשהם קולטים מידע על נוכחות גורם זר.";
                information.setText(conInfo); break;}

}}

    public void backtobeg(View view) {
       gm= new Intent(this, Main.class);
       startActivity(gm);
       finish();
    }
    }
