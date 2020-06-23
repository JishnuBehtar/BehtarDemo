package com.learning.behtardemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {


    TextView tvPayOnlHeader;
    TextView tvPayOnTypes;
    ImageView imPayOnline;
    ImageView imPayOnlineArraow;

    TextView tvPayOfflHeader;
    TextView tvPayOffTypes;
    ImageView imPayOffline;
    ImageView imPayOfflineArraow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        RelativeLayout rlPayOnline = findViewById(R.id.rl_pay_online);
        RelativeLayout rlPayOffline = findViewById(R.id.rl_pay_offline);

        tvPayOnlHeader = findViewById(R.id.tv_pay_online);
        tvPayOnTypes = findViewById(R.id.tv_pay_online_meths);
        imPayOnline = findViewById(R.id.im_onl_pay);
        imPayOnlineArraow = findViewById(R.id.im_onl_arrow);

        tvPayOfflHeader = findViewById(R.id.tv_pay_offline);
        tvPayOffTypes = findViewById(R.id.tv_pay_offline_meths);
        imPayOffline = findViewById(R.id.im_pay_off);
        imPayOfflineArraow = findViewById(R.id.im_off_arrow);

        rlPayOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                tvPayOnlHeader.setTextColor(getResources().getColor(R.color.black));
                tvPayOnTypes.setTextColor(getResources().getColor(R.color.dimblack));
                imPayOnline.setImageResource(R.drawable.ic_online_pay);
                imPayOnlineArraow.setImageResource(R.drawable.ic_keyboard_arrow_right);

                tvPayOfflHeader.setTextColor(getResources().getColor(R.color.dimgrey));
                tvPayOffTypes.setTextColor(getResources().getColor(R.color.dimgrey));
                imPayOffline.setImageResource(R.drawable.ic_offline_grey_pay);
                imPayOfflineArraow.setImageResource(R.drawable.ic_forward_arrow_grey);

            }
        });

        rlPayOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPayOfflHeader.setTextColor(getResources().getColor(R.color.black));
                tvPayOffTypes.setTextColor(getResources().getColor(R.color.dimblack));
                imPayOffline.setImageResource(R.drawable.ic_offline_pay);
                imPayOfflineArraow.setImageResource(R.drawable.ic_keyboard_arrow_right);

                tvPayOnlHeader.setTextColor(getResources().getColor(R.color.dimgrey));
                tvPayOnTypes.setTextColor(getResources().getColor(R.color.dimgrey));
                imPayOnline.setImageResource(R.drawable.ic_online_grey_pay);
                imPayOnlineArraow.setImageResource(R.drawable.ic_forward_arrow_grey);

            }
        });
    }
}
