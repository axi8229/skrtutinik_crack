package sputnik.axmor.com.sputnik.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntentProcessingUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/FaqDeeplinkParams;", "", "", "categoryId", "subcategoryId", "questionId", "<init>", "(JLjava/lang/Long;Ljava/lang/Long;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getCategoryId", "()J", "Ljava/lang/Long;", "getSubcategoryId", "()Ljava/lang/Long;", "getQuestionId", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* data */ class FaqDeeplinkParams {
    private final long categoryId;
    private final Long questionId;
    private final Long subcategoryId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqDeeplinkParams)) {
            return false;
        }
        FaqDeeplinkParams faqDeeplinkParams = (FaqDeeplinkParams) other;
        return this.categoryId == faqDeeplinkParams.categoryId && Intrinsics.areEqual(this.subcategoryId, faqDeeplinkParams.subcategoryId) && Intrinsics.areEqual(this.questionId, faqDeeplinkParams.questionId);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.categoryId) * 31;
        Long l = this.subcategoryId;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.questionId;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "FaqDeeplinkParams(categoryId=" + this.categoryId + ", subcategoryId=" + this.subcategoryId + ", questionId=" + this.questionId + ")";
    }

    public FaqDeeplinkParams(long j, Long l, Long l2) {
        this.categoryId = j;
        this.subcategoryId = l;
        this.questionId = l2;
    }

    public /* synthetic */ FaqDeeplinkParams(long j, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    public final Long getSubcategoryId() {
        return this.subcategoryId;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }
}
