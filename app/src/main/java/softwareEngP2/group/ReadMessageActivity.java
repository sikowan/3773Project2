package softwareEngP2.group;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;

import java.util.logging.LogRecord;

public class ReadMessageActivity extends AppCompatActivity {

    private TextView mUsernameView;
    private TextView mMessageView;
    private TextView mTimeoutView;
    private Bundle extras;
    private int timeout;
    private Handler handler;
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
        timeout=(int)(extras.get("EXTRA_TIMEOUT"));

        mTimeoutView.setText(Integer.toString(timeout*60));
        startTimer();

    }



    private void startTimer(){



    }


}
