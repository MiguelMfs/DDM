package com.ifsc.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class PaintView extends View {

    public enum DrawingMode {
        PATH, CIRCLE, RECTANGLE
    }

    private DrawingMode drawingMode = DrawingMode.PATH;

    private Paint paint;
    private Path path;
    private float startX, startY;
    private float currentX, currentY;

    public PaintView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);

        path = new Path();
        setBackgroundColor(Color.WHITE);
    }

    public void setDrawingMode(DrawingMode mode) {
        this.drawingMode = mode;
    }


    public int getPaintColor() {
        return paint.getColor();
    }

    public void clear() {
        path.reset();
        startX = 0;
        startY = 0;
        currentX = 0;
        currentY = 0;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);

        if (drawingMode == DrawingMode.CIRCLE) {
            float dx = currentX - startX;
            float dy = currentY - startY;
            float radius = (float) Math.sqrt(dx * dx + dy * dy);
            canvas.drawCircle(startX, startY, radius, paint);
        } else if (drawingMode == DrawingMode.RECTANGLE) {
            canvas.drawRect(startX, startY, currentX, currentY, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = x;
                startY = y;
                if (drawingMode == DrawingMode.PATH) {
                    path.moveTo(x, y);
                } else {
                    currentX = x;
                    currentY = y;
                }
                return true;

            case MotionEvent.ACTION_MOVE:
                if (drawingMode == DrawingMode.PATH) {
                    path.lineTo(x, y);
                } else {
                    currentX = x;
                    currentY = y;
                }
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                if (drawingMode == DrawingMode.CIRCLE) {
                    float dx = x - startX;
                    float dy = y - startY;
                    float radius = (float) Math.sqrt(dx * dx + dy * dy);
                    path.addCircle(startX, startY, radius, Path.Direction.CW);
                } else if (drawingMode == DrawingMode.RECTANGLE) {
                    path.addRect(startX, startY, x, y, Path.Direction.CW);
                }
                invalidate();
                break;
        }

        return true;
    }
}
