package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.surveys.Survey;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.survey.DomainSurveyResult;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveysViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012Jz\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b!\u0010 R\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b+\u0010*R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b-\u0010\u0016R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/sputnik/common/viewmodels/SurveysState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "uploadResultState", "", "Lcom/sputnik/common/entities/surveys/Survey;", "surveys", "", "surveysDismissed", "Lcom/sputnik/domain/common/Event;", "requestedSurvey", "needToReload", "", "lastRequestedSurveyName", "Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", "uploadResultData", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/entities/survey/DomainSurveyResult;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;Lcom/sputnik/domain/entities/survey/DomainSurveyResult;)Lcom/sputnik/common/viewmodels/SurveysState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getUploadResultState", "Ljava/util/List;", "getSurveys", "()Ljava/util/List;", "Z", "getSurveysDismissed", "()Z", "Lcom/sputnik/domain/common/Event;", "getRequestedSurvey", "()Lcom/sputnik/domain/common/Event;", "getNeedToReload", "Ljava/lang/String;", "getLastRequestedSurveyName", "Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", "getUploadResultData", "()Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SurveysState implements VMState {
    private final String lastRequestedSurveyName;
    private final Event<Boolean> needToReload;
    private final Event<Survey> requestedSurvey;
    private final Resource.Status serverState;
    private final List<Survey> surveys;
    private final boolean surveysDismissed;
    private final DomainSurveyResult uploadResultData;
    private final Resource.Status uploadResultState;

    public SurveysState() {
        this(null, null, null, false, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    public final SurveysState copy(Resource.Status serverState, Resource.Status uploadResultState, List<Survey> surveys, boolean surveysDismissed, Event<Survey> requestedSurvey, Event<Boolean> needToReload, String lastRequestedSurveyName, DomainSurveyResult uploadResultData) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(uploadResultState, "uploadResultState");
        Intrinsics.checkNotNullParameter(needToReload, "needToReload");
        return new SurveysState(serverState, uploadResultState, surveys, surveysDismissed, requestedSurvey, needToReload, lastRequestedSurveyName, uploadResultData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveysState)) {
            return false;
        }
        SurveysState surveysState = (SurveysState) other;
        return this.serverState == surveysState.serverState && this.uploadResultState == surveysState.uploadResultState && Intrinsics.areEqual(this.surveys, surveysState.surveys) && this.surveysDismissed == surveysState.surveysDismissed && Intrinsics.areEqual(this.requestedSurvey, surveysState.requestedSurvey) && Intrinsics.areEqual(this.needToReload, surveysState.needToReload) && Intrinsics.areEqual(this.lastRequestedSurveyName, surveysState.lastRequestedSurveyName) && Intrinsics.areEqual(this.uploadResultData, surveysState.uploadResultData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.serverState.hashCode() * 31) + this.uploadResultState.hashCode()) * 31;
        List<Survey> list = this.surveys;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z = this.surveysDismissed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        Event<Survey> event = this.requestedSurvey;
        int iHashCode3 = (((i2 + (event == null ? 0 : event.hashCode())) * 31) + this.needToReload.hashCode()) * 31;
        String str = this.lastRequestedSurveyName;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        DomainSurveyResult domainSurveyResult = this.uploadResultData;
        return iHashCode4 + (domainSurveyResult != null ? domainSurveyResult.hashCode() : 0);
    }

    public String toString() {
        return "SurveysState(serverState=" + this.serverState + ", uploadResultState=" + this.uploadResultState + ", surveys=" + this.surveys + ", surveysDismissed=" + this.surveysDismissed + ", requestedSurvey=" + this.requestedSurvey + ", needToReload=" + this.needToReload + ", lastRequestedSurveyName=" + this.lastRequestedSurveyName + ", uploadResultData=" + this.uploadResultData + ")";
    }

    public SurveysState(Resource.Status serverState, Resource.Status uploadResultState, List<Survey> list, boolean z, Event<Survey> event, Event<Boolean> needToReload, String str, DomainSurveyResult domainSurveyResult) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(uploadResultState, "uploadResultState");
        Intrinsics.checkNotNullParameter(needToReload, "needToReload");
        this.serverState = serverState;
        this.uploadResultState = uploadResultState;
        this.surveys = list;
        this.surveysDismissed = z;
        this.requestedSurvey = event;
        this.needToReload = needToReload;
        this.lastRequestedSurveyName = str;
        this.uploadResultData = domainSurveyResult;
    }

    public /* synthetic */ SurveysState(Resource.Status status, Resource.Status status2, List list, boolean z, Event event, Event event2, String str, DomainSurveyResult domainSurveyResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : event, (i & 32) != 0 ? new Event(Boolean.FALSE) : event2, (i & 64) != 0 ? null : str, (i & 128) == 0 ? domainSurveyResult : null);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Resource.Status getUploadResultState() {
        return this.uploadResultState;
    }

    public final List<Survey> getSurveys() {
        return this.surveys;
    }

    public final boolean getSurveysDismissed() {
        return this.surveysDismissed;
    }

    public final Event<Survey> getRequestedSurvey() {
        return this.requestedSurvey;
    }

    public final Event<Boolean> getNeedToReload() {
        return this.needToReload;
    }

    public final String getLastRequestedSurveyName() {
        return this.lastRequestedSurveyName;
    }

    public final DomainSurveyResult getUploadResultData() {
        return this.uploadResultData;
    }
}
