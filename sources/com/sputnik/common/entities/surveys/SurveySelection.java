package com.sputnik.common.entities.surveys;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveySelection.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\n\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/surveys/SurveySelection;", "", "", "id", "", "description", "", "localityUuids", "", "subscribed", "unsubscribed", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getDescription", "Ljava/util/List;", "getLocalityUuids", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getSubscribed", "()Ljava/lang/Boolean;", "getUnsubscribed", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SurveySelection {
    private final String description;
    private final Integer id;
    private final List<String> localityUuids;
    private final Boolean subscribed;
    private final Boolean unsubscribed;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveySelection)) {
            return false;
        }
        SurveySelection surveySelection = (SurveySelection) other;
        return Intrinsics.areEqual(this.id, surveySelection.id) && Intrinsics.areEqual(this.description, surveySelection.description) && Intrinsics.areEqual(this.localityUuids, surveySelection.localityUuids) && Intrinsics.areEqual(this.subscribed, surveySelection.subscribed) && Intrinsics.areEqual(this.unsubscribed, surveySelection.unsubscribed);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.localityUuids;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.subscribed;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.unsubscribed;
        return iHashCode4 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "SurveySelection(id=" + this.id + ", description=" + this.description + ", localityUuids=" + this.localityUuids + ", subscribed=" + this.subscribed + ", unsubscribed=" + this.unsubscribed + ")";
    }

    public SurveySelection(Integer num, String str, List<String> list, Boolean bool, Boolean bool2) {
        this.id = num;
        this.description = str;
        this.localityUuids = list;
        this.subscribed = bool;
        this.unsubscribed = bool2;
    }
}
