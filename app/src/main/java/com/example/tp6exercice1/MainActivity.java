package com.example.tp6exercice1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> lesContacts = new ArrayList<Contact>();

    MyAdapter myAdapter = new MyAdapter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        lesContacts.add(new Contact("the queen","99074732",R.drawable.image1));
        lesContacts.add(new Contact("Lef3a","99074732",R.drawable.image2));
        lesContacts.add(new Contact("Daddou","99074732",R.drawable.image3));
        lesContacts.add(new Contact("Hsouna","99074732",R.drawable.image5));
        lesContacts.add(new Contact("Chouchou","99074732",R.drawable.image5));

        MyAdapter myAdapter = new MyAdapter(this,lesContacts);
        recyclerView.setAdapter(myAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        registerForContextMenu(recyclerView);


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 121:
                Toast.makeText(getApplicationContext(),"Call"+item.getGroupId(),Toast.LENGTH_LONG).show();
                return true;
            case 122:
                Toast.makeText(getApplicationContext(),"Send Sms"+item.getGroupId(),Toast.LENGTH_LONG).show();
                return true;
            case 123:
                Toast.makeText(getApplicationContext(),"Edit"+item.getGroupId(),Toast.LENGTH_LONG).show();
                myAdapter.editItem(item.getGroupId());
                return true;
            case 124:
                Toast.makeText(getApplicationContext(),"Delete"+item.getGroupId(),Toast.LENGTH_LONG).show();
                myAdapter.removeItem(item.getGroupId());
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }
}