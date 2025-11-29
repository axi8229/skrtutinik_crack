package ru.yoomoney.sdk.guiCompose.views.notice;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoticeCommon.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/notice/Notice;", "", "type", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice$Type;", "text", "", "action", "onClick", "Lkotlin/Function0;", "", "(Lru/yoomoney/sdk/guiCompose/views/notice/Notice$Type;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Ljava/lang/String;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getText", "getType", "()Lru/yoomoney/sdk/guiCompose/views/notice/Notice$Type;", "show", "noticeService", "Lru/yoomoney/sdk/guiCompose/views/notice/NoticeService;", "Companion", "Type", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Notice {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String action;
    private final Function0<Unit> onClick;
    private final String text;
    private final Type type;

    public /* synthetic */ Notice(Type type, String str, String str2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, str, str2, function0);
    }

    private Notice(Type type, String str, String str2, Function0<Unit> function0) {
        this.type = type;
        this.text = str;
        this.action = str2;
        this.onClick = function0;
    }

    public final Type getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }

    public final String getAction() {
        return this.action;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final void show(NoticeService noticeService) {
        Intrinsics.checkNotNullParameter(noticeService, "noticeService");
        noticeService.showNotice(this);
    }

    /* compiled from: NoticeCommon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/notice/Notice$Companion;", "", "<init>", "()V", "", "text", "action", "Lkotlin/Function0;", "", "onClick", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice;", "alert", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lru/yoomoney/sdk/guiCompose/views/notice/Notice;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Notice alert$default(Companion companion, String str, String str2, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                function0 = null;
            }
            return companion.alert(str, str2, function0);
        }

        public final Notice alert(String text, String action, Function0<Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Notice(Type.ALERT, text, action, onClick, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: NoticeCommon.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/notice/Notice$Type;", "", "(Ljava/lang/String;I)V", "SUCCESS", "ALERT", "NORMAL", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type SUCCESS = new Type("SUCCESS", 0);
        public static final Type ALERT = new Type("ALERT", 1);
        public static final Type NORMAL = new Type("NORMAL", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{SUCCESS, ALERT, NORMAL};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i) {
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }
    }
}
