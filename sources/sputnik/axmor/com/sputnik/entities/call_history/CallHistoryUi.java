package sputnik.axmor.com.sputnik.entities.call_history;

import com.sputnik.domain.entities.call.CallState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallHistoryUi.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "", "()V", "CallHistoryItem", "DateItem", "Footer", "Promo", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi$CallHistoryItem;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi$DateItem;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi$Footer;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi$Promo;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CallHistoryUi {
    public /* synthetic */ CallHistoryUi(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: CallHistoryUi.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi$CallHistoryItem;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;", "item", "<init>", "(Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;", "getItem", "()Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class CallHistoryItem extends CallHistoryUi {
        private final CallHistory item;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CallHistoryItem) && Intrinsics.areEqual(this.item, ((CallHistoryItem) other).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "CallHistoryItem(item=" + this.item + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallHistoryItem(CallHistory item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final CallHistory getItem() {
            return this.item;
        }
    }

    private CallHistoryUi() {
    }

    /* compiled from: CallHistoryUi.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi$DateItem;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "Lcom/sputnik/domain/entities/call/CallState;", "state", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/call/CallState;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDate", "Lcom/sputnik/domain/entities/call/CallState;", "getState", "()Lcom/sputnik/domain/entities/call/CallState;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DateItem extends CallHistoryUi {
        private final String date;
        private final CallState state;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DateItem)) {
                return false;
            }
            DateItem dateItem = (DateItem) other;
            return Intrinsics.areEqual(this.date, dateItem.date) && this.state == dateItem.state;
        }

        public int hashCode() {
            return (this.date.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "DateItem(date=" + this.date + ", state=" + this.state + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final CallState getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DateItem(String date, CallState state) {
            super(null);
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(state, "state");
            this.date = date;
            this.state = state;
        }
    }

    /* compiled from: CallHistoryUi.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi$Footer;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Footer extends CallHistoryUi {
        public static final Footer INSTANCE = new Footer();

        private Footer() {
            super(null);
        }
    }

    /* compiled from: CallHistoryUi.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi$Promo;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Promo extends CallHistoryUi {
        public static final Promo INSTANCE = new Promo();

        private Promo() {
            super(null);
        }
    }
}
