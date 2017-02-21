package com.mtelnet.myview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class ViewTranslateActivity extends AppCompatActivity {

    private int screen_height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_translate);
        final ImageView img_translate = (ImageView) findViewById(R.id.trans_img);

        //补间动画，view原来的位置不变，想要真正改变view的位置，要用属性动画
//        TranslateAnimation animation=new TranslateAnimation(0,500,0,200);
//        animation.setDuration(2000);
//        animation.setFillAfter(true);
//        img_translate.startAnimation(animation);

        img_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewTranslateActivity.this, "click", Toast.LENGTH_SHORT).show();

            }
        });

        //属性动画
        //第二个参数  透明度：alpha  旋转度数：rotation、rotationX、rotationY   平移：translationX、translationY  缩放：scaleX、scaleY

//        setRotationX(float rotationX)：表示围绕 X 轴旋转，rotationX 表示旋转度数
//        setRotationY(rotationY):表示围绕 Y 轴旋转，rotationY 表示旋转度数
//        setRotation(float rotation):表示围绕 Z 旋转,rotation 表示旋转度数

//        ObjectAnimator first = ObjectAnimator.ofFloat(img_translate, "translationY", 0, 500).setDuration(2000);
////        first.start();
//
//        ObjectAnimator second = ObjectAnimator.ofFloat(img_translate, "translationX", 0, 300).setDuration(2000);
//
//        ObjectAnimator third = ObjectAnimator.ofFloat(img_translate, "alpha", 0, 1).setDuration(2000);
//
//        ObjectAnimator fourth = ObjectAnimator.ofFloat(img_translate, "rotationX", 0, 180,0).setDuration(2000);
//
//        ObjectAnimator firth = ObjectAnimator.ofFloat(img_translate, "rotationY", 0, 180,0).setDuration(2000);
//
//        ObjectAnimator  sixth= ObjectAnimator.ofFloat(img_translate, "scaleX",0, 1).setDuration(2000);
//
//        ObjectAnimator  seventh= ObjectAnimator.ofFloat(img_translate, "scaleY",0, 1).setDuration(2000);
//
//        //组合动画
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(first)
////                .with(second)
//                .with(third)
//                .with(fourth)
//                .with(firth)
//                .with(sixth)
//                .with(seventh)
//        ;
////        animatorSet.setStartDelay(1000);
////        animatorSet.setDuration(3000);
//        animatorSet.start();


        // 获取屏幕宽高
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        screen_height = wm.getDefaultDisplay().getHeight();

        //放大图片，然后缩小还原到原来的位置

        final int[] locOfHeadlineView = new int[2];
        img_translate.getLocationOnScreen(locOfHeadlineView);
        
        ObjectAnimator anim=ObjectAnimator.ofFloat(img_translate,"hzy",0.0F,1.0F);
        anim.setDuration(1000);
        anim.setTarget(img_translate);
        anim.setInterpolator(new LinearInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float scale = (Float) valueAnimator.getAnimatedValue();
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) img_translate.getLayoutParams();

                params.topMargin= (int) (locOfHeadlineView[1]*(1-scale));
                params.bottomMargin= (int) (screen_height-(locOfHeadlineView[1]-img_translate.getHeight())*(1-scale));

                img_translate.setLayoutParams(params);
                img_translate.requestLayout();


//                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) eventView.getLayoutParams();
//
//                float scale = interpolatedTime;
//
//                if (null!=params){
//                    params.topMargin = (int) (1.0f * locOfHeadlineView[1] * (1 - scale));
//
//                    params.bottomMargin = (int) (1.0f * (Config.SCREEN_HEIGHT - (locOfHeadlineView[1] + v.getHeight()) - lay_nav.getHeight()) * (1 - scale));
//                    eventView.setLayoutParams(params);
////                llDescript.setAlpha(1.0f * (1 - scale));
//
//                    eventView.requestLayout();
//                }
            }
        });

        anim.start();

    }
}
