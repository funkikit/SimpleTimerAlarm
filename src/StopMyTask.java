/*
Taskを停止するためのクラスである
引数によって止める時間を得る
処理の停止はクラスの実行によって得られる
 */
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class StopMyTask extends TimerTask{
    private Timer stopTimer;

    public StopMyTask (Timer stopTimer) { //コンストラクタ：timerクラスのインスタンスより停止時間を格納する
        this.stopTimer = stopTimer; //StopMyTask:thisのフィールドstopTimerに格納しておく
    }

    @Override
    public void run() {
        this.stopTimer.cancel(); //Timer.cancelによりtaskの停止を行う
        System.out.println("処理を停止します：" + new Date());
    }
}