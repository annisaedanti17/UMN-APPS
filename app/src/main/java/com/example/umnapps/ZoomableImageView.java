package com.example.umnapps;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.appcompat.widget.AppCompatImageView;

public class ZoomableImageView extends AppCompatImageView {

    private Matrix matrix = new Matrix();
    private float[] matrixValues = new float[9];

    // Zoom state
    private float minScale = 1f;
    private float maxScale = 5f;
    private float currentScale = 1f;

    // Gesture detectors
    private ScaleGestureDetector scaleDetector;
    private GestureDetector gestureDetector;

    // Drag state
    private PointF lastTouch = new PointF();
    private int activePointerId = -1;
    private boolean isDragging = false;

    // View dimensions
    private int viewWidth, viewHeight;
    private float originalWidth, originalHeight;
    private boolean isInitialized = false;

    public ZoomableImageView(Context context) {
        super(context);
        init(context);
    }

    public ZoomableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ZoomableImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setScaleType(ScaleType.MATRIX);

        scaleDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                float scaleFactor = detector.getScaleFactor();
                float newScale = currentScale * scaleFactor;

                if (newScale >= minScale && newScale <= maxScale) {
                    currentScale = newScale;
                    matrix.postScale(scaleFactor, scaleFactor, detector.getFocusX(), detector.getFocusY());
                    constrainMatrix();
                    setImageMatrix(matrix);
                }
                return true;
            }
        });

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (currentScale > minScale) {
                    // Reset to fit
                    resetZoom();
                } else {
                    // Zoom to 2.5x at tap point
                    float targetScale = 2.5f;
                    float scaleFactor = targetScale / currentScale;
                    currentScale = targetScale;
                    matrix.postScale(scaleFactor, scaleFactor, e.getX(), e.getY());
                    constrainMatrix();
                    setImageMatrix(matrix);
                }
                return true;
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
        if (!isInitialized) {
            initializeMatrix();
        }
    }

    private void initializeMatrix() {
        if (getDrawable() == null) return;

        originalWidth = getDrawable().getIntrinsicWidth();
        originalHeight = getDrawable().getIntrinsicHeight();

        // Fit image to view (fit center)
        float scaleX = (float) viewWidth / originalWidth;
        float scaleY = (float) viewHeight / originalHeight;
        float scale = Math.min(scaleX, scaleY);

        float dx = (viewWidth - originalWidth * scale) / 2f;
        float dy = (viewHeight - originalHeight * scale) / 2f;

        matrix.reset();
        matrix.postScale(scale, scale);
        matrix.postTranslate(dx, dy);
        setImageMatrix(matrix);

        minScale = scale;
        currentScale = scale;
        isInitialized = true;
    }

    public void resetZoom() {
        isInitialized = false;
        initializeMatrix();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleDetector.onTouchEvent(event);
        gestureDetector.onTouchEvent(event);

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                activePointerId = event.getPointerId(0);
                lastTouch.set(event.getX(), event.getY());
                isDragging = true;
                getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_MOVE:
                if (isDragging && !scaleDetector.isInProgress()) {
                    int pointerIndex = event.findPointerIndex(activePointerId);
                    if (pointerIndex >= 0) {
                        float x = event.getX(pointerIndex);
                        float y = event.getY(pointerIndex);
                        float dx = x - lastTouch.x;
                        float dy = y - lastTouch.y;

                        if (currentScale > minScale) {
                            matrix.postTranslate(dx, dy);
                            constrainMatrix();
                            setImageMatrix(matrix);
                        }

                        lastTouch.set(x, y);
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                activePointerId = -1;
                isDragging = false;
                break;

            case MotionEvent.ACTION_POINTER_UP:
                int pointerIndex = event.getActionIndex();
                int pointerId = event.getPointerId(pointerIndex);
                if (pointerId == activePointerId) {
                    int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    if (newPointerIndex < event.getPointerCount()) {
                        lastTouch.set(event.getX(newPointerIndex), event.getY(newPointerIndex));
                        activePointerId = event.getPointerId(newPointerIndex);
                    }
                }
                break;
        }
        return true;
    }

    private void constrainMatrix() {
        if (getDrawable() == null) return;

        matrix.getValues(matrixValues);
        float transX = matrixValues[Matrix.MTRANS_X];
        float transY = matrixValues[Matrix.MTRANS_Y];
        float scaleX = matrixValues[Matrix.MSCALE_X];

        float scaledWidth = originalWidth * scaleX;
        float scaledHeight = originalHeight * scaleX;

        float maxTransX, minTransX, maxTransY, minTransY;

        if (scaledWidth <= viewWidth) {
            minTransX = maxTransX = (viewWidth - scaledWidth) / 2f;
        } else {
            minTransX = viewWidth - scaledWidth;
            maxTransX = 0;
        }

        if (scaledHeight <= viewHeight) {
            minTransY = maxTransY = (viewHeight - scaledHeight) / 2f;
        } else {
            minTransY = viewHeight - scaledHeight;
            maxTransY = 0;
        }

        float dx = 0, dy = 0;
        if (transX < minTransX) dx = minTransX - transX;
        else if (transX > maxTransX) dx = maxTransX - transX;

        if (transY < minTransY) dy = minTransY - transY;
        else if (transY > maxTransY) dy = maxTransY - transY;

        matrix.postTranslate(dx, dy);
    }
}

