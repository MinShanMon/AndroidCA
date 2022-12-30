package sg.nus.iss.team3.androidcateam3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private final String[] first = {
            "hug", "full", "snore", "stop"
    };
    private final String[] second = {
            "full", "hug", "peep", "what"
    };
    private final String[] third = {
            "snore", "what", "peep", "stop"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);
        if(gridView != null){
            gridView.setAdapter(new ViewImgBtn(this, first, second, third));
//            listView.setOnItemClickListener(this);

        }
    }
}