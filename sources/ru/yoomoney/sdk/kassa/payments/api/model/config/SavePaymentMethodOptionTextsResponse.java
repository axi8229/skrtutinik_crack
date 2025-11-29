package ru.yoomoney.sdk.kassa.payments.api.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bK\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0003¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003Jù\u0001\u0010M\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00032\b\b\u0003\u0010\u0014\u001a\u00020\u00032\b\b\u0003\u0010\u0015\u001a\u00020\u00032\b\b\u0003\u0010\u0016\u001a\u00020\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00032\b\b\u0003\u0010\u0018\u001a\u00020\u00032\b\b\u0003\u0010\u0019\u001a\u00020\u00032\b\b\u0003\u0010\u001a\u001a\u00020\u0003HÆ\u0001J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020RHÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d¨\u0006T"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/config/SavePaymentMethodOptionTextsResponse;", "", "switchRecurrentOnBindOnTitle", "", "switchRecurrentOnBindOnSubtitle", "switchRecurrentOnBindOffTitle", "switchRecurrentOnBindOffSubtitle", "switchRecurrentOffBindOnTitle", "switchRecurrentOffBindOnSubtitle", "messageRecurrentOnBindOnTitle", "messageRecurrentOnBindOnSubtitle", "messageRecurrentOnBindOffTitle", "messageRecurrentOnBindOffSubtitle", "messageRecurrentOffBindOnTitle", "messageRecurrentOffBindOnSubtitle", "screenRecurrentOnBindOnTitle", "screenRecurrentOnBindOnText", "screenRecurrentOnBindOffTitle", "screenRecurrentOnBindOffText", "screenRecurrentOffBindOnTitle", "screenRecurrentOffBindOnText", "screenRecurrentOnSberpayTitle", "screenRecurrentOnSberpayText", "messageRecurrentOnSBPTitle", "switchRecurrentOnSBPTitle", "messageRecurrentOnSberPayTitle", "switchRecurrentOnSberPayTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageRecurrentOffBindOnSubtitle", "()Ljava/lang/String;", "getMessageRecurrentOffBindOnTitle", "getMessageRecurrentOnBindOffSubtitle", "getMessageRecurrentOnBindOffTitle", "getMessageRecurrentOnBindOnSubtitle", "getMessageRecurrentOnBindOnTitle", "getMessageRecurrentOnSBPTitle", "getMessageRecurrentOnSberPayTitle", "getScreenRecurrentOffBindOnText", "getScreenRecurrentOffBindOnTitle", "getScreenRecurrentOnBindOffText", "getScreenRecurrentOnBindOffTitle", "getScreenRecurrentOnBindOnText", "getScreenRecurrentOnBindOnTitle", "getScreenRecurrentOnSberpayText", "getScreenRecurrentOnSberpayTitle", "getSwitchRecurrentOffBindOnSubtitle", "getSwitchRecurrentOffBindOnTitle", "getSwitchRecurrentOnBindOffSubtitle", "getSwitchRecurrentOnBindOffTitle", "getSwitchRecurrentOnBindOnSubtitle", "getSwitchRecurrentOnBindOnTitle", "getSwitchRecurrentOnSBPTitle", "getSwitchRecurrentOnSberPayTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SavePaymentMethodOptionTextsResponse {
    public static final int $stable = 0;
    private final String messageRecurrentOffBindOnSubtitle;
    private final String messageRecurrentOffBindOnTitle;
    private final String messageRecurrentOnBindOffSubtitle;
    private final String messageRecurrentOnBindOffTitle;
    private final String messageRecurrentOnBindOnSubtitle;
    private final String messageRecurrentOnBindOnTitle;
    private final String messageRecurrentOnSBPTitle;
    private final String messageRecurrentOnSberPayTitle;
    private final String screenRecurrentOffBindOnText;
    private final String screenRecurrentOffBindOnTitle;
    private final String screenRecurrentOnBindOffText;
    private final String screenRecurrentOnBindOffTitle;
    private final String screenRecurrentOnBindOnText;
    private final String screenRecurrentOnBindOnTitle;
    private final String screenRecurrentOnSberpayText;
    private final String screenRecurrentOnSberpayTitle;
    private final String switchRecurrentOffBindOnSubtitle;
    private final String switchRecurrentOffBindOnTitle;
    private final String switchRecurrentOnBindOffSubtitle;
    private final String switchRecurrentOnBindOffTitle;
    private final String switchRecurrentOnBindOnSubtitle;
    private final String switchRecurrentOnBindOnTitle;
    private final String switchRecurrentOnSBPTitle;
    private final String switchRecurrentOnSberPayTitle;

    public SavePaymentMethodOptionTextsResponse(@JsonProperty("switchRecurrentOnBindOnTitle") String switchRecurrentOnBindOnTitle, @JsonProperty("switchRecurrentOnBindOnSubtitle") String switchRecurrentOnBindOnSubtitle, @JsonProperty("switchRecurrentOnBindOffTitle") String switchRecurrentOnBindOffTitle, @JsonProperty("switchRecurrentOnBindOffSubtitle") String switchRecurrentOnBindOffSubtitle, @JsonProperty("switchRecurrentOffBindOnTitle") String switchRecurrentOffBindOnTitle, @JsonProperty("switchRecurrentOffBindOnSubtitle") String switchRecurrentOffBindOnSubtitle, @JsonProperty("messageRecurrentOnBindOnTitle") String messageRecurrentOnBindOnTitle, @JsonProperty("messageRecurrentOnBindOnSubtitle") String messageRecurrentOnBindOnSubtitle, @JsonProperty("messageRecurrentOnBindOffTitle") String messageRecurrentOnBindOffTitle, @JsonProperty("messageRecurrentOnBindOffSubtitle") String messageRecurrentOnBindOffSubtitle, @JsonProperty("messageRecurrentOffBindOnTitle") String messageRecurrentOffBindOnTitle, @JsonProperty("messageRecurrentOffBindOnSubtitle") String messageRecurrentOffBindOnSubtitle, @JsonProperty("screenRecurrentOnBindOnTitle") String screenRecurrentOnBindOnTitle, @JsonProperty("screenRecurrentOnBindOnText") String screenRecurrentOnBindOnText, @JsonProperty("screenRecurrentOnBindOffTitle") String screenRecurrentOnBindOffTitle, @JsonProperty("screenRecurrentOnBindOffText") String screenRecurrentOnBindOffText, @JsonProperty("screenRecurrentOffBindOnTitle") String screenRecurrentOffBindOnTitle, @JsonProperty("screenRecurrentOffBindOnText") String screenRecurrentOffBindOnText, @JsonProperty("screenRecurrentOnSberpayTitle") String screenRecurrentOnSberpayTitle, @JsonProperty("screenRecurrentOnSberpayText") String screenRecurrentOnSberpayText, @JsonProperty("messageRecurrentOnSBPTitle") String messageRecurrentOnSBPTitle, @JsonProperty("switchRecurrentOnSBPTitle") String switchRecurrentOnSBPTitle, @JsonProperty("messageRecurrentOnSberPayTitle") String messageRecurrentOnSberPayTitle, @JsonProperty("switchRecurrentOnSberPayTitle") String switchRecurrentOnSberPayTitle) {
        Intrinsics.checkNotNullParameter(switchRecurrentOnBindOnTitle, "switchRecurrentOnBindOnTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnBindOnSubtitle, "switchRecurrentOnBindOnSubtitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnBindOffTitle, "switchRecurrentOnBindOffTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnBindOffSubtitle, "switchRecurrentOnBindOffSubtitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOffBindOnTitle, "switchRecurrentOffBindOnTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOffBindOnSubtitle, "switchRecurrentOffBindOnSubtitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnBindOnTitle, "messageRecurrentOnBindOnTitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnBindOnSubtitle, "messageRecurrentOnBindOnSubtitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnBindOffTitle, "messageRecurrentOnBindOffTitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnBindOffSubtitle, "messageRecurrentOnBindOffSubtitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOffBindOnTitle, "messageRecurrentOffBindOnTitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOffBindOnSubtitle, "messageRecurrentOffBindOnSubtitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOnBindOnTitle, "screenRecurrentOnBindOnTitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOnBindOnText, "screenRecurrentOnBindOnText");
        Intrinsics.checkNotNullParameter(screenRecurrentOnBindOffTitle, "screenRecurrentOnBindOffTitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOnBindOffText, "screenRecurrentOnBindOffText");
        Intrinsics.checkNotNullParameter(screenRecurrentOffBindOnTitle, "screenRecurrentOffBindOnTitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOffBindOnText, "screenRecurrentOffBindOnText");
        Intrinsics.checkNotNullParameter(screenRecurrentOnSberpayTitle, "screenRecurrentOnSberpayTitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOnSberpayText, "screenRecurrentOnSberpayText");
        Intrinsics.checkNotNullParameter(messageRecurrentOnSBPTitle, "messageRecurrentOnSBPTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnSBPTitle, "switchRecurrentOnSBPTitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnSberPayTitle, "messageRecurrentOnSberPayTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnSberPayTitle, "switchRecurrentOnSberPayTitle");
        this.switchRecurrentOnBindOnTitle = switchRecurrentOnBindOnTitle;
        this.switchRecurrentOnBindOnSubtitle = switchRecurrentOnBindOnSubtitle;
        this.switchRecurrentOnBindOffTitle = switchRecurrentOnBindOffTitle;
        this.switchRecurrentOnBindOffSubtitle = switchRecurrentOnBindOffSubtitle;
        this.switchRecurrentOffBindOnTitle = switchRecurrentOffBindOnTitle;
        this.switchRecurrentOffBindOnSubtitle = switchRecurrentOffBindOnSubtitle;
        this.messageRecurrentOnBindOnTitle = messageRecurrentOnBindOnTitle;
        this.messageRecurrentOnBindOnSubtitle = messageRecurrentOnBindOnSubtitle;
        this.messageRecurrentOnBindOffTitle = messageRecurrentOnBindOffTitle;
        this.messageRecurrentOnBindOffSubtitle = messageRecurrentOnBindOffSubtitle;
        this.messageRecurrentOffBindOnTitle = messageRecurrentOffBindOnTitle;
        this.messageRecurrentOffBindOnSubtitle = messageRecurrentOffBindOnSubtitle;
        this.screenRecurrentOnBindOnTitle = screenRecurrentOnBindOnTitle;
        this.screenRecurrentOnBindOnText = screenRecurrentOnBindOnText;
        this.screenRecurrentOnBindOffTitle = screenRecurrentOnBindOffTitle;
        this.screenRecurrentOnBindOffText = screenRecurrentOnBindOffText;
        this.screenRecurrentOffBindOnTitle = screenRecurrentOffBindOnTitle;
        this.screenRecurrentOffBindOnText = screenRecurrentOffBindOnText;
        this.screenRecurrentOnSberpayTitle = screenRecurrentOnSberpayTitle;
        this.screenRecurrentOnSberpayText = screenRecurrentOnSberpayText;
        this.messageRecurrentOnSBPTitle = messageRecurrentOnSBPTitle;
        this.switchRecurrentOnSBPTitle = switchRecurrentOnSBPTitle;
        this.messageRecurrentOnSberPayTitle = messageRecurrentOnSberPayTitle;
        this.switchRecurrentOnSberPayTitle = switchRecurrentOnSberPayTitle;
    }

    /* renamed from: component1, reason: from getter */
    public final String getSwitchRecurrentOnBindOnTitle() {
        return this.switchRecurrentOnBindOnTitle;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMessageRecurrentOnBindOffSubtitle() {
        return this.messageRecurrentOnBindOffSubtitle;
    }

    /* renamed from: component11, reason: from getter */
    public final String getMessageRecurrentOffBindOnTitle() {
        return this.messageRecurrentOffBindOnTitle;
    }

    /* renamed from: component12, reason: from getter */
    public final String getMessageRecurrentOffBindOnSubtitle() {
        return this.messageRecurrentOffBindOnSubtitle;
    }

    /* renamed from: component13, reason: from getter */
    public final String getScreenRecurrentOnBindOnTitle() {
        return this.screenRecurrentOnBindOnTitle;
    }

    /* renamed from: component14, reason: from getter */
    public final String getScreenRecurrentOnBindOnText() {
        return this.screenRecurrentOnBindOnText;
    }

    /* renamed from: component15, reason: from getter */
    public final String getScreenRecurrentOnBindOffTitle() {
        return this.screenRecurrentOnBindOffTitle;
    }

    /* renamed from: component16, reason: from getter */
    public final String getScreenRecurrentOnBindOffText() {
        return this.screenRecurrentOnBindOffText;
    }

    /* renamed from: component17, reason: from getter */
    public final String getScreenRecurrentOffBindOnTitle() {
        return this.screenRecurrentOffBindOnTitle;
    }

    /* renamed from: component18, reason: from getter */
    public final String getScreenRecurrentOffBindOnText() {
        return this.screenRecurrentOffBindOnText;
    }

    /* renamed from: component19, reason: from getter */
    public final String getScreenRecurrentOnSberpayTitle() {
        return this.screenRecurrentOnSberpayTitle;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSwitchRecurrentOnBindOnSubtitle() {
        return this.switchRecurrentOnBindOnSubtitle;
    }

    /* renamed from: component20, reason: from getter */
    public final String getScreenRecurrentOnSberpayText() {
        return this.screenRecurrentOnSberpayText;
    }

    /* renamed from: component21, reason: from getter */
    public final String getMessageRecurrentOnSBPTitle() {
        return this.messageRecurrentOnSBPTitle;
    }

    /* renamed from: component22, reason: from getter */
    public final String getSwitchRecurrentOnSBPTitle() {
        return this.switchRecurrentOnSBPTitle;
    }

    /* renamed from: component23, reason: from getter */
    public final String getMessageRecurrentOnSberPayTitle() {
        return this.messageRecurrentOnSberPayTitle;
    }

    /* renamed from: component24, reason: from getter */
    public final String getSwitchRecurrentOnSberPayTitle() {
        return this.switchRecurrentOnSberPayTitle;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSwitchRecurrentOnBindOffTitle() {
        return this.switchRecurrentOnBindOffTitle;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSwitchRecurrentOnBindOffSubtitle() {
        return this.switchRecurrentOnBindOffSubtitle;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSwitchRecurrentOffBindOnTitle() {
        return this.switchRecurrentOffBindOnTitle;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSwitchRecurrentOffBindOnSubtitle() {
        return this.switchRecurrentOffBindOnSubtitle;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMessageRecurrentOnBindOnTitle() {
        return this.messageRecurrentOnBindOnTitle;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMessageRecurrentOnBindOnSubtitle() {
        return this.messageRecurrentOnBindOnSubtitle;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMessageRecurrentOnBindOffTitle() {
        return this.messageRecurrentOnBindOffTitle;
    }

    public final SavePaymentMethodOptionTextsResponse copy(@JsonProperty("switchRecurrentOnBindOnTitle") String switchRecurrentOnBindOnTitle, @JsonProperty("switchRecurrentOnBindOnSubtitle") String switchRecurrentOnBindOnSubtitle, @JsonProperty("switchRecurrentOnBindOffTitle") String switchRecurrentOnBindOffTitle, @JsonProperty("switchRecurrentOnBindOffSubtitle") String switchRecurrentOnBindOffSubtitle, @JsonProperty("switchRecurrentOffBindOnTitle") String switchRecurrentOffBindOnTitle, @JsonProperty("switchRecurrentOffBindOnSubtitle") String switchRecurrentOffBindOnSubtitle, @JsonProperty("messageRecurrentOnBindOnTitle") String messageRecurrentOnBindOnTitle, @JsonProperty("messageRecurrentOnBindOnSubtitle") String messageRecurrentOnBindOnSubtitle, @JsonProperty("messageRecurrentOnBindOffTitle") String messageRecurrentOnBindOffTitle, @JsonProperty("messageRecurrentOnBindOffSubtitle") String messageRecurrentOnBindOffSubtitle, @JsonProperty("messageRecurrentOffBindOnTitle") String messageRecurrentOffBindOnTitle, @JsonProperty("messageRecurrentOffBindOnSubtitle") String messageRecurrentOffBindOnSubtitle, @JsonProperty("screenRecurrentOnBindOnTitle") String screenRecurrentOnBindOnTitle, @JsonProperty("screenRecurrentOnBindOnText") String screenRecurrentOnBindOnText, @JsonProperty("screenRecurrentOnBindOffTitle") String screenRecurrentOnBindOffTitle, @JsonProperty("screenRecurrentOnBindOffText") String screenRecurrentOnBindOffText, @JsonProperty("screenRecurrentOffBindOnTitle") String screenRecurrentOffBindOnTitle, @JsonProperty("screenRecurrentOffBindOnText") String screenRecurrentOffBindOnText, @JsonProperty("screenRecurrentOnSberpayTitle") String screenRecurrentOnSberpayTitle, @JsonProperty("screenRecurrentOnSberpayText") String screenRecurrentOnSberpayText, @JsonProperty("messageRecurrentOnSBPTitle") String messageRecurrentOnSBPTitle, @JsonProperty("switchRecurrentOnSBPTitle") String switchRecurrentOnSBPTitle, @JsonProperty("messageRecurrentOnSberPayTitle") String messageRecurrentOnSberPayTitle, @JsonProperty("switchRecurrentOnSberPayTitle") String switchRecurrentOnSberPayTitle) {
        Intrinsics.checkNotNullParameter(switchRecurrentOnBindOnTitle, "switchRecurrentOnBindOnTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnBindOnSubtitle, "switchRecurrentOnBindOnSubtitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnBindOffTitle, "switchRecurrentOnBindOffTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnBindOffSubtitle, "switchRecurrentOnBindOffSubtitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOffBindOnTitle, "switchRecurrentOffBindOnTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOffBindOnSubtitle, "switchRecurrentOffBindOnSubtitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnBindOnTitle, "messageRecurrentOnBindOnTitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnBindOnSubtitle, "messageRecurrentOnBindOnSubtitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnBindOffTitle, "messageRecurrentOnBindOffTitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnBindOffSubtitle, "messageRecurrentOnBindOffSubtitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOffBindOnTitle, "messageRecurrentOffBindOnTitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOffBindOnSubtitle, "messageRecurrentOffBindOnSubtitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOnBindOnTitle, "screenRecurrentOnBindOnTitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOnBindOnText, "screenRecurrentOnBindOnText");
        Intrinsics.checkNotNullParameter(screenRecurrentOnBindOffTitle, "screenRecurrentOnBindOffTitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOnBindOffText, "screenRecurrentOnBindOffText");
        Intrinsics.checkNotNullParameter(screenRecurrentOffBindOnTitle, "screenRecurrentOffBindOnTitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOffBindOnText, "screenRecurrentOffBindOnText");
        Intrinsics.checkNotNullParameter(screenRecurrentOnSberpayTitle, "screenRecurrentOnSberpayTitle");
        Intrinsics.checkNotNullParameter(screenRecurrentOnSberpayText, "screenRecurrentOnSberpayText");
        Intrinsics.checkNotNullParameter(messageRecurrentOnSBPTitle, "messageRecurrentOnSBPTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnSBPTitle, "switchRecurrentOnSBPTitle");
        Intrinsics.checkNotNullParameter(messageRecurrentOnSberPayTitle, "messageRecurrentOnSberPayTitle");
        Intrinsics.checkNotNullParameter(switchRecurrentOnSberPayTitle, "switchRecurrentOnSberPayTitle");
        return new SavePaymentMethodOptionTextsResponse(switchRecurrentOnBindOnTitle, switchRecurrentOnBindOnSubtitle, switchRecurrentOnBindOffTitle, switchRecurrentOnBindOffSubtitle, switchRecurrentOffBindOnTitle, switchRecurrentOffBindOnSubtitle, messageRecurrentOnBindOnTitle, messageRecurrentOnBindOnSubtitle, messageRecurrentOnBindOffTitle, messageRecurrentOnBindOffSubtitle, messageRecurrentOffBindOnTitle, messageRecurrentOffBindOnSubtitle, screenRecurrentOnBindOnTitle, screenRecurrentOnBindOnText, screenRecurrentOnBindOffTitle, screenRecurrentOnBindOffText, screenRecurrentOffBindOnTitle, screenRecurrentOffBindOnText, screenRecurrentOnSberpayTitle, screenRecurrentOnSberpayText, messageRecurrentOnSBPTitle, switchRecurrentOnSBPTitle, messageRecurrentOnSberPayTitle, switchRecurrentOnSberPayTitle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SavePaymentMethodOptionTextsResponse)) {
            return false;
        }
        SavePaymentMethodOptionTextsResponse savePaymentMethodOptionTextsResponse = (SavePaymentMethodOptionTextsResponse) other;
        return Intrinsics.areEqual(this.switchRecurrentOnBindOnTitle, savePaymentMethodOptionTextsResponse.switchRecurrentOnBindOnTitle) && Intrinsics.areEqual(this.switchRecurrentOnBindOnSubtitle, savePaymentMethodOptionTextsResponse.switchRecurrentOnBindOnSubtitle) && Intrinsics.areEqual(this.switchRecurrentOnBindOffTitle, savePaymentMethodOptionTextsResponse.switchRecurrentOnBindOffTitle) && Intrinsics.areEqual(this.switchRecurrentOnBindOffSubtitle, savePaymentMethodOptionTextsResponse.switchRecurrentOnBindOffSubtitle) && Intrinsics.areEqual(this.switchRecurrentOffBindOnTitle, savePaymentMethodOptionTextsResponse.switchRecurrentOffBindOnTitle) && Intrinsics.areEqual(this.switchRecurrentOffBindOnSubtitle, savePaymentMethodOptionTextsResponse.switchRecurrentOffBindOnSubtitle) && Intrinsics.areEqual(this.messageRecurrentOnBindOnTitle, savePaymentMethodOptionTextsResponse.messageRecurrentOnBindOnTitle) && Intrinsics.areEqual(this.messageRecurrentOnBindOnSubtitle, savePaymentMethodOptionTextsResponse.messageRecurrentOnBindOnSubtitle) && Intrinsics.areEqual(this.messageRecurrentOnBindOffTitle, savePaymentMethodOptionTextsResponse.messageRecurrentOnBindOffTitle) && Intrinsics.areEqual(this.messageRecurrentOnBindOffSubtitle, savePaymentMethodOptionTextsResponse.messageRecurrentOnBindOffSubtitle) && Intrinsics.areEqual(this.messageRecurrentOffBindOnTitle, savePaymentMethodOptionTextsResponse.messageRecurrentOffBindOnTitle) && Intrinsics.areEqual(this.messageRecurrentOffBindOnSubtitle, savePaymentMethodOptionTextsResponse.messageRecurrentOffBindOnSubtitle) && Intrinsics.areEqual(this.screenRecurrentOnBindOnTitle, savePaymentMethodOptionTextsResponse.screenRecurrentOnBindOnTitle) && Intrinsics.areEqual(this.screenRecurrentOnBindOnText, savePaymentMethodOptionTextsResponse.screenRecurrentOnBindOnText) && Intrinsics.areEqual(this.screenRecurrentOnBindOffTitle, savePaymentMethodOptionTextsResponse.screenRecurrentOnBindOffTitle) && Intrinsics.areEqual(this.screenRecurrentOnBindOffText, savePaymentMethodOptionTextsResponse.screenRecurrentOnBindOffText) && Intrinsics.areEqual(this.screenRecurrentOffBindOnTitle, savePaymentMethodOptionTextsResponse.screenRecurrentOffBindOnTitle) && Intrinsics.areEqual(this.screenRecurrentOffBindOnText, savePaymentMethodOptionTextsResponse.screenRecurrentOffBindOnText) && Intrinsics.areEqual(this.screenRecurrentOnSberpayTitle, savePaymentMethodOptionTextsResponse.screenRecurrentOnSberpayTitle) && Intrinsics.areEqual(this.screenRecurrentOnSberpayText, savePaymentMethodOptionTextsResponse.screenRecurrentOnSberpayText) && Intrinsics.areEqual(this.messageRecurrentOnSBPTitle, savePaymentMethodOptionTextsResponse.messageRecurrentOnSBPTitle) && Intrinsics.areEqual(this.switchRecurrentOnSBPTitle, savePaymentMethodOptionTextsResponse.switchRecurrentOnSBPTitle) && Intrinsics.areEqual(this.messageRecurrentOnSberPayTitle, savePaymentMethodOptionTextsResponse.messageRecurrentOnSberPayTitle) && Intrinsics.areEqual(this.switchRecurrentOnSberPayTitle, savePaymentMethodOptionTextsResponse.switchRecurrentOnSberPayTitle);
    }

    public final String getMessageRecurrentOffBindOnSubtitle() {
        return this.messageRecurrentOffBindOnSubtitle;
    }

    public final String getMessageRecurrentOffBindOnTitle() {
        return this.messageRecurrentOffBindOnTitle;
    }

    public final String getMessageRecurrentOnBindOffSubtitle() {
        return this.messageRecurrentOnBindOffSubtitle;
    }

    public final String getMessageRecurrentOnBindOffTitle() {
        return this.messageRecurrentOnBindOffTitle;
    }

    public final String getMessageRecurrentOnBindOnSubtitle() {
        return this.messageRecurrentOnBindOnSubtitle;
    }

    public final String getMessageRecurrentOnBindOnTitle() {
        return this.messageRecurrentOnBindOnTitle;
    }

    public final String getMessageRecurrentOnSBPTitle() {
        return this.messageRecurrentOnSBPTitle;
    }

    public final String getMessageRecurrentOnSberPayTitle() {
        return this.messageRecurrentOnSberPayTitle;
    }

    public final String getScreenRecurrentOffBindOnText() {
        return this.screenRecurrentOffBindOnText;
    }

    public final String getScreenRecurrentOffBindOnTitle() {
        return this.screenRecurrentOffBindOnTitle;
    }

    public final String getScreenRecurrentOnBindOffText() {
        return this.screenRecurrentOnBindOffText;
    }

    public final String getScreenRecurrentOnBindOffTitle() {
        return this.screenRecurrentOnBindOffTitle;
    }

    public final String getScreenRecurrentOnBindOnText() {
        return this.screenRecurrentOnBindOnText;
    }

    public final String getScreenRecurrentOnBindOnTitle() {
        return this.screenRecurrentOnBindOnTitle;
    }

    public final String getScreenRecurrentOnSberpayText() {
        return this.screenRecurrentOnSberpayText;
    }

    public final String getScreenRecurrentOnSberpayTitle() {
        return this.screenRecurrentOnSberpayTitle;
    }

    public final String getSwitchRecurrentOffBindOnSubtitle() {
        return this.switchRecurrentOffBindOnSubtitle;
    }

    public final String getSwitchRecurrentOffBindOnTitle() {
        return this.switchRecurrentOffBindOnTitle;
    }

    public final String getSwitchRecurrentOnBindOffSubtitle() {
        return this.switchRecurrentOnBindOffSubtitle;
    }

    public final String getSwitchRecurrentOnBindOffTitle() {
        return this.switchRecurrentOnBindOffTitle;
    }

    public final String getSwitchRecurrentOnBindOnSubtitle() {
        return this.switchRecurrentOnBindOnSubtitle;
    }

    public final String getSwitchRecurrentOnBindOnTitle() {
        return this.switchRecurrentOnBindOnTitle;
    }

    public final String getSwitchRecurrentOnSBPTitle() {
        return this.switchRecurrentOnSBPTitle;
    }

    public final String getSwitchRecurrentOnSberPayTitle() {
        return this.switchRecurrentOnSberPayTitle;
    }

    public int hashCode() {
        return this.switchRecurrentOnSberPayTitle.hashCode() + AbstractC1553e.a(this.messageRecurrentOnSberPayTitle, AbstractC1553e.a(this.switchRecurrentOnSBPTitle, AbstractC1553e.a(this.messageRecurrentOnSBPTitle, AbstractC1553e.a(this.screenRecurrentOnSberpayText, AbstractC1553e.a(this.screenRecurrentOnSberpayTitle, AbstractC1553e.a(this.screenRecurrentOffBindOnText, AbstractC1553e.a(this.screenRecurrentOffBindOnTitle, AbstractC1553e.a(this.screenRecurrentOnBindOffText, AbstractC1553e.a(this.screenRecurrentOnBindOffTitle, AbstractC1553e.a(this.screenRecurrentOnBindOnText, AbstractC1553e.a(this.screenRecurrentOnBindOnTitle, AbstractC1553e.a(this.messageRecurrentOffBindOnSubtitle, AbstractC1553e.a(this.messageRecurrentOffBindOnTitle, AbstractC1553e.a(this.messageRecurrentOnBindOffSubtitle, AbstractC1553e.a(this.messageRecurrentOnBindOffTitle, AbstractC1553e.a(this.messageRecurrentOnBindOnSubtitle, AbstractC1553e.a(this.messageRecurrentOnBindOnTitle, AbstractC1553e.a(this.switchRecurrentOffBindOnSubtitle, AbstractC1553e.a(this.switchRecurrentOffBindOnTitle, AbstractC1553e.a(this.switchRecurrentOnBindOffSubtitle, AbstractC1553e.a(this.switchRecurrentOnBindOffTitle, AbstractC1553e.a(this.switchRecurrentOnBindOnSubtitle, this.switchRecurrentOnBindOnTitle.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "SavePaymentMethodOptionTextsResponse(switchRecurrentOnBindOnTitle=" + this.switchRecurrentOnBindOnTitle + ", switchRecurrentOnBindOnSubtitle=" + this.switchRecurrentOnBindOnSubtitle + ", switchRecurrentOnBindOffTitle=" + this.switchRecurrentOnBindOffTitle + ", switchRecurrentOnBindOffSubtitle=" + this.switchRecurrentOnBindOffSubtitle + ", switchRecurrentOffBindOnTitle=" + this.switchRecurrentOffBindOnTitle + ", switchRecurrentOffBindOnSubtitle=" + this.switchRecurrentOffBindOnSubtitle + ", messageRecurrentOnBindOnTitle=" + this.messageRecurrentOnBindOnTitle + ", messageRecurrentOnBindOnSubtitle=" + this.messageRecurrentOnBindOnSubtitle + ", messageRecurrentOnBindOffTitle=" + this.messageRecurrentOnBindOffTitle + ", messageRecurrentOnBindOffSubtitle=" + this.messageRecurrentOnBindOffSubtitle + ", messageRecurrentOffBindOnTitle=" + this.messageRecurrentOffBindOnTitle + ", messageRecurrentOffBindOnSubtitle=" + this.messageRecurrentOffBindOnSubtitle + ", screenRecurrentOnBindOnTitle=" + this.screenRecurrentOnBindOnTitle + ", screenRecurrentOnBindOnText=" + this.screenRecurrentOnBindOnText + ", screenRecurrentOnBindOffTitle=" + this.screenRecurrentOnBindOffTitle + ", screenRecurrentOnBindOffText=" + this.screenRecurrentOnBindOffText + ", screenRecurrentOffBindOnTitle=" + this.screenRecurrentOffBindOnTitle + ", screenRecurrentOffBindOnText=" + this.screenRecurrentOffBindOnText + ", screenRecurrentOnSberpayTitle=" + this.screenRecurrentOnSberpayTitle + ", screenRecurrentOnSberpayText=" + this.screenRecurrentOnSberpayText + ", messageRecurrentOnSBPTitle=" + this.messageRecurrentOnSBPTitle + ", switchRecurrentOnSBPTitle=" + this.switchRecurrentOnSBPTitle + ", messageRecurrentOnSberPayTitle=" + this.messageRecurrentOnSberPayTitle + ", switchRecurrentOnSberPayTitle=" + this.switchRecurrentOnSberPayTitle + ")";
    }
}
