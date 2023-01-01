package sg.nus.iss.team3.androidcateam3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    public int scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);
        ArrayList<Image> img= ImageService.ImageList(this);
        ViewImgBtn btnn = new ViewImgBtn(this, img);
        if(gridView != null){
            gridView.setAdapter(btnn);
            LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("custom-message"));
        }

    }


    @Override
    public void onStart() {
        super.onStart();
        TextView txt = findViewById(R.id.score);
        txt.setText(scores + " of 6");
    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            scores = intent.getIntExtra("score",0);
            TextView txt = findViewById(R.id.score);
            txt.setText(scores + " of 6");
        }
    };

}