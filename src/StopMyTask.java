import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class StopMyTask extends TimerTask{
    private Timer stopTimer;
    public StopMyTask (Timer stopTimer) {
        this.stopTimer = stopTimer;
    }
    @Override
    public void run() {
        this.stopTimer.cancel();
        System.out.println("処理を停止します：" + new Date());
    }
}