package com.example.mayq.touchdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mayq on 2016/12/2.
 */

public class TouchView extends View {
    private Paint paint;
    //private MySet set = new MySet();
    private int id;
    private float x, y;

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        /*
        Log.d("mayq", "action=" + event.getAction()
                + "\nactionMasked=" + event.getActionMasked()
                + "\ncounter=" + event.getPointerCount()
                + "\nindex=" + event.getActionIndex()
                + "\npointerId=" + event.getPointerId(event.getActionIndex())
                + "\nhistorySize=" + event.getHistorySize()
        );
        */

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //case MotionEvent.ACTION_POINTER_DOWN:
                /*
                set.add(new Finger(
                        event.getPointerId(event.getActionIndex()),
                        event.getX(event.getActionIndex()),
                        event.getY(event.getActionIndex())));
                        */
                id = event.getPointerId(event.getActionIndex());
                x = event.getX();
                y = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                /*
                List<Finger> list = set.getAll();
                for (Finger obj : list) {
                    set.update(obj.getId(),
                            event.getX(event.findPointerIndex(obj.getId())),
                            event.getY(event.findPointerIndex(obj.getId())));
                }
                */
                int index = event.findPointerIndex(id);
                if (index >= 0) {
                    x = event.getX(index);
                    y = event.getY(index);
                }

                break;
            case MotionEvent.ACTION_UP:
                //case MotionEvent.ACTION_POINTER_UP:
                //set.remove(event.getPointerId(event.getActionIndex()));
                x = y = -1;
                break;
            default:
                break;
        }
        invalidate();

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        /*
        List<Finger> list = set.getAll();
        for (Finger obj : list) {
            canvas.drawText("" + obj.getId(), obj.getX(), obj.getY() - 100, paint);
        }
        */

        /*
        if (list.size() > 1) {
            Finger f0 = list.get(0);
            Finger f1 = list.get(1);
            float x0 = Math.min(f0.getX(), f1.getX());
            float y0 = Math.min(f0.getY(), f1.getY());
            float x1 = Math.max(f0.getX(), f1.getX());
            float y1 = Math.max(f0.getY(), f1.getY());
            canvas.drawRect(x0, y0, x1, y1, paint);
        }
        */

        canvas.drawText("" + id, x, y - 100, paint);
    }
}
