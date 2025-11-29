package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PointerInputEventProcessor.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "", "()V", "previousPointerInputData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "clear", "", "produce", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "PointerInputData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class PointerInputChangeEventProducer {
    private final LongSparseArray<PointerInputData> previousPointerInputData = new LongSparseArray<>(0, 1, null);

    public final InternalPointerEvent produce(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator) {
        long uptime;
        boolean down;
        long jMo1385screenToLocalMKHz9U;
        LongSparseArray longSparseArray = new LongSparseArray(pointerInputEvent.getPointers().size());
        List<PointerInputEventData> pointers = pointerInputEvent.getPointers();
        int size = pointers.size();
        for (int i = 0; i < size; i++) {
            PointerInputEventData pointerInputEventData = pointers.get(i);
            PointerInputData pointerInputData = this.previousPointerInputData.get(pointerInputEventData.getId());
            if (pointerInputData == null) {
                uptime = pointerInputEventData.getUptime();
                jMo1385screenToLocalMKHz9U = pointerInputEventData.getPosition();
                down = false;
            } else {
                long uptime2 = pointerInputData.getUptime();
                uptime = uptime2;
                down = pointerInputData.getDown();
                jMo1385screenToLocalMKHz9U = positionCalculator.mo1385screenToLocalMKHz9U(pointerInputData.getPositionOnScreen());
            }
            longSparseArray.put(pointerInputEventData.getId(), new PointerInputChange(pointerInputEventData.getId(), pointerInputEventData.getUptime(), pointerInputEventData.getPosition(), pointerInputEventData.getDown(), pointerInputEventData.getPressure(), uptime, jMo1385screenToLocalMKHz9U, down, false, pointerInputEventData.getType(), pointerInputEventData.getHistorical(), pointerInputEventData.getScrollDelta(), pointerInputEventData.getOriginalEventPosition(), null));
            if (pointerInputEventData.getDown()) {
                this.previousPointerInputData.put(pointerInputEventData.getId(), new PointerInputData(pointerInputEventData.getUptime(), pointerInputEventData.getPositionOnScreen(), pointerInputEventData.getDown(), pointerInputEventData.getType(), null));
            } else {
                this.previousPointerInputData.remove(pointerInputEventData.getId());
            }
        }
        return new InternalPointerEvent(longSparseArray, pointerInputEvent);
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    /* compiled from: PointerInputEventProcessor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\t\u001a\u00020\b8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "", "", "uptime", "Landroidx/compose/ui/geometry/Offset;", "positionOnScreen", "", "down", "Landroidx/compose/ui/input/pointer/PointerType;", "type", "<init>", "(JJZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getUptime", "()J", "getPositionOnScreen-F1C5BW0", "Z", "getDown", "()Z", "I", "getType-T8wyACA", "()I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final int type;
        private final long uptime;

        public /* synthetic */ PointerInputData(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z, i);
        }

        private PointerInputData(long j, long j2, boolean z, int i) {
            this.uptime = j;
            this.positionOnScreen = j2;
            this.down = z;
            this.type = i;
        }

        public final long getUptime() {
            return this.uptime;
        }

        /* renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name and from getter */
        public final long getPositionOnScreen() {
            return this.positionOnScreen;
        }

        public final boolean getDown() {
            return this.down;
        }
    }
}
