package ru.yoomoney.sdk.core_api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiErrorBodyResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/core_api/ArgumentRuleViolationErrorResponse;", "T", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "rule", "description", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getRule", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/String;)Lru/yoomoney/sdk/core_api/ArgumentRuleViolationErrorResponse;", "equals", "", "other", "", "hashCode", "", "toString", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ArgumentRuleViolationErrorResponse<T> extends ApiErrorBodyResponse {
    private final String description;
    private final T rule;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArgumentRuleViolationErrorResponse copy$default(ArgumentRuleViolationErrorResponse argumentRuleViolationErrorResponse, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = argumentRuleViolationErrorResponse.rule;
        }
        if ((i & 2) != 0) {
            str = argumentRuleViolationErrorResponse.description;
        }
        return argumentRuleViolationErrorResponse.copy(obj, str);
    }

    public final T component1() {
        return this.rule;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final ArgumentRuleViolationErrorResponse<T> copy(T rule, String description) {
        return new ArgumentRuleViolationErrorResponse<>(rule, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArgumentRuleViolationErrorResponse)) {
            return false;
        }
        ArgumentRuleViolationErrorResponse argumentRuleViolationErrorResponse = (ArgumentRuleViolationErrorResponse) other;
        return Intrinsics.areEqual(this.rule, argumentRuleViolationErrorResponse.rule) && Intrinsics.areEqual(this.description, argumentRuleViolationErrorResponse.description);
    }

    public int hashCode() {
        T t = this.rule;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        String str = this.description;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ArgumentRuleViolationErrorResponse(rule=" + this.rule + ", description=" + this.description + ")";
    }

    public final T getRule() {
        return this.rule;
    }

    public final String getDescription() {
        return this.description;
    }

    public ArgumentRuleViolationErrorResponse(T t, String str) {
        super(null);
        this.rule = t;
        this.description = str;
    }
}
