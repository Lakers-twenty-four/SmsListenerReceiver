package com.example.administrator.smslistenerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

/**
 * Created by Administrator on 2017/2/23 0023.
 */

public class SmsListener extends BroadcastReceiver{
    //当短信到来的时候执行
    public void onReceive(Context context, Intent intent) {
        //获取发送者的号码和发送内容
        Object []objects =(Object[]) intent.getExtras().get("pdus");

        for(Object obj: objects){
            //[1]获取smsmessage实例
            SmsMessage s = SmsMessage.createFromPdu((byte[]) obj);
            //[2]获取发送短信的内容
            String messageBody=s.getMessageBody();
            String adress=s.getOriginatingAddress();

            System.out.print("adress:"+adress+"-----"+"messageBody"+messageBody);
        }

    }
}
