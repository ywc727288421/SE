package com.se.test;

import java.util.ArrayList;
import java.util.List;

public class Resident {
    private int useBeginTime;
    private int useTime;

    //如果太晚的话就固定在晚上九点，同理太早的话也将时间固定
    public Resident(int useBeginTime, int useTime) {
        if (useBeginTime > 6)
            if (useBeginTime < 23)
                this.useBeginTime = useBeginTime;
            else
                this.useBeginTime = 21;
        else
            this.useBeginTime = 6;
        if (useTime == 0) {
            this.useTime = 1;
        } else
            this.useTime = useTime;
    }


    public boolean isUse(int now) {
        return !getNotUseTime().contains(now);
    }

    public int getUseBeginTime() {
        return useBeginTime;
    }

    public void setUseBeginTime(int useBeginTime) {
        this.useBeginTime = useBeginTime;
    }

    public int getUseTime() {
        return useTime;
    }

    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }

    //获取车位不在使用的时间段
    public List<Integer> getNotUseTime() {
        List<Integer> times = new ArrayList<>();
        for (int i = 0; i <= 23; i++) {
            if (i < useBeginTime && i < useBeginTime + useTime || i > useBeginTime && i > useBeginTime + useTime)
                times.add(i);
        }
        return times;
    }
}
