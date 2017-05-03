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
        User Jennifer = new User("Jennifer", "Woodal");
        User Victoria = new User("Victoria", "Mueller");
        User Austin = new User("Austin", "Olivares");
        User Trenton = new User("Trenton", "Goins");
        User Ernesto = new User("Ernesto", "Felan");

        User Test = new User("Test", "User");
        Test.freezeUser();

        Contacts contact = new Contacts();
        contact.addContact(Ernesto);
        contact.addContact(Trenton);
        contact.addContact(Victoria);
        contact.addContact(Austin);
        contact.addContact(Jennifer);
        contact.addContact(Test);


        // ArrayAdapter puts contacts into listview
        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<User>(
                this,
                android.R.layout.simple_selectable_list_item, contact.getContacts());

        lv.setAdapter(arrayAdapter);

    }
}