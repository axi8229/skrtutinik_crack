package com.yandex.metrica.impl.ob;

import android.util.Pair;
import java.util.List;

/* loaded from: classes3.dex */
public class Oh {
    public final List<Pair<String, a>> a;

    public static class a {
        public final String a;

        public a(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    public Oh(List<Pair<String, a>> list) {
        this.a = list;
    }

    public String toString() {
        return "AttributionConfig{deeplinkConditions=" + this.a + '}';
    }
}
