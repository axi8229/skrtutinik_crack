package com.group_ib.sdk;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class Z0 {
    public static /* synthetic */ String a(int i) {
        switch (i) {
            case 1:
                return "NO";
            case 2:
                return "ERROR";
            case 3:
                return "WARN";
            case 4:
                return "INFO";
            case 5:
                return "VERBOSE";
            case 6:
                return "VERBOSE_ERROR";
            case 7:
                return "DEBUG";
            default:
                throw null;
        }
    }

    public static /* synthetic */ int a(String str) {
        if (str == null) {
            throw new NullPointerException("Name is null");
        }
        if (str.equals("NO")) {
            return 1;
        }
        if (str.equals("ERROR")) {
            return 2;
        }
        if (str.equals("WARN")) {
            return 3;
        }
        if (str.equals("INFO")) {
            return 4;
        }
        if (str.equals("VERBOSE")) {
            return 5;
        }
        if (str.equals("VERBOSE_ERROR")) {
            return 6;
        }
        if (str.equals("DEBUG")) {
            return 7;
        }
        throw new IllegalArgumentException("No enum constant com.group_ib.sdk.w.a.".concat(str));
    }
}
