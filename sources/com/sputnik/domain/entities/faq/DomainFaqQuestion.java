package com.sputnik.domain.entities.faq;

import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainFaqQuestion.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/sputnik/domain/entities/faq/DomainFaqQuestion;", "", "", "id", "", "question", "answer", "link", "Lcom/sputnik/domain/entities/faq/DomainFaqQuestion$DomainFaqButton;", "button", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/faq/DomainFaqQuestion$DomainFaqButton;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "Ljava/lang/String;", "getQuestion", "getAnswer", "getLink", "Lcom/sputnik/domain/entities/faq/DomainFaqQuestion$DomainFaqButton;", "getButton", "()Lcom/sputnik/domain/entities/faq/DomainFaqQuestion$DomainFaqButton;", "DomainFaqButton", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainFaqQuestion {
    private final String answer;
    private final DomainFaqButton button;
    private final Long id;
    private final String link;
    private final String question;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainFaqQuestion)) {
            return false;
        }
        DomainFaqQuestion domainFaqQuestion = (DomainFaqQuestion) other;
        return Intrinsics.areEqual(this.id, domainFaqQuestion.id) && Intrinsics.areEqual(this.question, domainFaqQuestion.question) && Intrinsics.areEqual(this.answer, domainFaqQuestion.answer) && Intrinsics.areEqual(this.link, domainFaqQuestion.link) && Intrinsics.areEqual(this.button, domainFaqQuestion.button);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.question;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.answer;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.link;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        DomainFaqButton domainFaqButton = this.button;
        return iHashCode4 + (domainFaqButton != null ? domainFaqButton.hashCode() : 0);
    }

    public String toString() {
        return "DomainFaqQuestion(id=" + this.id + ", question=" + this.question + ", answer=" + this.answer + ", link=" + this.link + ", button=" + this.button + ")";
    }

    public DomainFaqQuestion(Long l, String str, String str2, String str3, DomainFaqButton domainFaqButton) {
        this.id = l;
        this.question = str;
        this.answer = str2;
        this.link = str3;
        this.button = domainFaqButton;
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

    public final String getLink() {
        return this.link;
    }

    public final DomainFaqButton getButton() {
        return this.button;
    }

    /* compiled from: DomainFaqQuestion.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/sputnik/domain/entities/faq/DomainFaqQuestion$DomainFaqButton;", "", "", "id", "", RemoteMessageConst.Notification.COLOR, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "deeplink", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "Ljava/lang/String;", "getColor", "getTitle", "getDeeplink", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DomainFaqButton {
        private final String color;
        private final String deeplink;
        private final Long id;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DomainFaqButton)) {
                return false;
            }
            DomainFaqButton domainFaqButton = (DomainFaqButton) other;
            return Intrinsics.areEqual(this.id, domainFaqButton.id) && Intrinsics.areEqual(this.color, domainFaqButton.color) && Intrinsics.areEqual(this.title, domainFaqButton.title) && Intrinsics.areEqual(this.deeplink, domainFaqButton.deeplink);
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
            return "DomainFaqButton(id=" + this.id + ", color=" + this.color + ", title=" + this.title + ", deeplink=" + this.deeplink + ")";
        }

        public DomainFaqButton(Long l, String str, String str2, String str3) {
            this.id = l;
            this.color = str;
            this.title = str2;
            this.deeplink = str3;
        }

        public final Long getId() {
            return this.id;
        }

        public final String getColor() {
            return this.color;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDeeplink() {
            return this.deeplink;
        }
    }
}
