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
    private DeleteMessageTask mDeleteMessageTask;
    private ListView lv;
    private ArrayList<Message> messages;
    private ArrayList<String> usernames;
    private Bundle extras;
    private  ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messages =new ArrayList<Message>();
        usernames= new ArrayList<String>();
        setContentView(R.layout.activity_inbox);
        extras=getIntent().getExtras();

        lv = (ListView) findViewById(R.id.inbox_listview);

        //Just made an Arraylist to test this out for now
        getMessagesFromServer();


        // ArrayAdapter puts contacts into listview

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               messageSelected(messages.get(position));
            }
       });


    }



    private void refreshUserList(){
       usernames= new ArrayList<String>();

        for (Message m : messages ) {
            usernames.add(m.getUsername());

       }
        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_selectable_list_item, usernames);

        lv.setAdapter(arrayAdapter);
       // lv.refreshDrawableState();
    }

    private void messageSelected(Message message){

        Intent intent = new Intent(InboxActivity.this, ReadMessageActivity.class);
        intent.putExtra("EXTRA_USERNAME",message.getUsername());
        intent.putExtra("EXTRA_MESSAGE",message.getMessage());
        intent.putExtra("EXTRA_TIMEOUT",message.getTimeout());

        mDeleteMessageTask = new DeleteMessageTask(message.getMessage());
        mDeleteMessageTask.execute((Void) null);
        messages.remove(messages.indexOf(message));
        refreshUserList();
        startActivity(intent);
    }



    private void getMessagesFromServer(){
        mGetMessagesTask = new GetMessagesTask(extras.getString(Intent.EXTRA_TEXT));
        mGetMessagesTask.execute((Void) null);
         //messages.add(new Message("TRENT", "HELLO", 1));
       // refreshUserList();
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
                URL url = new URL("http://ec2-52-34-10-100.us-west-2.compute.amazonaws.com/getMessage.php");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

                writer.write("username="+mUser);
                writer.close();

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    //OK
                    InputStream is = connection.getInputStream();
                    String input = "";
                    while((tmp = is.read()) != -1){
                        input += (char)tmp;
                    }
                    JSONObject jsonObject = new JSONObject(input);
                    if(jsonObject.isNull("result")) {
                        int index = 1;
                        //while (!jsonObject.getString("sender" + index).isEmpty()) {
                            messages.add(new Message(jsonObject.getString("sender" + index), jsonObject.getString("message" + index), 1));
                            //messages.add(new Message("TRENT", "HELLO", 1));

                            index++;
                        //}
                        return true;
                    } else {
                        return false;
                    }
                        //otherwise, bad stuff happened
                } else {
                    return false;
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
                refreshUserList();
            } else {
               return;

            }
        }

        @Override
        protected void onCancelled() {
            mGetMessagesTask = null;
        }
    }


    public class DeleteMessageTask extends AsyncTask<Void, Void, Boolean> {

        private final String mMessage;


        DeleteMessageTask(String message) {
            mMessage = message;

        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            int tmp;
            try {
                // Simulate network access.
                URL url = new URL("http://ec2-52-34-10-100.us-west-2.compute.amazonaws.com/deleteMessage.php");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

                writer.write("message="+mMessage);
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
                        is.close();
                        connection.disconnect();
                        return true;
                    } else{
                        is.close();
                        connection.disconnect();
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
                        is.close();
                        connection.disconnect();
                        return true;
                    } else{
                        is.close();
                        connection.disconnect();
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

            mDeleteMessageTask = null;

            if (success){



            } else {
               // mRecepientView.setError("Could not find User");

            }
        }

        @Override
        protected void onCancelled() {
            mDeleteMessageTask = null;
        }
    }


}