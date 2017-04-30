package softwareEngP2.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_contacts);

        setContentView(R.layout.activity_contacts);

        ListView lv = (ListView) findViewById(R.id.contact_listview);

        //Just made an Arraylist to test this out for now
        ArrayList<String> contacts = new ArrayList<String>();
        contacts.add("Victoria");
        contacts.add("Jennifer");
        contacts.add("Ernesto");
        contacts.add("Austin");
        contacts.add("Trenton");

        // ArrayAdapter puts contacts into listview
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_selectable_list_item, contacts);

        lv.setAdapter(arrayAdapter);

    }
}