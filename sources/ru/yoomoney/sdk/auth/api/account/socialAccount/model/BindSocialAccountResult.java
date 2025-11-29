package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.account.socialAccount.deserializer.BindSocialAccountResultDeserializer;

@JsonAdapter(BindSocialAccountResultDeserializer.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "Landroid/os/Parcelable;", "()V", "service", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "getService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", UpdateKey.STATUS, "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;", "getStatus", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;", "Status", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountFailResult;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountSuccessResult;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BindSocialAccountResult implements Parcelable {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult$Status;", "", "(Ljava/lang/String;I)V", "SUCCESS", "ERROR", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;

        @SerializedName("Success")
        public static final Status SUCCESS = new Status("SUCCESS", 0);

        @SerializedName("Error")
        public static final Status ERROR = new Status("ERROR", 1);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{SUCCESS, ERROR};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        }

        private Status(String str, int i) {
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    private BindSocialAccountResult() {
    }

    public /* synthetic */ BindSocialAccountResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract OauthServiceProvider getService();

    public abstract Status getStatus();
}
