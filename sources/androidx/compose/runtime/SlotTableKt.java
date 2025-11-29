package androidx.compose.runtime;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\u0004\u001a\u001b\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\u0007\u001a\u001b\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u0004\u001a\u001b\u0010\u000b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u001b\u0010\f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\f\u0010\u0007\u001a#\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\u0007\u001a#\u0010\u0012\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u001b\u0010\u0013\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0007\u001a\u001b\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0014\u0010\u0004\u001a\u001b\u0010\u0015\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0004\u001a\u0017\u0010\u0016\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0018\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0004\u001a\u001b\u0010\u0019\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u0004\u001a#\u0010\u001a\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u0004\u001a#\u0010\u001d\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001b\u0010\u001e\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001e\u0010\u0004\u001a#\u0010\u001f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001f\u0010\u001b\u001a\u001b\u0010 \u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010\u0004\u001a#\u0010\"\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\"\u0010\u001b\u001aK\u0010%\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0002¢\u0006\u0004\b%\u0010&\u001a5\u0010,\u001a\u0004\u0018\u00010(*\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b,\u0010-\u001a3\u0010/\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b/\u00100\u001a3\u00101\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b1\u00100¨\u00062"}, d2 = {"", "", "address", "groupInfo", "([II)I", "", "isNode", "([II)Z", "nodeIndex", "hasObjectKey", "objectKeyIndex", "hasAux", "hasMark", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "updateMark", "([IIZ)V", "containsMark", "updateContainsMark", "containsAnyMark", "auxIndex", "slotAnchor", "countOneBits", "(I)I", "key", "nodeCount", "updateNodeCount", "([III)V", "parentAnchor", "updateParentAnchor", "groupSize", "updateGroupSize", "dataAnchor", "anchor", "updateDataAnchor", "hasDataKey", "hasData", "initGroup", "([IIIZZZII)V", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "index", "effectiveSize", "find", "(Ljava/util/ArrayList;II)Landroidx/compose/runtime/Anchor;", "location", "search", "(Ljava/util/ArrayList;II)I", "locationOf", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTableKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int countOneBits(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
                return 1;
            case 3:
            case 5:
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int groupInfo(int[] iArr, int i) {
        return iArr[(i * 5) + 1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isNode(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nodeIndex(int[] iArr, int i) {
        return iArr[(i * 5) + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasObjectKey(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 536870912) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int objectKeyIndex(int[] iArr, int i) {
        int i2 = i * 5;
        return iArr[i2 + 4] + countOneBits(iArr[i2 + 1] >> 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasAux(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 268435456) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasMark(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 134217728) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMark(int[] iArr, int i, boolean z) {
        int i2 = (i * 5) + 1;
        if (z) {
            iArr[i2] = iArr[i2] | 134217728;
        } else {
            iArr[i2] = iArr[i2] & (-134217729);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsMark(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 67108864) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateContainsMark(int[] iArr, int i, boolean z) {
        int i2 = (i * 5) + 1;
        if (z) {
            iArr[i2] = iArr[i2] | 67108864;
        } else {
            iArr[i2] = iArr[i2] & (-67108865);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsAnyMark(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 201326592) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int auxIndex(int[] iArr, int i) {
        int i2 = i * 5;
        if (i2 >= iArr.length) {
            return iArr.length;
        }
        return countOneBits(iArr[i2 + 1] >> 29) + iArr[i2 + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int slotAnchor(int[] iArr, int i) {
        int i2 = i * 5;
        return iArr[i2 + 4] + countOneBits(iArr[i2 + 1] >> 28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int key(int[] iArr, int i) {
        return iArr[i * 5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nodeCount(int[] iArr, int i) {
        return iArr[(i * 5) + 1] & 67108863;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateNodeCount(int[] iArr, int i, int i2) {
        ComposerKt.runtimeCheck(i2 >= 0 && i2 < 67108863);
        int i3 = (i * 5) + 1;
        iArr[i3] = i2 | (iArr[i3] & (-67108864));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int parentAnchor(int[] iArr, int i) {
        return iArr[(i * 5) + 2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateParentAnchor(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 2] = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int groupSize(int[] iArr, int i) {
        return iArr[(i * 5) + 3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGroupSize(int[] iArr, int i, int i2) {
        ComposerKt.runtimeCheck(i2 >= 0);
        iArr[(i * 5) + 3] = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int dataAnchor(int[] iArr, int i) {
        return iArr[(i * 5) + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDataAnchor(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 4] = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initGroup(int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4) {
        int i5 = z ? pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH : 0;
        int i6 = z2 ? 536870912 : 0;
        int i7 = z3 ? 268435456 : 0;
        int i8 = i * 5;
        iArr[i8] = i2;
        iArr[i8 + 1] = i5 | i6 | i7;
        iArr[i8 + 2] = i3;
        iArr[i8 + 3] = 0;
        iArr[i8 + 4] = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Anchor find(ArrayList<Anchor> arrayList, int i, int i2) {
        int iSearch = search(arrayList, i, i2);
        if (iSearch >= 0) {
            return arrayList.get(iSearch);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int search(ArrayList<Anchor> arrayList, int i, int i2) {
        int size = arrayList.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) >>> 1;
            int location$runtime_release = arrayList.get(i4).getLocation();
            if (location$runtime_release < 0) {
                location$runtime_release += i2;
            }
            int iCompare = Intrinsics.compare(location$runtime_release, i);
            if (iCompare < 0) {
                i3 = i4 + 1;
            } else {
                if (iCompare <= 0) {
                    return i4;
                }
                size = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int locationOf(ArrayList<Anchor> arrayList, int i, int i2) {
        int iSearch = search(arrayList, i, i2);
        return iSearch >= 0 ? iSearch : -(iSearch + 1);
    }
}
