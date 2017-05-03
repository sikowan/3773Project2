package softwareEngP2.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button mViewProfileButton = (Button) findViewById(R.id.viewProfileButton);
        Button mContactsButton = (Button) findViewById(R.id.contactsButton);
        Button mInboxButton = (Button) findViewById(R.id.inboxButton);
        Button mOutboxButton = (Button) findViewById(R.id.outboxButton);
        Button mSendMessageButton = (Button) findViewById(R.id.sendMessageButton);
        Button mSignOutButton = (Button) findViewById(R.id.signOutButton);

        mViewProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewProfile();
            }
        });
        mContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewContacts();
            }
        });
        mInboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewInbox();
            }
        });
        mOutboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewOutbox();
            }
        });
        mSendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
        mSignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        extras=getIntent().getExtras();


    }

    private void viewProfile() {
        Intent intent = new Intent(MainMenuActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void viewInbox() {
        Intent intent = new Intent(MainMenuActivity.this, InboxActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, extras.getString(Intent.EXTRA_TEXT));
        startActivity(intent);
    }

    private void viewOutbox() {
        Intent intent = new Intent(MainMenuActivity.this, OutboxActivity.class);
        startActivity(intent);
    }

    private void viewContacts() {
        Intent intent = new Intent(MainMenuActivity.this, ContactsActivity.class);
        startActivity(intent);
    }

    private void sendMessage() {
        Intent intent = new Intent(MainMenuActivity.this, SendMessageActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, extras.getString(Intent.EXTRA_TEXT));
        startActivity(intent);
    }

    private void signOut() {
        Intent intent = new Intent(MainMenuActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}
