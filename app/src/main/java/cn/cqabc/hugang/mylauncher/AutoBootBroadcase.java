package cn.cqabc.hugang.mylauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoBootBroadcase extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Intent intent1 = new Intent();
            intent1.setClass(context, MainActivity.class);
            intent1.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    }
}
