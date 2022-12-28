package sg.nus.iss.team3.androidcateam3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private final String[] first = {
            "hug", "full", "peep", "what"
    };
    private final String[] second = {
            "what", "peep", "full", "hug"
    };
    private final String[] third = {
            "peep", "hug", "what", "full"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        if(listView != null){
            listView.setAdapter(new ViewImgBtn(this, first, second, third));
//            listView.setOnItemClickListener(this);

        }
    }
}