package softwareEngP2.group;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.LoaderManager.LoaderCallbacks;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendMessageActivity extends AppCompatActivity {


    private SendMessageTask mSendMessageTask = null;
    private TextView mRecepientView;
    private TextView mMessageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);


        mRecepientView = (TextView) findViewById(R.id.Recepient);
        mMessageView = (TextView) findViewById(R.id.MessageBody);

        Button mSendButton = (Button) findViewById(R.id.sendButton);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSendMessage();
            }
        });

    }

    private void attemptSendMessage(){
        String recepient = mRecepientView.getText().toString();
        String message = mMessageView.getText().toString();

        mSendMessageTask = new SendMessageTask(recepient, message);
        mSendMessageTask.execute((Void) null);
        
    }




    public class SendMessageTask extends AsyncTask<Void, Void, Boolean> {

        private final String mRecepient;
        private final String mMessage;

        SendMessageTask(String recepient, String message) {
            mRecepient = recepient;
            mMessage = message;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            Log.i("STATUS","BEFORE everything");
            int tmp;
            try {
                // Simulate network access.
                URL url = new URL("http://ec2-52-34-10-100.us-west-2.compute.amazonaws.com/login.php");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

                writer.write("username="+mRecepient+"&password="+mMessage);
                writer.close();

                Log.i("STATUS","BEFORE Ifs");
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

            mSendMessageTask = null;

            if (success){
                mRecepientView.setText("");
                mMessageView.setText("Message Successfully Sent");
                finish();
            } else {
                mRecepientView.setError("Contact Not found");

            }
        }

        @Override
        protected void onCancelled() {
            mSendMessageTask = null;
        }
    }
}


