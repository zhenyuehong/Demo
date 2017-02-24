package com.mtelnet.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.mtelnet.xruler.XRuler;
import com.mtelnet.xswitch.XSwitch;

public class SwitchAndRulerActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_and_ruler);

        XSwitch xSwitch =  (XSwitch) findViewById(R.id.xswitch);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        XRuler ruler1 = (XRuler) findViewById(R.id.ruler1);
        XRuler ruler2 = (XRuler) findViewById(R.id.ruler2);
        XRuler ruler3 = (XRuler) findViewById(R.id.ruler3);
        XRuler ruler4 = (XRuler) findViewById(R.id.ruler4);

        xSwitch.setOnXyzSwitchChangeListener(new XSwitch.XyzSwitchChange() {
            @Override
            public void changed(boolean isRight) {
                Toast.makeText(SwitchAndRulerActivity.this,isRight?"男":"女",Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 设置选中的条目
         */
        ruler1.setOnSelectItem(new XRuler.SelectItem() {
            @Override
            public int setSelectItem() {
                return 60;
            }
        });
        ruler2.setOnSelectItem(new XRuler.SelectItem() {
            @Override
            public int setSelectItem() {
                return 170;
            }
        });
        ruler3.setOnSelectItem(new XRuler.SelectItem() {
            @Override
            public int setSelectItem() {
                return 1990;
            }
        });
        ruler4.setOnSelectItem(new XRuler.SelectItem() {
            @Override
            public int setSelectItem() {
                return 60;
            }
        });

        /**
         * 监听拖动时值得变化
         */
        ruler1.setOnRulerValueChangeListener(new XRuler.RulerValue() {
            @Override
            public void value(int value) {
                tv1.setText("体重\n"+value+"\nkg");
            }
        });
        ruler2.setOnRulerValueChangeListener(new XRuler.RulerValue() {
            @Override
            public void value(int value) {
                tv2.setText("身高\n"+value+"\ncm");
            }
        });
        ruler3.setOnRulerValueChangeListener(new XRuler.RulerValue() {
            @Override
            public void value(int value) {
                tv3.setText("出生年\n"+value);
            }
        });
        ruler4.setOnRulerValueChangeListener(new XRuler.RulerValue() {
            @Override
            public void value(int value) {
                tv4.setText("每日运动\n"+value+"\n分钟");
            }
        });
    }
}
