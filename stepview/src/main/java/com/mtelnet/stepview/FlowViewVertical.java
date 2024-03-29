package com.mtelnet.stepview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Map;
/**
 * Created by hongzhenyue on 17/2/24.
 */

public class FlowViewVertical extends View {

    private Paint bgPaint;
    private Paint proPaint;
    private TextPaint textPaint;
    private float bgRadius;
    private float proRadius;
    private int lineBgWidth;
    private int bgColor;
    private int lineProWidth;
    private int proColor;
    private int interval;
    private int bgPositionX;
    private int maxStep;
    private int proStep;
    private int textPaddingLeft;
    private int timePaddingRight;
    private int textMoveTop;
    private int timeMoveTop;
    private int textsize;
    private float starY;
    private float stopY;
    private String[] titles;
    private String[] times;
    private int border;
    private Map<String, String> map;

//    属性	        介绍	         类型	        默认	是否必须
//    v_bg_radius	背景 ○ 的半径	dimension	5	否
//    v_pro_radius	已完成 ○ 的半径	dimension	2	否
//    v_bg_width	背景线的宽度	dimension	3	否
//    v_bg_color	背景的颜色	color	#cdcbcc	否
//    v_pro_width	已完成线的宽度	dimension	2	否
//    v_pro_color	已完成的颜色	color	#029dd5	否
//    v_interval	○ 与 ○之间的间距	dimension	80	否
//    v_bgPositionX	指示线距view左边缘的距离	dimension	100	否
//    v_textPaddingLeft	步骤描述文字与指示线的距离	dimension	10	否
//    v_timePaddingRight	时间与指示线的距离	dimension	15	否
//    v_max_step	总步骤(○)的个数	int	5	否
//    v_pro_step	已完成步骤	int	1	否
//    v_textsize	字体大小	dimension	10	否
//    v_textMoveTop	指示器右侧文字位置上下移动的距离	dimension	5	否
//    v_timeMoveTop	指示器左侧文字位置上下移动的距离	dimension	4	否



//    竖向
//
//    竖向指示器需单独设置步骤之间的间隔(v_interval)
//    竖向指示器可与ScrollView结合使用,从而达到滑动
//            竖向指示器并没有使用item复用,如果数据量较大建议使用listview
//    竖向指示器绘制文字有所不同,也因此导致文字与步骤节点(○)不在一个水平线上,可通过v_textMoveTop与v_timeMoveTop适配


    public FlowViewVertical(Context context) {
        this(context, null);
    }

    public FlowViewVertical(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowViewVertical(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FlowViewVertical);
        bgRadius = ta.getDimension(R.styleable.FlowViewVertical_v_bg_radius, 10);
        proRadius = ta.getDimension(R.styleable.FlowViewVertical_v_pro_radius, 8);
        lineBgWidth = (int) ta.getDimension(R.styleable.FlowViewVertical_v_bg_width, 3f);
        bgColor = ta.getColor(R.styleable.FlowViewVertical_v_bg_color, Color.parseColor("#cdcbcc"));
        lineProWidth = (int) ta.getDimension(R.styleable.FlowViewVertical_v_pro_width, 2f);
        proColor = ta.getColor(R.styleable.FlowViewVertical_v_pro_color, Color.parseColor("#029dd5"));
        interval = (int) ta.getDimension(R.styleable.FlowViewVertical_v_interval, 140);
        maxStep = ta.getInt(R.styleable.FlowViewVertical_v_max_step, 5);
        proStep = ta.getInt(R.styleable.FlowViewVertical_v_pro_step, 3);
        bgPositionX = (int) ta.getDimension(R.styleable.FlowViewVertical_v_bgPositionX, 200);
        textPaddingLeft = (int) ta.getDimension(R.styleable.FlowViewVertical_v_textPaddingLeft, 40);
        timePaddingRight = (int) ta.getDimension(R.styleable.FlowViewVertical_v_timePaddingRight, 80);
        textMoveTop = (int) ta.getDimension(R.styleable.FlowViewVertical_v_textMoveTop, 10);
        timeMoveTop = (int) ta.getDimension(R.styleable.FlowViewVertical_v_timeMoveTop, 8);
        textsize = (int) ta.getDimension(R.styleable.FlowViewVertical_v_textsize, 17);
        ta.recycle();
        init();
    }

    private void init() {
        bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(bgColor);
        bgPaint.setStrokeWidth(lineBgWidth);

        proPaint = new Paint();
        proPaint.setAntiAlias(true);
        proPaint.setStyle(Paint.Style.FILL);
        proPaint.setColor(proColor);
        proPaint.setStrokeWidth(lineProWidth);

        textPaint = new TextPaint();
        textPaint.setTextSize(textsize);
        textPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int bgWidth;
        if (widthMode == MeasureSpec.EXACTLY) {
            bgWidth = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();
        } else
            bgWidth = Util.dip2px(getContext(), 311);
        starY = getPaddingTop() + bgRadius;
        stopY = getPaddingTop() + bgRadius + (maxStep - 1) * interval;
        float bottom = stopY + bgRadius + getPaddingBottom();
        border = bgWidth - (bgPositionX + textPaddingLeft);
        setMeasuredDimension(bgWidth, (int) bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBg(canvas);
        drawProgress(canvas);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < maxStep; i++) {
            setPaintColor(i);
            if (null != times && i < proStep)
                canvas.drawText(times[i], bgPositionX - timePaddingRight, stopY - (i * interval) + timeMoveTop, textPaint);
            if (null != titles) {
                canvas.save();
                canvas.translate(bgPositionX + textPaddingLeft, (stopY - (i * interval) - textMoveTop));
                StaticLayout sl = new StaticLayout(titles[i], textPaint, border, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                sl.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void drawProgress(Canvas canvas) {
        int linePro;
        float lastBottom = stopY;
        for (int i = 0; i < proStep; i++) {
            setPaintColor(i);
            if (i == 0 || i == maxStep - 1)
                linePro = interval / 2;
            else
                linePro = interval;
            canvas.drawLine(bgPositionX, lastBottom, bgPositionX, lastBottom - linePro, proPaint);
            lastBottom = lastBottom - linePro;
            canvas.drawCircle(bgPositionX, stopY - (i * interval), proRadius, proPaint);
        }
    }

    private void setPaintColor(int i) {
        if (i < proStep) {
            textPaint.setColor(proColor);
        } else {
            textPaint.setColor(bgColor);
        }
        if (titles == null || map == null) return;
        String title = titles[i];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (title.contains(entry.getKey())) {
                String value = entry.getValue();
                proPaint.setColor(Color.parseColor(value));
                textPaint.setColor(Color.parseColor(value));
                return;
            } else {
                proPaint.setColor(proColor);
            }
        }
    }

    private void drawBg(Canvas canvas) {
        canvas.drawLine(bgPositionX, stopY, bgPositionX, starY, bgPaint);
        for (int i = 0; i < maxStep; i++) {
            canvas.drawCircle(bgPositionX, stopY - (i * interval), bgRadius, bgPaint);
        }
    }


    public void setKeyColor(Map<String, String> map) {
        this.map = map;
    }

    /**
     * 进度设置
     * @param progress 当前进行到哪一步
     * @param maxStep  总的步骤
     * @param titles   文字描述(指示线右侧)
     * @param times    时间描述(指示线左侧)
     */
    public void setProgress(int progress, int maxStep, String[] titles, String[] times) {
        proStep = progress;
        this.maxStep = maxStep;
        this.titles = titles;
        this.times = times;
        invalidate();
    }
}