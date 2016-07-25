package com.example.sonet.sqlitedemov_1;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sonet on 7/25/2016.
 */
public class Massage {

    public static void getMassage(Context context, String massage)
    {
        Toast.makeText(context, massage, Toast.LENGTH_LONG).show();
    }
}
