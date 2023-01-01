package sg.nus.iss.team3.androidcateam3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import org.w3c.dom.Text;

import java.util.List;

public class ViewImgBtn extends ArrayAdapter<Object> implements View.OnClickListener{
    private final Context context;
    private List<Image> gameImages;
    protected int score;
    public ViewImgBtn(Context context, List<Image> gameImages){
        super(context, R.layout.row);
        this.context = context;
        this.gameImages = gameImages;

        addAll(new Object[gameImages.size()]);
    }


    @NonNull
    public View getView(int pos, View view, @NonNull ViewGroup parent){
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, parent, false);
        }

        ImageButton imageView = view.findViewById(R.id.img1);
        Image gameImage = gameImages.get(pos);

        Bitmap bitmap = BitmapFactory.decodeFile(gameImage.getFilePath());
        imageView.setTag(gameImage.getFilePath());
        imageView.setOnClickListener(this);
        imageView.setImageBitmap(bitmap);
        return view;
    }
    String first = "";
    String second = "";
    @Override
    public void onClick(View v) {
        if(first != ""){
            second = v.getTag().toString();
            Toast.makeText(context, v.getTag().toString()+" added to second", Toast.LENGTH_SHORT).show();
            if(first == second){
                score++;

                Toast.makeText(context, score + " score", Toast.LENGTH_SHORT).show();
                if(score == 6){
                    Toast.makeText(context, "You Win The Game", Toast.LENGTH_SHORT).show();
                    score = 0;
                }
                first ="";
                second = "";
                Intent intent = new Intent("custom-message");
                intent.putExtra("score", score);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
            else{
                first ="";
                second="";
            }
        }
        else{
            first = v.getTag().toString();
            Toast.makeText(context, v.getTag().toString()+" added to first", Toast.LENGTH_SHORT).show();
        }

    }

}
