package androidx.compose.ui.node;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* compiled from: MyersDiff.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/CenteredArray;", "", "", RemoteMessageConst.DATA, "constructor-impl", "([I)[I", "", "index", "get-impl", "([II)I", "get", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "set-impl", "([III)V", "set", "getMid-impl", "([I)I", "mid", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
final class CenteredArray {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m1461constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: getMid-impl, reason: not valid java name */
    private static final int m1463getMidimpl(int[] iArr) {
        return iArr.length / 2;
    }

    /* renamed from: get-impl, reason: not valid java name */
    public static final int m1462getimpl(int[] iArr, int i) {
        return iArr[i + m1463getMidimpl(iArr)];
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m1464setimpl(int[] iArr, int i, int i2) {
        iArr[i + m1463getMidimpl(iArr)] = i2;
    }
}
