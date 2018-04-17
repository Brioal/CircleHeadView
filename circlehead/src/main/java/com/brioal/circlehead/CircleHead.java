package com.brioal.circlehead;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.Gravity;

import java.util.Random;
import java.util.regex.Matcher;

/**
 * 显示文字的圆点
 */
public class CircleHead extends android.support.v7.widget.AppCompatTextView {
    // 是否随机颜色
    private boolean isRandom = false;
    private Random random;
    // 背景颜色
    private int mBackColor;

    private Context mContext;

    public CircleHead(Context context) {
        this(context, null);
    }

    public CircleHead(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
        build();
    }

    /**
     * 初始化设置
     */
    private void init(AttributeSet attrs) {
        // 初始化随机数
        random = new Random();
        // 获取参数
        TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.CircleHead);
        // 获取是否随机背景
        isRandom = array.getBoolean(R.styleable.CircleHead_random, false);
        // 获取背景颜色
        mBackColor = array.getColor(R.styleable.CircleHead_back_color, Color.BLUE);
        array.recycle();

    }

    @SuppressLint("RestrictedApi")
    private void build() {
        if (isRandom) {
            mBackColor = getRandomColor(); //产生随机颜色
        }
        // 设置居中
        setGravity(Gravity.CENTER);
        // 设置自适应文字大小
        TextViewCompat.setAutoSizeTextTypeWithDefaults(this, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        // 设置背景颜色
        setBackgroundResource(R.drawable.shape_drawable);
        GradientDrawable drawable = (GradientDrawable) getBackground();
        drawable.setColor(mBackColor);
        setBackgroundDrawable(drawable);
    }


    //设置背景颜色
    public CircleHead setBackColor(int backColor) {
        mBackColor = backColor;
        isRandom = false;
        build();
        return this;
    }

    //设置是否开启随机颜色
    public CircleHead setRandom(boolean isRandom) {
        this.isRandom = isRandom;
        build();
        return this;
    }

    public int getRandomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int minSize = Math.min(width, height);
        setMeasuredDimension(minSize, minSize);
    }
}
