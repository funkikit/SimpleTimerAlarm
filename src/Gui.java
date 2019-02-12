
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Container;


public class Gui extends JFrame{ //JFrameを継承している

    public JPanel p = new JPanel(); //panelを作成

    public JComboBox combo1;
    public JComboBox combo2;
    public JComboBox combo3;
    public JButton button;

    Gui(){
        this.TimeComboBox();//時間指定comboboxの作成
        this.StartBotton();//start /stop buttonの作成

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//アプリケーション終了をクローズ処理として設定
        this.setBounds(10, 10, 500, 400);
        this.setTitle("SimpleAlarm");
        this.setVisible(true);
    }

    public void TimeComboBox(){
        int i;
        //時間、分、秒を設定する配列
        String[] Hours = new String[24];
        String[] Minutes = new String[60];
        String[] Seconds = new String[60];
        //時間の設定
        for (i = 0; i < 24; i++){
            Hours[i] = String.valueOf(i);
        }
        //分、秒の設定
        for (i = 0; i < 60; i++){
            Minutes[i] = String.valueOf(i);
            Seconds[i] = String.valueOf(i);
        }

        //ComboBoxの作成、大きさと初期値を設定している
        combo1 = new JComboBox(Hours);
        combo1.setPreferredSize(new Dimension(80, 30));
        combo1.setSelectedIndex(8);

        combo2 = new JComboBox(Minutes);
        combo2.setPreferredSize(new Dimension(80, 30));
        combo2.setSelectedIndex(0);

        combo3 = new JComboBox(Seconds);
        combo3.setPreferredSize(new Dimension(80, 30));
        combo3.setSelectedIndex(0);



        p.add(new JLabel("Hour:")); //panelにcomboboxの追加を行っている
        p.add(combo1);
        p.add(new JLabel("Minute:"));
        p.add(combo2);
        p.add(new JLabel("Second:"));
        p.add(combo3);

        getContentPane().add(p, BorderLayout.CENTER);
    }

    public void StartBotton(){

        ImageIcon normalicon = new ImageIcon("./image/start.png");
        ImageIcon pressedicon = new ImageIcon("./image/stop.png");

        button.setIcon(normalicon);
        button.setPressedIcon(pressedicon);

        p.add(button);
        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.SOUTH);

    }
}