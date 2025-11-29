package sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveyViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJT\u0010\u000e\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R'\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewState;", "Lcom/sputnik/common/base/VMState;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "marks", "", "commentText", "Lcom/sputnik/domain/common/Event;", "", "surveyIsSent", "positiveIsSent", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)V", "copy", "(Ljava/util/ArrayList;Ljava/lang/String;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "getMarks", "()Ljava/util/ArrayList;", "Ljava/lang/String;", "getCommentText", "Lcom/sputnik/domain/common/Event;", "getSurveyIsSent", "()Lcom/sputnik/domain/common/Event;", "getPositiveIsSent", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SurveyViewState implements VMState {
    private final String commentText;
    private final ArrayList<Integer> marks;
    private final Event<Boolean> positiveIsSent;
    private final Event<Boolean> surveyIsSent;

    public SurveyViewState() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyViewState copy$default(SurveyViewState surveyViewState, ArrayList arrayList, String str, Event event, Event event2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = surveyViewState.marks;
        }
        if ((i & 2) != 0) {
            str = surveyViewState.commentText;
        }
        if ((i & 4) != 0) {
            event = surveyViewState.surveyIsSent;
        }
        if ((i & 8) != 0) {
            event2 = surveyViewState.positiveIsSent;
        }
        return surveyViewState.copy(arrayList, str, event, event2);
    }

    public final SurveyViewState copy(ArrayList<Integer> marks, String commentText, Event<Boolean> surveyIsSent, Event<Boolean> positiveIsSent) {
        Intrinsics.checkNotNullParameter(marks, "marks");
        Intrinsics.checkNotNullParameter(commentText, "commentText");
        Intrinsics.checkNotNullParameter(surveyIsSent, "surveyIsSent");
        Intrinsics.checkNotNullParameter(positiveIsSent, "positiveIsSent");
        return new SurveyViewState(marks, commentText, surveyIsSent, positiveIsSent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyViewState)) {
            return false;
        }
        SurveyViewState surveyViewState = (SurveyViewState) other;
        return Intrinsics.areEqual(this.marks, surveyViewState.marks) && Intrinsics.areEqual(this.commentText, surveyViewState.commentText) && Intrinsics.areEqual(this.surveyIsSent, surveyViewState.surveyIsSent) && Intrinsics.areEqual(this.positiveIsSent, surveyViewState.positiveIsSent);
    }

    public int hashCode() {
        return (((((this.marks.hashCode() * 31) + this.commentText.hashCode()) * 31) + this.surveyIsSent.hashCode()) * 31) + this.positiveIsSent.hashCode();
    }

    public String toString() {
        return "SurveyViewState(marks=" + this.marks + ", commentText=" + this.commentText + ", surveyIsSent=" + this.surveyIsSent + ", positiveIsSent=" + this.positiveIsSent + ")";
    }

    public SurveyViewState(ArrayList<Integer> marks, String commentText, Event<Boolean> surveyIsSent, Event<Boolean> positiveIsSent) {
        Intrinsics.checkNotNullParameter(marks, "marks");
        Intrinsics.checkNotNullParameter(commentText, "commentText");
        Intrinsics.checkNotNullParameter(surveyIsSent, "surveyIsSent");
        Intrinsics.checkNotNullParameter(positiveIsSent, "positiveIsSent");
        this.marks = marks;
        this.commentText = commentText;
        this.surveyIsSent = surveyIsSent;
        this.positiveIsSent = positiveIsSent;
    }

    public /* synthetic */ SurveyViewState(ArrayList arrayList, String str, Event event, Event event2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? new Event(Boolean.FALSE) : event, (i & 8) != 0 ? new Event(Boolean.FALSE) : event2);
    }

    public final ArrayList<Integer> getMarks() {
        return this.marks;
    }

    public final String getCommentText() {
        return this.commentText;
    }

    public final Event<Boolean> getSurveyIsSent() {
        return this.surveyIsSent;
    }

    public final Event<Boolean> getPositiveIsSent() {
        return this.positiveIsSent;
    }
}
