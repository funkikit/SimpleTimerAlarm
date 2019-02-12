/*
オーディオファイルを再生するプログラム
例外処理を実装しており、ファイルの入手力、非サポートファイル、その他例外に対して検査例外として扱える。


 */

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundTest {

    public void Sound() {
        /*
        System.out.println("===== サポートしている形式 =====");
        Type[] typeArray = AudioSystem.getAudioFileTypes();//サポート形式のリストを代入
        for(Type type : typeArray) {
            System.out.println(type.toString()); //type配列を出力する
        }
        */
        AudioInputStream ais = null; //

        try { //実行内容
            ais = AudioSystem.getAudioInputStream(new File("./Sounds/Se_koc03.wav"));
            AudioFormat af = ais.getFormat(); //フォーマットの読み込み

            DataLine.Info info = new DataLine.Info(Clip.class, af);
            Clip clip = (Clip)AudioSystem.getLine(info); //Audioclipの指定

            clip.open(ais);
            clip.loop(0); //再生回数指定とともに再生処理を行う。
            clip.flush(); //Clipのflush処理
            while(clip.isActive()) { //終了時処理 100msec待たせて次へ
                Thread.sleep(30);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();  //例外処理
        }finally {  //最終処理
            try {
                ais.close(); //メモリ解放
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}