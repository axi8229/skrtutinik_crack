package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Sl extends Vl {
    private static final Sl c = new Sl("");

    public Sl(String str) {
        super(str);
    }

    public static Sl a() {
        return c;
    }

    @Override // com.yandex.metrica.coreutils.logger.BaseLogger
    public String getTag() {
        return "AppMetricaInternal";
    }

    @Override // com.yandex.metrica.coreutils.logger.BaseLogger
    protected boolean shouldLog() {
        super.shouldLog();
        return false;
    }

    private Sl() {
        this("");
    }
}
