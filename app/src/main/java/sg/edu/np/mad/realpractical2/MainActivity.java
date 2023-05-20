package sg.edu.np.mad.realpractical2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create");

        int randomInt = getIntent().getIntExtra("randomInt", 0);
        TextView textView = findViewById(R.id.randint);
        textView.setText("MAD" + randomInt);

        Button followbutton = findViewById(R.id.button17);
        User user = new User();
        if (user.followed == true)
        {
            followbutton.setText("UNFOLLOW");
        } else {
            followbutton.setText("FOLLOW");
        }

        followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.followed == true) {
                    followbutton.setText("FOLLOW");
                    user.followed = false;
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                } else {
                    followbutton.setText("UNFOLLOW");
                    user.followed =true;
                    Toast.makeText(MainActivity.this, "followed", Toast.LENGTH_SHORT).show();

                }
            }
        });

        Button msgbttn = findViewById(R.id.msgbutton);
        msgbttn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent msgfragment = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(msgfragment);
            }
        });






    }


    @Override
    protected void onStart()
    {
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v(TITLE, "On pause");
    }
    @Override
    protected void onResume() {

        super.onResume();
        Log.v(TITLE, "On Resume");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.v(TITLE, "On Stop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.v(TITLE, "On Destroy");
    }


}


