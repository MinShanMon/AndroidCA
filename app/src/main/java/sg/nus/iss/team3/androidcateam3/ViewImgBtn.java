package sg.nus.iss.team3.androidcateam3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

public class ViewImgBtn extends ArrayAdapter<Object> {
    private final Context context;

    protected String[] img1, img2, img3;

    public ViewImgBtn(Context context, String[] img1, String[] img2, String[] img3){
        super(context, R.layout.row);
        this.context = context;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;

        addAll(new Object[img1.length]);
    }

    @NonNull
    public View getView(int pos, View view, @NonNull ViewGroup parent){
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, parent, false);
        }
        ImageButton imageView1 = view.findViewById(R.id.img1);
        int id1 = context.getResources().getIdentifier(img1[pos], "drawable", context.getPackageName());
        imageView1.setImageResource(id1);

        ImageButton imageView2 = view.findViewById(R.id.img2);
        int id2 = context.getResources().getIdentifier(img2[pos], "drawable", context.getPackageName());
        imageView2.setImageResource(id2);

        ImageButton imageView3 = view.findViewById(R.id.img3);
        int id3 = context.getResources().getIdentifier(img3[pos], "drawable", context.getPackageName());
        imageView3.setImageResource(id3);

        return view;
    }
}
