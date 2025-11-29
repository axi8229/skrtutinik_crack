package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/EmailInputType;", "", "suggestion", "Lru/yoomoney/sdk/auth/api/migration/model/EmailInputSuggestions;", "raw", "Lru/yoomoney/sdk/auth/api/migration/model/EmailInputRaw;", "(Lru/yoomoney/sdk/auth/api/migration/model/EmailInputSuggestions;Lru/yoomoney/sdk/auth/api/migration/model/EmailInputRaw;)V", "getRaw", "()Lru/yoomoney/sdk/auth/api/migration/model/EmailInputRaw;", "getSuggestion", "()Lru/yoomoney/sdk/auth/api/migration/model/EmailInputSuggestions;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EmailInputType {

    @SerializedName("raw")
    private final EmailInputRaw raw;

    @SerializedName("suggestion")
    private final EmailInputSuggestions suggestion;

    public EmailInputType(EmailInputSuggestions emailInputSuggestions, EmailInputRaw emailInputRaw) {
        this.suggestion = emailInputSuggestions;
        this.raw = emailInputRaw;
    }

    public static /* synthetic */ EmailInputType copy$default(EmailInputType emailInputType, EmailInputSuggestions emailInputSuggestions, EmailInputRaw emailInputRaw, int i, Object obj) {
        if ((i & 1) != 0) {
            emailInputSuggestions = emailInputType.suggestion;
        }
        if ((i & 2) != 0) {
            emailInputRaw = emailInputType.raw;
        }
        return emailInputType.copy(emailInputSuggestions, emailInputRaw);
    }

    /* renamed from: component1, reason: from getter */
    public final EmailInputSuggestions getSuggestion() {
        return this.suggestion;
    }

    /* renamed from: component2, reason: from getter */
    public final EmailInputRaw getRaw() {
        return this.raw;
    }

    public final EmailInputType copy(EmailInputSuggestions suggestion, EmailInputRaw raw) {
        return new EmailInputType(suggestion, raw);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailInputType)) {
            return false;
        }
        EmailInputType emailInputType = (EmailInputType) other;
        return Intrinsics.areEqual(this.suggestion, emailInputType.suggestion) && Intrinsics.areEqual(this.raw, emailInputType.raw);
    }

    public final EmailInputRaw getRaw() {
        return this.raw;
    }

    public final EmailInputSuggestions getSuggestion() {
        return this.suggestion;
    }

    public int hashCode() {
        EmailInputSuggestions emailInputSuggestions = this.suggestion;
        int iHashCode = (emailInputSuggestions == null ? 0 : emailInputSuggestions.hashCode()) * 31;
        EmailInputRaw emailInputRaw = this.raw;
        return iHashCode + (emailInputRaw != null ? emailInputRaw.hashCode() : 0);
    }

    public String toString() {
        return "EmailInputType(suggestion=" + this.suggestion + ", raw=" + this.raw + ")";
    }
}
