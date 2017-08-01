package com.example.tam.a14customcoponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class customView  extends View{
    private static final int mDefaultTextSize = 20;
    private Paint mPaint = new Paint();
    private float mLeft, mTop, mViewWidth = 300, mViewHeight = 300;

    public customView(Context context) {
        super(context);
        mLeft = (getWidth() - mViewWidth)/2.0f;
        mTop = (getHeight() - mViewHeight)/2.0f;
    }

    public customView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.RED);
    }

    public void setSizeRectagle(float width, float height) {
        Rectagle SizeRegtagle = new Rectagle(width, height);
        mViewHeight = SizeRegtagle.getSizeWidth();
        mViewWidth = SizeRegtagle.getSizeHeight();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DrawShapeView(canvas,mViewWidth, mViewHeight, mPaint);
    }

    public void DrawShapeView(Canvas drawBitmap, float viewHieght, float viewWidth, Paint paint){
        mLeft = (getWidth() - viewWidth)/2.0f;
        mTop = (getHeight() - viewHieght)/2.0f;
        drawBitmap.drawRect(mLeft, mTop, mLeft + viewWidth, mTop + viewHieght, paint);
    }

    public void setColor(int newColor){
        mPaint.setColor(newColor);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int)event.getX();
            int y = (int)event.getY();
            if (x >= mLeft && x <= mLeft + mViewWidth && y >= mTop && y <= mTop + mViewHeight) {
                mPaint.setColor(Color.YELLOW);
                invalidate();
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    private Paint makePaint(int color) {
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(color);
        p.setTextSize(mDefaultTextSize);
        return(p);
    }

}
