package com.segment.analytics;

import java.util.Map;

/* loaded from: classes3.dex */
public class Properties extends ValueMap {
    public Properties() {
    }

    Properties(Map<String, Object> map) {
        super(map);
    }

    @Override // com.segment.analytics.ValueMap
    public Properties putValue(String str, Object obj) {
        super.putValue(str, obj);
        return this;
    }
}
