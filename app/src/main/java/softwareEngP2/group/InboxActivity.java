package softwareEngP2.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_inbox);
        setContentView(R.layout.activity_inbox);

        ListView lv = (ListView) findViewById(R.id.inbox_listview);

        //Just made an Arraylist to test this out for now
        ArrayList<String> messages = new ArrayList<String>();
        messages.add("Message from Victoria");
        messages.add("Message from Jennifer");


        // ArrayAdapter puts contacts into listview
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_selectable_list_item, messages);

        lv.setAdapter(arrayAdapter);


    }

    private void messageSelected(){

    }
}