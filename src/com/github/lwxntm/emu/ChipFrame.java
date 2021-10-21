package com.github.lwxntm.emu;

import com.github.lwxntm.chip.Chip;

import javax.swing.*;
import java.awt.*;

public class ChipFrame extends JFrame {
    private ChipPanel panel;
    public ChipFrame(Chip chip) {
        setPreferredSize(new Dimension(640, 320));
        pack();
        setPreferredSize(new Dimension(640 + getInsets().left + getInsets().right,
                320 + getInsets().top + getInsets().bottom));

        panel=new ChipPanel(chip);
        setLayout(new BorderLayout());
        add(panel,BorderLayout.CENTER);
        //设置默认的关闭方式，不设置的话关闭窗口程序不会自动退出
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chip-8模拟器");
        pack();
        setVisible(true);
    }
}
