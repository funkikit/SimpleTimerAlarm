/*
このクラスによって、開始時間、終了時間を設定し、taskとして
timer.scheduleAtFixedRateによって、タスクを指定時間に実行する。
timer.Scheduleによって、指定時間にタスクを停止する、
 */

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MySchedule {
    public static void main(String[] args) throws Exception{

        Gui gui = new Gui();

        int h,m,s;

        h = (int)gui.combo1.getSelectedItem();
        m = (int)gui.combo2.getSelectedItem();
        s = (int)gui.combo3.getSelectedItem();

        MyTask task = new MyTask();  //Mytaskインスタンスの作成:task内容を与える
        Timer timer = new Timer("myTimer"); //timerインスタンス:時間指定実行を担う

        System.out.println("処理開始：" + new Date());//処理開始通知

        //実行開始時間の指定
        Calendar startCal = Calendar.getInstance(); //Calendarインスタンスの作成
        startCal.set(Calendar.HOUR_OF_DAY, h);//時間を設定（24時間）
        startCal.set(Calendar.MINUTE, m);//分を設定
        startCal.set(Calendar.SECOND, s);//秒を設定

        StopMyTask stopTask = new StopMyTask(timer);//StopMyTaskインスタンス作成
        //実行終了時間の指定
        Calendar stopCal = Calendar.getInstance();
        stopCal.set(Calendar.HOUR_OF_DAY, h);
        stopCal.set(Calendar.MINUTE, m+1);
        stopCal.set(Calendar.SECOND, s);

        //実行開始時間になったら処理を実行させ、以降は10秒ごとに実行
        timer.scheduleAtFixedRate(task, startCal.getTime(),TimeUnit.SECONDS.toMillis(10));
        //引数(行われるtask,指定の時間、時間間隔)

        //実行終了時間になったら処理終了
        timer.schedule(stopTask, stopCal.getTime());//
    }
}