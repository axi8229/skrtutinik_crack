package com.sputnik.common.base;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/sputnik/common/base/Notify;", "", CrashHianalyticsData.MESSAGE, "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "ActionMessage", "ErrorMessage", "TextMessage", "Lcom/sputnik/common/base/Notify$ActionMessage;", "Lcom/sputnik/common/base/Notify$ErrorMessage;", "Lcom/sputnik/common/base/Notify$TextMessage;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Notify {
    private final String message;

    public /* synthetic */ Notify(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/sputnik/common/base/Notify$TextMessage;", "Lcom/sputnik/common/base/Notify;", "", RemoteMessageConst.MessageBody.MSG, "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMsg", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class TextMessage extends Notify {
        private final String msg;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TextMessage) && Intrinsics.areEqual(this.msg, ((TextMessage) other).msg);
        }

        public int hashCode() {
            return this.msg.hashCode();
        }

        public String toString() {
            return "TextMessage(msg=" + this.msg + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextMessage(String msg) {
            super(msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.msg = msg;
        }
    }

    private Notify(String str) {
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/sputnik/common/base/Notify$ActionMessage;", "Lcom/sputnik/common/base/Notify;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", RemoteMessageConst.MessageBody.MSG, "Ljava/lang/String;", "getMsg", "actionLabel", "getActionLabel", "Lkotlin/Function0;", "", "actionHandler", "Lkotlin/jvm/functions/Function0;", "getActionHandler", "()Lkotlin/jvm/functions/Function0;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ActionMessage extends Notify {
        private final Function0<Unit> actionHandler;
        private final String actionLabel;
        private final String msg;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionMessage)) {
                return false;
            }
            ActionMessage actionMessage = (ActionMessage) other;
            return Intrinsics.areEqual(this.msg, actionMessage.msg) && Intrinsics.areEqual(this.actionLabel, actionMessage.actionLabel) && Intrinsics.areEqual(this.actionHandler, actionMessage.actionHandler);
        }

        public int hashCode() {
            return (((this.msg.hashCode() * 31) + this.actionLabel.hashCode()) * 31) + this.actionHandler.hashCode();
        }

        public String toString() {
            return "ActionMessage(msg=" + this.msg + ", actionLabel=" + this.actionLabel + ", actionHandler=" + this.actionHandler + ")";
        }

        public final String getActionLabel() {
            return this.actionLabel;
        }

        public final Function0<Unit> getActionHandler() {
            return this.actionHandler;
        }
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u000bR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/sputnik/common/base/Notify$ErrorMessage;", "Lcom/sputnik/common/base/Notify;", "", RemoteMessageConst.MessageBody.MSG, "errLabel", "Lkotlin/Function0;", "", "errHandler", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMsg", "getErrLabel", "Lkotlin/jvm/functions/Function0;", "getErrHandler", "()Lkotlin/jvm/functions/Function0;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ErrorMessage extends Notify {
        private final Function0<Unit> errHandler;
        private final String errLabel;
        private final String msg;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorMessage)) {
                return false;
            }
            ErrorMessage errorMessage = (ErrorMessage) other;
            return Intrinsics.areEqual(this.msg, errorMessage.msg) && Intrinsics.areEqual(this.errLabel, errorMessage.errLabel) && Intrinsics.areEqual(this.errHandler, errorMessage.errHandler);
        }

        public int hashCode() {
            String str = this.msg;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.errLabel;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Function0<Unit> function0 = this.errHandler;
            return iHashCode2 + (function0 != null ? function0.hashCode() : 0);
        }

        public String toString() {
            return "ErrorMessage(msg=" + this.msg + ", errLabel=" + this.errLabel + ", errHandler=" + this.errHandler + ")";
        }

        public final String getErrLabel() {
            return this.errLabel;
        }

        public final Function0<Unit> getErrHandler() {
            return this.errHandler;
        }

        public ErrorMessage(String str, String str2, Function0<Unit> function0) {
            super(str == null ? "Error" : str, null);
            this.msg = str;
            this.errLabel = str2;
            this.errHandler = function0;
        }
    }
}
