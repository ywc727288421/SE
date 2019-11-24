package com.se.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private int residentsNumber;
    private List<Resident> residents = new ArrayList<>();
    private int nowTime = 7;
    private int peopleNum = 0;
    private List<Resident> socialCar = new ArrayList<>();
    private int socialCarCount = 0;

    public Main(int residentsNumber) {
        this.residentsNumber = residentsNumber;
    }

    //获取已经使用的车位（用二维表来表示）
    public int[][] useList(int time) {
        int xx = 0;
        int[][] nowList = new int[this.peopleNum / 5 + 1][5];
        int now = 0;
        for (int i = 0; i < this.peopleNum / 5 + 1; i++) {
            for (int j = 0; j < 5 && now < this.peopleNum; j++) {
                boolean flag = residents.get(now).isUse(time);
                now++;
                if (flag) {
                    nowList[i][j] = 1;
                }
                if (nowList[i][j] == 0 && xx <= this.socialCarCount) {
                    nowList[i][j] = 1;
                    xx++;
                }
            }
        }
        return nowList;
    }

    //获得当前社会车辆的个数
    public void getSocialCarCount(int time) {
        int count = 0;
        for (int i = 0; i < socialCar.size(); i++)
            if (socialCar.get(i).isUse(time)) {
                count++;
            }
        this.socialCarCount = count;
    }

    //获取当前可用的车位个数
    public int getNowCanUseNum(int time, int[][] x) {
        int now = 0;
        int use = 0;
        for (int i = 0; i < this.peopleNum / 5 + 1; i++) {
            for (int j = 0; j < 5 && now < this.peopleNum; j++) {
                if (x[i][j] == 1) {
                    use++;
                }
            }
        }
        return peopleNum - use;
    }

    //显示当前车位的占用情况
    public void display(int[][] x) {
        int now = 0;
        for (int i = 0; i < this.peopleNum / 5 + 1; i++) {
            for (int j = 0; j < 5 && now < this.peopleNum; j++) {
                now++;
                System.out.print(x[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //获取随机需要停车的居民，开始时间和停车时间都随机
    //随机事件最长6个小时
    public void createResidentRandom() {
        for (int i = 0; i < residentsNumber; i++) {
            residents.add(new Resident((int) ((Math.random() * 24) % 24), (int) ((Math.random() * 10) % 6)));
        }
    }

    //银行家算法
    //0表示满了不能再插入了
    public boolean insertCar(int nowTime, int parkingTime, Resident resident) {
        socialCar.add(resident);
        getSocialCarCount(nowTime);
        for (int i = nowTime; i < nowTime + parkingTime; i++) {
            if (getNowCanUseNum(nowTime, useList(nowTime)) <= 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        System.out.println("请输入小区车位数:");
        x = scanner.nextInt();
        Main main = new Main(x);
        main.peopleNum = x;
        main.createResidentRandom();
        System.out.println("居民使用时间如下:");
        int ii=1;
        for (Resident resident:main.residents)
        {
            System.out.println("居民"+ii+"使用时间:"+resident.getUseBeginTime()+" 持续时间:"+resident.getUseTime());
            ii++;
        }
        System.out.println();
        System.out.println("请输入当前时间:(大于等于6,半夜不开门)");
        x = scanner.nextInt();
        main.nowTime = x;
        System.out.println("现在时间是:" + main.nowTime);
        System.out.println("当前车位使用情况:(0代表当前车位没有被占用,1则反之)");
        int[][] xxxx = main.useList(main.nowTime);
        main.display(xxxx);
        int num = main.getNowCanUseNum(main.nowTime, xxxx);
        System.out.println("当前有" + num + "个车位可以供社会车辆使用");
        int x2;
        while (true) {
            System.out.println("请选择要执行的动作:");
            System.out.println("1,添加n辆社会车辆(当前时间作为起始时间,停车时间为随机)");
            System.out.println("2,更改当前时间");
            x2 = scanner.nextInt();
            if (x2 == -1)
                break;
            else if (x2 == 1) {
                System.out.println("请输入要增加多少随机车辆");
                x2 = scanner.nextInt();
                for (int i = 0; i < x2; i++) {
                    int xxx = (int) ((Math.random() * 10) % 5) + 1;
                    System.out.println("添加第" + (i + 1) + "辆社会车辆:停车时间为" + main.nowTime + "到" + (main.nowTime + xxx) + "点");
                    Resident newCar = new Resident(main.nowTime, xxx);
                    if (main.insertCar(main.nowTime, xxx, newCar)) {
                        System.out.println("第" + (i + 1) + "辆社会车辆插入成功");
                    } else {
                        System.out.println("第" + (i + 1) + "辆社会车辆插入失败,已经没有可用的车位了！");
                    }
                    System.out.println("当前车位使用情况:(0代表当前车位没有被占用,1则反之)");
                    int[][] dsa = main.useList(main.nowTime);
                    main.display(dsa);
                }
            } else if (x2 == 2) {
                System.out.println("请输入你要更改的时间:");
                x2 = scanner.nextInt();
                main.nowTime = x2;
                main.getSocialCarCount(main.nowTime);
                System.out.println("现在时间是:" + main.nowTime);
                System.out.println("当前车位使用情况:(0代表当前车位没有被占用,1则反之)");
                xxxx = main.useList(main.nowTime);
                main.display(xxxx);
                num = main.getNowCanUseNum(main.nowTime, xxxx);
                System.out.println("当前有" + num + "个车位可以供社会车辆使用");
            }
        }
    }
}
