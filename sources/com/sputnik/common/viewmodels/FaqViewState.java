package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.faq.Faq;
import com.sputnik.common.entities.faq.FaqItem;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FaqViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJR\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b!\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/sputnik/common/viewmodels/FaqViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", "Lcom/sputnik/common/entities/faq/Faq;", "faq", "Lcom/sputnik/common/entities/faq/FaqItem;", "faq2", "selectedItem", "Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;", "selectedSubcategory", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Ljava/util/List;Lcom/sputnik/common/entities/faq/FaqItem;Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Ljava/util/List;Lcom/sputnik/common/entities/faq/FaqItem;Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;)Lcom/sputnik/common/viewmodels/FaqViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/util/List;", "getFaq", "()Ljava/util/List;", "getFaq2", "Lcom/sputnik/common/entities/faq/FaqItem;", "getSelectedItem", "()Lcom/sputnik/common/entities/faq/FaqItem;", "Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;", "getSelectedSubcategory", "()Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FaqViewState implements VMState {
    private final List<Faq> faq;
    private final List<FaqItem> faq2;
    private final FaqItem selectedItem;
    private final FaqItem.FaqGroup selectedSubcategory;
    private final Resource.Status serverState;

    public FaqViewState() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FaqViewState copy$default(FaqViewState faqViewState, Resource.Status status, List list, List list2, FaqItem faqItem, FaqItem.FaqGroup faqGroup, int i, Object obj) {
        if ((i & 1) != 0) {
            status = faqViewState.serverState;
        }
        if ((i & 2) != 0) {
            list = faqViewState.faq;
        }
        List list3 = list;
        if ((i & 4) != 0) {
            list2 = faqViewState.faq2;
        }
        List list4 = list2;
        if ((i & 8) != 0) {
            faqItem = faqViewState.selectedItem;
        }
        FaqItem faqItem2 = faqItem;
        if ((i & 16) != 0) {
            faqGroup = faqViewState.selectedSubcategory;
        }
        return faqViewState.copy(status, list3, list4, faqItem2, faqGroup);
    }

    public final FaqViewState copy(Resource.Status serverState, List<Faq> faq, List<? extends FaqItem> faq2, FaqItem selectedItem, FaqItem.FaqGroup selectedSubcategory) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(faq, "faq");
        Intrinsics.checkNotNullParameter(faq2, "faq2");
        return new FaqViewState(serverState, faq, faq2, selectedItem, selectedSubcategory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqViewState)) {
            return false;
        }
        FaqViewState faqViewState = (FaqViewState) other;
        return this.serverState == faqViewState.serverState && Intrinsics.areEqual(this.faq, faqViewState.faq) && Intrinsics.areEqual(this.faq2, faqViewState.faq2) && Intrinsics.areEqual(this.selectedItem, faqViewState.selectedItem) && Intrinsics.areEqual(this.selectedSubcategory, faqViewState.selectedSubcategory);
    }

    public int hashCode() {
        int iHashCode = ((((this.serverState.hashCode() * 31) + this.faq.hashCode()) * 31) + this.faq2.hashCode()) * 31;
        FaqItem faqItem = this.selectedItem;
        int iHashCode2 = (iHashCode + (faqItem == null ? 0 : faqItem.hashCode())) * 31;
        FaqItem.FaqGroup faqGroup = this.selectedSubcategory;
        return iHashCode2 + (faqGroup != null ? faqGroup.hashCode() : 0);
    }

    public String toString() {
        return "FaqViewState(serverState=" + this.serverState + ", faq=" + this.faq + ", faq2=" + this.faq2 + ", selectedItem=" + this.selectedItem + ", selectedSubcategory=" + this.selectedSubcategory + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FaqViewState(Resource.Status serverState, List<Faq> faq, List<? extends FaqItem> faq2, FaqItem faqItem, FaqItem.FaqGroup faqGroup) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(faq, "faq");
        Intrinsics.checkNotNullParameter(faq2, "faq2");
        this.serverState = serverState;
        this.faq = faq;
        this.faq2 = faq2;
        this.selectedItem = faqItem;
        this.selectedSubcategory = faqGroup;
    }

    public /* synthetic */ FaqViewState(Resource.Status status, List list, List list2, FaqItem faqItem, FaqItem.FaqGroup faqGroup, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? null : faqItem, (i & 16) != 0 ? null : faqGroup);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final List<FaqItem> getFaq2() {
        return this.faq2;
    }

    public final FaqItem getSelectedItem() {
        return this.selectedItem;
    }

    public final FaqItem.FaqGroup getSelectedSubcategory() {
        return this.selectedSubcategory;
    }
}
