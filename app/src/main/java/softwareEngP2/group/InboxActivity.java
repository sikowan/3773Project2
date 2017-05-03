package softwareEngP2.group;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class InboxActivity extends AppCompatActivity {

    private GetMessagesTask mGetMessagesTask;
    ListView lv;
    ArrayList<Message> messages;
    ArrayList<String> usernames;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inbox);
        extras=getIntent().getExtras();

        lv = (ListView) findViewById(R.id.inbox_listview);

        //Just made an Arraylist to test this out for now
        messages = getMessagesFromServer();
        usernames= refreshUserList();

        // ArrayAdapter puts contacts into listview
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_selectable_list_item, usernames);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                messageSelected(messages.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    private ArrayList<String> refreshUserList(){
        ArrayList<String> userList= new ArrayList<String>();
        for (Message m : messages ) {
            userList.add(m.getUsername());

        }
        return userList;




    }

    private void messageSelected(Message message){

        Intent intent = new Intent(InboxActivity.this, ReadMessageActivity.class);
        startActivity(intent);
        messages.remove(messages.indexOf(message));
        refreshUserList();
    }



    private ArrayList<Message> getMessagesFromServer(){
        //mGetMessagesTask = new GetMessagesTask(extras.getString(Intent.EXTRA_TEXT));
        //mGetMessagesTask.execute((Void) null);
        ArrayList<Message> messageList= new ArrayList<Message>();
        messageList.add(new Message("1 New message from Trent", "WE DID IT REDDIT", 1));
        messageList.add(new Message("1 New message from Ernesto", "WE DID IT TOO REDDIT", 1));

        return messageList;

    }


    public class GetMessagesTask extends AsyncTask<Void, Void, Boolean> {

        private final String mUser;


        GetMessagesTask(String user) {
            mUser = user;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            int tmp;
            try {
                // Simulate network access.
                URL url = new URL("http://ec2-52-34-10-100.us-west-2.compute.amazonaws.com/sendMessage.php");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

               // writer.write("sender="+mSender+"&username="+mRecepient+"&message="+mMessage+"&timeout="+mTimeout);
                writer.close();

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    //OK
                    InputStream is = connection.getInputStream();
                    String input = "";
                    while((tmp = is.read()) != -1){
                        input += (char)tmp;
                    }
                    JSONObject jsonObject = new JSONObject(input);
                    if(jsonObject.getString("result").equals("true")){
                        return true;
                    } else{
                        return false;
                    }
                    //otherwise, bad stuff happened
                } else {
                    InputStream is = connection.getInputStream();
                    String input = "";
                    while((tmp = is.read()) != -1){
                        input += (char)tmp;
                    }
                    JSONObject jsonObject = new JSONObject(input);
                    if(jsonObject.getString("result").equals("true")){
                        return true;
                    } else{
                        return false;
                    }
                    //Server returned HTTP error code.
                }
            } catch (MalformedURLException e) {

            } catch (IOException e){

            } catch (JSONException e){

            }

            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

            mGetMessagesTask = null;

            if (success){
                finish();
            } else {
               return;

            }
        }

        @Override
        protected void onCancelled() {
            mGetMessagesTask = null;
        }
    }


}