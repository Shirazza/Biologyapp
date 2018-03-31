package com.example.shira.biologyapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class systemInfo extends AppCompatActivity implements View.OnCreateContextMenuListener {

    TextView Hname;
    ImageButton gowH, gowL, gowP, gowE, gowI, gowF;
    Button backtoMain;
    Intent gi, t3, gofor;
    String name, Info, filename;
    int x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        Hname= (TextView) findViewById(R.id.Hname);
        gowH= (ImageButton) findViewById(R.id.gowH);
        gowL= (ImageButton) findViewById(R.id.gowL);
        gowP= (ImageButton) findViewById(R.id.gowP);
        gowE= (ImageButton) findViewById(R.id.gowE);
        gowI= (ImageButton) findViewById(R.id.gowI);
        gowF= (ImageButton) findViewById(R.id.gowF);
        backtoMain= (Button) findViewById(R.id.backtoMain);

        gofor= new Intent(this, systemConInfo.class);
        gi= getIntent();
        name=gi.getStringExtra("name");
        Hname.setText("שלום" + name+ ", בחר מערכת:");

        filename="systemsInfo.txt";
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

    public void choseair(View view) {
        x=2;
        Info="תפקידה הוא להכניס לגוף אוויר עשיר בחמצן ולהוציא אוויר עשיר בפחמן. תפקיד האף הוא סינון אוויר. באף יש ריסים שמסננים את האוויר, ריר דביק ולח שעושה את האוויר לח יותר ומדביק חיידשקים וזיהומים. תפקיד קנה הנשימה והסימפונות הוא להכניס אוויר לריאות. בקנה יש ריסים שמסלקים החוצה גורמים זרים כמו אבק וחיידקים, הקנה עושה את האוויר לח יותר והטמפרטורה של האוויר נעשית דומה יותר לטמפרטורת הגוף. לקנה גם יש טבעות סחוש שמשאירות אותו פתוח כך שהדפנות שלו לא יקרסו. הלוע הוא איזור הכניסה לקנה הנשימה אליו מגיע האוויר שנכנס דרך האף והפה. השקדים הם בלוטות לימפה שמייצרות תאי דם לבנים שיכולים לבלוע גורמים זרים שחדרו ללוע. מכסה הגרון (הגלוטיס) הוא לשוניץ המכסה את פתח קנה הנשימה בעת בליעת המזון. לבסוף, הריאות בהן מתרחש חילוף הגזים בין נאדיות הריאה לדפ. הריאות בנויות משקיקים רבים הנקראים נאדיות הריאה שמגדילות את שטח הפנים של הריאות ולכן פעפוע הגזים יעיל ומהיר יותר. נימי דם רבים מאוד וצמודים לנאדיות גורמים למרחק פעפוע קצר. גם לנימי הדם וגם לנאדיות הריאה יש דופן הבנויה משכבת תאים אחת מה שעוזר למרחק פעפוע קצר. שרירי הנשימה הם שריר הסרעפת והשרירים הבין צלעתיים. התרחבות והתכווצות הריאות מאפשרים שאיפה ונשיפה, שריר הסרעפת מתחת לריאות עולה ותורם לכיווץ הריאות ובהרפיה שלו יורד ומרחיב את הריאות. תהליך השאיפה הוא תהליך הכנסת האוויר לריאות. תהליך השאיפה הוא תהליך אקטיבי המתרחש בזכות התכווצות שרירי הנשימה בין הצלעות ושריר הסרעפת בעקבות אות מהמוח. תהליך הנשיפה הוא תהליך הוצאת האוויר מהריאות. תהליך הנשיפה הוא תהליך פסיבי המתרחש לאחר התכווצות השרירים.";
        FileOutputStream fos= null;
        try {
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw= new OutputStreamWriter(fos);
        BufferedWriter bw= new BufferedWriter(osw);
        try {
            bw.write(Info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t3= new Intent(this, systemConInfo.class);
        t3.putExtra("the file", filename);
        t3.putExtra("num", x);
        startActivity(t3);
    }

    public void choseblood(View view) {
        x=1;
        Info="תפקידה הוא להוביל חומרים אל התאים ומהתאים. קיימים שני מחזורי דם: מחזור הדם הגדול שמספק חמצן לכל תאי הגוף ואוסף מהם את הפחמן הדו חמצני שנוצר בנשימה תאית ומחזור הדם הקטן שמוציא מהגוף את הפחמן הדו חמצני ומכניס לגוף חמצן. כלי הדם הם: העורקים שבהם הדם זורם מן הלב, הדפנות שלהם עבות ואלסטיות וכך מאפשרות התרחבות וחזרה לקוטר המקורי כדי לאפשר זרימת דם למרות הלחץ דם הגבוה בהם, האלסטיות מקנה עמידות בלחץ ומאפשרת זרימה מהירה. הורידים שבהם הדם זורם אל הלב, עליית הדם בורידים מהרגליים לכיוון הלב, נגד כוח המשיכה, מתאפשרת בזכות לחץ שרירי השלד על הורידים ודחיפת הדם למעלה לכיוון הלב, בנוסף בורידים יש מסתמים המונעים ירידה של הדם בחזרה לרגליים. והנימים שמקשרים בין העורקים והורידים, הנימים מאוד צרים כך שתאי הדם האדומים עוברים בתור ונוגעים בדפנות והחמצן יכול לצאת מהנימים לתאים בקלות, הנימים בנויים משכבת תאים אחת בלבד כך שמתאפשר מעבר יעיל של חומרים בעזרת מרחק הפעפוע הקצר. בנוסף, שטח החתך הכולל של הנימים יותר גדול משטח החתך של העורקיק ממנו התפצלו ולכן מהירות הזרימה בנימים היא איטית מאוד והדבר מאפשר מעבר חומרים יעיל.  אבי העורקים הוא העורק הראשי שמזרים דם עשיר בחמצן לכל העורקים בגוף. העורק הכלילי הוא כלי דם שמזרים דם לתאי שריר הלב עצמו. בחדר השמאלי של הלב יש דם עשיר בחמצן שעובר לאבי העורקים. העליה השמאלית מכילה דם עשיר בחמצן הזורם לחדר השמאלי. בחדר הימני של הלב יש דם עשיר בפחמן שעובר לעורק הריאה. העליה הימנית מכילה דם עשיר בפחמן הזורם לחדר הימני. בהתכווצות העליות הדם זורם  מהעליות לחדרים ומסתמי העליה-חדר פתוחים בזמן שמסתמי החדר-עורק נסגרים ונשמעת הנקישה הראשונה של פעימת הלב. בהתכווצות החדרים הדם זורם מהחדרים לעורקים ומסתמי העליה-חדר סגורים בזמן שמסתמי החדר-עורק נפתחים. בהרפיה הדם זורם מהורידים לעליות ןמסתמי העליה-חדר פתוחים מעט (מעט דליפה מהעליות לחדרים) בזמן שמסתמי החדר-עורק נזגרים ונשמעת הנקישה השנייה של פעימת הלב.";
        FileOutputStream fos= null;
        try {
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw= new OutputStreamWriter(fos);
        BufferedWriter bw= new BufferedWriter(osw);
        try {
            bw.write(Info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t3= new Intent(this, systemConInfo.class);
        t3.putExtra("the file", filename);
        t3.putExtra("num", x);
        startActivity(t3);
    }

    public void chosepee(View view) {
        x=4;
        Info="מערכת השתן היא מערכת ההפרשה החיצונית שמייצרת את השתן ומפרישה אותו אל מחוץ לגוף. תפקיד המערכת הוא הוצאת עודף מים מהגוף והוצאת פסולת מהגוף כמו שתנן (פסולת חנקנית רעילה לגוף שצבעה צהוב). תפקיד הכליות הוא סינון הדם מעודף מים, עודף מלחים, מחומצה ומפסולת. הכליה בנויה מכמיליון יחידות סינון חכמות הנקראות נפרונים. היתרון של הנפרונים הוא הגדלת שטח הפנים של הסינון ללא הגדלת נפח וסינון דם מהיר יותר. כל נפרון מורכב מכלי דם ומצינור הנקרא אבובית. הנפרון הוא מעין צינור שצידו האחד מסתיים במנה הנקרא קופסית וצידו האחר מתחבר לצינורית מאספת. הצינורות המאספים מכל כליה מתחברים לצינור מוביל שדרכו עובר השתן מן הכליות אל שלפוחית השתן. השלב הראשון של פעילות הכליה הוא שלב הסינון בלחץ. בשלב זה מסתננים חומרים מנימי הפקעות אל הקופסית שהיא נקודת הכניסה  לאבובית. הסינון הוא סינון בלחץ, כל המולקולות הקטנות מספיק יעברו אל הקופסית ויתחילו לזרופ באבובית. התוצר של הסינון הראשוני יקרא תסנין ראשוני. הסתנין הראשוני דומה פלסמה של הדם, בלי תאים ובלי חלבונים.  החומרים שעובקים בסינון הראשוני הם מים, גלוקוז, מלחים, שתנן ויונים של חומצה. החומרים שלא עוברים הם מולקולות גדולות כמו חלבונים, שומנים ותאי דם. השלב השני של פעילות הכליה הוא שלב הספיגה החוזרת. בתהליך זה מים, גלוקוז ומולקולות נוספות חוזרות בחזרה מן האבובית לדם. במהלך הזרימה של התסנין הראשוני באבובית הוא הולך ומשתנה בעקבות הספיגה החוזרת כך שבקצה האבובית באיזור של הצינור המאסף כבר נוצר שתן. מהצינורות המאספים של כל הנפרונים השתן זורם לאגן הכליה ומשם דקך צינור מוביל השתן מכל כליה אל שלפוחית השתן.";
        FileOutputStream fos= null;
        try {
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw= new OutputStreamWriter(fos);
        BufferedWriter bw= new BufferedWriter(osw);
        try {
            bw.write(Info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t3= new Intent(this, systemConInfo.class);
        t3.putExtra("the file", filename);
        t3.putExtra("num", x);
        startActivity(t3);
    }

    public void choseendocrine(View view) {
        x=3;
        Info="מערכת המפרישה הורמונים לדם לפי שינוי המורגש במוח. ההורמונים מופרשים מבלוטות הפרשה פנימיות שונות אל הדם, ההורמונים מועברים דרך הדם לכל חלקי הגוף, נקשרים לתאי המטרה על ידי חלבונים (קולטנים) שמתחברים להורמונים ומפעילים את התא. בלוטת ההפרשה של האינסולין היא תאי בטא באיי לנגרהנס בלבלב. תאי המטרה של האינסולין ם כל תאי הגוף, בעיקר תאי כבד, תאי שריר ותאי שומן שיש בקרום שלהם הרבה קולטני אינסולין. האינסולין נקשר לקולטנים בתאים ומגביר את חדירות קרומי התאים לגלוקוז. הגלוקוז יכנס מן הדם לתאים וריכוזו בדם ירד. מנגנון זה קורה על מנת שריכוז הגלוקוז בדם לא יעלה ויהפוך את הדם לסמיך יותר ויקשה עליו לזרום לאיברים שונים. כאשר ריכוז הסוכר בדם יורד, האינסולין עושה פעולה הפוכה ומגביר את תהליך הפירוש של גליקוגן לחד סוכרים. סוכרת מסוג 1 היא סכרת נעורים, מצב בו הגוף מתקיף את תאי הבטא בלבלב והם מושמדים על ידי המערכת החיסונית וייצור האינסולין נפגע טנפסק לחלוטין. סכרת מסוג 2 היא סכרת מבוגרים, מצב בו התאים אינם מגיבים כראוי לאינסולין. הגוף מפתח תנגודת או אי סבילות לאינסולין, רמת הסוכר נשארת גבוהה והלבלב מפריש עוד ועוד אינסולין במטרה לנסות להוריד אותה.";
        FileOutputStream fos= null;
        try {
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw= new OutputStreamWriter(fos);
        BufferedWriter bw= new BufferedWriter(osw);
        try {
            bw.write(Info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t3= new Intent(this, systemConInfo.class);
        t3.putExtra("the file", filename);
        t3.putExtra("num", x);
        startActivity(t3);
    }

    public void choseimmune(View view) {
        x=6;
        Info="קו ההגנה הראשון של הגוף מונע כניסה של גורמים מהסביבה החיונית בלי להבחין מהם (הגנה לא ספציפית). מערכת החיסון היא קן ההגנה השני, היא מבחינה בין עצמי לזר, היא לא תפגע בגורמים עצמיים של הגוף והיא ספציפית, מבחינה בין סוגי אנטיגנים שונים (כל ז=גורם זר שחדר לגוף). השלב הראשון של התגובה החיסונית הוא שלב הזיהוי. בשלב זה תאי דם לבנים בלעניים הנראים מאקרופאגים בולעים את האנטיגן שחדר לגוף, מפרקים אותו ומציגים את חלבוני האנטיגן על פני קרום התא. השלב השני הוא שלה ההתארגנות. תאי t מסוג תאי עזר נקשרים לחלבון המוצג על פני קרום המאקרופגים, מפרישים חומרים המגבירים ייצור של לימפוציטים מסוג t ומסוג b. השלב השלישי מתקיים כאשר שתי זרועות מערכת החיסון מתחילות לפעול במהירות כתגובה לחומרים שמופרשים מתאי t עוזרים. שתי התגובות הנוצרות הן תגובות ספציפיות המזהות בדיוק את האנטיגן. הראשונה היא התגובה ההומוראלית בה לימפוציטים מסוג b מייצרים נוגדנים ספציפיים לדם, הם נקשרים לאנטיגנים המתאימים ומשתקים אותם. התגובה השנייה היא התגובה התאית, היא פועלת באמצעות תאי t מסוג הרג שנצמדים לאנטיגן ומפרישים חומרים שמפרקים אותו. יש מקרים בהם תאי ההרג גורמים לתא להתאבד. ";
        FileOutputStream fos= null;
        try {
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw= new OutputStreamWriter(fos);
        BufferedWriter bw= new BufferedWriter(osw);
        try {
            bw.write(Info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t3= new Intent(this, systemConInfo.class);
        t3.putExtra("the file", filename);
        t3.putExtra("num", x);
        startActivity(t3);
    }

    public void chosefood(View view) {
        x=5;
        Info="במערכת העיכול מתקיימים 2 שלבים של פירוק מזון. פירוק המזון מתבצע בפירוק מכני שהוא חתיכה של המזון לחתיכות קטנות על ידי כך גודל שטח הפנים של המזון והדבר מהווה יתרון לאנזימי העיכול בפירוק כימי יעיל של המזון ובפרוק כימי בו משתתפים אנזימים שמצויים במקומות שונים במערכת העיכול. החשיבות של הפירוק הכימי היא לפרק מולקולות גדולות למולקולות קטנות על מנת שיוכלו לעבור דרך קרומי התאים וליצור מחדש פחמימות, שומנים וחלבונים הייחודיים לבני האדם מיחידות בניין שהגיעו לתאי גופינו, חומרים אלה בונים את הגוף ומאפשרים לנו לגדול ולפעול. לתנליך העיכול באדם יש כמה שלבים. השלב הראשון הוא בפה שם הרוק מרטיב ומרכך את המזון. אנזים המצוי ברוק מתחיל את תהליך הפרוק של הפחמימות (סוכרים), הרב סוכרים מתפרקים ליחידות של דו סוכר. השלב השני הוא בוושט בו שרירי הוושט מתכווצים לאורך הצינור בגלים רצופים ודחופים את גושי המזון לעבר הקיבה. השלב השלישי הוא בקיבה  שם היא מערבלת את המזון ומפרישה חומצה וחומרים נוספים. החומצה והחומרים הנוספים מפרקים את החלבונים שבמזון לחומצות אמיניות. השלב הרביעי הוא בימיצי הכבד והלבלב שם מיצי העיכול מופרשים מהם אל תוך התריסריון. התפקיד של מיצי העיכול הוא לפרק את החלבונים, הפחמימות והשומנים שבמזון. השלב החמישי הוא השלמת תהליכי הפירוק במעי. החומרים המפורקים נספגים לדם דרך דופן המעי ושאריות המזון וחומרים שלא נעכלו, מופרשים החוצה כצואה. המעי הדק הא צינור ארוך ודק בתוכו מתבצע הפירוק הסופי של אבות המזון. המעי הגס הוא צינור רחב וקצר ואין בו סיבים לכן התפקיד העיקרי שלו הוא ספיגת נוזלים ומיצי עיכול. למעי הגס גם מגיעים סיבים תזונתיים שמשפרים את פעולת המעיים וכל הפסולת שלא התעכלה נפלטת החוצה מפי הטבעת.";
        FileOutputStream fos= null;
        try {
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw= new OutputStreamWriter(fos);
        BufferedWriter bw= new BufferedWriter(osw);
        try {
            bw.write(Info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t3= new Intent(this, systemConInfo.class);
        t3.putExtra("the file", filename);
        t3.putExtra("num", x);
        startActivity(t3);
    }

    public void backtomain(View view) {
        t3= new Intent(this, Main.class);
        startActivity(t3);
        finish();
    }
}
