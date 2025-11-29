package com.sputnik.domain.entities.alers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextWith1Param.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/alers/TextWith1Param;", "", "", "text", "param1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getParam1", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TextWith1Param {
    private final String param1;
    private final String text;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextWith1Param)) {
            return false;
        }
        TextWith1Param textWith1Param = (TextWith1Param) other;
        return Intrinsics.areEqual(this.text, textWith1Param.text) && Intrinsics.areEqual(this.param1, textWith1Param.param1);
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.param1;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TextWith1Param(text=" + this.text + ", param1=" + this.param1 + ")";
    }

    public TextWith1Param(String str, String str2) {
        this.text = str;
        this.param1 = str2;
    }

    public final String getText() {
        return this.text;
    }

    public final String getParam1() {
        return this.param1;
    }
}
