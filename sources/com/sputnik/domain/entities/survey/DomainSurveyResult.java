package com.sputnik.domain.entities.survey;

import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainSurveyResult.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", "", "", "surveyId", "", "optionIds", "starsCount", "", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "<init>", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSurveyId", "Ljava/util/List;", "getOptionIds", "()Ljava/util/List;", "Ljava/lang/Integer;", "getStarsCount", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getComment", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainSurveyResult {
    private final String comment;
    private final List<Integer> optionIds;
    private final Integer starsCount;
    private final int surveyId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainSurveyResult)) {
            return false;
        }
        DomainSurveyResult domainSurveyResult = (DomainSurveyResult) other;
        return this.surveyId == domainSurveyResult.surveyId && Intrinsics.areEqual(this.optionIds, domainSurveyResult.optionIds) && Intrinsics.areEqual(this.starsCount, domainSurveyResult.starsCount) && Intrinsics.areEqual(this.comment, domainSurveyResult.comment);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.surveyId) * 31) + this.optionIds.hashCode()) * 31;
        Integer num = this.starsCount;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.comment;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DomainSurveyResult(surveyId=" + this.surveyId + ", optionIds=" + this.optionIds + ", starsCount=" + this.starsCount + ", comment=" + this.comment + ")";
    }

    public DomainSurveyResult(int i, List<Integer> optionIds, Integer num, String str) {
        Intrinsics.checkNotNullParameter(optionIds, "optionIds");
        this.surveyId = i;
        this.optionIds = optionIds;
        this.starsCount = num;
        this.comment = str;
    }

    public final Integer getStarsCount() {
        return this.starsCount;
    }
}
