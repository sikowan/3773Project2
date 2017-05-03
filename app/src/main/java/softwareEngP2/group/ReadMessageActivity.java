package softwareEngP2.group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReadMessageActivity extends AppCompatActivity {

    private TextView mUsernameView;
    private TextView mMessageView;
    private TextView mTimeoutView;
    private Bundle extras;
    private int timeout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_message);
        extras= getIntent().getExtras();
        mUsernameView = (TextView) findViewById(R.id.UserDisp);
        mMessageView = (TextView) findViewById(R.id.MessageDisp);
        mTimeoutView= (TextView) findViewById(R.id.TimeoutDisp);

        mUsernameView.setText((String)extras.get("EXTRA_USERNAME"));
        mMessageView.setText((String)extras.get("EXTRA_MESSAGE"));


        //mTimeoutView.setText((int)(extras.get("EXTRA_TIMEOUT")));


    }



}
