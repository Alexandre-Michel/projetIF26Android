package fr.utt.if26.todoist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_element);
    }

    private void BDAddElement() {
        Intent i = new Intent(AddElement.this, BDAddElement.class);
        startActivity(i);
    }
}
