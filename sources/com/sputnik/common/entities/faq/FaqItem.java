package com.sputnik.common.entities.faq;

import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FaqItem.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/entities/faq/FaqItem;", "", "()V", "id", "", "getId", "()Ljava/lang/Integer;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "getTitle", "()Ljava/lang/String;", "FaqCategory", "FaqGroup", "Lcom/sputnik/common/entities/faq/FaqItem$FaqCategory;", "Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class FaqItem {
    public /* synthetic */ FaqItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Integer getId();

    public abstract String getTitle();

    private FaqItem() {
    }

    /* compiled from: FaqItem.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;", "Lcom/sputnik/common/entities/faq/FaqItem;", "", "id", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Lcom/sputnik/common/entities/faq/FaqItem$FaqCategory;", "subcategories", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getSubcategories", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FaqGroup extends FaqItem {
        private final Integer id;
        private final List<FaqCategory> subcategories;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FaqGroup)) {
                return false;
            }
            FaqGroup faqGroup = (FaqGroup) other;
            return Intrinsics.areEqual(this.id, faqGroup.id) && Intrinsics.areEqual(this.title, faqGroup.title) && Intrinsics.areEqual(this.subcategories, faqGroup.subcategories);
        }

        public int hashCode() {
            Integer num = this.id;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.title;
            return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.subcategories.hashCode();
        }

        public String toString() {
            return "FaqGroup(id=" + this.id + ", title=" + this.title + ", subcategories=" + this.subcategories + ")";
        }

        @Override // com.sputnik.common.entities.faq.FaqItem
        public Integer getId() {
            return this.id;
        }

        @Override // com.sputnik.common.entities.faq.FaqItem
        public String getTitle() {
            return this.title;
        }

        public final List<FaqCategory> getSubcategories() {
            return this.subcategories;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FaqGroup(Integer num, String str, List<FaqCategory> subcategories) {
            super(null);
            Intrinsics.checkNotNullParameter(subcategories, "subcategories");
            this.id = num;
            this.title = str;
            this.subcategories = subcategories;
        }
    }

    /* compiled from: FaqItem.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/sputnik/common/entities/faq/FaqItem$FaqCategory;", "Lcom/sputnik/common/entities/faq/FaqItem;", "", "id", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Lcom/sputnik/common/entities/faq/FaqQuestion;", "questions", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getQuestions", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FaqCategory extends FaqItem {
        private final Integer id;
        private final List<FaqQuestion> questions;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FaqCategory)) {
                return false;
            }
            FaqCategory faqCategory = (FaqCategory) other;
            return Intrinsics.areEqual(this.id, faqCategory.id) && Intrinsics.areEqual(this.title, faqCategory.title) && Intrinsics.areEqual(this.questions, faqCategory.questions);
        }

        public int hashCode() {
            Integer num = this.id;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.title;
            return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.questions.hashCode();
        }

        public String toString() {
            return "FaqCategory(id=" + this.id + ", title=" + this.title + ", questions=" + this.questions + ")";
        }

        @Override // com.sputnik.common.entities.faq.FaqItem
        public Integer getId() {
            return this.id;
        }

        @Override // com.sputnik.common.entities.faq.FaqItem
        public String getTitle() {
            return this.title;
        }

        public final List<FaqQuestion> getQuestions() {
            return this.questions;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FaqCategory(Integer num, String str, List<FaqQuestion> questions) {
            super(null);
            Intrinsics.checkNotNullParameter(questions, "questions");
            this.id = num;
            this.title = str;
            this.questions = questions;
        }
    }
}
