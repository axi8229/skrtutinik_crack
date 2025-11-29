package com.yandex.metrica.networktasks.api;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FullUrlFormer {
    private List a = new ArrayList();
    private int b = -1;
    private String c;
    private final IParamsAppender d;
    private final ConfigProvider e;

    public FullUrlFormer(IParamsAppender iParamsAppender, ConfigProvider configProvider) {
        this.d = iParamsAppender;
        this.e = configProvider;
    }

    public void buildAndSetFullHostUrl() {
        Uri.Builder builderBuildUpon = Uri.parse((String) this.a.get(this.b)).buildUpon();
        this.d.appendParams(builderBuildUpon, this.e.getConfig());
        this.c = builderBuildUpon.build().toString();
    }

    public List getAllHosts() {
        return this.a;
    }

    public String getUrl() {
        return new com.yandex.metrica.networktasks.impl.b(this.c).a();
    }

    public boolean hasMoreHosts() {
        return this.b + 1 < this.a.size();
    }

    public void incrementAttemptNumber() {
        this.b++;
    }

    public void setHosts(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        this.a = list;
    }
}
