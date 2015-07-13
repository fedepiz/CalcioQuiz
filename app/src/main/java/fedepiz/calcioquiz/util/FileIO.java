package fedepiz.calcioquiz.util;

import android.content.res.*;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import fedepiz.calcioquiz.R;

/**
 * Created by Federico on 13/7/15.
 */
public class FileIO {
    public static String readTextFileFull(Resources res,String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(res.openRawResource(R.raw.domande)));
        StringBuffer sb = new StringBuffer("");
        String str;
        while((str = bufferedReader.readLine()) != null) {
            sb.append(str);
            sb.append("\n");
        }
        str = sb.toString();
        return str.substring(0,str.length()-1);
    }
}
