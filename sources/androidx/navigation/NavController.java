package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.view.OnBackPressedCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.SerializersKt;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: NavController.kt */
@Metadata(d1 = {"\u0000Ø\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 \u0087\u00022\u00020\u0001:\u0006\u0087\u0002\u0088\u0002\u0089\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJS\u0010\u0016\u001a\u00020\t*\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u001b\u001a\u00020\t*\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001b\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0003¢\u0006\u0004\b\u001b\u0010 J3\u0010\u001b\u001a\u00020\u0019\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010#J'\u0010\u001b\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010%J9\u0010(\u001a\u00020\u00192\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000e2\u0006\u0010'\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b(\u0010)J1\u0010-\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0003¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0019H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0019H\u0002¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u0019H\u0002¢\u0006\u0004\b4\u00102J\u0019\u00107\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000105H\u0003¢\u0006\u0004\b7\u00108J\u0019\u0010;\u001a\u0004\u0018\u00010$2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010>\u001a\u00020=*\b\u0012\u0004\u0012\u00020\u00060*H\u0002¢\u0006\u0004\b>\u0010?J!\u0010@\u001a\u00020$\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0004\b@\u0010AJ5\u0010D\u001a\u00020\t2\u0006\u0010B\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u0001052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0004\bD\u0010EJ!\u0010F\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\bF\u0010GJ5\u0010I\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u0001052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bI\u0010JJ;\u0010K\u001a\u00020\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010C\u001a\u0004\u0018\u0001052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bK\u0010LJ%\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0002¢\u0006\u0004\bN\u0010OJ9\u0010S\u001a\u00020\t2\u0006\u0010B\u001a\u00020\r2\b\u0010P\u001a\u0004\u0018\u0001052\u0006\u0010Q\u001a\u00020\u00062\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\tH\u0002¢\u0006\u0004\bU\u0010VJ\u0019\u0010Y\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\bW\u0010XJ\u0017\u0010\\\u001a\u00020\t2\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\t2\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b^\u0010]J\u000f\u0010_\u001a\u00020\u0019H\u0017¢\u0006\u0004\b_\u00102J!\u0010_\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0019H\u0017¢\u0006\u0004\b_\u0010`J)\u0010_\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0004\b_\u0010 J)\u0010_\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b_\u0010%J%\u0010e\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00062\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\t0aH\u0000¢\u0006\u0004\bc\u0010dJ\u000f\u0010f\u001a\u00020\u0019H\u0017¢\u0006\u0004\bf\u00102J\u000f\u0010h\u001a\u00020\tH\u0000¢\u0006\u0004\bg\u0010VJ\u0015\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0000¢\u0006\u0004\bi\u0010jJ\u0019\u0010m\u001a\u00020\t2\b\b\u0001\u0010l\u001a\u00020\u001dH\u0017¢\u0006\u0004\bm\u0010nJ#\u0010m\u001a\u00020\t2\b\b\u0001\u0010l\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u000105H\u0017¢\u0006\u0004\bm\u0010oJ!\u0010m\u001a\u00020\t2\u0006\u0010p\u001a\u00020=2\b\u00106\u001a\u0004\u0018\u000105H\u0017¢\u0006\u0004\bm\u0010qJ\u0019\u0010t\u001a\u00020\u00192\b\u0010s\u001a\u0004\u0018\u00010rH\u0017¢\u0006\u0004\bt\u0010uJ\u001b\u0010v\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\bv\u0010wJ'\u0010y\u001a\u0004\u0018\u00010\r*\u00020\r2\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u0019H\u0007¢\u0006\u0004\by\u0010zJ\u0019\u0010D\u001a\u00020\t2\b\b\u0001\u0010{\u001a\u00020\u001dH\u0017¢\u0006\u0004\bD\u0010nJ#\u0010D\u001a\u00020\t2\b\b\u0001\u0010{\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u000105H\u0017¢\u0006\u0004\bD\u0010oJ-\u0010D\u001a\u00020\t2\b\b\u0001\u0010{\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u0001052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\bD\u0010|J7\u0010D\u001a\u00020\t2\b\b\u0001\u0010{\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u0001052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\bD\u0010}J\u0017\u0010D\u001a\u00020\t2\u0006\u0010:\u001a\u00020~H\u0017¢\u0006\u0004\bD\u0010\u007fJ\u001a\u0010D\u001a\u00020\t2\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0017¢\u0006\u0005\bD\u0010\u0082\u0001J$\u0010D\u001a\u00020\t2\b\u0010\u0081\u0001\u001a\u00030\u0080\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0005\bD\u0010\u0083\u0001J.\u0010D\u001a\u00020\t2\b\u0010\u0081\u0001\u001a\u00030\u0080\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0005\bD\u0010\u0084\u0001J\u001a\u0010D\u001a\u00020\t2\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001H\u0017¢\u0006\u0005\bD\u0010\u0087\u0001J.\u0010D\u001a\u00020\t2\u0006\u0010\"\u001a\u00020$2\u0014\u0010\u0089\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\t0\u0014H\u0007¢\u0006\u0005\bD\u0010\u008a\u0001J0\u0010D\u001a\u00020\t2\u0006\u0010\"\u001a\u00020$2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0005\bD\u0010\u008b\u0001J\u0013\u0010\u008d\u0001\u001a\u00030\u008c\u0001H\u0016¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0012\u0010\u001a\u001a\u0004\u0018\u000105H\u0017¢\u0006\u0005\b\u001a\u0010\u008f\u0001J\u001c\u0010\u0091\u0001\u001a\u00020\t2\t\u0010\u0090\u0001\u001a\u0004\u0018\u000105H\u0017¢\u0006\u0005\b\u0091\u0001\u00108J\u001c\u0010\u0094\u0001\u001a\u00020\t2\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001H\u0017¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001c\u0010\u0098\u0001\u001a\u00020\t2\b\u0010\u0097\u0001\u001a\u00030\u0096\u0001H\u0017¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001c\u0010\u009a\u0001\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u000f\n\u0005\b\u0003\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001b\u0010¥\u0001\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001b\u0010§\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R#\u0010«\u0001\u001a\f\u0012\u0005\u0012\u00030ª\u0001\u0018\u00010©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u001d\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R$\u0010²\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0±\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R,\u0010µ\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0´\u00018GX\u0087\u0004¢\u0006\u0010\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001R$\u0010¹\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0±\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010³\u0001R)\u0010º\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0´\u00018\u0006¢\u0006\u0010\n\u0006\bº\u0001\u0010¶\u0001\u001a\u0006\b»\u0001\u0010¸\u0001R$\u0010½\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R%\u0010À\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030¿\u00010¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010¾\u0001R&\u0010Á\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010$0¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010¾\u0001R*\u0010Â\u0001\u001a\u0015\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010¾\u0001R\u001c\u0010Ã\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u001e\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020Z0È\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R*\u0010Ì\u0001\u001a\u00030Ë\u00018@@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R\u0018\u0010Ó\u0001\u001a\u00030Ò\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u0018\u0010Ö\u0001\u001a\u00030Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u0019\u0010Ø\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010®\u0001R\u001a\u0010Ú\u0001\u001a\u00030Ù\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R1\u0010Ý\u0001\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u0012\t\u0012\u00070Ü\u0001R\u00020\u00000¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010¾\u0001R'\u0010Þ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R'\u0010à\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010ß\u0001R$\u0010á\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0001\u0010¾\u0001R\u0019\u0010â\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001e\u0010å\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R!\u0010ë\u0001\u001a\u00030¢\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\bç\u0001\u0010è\u0001\u001a\u0006\bé\u0001\u0010ê\u0001R\u001e\u0010í\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ì\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R#\u0010ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ï\u00018\u0006¢\u0006\u0010\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001R\u0017\u0010ö\u0001\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\b\u001a\u0006\bô\u0001\u0010õ\u0001R'\u0010p\u001a\u00020=2\u0006\u0010p\u001a\u00020=8W@WX\u0096\u000e¢\u0006\u000f\u001a\u0006\b÷\u0001\u0010ø\u0001\"\u0005\bm\u0010ù\u0001R,\u0010ú\u0001\u001a\u00030Ù\u00012\b\u0010ú\u0001\u001a\u00030Ù\u00018V@WX\u0096\u000e¢\u0006\u0010\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R\u0019\u0010\u0081\u0002\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\u0019\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002R\u0019\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0085\u0002\u0010\u0083\u0002¨\u0006\u008a\u0002"}, d2 = {"Landroidx/navigation/NavController;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/navigation/NavBackStackEntry;", "child", "parent", "", "linkChildToParent", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavBackStackEntry;)V", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Lkotlin/Function1;", "handler", "navigateInternal", "(Landroidx/navigation/Navigator;Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;Lkotlin/jvm/functions/Function1;)V", "popUpTo", "", "saveState", "popBackStackInternal", "(Landroidx/navigation/Navigator;Landroidx/navigation/NavBackStackEntry;ZLkotlin/jvm/functions/Function1;)V", "", "destinationId", "inclusive", "(IZZ)Z", "T", "route", "(Ljava/lang/Object;ZZ)Z", "", "(Ljava/lang/String;ZZ)Z", "popOperations", "foundDestination", "executePopOperations", "(Ljava/util/List;Landroidx/navigation/NavDestination;ZZ)Z", "Lkotlin/collections/ArrayDeque;", "Landroidx/navigation/NavBackStackEntryState;", "savedState", "popEntryFromBackStack", "(Landroidx/navigation/NavBackStackEntry;ZLkotlin/collections/ArrayDeque;)V", "clearBackStackInternal", "(I)Z", "tryRelaunchUpToExplicitStack", "()Z", "tryRelaunchUpToGeneratedStack", "dispatchOnDestinationChanged", "Landroid/os/Bundle;", "startDestinationArgs", "onGraphCreated", "(Landroid/os/Bundle;)V", "", "deepLink", "findInvalidDestinationDisplayNameInDeepLink", "([I)Ljava/lang/String;", "Landroidx/navigation/NavGraph;", "getTopGraph", "(Lkotlin/collections/ArrayDeque;)Landroidx/navigation/NavGraph;", "generateRouteFilled", "(Ljava/lang/Object;)Ljava/lang/String;", "node", "args", "navigate", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "launchSingleTopInternal", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Z", "id", "restoreStateInternal", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "executeRestoreState", "(Ljava/util/List;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "backStackState", "instantiateBackStack", "(Lkotlin/collections/ArrayDeque;)Ljava/util/List;", "finalArgs", "backStackEntry", "restoredEntries", "addEntryToBackStack", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavBackStackEntry;Ljava/util/List;)V", "updateOnBackPressedCallbackEnabled", "()V", "unlinkChildFromParent$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;)Landroidx/navigation/NavBackStackEntry;", "unlinkChildFromParent", "Landroidx/navigation/NavController$OnDestinationChangedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnDestinationChangedListener", "(Landroidx/navigation/NavController$OnDestinationChangedListener;)V", "removeOnDestinationChangedListener", "popBackStack", "(IZ)Z", "Lkotlin/Function0;", "onComplete", "popBackStackFromNavigator$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;Lkotlin/jvm/functions/Function0;)V", "popBackStackFromNavigator", "navigateUp", "updateBackStackLifecycle$navigation_runtime_release", "updateBackStackLifecycle", "populateVisibleEntries$navigation_runtime_release", "()Ljava/util/List;", "populateVisibleEntries", "graphResId", "setGraph", "(I)V", "(ILandroid/os/Bundle;)V", "graph", "(Landroidx/navigation/NavGraph;Landroid/os/Bundle;)V", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "handleDeepLink", "(Landroid/content/Intent;)Z", "findDestination", "(I)Landroidx/navigation/NavDestination;", "searchChildren", "findDestinationComprehensive", "(Landroidx/navigation/NavDestination;IZ)Landroidx/navigation/NavDestination;", "resId", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;)V", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "Landroidx/navigation/NavDeepLinkRequest;", "request", "(Landroidx/navigation/NavDeepLinkRequest;)V", "(Landroidx/navigation/NavDeepLinkRequest;Landroidx/navigation/NavOptions;)V", "(Landroidx/navigation/NavDeepLinkRequest;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDirections;", "directions", "(Landroidx/navigation/NavDirections;)V", "Landroidx/navigation/NavOptionsBuilder;", "builder", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDeepLinkBuilder;", "createDeepLink", "()Landroidx/navigation/NavDeepLinkBuilder;", "()Landroid/os/Bundle;", "navState", "restoreState", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "setViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "getBackStackEntry", "(I)Landroidx/navigation/NavBackStackEntry;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Landroidx/navigation/NavInflater;", "inflater", "Landroidx/navigation/NavInflater;", "_graph", "Landroidx/navigation/NavGraph;", "navigatorStateToRestore", "Landroid/os/Bundle;", "", "Landroid/os/Parcelable;", "backStackToRestore", "[Landroid/os/Parcelable;", "deepLinkHandled", "Z", "backQueue", "Lkotlin/collections/ArrayDeque;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_currentBackStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "currentBackStack", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "_visibleEntries", "visibleEntries", "getVisibleEntries", "", "childToParentEntries", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicInteger;", "parentToChildCount", "backStackMap", "backStackStates", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/navigation/NavControllerViewModel;", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "enableOnBackPressedCallback", "Landroidx/navigation/NavigatorProvider;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorState", "addToBackStackHandler", "Lkotlin/jvm/functions/Function1;", "popFromBackStackHandler", "entrySavedState", "dispatchReentrantCount", "I", "", "backStackEntriesToDispatch", "Ljava/util/List;", "navInflater$delegate", "Lkotlin/Lazy;", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "getDestinationCountOnBackStack", "()I", "destinationCountOnBackStack", "getGraph", "()Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavGraph;)V", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "currentDestination", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "getPreviousBackStackEntry", "previousBackStackEntry", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NavController {
    private static boolean deepLinkSaveState = true;
    private final MutableStateFlow<List<NavBackStackEntry>> _currentBackStack;
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    private NavigatorProvider _navigatorProvider;
    private final MutableStateFlow<List<NavBackStackEntry>> _visibleEntries;
    private Activity activity;
    private Function1<? super NavBackStackEntry, Unit> addToBackStackHandler;
    private final ArrayDeque<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    private final Map<Integer, String> backStackMap;
    private final Map<String, ArrayDeque<NavBackStackEntryState>> backStackStates;
    private Parcelable[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final Context context;
    private final StateFlow<List<NavBackStackEntry>> currentBackStack;
    private final Flow<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    private NavInflater inflater;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;

    /* renamed from: navInflater$delegate, reason: from kotlin metadata */
    private final Lazy navInflater;
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final OnBackPressedCallback onBackPressedCallback;
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    private Function1<? super NavBackStackEntry, Unit> popFromBackStackHandler;
    private NavControllerViewModel viewModel;
    private final StateFlow<List<NavBackStackEntry>> visibleEntries;

    /* compiled from: NavController.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments);
    }

    public NavController(Context context) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Iterator it = SequencesKt.generateSequence(context, new Function1<Context, Context>() { // from class: androidx.navigation.NavController$activity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2 instanceof ContextWrapper) {
                    return ((ContextWrapper) it2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Context) next) instanceof Activity) {
                    break;
                }
            }
        }
        this.activity = (Activity) next;
        this.backQueue = new ArrayDeque<>();
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._currentBackStack = MutableStateFlow;
        this.currentBackStack = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._visibleEntries = MutableStateFlow2;
        this.visibleEntries = FlowKt.asStateFlow(MutableStateFlow2);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.NavController$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavController.lifecycleObserver$lambda$2(this.f$0, lifecycleOwner, event);
            }
        };
        this.onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            {
                super(false);
            }

            @Override // androidx.view.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.this$0.popBackStack();
            }
        };
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this._navigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater = LazyKt.lazy(new Function0<NavInflater>() { // from class: androidx.navigation.NavController$navInflater$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavInflater invoke() {
                NavInflater navInflater = this.this$0.inflater;
                return navInflater == null ? new NavInflater(this.this$0.getContext(), this.this$0._navigatorProvider) : navInflater;
            }
        });
        MutableSharedFlow<NavBackStackEntry> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._currentBackStackEntryFlow = mutableSharedFlowMutableSharedFlow$default;
        this.currentBackStackEntryFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    public final Context getContext() {
        return this.context;
    }

    public NavGraph getGraph() {
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        Intrinsics.checkNotNull(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return navGraph;
    }

    public void setGraph(NavGraph graph) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(graph, "graph");
        setGraph(graph, (Bundle) null);
    }

    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    private final void linkChildToParent(NavBackStackEntry child, NavBackStackEntry parent) {
        this.childToParentEntries.put(child, parent);
        if (this.parentToChildCount.get(parent) == null) {
            this.parentToChildCount.put(parent, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(parent);
        Intrinsics.checkNotNull(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry child) {
        Intrinsics.checkNotNullParameter(child, "child");
        NavBackStackEntry navBackStackEntryRemove = this.childToParentEntries.remove(child);
        if (navBackStackEntryRemove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(navBackStackEntryRemove);
        Integer numValueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntryRemove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(navBackStackEntryRemove);
            }
            this.parentToChildCount.remove(navBackStackEntryRemove);
        }
        return navBackStackEntryRemove;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner == null) {
            return Lifecycle.State.CREATED;
        }
        return this.hostLifecycleState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lifecycleObserver$lambda$2(NavController this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.hostLifecycleState = event.getTargetState();
        if (this$0._graph != null) {
            Iterator<NavBackStackEntry> it = this$0.backQueue.iterator();
            while (it.hasNext()) {
                it.next().handleLifecycleEvent(event);
            }
        }
    }

    /* renamed from: getNavigatorProvider, reason: from getter */
    public NavigatorProvider get_navigatorProvider() {
        return this._navigatorProvider;
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, Function1<? super NavBackStackEntry, Unit> function1) {
        this.addToBackStackHandler = function1;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z, Function1<? super NavBackStackEntry, Unit> function1) {
        this.popFromBackStackHandler = function1;
        navigator.popBackStack(navBackStackEntry, z);
        this.popFromBackStackHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavController.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u000bR\u001f\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigator", "<init>", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "", "push", "(Landroidx/navigation/NavBackStackEntry;)V", "addInternal", "destination", "Landroid/os/Bundle;", "arguments", "createBackStackEntry", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "saveState", "pop", "(Landroidx/navigation/NavBackStackEntry;Z)V", "popWithTransition", "entry", "markTransitionComplete", "prepareForTransition", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    final class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(NavController navController, Navigator<? extends NavDestination> navigator) {
            Intrinsics.checkNotNullParameter(navigator, "navigator");
            this.this$0 = navController;
            this.navigator = navigator;
        }

        @Override // androidx.navigation.NavigatorState
        public void push(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(backStackEntry.getDestination().getNavigatorName());
            if (Intrinsics.areEqual(navigator, this.navigator)) {
                Function1 function1 = this.this$0.addToBackStackHandler;
                if (function1 != null) {
                    function1.invoke(backStackEntry);
                    addInternal(backStackEntry);
                    return;
                }
                Log.i("NavController", "Ignoring add of destination " + backStackEntry.getDestination() + " outside of the call to navigate(). ");
                return;
            }
            Object obj = this.this$0.navigatorState.get(navigator);
            if (obj == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
            }
            ((NavControllerNavigatorState) obj).push(backStackEntry);
        }

        public final void addInternal(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            super.push(backStackEntry);
        }

        @Override // androidx.navigation.NavigatorState
        public NavBackStackEntry createBackStackEntry(NavDestination destination, Bundle arguments) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.this$0.getContext(), destination, arguments, this.this$0.getHostLifecycleState$navigation_runtime_release(), this.this$0.viewModel, null, null, 96, null);
        }

        @Override // androidx.navigation.NavigatorState
        public void pop(final NavBackStackEntry popUpTo, final boolean saveState) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(popUpTo.getDestination().getNavigatorName());
            this.this$0.entrySavedState.put(popUpTo, Boolean.valueOf(saveState));
            if (Intrinsics.areEqual(navigator, this.navigator)) {
                Function1 function1 = this.this$0.popFromBackStackHandler;
                if (function1 != null) {
                    function1.invoke(popUpTo);
                    super.pop(popUpTo, saveState);
                    return;
                } else {
                    this.this$0.popBackStackFromNavigator$navigation_runtime_release(popUpTo, new Function0<Unit>() { // from class: androidx.navigation.NavController$NavControllerNavigatorState$pop$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            super/*androidx.navigation.NavigatorState*/.pop(popUpTo, saveState);
                        }
                    });
                    return;
                }
            }
            Object obj = this.this$0.navigatorState.get(navigator);
            Intrinsics.checkNotNull(obj);
            ((NavControllerNavigatorState) obj).pop(popUpTo, saveState);
        }

        @Override // androidx.navigation.NavigatorState
        public void popWithTransition(NavBackStackEntry popUpTo, boolean saveState) {
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            super.popWithTransition(popUpTo, saveState);
        }

        @Override // androidx.navigation.NavigatorState
        public void markTransitionComplete(NavBackStackEntry entry) {
            NavControllerViewModel navControllerViewModel;
            Intrinsics.checkNotNullParameter(entry, "entry");
            boolean zAreEqual = Intrinsics.areEqual(this.this$0.entrySavedState.get(entry), Boolean.TRUE);
            super.markTransitionComplete(entry);
            this.this$0.entrySavedState.remove(entry);
            if (!this.this$0.backQueue.contains(entry)) {
                this.this$0.unlinkChildFromParent$navigation_runtime_release(entry);
                if (entry.getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
                    entry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                }
                ArrayDeque arrayDeque = this.this$0.backQueue;
                if (arrayDeque == null || !arrayDeque.isEmpty()) {
                    Iterator<E> it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((NavBackStackEntry) it.next()).getId(), entry.getId())) {
                            break;
                        }
                    }
                    if (!zAreEqual && (navControllerViewModel = this.this$0.viewModel) != null) {
                        navControllerViewModel.clear(entry.getId());
                    }
                } else if (!zAreEqual) {
                    navControllerViewModel.clear(entry.getId());
                }
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
                return;
            }
            if (getIsNavigating()) {
                return;
            }
            this.this$0.updateBackStackLifecycle$navigation_runtime_release();
            this.this$0._currentBackStack.tryEmit(CollectionsKt.toMutableList((Collection) this.this$0.backQueue));
            this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
        }

        @Override // androidx.navigation.NavigatorState
        public void prepareForTransition(NavBackStackEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            super.prepareForTransition(entry);
            if (this.this$0.backQueue.contains(entry)) {
                entry.setMaxLifecycle(Lifecycle.State.STARTED);
                return;
            }
            throw new IllegalStateException("Cannot transition entry that is not in the back stack");
        }
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDestinationChangedListeners.add(listener);
        if (this.backQueue.isEmpty()) {
            return;
        }
        NavBackStackEntry navBackStackEntryLast = this.backQueue.last();
        listener.onDestinationChanged(this, navBackStackEntryLast.getDestination(), navBackStackEntryLast.getArguments());
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDestinationChangedListeners.remove(listener);
    }

    public boolean popBackStack() {
        if (this.backQueue.isEmpty()) {
            return false;
        }
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        return popBackStack(currentDestination.getId(), true);
    }

    public boolean popBackStack(int destinationId, boolean inclusive) {
        return popBackStack(destinationId, inclusive, false);
    }

    public boolean popBackStack(int destinationId, boolean inclusive, boolean saveState) {
        return popBackStackInternal(destinationId, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStack(str, z, z2);
    }

    public final boolean popBackStack(String route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal(route, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStackInternal(i, z, z2);
    }

    private final boolean popBackStackInternal(int destinationId, boolean inclusive, boolean saveState) throws Resources.NotFoundException {
        NavDestination destination;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        while (true) {
            if (!it.hasNext()) {
                destination = null;
                break;
            }
            destination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(destination.getNavigatorName());
            if (inclusive || destination.getId() != destinationId) {
                arrayList.add(navigator);
            }
            if (destination.getId() == destinationId) {
                break;
            }
        }
        if (destination == null) {
            Log.i("NavController", "Ignoring popBackStack to destination " + NavDestination.INSTANCE.getDisplayName(this.context, destinationId) + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations(arrayList, destination, inclusive, saveState);
    }

    private final <T> boolean popBackStackInternal(T route, boolean inclusive, boolean saveState) {
        return popBackStackInternal(generateRouteFilled(route), inclusive, saveState);
    }

    private final boolean popBackStackInternal(String route, boolean inclusive, boolean saveState) {
        NavBackStackEntry navBackStackEntryPrevious;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
            boolean zHasRoute = navBackStackEntry.getDestination().hasRoute(route, navBackStackEntry.getArguments());
            if (inclusive || !zHasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
            }
            if (zHasRoute) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntryPrevious;
        NavDestination destination = navBackStackEntry2 != null ? navBackStackEntry2.getDestination() : null;
        if (destination == null) {
            Log.i("NavController", "Ignoring popBackStack to route " + route + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations(arrayList, destination, inclusive, saveState);
    }

    private final boolean executePopOperations(List<? extends Navigator<?>> popOperations, NavDestination foundDestination, boolean inclusive, final boolean saveState) {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>();
        Iterator<? extends Navigator<?>> it = popOperations.iterator();
        while (it.hasNext()) {
            Navigator<? extends NavDestination> navigator = (Navigator) it.next();
            final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            popBackStackInternal(navigator, this.backQueue.last(), saveState, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController.executePopOperations.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
                    invoke2(navBackStackEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry entry) {
                    Intrinsics.checkNotNullParameter(entry, "entry");
                    ref$BooleanRef2.element = true;
                    ref$BooleanRef.element = true;
                    this.popEntryFromBackStack(entry, saveState, arrayDeque);
                }
            });
            if (!ref$BooleanRef2.element) {
                break;
            }
        }
        if (saveState) {
            if (!inclusive) {
                for (NavDestination navDestination : SequencesKt.takeWhile(SequencesKt.generateSequence(foundDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController.executePopOperations.2
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination destination) {
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        NavGraph parent = destination.getParent();
                        if (parent == null || parent.getStartDestId() != destination.getId()) {
                            return null;
                        }
                        return destination.getParent();
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController.executePopOperations.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination destination) {
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        return Boolean.valueOf(!NavController.this.backStackMap.containsKey(Integer.valueOf(destination.getId())));
                    }
                })) {
                    Map<Integer, String> map = this.backStackMap;
                    Integer numValueOf = Integer.valueOf(navDestination.getId());
                    NavBackStackEntryState navBackStackEntryStateFirstOrNull = arrayDeque.firstOrNull();
                    map.put(numValueOf, navBackStackEntryStateFirstOrNull != null ? navBackStackEntryStateFirstOrNull.getId() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryStateFirst = arrayDeque.first();
                Iterator it2 = SequencesKt.takeWhile(SequencesKt.generateSequence(findDestination(navBackStackEntryStateFirst.getDestinationId()), new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController.executePopOperations.5
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination destination) {
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        NavGraph parent = destination.getParent();
                        if (parent == null || parent.getStartDestId() != destination.getId()) {
                            return null;
                        }
                        return destination.getParent();
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController.executePopOperations.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination destination) {
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        return Boolean.valueOf(!NavController.this.backStackMap.containsKey(Integer.valueOf(destination.getId())));
                    }
                }).iterator();
                while (it2.hasNext()) {
                    this.backStackMap.put(Integer.valueOf(((NavDestination) it2.next()).getId()), navBackStackEntryStateFirst.getId());
                }
                if (this.backStackMap.values().contains(navBackStackEntryStateFirst.getId())) {
                    this.backStackStates.put(navBackStackEntryStateFirst.getId(), arrayDeque);
                }
            }
        }
        updateOnBackPressedCallbackEnabled();
        return ref$BooleanRef.element;
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry popUpTo, Function0<Unit> onComplete) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        int iIndexOf = this.backQueue.indexOf(popUpTo);
        if (iIndexOf < 0) {
            Log.i("NavController", "Ignoring pop of " + popUpTo + " as it was not found on the current back stack");
            return;
        }
        int i = iIndexOf + 1;
        if (i != this.backQueue.size()) {
            popBackStackInternal(this.backQueue.get(i).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$default(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void popEntryFromBackStack$default(NavController navController, NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            arrayDeque = new ArrayDeque();
        }
        navController.popEntryFromBackStack(navBackStackEntry, z, arrayDeque);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void popEntryFromBackStack(NavBackStackEntry popUpTo, boolean saveState, ArrayDeque<NavBackStackEntryState> savedState) {
        NavControllerViewModel navControllerViewModel;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        NavBackStackEntry navBackStackEntryLast = this.backQueue.last();
        if (!Intrinsics.areEqual(navBackStackEntryLast, popUpTo)) {
            throw new IllegalStateException(("Attempted to pop " + popUpTo.getDestination() + ", which is not the top of the back stack (" + navBackStackEntryLast.getDestination() + ')').toString());
        }
        CollectionsKt.removeLast(this.backQueue);
        NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(navBackStackEntryLast.getDestination().getNavigatorName()));
        boolean z = true;
        if ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(navBackStackEntryLast)) && !this.parentToChildCount.containsKey(navBackStackEntryLast)) {
            z = false;
        }
        Lifecycle.State state = navBackStackEntryLast.getLifecycle().getState();
        Lifecycle.State state2 = Lifecycle.State.CREATED;
        if (state.isAtLeast(state2)) {
            if (saveState) {
                navBackStackEntryLast.setMaxLifecycle(state2);
                savedState.addFirst(new NavBackStackEntryState(navBackStackEntryLast));
            }
            if (!z) {
                navBackStackEntryLast.setMaxLifecycle(Lifecycle.State.DESTROYED);
                unlinkChildFromParent$navigation_runtime_release(navBackStackEntryLast);
            } else {
                navBackStackEntryLast.setMaxLifecycle(state2);
            }
        }
        if (saveState || z || (navControllerViewModel = this.viewModel) == null) {
            return;
        }
        navControllerViewModel.clear(navBackStackEntryLast.getId());
    }

    private final boolean clearBackStackInternal(int destinationId) {
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean zRestoreStateInternal = restoreStateInternal(destinationId, null, NavOptionsBuilderKt.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: androidx.navigation.NavController$clearBackStackInternal$restored$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                invoke2(navOptionsBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavOptionsBuilder navOptions) {
                Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                navOptions.setRestoreState(true);
            }
        }), null);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return zRestoreStateInternal && popBackStackInternal(destinationId, true, false);
    }

    public boolean navigateUp() {
        Intent intent;
        if (getDestinationCountOnBackStack() == 1) {
            Activity activity = this.activity;
            Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
            if ((extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null) != null) {
                return tryRelaunchUpToExplicitStack();
            }
            return tryRelaunchUpToGeneratedStack();
        }
        return popBackStack();
    }

    private final boolean tryRelaunchUpToExplicitStack() throws Resources.NotFoundException {
        int i = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        int[] intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
        Intrinsics.checkNotNull(intArray);
        List<Integer> mutableList = ArraysKt.toMutableList(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        int iIntValue = ((Number) CollectionsKt.removeLast(mutableList)).intValue();
        if (parcelableArrayList != null) {
        }
        if (mutableList.isEmpty()) {
            return false;
        }
        NavDestination navDestinationFindDestinationComprehensive = findDestinationComprehensive(getGraph(), iIntValue, false);
        if (navDestinationFindDestinationComprehensive instanceof NavGraph) {
            iIntValue = NavGraph.INSTANCE.findStartDestination((NavGraph) navDestinationFindDestinationComprehensive).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (currentDestination == null || iIntValue != currentDestination.getId()) {
            return false;
        }
        NavDeepLinkBuilder navDeepLinkBuilderCreateDeepLink = createDeepLink();
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("android-support-nav:controller:deepLinkIntent", intent));
        Bundle bundle = extras.getBundle("android-support-nav:controller:deepLinkExtras");
        if (bundle != null) {
            bundleBundleOf.putAll(bundle);
        }
        navDeepLinkBuilderCreateDeepLink.setArguments(bundleBundleOf);
        for (Object obj : mutableList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            navDeepLinkBuilderCreateDeepLink.addDestination(((Number) obj).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i) : null);
            i = i2;
        }
        navDeepLinkBuilderCreateDeepLink.createTaskStackBuilder().startActivities();
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return true;
        }
        activity2.finish();
        return true;
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestId() != id) {
                Bundle bundle = new Bundle();
                Activity activity = this.activity;
                if (activity != null) {
                    Intrinsics.checkNotNull(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.activity;
                        Intrinsics.checkNotNull(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.activity;
                            Intrinsics.checkNotNull(activity3);
                            bundle.putParcelable("android-support-nav:controller:deepLinkIntent", activity3.getIntent());
                            NavGraph topGraph = getTopGraph(this.backQueue);
                            Activity activity4 = this.activity;
                            Intrinsics.checkNotNull(activity4);
                            Intent intent = activity4.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = topGraph.matchDeepLinkComprehensive(new NavDeepLinkRequest(intent), true, true, topGraph);
                            if ((deepLinkMatchMatchDeepLinkComprehensive != null ? deepLinkMatchMatchDeepLinkComprehensive.getMatchingArgs() : null) != null) {
                                bundle.putAll(deepLinkMatchMatchDeepLinkComprehensive.getDestination().addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.getMatchingArgs()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), null, 2, null).setArguments(bundle).createTaskStackBuilder().startActivities();
                Activity activity5 = this.activity;
                if (activity5 != null) {
                    activity5.finish();
                }
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    private final int getDestinationCountOnBackStack() {
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        int i = 0;
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            Iterator<NavBackStackEntry> it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (!(it.next().getDestination() instanceof NavGraph) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$default(this, this.backQueue.last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntryLastOrNull = this.backQueue.lastOrNull();
        if (navBackStackEntryLastOrNull != null) {
            this.backStackEntriesToDispatch.add(navBackStackEntryLastOrNull);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : mutableList) {
                Iterator<OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry);
            }
            this._currentBackStack.tryEmit(CollectionsKt.toMutableList((Collection) this.backQueue));
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
        return navBackStackEntryLastOrNull != null;
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        AtomicInteger atomicInteger;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.backQueue);
        if (mutableList.isEmpty()) {
            return;
        }
        NavDestination destination = ((NavBackStackEntry) CollectionsKt.last(mutableList)).getDestination();
        ArrayList arrayList = new ArrayList();
        if (destination instanceof FloatingWindow) {
            Iterator it = CollectionsKt.reversed(mutableList).iterator();
            while (it.hasNext()) {
                NavDestination destination2 = ((NavBackStackEntry) it.next()).getDestination();
                arrayList.add(destination2);
                if (!(destination2 instanceof FloatingWindow) && !(destination2 instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap map = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed(mutableList)) {
            Lifecycle.State maxLifecycle = navBackStackEntry.getMaxLifecycle();
            NavDestination destination3 = navBackStackEntry.getDestination();
            if (destination != null && destination3.getId() == destination.getId()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (maxLifecycle != state) {
                    NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
                    if (!Intrinsics.areEqual((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null) ? null : Boolean.valueOf(value.contains(navBackStackEntry)), Boolean.TRUE) && ((atomicInteger = this.parentToChildCount.get(navBackStackEntry)) == null || atomicInteger.get() != 0)) {
                        map.put(navBackStackEntry, state);
                    } else {
                        map.put(navBackStackEntry, Lifecycle.State.STARTED);
                    }
                }
                NavDestination navDestination = (NavDestination) CollectionsKt.firstOrNull((List) arrayList);
                if (navDestination != null && navDestination.getId() == destination3.getId()) {
                    CollectionsKt.removeFirst(arrayList);
                }
                destination = destination.getParent();
            } else if (!arrayList.isEmpty() && destination3.getId() == ((NavDestination) CollectionsKt.first((List) arrayList)).getId()) {
                NavDestination navDestination2 = (NavDestination) CollectionsKt.removeFirst(arrayList);
                if (maxLifecycle == Lifecycle.State.RESUMED) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (maxLifecycle != state2) {
                        map.put(navBackStackEntry, state2);
                    }
                }
                NavGraph parent = navDestination2.getParent();
                if (parent != null && !arrayList.contains(parent)) {
                    arrayList.add(parent);
                }
            } else {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : mutableList) {
            Lifecycle.State state3 = (Lifecycle.State) map.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.setMaxLifecycle(state3);
            } else {
                navBackStackEntry2.updateState();
            }
        }
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            Set<NavBackStackEntry> value = ((NavControllerNavigatorState) it.next()).getTransitionsInProgress().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ArrayList arrayList3 = new ArrayList();
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque) {
            NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
            if (!arrayList.contains(navBackStackEntry3) && navBackStackEntry3.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(navBackStackEntry2);
            }
        }
        CollectionsKt.addAll(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!(((NavBackStackEntry) obj2).getDestination() instanceof NavGraph)) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater.getValue();
    }

    public void setGraph(int graphResId) throws Resources.NotFoundException {
        setGraph(getNavInflater().inflate(graphResId), (Bundle) null);
    }

    public void setGraph(int graphResId, Bundle startDestinationArgs) throws Resources.NotFoundException {
        setGraph(getNavInflater().inflate(graphResId), startDestinationArgs);
    }

    public void setGraph(NavGraph graph, Bundle startDestinationArgs) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(graph, "graph");
        if (!Intrinsics.areEqual(this._graph, graph)) {
            NavGraph navGraph = this._graph;
            if (navGraph != null) {
                for (Integer id : new ArrayList(this.backStackMap.keySet())) {
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    clearBackStackInternal(id.intValue());
                }
                popBackStackInternal$default(this, navGraph.getId(), true, false, 4, null);
            }
            this._graph = graph;
            onGraphCreated(startDestinationArgs);
            return;
        }
        int size = graph.getNodes().size();
        for (int i = 0; i < size; i++) {
            NavDestination navDestinationValueAt = graph.getNodes().valueAt(i);
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            int iKeyAt = navGraph2.getNodes().keyAt(i);
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            navGraph3.getNodes().replace(iKeyAt, navDestinationValueAt);
        }
        for (NavBackStackEntry navBackStackEntry : this.backQueue) {
            List<NavDestination> listAsReversed = CollectionsKt.asReversed(SequencesKt.toList(NavDestination.INSTANCE.getHierarchy(navBackStackEntry.getDestination())));
            NavDestination navDestinationFindNode = this._graph;
            Intrinsics.checkNotNull(navDestinationFindNode);
            for (NavDestination navDestination : listAsReversed) {
                if (!Intrinsics.areEqual(navDestination, this._graph) || !Intrinsics.areEqual(navDestinationFindNode, graph)) {
                    if (navDestinationFindNode instanceof NavGraph) {
                        navDestinationFindNode = ((NavGraph) navDestinationFindNode).findNode(navDestination.getId());
                        Intrinsics.checkNotNull(navDestinationFindNode);
                    }
                }
            }
            navBackStackEntry.setDestination(navDestinationFindNode);
        }
    }

    private final void onGraphCreated(Bundle startDestinationArgs) throws Resources.NotFoundException {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle = this.navigatorStateToRestore;
        if (bundle != null && (stringArrayList = bundle.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String name = it.next();
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Navigator navigator = navigatorProvider.getNavigator(name);
                Bundle bundle2 = bundle.getBundle(name);
                if (bundle2 != null) {
                    navigator.onRestoreState(bundle2);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination navDestinationFindDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (navDestinationFindDestination == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
                NavBackStackEntry navBackStackEntryInstantiate = navBackStackEntryState.instantiate(this.context, navDestinationFindDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator<? extends NavDestination> navigator2 = this._navigatorProvider.getNavigator(navDestinationFindDestination.getNavigatorName());
                Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.navigatorState;
                NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                if (navControllerNavigatorState == null) {
                    navControllerNavigatorState = new NavControllerNavigatorState(this, navigator2);
                    map.put(navigator2, navControllerNavigatorState);
                }
                this.backQueue.add(navBackStackEntryInstantiate);
                navControllerNavigatorState.addInternal(navBackStackEntryInstantiate);
                NavGraph parent = navBackStackEntryInstantiate.getDestination().getParent();
                if (parent != null) {
                    linkChildToParent(navBackStackEntryInstantiate, getBackStackEntry(parent.getId()));
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        Collection<Navigator<? extends NavDestination>> collectionValues = this._navigatorProvider.getNavigators().values();
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((Navigator) obj).getIsAttached()) {
                arrayList.add(obj);
            }
        }
        for (Navigator<? extends NavDestination> navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph != null && this.backQueue.isEmpty()) {
            if (!this.deepLinkHandled && (activity = this.activity) != null) {
                Intrinsics.checkNotNull(activity);
                if (handleDeepLink(activity.getIntent())) {
                    return;
                }
            }
            NavGraph navGraph = this._graph;
            Intrinsics.checkNotNull(navGraph);
            navigate(navGraph, startDestinationArgs, (NavOptions) null, (Navigator.Extras) null);
            return;
        }
        dispatchOnDestinationChanged();
    }

    public boolean handleDeepLink(Intent intent) throws Resources.NotFoundException {
        int[] intArray;
        NavGraph topGraph;
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive;
        NavDestination navDestinationFindNode;
        NavGraph navGraph;
        Bundle bundle;
        int i = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
            } catch (Exception e) {
                Log.e("NavController", "handleDeepLink() could not extract deepLink from " + intent, e);
            }
        } else {
            intArray = null;
        }
        ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs") : null;
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        if ((intArray == null || intArray.length == 0) && (deepLinkMatchMatchDeepLinkComprehensive = (topGraph = getTopGraph(this.backQueue)).matchDeepLinkComprehensive(new NavDeepLinkRequest(intent), true, true, topGraph)) != null) {
            NavDestination destination = deepLinkMatchMatchDeepLinkComprehensive.getDestination();
            int[] iArrBuildDeepLinkIds$default = NavDestination.buildDeepLinkIds$default(destination, null, 1, null);
            Bundle bundleAddInDefaultArgs = destination.addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.getMatchingArgs());
            if (bundleAddInDefaultArgs != null) {
                bundle2.putAll(bundleAddInDefaultArgs);
            }
            intArray = iArrBuildDeepLinkIds$default;
            parcelableArrayList = null;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String strFindInvalidDestinationDisplayNameInDeepLink = findInvalidDestinationDisplayNameInDeepLink(intArray);
        if (strFindInvalidDestinationDisplayNameInDeepLink != null) {
            Log.i("NavController", "Could not find destination " + strFindInvalidDestinationDisplayNameInDeepLink + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle2.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int length = intArray.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i2 = 0; i2 < length; i2++) {
            Bundle bundle4 = new Bundle();
            bundle4.putAll(bundle2);
            if (parcelableArrayList != null && (bundle = (Bundle) parcelableArrayList.get(i2)) != null) {
                bundle4.putAll(bundle);
            }
            bundleArr[i2] = bundle4;
        }
        int flags = intent.getFlags();
        int i3 = 268435456 & flags;
        if (i3 != 0 && (flags & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) == 0) {
            intent.addFlags(pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP);
            TaskStackBuilder taskStackBuilderAddNextIntentWithParentStack = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(intent);
            Intrinsics.checkNotNullExpressionValue(taskStackBuilderAddNextIntentWithParentStack, "create(context).addNextI…ntWithParentStack(intent)");
            taskStackBuilderAddNextIntentWithParentStack.startActivities();
            Activity activity = this.activity;
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i3 != 0) {
            if (!this.backQueue.isEmpty()) {
                NavGraph navGraph2 = this._graph;
                Intrinsics.checkNotNull(navGraph2);
                popBackStackInternal$default(this, navGraph2.getId(), true, false, 4, null);
            }
            while (i < intArray.length) {
                int i4 = intArray[i];
                int i5 = i + 1;
                Bundle bundle5 = bundleArr[i];
                final NavDestination navDestinationFindDestination = findDestination(i4);
                if (navDestinationFindDestination == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, i4) + " cannot be found from the current destination " + getCurrentDestination());
                }
                navigate(navDestinationFindDestination, bundle5, NavOptionsBuilderKt.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: androidx.navigation.NavController.handleDeepLink.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        navOptions.anim(new Function1<AnimBuilder, Unit>() { // from class: androidx.navigation.NavController.handleDeepLink.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimBuilder animBuilder) {
                                invoke2(animBuilder);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AnimBuilder anim) {
                                Intrinsics.checkNotNullParameter(anim, "$this$anim");
                                anim.setEnter(0);
                                anim.setExit(0);
                            }
                        });
                        NavDestination navDestination = navDestinationFindDestination;
                        if (navDestination instanceof NavGraph) {
                            Sequence<NavDestination> hierarchy = NavDestination.INSTANCE.getHierarchy(navDestination);
                            NavController navController = this;
                            for (NavDestination navDestination2 : hierarchy) {
                                NavDestination currentDestination = navController.getCurrentDestination();
                                if (Intrinsics.areEqual(navDestination2, currentDestination != null ? currentDestination.getParent() : null)) {
                                    return;
                                }
                            }
                            if (NavController.deepLinkSaveState) {
                                navOptions.popUpTo(NavGraph.INSTANCE.findStartDestination(this.getGraph()).getId(), new Function1<PopUpToBuilder, Unit>() { // from class: androidx.navigation.NavController.handleDeepLink.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                        invoke2(popUpToBuilder);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(PopUpToBuilder popUpTo) {
                                        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                        popUpTo.setSaveState(true);
                                    }
                                });
                            }
                        }
                    }
                }), (Navigator.Extras) null);
                i = i5;
            }
            this.deepLinkHandled = true;
            return true;
        }
        NavGraph navGraph3 = this._graph;
        int length2 = intArray.length;
        for (int i6 = 0; i6 < length2; i6++) {
            int i7 = intArray[i6];
            Bundle bundle6 = bundleArr[i6];
            if (i6 == 0) {
                navDestinationFindNode = this._graph;
            } else {
                Intrinsics.checkNotNull(navGraph3);
                navDestinationFindNode = navGraph3.findNode(i7);
            }
            if (navDestinationFindNode == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, i7) + " cannot be found in graph " + navGraph3);
            }
            if (i6 != intArray.length - 1) {
                if (navDestinationFindNode instanceof NavGraph) {
                    while (true) {
                        navGraph = (NavGraph) navDestinationFindNode;
                        Intrinsics.checkNotNull(navGraph);
                        if (!(navGraph.findNode(navGraph.getStartDestId()) instanceof NavGraph)) {
                            break;
                        }
                        navDestinationFindNode = navGraph.findNode(navGraph.getStartDestId());
                    }
                    navGraph3 = navGraph;
                }
            } else {
                NavOptions.Builder builder = new NavOptions.Builder();
                NavGraph navGraph4 = this._graph;
                Intrinsics.checkNotNull(navGraph4);
                navigate(navDestinationFindNode, bundle6, NavOptions.Builder.setPopUpTo$default(builder, navGraph4.getId(), true, false, 4, null).setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
            }
        }
        this.deepLinkHandled = true;
        return true;
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] deepLink) {
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        int length = deepLink.length;
        int i = 0;
        while (true) {
            NavDestination navDestinationFindNode = null;
            if (i >= length) {
                return null;
            }
            int i2 = deepLink[i];
            if (i == 0) {
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                if (navGraph3.getId() == i2) {
                    navDestinationFindNode = this._graph;
                }
            } else {
                Intrinsics.checkNotNull(navGraph2);
                navDestinationFindNode = navGraph2.findNode(i2);
            }
            if (navDestinationFindNode == null) {
                return NavDestination.INSTANCE.getDisplayName(this.context, i2);
            }
            if (i != deepLink.length - 1 && (navDestinationFindNode instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestinationFindNode;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestinationFindNode = navGraph.findNode(navGraph.getStartDestId());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    public final NavDestination findDestination(int destinationId) {
        NavDestination destination;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.getId() == destinationId) {
            return this._graph;
        }
        NavBackStackEntry navBackStackEntryLastOrNull = this.backQueue.lastOrNull();
        if (navBackStackEntryLastOrNull == null || (destination = navBackStackEntryLastOrNull.getDestination()) == null) {
            destination = this._graph;
            Intrinsics.checkNotNull(destination);
        }
        return findDestinationComprehensive(destination, destinationId, false);
    }

    public final NavDestination findDestinationComprehensive(NavDestination navDestination, int i, boolean z) {
        NavGraph navGraph;
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        if (navDestination.getId() == i) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            NavGraph parent = navDestination.getParent();
            Intrinsics.checkNotNull(parent);
            navGraph = parent;
        }
        return navGraph.findNodeComprehensive(i, navGraph, z);
    }

    private final NavGraph getTopGraph(ArrayDeque<NavBackStackEntry> arrayDeque) {
        NavDestination destination;
        NavBackStackEntry navBackStackEntryLastOrNull = arrayDeque.lastOrNull();
        if (navBackStackEntryLastOrNull == null || (destination = navBackStackEntryLastOrNull.getDestination()) == null) {
            destination = this._graph;
            Intrinsics.checkNotNull(destination);
        }
        if (destination instanceof NavGraph) {
            return (NavGraph) destination;
        }
        NavGraph parent = destination.getParent();
        Intrinsics.checkNotNull(parent);
        return parent;
    }

    private final <T> String generateRouteFilled(T route) {
        NavDestination navDestinationFindDestinationComprehensive = findDestinationComprehensive(getGraph(), RouteSerializerKt.generateHashCode(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()))), true);
        if (navDestinationFindDestinationComprehensive == null) {
            throw new IllegalArgumentException(("Destination with route " + Reflection.getOrCreateKotlinClass(route.getClass()).getSimpleName() + " cannot be found in navigation graph " + this._graph).toString());
        }
        Map<String, NavArgument> arguments = navDestinationFindDestinationComprehensive.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
        Iterator<T> it = arguments.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        return RouteSerializerKt.generateRouteWithArgs(route, linkedHashMap);
    }

    public void navigate(int resId) throws Resources.NotFoundException {
        navigate(resId, (Bundle) null);
    }

    public void navigate(int resId, Bundle args) throws Resources.NotFoundException {
        navigate(resId, args, (NavOptions) null);
    }

    public void navigate(int resId, Bundle args, NavOptions navOptions) throws Resources.NotFoundException {
        navigate(resId, args, navOptions, (Navigator.Extras) null);
    }

    public void navigate(int resId, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) throws Resources.NotFoundException {
        int destinationId;
        NavDestination destination = this.backQueue.isEmpty() ? this._graph : this.backQueue.last().getDestination();
        if (destination == null) {
            throw new IllegalStateException("No current destination found. Ensure a navigation graph has been set for NavController " + this + '.');
        }
        NavAction action = destination.getAction(resId);
        Bundle bundle = null;
        if (action != null) {
            if (navOptions == null) {
                navOptions = action.getNavOptions();
            }
            destinationId = action.getDestinationId();
            Bundle defaultArguments = action.getDefaultArguments();
            if (defaultArguments != null) {
                bundle = new Bundle();
                bundle.putAll(defaultArguments);
            }
        } else {
            destinationId = resId;
        }
        if (args != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putAll(args);
        }
        if (destinationId == 0 && navOptions != null && (navOptions.getPopUpToId() != -1 || navOptions.getPopUpToRoute() != null || navOptions.getPopUpToRouteClass() != null)) {
            if (navOptions.getPopUpToRoute() != null) {
                String popUpToRoute = navOptions.getPopUpToRoute();
                Intrinsics.checkNotNull(popUpToRoute);
                popBackStack$default(this, popUpToRoute, navOptions.getPopUpToInclusive(), false, 4, null);
                return;
            } else if (navOptions.getPopUpToRouteClass() != null) {
                KClass<?> popUpToRouteClass = navOptions.getPopUpToRouteClass();
                Intrinsics.checkNotNull(popUpToRouteClass);
                popBackStack(RouteSerializerKt.generateHashCode(SerializersKt.serializer(popUpToRouteClass)), navOptions.getPopUpToInclusive());
                return;
            } else {
                if (navOptions.getPopUpToId() != -1) {
                    popBackStack(navOptions.getPopUpToId(), navOptions.getPopUpToInclusive());
                    return;
                }
                return;
            }
        }
        if (destinationId == 0) {
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        NavDestination navDestinationFindDestination = findDestination(destinationId);
        if (navDestinationFindDestination == null) {
            NavDestination.Companion companion = NavDestination.INSTANCE;
            String displayName = companion.getDisplayName(this.context, destinationId);
            if (action != null) {
                throw new IllegalArgumentException(("Navigation destination " + displayName + " referenced from action " + companion.getDisplayName(this.context, resId) + " cannot be found from the current destination " + destination).toString());
            }
            throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + destination);
        }
        navigate(navDestinationFindDestination, bundle, navOptions, navigatorExtras);
    }

    public void navigate(Uri deepLink) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null));
    }

    public void navigate(NavDeepLinkRequest request) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(request, "request");
        navigate(request, (NavOptions) null);
    }

    public void navigate(NavDeepLinkRequest request, NavOptions navOptions) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(request, "request");
        navigate(request, navOptions, (Navigator.Extras) null);
    }

    public void navigate(NavDeepLinkRequest request, NavOptions navOptions, Navigator.Extras navigatorExtras) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this._graph == null) {
            throw new IllegalArgumentException(("Cannot navigate to " + request + ". Navigation graph has not been set for NavController " + this + '.').toString());
        }
        NavGraph topGraph = getTopGraph(this.backQueue);
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = topGraph.matchDeepLinkComprehensive(request, true, true, topGraph);
        if (deepLinkMatchMatchDeepLinkComprehensive != null) {
            Bundle bundleAddInDefaultArgs = deepLinkMatchMatchDeepLinkComprehensive.getDestination().addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.getMatchingArgs());
            if (bundleAddInDefaultArgs == null) {
                bundleAddInDefaultArgs = new Bundle();
            }
            NavDestination destination = deepLinkMatchMatchDeepLinkComprehensive.getDestination();
            Intent intent = new Intent();
            intent.setDataAndType(request.getUri(), request.getMimeType());
            intent.setAction(request.getAction());
            bundleAddInDefaultArgs.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
            navigate(destination, bundleAddInDefaultArgs, navOptions, navigatorExtras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + request + " cannot be found in the navigation graph " + this._graph);
    }

    private final void navigate(final NavDestination node, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) throws Resources.NotFoundException {
        boolean z;
        boolean z2;
        boolean zPopBackStackInternal;
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        if (navOptions == null) {
            z = false;
        } else {
            if (navOptions.getPopUpToRoute() != null) {
                String popUpToRoute = navOptions.getPopUpToRoute();
                Intrinsics.checkNotNull(popUpToRoute);
                zPopBackStackInternal = popBackStackInternal(popUpToRoute, navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
            } else if (navOptions.getPopUpToRouteClass() != null) {
                KClass<?> popUpToRouteClass = navOptions.getPopUpToRouteClass();
                Intrinsics.checkNotNull(popUpToRouteClass);
                zPopBackStackInternal = popBackStackInternal(RouteSerializerKt.generateHashCode(SerializersKt.serializer(popUpToRouteClass)), navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
            } else if (navOptions.getPopUpToRouteObject() != null) {
                Object popUpToRouteObject = navOptions.getPopUpToRouteObject();
                Intrinsics.checkNotNull(popUpToRouteObject);
                zPopBackStackInternal = popBackStackInternal((NavController) popUpToRouteObject, navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
            } else {
                if (navOptions.getPopUpToId() != -1) {
                    zPopBackStackInternal = popBackStackInternal(navOptions.getPopUpToId(), navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
                }
                z = false;
            }
            z = zPopBackStackInternal;
        }
        final Bundle bundleAddInDefaultArgs = node.addInDefaultArgs(args);
        if (navOptions != null && navOptions.getRestoreState() && this.backStackMap.containsKey(Integer.valueOf(node.getId()))) {
            ref$BooleanRef.element = restoreStateInternal(node.getId(), bundleAddInDefaultArgs, navOptions, navigatorExtras);
            z2 = false;
        } else {
            z2 = navOptions != null && navOptions.getSingleTop() && launchSingleTopInternal(node, args);
            if (!z2) {
                navigateInternal(this._navigatorProvider.getNavigator(node.getNavigatorName()), CollectionsKt.listOf(NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, node, bundleAddInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null)), navOptions, navigatorExtras, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController.navigate.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
                        invoke2(navBackStackEntry);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavBackStackEntry it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        ref$BooleanRef.element = true;
                        NavController.addEntryToBackStack$default(this, node, bundleAddInDefaultArgs, it2, null, 8, null);
                    }
                });
            }
        }
        updateOnBackPressedCallbackEnabled();
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        if (z || ref$BooleanRef.element || z2) {
            dispatchOnDestinationChanged();
        } else {
            updateBackStackLifecycle$navigation_runtime_release();
        }
    }

    private final boolean launchSingleTopInternal(NavDestination node, Bundle args) {
        int iNextIndex;
        NavDestination destination;
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            if (listIterator.previous().getDestination() == node) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (iNextIndex == -1) {
            return false;
        }
        if (node instanceof NavGraph) {
            List list = SequencesKt.toList(SequencesKt.map(NavGraph.INSTANCE.childHierarchy((NavGraph) node), new Function1<NavDestination, Integer>() { // from class: androidx.navigation.NavController$launchSingleTopInternal$childHierarchyId$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(NavDestination it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(it.getId());
                }
            }));
            if (this.backQueue.size() - iNextIndex != list.size()) {
                return false;
            }
            ArrayDeque<NavBackStackEntry> arrayDeque2 = this.backQueue;
            List<NavBackStackEntry> listSubList = arrayDeque2.subList(iNextIndex, arrayDeque2.size());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList, 10));
            Iterator<T> it = listSubList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((NavBackStackEntry) it.next()).getDestination().getId()));
            }
            if (!Intrinsics.areEqual(arrayList, list)) {
                return false;
            }
        } else if (currentBackStackEntry == null || (destination = currentBackStackEntry.getDestination()) == null || node.getId() != destination.getId()) {
            return false;
        }
        ArrayDeque<NavBackStackEntry> arrayDeque3 = new ArrayDeque();
        while (CollectionsKt.getLastIndex(this.backQueue) >= iNextIndex) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.removeLast(this.backQueue);
            unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
            arrayDeque3.addFirst(new NavBackStackEntry(navBackStackEntry, navBackStackEntry.getDestination().addInDefaultArgs(args)));
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque3) {
            NavGraph parent = navBackStackEntry2.getDestination().getParent();
            if (parent != null) {
                linkChildToParent(navBackStackEntry2, getBackStackEntry(parent.getId()));
            }
            this.backQueue.add(navBackStackEntry2);
        }
        for (NavBackStackEntry navBackStackEntry3 : arrayDeque3) {
            this._navigatorProvider.getNavigator(navBackStackEntry3.getDestination().getNavigatorName()).onLaunchSingleTop(navBackStackEntry3);
        }
        return true;
    }

    private final boolean restoreStateInternal(int id, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        if (!this.backStackMap.containsKey(Integer.valueOf(id))) {
            return false;
        }
        final String str = this.backStackMap.get(Integer.valueOf(id));
        CollectionsKt.removeAll(this.backStackMap.values(), new Function1<String, Boolean>() { // from class: androidx.navigation.NavController.restoreStateInternal.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                return Boolean.valueOf(Intrinsics.areEqual(str2, str));
            }
        });
        return executeRestoreState(instantiateBackStack((ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str)), args, navOptions, navigatorExtras);
    }

    private final boolean executeRestoreState(final List<NavBackStackEntry> entries, final Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        ArrayList<List<NavBackStackEntry>> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : entries) {
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) CollectionsKt.lastOrNull((List) arrayList);
            if (Intrinsics.areEqual((list == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list)) == null || (destination = navBackStackEntry.getDestination()) == null) ? null : destination.getNavigatorName(), navBackStackEntry2.getDestination().getNavigatorName())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt.mutableListOf(navBackStackEntry2));
            }
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        for (List<NavBackStackEntry> list2 : arrayList) {
            Navigator<? extends NavDestination> navigator = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt.first((List) list2)).getDestination().getNavigatorName());
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            navigateInternal(navigator, list2, navOptions, navigatorExtras, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController.executeRestoreState.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry3) {
                    invoke2(navBackStackEntry3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry entry) {
                    List<NavBackStackEntry> listEmptyList;
                    Intrinsics.checkNotNullParameter(entry, "entry");
                    ref$BooleanRef.element = true;
                    int iIndexOf = entries.indexOf(entry);
                    if (iIndexOf != -1) {
                        int i = iIndexOf + 1;
                        listEmptyList = entries.subList(ref$IntRef.element, i);
                        ref$IntRef.element = i;
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    this.addEntryToBackStack(entry.getDestination(), args, entry, listEmptyList);
                }
            });
        }
        return ref$BooleanRef.element;
    }

    private final List<NavBackStackEntry> instantiateBackStack(ArrayDeque<NavBackStackEntryState> backStackState) throws Resources.NotFoundException {
        NavDestination graph;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntryLastOrNull = this.backQueue.lastOrNull();
        if (navBackStackEntryLastOrNull == null || (graph = navBackStackEntryLastOrNull.getDestination()) == null) {
            graph = getGraph();
        }
        if (backStackState != null) {
            for (NavBackStackEntryState navBackStackEntryState : backStackState) {
                NavDestination navDestinationFindDestinationComprehensive = findDestinationComprehensive(graph, navBackStackEntryState.getDestinationId(), true);
                if (navDestinationFindDestinationComprehensive == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + graph).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(this.context, navDestinationFindDestinationComprehensive, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                graph = navDestinationFindDestinationComprehensive;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void addEntryToBackStack$default(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
        }
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        navController.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addEntryToBackStack(NavDestination node, Bundle finalArgs, NavBackStackEntry backStackEntry, List<NavBackStackEntry> restoredEntries) {
        ArrayDeque<NavBackStackEntry> arrayDeque;
        NavDestination destination;
        List<NavBackStackEntry> list;
        NavBackStackEntry navBackStackEntry;
        Bundle bundle;
        NavBackStackEntry navBackStackEntryPrevious;
        NavGraph navGraph;
        NavBackStackEntry navBackStackEntryPrevious2;
        List<NavBackStackEntry> list2;
        Bundle bundle2;
        Bundle bundle3 = finalArgs;
        NavBackStackEntry navBackStackEntry2 = backStackEntry;
        List<NavBackStackEntry> list3 = restoredEntries;
        NavDestination destination2 = backStackEntry.getDestination();
        if (!(destination2 instanceof FloatingWindow)) {
            while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof FloatingWindow) && popBackStackInternal$default(this, this.backQueue.last().getDestination().getId(), true, false, 4, null)) {
            }
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        NavBackStackEntry navBackStackEntry3 = null;
        if (node instanceof NavGraph) {
            NavDestination navDestination = destination2;
            while (true) {
                Intrinsics.checkNotNull(navDestination);
                NavGraph parent = navDestination.getParent();
                if (parent != null) {
                    ListIterator<NavBackStackEntry> listIterator = list3.listIterator(restoredEntries.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            navBackStackEntryPrevious2 = listIterator.previous();
                            if (Intrinsics.areEqual(navBackStackEntryPrevious2.getDestination(), parent)) {
                                break;
                            }
                        } else {
                            navBackStackEntryPrevious2 = null;
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntryCreate$default = navBackStackEntryPrevious2;
                    if (navBackStackEntryCreate$default == null) {
                        destination = destination2;
                        list2 = list3;
                        bundle2 = bundle3;
                        navBackStackEntry = navBackStackEntry2;
                        navBackStackEntryCreate$default = NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, parent, finalArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
                    } else {
                        destination = destination2;
                        list2 = list3;
                        navBackStackEntry = navBackStackEntry2;
                        bundle2 = bundle3;
                    }
                    arrayDeque2.addFirst(navBackStackEntryCreate$default);
                    if (this.backQueue.isEmpty() || this.backQueue.last().getDestination() != parent) {
                        list = list2;
                        bundle = bundle2;
                        navGraph = parent;
                        arrayDeque = arrayDeque2;
                    } else {
                        list = list2;
                        bundle = bundle2;
                        navGraph = parent;
                        arrayDeque = arrayDeque2;
                        popEntryFromBackStack$default(this, this.backQueue.last(), false, null, 6, null);
                    }
                } else {
                    navGraph = parent;
                    arrayDeque = arrayDeque2;
                    destination = destination2;
                    list = list3;
                    navBackStackEntry = navBackStackEntry2;
                    bundle = bundle3;
                }
                if (navGraph == null || navGraph == node) {
                    break;
                }
                navBackStackEntry2 = navBackStackEntry;
                arrayDeque2 = arrayDeque;
                navDestination = navGraph;
                bundle3 = bundle;
                list3 = list;
                destination2 = destination;
            }
        } else {
            arrayDeque = arrayDeque2;
            destination = destination2;
            list = list3;
            navBackStackEntry = navBackStackEntry2;
            bundle = bundle3;
        }
        NavDestination destination3 = arrayDeque.isEmpty() ? destination : ((NavBackStackEntry) arrayDeque.first()).getDestination();
        while (destination3 != null && findDestination(destination3.getId()) != destination3) {
            destination3 = destination3.getParent();
            if (destination3 != null) {
                Bundle bundle4 = (bundle == null || !finalArgs.isEmpty()) ? bundle : null;
                ListIterator<NavBackStackEntry> listIterator2 = list.listIterator(restoredEntries.size());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        navBackStackEntryPrevious = listIterator2.previous();
                        if (Intrinsics.areEqual(navBackStackEntryPrevious.getDestination(), destination3)) {
                            break;
                        }
                    } else {
                        navBackStackEntryPrevious = null;
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntryCreate$default2 = navBackStackEntryPrevious;
                if (navBackStackEntryCreate$default2 == null) {
                    navBackStackEntryCreate$default2 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, destination3, destination3.addInDefaultArgs(bundle4), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
                }
                arrayDeque.addFirst(navBackStackEntryCreate$default2);
            }
        }
        if (!arrayDeque.isEmpty()) {
            destination = ((NavBackStackEntry) arrayDeque.first()).getDestination();
        }
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            NavDestination destination4 = this.backQueue.last().getDestination();
            Intrinsics.checkNotNull(destination4, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((NavGraph) destination4).getNodes().get(destination.getId()) != null) {
                break;
            } else {
                popEntryFromBackStack$default(this, this.backQueue.last(), false, null, 6, null);
            }
        }
        NavBackStackEntry navBackStackEntryFirstOrNull = this.backQueue.firstOrNull();
        if (navBackStackEntryFirstOrNull == null) {
            navBackStackEntryFirstOrNull = (NavBackStackEntry) arrayDeque.firstOrNull();
        }
        if (!Intrinsics.areEqual(navBackStackEntryFirstOrNull != null ? navBackStackEntryFirstOrNull.getDestination() : null, this._graph)) {
            ListIterator<NavBackStackEntry> listIterator3 = list.listIterator(restoredEntries.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                NavBackStackEntry navBackStackEntryPrevious3 = listIterator3.previous();
                NavDestination destination5 = navBackStackEntryPrevious3.getDestination();
                NavGraph navGraph2 = this._graph;
                Intrinsics.checkNotNull(navGraph2);
                if (Intrinsics.areEqual(destination5, navGraph2)) {
                    navBackStackEntry3 = navBackStackEntryPrevious3;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntryCreate$default3 = navBackStackEntry3;
            if (navBackStackEntryCreate$default3 == null) {
                NavBackStackEntry.Companion companion = NavBackStackEntry.INSTANCE;
                Context context = this.context;
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                NavGraph navGraph4 = this._graph;
                Intrinsics.checkNotNull(navGraph4);
                navBackStackEntryCreate$default3 = NavBackStackEntry.Companion.create$default(companion, context, navGraph3, navGraph4.addInDefaultArgs(bundle), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
            }
            arrayDeque.addFirst(navBackStackEntryCreate$default3);
        }
        for (NavBackStackEntry navBackStackEntry4 : arrayDeque) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry4.getDestination().getNavigatorName()));
            if (navControllerNavigatorState == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + node.getNavigatorName() + " should already be created").toString());
            }
            navControllerNavigatorState.addInternal(navBackStackEntry4);
        }
        this.backQueue.addAll(arrayDeque);
        this.backQueue.add(navBackStackEntry);
        for (NavBackStackEntry navBackStackEntry5 : CollectionsKt.plus((Collection<? extends NavBackStackEntry>) arrayDeque, navBackStackEntry)) {
            NavGraph parent2 = navBackStackEntry5.getDestination().getParent();
            if (parent2 != null) {
                linkChildToParent(navBackStackEntry5, getBackStackEntry(parent2.getId()));
            }
        }
    }

    public void navigate(NavDirections directions) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null);
    }

    public final void navigate(String route, Function1<? super NavOptionsBuilder, Unit> builder) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        navigate$default(this, route, NavOptionsBuilderKt.navOptions(builder), null, 4, null);
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 2) != 0) {
            navOptions = null;
        }
        if ((i & 4) != 0) {
            extras = null;
        }
        navController.navigate(str, navOptions, extras);
    }

    public final void navigate(String route, NavOptions navOptions, Navigator.Extras navigatorExtras) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(route, "route");
        if (this._graph == null) {
            throw new IllegalArgumentException(("Cannot navigate to " + route + ". Navigation graph has not been set for NavController " + this + '.').toString());
        }
        NavGraph topGraph = getTopGraph(this.backQueue);
        NavDestination.DeepLinkMatch deepLinkMatchMatchRouteComprehensive = topGraph.matchRouteComprehensive(route, true, true, topGraph);
        if (deepLinkMatchMatchRouteComprehensive != null) {
            NavDestination destination = deepLinkMatchMatchRouteComprehensive.getDestination();
            Bundle bundleAddInDefaultArgs = destination.addInDefaultArgs(deepLinkMatchMatchRouteComprehensive.getMatchingArgs());
            if (bundleAddInDefaultArgs == null) {
                bundleAddInDefaultArgs = new Bundle();
            }
            NavDestination destination2 = deepLinkMatchMatchRouteComprehensive.getDestination();
            Intent intent = new Intent();
            Uri uri = Uri.parse(NavDestination.INSTANCE.createRoute(destination.getRoute()));
            Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
            intent.setDataAndType(uri, null);
            intent.setAction(null);
            bundleAddInDefaultArgs.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
            navigate(destination2, bundleAddInDefaultArgs, navOptions, navigatorExtras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches route " + route + " cannot be found in the navigation graph " + this._graph);
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this._navigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle bundleOnSaveState = entry.getValue().onSaveState();
            if (bundleOnSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, bundleOnSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        }
        if (!this.backQueue.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.backQueue.size()];
            Iterator<NavBackStackEntry> it = this.backQueue.iterator();
            int i = 0;
            while (it.hasNext()) {
                parcelableArr[i] = new NavBackStackEntryState(it.next());
                i++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i2 = 0;
            for (Map.Entry<Integer, String> entry2 : this.backStackMap.entrySet()) {
                int iIntValue = entry2.getKey().intValue();
                String value = entry2.getValue();
                iArr[i2] = iIntValue;
                arrayList2.add(value);
                i2++;
            }
            bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
            bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry<String, ArrayDeque<NavBackStackEntryState>> entry3 : this.backStackStates.entrySet()) {
                String key2 = entry3.getKey();
                ArrayDeque<NavBackStackEntryState> value2 = entry3.getValue();
                arrayList3.add(key2);
                Parcelable[] parcelableArr2 = new Parcelable[value2.size()];
                int i3 = 0;
                for (NavBackStackEntryState navBackStackEntryState : value2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    parcelableArr2[i3] = navBackStackEntryState;
                    i3 = i4;
                }
                bundle.putParcelableArray("android-support-nav:controller:backStackStates:" + key2, parcelableArr2);
            }
            bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
        }
        if (this.deepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.deepLinkHandled);
        }
        return bundle;
    }

    public void restoreState(Bundle navState) {
        if (navState == null) {
            return;
        }
        navState.setClassLoader(this.context.getClassLoader());
        this.navigatorStateToRestore = navState.getBundle("android-support-nav:controller:navigatorState");
        this.backStackToRestore = navState.getParcelableArray("android-support-nav:controller:backStack");
        this.backStackStates.clear();
        int[] intArray = navState.getIntArray("android-support-nav:controller:backStackDestIds");
        ArrayList<String> stringArrayList = navState.getStringArrayList("android-support-nav:controller:backStackIds");
        if (intArray != null && stringArrayList != null) {
            int length = intArray.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                this.backStackMap.put(Integer.valueOf(intArray[i]), stringArrayList.get(i2));
                i++;
                i2++;
            }
        }
        ArrayList<String> stringArrayList2 = navState.getStringArrayList("android-support-nav:controller:backStackStates");
        if (stringArrayList2 != null) {
            for (String id : stringArrayList2) {
                Parcelable[] parcelableArray = navState.getParcelableArray("android-support-nav:controller:backStackStates:" + id);
                if (parcelableArray != null) {
                    Map<String, ArrayDeque<NavBackStackEntryState>> map = this.backStackStates;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>(parcelableArray.length);
                    Iterator it = ArrayIteratorKt.iterator(parcelableArray);
                    while (it.hasNext()) {
                        Parcelable parcelable = (Parcelable) it.next();
                        Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        arrayDeque.add((NavBackStackEntryState) parcelable);
                    }
                    map.put(id, arrayDeque);
                }
            }
        }
        this.deepLinkHandled = navState.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public void setLifecycleOwner(LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (Intrinsics.areEqual(owner, this.lifecycleOwner)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this.lifecycleObserver);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.onBackPressedCallback
            boolean r1 = r3.enableOnBackPressedCallback
            if (r1 == 0) goto Le
            int r1 = r3.getDestinationCountOnBackStack()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    public void setViewModelStore(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.viewModel;
        NavControllerViewModel.Companion companion = NavControllerViewModel.INSTANCE;
        if (Intrinsics.areEqual(navControllerViewModel, companion.getInstance(viewModelStore))) {
            return;
        }
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.viewModel = companion.getInstance(viewModelStore);
    }

    public NavBackStackEntry getBackStackEntry(int destinationId) {
        NavBackStackEntry navBackStackEntryPrevious;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
            if (navBackStackEntryPrevious.getDestination().getId() == destinationId) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + destinationId + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return this.backQueue.lastOrNull();
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Object next;
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt.asSequence(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (!(((NavBackStackEntry) next).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) next;
    }
}
