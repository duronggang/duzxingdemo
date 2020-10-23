package com.du.zxingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.zxing.WriterException;

import myencode.CodeConstant;
import myencode.DuQRCodeEncoder;
import zxing.encoding.EncodingHandler;

public class MainActivity extends AppCompatActivity {

    Button norml_code_btn;
    ImageView normal_code_iv;
    Button nomargin_code_btn;
    LinearLayout out_ll;
    ImageView nomargin_code_iv;
    Bitmap codeBit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        norml_code_btn = findViewById(R.id.norml_code_btn);
        normal_code_iv = findViewById(R.id.normal_code_iv);
        nomargin_code_btn = findViewById(R.id.nomargin_code_btn);
        out_ll = findViewById(R.id.out_ll);
        nomargin_code_iv = findViewById(R.id.nomargin_code_iv);

        norml_code_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    codeBit = EncodingHandler.createQRCode("https://github.com/duronggang", getdip2px(150));
                    normal_code_iv.setImageBitmap(codeBit);
                } catch (WriterException e) {
                    e.printStackTrace();
                }

            }
        });
        nomargin_code_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeBit = DuQRCodeEncoder.syncEncodeQRCode("https://github.com/duronggang", getdip2px(150));
                nomargin_code_iv.setImageBitmap(codeBit);
                out_ll.setPadding(0 - (CodeConstant.leftPadding), 0 - (CodeConstant.topPadding), 0 - (CodeConstant.leftPadding), 0 - (CodeConstant.topPadding));

            }
        });
    }

    public int getdip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}