package com.tommisaarnio.ostoslista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity_add extends AppCompatActivity {

    private EditText name;

    private EditText note;

    private Context context;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.txtAddSomething);
        note = findViewById(R.id.txtAddNote);
        context = activity_add.this;
    }


    public void addToBasket(View view){
        String stuffName = (name.getText().toString());
        String stuffNote = (note.getText().toString());
        Stuff stuff = new Stuff (stuffName, stuffNote);
        StuffStorage.getInstance().addStuff(stuff);
        StuffStorage.getInstance().saveStuff(context);
        StuffStorage.getInstance().loadStuff(context);
    }

    public void switchToShoppingCart(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}