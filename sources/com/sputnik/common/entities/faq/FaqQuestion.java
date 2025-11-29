package com.sputnik.common.entities.faq;

import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FaqQuestion.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001:\u0001$BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001f\u0010\u000fR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b\u000b\u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/faq/FaqQuestion;", "", "", "id", "", "question", "answer", "Lcom/sputnik/common/entities/faq/FaqQuestion$FaqButton;", "button", "link", "", "isExpanded", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/faq/FaqQuestion$FaqButton;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "Ljava/lang/String;", "getQuestion", "getAnswer", "Lcom/sputnik/common/entities/faq/FaqQuestion$FaqButton;", "getButton", "()Lcom/sputnik/common/entities/faq/FaqQuestion$FaqButton;", "getLink", "Z", "()Z", "setExpanded", "(Z)V", "FaqButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FaqQuestion {
    private final String answer;
    private final FaqButton button;
    private final Long id;
    private boolean isExpanded;
    private final String link;
    private final String question;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqQuestion)) {
            return false;
        }
        FaqQuestion faqQuestion = (FaqQuestion) other;
        return Intrinsics.areEqual(this.id, faqQuestion.id) && Intrinsics.areEqual(this.question, faqQuestion.question) && Intrinsics.areEqual(this.answer, faqQuestion.answer) && Intrinsics.areEqual(this.button, faqQuestion.button) && Intrinsics.areEqual(this.link, faqQuestion.link) && this.isExpanded == faqQuestion.isExpanded;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.question;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.answer;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        FaqButton faqButton = this.button;
        int iHashCode4 = (iHashCode3 + (faqButton == null ? 0 : faqButton.hashCode())) * 31;
        String str3 = this.link;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.isExpanded;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode5 + i;
    }

    public String toString() {
        return "FaqQuestion(id=" + this.id + ", question=" + this.question + ", answer=" + this.answer + ", button=" + this.button + ", link=" + this.link + ", isExpanded=" + this.isExpanded + ")";
    }

    public FaqQuestion(Long l, String str, String str2, FaqButton faqButton, String str3, boolean z) {
        this.id = l;
        this.question = str;
        this.answer = str2;
        this.button = faqButton;
        this.link = str3;
        this.isExpanded = z;
    }

    public /* synthetic */ FaqQuestion(Long l, String str, String str2, FaqButton faqButton, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str, str2, faqButton, str3, (i & 32) != 0 ? false : z);
    }

    public final Long getId() {
        return this.id;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final FaqButton getButton() {
        return this.button;
    }

    public final String getLink() {
        return this.link;
    }

    /* renamed from: isExpanded, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    /* compiled from: FaqQuestion.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/sputnik/common/entities/faq/FaqQuestion$FaqButton;", "", "", "id", "", RemoteMessageConst.Notification.COLOR, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "deeplink", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "Ljava/lang/String;", "getColor", "getTitle", "getDeeplink", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FaqButton {
        private final String color;
        private final String deeplink;
        private final Long id;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FaqButton)) {
                return false;
            }
            FaqButton faqButton = (FaqButton) other;
            return Intrinsics.areEqual(this.id, faqButton.id) && Intrinsics.areEqual(this.color, faqButton.color) && Intrinsics.areEqual(this.title, faqButton.title) && Intrinsics.areEqual(this.deeplink, faqButton.deeplink);
        }

        public int hashCode() {
            Long l = this.id;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            String str = this.color;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.title;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.deeplink;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "FaqButton(id=" + this.id + ", color=" + this.color + ", title=" + this.title + ", deeplink=" + this.deeplink + ")";
        }

        public FaqButton(Long l, String str, String str2, String str3) {
            this.id = l;
            this.color = str;
            this.title = str2;
            this.deeplink = str3;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDeeplink() {
            return this.deeplink;
        }
    }
}
