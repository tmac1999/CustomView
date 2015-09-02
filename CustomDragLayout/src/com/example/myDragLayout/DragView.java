package com.example.myDragLayout;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class DragView extends FrameLayout {

	public DragView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mHelper = ViewDragHelper.create(this, 1.0f, callBack);
	}

	public DragView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DragView(Context context) {
		this(context, null);

		
	}

	ViewDragHelper.Callback callBack = new ViewDragHelper.Callback() {

		@Override
		public boolean tryCaptureView(View child, int pointerId) {
			System.out.println("pointerId=" + pointerId);
			return true;
		}

		public int getViewHorizontalDragRange(View child) {
			return 200;
		};

		@Override
		public int clampViewPositionHorizontal(View child, int left, int dx) {
			// TODO Auto-generated method stub
			return left;
		}
	};
	private ViewDragHelper mHelper;

	/**
	 * 转交触摸判断和触摸处理
	 */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return mHelper.shouldInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mHelper.processTouchEvent(event);
		return true;
	}
}
