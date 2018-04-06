package nettyTest;

import java.util.Date;

/**
 * Created by CS on 2018/4/6.
 */
public class UnixTime {
    public long getTime() {
        return time;
    }

    private long time;

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long time) {

        this.time = time;
    }

    @Override
    public String toString() {
        return new Date((time - 2208988800L) * 1000L).toString();
    }
}
