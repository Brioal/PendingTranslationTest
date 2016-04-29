package com.brioal.pendingtranslationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.brioal.pendingtranslationtest.activity.OtherActivity;
import com.brioal.pendingtranslationtest.util.BrioalUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.radio_one)
    RadioButton radioOne;
    @Bind(R.id.radio_two)
    RadioButton radioTwo;
    @Bind(R.id.radio_three)
    RadioButton radioThree;
    @Bind(R.id.radio_four)
    RadioButton radioFour;
    @Bind(R.id.radio_five)
    RadioButton radioFive;
    @Bind(R.id.radio_six)
    RadioButton radioSix;
    @Bind(R.id.group)
    RadioGroup group;
    @Bind(R.id.btn_trans)
    Button btnTrans;

    private int inAnim;
    private int outAnim;
    private int inAnimExit;
    private int outAnimExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BrioalUtil.init(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnTrans.setOnClickListener(this);
        inAnim = android.R.anim.fade_in;
        outAnim = android.R.anim.fade_out;
        inAnimExit = android.R.anim.fade_in;
        outAnimExit = android.R.anim.fade_out;
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_one: //淡入淡出
                        inAnim = android.R.anim.fade_in;
                        outAnim = android.R.anim.fade_out;
                        inAnimExit = android.R.anim.fade_in;
                        outAnimExit = android.R.anim.fade_out;
                        break;
                    case R.id.radio_two: //左进右出  右进左出
                        inAnim = android.R.anim.slide_in_left;
                        outAnim = android.R.anim.slide_out_right;
                        inAnimExit = R.anim.slide_int_right;
                        outAnimExit = R.anim.slide_out_left;
                        break;
                    case R.id.radio_three: //右进左出 左进右出
                        inAnim = R.anim.slide_int_right;
                        outAnim = R.anim.slide_out_left;
                        inAnimExit = android.R.anim.slide_in_left;
                        outAnimExit = android.R.anim.slide_out_right;
                        break;
                    case R.id.radio_four: // 中心扩大  中心缩小
                        inAnim = R.anim.zoom_in;
                        outAnim = R.anim.zoom_out;
                        inAnimExit = R.anim.zoom_in;
                        outAnimExit = R.anim.zoom_out;
                        break;
                    case R.id.radio_five: //上进下出  下进上出
                        inAnim = R.anim.slide_in_up;
                        outAnim = R.anim.slide_out_down;
                        inAnimExit = R.anim.slide_in_down;
                        outAnimExit = R.anim.slide_out_top;
                        break;
                    case R.id.radio_six: //下进上出 上进下处于
                        inAnim = R.anim.slide_in_down;
                        outAnim = R.anim.slide_out_top;
                        inAnimExit = R.anim.slide_in_up;
                        outAnimExit = R.anim.slide_out_down;
                        break;

                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra("InAnim", inAnimExit);
        intent.putExtra("OutAnim", outAnimExit);
        startActivity(intent);
        overridePendingTransition(inAnim, outAnim);
    }
}
