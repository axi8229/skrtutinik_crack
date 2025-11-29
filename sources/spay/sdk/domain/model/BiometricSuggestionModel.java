package spay.sdk.domain.model;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lspay/sdk/domain/model/BiometricSuggestionModel;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", CrashHianalyticsData.MESSAGE, "positiveButtonText", "negativeButtonText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getNegativeButtonText", "getPositiveButtonText", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BiometricSuggestionModel {
    private final String message;
    private final String negativeButtonText;
    private final String positiveButtonText;
    private final String title;

    public BiometricSuggestionModel(String title, String message, String positiveButtonText, String negativeButtonText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(positiveButtonText, "positiveButtonText");
        Intrinsics.checkNotNullParameter(negativeButtonText, "negativeButtonText");
        this.title = title;
        this.message = message;
        this.positiveButtonText = positiveButtonText;
        this.negativeButtonText = negativeButtonText;
    }

    public static /* synthetic */ BiometricSuggestionModel copy$default(BiometricSuggestionModel biometricSuggestionModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = biometricSuggestionModel.title;
        }
        if ((i & 2) != 0) {
            str2 = biometricSuggestionModel.message;
        }
        if ((i & 4) != 0) {
            str3 = biometricSuggestionModel.positiveButtonText;
        }
        if ((i & 8) != 0) {
            str4 = biometricSuggestionModel.negativeButtonText;
        }
        return biometricSuggestionModel.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPositiveButtonText() {
        return this.positiveButtonText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNegativeButtonText() {
        return this.negativeButtonText;
    }

    public final BiometricSuggestionModel copy(String title, String message, String positiveButtonText, String negativeButtonText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(positiveButtonText, "positiveButtonText");
        Intrinsics.checkNotNullParameter(negativeButtonText, "negativeButtonText");
        return new BiometricSuggestionModel(title, message, positiveButtonText, negativeButtonText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BiometricSuggestionModel)) {
            return false;
        }
        BiometricSuggestionModel biometricSuggestionModel = (BiometricSuggestionModel) other;
        return Intrinsics.areEqual(this.title, biometricSuggestionModel.title) && Intrinsics.areEqual(this.message, biometricSuggestionModel.message) && Intrinsics.areEqual(this.positiveButtonText, biometricSuggestionModel.positiveButtonText) && Intrinsics.areEqual(this.negativeButtonText, biometricSuggestionModel.negativeButtonText);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getNegativeButtonText() {
        return this.negativeButtonText;
    }

    public final String getPositiveButtonText() {
        return this.positiveButtonText;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.negativeButtonText.hashCode() + AbstractC1553e.a(this.positiveButtonText, AbstractC1553e.a(this.message, this.title.hashCode() * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BiometricSuggestionModel(title=");
        sb.append(this.title);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", positiveButtonText=");
        sb.append(this.positiveButtonText);
        sb.append(", negativeButtonText=");
        return Q1.a(sb, this.negativeButtonText, ')');
    }
}
