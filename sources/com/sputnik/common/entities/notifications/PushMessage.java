package com.sputnik.common.entities.notifications;

import com.huawei.hms.android.SystemUtils;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: PushMessage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001f BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001d\u0010\u000eR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001e\u0010\u000e¨\u0006!"}, d2 = {"Lcom/sputnik/common/entities/notifications/PushMessage;", "", "", "id", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "Lcom/sputnik/common/entities/notifications/PushMessage$Types;", "type", "deeplink", "dataId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/notifications/PushMessage$Types;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getTitle", "getBody", "Lcom/sputnik/common/entities/notifications/PushMessage$Types;", "getType", "()Lcom/sputnik/common/entities/notifications/PushMessage$Types;", "getDeeplink", "getDataId", "Arguments", "Types", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PushMessage {
    private final String body;
    private final String dataId;
    private final String deeplink;
    private final int id;
    private final String title;
    private final Types type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushMessage)) {
            return false;
        }
        PushMessage pushMessage = (PushMessage) other;
        return this.id == pushMessage.id && Intrinsics.areEqual(this.title, pushMessage.title) && Intrinsics.areEqual(this.body, pushMessage.body) && this.type == pushMessage.type && Intrinsics.areEqual(this.deeplink, pushMessage.deeplink) && Intrinsics.areEqual(this.dataId, pushMessage.dataId);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.body.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str = this.deeplink;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.dataId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PushMessage(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", type=" + this.type + ", deeplink=" + this.deeplink + ", dataId=" + this.dataId + ")";
    }

    public PushMessage(int i, String title, String body, Types type, String str, String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = i;
        this.title = title;
        this.body = body;
        this.type = type;
        this.deeplink = str;
        this.dataId = str2;
    }

    public /* synthetic */ PushMessage(int i, String str, String str2, Types types, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Random.INSTANCE.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE) : i, str, str2, types, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4);
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final Types getType() {
        return this.type;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getDataId() {
        return this.dataId;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PushMessage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/entities/notifications/PushMessage$Types;", "", "(Ljava/lang/String;I)V", "call", "promo", SystemUtils.UNKNOWN, "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Types {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Types[] $VALUES;
        public static final Types call = new Types("call", 0);
        public static final Types promo = new Types("promo", 1);
        public static final Types unknown = new Types(SystemUtils.UNKNOWN, 2);

        private static final /* synthetic */ Types[] $values() {
            return new Types[]{call, promo, unknown};
        }

        public static Types valueOf(String str) {
            return (Types) Enum.valueOf(Types.class, str);
        }

        public static Types[] values() {
            return (Types[]) $VALUES.clone();
        }

        private Types(String str, int i) {
        }

        static {
            Types[] typesArr$values = $values();
            $VALUES = typesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typesArr$values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PushMessage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sputnik/common/entities/notifications/PushMessage$Arguments;", "", "(Ljava/lang/String;I)V", "intercom_uuid", "call_id", "flat_uuid", "address", "body", "deeplink", "id", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Arguments {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Arguments[] $VALUES;
        public static final Arguments intercom_uuid = new Arguments("intercom_uuid", 0);
        public static final Arguments call_id = new Arguments("call_id", 1);
        public static final Arguments flat_uuid = new Arguments("flat_uuid", 2);
        public static final Arguments address = new Arguments("address", 3);
        public static final Arguments body = new Arguments("body", 4);
        public static final Arguments deeplink = new Arguments("deeplink", 5);
        public static final Arguments id = new Arguments("id", 6);

        private static final /* synthetic */ Arguments[] $values() {
            return new Arguments[]{intercom_uuid, call_id, flat_uuid, address, body, deeplink, id};
        }

        public static Arguments valueOf(String str) {
            return (Arguments) Enum.valueOf(Arguments.class, str);
        }

        public static Arguments[] values() {
            return (Arguments[]) $VALUES.clone();
        }

        private Arguments(String str, int i) {
        }

        static {
            Arguments[] argumentsArr$values = $values();
            $VALUES = argumentsArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(argumentsArr$values);
        }
    }
}
