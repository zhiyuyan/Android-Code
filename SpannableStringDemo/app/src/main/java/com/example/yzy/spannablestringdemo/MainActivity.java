package com.example.yzy.spannablestringdemo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_container);

        SpannableString spannableString;

        LayoutInflater layoutInflater = LayoutInflater.from(this);

        TextView textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);

        // 前景色
        spannableString = new SpannableString("前景色");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.colorAccent));
        spannableString.setSpan(foregroundColorSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(foregroundColorSpan);

        // 背景色
        spannableString = new SpannableString("背景色");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(getResources().getColor(R.color.colorAccent));
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(backgroundColorSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(backgroundColorSpan);

        // 相对大小
        spannableString = new SpannableString("相对大小");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(1.5f);
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(relativeSizeSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(relativeSizeSpan);

        // 中划线
        spannableString = new SpannableString("中划线");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(strikethroughSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(strikethroughSpan);

        // 下划线
        spannableString = new SpannableString("下划线");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(underlineSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(underlineSpan);

        // 上标
        spannableString = new SpannableString("上标");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(superscriptSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(superscriptSpan);

        // 下标
        spannableString = new SpannableString("下标");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(subscriptSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(subscriptSpan);

        // 设置粗体、斜体
        spannableString = new SpannableString("设置粗体、斜体");
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(styleSpan, 0, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(styleSpan);

        // 将文本替换为图片
        spannableString = new SpannableString("将文本替换为图片");
        ImageSpan imageSpan = new ImageSpan(this, R.mipmap.ic_launcher);
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(imageSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        spannableString.removeSpan(imageSpan);

        // 为文本设置点击事件
        spannableString = new SpannableString("为文本设置点击事件");
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                Toast.makeText(widget.getContext(), "响应点击事件", Toast.LENGTH_SHORT).show();
            }
        };
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(clickableSpan, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        // 可以点击
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        linearLayout.addView(textView);
        spannableString.removeSpan(clickableSpan);

        // 设置超链接
        spannableString = new SpannableString("设置超链接");
        URLSpan urlSpan = new URLSpan("https://www.baidu.com");
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        spannableString.setSpan(urlSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        linearLayout.addView(textView);
        // 可以点击
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.removeSpan(urlSpan);

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int hasLength;
        // 前景色
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("前景色");
        spannableStringBuilder.setSpan(foregroundColorSpan, hasLength + 0, hasLength + 2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        // 背景色
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("背景色");
        spannableStringBuilder.setSpan(backgroundColorSpan, hasLength + 0, hasLength + 2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        // 相对大小
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("相对大小");
        spannableStringBuilder.setSpan(relativeSizeSpan, hasLength + 0, hasLength + 2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        // 中划线
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("中划线");
        spannableStringBuilder.setSpan(strikethroughSpan, hasLength + 0, hasLength + 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        // 下划线
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("下划线");
        spannableStringBuilder.setSpan(underlineSpan, hasLength + 0, hasLength + 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        // 上标
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("上标");
        spannableStringBuilder.setSpan(superscriptSpan, hasLength + 0, hasLength + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        // 下标
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("下标");
        spannableStringBuilder.setSpan(subscriptSpan, hasLength + 0, hasLength + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        // 设置粗体、斜体
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("设置粗体、斜体");
        spannableStringBuilder.setSpan(styleSpan, hasLength + 0, hasLength + 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        // 将文本替换为图片
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("将文本替换为图片");
        spannableStringBuilder.setSpan(imageSpan, hasLength + 0, hasLength + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        // 为文本设置点击事件
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("为文本设置点击事件");
        spannableStringBuilder.setSpan(clickableSpan, hasLength + 0, hasLength + 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        // 设置超链接
        hasLength = spannableStringBuilder.length();
        spannableStringBuilder.append("设置超链接");
        spannableStringBuilder.setSpan(urlSpan, hasLength + 0, hasLength + 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView = (TextView) layoutInflater.inflate(R.layout.include_text, null);
        textView.setText(spannableStringBuilder);
        linearLayout.addView(textView);
        // 可以点击
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
