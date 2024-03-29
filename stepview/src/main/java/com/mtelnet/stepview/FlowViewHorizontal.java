package com.mtelnet.stepview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Map;

/**
 * Created by hongzhenyue on 17/2/24.
 */

public class FlowViewHorizontal extends View {

    private Paint bgPaint;
    private Paint proPaint;
    private float bgRadius;
    private float proRadius;
    private float startX;
    private float stopX;
    private float bgCenterY;
    private int lineBgWidth;
    private int bgColor;
    private int lineProWidth;
    private int proColor;
    private int textPadding;
    private int timePadding;
    private int maxStep;
    private int textSize;
    private int proStep;
    private int interval;
    private String[] titles = {"提交", "接单", "取件", "配送", "完成"};
    private String[] times = {"12:20"};
    private Map<String, String> map;


//    属性	        介绍	            类型	    默认	是否必须
//    h_bg_radius	背景 ○ 的半径	dimension	5	否
//    h_pro_radius	已完成 ○ 的半径	dimension	2	否
//    h_bg_width	背景线的宽度	dimension	3	否
//    h_bg_color	背景的颜色	color	#cdcbcc	否
//    h_pro_width	已完成线的宽度	dimension	2	否
//    h_pro_color	已完成的颜色	color	#029dd5	否
//    h_text_padding	步骤描述文字(title)与○的距离	dimension	10	否
//    h_time_padding	时间与○的距离	dimension	15	否
//    h_max_step	总步骤(○)的个数	int	5	否
//    h_pro_step	已完成步骤	int	1	否
//    h_textsize	字体大小	dimension	10	否


//    横向
//
//            横向指示器自动计算步骤之间的间隔
//    横向指示器自动居中显示,当设定paddingLeft后无需再设定paddingRight
//            横向指示器不可以横向滑动


//    全部
//
//    title[] 和 time[] 传null 的时候则不显示指示器不显示文字与时间
//    最小步骤总和(max_step)>=2且>=已完成步骤(pro_step)
//    字体大小单位是dp
//    具体步骤颜色的设置是根据步骤描述(title[])中是否包含所传入map的key值来决定是否更改的,注意是"包含"
//    只有已完成步骤才可以单独设置颜色,未完成步骤统一使用的是bg_color所得到的颜色


    public FlowViewHorizontal(Context context) {
        this(context, null);
    }

    public FlowViewHorizontal(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowViewHorizontal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FlowViewHorizontal);
        bgRadius = ta.getDimension(R.styleable.FlowViewHorizontal_h_bg_radius, 10);
        proRadius = ta.getDimension(R.styleable.FlowViewHorizontal_h_pro_radius, 8);
        lineBgWidth = (int) ta.getDimension(R.styleable.FlowViewHorizontal_h_bg_width, 3f);
        bgColor = ta.getColor(R.styleable.FlowViewHorizontal_h_bg_color, Color.parseColor("#cdcbcc"));
        lineProWidth = (int) ta.getDimension(R.styleable.FlowViewHorizontal_h_pro_width, 2f);
        proColor = ta.getColor(R.styleable.FlowViewHorizontal_h_pro_color, Color.parseColor("#029dd5"));
        textPadding = (int) ta.getDimension(R.styleable.FlowViewHorizontal_h_text_padding, 20);
        timePadding = (int) ta.getDimension(R.styleable.FlowViewHorizontal_h_time_padding, 30);
        maxStep = ta.getInt(R.styleable.FlowViewHorizontal_h_max_step, 5);
        textSize = (int) ta.getDimension(R.styleable.FlowViewHorizontal_h_textsize, 20);
        proStep = ta.getInt(R.styleable.FlowViewHorizontal_h_pro_step, 1);
        ta.recycle();
        init();
    }

    private void init() {
        bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(bgColor);
        bgPaint.setStrokeWidth(lineBgWidth);
        bgPaint.setTextSize(textSize);
        bgPaint.setTextAlign(Paint.Align.CENTER);

        proPaint = new Paint();
        proPaint.setAntiAlias(true);
        proPaint.setStyle(Paint.Style.FILL);
        proPaint.setColor(proColor);
        proPaint.setStrokeWidth(lineProWidth);
        proPaint.setTextSize(textSize);
        proPaint.setTextAlign(Paint.Align.CENTER);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int bgWidth;
        if (widthMode == MeasureSpec.EXACTLY) {
            bgWidth = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();
        } else
            bgWidth = Util.dip2px(getContext(), 311);

        int bgHeight;
        if (heightMode == MeasureSpec.EXACTLY) {
            bgHeight = MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop() - getPaddingBottom();
        } else
            bgHeight = Util.dip2px(getContext(), 49);
        float left = getPaddingLeft() + bgRadius;
        stopX = bgWidth - bgRadius;
        startX = left;
        bgCenterY = bgHeight / 2;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        interval = (int) ((stopX - startX) / (maxStep - 1));
        drawBg(canvas);
        drawProgress(canvas);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < maxStep; i++) {
            if (i < proStep) {
                setPaintColor(i);
                if (null != titles && i<titles.length)
                    canvas.drawText(titles[i], startX + (i * interval), bgCenterY - textPadding, proPaint);
                if (null != times && i<times.length)
                    canvas.drawText(times[i], startX + (i * interval), bgCenterY + timePadding, proPaint);
            } else {
                if (null != titles && i<titles.length) {
                    String title = titles[i];
                    if (null == title) continue;
                    canvas.drawText(title, startX + (i * interval), bgCenterY - textPadding, bgPaint);
                }
            }
        }
    }

    private void setPaintColor(int i) {
        if (titles == null || map == null) return;
        String title = titles[i];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (title.contains(entry.getKey())) {
                proPaint.setColor(Color.parseColor(entry.getValue()));
                return;
            } else {
                proPaint.setColor(proColor);
            }
        }
    }

    private void drawProgress(Canvas canvas) {
        int linePro;
        float lastLeft = startX;
        for (int i = 0; i < proStep; i++) {
            setPaintColor(i);
            if (i == 0 || i == maxStep - 1)
                linePro = interval / 2;
            else
                linePro = interval;
            canvas.drawLine(lastLeft, bgCenterY, lastLeft + linePro, bgCenterY, proPaint);
            lastLeft = lastLeft + linePro;
            canvas.drawCircle(startX + (i * interval), bgCenterY, proRadius, proPaint);
        }
    }

    private void drawBg(Canvas canvas) {
        canvas.drawLine(startX, bgCenterY, stopX, bgCenterY, bgPaint);
        for (int i = 0; i < maxStep; i++) {
            canvas.drawCircle(startX + (i * interval), bgCenterY, bgRadius, bgPaint);
        }
    }

    /**
     * 进度设置
     * @param progress 已完成到哪部
     * @param maxStep  总步骤
     * @param titles   步骤名称
     * @param times    完成时间
     */
    public void setProgress(int progress, int maxStep, String[] titles, String[] times) {
        proStep = progress;
        this.maxStep = maxStep;
        this.titles = titles;
        this.times = times;
        invalidate();
    }

    /**
     * 颜色设置
     * @param map 标题-颜色
     */
    public void setKeyColor(Map<String, String> map) {
        this.map = map;
    }
}