package com.mtelnet.myview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mtelnet.myview.utils.JavaBlurProcess;

public class BlurImageActivity extends AppCompatActivity {
    Bitmap overlay;
    ViewTreeObserver observer;
    JavaBlurProcess process = new JavaBlurProcess();
    private ImageView img_blur;
    private LinearLayout bg_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur_image);


        bg_img = (LinearLayout) findViewById(R.id.bg_img);
        img_blur = (ImageView) findViewById(R.id.img_blur);

        observer = bg_img.getViewTreeObserver();

        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bg_img.setDrawingCacheEnabled(true);
                bg_img.buildDrawingCache();
                Bitmap bitmap = bg_img.getDrawingCache();//截取区域视图

                int x = (int) img_blur.getX();
                int y = (int) img_blur.getY();
                int bitmapX = bitmap.getWidth();
                int bitmapY = bitmap.getHeight();
                Bitmap bitmap1 = Bitmap.createBitmap(bitmap, x, y, bitmapX - x, bitmapY - y);

                if (bitmap != null) {
                    blur(bitmap1, img_blur, 8);//模糊处理
                }
                bitmap1.recycle();
                bg_img.setDrawingCacheEnabled(false);//清除缓存
            }
        });
    }

    private void blur(Bitmap bkg, ImageView view, float radius) {
        int scaleFactor = 8;
        if (overlay != null) {
            overlay.recycle();
        }
        overlay = Bitmap.createScaledBitmap(bkg, bkg.getWidth() / scaleFactor, bkg.getHeight() / scaleFactor, false);
        overlay = process.blur(overlay, radius);//高斯模糊
        view.setImageBitmap(overlay);
    }
}
