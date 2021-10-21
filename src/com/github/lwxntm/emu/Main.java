package com.github.lwxntm.emu;

import com.github.lwxntm.chip.Chip;

public class Main {

    public static void main(String[] args) {
        Chip c=new Chip();
        c.init();
     //   c.run();
        ChipFrame f=new ChipFrame(c);

    }
}
