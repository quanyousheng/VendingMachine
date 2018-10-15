package data;

import java.text.SimpleDateFormat;

public class LogBean {
    public String mTime;
    public String mLog;

    public LogBean(long time, String log) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        mTime = format.format(time);
        mLog = log;
    }
}