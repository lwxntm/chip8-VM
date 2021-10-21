package com.github.lwxntm.emu;

import com.github.lwxntm.chip.Chip;

import javax.swing.*;
import java.awt.*;

public class ChipPanel extends JPanel {
    private Chip chip;

    public ChipPanel(Chip chip) {
        this.chip = chip;
    }

    //这个程序由框架调用，用于具体实现屏幕该如何绘制
    public void paint(Graphics g) {
        byte[] display = chip.getDisplay();
        for (int i = 0; i < display.length; i++) {
            if (display[i] == 0)
                g.setColor(Color.BLACK);
            else
                g.setColor(Color.WHITE);

            int x = i % 64;
            int y = (int) Math.floor(i / 64);
            g.fillRect(x*10,y*10,10,10);
        }
    }
}
