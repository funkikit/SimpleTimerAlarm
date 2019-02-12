/*
TimerTaskクラスを拡張したmytaskクラス
ここでは、runをoverrideして、出力するように設定している。
 */

import java.util.Date;
import java.util.TimerTask;

class MyTask extends TimerTask { //
    @Override
    public void run() {
        System.out.println("実行時間：" + new Date());
        SoundTest soundtest = new SoundTest();
        soundtest.Sound();//Sound通知の実行
    }

}