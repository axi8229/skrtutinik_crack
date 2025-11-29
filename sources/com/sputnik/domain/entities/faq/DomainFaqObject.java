package com.sputnik.domain.entities.faq;

import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainFaqObject.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/sputnik/domain/entities/faq/DomainFaqObject;", "", "", "id", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "subcategories", "Lcom/sputnik/domain/entities/faq/DomainFaqQuestion;", "questions", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getSubcategories", "()Ljava/util/List;", "getQuestions", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainFaqObject {
    private final Integer id;
    private final List<DomainFaqQuestion> questions;
    private final List<DomainFaqObject> subcategories;
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainFaqObject)) {
            return false;
        }
        DomainFaqObject domainFaqObject = (DomainFaqObject) other;
        return Intrinsics.areEqual(this.id, domainFaqObject.id) && Intrinsics.areEqual(this.title, domainFaqObject.title) && Intrinsics.areEqual(this.subcategories, domainFaqObject.subcategories) && Intrinsics.areEqual(this.questions, domainFaqObject.questions);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<DomainFaqObject> list = this.subcategories;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<DomainFaqQuestion> list2 = this.questions;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "DomainFaqObject(id=" + this.id + ", title=" + this.title + ", subcategories=" + this.subcategories + ", questions=" + this.questions + ")";
    }

    public DomainFaqObject(Integer num, String str, List<DomainFaqObject> list, List<DomainFaqQuestion> list2) {
        this.id = num;
        this.title = str;
        this.subcategories = list;
        this.questions = list2;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<DomainFaqObject> getSubcategories() {
        return this.subcategories;
    }

    public final List<DomainFaqQuestion> getQuestions() {
        return this.questions;
    }
}
