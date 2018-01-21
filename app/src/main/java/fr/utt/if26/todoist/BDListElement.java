package fr.utt.if26.todoist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Alexandre on 21/01/2018.
 */

public class BDListElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ListView maListe = (ListView)findViewById(R.id.listView);
        ModulePersistance db = new ModulePersistance(this);
        ArrayList<ToDo> modules = db.getAllElements();
        CursusAdapter adapteur = new CursusAdapter(this, R.layout.activity_principal, modules);
        maListe.setAdapter(adapteur);
    }
}
