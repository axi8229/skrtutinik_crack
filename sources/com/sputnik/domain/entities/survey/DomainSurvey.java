package com.sputnik.domain.entities.survey;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.entities.alers.DomainButton;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainSurvey.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001:\u0001>B³\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b+\u0010*R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b,\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b-\u0010\u001dR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b.\u0010*R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b/\u0010*R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b0\u0010*R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b1\u0010\u001dR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b2\u0010\u001dR\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b9\u0010\u001dR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00108\u0006¢\u0006\f\n\u0004\b\u0017\u00103\u001a\u0004\b:\u00105R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010;\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/sputnik/domain/entities/survey/DomainSurvey;", "", "", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "multipass", "enabled", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "stars", "timed", "multioption", "startDate", "endDate", "", "Lcom/sputnik/domain/entities/survey/DomainSurveyOption;", "options", "Lcom/sputnik/domain/entities/survey/DomainSurveySelection;", "selection", "starsTitle", "Lcom/sputnik/domain/entities/alers/DomainButton;", "buttons", "Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody;", "richBody", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/sputnik/domain/entities/survey/DomainSurveySelection;Ljava/lang/String;Ljava/util/List;Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getName", "Ljava/lang/Boolean;", "getMultipass", "()Ljava/lang/Boolean;", "getEnabled", "getTitle", "getBody", "getStars", "getTimed", "getMultioption", "getStartDate", "getEndDate", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "Lcom/sputnik/domain/entities/survey/DomainSurveySelection;", "getSelection", "()Lcom/sputnik/domain/entities/survey/DomainSurveySelection;", "getStarsTitle", "getButtons", "Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody;", "getRichBody", "()Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody;", "DomainRichBody", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainSurvey {
    private final String body;
    private final List<DomainButton> buttons;
    private final Boolean enabled;
    private final String endDate;
    private final Integer id;
    private final Boolean multioption;
    private final Boolean multipass;
    private final String name;
    private final List<DomainSurveyOption> options;
    private final DomainRichBody richBody;
    private final DomainSurveySelection selection;
    private final Boolean stars;
    private final String starsTitle;
    private final String startDate;
    private final Boolean timed;
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainSurvey)) {
            return false;
        }
        DomainSurvey domainSurvey = (DomainSurvey) other;
        return Intrinsics.areEqual(this.id, domainSurvey.id) && Intrinsics.areEqual(this.name, domainSurvey.name) && Intrinsics.areEqual(this.multipass, domainSurvey.multipass) && Intrinsics.areEqual(this.enabled, domainSurvey.enabled) && Intrinsics.areEqual(this.title, domainSurvey.title) && Intrinsics.areEqual(this.body, domainSurvey.body) && Intrinsics.areEqual(this.stars, domainSurvey.stars) && Intrinsics.areEqual(this.timed, domainSurvey.timed) && Intrinsics.areEqual(this.multioption, domainSurvey.multioption) && Intrinsics.areEqual(this.startDate, domainSurvey.startDate) && Intrinsics.areEqual(this.endDate, domainSurvey.endDate) && Intrinsics.areEqual(this.options, domainSurvey.options) && Intrinsics.areEqual(this.selection, domainSurvey.selection) && Intrinsics.areEqual(this.starsTitle, domainSurvey.starsTitle) && Intrinsics.areEqual(this.buttons, domainSurvey.buttons) && Intrinsics.areEqual(this.richBody, domainSurvey.richBody);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.multipass;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.enabled;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.body;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool3 = this.stars;
        int iHashCode7 = (iHashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.timed;
        int iHashCode8 = (iHashCode7 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.multioption;
        int iHashCode9 = (iHashCode8 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        String str4 = this.startDate;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.endDate;
        int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<DomainSurveyOption> list = this.options;
        int iHashCode12 = (iHashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        DomainSurveySelection domainSurveySelection = this.selection;
        int iHashCode13 = (iHashCode12 + (domainSurveySelection == null ? 0 : domainSurveySelection.hashCode())) * 31;
        String str6 = this.starsTitle;
        int iHashCode14 = (((iHashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.buttons.hashCode()) * 31;
        DomainRichBody domainRichBody = this.richBody;
        return iHashCode14 + (domainRichBody != null ? domainRichBody.hashCode() : 0);
    }

    public String toString() {
        return "DomainSurvey(id=" + this.id + ", name=" + this.name + ", multipass=" + this.multipass + ", enabled=" + this.enabled + ", title=" + this.title + ", body=" + this.body + ", stars=" + this.stars + ", timed=" + this.timed + ", multioption=" + this.multioption + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", options=" + this.options + ", selection=" + this.selection + ", starsTitle=" + this.starsTitle + ", buttons=" + this.buttons + ", richBody=" + this.richBody + ")";
    }

    public DomainSurvey(Integer num, String str, Boolean bool, Boolean bool2, String str2, String str3, Boolean bool3, Boolean bool4, Boolean bool5, String str4, String str5, List<DomainSurveyOption> list, DomainSurveySelection domainSurveySelection, String str6, List<DomainButton> buttons, DomainRichBody domainRichBody) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        this.id = num;
        this.name = str;
        this.multipass = bool;
        this.enabled = bool2;
        this.title = str2;
        this.body = str3;
        this.stars = bool3;
        this.timed = bool4;
        this.multioption = bool5;
        this.startDate = str4;
        this.endDate = str5;
        this.options = list;
        this.selection = domainSurveySelection;
        this.starsTitle = str6;
        this.buttons = buttons;
        this.richBody = domainRichBody;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getMultipass() {
        return this.multipass;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final Boolean getStars() {
        return this.stars;
    }

    public final Boolean getTimed() {
        return this.timed;
    }

    public final Boolean getMultioption() {
        return this.multioption;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final List<DomainSurveyOption> getOptions() {
        return this.options;
    }

    public final DomainSurveySelection getSelection() {
        return this.selection;
    }

    public final String getStarsTitle() {
        return this.starsTitle;
    }

    public final List<DomainButton> getButtons() {
        return this.buttons;
    }

    public final DomainRichBody getRichBody() {
        return this.richBody;
    }

    /* compiled from: DomainSurvey.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody;", "", "Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody$DomainNotice;", "notice", "<init>", "(Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody$DomainNotice;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody$DomainNotice;", "getNotice", "()Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody$DomainNotice;", "DomainNotice", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DomainRichBody {
        private final DomainNotice notice;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DomainRichBody) && Intrinsics.areEqual(this.notice, ((DomainRichBody) other).notice);
        }

        public int hashCode() {
            DomainNotice domainNotice = this.notice;
            if (domainNotice == null) {
                return 0;
            }
            return domainNotice.hashCode();
        }

        public String toString() {
            return "DomainRichBody(notice=" + this.notice + ")";
        }

        public DomainRichBody(DomainNotice domainNotice) {
            this.notice = domainNotice;
        }

        public final DomainNotice getNotice() {
            return this.notice;
        }

        /* compiled from: DomainSurvey.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/survey/DomainSurvey$DomainRichBody$DomainNotice;", "", "", "body", RemoteMessageConst.MessageBody.PARAM, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBody", "getParam", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class DomainNotice {
            private final String body;
            private final String param;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DomainNotice)) {
                    return false;
                }
                DomainNotice domainNotice = (DomainNotice) other;
                return Intrinsics.areEqual(this.body, domainNotice.body) && Intrinsics.areEqual(this.param, domainNotice.param);
            }

            public int hashCode() {
                String str = this.body;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.param;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "DomainNotice(body=" + this.body + ", param=" + this.param + ")";
            }

            public DomainNotice(String str, String str2) {
                this.body = str;
                this.param = str2;
            }

            public final String getBody() {
                return this.body;
            }

            public final String getParam() {
                return this.param;
            }
        }
    }
}
