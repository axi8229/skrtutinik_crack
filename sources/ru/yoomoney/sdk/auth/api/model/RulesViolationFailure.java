package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RulesViolationFailure;", "Lru/yoomoney/sdk/auth/api/model/Failure;", "rule", "Lru/yoomoney/sdk/auth/api/model/RuleViolationType;", "(Lru/yoomoney/sdk/auth/api/model/RuleViolationType;)V", "getRule", "()Lru/yoomoney/sdk/auth/api/model/RuleViolationType;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RulesViolationFailure extends Failure {
    public static final Parcelable.Creator<RulesViolationFailure> CREATOR = new Creator();
    private final RuleViolationType rule;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RulesViolationFailure> {
        @Override // android.os.Parcelable.Creator
        public final RulesViolationFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RulesViolationFailure(RuleViolationType.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final RulesViolationFailure[] newArray(int i) {
            return new RulesViolationFailure[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RulesViolationFailure(RuleViolationType rule) {
        super(null);
        Intrinsics.checkNotNullParameter(rule, "rule");
        this.rule = rule;
    }

    public static /* synthetic */ RulesViolationFailure copy$default(RulesViolationFailure rulesViolationFailure, RuleViolationType ruleViolationType, int i, Object obj) {
        if ((i & 1) != 0) {
            ruleViolationType = rulesViolationFailure.rule;
        }
        return rulesViolationFailure.copy(ruleViolationType);
    }

    /* renamed from: component1, reason: from getter */
    public final RuleViolationType getRule() {
        return this.rule;
    }

    public final RulesViolationFailure copy(RuleViolationType rule) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        return new RulesViolationFailure(rule);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RulesViolationFailure) && this.rule == ((RulesViolationFailure) other).rule;
    }

    public final RuleViolationType getRule() {
        return this.rule;
    }

    public int hashCode() {
        return this.rule.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RulesViolationFailure(rule=" + this.rule + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.rule.name());
    }
}
