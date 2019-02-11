import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;


public class MySchedule {
    public static void main(String[] args) throws Exception{

        MyTask task = new MyTask();
        Timer timer = new Timer("myTimer");
        System.out.println("処理開始：" + new Date());

        //実行開始時間の指定
        Calendar startCal = Calendar.getInstance();
        startCal.set(Calendar.HOUR_OF_DAY, 12);//時間を設定（24時間）
        startCal.set(Calendar.MINUTE, 0);//分を設定
        startCal.set(Calendar.SECOND, 0);//秒を設定

        //実行開始時間になったら処理を実行させ、以降は10秒ごとに実行
        timer.scheduleAtFixedRate(task, startCal.getTime(),TimeUnit.SECONDS.toMillis(10));

        StopMyTask stopTask = new StopMyTask(timer);
        //実行終了時間の指定
        Calendar stopCal = Calendar.getInstance();
        stopCal.set(Calendar.HOUR_OF_DAY, 12);
        stopCal.set(Calendar.MINUTE, 10);
        stopCal.set(Calendar.SECOND, 0);

        //実行終了時間になったら処理終了
        timer.schedule(stopTask, stopCal.getTime());
    }
}