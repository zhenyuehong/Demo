package com.mtelnet.myview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mtelnet.myview.utils.NotificationsUtils;

public class CheckNotifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_notify);
    }

    public void checkNotify(final View view) {
        boolean state = NotificationsUtils.isNotificationEnabled(this);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("通知开启：" + state);

        dialog.setPositiveButton("开启", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NotificationsUtils.getAppDetailSettingIntent(view.getContext());
            }
        });
        dialog.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NotificationsUtils.getAppDetailSettingIntent(view.getContext());
            }
        });

        dialog.show();
    }




}
