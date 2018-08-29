package com.mqby.mylibrary;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


/**
 * @author MaQiang
 * @time 2018/7/3 0003 12:39
 * @class 描述
 */
public class MyEditText extends AppCompatEditText {

    private int mType = MyItemView.TYPE_TEXT;

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMyType(int type) {
        mType = type;
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        if (mType == MyItemView.TYPE_EDIT)
//            return super.dispatchTouchEvent(event);
//        else
//            return false;
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mType == MyItemView.TYPE_TEXT)
            return false;
        else {
            setFocusable(true);
            setFocusableInTouchMode(true);
            openKeybord(this,getContext());
            requestFocus();
            return super.onTouchEvent(event);
        }
    }

    /**
     * 打开软键盘
     *
     * @param editText
     * @param context
     */
    public void openKeybord(EditText editText, Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
}