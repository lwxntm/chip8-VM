package com.github.lwxntm.chip;

public class Chip {

    //chip-8有4KB的内存，这里使用char数组来储存
    private char[] memory;

    //chip-8有16个寄存器
    private  char[] v;

    //地址指针
    private  char I;

    //应用程序指针
    private  char programCounter;

    private  char[] stack;
    private  int stackPointer;

    private  int delay_timer;
    private  int sound_timer;


    //keys是键盘输入
    private  byte[] keys;

    //chip-8有个64x32的显示屏
    private byte[] display;

    public  void init(){
        memory=new char[4096];
        v=new char[16];
        I=0x0;
        programCounter=0x200;

        stack=new char[16];
        stackPointer=0;

        delay_timer=0;
        sound_timer=0;
        keys=new byte[16];

        display=new byte[64*32];

        //for test
        for (int i = 0; i < 64 * 32; i++) {
            if (i%5==0)
                display[i]=1;
        }
    }

    public void run(){
        //fetch Opcode
        //decode Opcode
        //execute opcode
        char opCode= (char) ((memory[programCounter]<<8)|memory[programCounter+1]);
        System.out.print(Integer.toHexString(opCode)+": ");
        switch (opCode & 0xF000){
            case 0x8000: //在最后一位含有更多信息
                switch (opCode&0x000f){
                    default:
                    System.err.println("不支持的OpCode");
                    System.exit(1);
                    break;
                }
            default:
                System.err.println("不支持的OpCode");
                System.exit(1);
        }
    }

    public  byte[] getDisplay(){
        return  display;
    }
}
