package utils;

import android.content.Context;
import android.widget.Toast;


public class ToastUtil {

    private static Toast mToast;

    public static void showToast(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        mToast.setText(text);
        mToast.show();
    }

    public static void showToast(Context context, int resourceId) {
        if (mToast == null) {
            mToast = Toast.makeText(context,resourceId, Toast.LENGTH_SHORT);
        }
        mToast.setText(resourceId);
        mToast.show();
    }

    public static void showLongToast(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        }
        mToast.setText(text);
        mToast.show();
    }

    public static void showLongToast(Context context, int resourceId) {
        if (mToast == null) {
            mToast = Toast.makeText(context,resourceId, Toast.LENGTH_LONG);
        }
        mToast.setText(resourceId);
        mToast.show();
    }
}
