package com.huawei.location.lite.common.log;

import android.util.Log;
import com.fasterxml.jackson.core.JsonPointer;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes3.dex */
final class dC {
    private int FB;
    private long LW;
    private String Vw;
    private boolean dC;
    private final StringBuilder yn = new StringBuilder();

    dC(int i, String str, boolean z) {
        this.Vw = "Location";
        this.LW = 0L;
        this.FB = i;
        if (str != null) {
            this.Vw = str;
        }
        this.LW = System.currentTimeMillis();
        this.dC = z;
    }

    public String Vw() {
        StringBuilder sb = new StringBuilder();
        yn(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        yn(sb);
        sb.append(' ');
        sb.append(this.yn.toString());
        return sb.toString();
    }

    public <T> dC yn(T t) {
        this.yn.append(t);
        return this;
    }

    public String yn() {
        return ' ' + this.yn.toString();
    }

    private StringBuilder yn(StringBuilder sb) {
        String strValueOf;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.LW)));
        sb.append(' ');
        int i = this.FB;
        if (i == 3) {
            strValueOf = "D";
        } else if (i == 4) {
            strValueOf = "I";
        } else if (i != 5) {
            strValueOf = i != 6 ? String.valueOf(i) : "E";
        } else {
            strValueOf = "W";
        }
        sb.append(strValueOf);
        sb.append(JsonPointer.SEPARATOR);
        sb.append(this.Vw);
        sb.append(']');
        if (!this.dC) {
            sb.append("[m]");
        }
        return sb;
    }

    public dC yn(Throwable th) {
        this.yn.append((Object) '\n');
        this.yn.append((Object) Log.getStackTraceString(th));
        return this;
    }
}
