package io.patrykpoborca.moshi_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import io.patrykpoborca.moshi_demo.models.Person;

public class MainActivity extends AppCompatActivity {

    private final String json = "{\"__typeName\": \"child\", \"first_Name\" : \"John\", \"lastName\" : \"Doe\", \"weight\" : { \"value\" : 75.5, \"unitType\" : \"KG\" }, \"dob\": \"08/12/1980\", \"ranItem\" : {\"value\" : \"val\" } }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<Person> personAdapter = moshi.adapter(Person.class);
        Person person = null;
        try {
            person = personAdapter.fromJson(json);
        } catch (IOException e) {
            //this is a checked exception
        }

        String result = personAdapter.toJson(person);
        Log.d("done", "done");
    }
}
