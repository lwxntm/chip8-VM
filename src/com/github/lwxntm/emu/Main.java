package com.github.lwxntm.emu;

import com.github.lwxntm.chip.Chip;

public class Main extends Thread {
    private Chip chip8;
    private ChipFrame frame;

    public Main() {
        chip8 = new Chip();
        chip8.init();
        chip8.loadProgram("./pong.ch8");
        frame = new ChipFrame(chip8);
    }
    public void run(){
        //chip8的CPU频率是60Hz,也就是每秒更新60次
        while (true){
            chip8.run();
            if (chip8.needRedraw()){
                frame.repaint();
                chip8.removeDrawFlag();
            }
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
