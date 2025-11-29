package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/PhoneInputType;", "", "suggestion", "Lru/yoomoney/sdk/auth/api/migration/model/PhoneInputSuggestions;", "raw", "Lru/yoomoney/sdk/auth/api/migration/model/PhoneInputRaw;", "(Lru/yoomoney/sdk/auth/api/migration/model/PhoneInputSuggestions;Lru/yoomoney/sdk/auth/api/migration/model/PhoneInputRaw;)V", "getRaw", "()Lru/yoomoney/sdk/auth/api/migration/model/PhoneInputRaw;", "getSuggestion", "()Lru/yoomoney/sdk/auth/api/migration/model/PhoneInputSuggestions;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PhoneInputType {

    @SerializedName("raw")
    private final PhoneInputRaw raw;

    @SerializedName("suggestion")
    private final PhoneInputSuggestions suggestion;

    public PhoneInputType(PhoneInputSuggestions phoneInputSuggestions, PhoneInputRaw phoneInputRaw) {
        this.suggestion = phoneInputSuggestions;
        this.raw = phoneInputRaw;
    }

    public static /* synthetic */ PhoneInputType copy$default(PhoneInputType phoneInputType, PhoneInputSuggestions phoneInputSuggestions, PhoneInputRaw phoneInputRaw, int i, Object obj) {
        if ((i & 1) != 0) {
            phoneInputSuggestions = phoneInputType.suggestion;
        }
        if ((i & 2) != 0) {
            phoneInputRaw = phoneInputType.raw;
        }
        return phoneInputType.copy(phoneInputSuggestions, phoneInputRaw);
    }

    /* renamed from: component1, reason: from getter */
    public final PhoneInputSuggestions getSuggestion() {
        return this.suggestion;
    }

    /* renamed from: component2, reason: from getter */
    public final PhoneInputRaw getRaw() {
        return this.raw;
    }

    public final PhoneInputType copy(PhoneInputSuggestions suggestion, PhoneInputRaw raw) {
        return new PhoneInputType(suggestion, raw);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneInputType)) {
            return false;
        }
        PhoneInputType phoneInputType = (PhoneInputType) other;
        return Intrinsics.areEqual(this.suggestion, phoneInputType.suggestion) && Intrinsics.areEqual(this.raw, phoneInputType.raw);
    }

    public final PhoneInputRaw getRaw() {
        return this.raw;
    }

    public final PhoneInputSuggestions getSuggestion() {
        return this.suggestion;
    }

    public int hashCode() {
        PhoneInputSuggestions phoneInputSuggestions = this.suggestion;
        int iHashCode = (phoneInputSuggestions == null ? 0 : phoneInputSuggestions.hashCode()) * 31;
        PhoneInputRaw phoneInputRaw = this.raw;
        return iHashCode + (phoneInputRaw != null ? phoneInputRaw.hashCode() : 0);
    }

    public String toString() {
        return "PhoneInputType(suggestion=" + this.suggestion + ", raw=" + this.raw + ")";
    }
}
