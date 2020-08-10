package HW6_1;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("Калькулятор валют");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 800, 100);
        Font font = new Font("Aril", Font.PLAIN, 20);
        Font fontI = new Font("Aril", Font.ITALIC, 20);
        Font fontSmall = new Font("Aril", Font.PLAIN, 15);

        //Надписи
        JLabel sumLabel = new JLabel("Сумма: ");
        sumLabel.setFont(fontI);

        JLabel kursLabel = new JLabel("по курсу ");
        kursLabel.setFont(fontI);

        //Поля
        JTextField sumFirst = new JTextField("");
        sumFirst.setPreferredSize(new Dimension(200, 20));
        PlainDocument doc = (PlainDocument) sumFirst.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        sumFirst.setFont(font);

        JTextField sumSecond = new JTextField("");
        sumSecond.setPreferredSize(new Dimension(200, 20));
        sumSecond.setEnabled(false);
        sumSecond.setFont(font);

        JTextField kurs = new JTextField("0");
        kurs.setPreferredSize(new Dimension(200, 20));
        kurs.setFont(font);

        //Кнопочка
        JButton equalButton = new JButton("<->");
        equalButton.setFont(font);
        equalButton.setSize(100, 100);//Кнопочка не хочет быть квадратной!


        //Выпадающие списки
        JComboBox curFirst = new JComboBox();
        curFirst.addItem("RUR");
        curFirst.addItem("EUR");
        curFirst.addItem("USD");
        curFirst.setFont(fontSmall);

        JComboBox curSecond = new JComboBox();
        curSecond.addItem("RUR");
        curSecond.addItem("EUR");
        curSecond.addItem("USD");
        curSecond.setFont(fontSmall);

        //Действия
        sumFirst.addActionListener(e -> {
            sumSecond.setText(calculate(sumFirst.getText(),kurs.getText()));
        });

        equalButton.addActionListener(e -> {
            String changeString = sumFirst.getText();
            sumFirst.setText(sumSecond.getText());
            sumSecond.setText(changeString);
            int changeInt = curFirst.getSelectedIndex();
            curFirst.setSelectedIndex(curSecond.getSelectedIndex());
            curSecond.setSelectedIndex(changeInt);
        });

        kurs.addActionListener(e -> {
            sumSecond.setText(calculate(sumFirst.getText(),kurs.getText()));

        });

        curFirst.addActionListener(e -> {
            kurs.setText(setKurs(curFirst.getSelectedIndex(), curSecond.getSelectedIndex()));
            sumSecond.setText(calculate(sumFirst.getText(),kurs.getText()));
        });

        curSecond.addActionListener(e -> {
            kurs.setText(setKurs(curFirst.getSelectedIndex(), curSecond.getSelectedIndex()));
            sumSecond.setText(calculate(sumFirst.getText(),kurs.getText()));
        });

        //Компануем и выводим
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        add(sumLabel);
        add(sumFirst);
        sumFirst.setText("0");
        add(curFirst);
        add(equalButton);
        add(sumSecond);
        add(curSecond);
        curSecond.setSelectedIndex(1);
        add(kursLabel);
        add(kurs);
        kurs.setText(setKurs(curFirst.getSelectedIndex(), curSecond.getSelectedIndex()));
        setVisible(true);
    }

    private String calculate(String text, String text1) {

        //здесь как-то не красиво получилось
        return String.format("%.2f", Double.parseDouble(text) * Double.parseDouble(text1)).replace(",",".");
    }

    private String setKurs(int i, int j) {
        if (i==0 && j==2) {return String.format("%.6f",1/73.64).replace(",",".");}
        else if (i==0 && j==1) {return String.format("%.6f",1/87.17).replace(",",".");}
        else if (i==1 && j==0) {return "87.17";}
        else if (i==2 && j==0) {return "73.64";}
        else if (i==1 && j==2) {return "1.18";}
        else if (i==2 && j==1) {return "0.85";}
        else {return "1";}
    }
}
