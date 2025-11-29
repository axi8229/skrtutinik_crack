package com.huawei.location.crowdsourcing.upload.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class FB {
    public final List<yn> FB = new LinkedList();
    public final String Vw;
    public final String yn;

    public static class yn {
        public final Map<String, String> FB;
        public final long Vw;
        public final String yn;

        public yn(String str, long j, Map<String, String> map) {
            this.yn = str;
            this.Vw = j;
            this.FB = map;
        }
    }

    public FB(String str, String str2) {
        this.yn = str;
        this.Vw = str2;
    }
}
