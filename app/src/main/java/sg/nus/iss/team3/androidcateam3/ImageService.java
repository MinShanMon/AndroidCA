package sg.nus.iss.team3.androidcateam3;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ImageService {
    public static ArrayList<Image> ImageList(Context context){
        ArrayList<Image> imgServ = new ArrayList<>();

        File dir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File[] fileInDir = dir.listFiles();

        int id = 1;

        for (File file: fileInDir){
            String filePath = file.getAbsolutePath();
            Image img = new Image(id, filePath);
            imgServ.add(img);
            imgServ.add(img);
            id++;
        }

        Collections.shuffle(imgServ);
        return imgServ;
    }
}
