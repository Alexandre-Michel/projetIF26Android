package fr.utt.if26.todoist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Principal extends AppCompatActivity {

    private Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //showElements();
    }


    public void addList(View v) {
        System.out.println("Tstt");
        Intent i = new Intent(this, AddElement.class);
        startActivity(i);
    }

    private void BDListElement() {
        Intent i = new Intent(Principal.this, BDListElement.class);
        startActivity(i);
    }

}
