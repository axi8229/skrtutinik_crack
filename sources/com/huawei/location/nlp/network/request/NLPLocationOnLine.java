package com.huawei.location.nlp.network.request;

import com.huawei.location.nlp.network.response.Location;

/* loaded from: classes3.dex */
public class NLPLocationOnLine extends Location {
    private int source;
    private int technology;

    public int getSource() {
        return this.source;
    }

    public int getTechnology() {
        return this.technology;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setTechnology(int i) {
        this.technology = i;
    }

    @Override // com.huawei.location.nlp.network.response.Location
    public String toString() {
        return "NLPLocationOnLine{" + super.toString() + "source=" + this.source + ", technology=" + this.technology + '}';
    }
}
