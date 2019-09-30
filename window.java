import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class window extends JFrame {

    // 定义组件
    JPanel jp1, jp2, jp3;
    JLabel jlb1, jlb2;
    JButton jb1, jb2;
    JTextField jtf1;
    JPasswordField jpf1;
    String queueUrl;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        window d1 = new window();

    }

    // 构造函数
    public window() {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("发送消息");
        jlb2 = new JLabel("接收消息");

        jb1 = new JButton("发送");
        jb2 = new JButton("接收");

        jtf1 = new JTextField(20);

        jpf1 = new JPasswordField(20);
        this.setLayout(new GridLayout(5, 2));

        // 加入各个组件
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jpf1);

        jp3.add(jb1);
        jp3.add(jb2);
    jb1.addActionListener(new button1actionlisener());
        jb2.addActionListener(new button2actionlisener());
        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setSize(500, 300);
        this.setTitle("AWS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

            }
    class button1actionlisener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 打印一个已存在的队列的URL
            System.out.println(SqsUtil.getQueueUrl("Qhh"));

            // 创建一个标准类型的队列
            queueUrl = SqsUtil.createQueue("test");

            // 发送Message

            SqsUtil.sendMessage(queueUrl, jtf1.getText());

        }

    }
    class button2actionlisener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 接收Message

                SqsUtil.receiveMessages(queueUrl);


        }

    }
}
