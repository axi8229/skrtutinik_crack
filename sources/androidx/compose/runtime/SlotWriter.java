package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.Composer;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\bI\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 Ù\u00012\u00020\u0001:\u0002Ù\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010\u0017J\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!J'\u0010%\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b(\u0010\u0019J\u001f\u0010)\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u000fH\u0002¢\u0006\u0004\b+\u0010\u0017J\u0017\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\b-\u0010\u0019J\u001f\u0010.\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b.\u0010*J\u001f\u00101\u001a\u00020\f2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0002¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b4\u00105J'\u00106\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b6\u0010&J!\u00107\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0002¢\u0006\u0004\b;\u0010*JG\u0010A\u001a\u00020\f2\u0006\u0010<\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2&\u0010@\u001a\"\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000203\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000203\u0018\u0001`?H\u0002¢\u0006\u0004\bA\u0010BJ'\u0010E\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\bE\u0010&J\u0017\u0010F\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\bI\u0010GJ\u001b\u0010\"\u001a\u00020\t*\u00020J2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010KJ\u0017\u0010H\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\bH\u0010GJ\u001b\u0010H\u001a\u00020\t*\u00020J2\u0006\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bH\u0010KJ\u001b\u0010M\u001a\u00020\t*\u00020J2\u0006\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010KJ#\u0010N\u001a\u00020\u000f*\u00020J2\u0006\u0010L\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\t*\u00020J2\u0006\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010KJ\u001b\u0010Q\u001a\u00020\t*\u00020J2\u0006\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bQ\u0010KJ/\u0010T\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0002¢\u0006\u0004\bT\u0010UJ'\u0010W\u001a\u00020\t2\u0006\u0010V\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0002¢\u0006\u0004\bW\u0010XJ\u001f\u0010Y\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0002¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b[\u0010GJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u0014J\u0015\u0010\\\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b\\\u0010GJ\u0015\u0010]\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b]\u0010GJ\u0017\u0010^\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b^\u0010_J\u0015\u0010`\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b`\u0010GJ\u0017\u0010a\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\ba\u0010_J\u0015\u0010b\u001a\u00020\f2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\bb\u0010\u0014J\u0015\u0010c\u001a\u00020\f2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\bc\u0010\u0014J\u001d\u0010d\u001a\u00020\f2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\bd\u00102J\u0017\u0010e\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\be\u0010_J\u0017\u0010e\u001a\u0004\u0018\u00010\u00012\u0006\u0010V\u001a\u00020>¢\u0006\u0004\be\u0010fJ\u0015\u0010\"\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b\"\u0010GJ\u0015\u0010h\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\f¢\u0006\u0004\bh\u0010iJ\r\u0010j\u001a\u00020\u000f¢\u0006\u0004\bj\u0010\u0017J\u0019\u0010k\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bk\u0010\bJ\u001f\u0010l\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020>2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bl\u0010mJ\u0015\u0010o\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\t¢\u0006\u0004\bo\u0010\u0019J\u0017\u0010p\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bp\u0010qJ\r\u0010r\u001a\u00020\u000f¢\u0006\u0004\br\u0010\u0017J\u0017\u0010s\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bs\u0010qJ\u001f\u0010s\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020>2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bs\u0010mJ\u0017\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010qJ!\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010tJ\u001d\u0010u\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\bu\u0010ZJ)\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010vJ\u000f\u0010w\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bw\u0010xJ\u001f\u0010y\u001a\u0004\u0018\u00010\u00012\u0006\u0010V\u001a\u00020>2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\by\u0010zJ\u001f\u0010y\u001a\u0004\u0018\u00010\u00012\u0006\u0010{\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\by\u0010|J\u0017\u0010~\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0000¢\u0006\u0004\b}\u0010GJ\u0018\u0010\u0080\u0001\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0000¢\u0006\u0004\b\u007f\u0010GJ\u0019\u0010\u0082\u0001\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0000¢\u0006\u0005\b\u0081\u0001\u0010GJ\u0018\u0010\u0084\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020\t¢\u0006\u0005\b\u0084\u0001\u0010\u0019J\u000f\u0010\u0085\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0085\u0001\u0010\u0017J\u000f\u0010\u0086\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0086\u0001\u0010\u0017J\u000f\u0010\u0087\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0087\u0001\u0010\u0017J\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0017J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0010\u00108J!\u0010\u0089\u0001\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0005\b\u0089\u0001\u00108J,\u0010\u008a\u0001\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\r\u0010#\u001a\u00020\t¢\u0006\u0004\b#\u0010!J\u0017\u0010\u008c\u0001\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\t¢\u0006\u0005\b\u008c\u0001\u0010\u0019J\u0018\u0010\u008c\u0001\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020>¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u000f\u0010\u008e\u0001\u001a\u00020\t¢\u0006\u0005\b\u008e\u0001\u0010!J\u0010\u0010\u008f\u0001\u001a\u00020\f¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0018\u0010\u0092\u0001\u001a\u00020\u000f2\u0007\u0010\u0091\u0001\u001a\u00020\t¢\u0006\u0005\b\u0092\u0001\u0010\u0019J1\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0006\u0010V\u001a\u00020>2\u0007\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0093\u0001\u001a\u00020\u0000¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J2\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\t2\t\b\u0002\u0010\u0097\u0001\u001a\u00020\f¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J0\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0007\u0010\u0091\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\t¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0018\u0010V\u001a\u00020>2\b\b\u0002\u0010'\u001a\u00020\t¢\u0006\u0005\bV\u0010\u009c\u0001J\u0019\u0010\u009d\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0005\b\u009d\u0001\u0010\u0019J\u0018\u0010\u009e\u0001\u001a\u00020\t2\u0006\u0010V\u001a\u00020>¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u0013\u0010¡\u0001\u001a\u00030 \u0001H\u0016¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u001c\u0010¤\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010\u0012\u001a\u00020\tH\u0000¢\u0006\u0006\b£\u0001\u0010\u009c\u0001R\u001d\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R\u0019\u0010¨\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\"\u0010«\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R+\u0010¯\u0001\u001a\u0014\u0012\u0004\u0012\u00020>0\u00ad\u0001j\t\u0012\u0004\u0012\u00020>`®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R7\u0010@\u001a\"\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000203\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000203\u0018\u0001`?8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b@\u0010±\u0001R#\u0010´\u0001\u001a\f\u0012\u0005\u0012\u00030³\u0001\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0019\u0010¶\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010¸\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010·\u0001R\u0019\u0010¹\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010·\u0001R\u0019\u0010º\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010·\u0001R\u0019\u0010»\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010·\u0001R\u0019\u0010¼\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010·\u0001R\u0019\u0010½\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010·\u0001R\u0019\u0010¾\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010·\u0001R\u0017\u0010\\\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\\\u0010·\u0001R\u0018\u0010À\u0001\u001a\u00030¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u0018\u0010Â\u0001\u001a\u00030¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Á\u0001R\u0018\u0010Ã\u0001\u001a\u00030¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Á\u0001R+\u0010Å\u0001\u001a\u0014\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ä\u0001\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010µ\u0001R)\u0010Ç\u0001\u001a\u00020\t2\u0007\u0010Æ\u0001\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bÇ\u0001\u0010·\u0001\u001a\u0005\bÈ\u0001\u0010!R)\u0010É\u0001\u001a\u00020\t2\u0007\u0010Æ\u0001\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bÉ\u0001\u0010·\u0001\u001a\u0005\bÊ\u0001\u0010!R'\u0010\"\u001a\u00020\t2\u0007\u0010Æ\u0001\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\"\u0010·\u0001\u001a\u0005\bË\u0001\u0010!R*\u0010Ì\u0001\u001a\u00020\f2\u0007\u0010Æ\u0001\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010\u0090\u0001R\u001b\u0010Ï\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u0015\u0010S\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÑ\u0001\u0010!R\u0013\u0010Ó\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\bÒ\u0001\u0010!R\u0012\u0010\r\u001a\u00020\f8F¢\u0006\u0007\u001a\u0005\b\r\u0010\u0090\u0001R\u0014\u0010Õ\u0001\u001a\u00020\f8F¢\u0006\b\u001a\u0006\bÔ\u0001\u0010\u0090\u0001R\u0014\u0010×\u0001\u001a\u00020\f8F¢\u0006\b\u001a\u0006\bÖ\u0001\u0010\u0090\u0001R\u0015\u0010,\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bØ\u0001\u0010!¨\u0006Ú\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "Landroidx/compose/runtime/SlotTable;", "table", "<init>", "(Landroidx/compose/runtime/SlotTable;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "rawUpdate", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "key", "objectKey", "", "isNode", "aux", "", "startGroup", "(ILjava/lang/Object;ZLjava/lang/Object;)V", "group", "containsGroupMark", "(I)Z", "containsAnyGroupMarks", "recalculateMarks", "()V", "updateContainsMark", "(I)V", "Landroidx/compose/runtime/PrioritySet;", "set", "updateContainsMarkNow", "(ILandroidx/compose/runtime/PrioritySet;)V", "childContainsAnyMarks", "saveCurrentGroupEnd", "restoreCurrentGroupEnd", "()I", "parent", "endGroup", "firstChild", "fixParentAnchorsFor", "(III)V", "index", "moveGroupGapTo", "moveSlotGapTo", "(II)V", "clearSlotGap", "size", "insertGroups", "insertSlots", "start", "len", "removeGroups", "(II)Z", "Landroidx/compose/runtime/GroupSourceInformation;", "sourceInformationOf", "(I)Landroidx/compose/runtime/GroupSourceInformation;", "removeSlots", "updateNodeOfGroup", "(ILjava/lang/Object;)V", "previousGapStart", "newGapStart", "updateAnchors", "gapStart", "Ljava/util/HashMap;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/HashMap;", "sourceInformationMap", "removeAnchors", "(IILjava/util/HashMap;)Z", "originalLocation", "newLocation", "moveAnchors", "groupIndexToAddress", "(I)I", "dataIndex", "dataIndexToDataAddress", "", "([II)I", "address", "slotIndex", "updateDataIndex", "([III)V", "nodeIndex", "auxIndex", "gapLen", "capacity", "dataIndexToDataAnchor", "(IIII)I", "anchor", "dataAnchorToDataIndex", "(III)I", "parentIndexToAnchor", "(II)I", "parentAnchorToIndex", "nodeCount", "groupKey", "groupObjectKey", "(I)Ljava/lang/Object;", "groupSize", "groupAux", "indexInParent", "indexInCurrentGroup", "indexInGroup", "node", "(Landroidx/compose/runtime/Anchor;)Ljava/lang/Object;", "normalClose", "close", "(Z)V", "reset", "update", "appendSlot", "(Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)V", "count", "trimTailSlots", "updateAux", "(Ljava/lang/Object;)V", "updateToTableMaps", "updateNode", "(ILjava/lang/Object;)Ljava/lang/Object;", "slotIndexOfGroupSlotIndex", "(IILjava/lang/Object;)Ljava/lang/Object;", "skip", "()Ljava/lang/Object;", "slot", "(Landroidx/compose/runtime/Anchor;I)Ljava/lang/Object;", "groupIndex", "(II)Ljava/lang/Object;", "slotsStartIndex$runtime_release", "slotsStartIndex", "slotsEndIndex$runtime_release", "slotsEndIndex", "slotsEndAllIndex$runtime_release", "slotsEndAllIndex", "amount", "advanceBy", "skipToGroupEnd", "beginInsert", "endInsert", "dataKey", "startNode", "startData", "(ILjava/lang/Object;Ljava/lang/Object;)V", "ensureStarted", "(Landroidx/compose/runtime/Anchor;)V", "skipGroup", "removeGroup", "()Z", "offset", "moveGroup", "writer", "", "moveTo", "(Landroidx/compose/runtime/Anchor;ILandroidx/compose/runtime/SlotWriter;)Ljava/util/List;", "removeSourceGroup", "moveFrom", "(Landroidx/compose/runtime/SlotTable;IZ)Ljava/util/List;", "moveIntoGroupFrom", "(ILandroidx/compose/runtime/SlotTable;I)Ljava/util/List;", "(I)Landroidx/compose/runtime/Anchor;", "markGroup", "anchorIndex", "(Landroidx/compose/runtime/Anchor;)I", "", "toString", "()Ljava/lang/String;", "tryAnchor$runtime_release", "tryAnchor", "Landroidx/compose/runtime/SlotTable;", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "groups", "[I", "", "slots", "[Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "anchors", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "groupGapStart", "I", "groupGapLen", "currentSlot", "currentSlotEnd", "slotsGapStart", "slotsGapLen", "slotsGapOwner", "insertCount", "Landroidx/compose/runtime/IntStack;", "startStack", "Landroidx/compose/runtime/IntStack;", "endStack", "nodeCountStack", "Landroidx/collection/MutableObjectList;", "deferredSlotWrites", "<set-?>", "currentGroup", "getCurrentGroup", "currentGroupEnd", "getCurrentGroupEnd", "getParent", "closed", "Z", "getClosed", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "getCapacity", "getSlotsSize", "slotsSize", "getCollectingSourceInformation", "collectingSourceInformation", "getCollectingCalledInformation", "collectingCalledInformation", "getSize$runtime_release", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotWriter {
    private ArrayList<Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private MutableIntObjectMap<MutableObjectList<Object>> deferredSlotWrites;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private PrioritySet pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final SlotTable table;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final IntStack startStack = new IntStack();
    private final IntStack endStack = new IntStack();
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;

    private final int dataAnchorToDataIndex(int anchor, int gapLen, int capacity) {
        return anchor < 0 ? (capacity - gapLen) + anchor + 1 : anchor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int index, int gapStart, int gapLen, int capacity) {
        return index > gapStart ? -(((capacity - gapLen) - index) + 1) : index;
    }

    public SlotWriter(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime_release();
        this.sourceInformationMap = slotTable.getSourceInformationMap$runtime_release();
        this.calledByMap = slotTable.getCalledByMap$runtime_release();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
    }

    /* renamed from: getTable$runtime_release, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        return i < this.currentGroupEnd && SlotTableKt.isNode(this.groups, groupIndexToAddress(i));
    }

    public final boolean getCollectingSourceInformation() {
        return this.sourceInformationMap != null;
    }

    public final boolean getCollectingCalledInformation() {
        return this.calledByMap != null;
    }

    public final boolean isNode(int index) {
        return SlotTableKt.isNode(this.groups, groupIndexToAddress(index));
    }

    public final int nodeCount(int index) {
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress(index));
    }

    public final int groupKey(int index) {
        return SlotTableKt.key(this.groups, groupIndexToAddress(index));
    }

    public final Object groupObjectKey(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.hasObjectKey(this.groups, iGroupIndexToAddress)) {
            return this.slots[SlotTableKt.objectKeyIndex(this.groups, iGroupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int index) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(index));
    }

    public final Object groupAux(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        return SlotTableKt.hasAux(this.groups, iGroupIndexToAddress) ? this.slots[auxIndex(this.groups, iGroupIndexToAddress)] : Composer.INSTANCE.getEmpty();
    }

    public final boolean indexInParent(int index) {
        int i = this.parent;
        return (index > i && index < this.currentGroupEnd) || (i == 0 && index == 0);
    }

    public final boolean indexInCurrentGroup(int index) {
        return indexInGroup(index, this.currentGroup);
    }

    public final boolean indexInGroup(int index, int group) {
        int iIndexOf;
        int capacity;
        if (group == this.parent) {
            capacity = this.currentGroupEnd;
        } else if (group > this.startStack.peekOr(0) || (iIndexOf = this.startStack.indexOf(group)) < 0) {
            int iGroupSize = groupSize(group);
            capacity = iGroupSize + group;
        } else {
            capacity = (getCapacity() - this.groupGapLen) - this.endStack.peek(iIndexOf);
        }
        return index > group && index < capacity;
    }

    public final Object node(int index) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))];
        }
        return null;
    }

    public final Object node(Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final int getParent() {
        return this.parent;
    }

    public final int parent(int index) {
        return parent(this.groups, index);
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final void close(boolean normalClose) {
        this.closed = true;
        if (normalClose && this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            clearSlotGap();
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    public final void reset() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    public final Object update(Object value) {
        if (this.insertCount > 0 && this.currentSlot != this.slotsGapStart) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            if (mutableIntObjectMap == null) {
                mutableIntObjectMap = new MutableIntObjectMap<>(i2, i, defaultConstructorMarker);
            }
            this.deferredSlotWrites = mutableIntObjectMap;
            int i3 = this.parent;
            MutableObjectList<Object> mutableObjectList = mutableIntObjectMap.get(i3);
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(i2, i, defaultConstructorMarker);
                mutableIntObjectMap.set(i3, mutableObjectList);
            }
            mutableObjectList.add(value);
            return Composer.INSTANCE.getEmpty();
        }
        return rawUpdate(value);
    }

    private final Object rawUpdate(Object value) {
        Object objSkip = skip();
        set(value);
        return objSkip;
    }

    public final void appendSlot(Anchor anchor, Object value) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }
        int i = this.currentSlot;
        int i2 = this.currentSlotEnd;
        int iAnchorIndex = anchorIndex(anchor);
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(iAnchorIndex + 1));
        this.currentSlot = iDataIndex;
        this.currentSlotEnd = iDataIndex;
        insertSlots(1, iAnchorIndex);
        if (i >= iDataIndex) {
            i++;
            i2++;
        }
        this.slots[iDataIndex] = value;
        this.currentSlot = i;
        this.currentSlotEnd = i2;
    }

    public final void trimTailSlots(int count) {
        ComposerKt.runtimeCheck(count > 0);
        int i = this.parent;
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1)) - count;
        ComposerKt.runtimeCheck(iDataIndex >= iSlotIndex);
        removeSlots(iDataIndex, count, i);
        int i2 = this.currentSlot;
        if (i2 >= iSlotIndex) {
            this.currentSlot = i2 - count;
        }
    }

    public final void updateAux(Object value) {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (!SlotTableKt.hasAux(this.groups, iGroupIndexToAddress)) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, iGroupIndexToAddress))] = value;
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime_release();
        this.calledByMap = this.table.getCalledByMap$runtime_release();
    }

    public final void updateNode(Object value) {
        updateNodeOfGroup(this.currentGroup, value);
    }

    public final void updateNode(Anchor anchor, Object value) {
        updateNodeOfGroup(anchor.toIndexFor(this), value);
    }

    public final void set(Object value) {
        if (!(this.currentSlot <= this.currentSlotEnd)) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = value;
    }

    public final Object set(int index, Object value) {
        return set(this.currentGroup, index, value);
    }

    public final int slotIndexOfGroupSlotIndex(int group, int index) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(group));
        int i = iSlotIndex + index;
        if (!(i >= iSlotIndex && i < dataIndex(this.groups, groupIndexToAddress(group + 1)))) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + index + " for group " + group);
        }
        return i;
    }

    public final Object set(int group, int index, Object value) {
        int iDataIndexToDataAddress = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(group, index));
        Object[] objArr = this.slots;
        Object obj = objArr[iDataIndexToDataAddress];
        objArr[iDataIndexToDataAddress] = value;
        return obj;
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final Object slot(Anchor anchor, int index) {
        return slot(anchorIndex(anchor), index);
    }

    public final Object slot(int groupIndex, int index) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(groupIndex));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
        int i = index + iSlotIndex;
        if (iSlotIndex > i || i >= iDataIndex) {
            return Composer.INSTANCE.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i)];
    }

    public final int slotsStartIndex$runtime_release(int groupIndex) {
        return slotIndex(this.groups, groupIndexToAddress(groupIndex));
    }

    public final int slotsEndIndex$runtime_release(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
    }

    public final int slotsEndAllIndex$runtime_release(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + groupSize(groupIndex)));
    }

    public final void advanceBy(int amount) {
        boolean z = false;
        if (!(amount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        if (!(this.insertCount <= 0)) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (amount == 0) {
            return;
        }
        int i = this.currentGroup + amount;
        if (i >= this.parent && i <= this.currentGroupEnd) {
            z = true;
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')');
        }
        this.currentGroup = i;
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        this.currentSlot = iDataIndex;
        this.currentSlotEnd = iDataIndex;
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i));
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void endInsert() {
        if (!(this.insertCount > 0)) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        int i = this.insertCount - 1;
        this.insertCount = i;
        if (i == 0) {
            if (!(this.nodeCountStack.getTos() == this.startStack.getTos())) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            restoreCurrentGroupEnd();
        }
    }

    public final void startGroup() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        Composer.Companion companion = Composer.INSTANCE;
        startGroup(0, companion.getEmpty(), false, companion.getEmpty());
    }

    public final void startGroup(int key, Object dataKey) {
        startGroup(key, dataKey, false, Composer.INSTANCE.getEmpty());
    }

    public final void startNode(int key, Object objectKey) {
        startGroup(key, objectKey, true, Composer.INSTANCE.getEmpty());
    }

    public final void startData(int key, Object objectKey, Object aux) {
        startGroup(key, objectKey, false, aux);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startGroup(int key, Object objectKey, boolean isNode, Object aux) {
        int iGroupSize;
        GroupSourceInformation groupSourceInformationSourceInformationOf;
        int i = this.parent;
        byte b = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (b != false) {
            int i2 = this.currentGroup;
            int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i2));
            insertGroups(1);
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
            int iGroupIndexToAddress = groupIndexToAddress(i2);
            Composer.Companion companion = Composer.INSTANCE;
            int i3 = objectKey != companion.getEmpty() ? 1 : 0;
            int i4 = (isNode || aux == companion.getEmpty()) ? 0 : 1;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(iDataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length);
            if (iDataIndexToDataAnchor >= 0 && this.slotsGapOwner < i2) {
                iDataIndexToDataAnchor = -(((this.slots.length - this.slotsGapLen) - iDataIndexToDataAnchor) + 1);
            }
            SlotTableKt.initGroup(this.groups, iGroupIndexToAddress, key, isNode, i3, i4, this.parent, iDataIndexToDataAnchor);
            int i5 = (isNode ? 1 : 0) + i3 + i4;
            if (i5 > 0) {
                insertSlots(i5, i2);
                Object[] objArr = this.slots;
                int i6 = this.currentSlot;
                if (isNode) {
                    objArr[i6] = aux;
                    i6++;
                }
                if (i3 != 0) {
                    objArr[i6] = objectKey;
                    i6++;
                }
                if (i4 != 0) {
                    objArr[i6] = aux;
                    i6++;
                }
                this.currentSlot = i6;
            }
            this.nodeCount = 0;
            iGroupSize = i2 + 1;
            this.parent = i2;
            this.currentGroup = iGroupSize;
            if (i >= 0 && (groupSourceInformationSourceInformationOf = sourceInformationOf(i)) != null) {
                groupSourceInformationSourceInformationOf.reportGroup(this, i2);
            }
        } else {
            this.startStack.push(i);
            saveCurrentGroupEnd();
            int i7 = this.currentGroup;
            int iGroupIndexToAddress2 = groupIndexToAddress(i7);
            if (!Intrinsics.areEqual(aux, Composer.INSTANCE.getEmpty())) {
                if (isNode) {
                    updateNode(aux);
                } else {
                    updateAux(aux);
                }
            }
            this.currentSlot = slotIndex(this.groups, iGroupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress2);
            this.parent = i7;
            this.currentGroup = i7 + 1;
            iGroupSize = i7 + SlotTableKt.groupSize(this.groups, iGroupIndexToAddress2);
        }
        this.currentGroupEnd = iGroupSize;
    }

    public final int endGroup() {
        MutableObjectList<Object> mutableObjectList;
        boolean z = this.insertCount > 0;
        int i = this.currentGroup;
        int i2 = this.currentGroupEnd;
        int i3 = this.parent;
        int iGroupIndexToAddress = groupIndexToAddress(i3);
        int i4 = this.nodeCount;
        int i5 = i - i3;
        boolean zIsNode = SlotTableKt.isNode(this.groups, iGroupIndexToAddress);
        if (!z) {
            if (!(i == i2)) {
                ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
            }
            int iGroupSize = SlotTableKt.groupSize(this.groups, iGroupIndexToAddress);
            int iNodeCount = SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress);
            SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress, i5);
            SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress, i4);
            int iPop = this.startStack.pop();
            restoreCurrentGroupEnd();
            this.parent = iPop;
            int iParent = parent(this.groups, i3);
            int iPop2 = this.nodeCountStack.pop();
            this.nodeCount = iPop2;
            if (iParent == iPop) {
                this.nodeCount = iPop2 + (zIsNode ? 0 : i4 - iNodeCount);
            } else {
                int i6 = i5 - iGroupSize;
                int i7 = zIsNode ? 0 : i4 - iNodeCount;
                if (i6 != 0 || i7 != 0) {
                    while (iParent != 0 && iParent != iPop && (i7 != 0 || i6 != 0)) {
                        int iGroupIndexToAddress2 = groupIndexToAddress(iParent);
                        if (i6 != 0) {
                            SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress2, SlotTableKt.groupSize(this.groups, iGroupIndexToAddress2) + i6);
                        }
                        if (i7 != 0) {
                            int[] iArr = this.groups;
                            SlotTableKt.updateNodeCount(iArr, iGroupIndexToAddress2, SlotTableKt.nodeCount(iArr, iGroupIndexToAddress2) + i7);
                        }
                        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress2)) {
                            i7 = 0;
                        }
                        iParent = parent(this.groups, iParent);
                    }
                }
                this.nodeCount += i7;
            }
        } else {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            if (mutableIntObjectMap != null && (mutableObjectList = mutableIntObjectMap.get(i3)) != null) {
                Object[] objArr = mutableObjectList.content;
                int i8 = mutableObjectList._size;
                for (int i9 = 0; i9 < i8; i9++) {
                    rawUpdate(objArr[i9]);
                }
                mutableIntObjectMap.remove(i3);
            }
            SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress, i5);
            SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress, i4);
            this.nodeCount = this.nodeCountStack.pop() + (zIsNode ? 1 : i4);
            int iParent2 = parent(this.groups, i3);
            this.parent = iParent2;
            int size$runtime_release = iParent2 < 0 ? getSize$runtime_release() : groupIndexToAddress(iParent2 + 1);
            int iDataIndex = size$runtime_release >= 0 ? dataIndex(this.groups, size$runtime_release) : 0;
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
        }
        return i4;
    }

    public final void ensureStarted(int index) {
        boolean z = false;
        if (!(this.insertCount <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int i = this.parent;
        if (i != index) {
            if (index >= i && index < this.currentGroupEnd) {
                z = true;
            }
            if (!z) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + index + " must be a subgroup of the group at " + i);
            }
            int i2 = this.currentGroup;
            int i3 = this.currentSlot;
            int i4 = this.currentSlotEnd;
            this.currentGroup = index;
            startGroup();
            this.currentGroup = i2;
            this.currentSlot = i3;
            this.currentSlotEnd = i4;
        }
    }

    public final void ensureStarted(Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }

    public final int skipGroup() {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int iGroupSize = this.currentGroup + SlotTableKt.groupSize(this.groups, iGroupIndexToAddress);
        this.currentGroup = iGroupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(iGroupSize));
        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress);
    }

    public final boolean removeGroup() {
        Anchor anchorTryAnchor$runtime_release;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        int iSkipGroup = skipGroup();
        GroupSourceInformation groupSourceInformationSourceInformationOf = sourceInformationOf(this.parent);
        if (groupSourceInformationSourceInformationOf != null && (anchorTryAnchor$runtime_release = tryAnchor$runtime_release(i)) != null) {
            groupSourceInformationSourceInformationOf.removeAnchor(anchorTryAnchor$runtime_release);
        }
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty() && prioritySet.peek() >= i) {
                prioritySet.takeMax();
            }
        }
        boolean zRemoveGroups = removeGroups(i, this.currentGroup - i);
        removeSlots(iDataIndex, this.currentSlot - iDataIndex, i - 1);
        this.currentGroup = i;
        this.currentSlot = i2;
        this.nodeCount -= iSkipGroup;
        return zRemoveGroups;
    }

    public final void moveGroup(int offset) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }
        if (!(offset >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
        }
        if (offset == 0) {
            return;
        }
        int i = this.currentGroup;
        int i2 = this.parent;
        int i3 = this.currentGroupEnd;
        int iGroupSize = i;
        for (int i4 = offset; i4 > 0; i4--) {
            iGroupSize += SlotTableKt.groupSize(this.groups, groupIndexToAddress(iGroupSize));
            if (!(iGroupSize <= i3)) {
                ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
            }
        }
        int iGroupSize2 = SlotTableKt.groupSize(this.groups, groupIndexToAddress(iGroupSize));
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int iDataIndex2 = dataIndex(this.groups, groupIndexToAddress(iGroupSize));
        int i5 = iGroupSize + iGroupSize2;
        int iDataIndex3 = dataIndex(this.groups, groupIndexToAddress(i5));
        int i6 = iDataIndex3 - iDataIndex2;
        insertSlots(i6, Math.max(this.currentGroup - 1, 0));
        insertGroups(iGroupSize2);
        int[] iArr = this.groups;
        int iGroupIndexToAddress = groupIndexToAddress(i5) * 5;
        ArraysKt.copyInto(iArr, iArr, groupIndexToAddress(i) * 5, iGroupIndexToAddress, (iGroupSize2 * 5) + iGroupIndexToAddress);
        if (i6 > 0) {
            Object[] objArr = this.slots;
            ArraysKt.copyInto(objArr, objArr, iDataIndex, dataIndexToDataAddress(iDataIndex2 + i6), dataIndexToDataAddress(iDataIndex3 + i6));
        }
        int i7 = iDataIndex2 + i6;
        int i8 = i7 - iDataIndex;
        int i9 = this.slotsGapStart;
        int i10 = this.slotsGapLen;
        int length = this.slots.length;
        int i11 = this.slotsGapOwner;
        int i12 = i + iGroupSize2;
        int i13 = i;
        while (i13 < i12) {
            int iGroupIndexToAddress2 = groupIndexToAddress(i13);
            int i14 = i9;
            int i15 = i8;
            updateDataIndex(iArr, iGroupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, iGroupIndexToAddress2) - i8, i11 < iGroupIndexToAddress2 ? 0 : i14, i10, length));
            i13++;
            i9 = i14;
            i8 = i15;
        }
        moveAnchors(i5, i, iGroupSize2);
        if (removeGroups(i5, iGroupSize2)) {
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        fixParentAnchorsFor(i2, this.currentGroupEnd, i);
        if (i6 > 0) {
            removeSlots(i7, i6, i5 - 1);
        }
    }

    /* compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ List moveGroup$default(Companion companion, SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                z3 = true;
            }
            return companion.moveGroup(slotWriter, i, slotWriter2, z, z2, z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter fromWriter, int fromIndex, SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor, boolean removeSourceGroup) {
            boolean zRemoveGroups;
            List<Anchor> listEmptyList;
            int i;
            int iGroupSize = fromWriter.groupSize(fromIndex);
            int i2 = fromIndex + iGroupSize;
            int iDataIndex = fromWriter.dataIndex(fromIndex);
            int iDataIndex2 = fromWriter.dataIndex(i2);
            int i3 = iDataIndex2 - iDataIndex;
            boolean zContainsAnyGroupMarks = fromWriter.containsAnyGroupMarks(fromIndex);
            toWriter.insertGroups(iGroupSize);
            toWriter.insertSlots(i3, toWriter.getCurrentGroup());
            if (fromWriter.groupGapStart < i2) {
                fromWriter.moveGroupGapTo(i2);
            }
            if (fromWriter.slotsGapStart < iDataIndex2) {
                fromWriter.moveSlotGapTo(iDataIndex2, i2);
            }
            int[] iArr = toWriter.groups;
            int currentGroup = toWriter.getCurrentGroup();
            ArraysKt.copyInto(fromWriter.groups, iArr, currentGroup * 5, fromIndex * 5, i2 * 5);
            Object[] objArr = toWriter.slots;
            int i4 = toWriter.currentSlot;
            ArraysKt.copyInto(fromWriter.slots, objArr, i4, iDataIndex, iDataIndex2);
            int parent = toWriter.getParent();
            SlotTableKt.updateParentAnchor(iArr, currentGroup, parent);
            int i5 = currentGroup - fromIndex;
            int i6 = currentGroup + iGroupSize;
            int iDataIndex3 = i4 - toWriter.dataIndex(iArr, currentGroup);
            int i7 = toWriter.slotsGapOwner;
            int i8 = toWriter.slotsGapLen;
            int length = objArr.length;
            int i9 = i7;
            int i10 = currentGroup;
            while (true) {
                zRemoveGroups = false;
                if (i10 >= i6) {
                    break;
                }
                if (i10 != currentGroup) {
                    i = i6;
                    SlotTableKt.updateParentAnchor(iArr, i10, SlotTableKt.parentAnchor(iArr, i10) + i5);
                } else {
                    i = i6;
                }
                int i11 = iDataIndex3;
                SlotTableKt.updateDataAnchor(iArr, i10, toWriter.dataIndexToDataAnchor(toWriter.dataIndex(iArr, i10) + iDataIndex3, i9 >= i10 ? toWriter.slotsGapStart : 0, i8, length));
                if (i10 == i9) {
                    i9++;
                }
                i10++;
                iDataIndex3 = i11;
                i6 = i;
            }
            int i12 = i6;
            toWriter.slotsGapOwner = i9;
            int iLocationOf = SlotTableKt.locationOf(fromWriter.anchors, fromIndex, fromWriter.getSize$runtime_release());
            int iLocationOf2 = SlotTableKt.locationOf(fromWriter.anchors, i2, fromWriter.getSize$runtime_release());
            if (iLocationOf < iLocationOf2) {
                ArrayList arrayList = fromWriter.anchors;
                ArrayList arrayList2 = new ArrayList(iLocationOf2 - iLocationOf);
                for (int i13 = iLocationOf; i13 < iLocationOf2; i13++) {
                    Anchor anchor = (Anchor) arrayList.get(i13);
                    anchor.setLocation$runtime_release(anchor.getLocation() + i5);
                    arrayList2.add(anchor);
                }
                toWriter.anchors.addAll(SlotTableKt.locationOf(toWriter.anchors, toWriter.getCurrentGroup(), toWriter.getSize$runtime_release()), arrayList2);
                arrayList.subList(iLocationOf, iLocationOf2).clear();
                listEmptyList = arrayList2;
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (!listEmptyList.isEmpty()) {
                HashMap map = fromWriter.sourceInformationMap;
                HashMap map2 = toWriter.sourceInformationMap;
                if (map != null && map2 != null) {
                    int size = listEmptyList.size();
                    for (int i14 = 0; i14 < size; i14++) {
                        Anchor anchor2 = listEmptyList.get(i14);
                        GroupSourceInformation groupSourceInformation = (GroupSourceInformation) map.get(anchor2);
                        if (groupSourceInformation != null) {
                            map.remove(anchor2);
                            map2.put(anchor2, groupSourceInformation);
                        }
                    }
                }
            }
            int parent2 = toWriter.getParent();
            GroupSourceInformation groupSourceInformationSourceInformationOf = toWriter.sourceInformationOf(parent);
            if (groupSourceInformationSourceInformationOf != null) {
                int iGroupSize2 = parent2 + 1;
                int currentGroup2 = toWriter.getCurrentGroup();
                int i15 = -1;
                while (iGroupSize2 < currentGroup2) {
                    i15 = iGroupSize2;
                    iGroupSize2 = SlotTableKt.groupSize(toWriter.groups, iGroupSize2) + iGroupSize2;
                }
                groupSourceInformationSourceInformationOf.addGroupAfter(toWriter, i15, currentGroup2);
            }
            int iParent = fromWriter.parent(fromIndex);
            if (removeSourceGroup) {
                if (!updateFromCursor) {
                    zRemoveGroups = fromWriter.removeGroups(fromIndex, iGroupSize);
                    fromWriter.removeSlots(iDataIndex, i3, fromIndex - 1);
                } else {
                    boolean z = iParent >= 0;
                    if (z) {
                        fromWriter.startGroup();
                        fromWriter.advanceBy(iParent - fromWriter.getCurrentGroup());
                        fromWriter.startGroup();
                    }
                    fromWriter.advanceBy(fromIndex - fromWriter.getCurrentGroup());
                    boolean zRemoveGroup = fromWriter.removeGroup();
                    if (z) {
                        fromWriter.skipToGroupEnd();
                        fromWriter.endGroup();
                        fromWriter.skipToGroupEnd();
                        fromWriter.endGroup();
                    }
                    zRemoveGroups = zRemoveGroup;
                }
            }
            if (zRemoveGroups) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            toWriter.nodeCount += SlotTableKt.isNode(iArr, currentGroup) ? 1 : SlotTableKt.nodeCount(iArr, currentGroup);
            if (updateToCursor) {
                toWriter.currentGroup = i12;
                toWriter.currentSlot = i4 + i3;
            }
            if (zContainsAnyGroupMarks) {
                toWriter.updateContainsMark(parent);
            }
            return listEmptyList;
        }
    }

    public final List<Anchor> moveTo(Anchor anchor, int offset, SlotWriter writer) {
        ComposerKt.runtimeCheck(writer.insertCount > 0);
        ComposerKt.runtimeCheck(this.insertCount == 0);
        ComposerKt.runtimeCheck(anchor.getValid());
        int iAnchorIndex = anchorIndex(anchor) + offset;
        int i = this.currentGroup;
        ComposerKt.runtimeCheck(i <= iAnchorIndex && iAnchorIndex < this.currentGroupEnd);
        int iParent = parent(iAnchorIndex);
        int iGroupSize = groupSize(iAnchorIndex);
        int iNodeCount = isNode(iAnchorIndex) ? 1 : nodeCount(iAnchorIndex);
        List<Anchor> listMoveGroup$default = Companion.moveGroup$default(INSTANCE, this, iAnchorIndex, writer, false, false, false, 32, null);
        updateContainsMark(iParent);
        boolean z = iNodeCount > 0;
        while (iParent >= i) {
            int iGroupIndexToAddress = groupIndexToAddress(iParent);
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, iGroupIndexToAddress, SlotTableKt.groupSize(iArr, iGroupIndexToAddress) - iGroupSize);
            if (z) {
                if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
                    z = false;
                } else {
                    int[] iArr2 = this.groups;
                    SlotTableKt.updateNodeCount(iArr2, iGroupIndexToAddress, SlotTableKt.nodeCount(iArr2, iGroupIndexToAddress) - iNodeCount);
                }
            }
            iParent = parent(iParent);
        }
        if (z) {
            ComposerKt.runtimeCheck(this.nodeCount >= iNodeCount);
            this.nodeCount -= iNodeCount;
        }
        return listMoveGroup$default;
    }

    public final List<Anchor> moveFrom(SlotTable table, int index, boolean removeSourceGroup) {
        ComposerKt.runtimeCheck(this.insertCount > 0);
        if (index != 0 || this.currentGroup != 0 || this.table.getGroupsSize() != 0 || SlotTableKt.groupSize(table.getGroups(), index) != table.getGroupsSize()) {
            SlotWriter slotWriterOpenWriter = table.openWriter();
            try {
                List<Anchor> listMoveGroup = INSTANCE.moveGroup(slotWriterOpenWriter, index, this, true, true, removeSourceGroup);
                slotWriterOpenWriter.close(true);
                return listMoveGroup;
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        }
        int[] iArr = this.groups;
        Object[] objArr = this.slots;
        ArrayList<Anchor> arrayList = this.anchors;
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        int[] groups = table.getGroups();
        int groupsSize = table.getGroupsSize();
        Object[] slots = table.getSlots();
        int slotsSize = table.getSlotsSize();
        HashMap<Anchor, GroupSourceInformation> sourceInformationMap$runtime_release = table.getSourceInformationMap$runtime_release();
        MutableIntObjectMap<MutableIntSet> calledByMap$runtime_release = table.getCalledByMap$runtime_release();
        this.groups = groups;
        this.slots = slots;
        this.anchors = table.getAnchors$runtime_release();
        this.groupGapStart = groupsSize;
        this.groupGapLen = (groups.length / 5) - groupsSize;
        this.slotsGapStart = slotsSize;
        this.slotsGapLen = slots.length - slotsSize;
        this.slotsGapOwner = groupsSize;
        this.sourceInformationMap = sourceInformationMap$runtime_release;
        this.calledByMap = calledByMap$runtime_release;
        table.setTo$runtime_release(iArr, 0, objArr, 0, arrayList, map, mutableIntObjectMap);
        return this.anchors;
    }

    public final List<Anchor> moveIntoGroupFrom(int offset, SlotTable table, int index) {
        ComposerKt.runtimeCheck(this.insertCount <= 0 && groupSize(this.currentGroup + offset) == 1);
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int i3 = this.currentSlotEnd;
        advanceBy(offset);
        startGroup();
        beginInsert();
        SlotWriter slotWriterOpenWriter = table.openWriter();
        try {
            List<Anchor> listMoveGroup$default = Companion.moveGroup$default(INSTANCE, slotWriterOpenWriter, index, this, false, true, false, 32, null);
            slotWriterOpenWriter.close(true);
            endInsert();
            endGroup();
            this.currentGroup = i;
            this.currentSlot = i2;
            this.currentSlotEnd = i3;
            return listMoveGroup$default;
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    public final Anchor anchor(int index) {
        ArrayList<Anchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, index, getSize$runtime_release());
        if (iSearch < 0) {
            if (index > this.groupGapStart) {
                index = -(getSize$runtime_release() - index);
            }
            Anchor anchor = new Anchor(index);
            arrayList.add(-(iSearch + 1), anchor);
            return anchor;
        }
        return arrayList.get(iSearch);
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.parent;
        }
        slotWriter.markGroup(i);
    }

    public final void markGroup(int group) {
        int iGroupIndexToAddress = groupIndexToAddress(group);
        if (SlotTableKt.hasMark(this.groups, iGroupIndexToAddress)) {
            return;
        }
        SlotTableKt.updateMark(this.groups, iGroupIndexToAddress, true);
        if (SlotTableKt.containsMark(this.groups, iGroupIndexToAddress)) {
            return;
        }
        updateContainsMark(parent(group));
    }

    private final boolean containsGroupMark(int group) {
        return group >= 0 && SlotTableKt.containsMark(this.groups, groupIndexToAddress(group));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int group) {
        return group >= 0 && SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(group));
    }

    private final void recalculateMarks() {
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty()) {
                updateContainsMarkNow(prioritySet.takeMax(), prioritySet);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContainsMark(int group) {
        if (group >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet(null, 1, 0 == true ? 1 : 0);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(group);
        }
    }

    private final void updateContainsMarkNow(int group, PrioritySet set) {
        int iGroupIndexToAddress = groupIndexToAddress(group);
        boolean zChildContainsAnyMarks = childContainsAnyMarks(group);
        if (SlotTableKt.containsMark(this.groups, iGroupIndexToAddress) != zChildContainsAnyMarks) {
            SlotTableKt.updateContainsMark(this.groups, iGroupIndexToAddress, zChildContainsAnyMarks);
            int iParent = parent(group);
            if (iParent >= 0) {
                set.add(iParent);
            }
        }
    }

    private final boolean childContainsAnyMarks(int group) {
        int iGroupSize = group + 1;
        int iGroupSize2 = group + groupSize(group);
        while (iGroupSize < iGroupSize2) {
            if (SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(iGroupSize))) {
                return true;
            }
            iGroupSize += groupSize(iGroupSize);
        }
        return false;
    }

    public final int anchorIndex(Anchor anchor) {
        int location$runtime_release = anchor.getLocation();
        return location$runtime_release < 0 ? location$runtime_release + getSize$runtime_release() : location$runtime_release;
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void fixParentAnchorsFor(int parent, int endGroup, int firstChild) {
        int iParentIndexToAnchor = parentIndexToAnchor(parent, this.groupGapStart);
        while (firstChild < endGroup) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(firstChild), iParentIndexToAnchor);
            int iGroupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(firstChild)) + firstChild;
            fixParentAnchorsFor(firstChild, iGroupSize, firstChild + 1);
            firstChild = iGroupSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveGroupGapTo(int index) {
        int i = this.groupGapLen;
        int i2 = this.groupGapStart;
        if (i2 != index) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i2, index);
            }
            if (i > 0) {
                int[] iArr = this.groups;
                int i3 = index * 5;
                int i4 = i * 5;
                int i5 = i2 * 5;
                if (index < i2) {
                    ArraysKt.copyInto(iArr, iArr, i4 + i3, i3, i5);
                } else {
                    ArraysKt.copyInto(iArr, iArr, i5, i5 + i4, i3 + i4);
                }
            }
            if (index < i2) {
                i2 = index + i;
            }
            int capacity = getCapacity();
            ComposerKt.runtimeCheck(i2 < capacity);
            while (i2 < capacity) {
                int iParentAnchor = SlotTableKt.parentAnchor(this.groups, i2);
                int iParentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(iParentAnchor), index);
                if (iParentIndexToAnchor != iParentAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, i2, iParentIndexToAnchor);
                }
                i2++;
                if (i2 == index) {
                    i2 += i;
                }
            }
        }
        this.groupGapStart = index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSlotGapTo(int index, int group) {
        int i = this.slotsGapLen;
        int i2 = this.slotsGapStart;
        int i3 = this.slotsGapOwner;
        if (i2 != index) {
            Object[] objArr = this.slots;
            if (index < i2) {
                ArraysKt.copyInto(objArr, objArr, index + i, index, i2);
            } else {
                ArraysKt.copyInto(objArr, objArr, i2, i2 + i, index + i);
            }
        }
        int iMin = Math.min(group + 1, getSize$runtime_release());
        if (i3 != iMin) {
            int length = this.slots.length - i;
            if (iMin < i3) {
                int iGroupIndexToAddress = groupIndexToAddress(iMin);
                int iGroupIndexToAddress2 = groupIndexToAddress(i3);
                int i4 = this.groupGapStart;
                while (iGroupIndexToAddress < iGroupIndexToAddress2) {
                    int iDataAnchor = SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress);
                    if (!(iDataAnchor >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }
                    SlotTableKt.updateDataAnchor(this.groups, iGroupIndexToAddress, -((length - iDataAnchor) + 1));
                    iGroupIndexToAddress++;
                    if (iGroupIndexToAddress == i4) {
                        iGroupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int iGroupIndexToAddress3 = groupIndexToAddress(i3);
                int iGroupIndexToAddress4 = groupIndexToAddress(iMin);
                while (iGroupIndexToAddress3 < iGroupIndexToAddress4) {
                    int iDataAnchor2 = SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress3);
                    if (!(iDataAnchor2 < 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }
                    SlotTableKt.updateDataAnchor(this.groups, iGroupIndexToAddress3, iDataAnchor2 + length + 1);
                    iGroupIndexToAddress3++;
                    if (iGroupIndexToAddress3 == this.groupGapStart) {
                        iGroupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = iMin;
        }
        this.slotsGapStart = index;
    }

    private final void clearSlotGap() {
        int i = this.slotsGapStart;
        ArraysKt.fill(this.slots, (Object) null, i, this.slotsGapLen + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGroups(int size) {
        if (size > 0) {
            int i = this.currentGroup;
            moveGroupGapTo(i);
            int i2 = this.groupGapStart;
            int i3 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i4 = length - i3;
            if (i3 < size) {
                int iMax = Math.max(Math.max(length * 2, i4 + size), 32);
                int[] iArr2 = new int[iMax * 5];
                int i5 = iMax - i4;
                ArraysKt.copyInto(iArr, iArr2, 0, 0, i2 * 5);
                ArraysKt.copyInto(iArr, iArr2, (i2 + i5) * 5, (i3 + i2) * 5, length * 5);
                this.groups = iArr2;
                i3 = i5;
            }
            int i6 = this.currentGroupEnd;
            if (i6 >= i2) {
                this.currentGroupEnd = i6 + size;
            }
            int i7 = i2 + size;
            this.groupGapStart = i7;
            this.groupGapLen = i3 - size;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(i4 > 0 ? dataIndex(i + size) : 0, this.slotsGapOwner >= i2 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i8 = i2; i8 < i7; i8++) {
                SlotTableKt.updateDataAnchor(this.groups, i8, iDataIndexToDataAnchor);
            }
            int i9 = this.slotsGapOwner;
            if (i9 >= i2) {
                this.slotsGapOwner = i9 + size;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSlots(int size, int group) {
        if (size > 0) {
            moveSlotGapTo(this.currentSlot, group);
            int i = this.slotsGapStart;
            int i2 = this.slotsGapLen;
            if (i2 < size) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i3 = length - i2;
                int iMax = Math.max(Math.max(length * 2, i3 + size), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i4 = 0; i4 < iMax; i4++) {
                    objArr2[i4] = null;
                }
                int i5 = iMax - i3;
                ArraysKt.copyInto(objArr, objArr2, 0, 0, i);
                ArraysKt.copyInto(objArr, objArr2, i + i5, i2 + i, length);
                this.slots = objArr2;
                i2 = i5;
            }
            int i6 = this.currentSlotEnd;
            if (i6 >= i) {
                this.currentSlotEnd = i6 + size;
            }
            this.slotsGapStart = i + size;
            this.slotsGapLen = i2 - size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeGroups(int start, int len) {
        if (len > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(start);
            zRemoveAnchors = arrayList.isEmpty() ? false : removeAnchors(start, len, this.sourceInformationMap);
            this.groupGapStart = start;
            this.groupGapLen += len;
            int i = this.slotsGapOwner;
            if (i > start) {
                this.slotsGapOwner = Math.max(start, i - len);
            }
            int i2 = this.currentGroupEnd;
            if (i2 >= this.groupGapStart) {
                this.currentGroupEnd = i2 - len;
            }
            int i3 = this.parent;
            if (containsGroupMark(i3)) {
                updateContainsMark(i3);
            }
        }
        return zRemoveAnchors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GroupSourceInformation sourceInformationOf(int group) {
        Anchor anchorTryAnchor$runtime_release;
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map == null || (anchorTryAnchor$runtime_release = tryAnchor$runtime_release(group)) == null) {
            return null;
        }
        return map.get(anchorTryAnchor$runtime_release);
    }

    public final Anchor tryAnchor$runtime_release(int group) {
        if (group < 0 || group >= getSize$runtime_release()) {
            return null;
        }
        return SlotTableKt.find(this.anchors, group, getSize$runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSlots(int start, int len, int group) {
        if (len > 0) {
            int i = this.slotsGapLen;
            int i2 = start + len;
            moveSlotGapTo(i2, group);
            this.slotsGapStart = start;
            this.slotsGapLen = i + len;
            ArraysKt.fill(this.slots, (Object) null, start, i2);
            int i3 = this.currentSlotEnd;
            if (i3 >= start) {
                this.currentSlotEnd = i3 - len;
            }
        }
    }

    private final void updateNodeOfGroup(int index, Object value) {
        int iGroupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if (!(iGroupIndexToAddress < iArr.length && SlotTableKt.isNode(iArr, iGroupIndexToAddress))) {
            ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + index + " that was not created with as a node group");
        }
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))] = value;
    }

    private final void updateAnchors(int previousGapStart, int newGapStart) {
        Anchor anchor;
        int location$runtime_release;
        Anchor anchor2;
        int location$runtime_release2;
        int i;
        int capacity = getCapacity() - this.groupGapLen;
        if (previousGapStart < newGapStart) {
            for (int iLocationOf = SlotTableKt.locationOf(this.anchors, previousGapStart, capacity); iLocationOf < this.anchors.size() && (location$runtime_release2 = (anchor2 = this.anchors.get(iLocationOf)).getLocation()) < 0 && (i = location$runtime_release2 + capacity) < newGapStart; iLocationOf++) {
                anchor2.setLocation$runtime_release(i);
            }
            return;
        }
        for (int iLocationOf2 = SlotTableKt.locationOf(this.anchors, newGapStart, capacity); iLocationOf2 < this.anchors.size() && (location$runtime_release = (anchor = this.anchors.get(iLocationOf2)).getLocation()) >= 0; iLocationOf2++) {
            anchor.setLocation$runtime_release(-(capacity - location$runtime_release));
        }
    }

    private final boolean removeAnchors(int gapStart, int size, HashMap<Anchor, GroupSourceInformation> sourceInformationMap) {
        int i = size + gapStart;
        int iLocationOf = SlotTableKt.locationOf(this.anchors, i, getCapacity() - this.groupGapLen);
        if (iLocationOf >= this.anchors.size()) {
            iLocationOf--;
        }
        int i2 = iLocationOf + 1;
        int i3 = 0;
        while (iLocationOf >= 0) {
            Anchor anchor = this.anchors.get(iLocationOf);
            int iAnchorIndex = anchorIndex(anchor);
            if (iAnchorIndex < gapStart) {
                break;
            }
            if (iAnchorIndex < i) {
                anchor.setLocation$runtime_release(Integer.MIN_VALUE);
                if (sourceInformationMap != null) {
                    sourceInformationMap.remove(anchor);
                }
                if (i3 == 0) {
                    i3 = iLocationOf + 1;
                }
                i2 = iLocationOf;
            }
            iLocationOf--;
        }
        boolean z = i2 < i3;
        if (z) {
            this.anchors.subList(i2, i3).clear();
        }
        return z;
    }

    private final void moveAnchors(int originalLocation, int newLocation, int size) {
        Anchor anchor;
        int iAnchorIndex;
        int i = size + originalLocation;
        int size$runtime_release = getSize$runtime_release();
        int iLocationOf = SlotTableKt.locationOf(this.anchors, originalLocation, size$runtime_release);
        ArrayList arrayList = new ArrayList();
        if (iLocationOf >= 0) {
            while (iLocationOf < this.anchors.size() && (iAnchorIndex = anchorIndex((anchor = this.anchors.get(iLocationOf)))) >= originalLocation && iAnchorIndex < i) {
                arrayList.add(anchor);
                this.anchors.remove(iLocationOf);
            }
        }
        int i2 = newLocation - originalLocation;
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Anchor anchor2 = (Anchor) arrayList.get(i3);
            int iAnchorIndex2 = anchorIndex(anchor2) + i2;
            if (iAnchorIndex2 >= this.groupGapStart) {
                anchor2.setLocation$runtime_release(-(size$runtime_release - iAnchorIndex2));
            } else {
                anchor2.setLocation$runtime_release(iAnchorIndex2);
            }
            this.anchors.add(SlotTableKt.locationOf(this.anchors, iAnchorIndex2, size$runtime_release), anchor2);
        }
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int groupIndexToAddress(int index) {
        return index < this.groupGapStart ? index : index + this.groupGapLen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAddress(int dataIndex) {
        return dataIndex < this.slotsGapStart ? dataIndex : dataIndex + this.slotsGapLen;
    }

    private final int parent(int[] iArr, int i) {
        return parentAnchorToIndex(SlotTableKt.parentAnchor(iArr, groupIndexToAddress(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int index) {
        return dataIndex(this.groups, groupIndexToAddress(index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.dataAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int slotIndex(int[] iArr, int i) {
        return i >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.slotAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    private final void updateDataIndex(int[] iArr, int i, int i2) {
        SlotTableKt.updateDataAnchor(iArr, i, dataIndexToDataAnchor(i2, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final int nodeIndex(int[] iArr, int i) {
        return dataIndex(iArr, i);
    }

    private final int auxIndex(int[] iArr, int i) {
        return dataIndex(iArr, i) + SlotTableKt.countOneBits(SlotTableKt.groupInfo(iArr, i) >> 29);
    }

    private final int parentIndexToAnchor(int index, int gapStart) {
        return index < gapStart ? index : -((getSize$runtime_release() - index) + 2);
    }

    private final int parentAnchorToIndex(int index) {
        return index > -2 ? index : getSize$runtime_release() + index + 2;
    }
}
