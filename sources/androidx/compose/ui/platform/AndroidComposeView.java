package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusOwnerImplKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.NestedVectorStack;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.ViewLayer;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.TypeIntrinsics;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000Â\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002©\u0004\b\u0000\u0018\u0000 Û\u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004Û\u0004Ü\u0004B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001d\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J6\u0010*\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001e0%H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b,\u0010-J'\u00103\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00152\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u001b\u00107\u001a\u00020\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\b7\u00108J\u0013\u00109\u001a\u00020\u000e*\u000205H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u001eH\u0002¢\u0006\u0004\b;\u0010 J%\u0010A\u001a\u00020>2\u0006\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001d\u0010E\u001a\u00020>2\u0006\u0010B\u001a\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020\u001eH\u0002¢\u0006\u0004\bF\u0010 J\u0017\u0010H\u001a\u00020\u001e2\u0006\u0010G\u001a\u000205H\u0002¢\u0006\u0004\bH\u00108J\u0017\u0010I\u001a\u00020\u001e2\u0006\u0010G\u001a\u000205H\u0002¢\u0006\u0004\bI\u00108J\u0017\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u001d\u0010R\u001a\u00020O2\u0006\u0010N\u001a\u00020JH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u001f\u0010T\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020J2\u0006\u0010S\u001a\u00020JH\u0002¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bV\u0010MJ\u001d\u0010X\u001a\u00020O2\u0006\u0010N\u001a\u00020JH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010QJ1\u0010]\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020J2\u0006\u0010Y\u001a\u00020\u00152\u0006\u0010[\u001a\u00020Z2\b\b\u0002\u0010\\\u001a\u00020\u000eH\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020JH\u0002¢\u0006\u0004\b_\u0010MJ\u000f\u0010`\u001a\u00020\u001eH\u0002¢\u0006\u0004\b`\u0010 J\u0017\u0010`\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020JH\u0002¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\u001eH\u0002¢\u0006\u0004\bb\u0010 J\u000f\u0010c\u001a\u00020\u000eH\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\be\u0010MJ\u0017\u0010f\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bf\u0010MJ!\u0010i\u001a\u0004\u0018\u00010\u00172\u0006\u0010g\u001a\u00020\u00152\u0006\u0010h\u001a\u00020\u0017H\u0002¢\u0006\u0004\bi\u0010jJ4\u0010q\u001a\u00020n2\"\u0010p\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020l\u0012\n\u0012\b\u0012\u0004\u0012\u00020n0m\u0012\u0006\u0012\u0004\u0018\u00010o0kH\u0096@¢\u0006\u0004\bq\u0010rJ\u0017\u0010u\u001a\u00020\u001e2\u0006\u0010t\u001a\u00020sH\u0016¢\u0006\u0004\bu\u0010vJ\u0017\u0010y\u001a\u00020\u001e2\u0006\u0010x\u001a\u00020wH\u0016¢\u0006\u0004\by\u0010zJ1\u0010\u0081\u0001\u001a\u00020\u001e2\u0006\u0010{\u001a\u00020s2\u0006\u0010}\u001a\u00020|2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~H\u0016¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001c\u0010\u0085\u0001\u001a\u00020\u001e2\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0016¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J'\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J$\u0010\u008a\u0001\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010sH\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J-\u0010\u008d\u0001\u001a\u00020\u001e2\u0007\u0010\u008c\u0001\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010sH\u0014¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001b\u0010\u0090\u0001\u001a\u00020\u001e2\u0007\u0010\u008f\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001b\u0010\u0093\u0001\u001a\u00020\u000e2\u0007\u0010K\u001a\u00030\u0092\u0001H\u0016¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001b\u0010\u0095\u0001\u001a\u00020\u000e2\u0007\u0010K\u001a\u00030\u0092\u0001H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u0094\u0001J\u001b\u0010\u0097\u0001\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020ZH\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0019\u0010\u0099\u0001\u001a\u00020\u001e2\u0006\u0010G\u001a\u000205H\u0016¢\u0006\u0005\b\u0099\u0001\u00108J\u0019\u0010\u009a\u0001\u001a\u00020\u001e2\u0006\u0010G\u001a\u000205H\u0016¢\u0006\u0005\b\u009a\u0001\u00108J\u000f\u0010\u009b\u0001\u001a\u00020\u001e¢\u0006\u0005\b\u009b\u0001\u0010 J\u0011\u0010\u009c\u0001\u001a\u00020\u001eH\u0016¢\u0006\u0005\b\u009c\u0001\u0010 J\"\u0010\u009f\u0001\u001a\u00020\u001e2\u000e\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u009d\u0001H\u0016¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001d\u0010¢\u0001\u001a\u00020\u001e2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0006\b¢\u0001\u0010£\u0001J&\u0010¢\u0001\u001a\u00020\u001e2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010¤\u0001\u001a\u00020\u0015H\u0016¢\u0006\u0006\b¢\u0001\u0010¥\u0001J/\u0010¢\u0001\u001a\u00020\u001e2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010¦\u0001\u001a\u00020\u00152\u0007\u0010§\u0001\u001a\u00020\u0015H\u0016¢\u0006\u0006\b¢\u0001\u0010¨\u0001J)\u0010¢\u0001\u001a\u00020\u001e2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u00172\n\u0010ª\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016¢\u0006\u0006\b¢\u0001\u0010«\u0001J2\u0010¢\u0001\u001a\u00020\u001e2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010¤\u0001\u001a\u00020\u00152\n\u0010ª\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016¢\u0006\u0006\b¢\u0001\u0010¬\u0001J#\u0010°\u0001\u001a\u00020\u001e2\b\u0010®\u0001\u001a\u00030\u00ad\u00012\u0007\u0010¯\u0001\u001a\u000205¢\u0006\u0006\b°\u0001\u0010±\u0001J\u001a\u0010²\u0001\u001a\u00020\u001e2\b\u0010®\u0001\u001a\u00030\u00ad\u0001¢\u0006\u0006\b²\u0001\u0010³\u0001J$\u0010¶\u0001\u001a\u00020\u001e2\b\u0010®\u0001\u001a\u00030\u00ad\u00012\b\u0010µ\u0001\u001a\u00030´\u0001¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u001b\u0010¹\u0001\u001a\u00020\u001e2\u0007\u0010¸\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0006\b¹\u0001\u0010\u0091\u0001J(\u0010¹\u0001\u001a\u00020\u001e2\u0007\u0010¯\u0001\u001a\u0002052\b\u0010»\u0001\u001a\u00030º\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b¼\u0001\u0010½\u0001J$\u0010¿\u0001\u001a\u00020\u001e2\u0007\u0010¯\u0001\u001a\u0002052\u0007\u0010¾\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0006\b¿\u0001\u0010À\u0001J5\u0010Â\u0001\u001a\u00020\u001e2\u0007\u0010¯\u0001\u001a\u0002052\u0007\u0010¾\u0001\u001a\u00020\u000e2\u0007\u0010Á\u0001\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000eH\u0016¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J-\u0010Ä\u0001\u001a\u00020\u001e2\u0007\u0010¯\u0001\u001a\u0002052\u0007\u0010¾\u0001\u001a\u00020\u000e2\u0007\u0010Á\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u001a\u0010Æ\u0001\u001a\u00020\u001e2\u0007\u0010¯\u0001\u001a\u000205H\u0016¢\u0006\u0005\bÆ\u0001\u00108J$\u0010É\u0001\u001a\u00020\u001e2\u0007\u0010Ç\u0001\u001a\u00020\u00152\u0007\u0010È\u0001\u001a\u00020\u0015H\u0014¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J>\u0010Ï\u0001\u001a\u00020\u001e2\u0007\u0010Ë\u0001\u001a\u00020\u000e2\u0007\u0010Ì\u0001\u001a\u00020\u00152\u0007\u0010Í\u0001\u001a\u00020\u00152\u0007\u0010Î\u0001\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0015H\u0014¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u001c\u0010Ñ\u0001\u001a\u00020\u001e2\b\u0010µ\u0001\u001a\u00030´\u0001H\u0014¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001JN\u0010Ù\u0001\u001a\u00030Ø\u00012\u001d\u0010Õ\u0001\u001a\u0018\u0012\u0005\u0012\u00030Ó\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ô\u0001\u0012\u0004\u0012\u00020\u001e0k2\u000e\u0010Ö\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u009d\u00012\n\u0010×\u0001\u001a\u0005\u0018\u00010Ô\u0001H\u0016¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J\u001c\u0010Þ\u0001\u001a\u00020\u000e2\b\u0010Û\u0001\u001a\u00030Ø\u0001H\u0000¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u0011\u0010ß\u0001\u001a\u00020\u001eH\u0016¢\u0006\u0005\bß\u0001\u0010 J\u001a\u0010à\u0001\u001a\u00020\u001e2\u0007\u0010¯\u0001\u001a\u000205H\u0016¢\u0006\u0005\bà\u0001\u00108J \u0010â\u0001\u001a\u00020\u001e2\f\u0010®\u0001\u001a\u00070\u0017j\u0003`á\u0001H\u0016¢\u0006\u0006\bâ\u0001\u0010£\u0001J\u001c\u0010ä\u0001\u001a\u00020\u001e2\b\u0010\u009e\u0001\u001a\u00030ã\u0001H\u0016¢\u0006\u0006\bä\u0001\u0010å\u0001J!\u0010ê\u0001\u001a\u0004\u0018\u00010\f2\b\u0010ç\u0001\u001a\u00030æ\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bè\u0001\u0010é\u0001J\u001c\u0010ë\u0001\u001a\u00020\u001e2\b\u0010µ\u0001\u001a\u00030´\u0001H\u0014¢\u0006\u0006\bë\u0001\u0010Ò\u0001J%\u0010ï\u0001\u001a\u00020\u001e2\b\u0010Û\u0001\u001a\u00030Ø\u00012\u0007\u0010ì\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0006\bí\u0001\u0010î\u0001J&\u0010ò\u0001\u001a\u00020\u001e2\u0014\u0010ñ\u0001\u001a\u000f\u0012\u0005\u0012\u00030ð\u0001\u0012\u0004\u0012\u00020\u001e0%¢\u0006\u0006\bò\u0001\u0010ó\u0001J\u0013\u0010ô\u0001\u001a\u00020\u001eH\u0086@¢\u0006\u0006\bô\u0001\u0010õ\u0001J\u0013\u0010ö\u0001\u001a\u00020\u001eH\u0086@¢\u0006\u0006\bö\u0001\u0010õ\u0001J\u0011\u0010÷\u0001\u001a\u00020\u001eH\u0016¢\u0006\u0005\b÷\u0001\u0010 J\u0011\u0010ø\u0001\u001a\u00020\u001eH\u0014¢\u0006\u0005\bø\u0001\u0010 J\u0011\u0010ù\u0001\u001a\u00020\u001eH\u0014¢\u0006\u0005\bù\u0001\u0010 J%\u0010û\u0001\u001a\u00020\u001e2\b\u0010x\u001a\u0004\u0018\u00010w2\u0007\u0010ú\u0001\u001a\u00020\u0015H\u0016¢\u0006\u0006\bû\u0001\u0010ü\u0001J#\u0010\u0080\u0002\u001a\u00020\u001e2\u000f\u0010ÿ\u0001\u001a\n\u0012\u0005\u0012\u00030þ\u00010ý\u0001H\u0016¢\u0006\u0006\b\u0080\u0002\u0010\u0081\u0002J8\u0010\u0088\u0002\u001a\u00020\u001e2\b\u0010\u0083\u0002\u001a\u00030\u0082\u00022\b\u0010\u0085\u0002\u001a\u00030\u0084\u00022\u0010\u0010\u0087\u0002\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0086\u00020~H\u0017¢\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J%\u0010\u008d\u0002\u001a\u00020\u001e2\u0011\u0010\u008c\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008b\u00020\u008a\u0002H\u0017¢\u0006\u0006\b\u008d\u0002\u0010\u008e\u0002J\u0019\u0010\u008f\u0002\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020JH\u0016¢\u0006\u0005\b\u008f\u0002\u0010MJ\u0019\u0010\u0090\u0002\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020JH\u0016¢\u0006\u0005\b\u0090\u0002\u0010MJ\u0019\u0010\u0091\u0002\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0005\b\u0091\u0002\u0010\u0010J\u0019\u0010\u0092\u0002\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0005\b\u0092\u0002\u0010\u0010J \u0010\u0097\u0002\u001a\u00030\u0093\u00022\b\u0010\u0094\u0002\u001a\u00030\u0093\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0095\u0002\u0010\u0096\u0002J\u001f\u0010\u0097\u0002\u001a\u00020\u001e2\b\u0010\u0099\u0002\u001a\u00030\u0098\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u009a\u0002\u0010\u009b\u0002J \u0010\u009e\u0002\u001a\u00030\u0093\u00022\b\u0010\u009c\u0002\u001a\u00030\u0093\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u009d\u0002\u0010\u0096\u0002J\u0011\u0010\u009f\u0002\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u009f\u0002\u0010dJ\u001f\u0010£\u0002\u001a\u0005\u0018\u00010¢\u00022\b\u0010¡\u0002\u001a\u00030 \u0002H\u0016¢\u0006\u0006\b£\u0002\u0010¤\u0002J \u0010§\u0002\u001a\u00030\u0093\u00022\b\u0010¥\u0002\u001a\u00030\u0093\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b¦\u0002\u0010\u0096\u0002J \u0010©\u0002\u001a\u00030\u0093\u00022\b\u0010\u0094\u0002\u001a\u00030\u0093\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b¨\u0002\u0010\u0096\u0002J\u001c\u0010¬\u0002\u001a\u00020\u001e2\b\u0010«\u0002\u001a\u00030ª\u0002H\u0014¢\u0006\u0006\b¬\u0002\u0010\u00ad\u0002J\u001b\u0010¯\u0002\u001a\u00020\u001e2\u0007\u0010®\u0002\u001a\u00020\u0015H\u0016¢\u0006\u0006\b¯\u0002\u0010°\u0002J\u0019\u0010±\u0002\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0005\b±\u0002\u0010MJ\u0019\u0010²\u0002\u001a\u0004\u0018\u00010\u00172\u0006\u0010g\u001a\u00020\u0015¢\u0006\u0005\b²\u0002\u0010\u0019J\u0011\u0010³\u0002\u001a\u00020\u000eH\u0016¢\u0006\u0005\b³\u0002\u0010dR \u0010´\u0002\u001a\u00030\u0093\u00028\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b´\u0002\u0010µ\u0002R\u0019\u0010¶\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010·\u0002R \u0010¹\u0002\u001a\u00030¸\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¹\u0002\u0010º\u0002\u001a\u0006\b»\u0002\u0010¼\u0002R5\u0010Å\u0002\u001a\u00030½\u00022\b\u0010¾\u0002\u001a\u00030½\u00028V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\b¿\u0002\u0010À\u0002\u001a\u0006\bÁ\u0002\u0010Â\u0002\"\u0006\bÃ\u0002\u0010Ä\u0002R\u0018\u0010Ç\u0002\u001a\u00030Æ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0002\u0010È\u0002R\u0018\u0010Ê\u0002\u001a\u00030É\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0002\u0010Ë\u0002R \u0010Í\u0002\u001a\u00030Ì\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÍ\u0002\u0010Î\u0002\u001a\u0006\bÏ\u0002\u0010Ð\u0002R\u0018\u0010Ò\u0002\u001a\u00030Ñ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÒ\u0002\u0010Ó\u0002R0\u0010\t\u001a\u00020\b2\u0007\u0010Ô\u0002\u001a\u00020\b8\u0016@VX\u0096\u000e¢\u0006\u0017\n\u0005\b\t\u0010Õ\u0002\u001a\u0006\bÖ\u0002\u0010×\u0002\"\u0006\bØ\u0002\u0010Ù\u0002R \u0010Û\u0002\u001a\u00030Ú\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÛ\u0002\u0010Ü\u0002\u001a\u0006\bÝ\u0002\u0010Þ\u0002R\u0018\u0010à\u0002\u001a\u00030ß\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0002\u0010á\u0002R\u0018\u0010ã\u0002\u001a\u00030â\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0002\u0010ä\u0002R\u0018\u0010å\u0002\u001a\u00030â\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0002\u0010ä\u0002R\u0018\u0010ç\u0002\u001a\u00030æ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bç\u0002\u0010è\u0002R\u001f\u0010é\u0002\u001a\u0002058\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bé\u0002\u0010ê\u0002\u001a\u0006\bë\u0002\u0010ì\u0002R \u0010î\u0002\u001a\u00030í\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bî\u0002\u0010ï\u0002\u001a\u0006\bð\u0002\u0010ñ\u0002R \u0010ó\u0002\u001a\u00030ò\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bó\u0002\u0010ô\u0002\u001a\u0006\bõ\u0002\u0010ö\u0002R\u0018\u0010ø\u0002\u001a\u00030÷\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bø\u0002\u0010ù\u0002R*\u0010û\u0002\u001a\u00030ú\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bû\u0002\u0010ü\u0002\u001a\u0006\bý\u0002\u0010þ\u0002\"\u0006\bÿ\u0002\u0010\u0080\u0003R \u0010\u0082\u0003\u001a\u00030\u0081\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0082\u0003\u0010\u0083\u0003\u001a\u0006\b\u0084\u0003\u0010\u0085\u0003R \u0010\u0087\u0003\u001a\u00030\u0086\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0087\u0003\u0010\u0088\u0003\u001a\u0006\b\u0089\u0003\u0010\u008a\u0003R \u0010\u008c\u0003\u001a\u00030\u008b\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008c\u0003\u0010\u008d\u0003\u001a\u0006\b\u008e\u0003\u0010\u008f\u0003R\u001f\u0010\u0091\u0003\u001a\n\u0012\u0005\u0012\u00030Ø\u00010\u0090\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0003\u0010\u0092\u0003R#\u0010\u0093\u0003\u001a\f\u0012\u0005\u0012\u00030Ø\u0001\u0018\u00010\u0090\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0003\u0010\u0092\u0003R\u0019\u0010\u0094\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0003\u0010·\u0002R\u0019\u0010\u0095\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0003\u0010·\u0002R\u0018\u0010\u0097\u0003\u001a\u00030\u0096\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0003\u0010\u0098\u0003R\u0018\u0010\u009a\u0003\u001a\u00030\u0099\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0003\u0010\u009b\u0003R6\u0010\u009c\u0003\u001a\u000f\u0012\u0005\u0012\u00030ª\u0002\u0012\u0004\u0012\u00020\u001e0%8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009c\u0003\u0010\u009d\u0003\u001a\u0006\b\u009e\u0003\u0010\u009f\u0003\"\u0006\b \u0003\u0010ó\u0001R\u001a\u0010¢\u0003\u001a\u0005\u0018\u00010¡\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0003\u0010£\u0003R\u0019\u0010¤\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0003\u0010·\u0002R \u0010¦\u0003\u001a\u00030¥\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¦\u0003\u0010§\u0003\u001a\u0006\b¨\u0003\u0010©\u0003R \u0010«\u0003\u001a\u00030ª\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b«\u0003\u0010¬\u0003\u001a\u0006\b\u00ad\u0003\u0010®\u0003R/\u0010¯\u0003\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u001e\n\u0006\b¯\u0003\u0010·\u0002\u0012\u0005\b²\u0003\u0010 \u001a\u0005\b°\u0003\u0010d\"\u0006\b±\u0003\u0010\u0091\u0001R\u001c\u0010´\u0003\u001a\u0005\u0018\u00010³\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0003\u0010µ\u0003R\u001c\u0010·\u0003\u001a\u0005\u0018\u00010¶\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0003\u0010¸\u0003R\"\u0010¹\u0003\u001a\u0005\u0018\u00010º\u00018\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b¹\u0003\u0010º\u0003R\u0019\u0010»\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0003\u0010·\u0002R\u0018\u0010½\u0003\u001a\u00030¼\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0003\u0010¾\u0003R \u0010À\u0003\u001a\u00030¿\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÀ\u0003\u0010Á\u0003\u001a\u0006\bÂ\u0003\u0010Ã\u0003R \u0010Å\u0003\u001a\u00030Ä\u00038\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÅ\u0003\u0010µ\u0002R\u0018\u0010Æ\u0003\u001a\u00030\u0084\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0003\u0010Ç\u0003R\u001e\u0010È\u0003\u001a\u00030\u0098\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÈ\u0003\u0010É\u0003R\u001e\u0010Ê\u0003\u001a\u00030\u0098\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÊ\u0003\u0010É\u0003R\u001e\u0010Ë\u0003\u001a\u00030\u0098\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bË\u0003\u0010É\u0003R0\u0010Ì\u0003\u001a\u00020Z8\u0000@\u0000X\u0081\u000e¢\u0006\u001f\n\u0006\bÌ\u0003\u0010µ\u0002\u0012\u0005\bÐ\u0003\u0010 \u001a\u0006\bÍ\u0003\u0010Î\u0003\"\u0006\bÏ\u0003\u0010\u0098\u0001R\u0019\u0010Ñ\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0003\u0010·\u0002R \u0010Ò\u0003\u001a\u00030\u0093\u00028\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÒ\u0003\u0010µ\u0002R\u0019\u0010Ó\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0003\u0010·\u0002R9\u0010Ù\u0003\u001a\u0005\u0018\u00010ð\u00012\n\u0010¾\u0002\u001a\u0005\u0018\u00010ð\u00018B@BX\u0082\u008e\u0002¢\u0006\u0018\n\u0006\bÔ\u0003\u0010À\u0002\u001a\u0006\bÕ\u0003\u0010Ö\u0003\"\u0006\b×\u0003\u0010Ø\u0003R#\u0010Ý\u0003\u001a\u0005\u0018\u00010ð\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bÚ\u0003\u0010Û\u0003\u001a\u0006\bÜ\u0003\u0010Ö\u0003R(\u0010Þ\u0003\u001a\u0011\u0012\u0005\u0012\u00030ð\u0001\u0012\u0004\u0012\u00020\u001e\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0003\u0010\u009d\u0003R\u0018\u0010à\u0003\u001a\u00030ß\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0003\u0010á\u0003R\u0018\u0010ã\u0003\u001a\u00030â\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0003\u0010ä\u0003R\u0018\u0010æ\u0003\u001a\u00030å\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bæ\u0003\u0010ç\u0003R\u0018\u0010é\u0003\u001a\u00030è\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bé\u0003\u0010ê\u0003R \u0010ì\u0003\u001a\u00030ë\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bì\u0003\u0010í\u0003\u001a\u0006\bî\u0003\u0010ï\u0003R%\u0010ò\u0003\u001a\n\u0012\u0005\u0012\u00030ñ\u00030ð\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bò\u0003\u0010ó\u0003R \u0010õ\u0003\u001a\u00030ô\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bõ\u0003\u0010ö\u0003\u001a\u0006\b÷\u0003\u0010ø\u0003R'\u0010ú\u0003\u001a\u00030ù\u00038\u0016X\u0097\u0004¢\u0006\u0017\n\u0006\bú\u0003\u0010û\u0003\u0012\u0005\bþ\u0003\u0010 \u001a\u0006\bü\u0003\u0010ý\u0003R5\u0010\u0085\u0004\u001a\u00030ÿ\u00032\b\u0010¾\u0002\u001a\u00030ÿ\u00038V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\b\u0080\u0004\u0010À\u0002\u001a\u0006\b\u0081\u0004\u0010\u0082\u0004\"\u0006\b\u0083\u0004\u0010\u0084\u0004R\u0019\u0010\u0086\u0004\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0004\u0010\u0087\u0004R5\u0010®\u0002\u001a\u00030\u0088\u00042\b\u0010¾\u0002\u001a\u00030\u0088\u00048V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\b\u0089\u0004\u0010À\u0002\u001a\u0006\b\u008a\u0004\u0010\u008b\u0004\"\u0006\b\u008c\u0004\u0010\u008d\u0004R \u0010\u008f\u0004\u001a\u00030\u008e\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008f\u0004\u0010\u0090\u0004\u001a\u0006\b\u0091\u0004\u0010\u0092\u0004R\u0018\u0010\u0094\u0004\u001a\u00030\u0093\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0004\u0010\u0095\u0004R \u0010\u0097\u0004\u001a\u00030\u0096\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0097\u0004\u0010\u0098\u0004\u001a\u0006\b\u0099\u0004\u0010\u009a\u0004R \u0010\u009c\u0004\u001a\u00030\u009b\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u009c\u0004\u0010\u009d\u0004\u001a\u0006\b\u009e\u0004\u0010\u009f\u0004R\u001b\u0010 \u0004\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0004\u0010¡\u0004R\u0019\u0010¢\u0004\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0004\u0010µ\u0002R\u001f\u0010¤\u0004\u001a\n\u0012\u0005\u0012\u00030Ø\u00010£\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0004\u0010¥\u0004R'\u0010§\u0004\u001a\u0012\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u009d\u00010¦\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0004\u0010¨\u0004R\u0018\u0010ª\u0004\u001a\u00030©\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0004\u0010«\u0004R\u0018\u0010\u00ad\u0004\u001a\u00030¬\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0004\u0010®\u0004R\u0019\u0010¯\u0004\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0004\u0010·\u0002R\u001e\u0010°\u0004\u001a\t\u0012\u0004\u0012\u00020\u001e0\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0004\u0010±\u0004R\u0018\u0010³\u0004\u001a\u00030²\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0004\u0010´\u0004R\u0019\u0010µ\u0004\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0004\u0010·\u0002R\u001a\u0010·\u0004\u001a\u0005\u0018\u00010¶\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0004\u0010¸\u0004R \u0010º\u0004\u001a\u00030¹\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bº\u0004\u0010»\u0004\u001a\u0006\b¼\u0004\u0010½\u0004R\u001c\u0010À\u0004\u001a\u00020\u0015*\u00030ª\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b¾\u0004\u0010¿\u0004R\u0017\u0010®\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\b\u001a\u0006\bÁ\u0004\u0010Â\u0004R\u0018\u0010Æ\u0004\u001a\u00030Ã\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÄ\u0004\u0010Å\u0004R\u001a\u0010\u0080\u0002\u001a\u0005\u0018\u00010Ç\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÈ\u0004\u0010É\u0004R\u0018\u0010Ì\u0004\u001a\u00030³\u00038@X\u0080\u0004¢\u0006\b\u001a\u0006\bÊ\u0004\u0010Ë\u0004R\u0017\u0010Î\u0004\u001a\u00020Z8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÍ\u0004\u0010Î\u0003R\u0016\u0010Ð\u0004\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0004\u0010dR\u0018\u0010Ô\u0004\u001a\u00030Ñ\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÒ\u0004\u0010Ó\u0004R\u0018\u0010Ø\u0004\u001a\u00030Õ\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÖ\u0004\u0010×\u0004R\u0016\u0010Ú\u0004\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÙ\u0004\u0010d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Ý\u0004"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "context", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/compose/ui/focus/FocusDirection;", "focusDirection", "", "onMoveFocusInChildren-3ESFkO8", "(I)Z", "onMoveFocusInChildren", "Landroidx/compose/ui/geometry/Rect;", "onFetchFocusRect", "()Landroidx/compose/ui/geometry/Rect;", "", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "Landroid/view/View;", "findNextNonChildView", "(I)Landroid/view/View;", "previouslyFocusedRect", "onRequestFocusForOwner-7o62pno", "(Landroidx/compose/ui/focus/FocusDirection;Landroidx/compose/ui/geometry/Rect;)Z", "onRequestFocusForOwner", "", "onClearFocusForOwner", "()V", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "transferData", "Landroidx/compose/ui/geometry/Size;", "decorationSize", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawDragDecoration", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "startDrag", "viewGroup", "clearChildInvalidObservations", "(Landroid/view/ViewGroup;)V", "virtualViewId", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "extraDataKey", "addExtraDataToAccessibilityNodeInfoHelper", "(ILandroid/view/accessibility/AccessibilityNodeInfo;Ljava/lang/String;)V", "Landroidx/compose/ui/node/LayoutNode;", "nodeToRemeasure", "scheduleMeasureAndLayout", "(Landroidx/compose/ui/node/LayoutNode;)V", "childSizeCanAffectParentSize", "(Landroidx/compose/ui/node/LayoutNode;)Z", "dispatchPendingInteropLayoutCallbacks", "a", "b", "Lkotlin/ULong;", "pack-ZIaKswc", "(II)J", "pack", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "convertMeasureSpec", "updatePositionCacheAndDispatch", "node", "invalidateLayoutNodeMeasurement", "invalidateLayers", "Landroid/view/MotionEvent;", "event", "handleRotaryEvent", "(Landroid/view/MotionEvent;)Z", "motionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleMotionEvent", "lastEvent", "hasChangedDevices", "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z", "isDevicePressEvent", "sendMotionEvent-8iAsVTc", "sendMotionEvent", "action", "", "eventTime", "forceHover", "sendSimulatedEvent", "(Landroid/view/MotionEvent;IJZ)V", "isInBounds", "recalculateWindowPosition", "(Landroid/view/MotionEvent;)V", "recalculateWindowViewTransforms", "autofillSupported", "()Z", "isBadMotionEvent", "isPositionChanged", "accessibilityId", "currentView", "findViewByAccessibilityIdRootedAtCurrentView", "(ILandroid/view/View;)Landroid/view/View;", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "", "session", "textInputSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/Rect;", "rect", "getFocusedRect", "(Landroid/graphics/Rect;)V", "Landroid/view/ViewStructure;", "structure", "dispatchProvideStructure", "(Landroid/view/ViewStructure;)V", "localVisibleRect", "Landroid/graphics/Point;", "windowOffset", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "targets", "onScrollCaptureSearch", "(Landroid/graphics/Rect;Landroid/graphics/Point;Ljava/util/function/Consumer;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "(Landroidx/lifecycle/LifecycleOwner;)V", "focused", "focusSearch", "(Landroid/view/View;I)Landroid/view/View;", "requestFocus", "(ILandroid/graphics/Rect;)Z", "gainFocus", "onFocusChanged", "(ZILandroid/graphics/Rect;)V", "hasWindowFocus", "onWindowFocusChanged", "(Z)V", "Landroid/view/KeyEvent;", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEventPreIme", "intervalMillis", "setAccessibilityEventBatchIntervalMillis", "(J)V", "onAttach", "onDetach", "requestClearInvalidObservations", "onEndApplyChanges", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerOnEndApplyChangesListener", "(Lkotlin/jvm/functions/Function0;)V", "child", "addView", "(Landroid/view/View;)V", "index", "(Landroid/view/View;I)V", "width", "height", "(Landroid/view/View;II)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "view", "layoutNode", "addAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;Landroidx/compose/ui/node/LayoutNode;)V", "removeAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "Landroid/graphics/Canvas;", "canvas", "drawAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;Landroid/graphics/Canvas;)V", "sendPointerUpdate", "measureAndLayout", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "affectsLookahead", "forceMeasureTheSubtree", "(Landroidx/compose/ui/node/LayoutNode;Z)V", "forceRequest", "onRequestMeasure", "(Landroidx/compose/ui/node/LayoutNode;ZZZ)V", "onRequestRelayout", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "requestOnPositionedCallback", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", "r", "onLayout", "(ZIIII)V", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawBlock", "invalidateParentLayer", "explicitLayer", "Landroidx/compose/ui/node/OwnedLayer;", "createLayer", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)Landroidx/compose/ui/node/OwnedLayer;", "layer", "recycle$ui_release", "(Landroidx/compose/ui/node/OwnedLayer;)Z", "recycle", "onSemanticsChange", "onLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "onInteropViewLayoutChange", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "registerOnLayoutCompletedListener", "(Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;)V", "Landroidx/compose/ui/input/key/KeyEvent;", "keyEvent", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusDirection", "dispatchDraw", "isDirty", "notifyLayerIsDirty$ui_release", "(Landroidx/compose/ui/node/OwnedLayer;Z)V", "notifyLayerIsDirty", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "callback", "setOnViewTreeOwnersAvailable", "(Lkotlin/jvm/functions/Function1;)V", "boundsUpdatesContentCaptureEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesAccessibilityEventLoop", "invalidateDescendants", "onAttachedToWindow", "onDetachedFromWindow", "flags", "onProvideAutofillVirtualStructure", "(Landroid/view/ViewStructure;I)V", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "values", "autofill", "(Landroid/util/SparseArray;)V", "", "virtualIds", "", "supportedFormats", "Landroid/view/translation/ViewTranslationRequest;", "requestsCollector", "onCreateVirtualViewTranslationRequests", "([J[ILjava/util/function/Consumer;)V", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "response", "onVirtualViewTranslationResponses", "(Landroid/util/LongSparseArray;)V", "dispatchGenericMotionEvent", "dispatchTouchEvent", "canScrollHorizontally", "canScrollVertically", "Landroidx/compose/ui/geometry/Offset;", "localPosition", "localToScreen-MK-Hz9U", "(J)J", "localToScreen", "Landroidx/compose/ui/graphics/Matrix;", "localTransform", "localToScreen-58bKbWc", "([F)V", "positionOnScreen", "screenToLocal-MK-Hz9U", "screenToLocal", "onCheckIsTextEditor", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "calculateLocalPosition", "calculatePositionInWindow-MK-Hz9U", "calculatePositionInWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "layoutDirection", "onRtlPropertiesChanged", "(I)V", "dispatchHoverEvent", "findViewByAccessibilityIdTraversal", "shouldDelayChildPressedState", "lastDownPointerPosition", "J", "superclassInitComplete", "Z", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/unit/Density;", "<set-?>", "density$delegate", "Landroidx/compose/runtime/MutableState;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "Landroidx/compose/ui/focus/FocusOwner;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "dragAndDropModifierOnDragListener", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "Landroidx/compose/ui/platform/WindowInfoImpl;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "Landroidx/compose/ui/Modifier;", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "rotaryInputModifier", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/RootForTest;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "Landroidx/compose/ui/autofill/AutofillTree;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "", "dirtyLayers", "Ljava/util/List;", "postponedDirtyLayers", "isDrawingContent", "isPendingInteropViewLayoutChangeDispatch", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "configurationChangeObserver", "Lkotlin/jvm/functions/Function1;", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "observationClearRequested", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "showLayoutBounds", "getShowLayoutBounds", "setShowLayoutBounds", "getShowLayoutBounds$annotations", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "wasMeasuredWithMultipleConstraints", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "Landroidx/compose/ui/unit/IntOffset;", "globalPosition", "tmpPositionArray", "[I", "tmpMatrix", "[F", "viewToWindowMatrix", "windowToViewMatrix", "lastMatrixRecalculationAnimationTime", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "forceUseMatrixCache", "windowPosition", "isRenderNodeCompatible", "_viewTreeOwners$delegate", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "getViewTreeOwners", "viewTreeOwners", "onViewTreeOwnersAvailable", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/TextInputService;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "textInputSessionMutex", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver$delegate", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver", "currentFontWeightAdjustment", "I", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection$delegate", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "Landroidx/compose/ui/input/InputModeManagerImpl;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "Landroidx/compose/ui/platform/TextToolbar;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "Landroidx/compose/ui/platform/WeakCache;", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/runtime/collection/MutableVector;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "resendMotionEventRunnable", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "Ljava/lang/Runnable;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "hoverExitReceived", "resendMotionEventOnLayout", "Lkotlin/jvm/functions/Function0;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "keyboardModifiersRequireUpdate", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "fontWeightAdjustmentCompat", "getView", "()Landroid/view/View;", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowInfo", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "androidViewsHandler", "getMeasureIteration", "measureIteration", "getHasPendingMeasureOrLayout", "hasPendingMeasureOrLayout", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementScope", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "inputModeManager", "getScrollCaptureInProgress$ui_release", "scrollCaptureInProgress", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    private static Method getBooleanMethod;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final InputModeManagerImpl _inputModeManager;

    /* renamed from: _viewTreeOwners$delegate, reason: from kotlin metadata */
    private final MutableState _viewTreeOwners;
    private final WindowInfoImpl _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;

    /* renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;
    private final List<OwnedLayer> dirtyLayers;
    private final DragAndDropManager dragAndDropManager;
    private final DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;

    /* renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    private final MutableState fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;

    /* renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final EmptySemanticsModifier rootSemanticsNode;
    private final Modifier rotaryInputModifier;
    private final ScrollCapture scrollCapture;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete;
    private final TextInputService textInputService;
    private final AtomicReference textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;

    /* renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    private final State viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.platform.AndroidComposeView", f = "AndroidComposeView.android.kt", l = {592}, m = "textInputSession")
    /* renamed from: androidx.compose.ui.platform.AndroidComposeView$textInputSession$1, reason: invalid class name and case insensitive filesystem */
    static final class C04571 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04571(Continuation<? super C04571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidComposeView.this.textInputSession(null, this);
        }
    }

    @Deprecated
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public View getView() {
        return this;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onAttach(LayoutNode node) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r14v13, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        Offset.Companion companion = Offset.INSTANCE;
        this.lastDownPointerPosition = companion.m853getUnspecifiedF1C5BW0();
        this.superclassInitComplete = true;
        byte b = 0;
        byte b2 = 0;
        this.sharedDrawScope = new LayoutNodeDrawScope(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.density = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        EmptySemanticsModifier emptySemanticsModifier = new EmptySemanticsModifier();
        this.rootSemanticsNode = emptySemanticsModifier;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(emptySemanticsModifier);
        this.semanticsModifier = emptySemanticsElement;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$6
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((AndroidComposeView) this.receiver).getLayoutDirection();
            }
        });
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.dragAndDropModifierOnDragListener = dragAndDropModifierOnDragListener;
        this.coroutineContext = coroutineContext;
        this.dragAndDropManager = dragAndDropModifierOnDragListener;
        this._windowInfo = new WindowInfoImpl();
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion2, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1591invokeZmokQxo(keyEvent.getNativeKeyEvent());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1591invokeZmokQxo(android.view.KeyEvent keyEvent) {
                final FocusDirection focusDirectionM1586getFocusDirectionP8AzH3I = this.this$0.m1586getFocusDirectionP8AzH3I(keyEvent);
                if (focusDirectionM1586getFocusDirectionP8AzH3I != null && KeyEventType.m1289equalsimpl0(KeyEvent_androidKt.m1294getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m1290getKeyDownCS__XNY())) {
                    Rect rectOnFetchFocusRect = this.this$0.onFetchFocusRect();
                    Boolean boolMo798focusSearchULY8qGw = this.this$0.getFocusOwner().mo798focusSearchULY8qGw(focusDirectionM1586getFocusDirectionP8AzH3I.getValue(), rectOnFetchFocusRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(FocusTargetNode focusTargetNode) {
                            Boolean boolM811requestFocusMxy_nc0 = FocusTransactionsKt.m811requestFocusMxy_nc0(focusTargetNode, focusDirectionM1586getFocusDirectionP8AzH3I.getValue());
                            return Boolean.valueOf(boolM811requestFocusMxy_nc0 != null ? boolM811requestFocusMxy_nc0.booleanValue() : true);
                        }
                    });
                    if (boolMo798focusSearchULY8qGw != null ? boolMo798focusSearchULY8qGw.booleanValue() : true) {
                        return Boolean.TRUE;
                    }
                    if (!FocusOwnerImplKt.m802is1dFocusSearch3ESFkO8(focusDirectionM1586getFocusDirectionP8AzH3I.getValue())) {
                        return Boolean.FALSE;
                    }
                    Integer numM792toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m792toAndroidFocusDirection3ESFkO8(focusDirectionM1586getFocusDirectionP8AzH3I.getValue());
                    if (numM792toAndroidFocusDirection3ESFkO8 == null) {
                        throw new IllegalStateException("Invalid focus direction");
                    }
                    int iIntValue = numM792toAndroidFocusDirection3ESFkO8.intValue();
                    android.graphics.Rect androidRect = rectOnFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(rectOnFetchFocusRect) : null;
                    if (androidRect != null) {
                        View viewFindNextNonChildView = this.this$0.findNextNonChildView(iIntValue);
                        if (Intrinsics.areEqual(viewFindNextNonChildView, this.this$0)) {
                            viewFindNextNonChildView = null;
                        }
                        if (viewFindNextNonChildView != null && FocusInteropUtils_androidKt.requestInteropFocus(viewFindNextNonChildView, Integer.valueOf(iIntValue), androidRect)) {
                            return Boolean.TRUE;
                        }
                        if (!this.this$0.getFocusOwner().mo795clearFocusI7lrPNg(false, true, false, focusDirectionM1586getFocusDirectionP8AzH3I.getValue())) {
                            return Boolean.TRUE;
                        }
                        Boolean boolMo798focusSearchULY8qGw2 = this.this$0.getFocusOwner().mo798focusSearchULY8qGw(focusDirectionM1586getFocusDirectionP8AzH3I.getValue(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                                Boolean boolM811requestFocusMxy_nc0 = FocusTransactionsKt.m811requestFocusMxy_nc0(focusTargetNode, focusDirectionM1586getFocusDirectionP8AzH3I.getValue());
                                return Boolean.valueOf(boolM811requestFocusMxy_nc0 != null ? boolM811requestFocusMxy_nc0.booleanValue() : true);
                            }
                        });
                        return Boolean.valueOf(boolMo798focusSearchULY8qGw2 != null ? boolMo798focusSearchULY8qGw2.booleanValue() : true);
                    }
                    throw new IllegalStateException("Invalid rect");
                }
                return Boolean.FALSE;
            }
        });
        this.keyInputModifier = modifierOnKeyEvent;
        Modifier modifierOnRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(companion2, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RotaryScrollEvent rotaryScrollEvent) {
                return Boolean.FALSE;
            }
        });
        this.rotaryInputModifier = modifierOnRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(companion2.then(emptySemanticsElement).then(modifierOnRotaryScrollEvent).then(modifierOnKeyEvent).then(getFocusOwner().getModifier()).then(dragAndDropModifierOnDragListener.getModifier()));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot(), emptySemanticsModifier);
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration configuration) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.viewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(context));
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        float[] fArrM1031constructorimpl$default = Matrix.m1031constructorimpl$default(null, 1, null);
        this.tmpMatrix = fArrM1031constructorimpl$default;
        this.viewToWindowMatrix = Matrix.m1031constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m1031constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = companion.m852getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewTreeOwners = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                return this.this$0.get_viewTreeOwners();
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.updatePositionCacheAndDispatch();
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.updatePositionCacheAndDispatch();
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z) {
                AndroidComposeView.touchModeChangeListener$lambda$6(this.f$0, z);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m753constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(layoutDirection == null ? LayoutDirection.Ltr : layoutDirection, null, 2, null);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m1260getTouchaOaMEAU() : InputMode.INSTANCE.m1259getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m1587invokeiuPiT84(inputMode.getValue());
            }

            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m1587invokeiuPiT84(int i) {
                boolean zRequestFocusFromTouch;
                InputMode.Companion companion3 = InputMode.INSTANCE;
                if (InputMode.m1255equalsimpl0(i, companion3.m1260getTouchaOaMEAU())) {
                    zRequestFocusFromTouch = this.this$0.isInTouchMode();
                } else {
                    zRequestFocusFromTouch = InputMode.m1255equalsimpl0(i, companion3.m1259getKeyboardaOaMEAU()) ? this.this$0.isInTouchMode() ? this.this$0.requestFocusFromTouch() : true : false;
                }
                return Boolean.valueOf(zRequestFocusFromTouch);
            }
        }, b2 == true ? 1 : 0);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.removeCallbacks(this);
                MotionEvent motionEvent = this.this$0.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i = 2;
                    }
                    AndroidComposeView androidComposeView = this.this$0;
                    androidComposeView.sendSimulatedEvent(motionEvent, i, androidComposeView.relayoutTime, false);
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.sendHoverExitEvent$lambda$8(this.f$0);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
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
                MotionEvent motionEvent = this.this$0.previousMotionEvent;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        this.this$0.relayoutTime = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView = this.this$0;
                        androidComposeView.post(androidComposeView.resendMotionEventRunnable);
                    }
                }
            }
        };
        int i = Build.VERSION.SDK_INT;
        this.matrixToWindow = i < 29 ? new CalculateMatrixToWindowApi21(fArrM1031constructorimpl$default, b == true ? 1 : 0) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        if (i >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(dragAndDropModifierOnDragListener);
        getRoot().attach$ui_release(this);
        if (i >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.scrollCapture = i >= 31 ? new ScrollCapture() : null;
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            private PointerIcon currentIcon = PointerIcon.INSTANCE.getDefault();

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setIcon(PointerIcon value) {
                if (value == null) {
                    value = PointerIcon.INSTANCE.getDefault();
                }
                this.currentIcon = value;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this.this$0, value);
            }
        };
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    private void setDensity(Density density) {
        this.density.setValue(density);
    }

    @Override // androidx.compose.ui.node.Owner
    public Density getDensity() {
        return (Density) this.density.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
        DelegatableNode head = getRoot().getNodes().getHead();
        if (head instanceof SuspendingPointerInputModifierNode) {
            ((SuspendingPointerInputModifierNode) head).resetPointerInputHandler();
        }
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(16);
        if (!head.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        Modifier.Node child = head.getNode().getChild();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(head);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (layoutNodeRequireLayoutNode != null) {
            if (child == null) {
                child = layoutNodeRequireLayoutNode.getNodes().getHead();
            }
            if ((child.getAggregateChildKindSet() & iM1552constructorimpl) != 0) {
                while (child != null) {
                    if ((child.getKindSet() & iM1552constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = child;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            if (!(delegatingNodePop instanceof PointerInputModifierNode)) {
                                if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                    int i = 0;
                                    delegatingNodePop = delegatingNodePop;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet() & iM1552constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNodePop != 0) {
                                                    mutableVector.add(delegatingNodePop);
                                                    delegatingNodePop = 0;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild();
                                        delegatingNodePop = delegatingNodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                            } else {
                                PointerInputModifierNode pointerInputModifierNode = (PointerInputModifierNode) delegatingNodePop;
                                if (pointerInputModifierNode instanceof SuspendingPointerInputModifierNode) {
                                    ((SuspendingPointerInputModifierNode) pointerInputModifierNode).resetPointerInputHandler();
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    child = child.getChild();
                }
            }
            nestedVectorStack.push(layoutNodeRequireLayoutNode.get_children$ui_release());
            layoutNodeRequireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
            child = null;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public DragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onMoveFocusInChildren-3ESFkO8, reason: not valid java name */
    public final boolean m1581onMoveFocusInChildren3ESFkO8(int focusDirection) {
        View viewFindNextFocusFromRect;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m780equalsimpl0(focusDirection, companion.m785getEnterdhqQ8s()) || FocusDirection.m780equalsimpl0(focusDirection, companion.m786getExitdhqQ8s())) {
            return false;
        }
        Integer numM792toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m792toAndroidFocusDirection3ESFkO8(focusDirection);
        if (numM792toAndroidFocusDirection3ESFkO8 == null) {
            throw new IllegalStateException("Invalid focus direction");
        }
        int iIntValue = numM792toAndroidFocusDirection3ESFkO8.intValue();
        Rect rectOnFetchFocusRect = onFetchFocusRect();
        android.graphics.Rect androidRect = rectOnFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(rectOnFetchFocusRect) : null;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (androidRect == null) {
            viewFindNextFocusFromRect = focusFinder.findNextFocus(this, findFocus(), iIntValue);
        } else {
            viewFindNextFocusFromRect = focusFinder.findNextFocusFromRect(this, androidRect, iIntValue);
        }
        if (viewFindNextFocusFromRect != null) {
            return FocusInteropUtils_androidKt.requestInteropFocus(viewFindNextFocusFromRect, Integer.valueOf(iIntValue), androidRect);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect onFetchFocusRect() {
        if (isFocused()) {
            return getFocusOwner().getFocusRect();
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return FocusInteropUtils_androidKt.calculateBoundingRect(viewFindFocus);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findNextNonChildView(int direction) {
        View viewFindNextFocus = this;
        while (viewFindNextFocus != null) {
            FocusFinder focusFinder = FocusFinder.getInstance();
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            viewFindNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, viewFindNextFocus, direction);
            if (viewFindNextFocus != null && !AndroidComposeView_androidKt.containsDescendant(this, viewFindNextFocus)) {
                return viewFindNextFocus;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    /* renamed from: getContentCaptureManager$ui_release, reason: from getter */
    public final AndroidContentCaptureManager getContentCaptureManager() {
        return this.contentCaptureManager;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    /* renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$6(AndroidComposeView androidComposeView, boolean z) {
        androidComposeView._inputModeManager.m1262setInputModeiuPiT84(z ? InputMode.INSTANCE.m1260getTouchaOaMEAU() : InputMode.INSTANCE.m1259getKeyboardaOaMEAU());
    }

    @Override // androidx.compose.ui.node.Owner
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // androidx.compose.ui.node.Owner
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.node.Owner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object textInputSession(kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.platform.AndroidComposeView.C04571
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = (androidx.compose.ui.platform.AndroidComposeView.C04571) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.concurrent.atomic.AtomicReference r6 = r4.textInputSessionMutex
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$2 r2 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
            r2.<init>()
            r0.label = r3
            java.lang.Object r5 = androidx.compose.ui.SessionMutex.m756withSessionCancellingPreviousimpl(r6, r2, r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.textInputSession(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver.setValue(resolver);
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$8(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.");
        }
        androidComposeView.m1584sendMotionEvent8iAsVTc(motionEvent);
    }

    @Override // android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        Unit unit;
        Rect rectOnFetchFocusRect = onFetchFocusRect();
        if (rectOnFetchFocusRect != null) {
            rect.left = Math.round(rectOnFetchFocusRect.getLeft());
            rect.top = Math.round(rectOnFetchFocusRect.getTop());
            rect.right = Math.round(rectOnFetchFocusRect.getRight());
            rect.bottom = Math.round(rectOnFetchFocusRect.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure structure) {
        if (Build.VERSION.SDK_INT < 28) {
            AndroidComposeViewAssistHelperMethodsO.INSTANCE.setClassName(structure, getView());
        } else {
            super.dispatchProvideStructure(structure);
        }
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return false;
        }
        return scrollCapture.getScrollCaptureInProgress();
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(android.graphics.Rect localVisibleRect, Point windowOffset, Consumer<ScrollCaptureTarget> targets) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return;
        }
        scrollCapture.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), targets);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        if (focused != null) {
            Rect rectCalculateBoundingRect = FocusInteropUtils_androidKt.calculateBoundingRect(focused);
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
            if (Intrinsics.areEqual(getFocusOwner().mo798focusSearchULY8qGw(focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m784getDowndhqQ8s(), rectCalculateBoundingRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.focusSearch.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.TRUE;
                }
            }), Boolean.TRUE)) {
                return this;
            }
        }
        return super.focusSearch(focused, direction);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) {
        if (isFocused()) {
            return true;
        }
        if (getFocusOwner().getRootState().getHasFocus()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        if (isInTouchMode()) {
            return false;
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
        final int value = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m785getEnterdhqQ8s();
        Boolean boolMo798focusSearchULY8qGw = getFocusOwner().mo798focusSearchULY8qGw(value, previouslyFocusedRect != null ? RectHelper_androidKt.toComposeRect(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.requestFocus.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                Boolean boolM811requestFocusMxy_nc0 = FocusTransactionsKt.m811requestFocusMxy_nc0(focusTargetNode, value);
                return Boolean.valueOf(boolM811requestFocusMxy_nc0 != null ? boolM811requestFocusMxy_nc0.booleanValue() : false);
            }
        });
        if (boolMo798focusSearchULY8qGw != null) {
            return boolMo798focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRequestFocusForOwner-7o62pno, reason: not valid java name */
    public final boolean m1582onRequestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        Integer numM792toAndroidFocusDirection3ESFkO8;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (numM792toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m792toAndroidFocusDirection3ESFkO8(focusDirection.getValue())) == null) ? pjsip_transport_type_e.PJSIP_TRANSPORT_TCP6 : numM792toAndroidFocusDirection3ESFkO8.intValue(), previouslyFocusedRect != null ? RectHelper_androidKt.toAndroidRect(previouslyFocusedRect) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClearFocusForOwner() {
        if (isFocused() || hasFocus()) {
            super.clearFocus();
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus || hasFocus()) {
            return;
        }
        getFocusOwner().releaseFocus();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean isShowingLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus || getShowLayoutBounds() == (isShowingLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final android.view.KeyEvent event) {
        if (isFocused()) {
            this._windowInfo.m1645setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m1369constructorimpl(event.getMetaState()));
            return FocusOwner.m794dispatchKeyEventYhN2O0w$default(getFocusOwner(), KeyEvent.m1283constructorimpl(event), null, 2, null) || super.dispatchKeyEvent(event);
        }
        return getFocusOwner().mo797dispatchKeyEventYhN2O0w(KeyEvent.m1283constructorimpl(event), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.dispatchKeyEvent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(AndroidComposeView.super.dispatchKeyEvent(event));
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) {
        return (isFocused() && getFocusOwner().mo796dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent.m1283constructorimpl(event))) || super.dispatchKeyEventPreIme(event);
    }

    public void setAccessibilityEventBatchIntervalMillis(long intervalMillis) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui_release(intervalMillis);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onDetach(LayoutNode node) {
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0<Unit> function0 = this.endApplyChangesListeners.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        if (this.endApplyChangesListeners.contains(listener)) {
            return;
        }
        this.endApplyChangesListeners.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startDrag-12SF9DM, reason: not valid java name */
    public final boolean m1585startDrag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, transferData, new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), decorationSize, drawDragDecoration, null));
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        int orDefault;
        if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal())) {
            int orDefault2 = this.composeAccessibilityDelegate.getIdToBeforeMap().getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal()) || (orDefault = this.composeAccessibilityDelegate.getIdToAfterMap().getOrDefault(virtualViewId, -1)) == -1) {
            return;
        }
        info.getExtras().putInt(extraDataKey, orDefault);
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        addView(child, -1);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        Intrinsics.checkNotNull(child);
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(child, index, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = width;
        layoutParamsGenerateDefaultLayoutParams.height = height;
        Unit unit = Unit.INSTANCE;
        addView(child, -1, layoutParamsGenerateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        addView(child, -1, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addViewInLayout(child, index, params, true);
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        view.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView.addAndroidView.1
            /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onInitializeAccessibilityNodeInfo(android.view.View r5, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r6) {
                /*
                    r4 = this;
                    super.onInitializeAccessibilityNodeInfo(r5, r6)
                    androidx.compose.ui.platform.AndroidComposeView r5 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r5)
                    boolean r5 = r5.isEnabled$ui_release()
                    if (r5 == 0) goto L13
                    r5 = 0
                    r6.setVisibleToUser(r5)
                L13:
                    androidx.compose.ui.node.LayoutNode r5 = r2
                    androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                        static {
                            /*
                                androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                r0.<init>()
                                
                                // error: 0x0005: SPUT (r0 I:androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1) androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.INSTANCE androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.<clinit>():void");
                        }

                        {
                            /*
                                r1 = this;
                                r0 = 1
                                r1.<init>(r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.<init>():void");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                            /*
                                r1 = this;
                                androidx.compose.ui.node.NodeChain r2 = r2.getNodes()
                                r0 = 8
                                int r0 = androidx.compose.ui.node.NodeKind.m1552constructorimpl(r0)
                                boolean r2 = r2.m1520hasH91voCI$ui_release(r0)
                                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r1) {
                            /*
                                r0 = this;
                                androidx.compose.ui.node.LayoutNode r1 = (androidx.compose.ui.node.LayoutNode) r1
                                java.lang.Boolean r1 = r0.invoke(r1)
                                return r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.invoke(java.lang.Object):java.lang.Object");
                        }
                    }
                    androidx.compose.ui.node.LayoutNode r5 = androidx.compose.ui.semantics.SemanticsNodeKt.findClosestParentNode(r5, r0)
                    if (r5 == 0) goto L26
                    int r5 = r5.getSemanticsId()
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                    goto L27
                L26:
                    r5 = 0
                L27:
                    r0 = -1
                    if (r5 == 0) goto L3e
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.semantics.SemanticsOwner r1 = r1.getSemanticsOwner()
                    androidx.compose.ui.semantics.SemanticsNode r1 = r1.getUnmergedRootSemanticsNode()
                    int r1 = r1.getId()
                    int r2 = r5.intValue()
                    if (r2 != r1) goto L42
                L3e:
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
                L42:
                    androidx.compose.ui.platform.AndroidComposeView r1 = r3
                    int r5 = r5.intValue()
                    r6.setParent(r1, r5)
                    androidx.compose.ui.node.LayoutNode r5 = r2
                    int r5 = r5.getSemanticsId()
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    androidx.collection.MutableIntIntMap r1 = r1.getIdToBeforeMap()
                    int r1 = r1.getOrDefault(r5, r0)
                    if (r1 == r0) goto L89
                    androidx.compose.ui.platform.AndroidComposeView r2 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidViewsHandler r2 = r2.getAndroidViewsHandler$ui_release()
                    android.view.View r2 = androidx.compose.ui.platform.SemanticsUtils_androidKt.semanticsIdToView(r2, r1)
                    if (r2 == 0) goto L71
                    r6.setTraversalBefore(r2)
                    goto L76
                L71:
                    androidx.compose.ui.platform.AndroidComposeView r2 = r3
                    r6.setTraversalBefore(r2, r1)
                L76:
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    android.view.accessibility.AccessibilityNodeInfo r2 = r6.unwrap()
                    androidx.compose.ui.platform.AndroidComposeView r3 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r3 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r3)
                    java.lang.String r3 = r3.getExtraDataTestTraversalBeforeVal()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r1, r5, r2, r3)
                L89:
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    androidx.collection.MutableIntIntMap r1 = r1.getIdToAfterMap()
                    int r1 = r1.getOrDefault(r5, r0)
                    if (r1 == r0) goto Lc1
                    androidx.compose.ui.platform.AndroidComposeView r0 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidViewsHandler r0 = r0.getAndroidViewsHandler$ui_release()
                    android.view.View r0 = androidx.compose.ui.platform.SemanticsUtils_androidKt.semanticsIdToView(r0, r1)
                    if (r0 == 0) goto La9
                    r6.setTraversalAfter(r0)
                    goto Lae
                La9:
                    androidx.compose.ui.platform.AndroidComposeView r0 = r3
                    r6.setTraversalAfter(r0, r1)
                Lae:
                    androidx.compose.ui.platform.AndroidComposeView r0 = androidx.compose.ui.platform.AndroidComposeView.this
                    android.view.accessibility.AccessibilityNodeInfo r6 = r6.unwrap()
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    java.lang.String r1 = r1.getExtraDataTestTraversalAfterVal()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r0, r5, r6, r1)
                Lc1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.AnonymousClass1.onInitializeAccessibilityNodeInfo(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
            }
        });
    }

    public final void removeAndroidView(final AndroidViewHolder view) {
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView.removeAndroidView.1
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
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                view.setImportantForAccessibility(0);
            }
        });
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (nodeToRemeasure != null) {
            while (nodeToRemeasure != null && nodeToRemeasure.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(nodeToRemeasure)) {
                nodeToRemeasure = nodeToRemeasure.getParent$ui_release();
            }
            if (nodeToRemeasure == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode layoutNode) {
        LayoutNode parent$ui_release;
        return this.wasMeasuredWithMultipleConstraints || !((parent$ui_release = layoutNode.getParent$ui_release()) == null || parent$ui_release.getHasFixedInnerContentConstraints$ui_release());
    }

    @Override // androidx.compose.ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (sendPointerUpdate) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            dispatchPendingInteropLayoutCallbacks();
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo1562measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m1515measureAndLayout0kLqBqw(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
                dispatchPendingInteropLayoutCallbacks();
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long jM1579convertMeasureSpecI7RO_PI = m1579convertMeasureSpecI7RO_PI(widthMeasureSpec);
            int iM2682constructorimpl = (int) ULong.m2682constructorimpl(jM1579convertMeasureSpecI7RO_PI >>> 32);
            int iM2682constructorimpl2 = (int) ULong.m2682constructorimpl(jM1579convertMeasureSpecI7RO_PI & 4294967295L);
            long jM1579convertMeasureSpecI7RO_PI2 = m1579convertMeasureSpecI7RO_PI(heightMeasureSpec);
            long jM2091fitPrioritizingHeightZbe2FdA = Constraints.INSTANCE.m2091fitPrioritizingHeightZbe2FdA(iM2682constructorimpl, iM2682constructorimpl2, (int) ULong.m2682constructorimpl(jM1579convertMeasureSpecI7RO_PI2 >>> 32), (int) ULong.m2682constructorimpl(4294967295L & jM1579convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            boolean zM2078equalsimpl0 = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m2073boximpl(jM2091fitPrioritizingHeightZbe2FdA);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    zM2078equalsimpl0 = Constraints.m2078equalsimpl0(constraints.getValue(), jM2091fitPrioritizingHeightZbe2FdA);
                }
                if (!zM2078equalsimpl0) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m1516updateRootConstraintsBRTryo0(jM2091fitPrioritizingHeightZbe2FdA);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH));
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* renamed from: pack-ZIaKswc, reason: not valid java name */
    private final long m1583packZIaKswc(int a, int b) {
        return ULong.m2682constructorimpl(ULong.m2682constructorimpl(b) | ULong.m2682constructorimpl(ULong.m2682constructorimpl(a) << 32));
    }

    /* renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    private final long m1579convertMeasureSpecI7RO_PI(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == Integer.MIN_VALUE) {
            return m1583packZIaKswc(0, size);
        }
        if (mode == 0) {
            return m1583packZIaKswc(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return m1583packZIaKswc(size, size);
        }
        throw new IllegalStateException();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int iM2138getXimpl = IntOffset.m2138getXimpl(j);
        int iM2139getYimpl = IntOffset.m2139getYimpl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        int i = iArr[0];
        if (iM2138getXimpl != i || iM2139getYimpl != iArr[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(i, iArr[1]);
            if (iM2138getXimpl != Integer.MAX_VALUE && iM2139getYimpl != Integer.MAX_VALUE) {
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnedLayer createLayer(Function2<? super androidx.compose.ui.graphics.Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer, GraphicsLayer explicitLayer) {
        DrawChildContainer viewLayerContainer;
        if (explicitLayer != null) {
            return new GraphicsLayerOwnerLayer(explicitLayer, null, this, drawBlock, invalidateParentLayer);
        }
        OwnedLayer ownedLayerPop = this.layerCache.pop();
        if (ownedLayerPop != null) {
            ownedLayerPop.reuseLayer(drawBlock, invalidateParentLayer);
            return ownedLayerPop;
        }
        if (isHardwareAccelerated() && Build.VERSION.SDK_INT != 28) {
            return new GraphicsLayerOwnerLayer(getGraphicsContext().createGraphicsLayer(), getGraphicsContext(), this, drawBlock, invalidateParentLayer);
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            ViewLayer.Companion companion = ViewLayer.INSTANCE;
            if (!companion.getHasRetrievedMethod()) {
                companion.updateDisplayList(new View(getContext()));
            }
            if (companion.getShouldUseDispatchDraw()) {
                viewLayerContainer = new DrawChildContainer(getContext());
            } else {
                viewLayerContainer = new ViewLayerContainer(getContext());
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(viewLayerContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, drawBlock, invalidateParentLayer);
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.INSTANCE.getShouldUseDispatchDraw();
        }
        this.layerCache.push(layer);
        return true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
        this.contentCaptureManager.onSemanticsChange$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui_release(layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onInteropViewLayoutChange(View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    /* renamed from: getFocusDirection-P8AzH3I, reason: not valid java name */
    public FocusDirection m1586getFocusDirectionP8AzH3I(android.view.KeyEvent keyEvent) {
        long jM1293getKeyZmokQxo = KeyEvent_androidKt.m1293getKeyZmokQxo(keyEvent);
        Key.Companion companion = Key.INSTANCE;
        if (Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1281getTabEK5gGoQ())) {
            return FocusDirection.m777boximpl(KeyEvent_androidKt.m1298isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m789getPreviousdhqQ8s() : FocusDirection.INSTANCE.m788getNextdhqQ8s());
        }
        if (Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1274getDirectionRightEK5gGoQ())) {
            return FocusDirection.m777boximpl(FocusDirection.INSTANCE.m790getRightdhqQ8s());
        }
        if (Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1273getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m777boximpl(FocusDirection.INSTANCE.m787getLeftdhqQ8s());
        }
        if (Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1275getDirectionUpEK5gGoQ()) ? true : Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1280getPageUpEK5gGoQ())) {
            return FocusDirection.m777boximpl(FocusDirection.INSTANCE.m791getUpdhqQ8s());
        }
        if (Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1272getDirectionDownEK5gGoQ()) ? true : Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1279getPageDownEK5gGoQ())) {
            return FocusDirection.m777boximpl(FocusDirection.INSTANCE.m784getDowndhqQ8s());
        }
        if (Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1271getDirectionCenterEK5gGoQ()) ? true : Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1276getEnterEK5gGoQ()) ? true : Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1278getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m777boximpl(FocusDirection.INSTANCE.m785getEnterdhqQ8s());
        }
        if (Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1270getBackEK5gGoQ()) ? true : Key.m1266equalsimpl0(jM1293getKeyZmokQxo, companion.m1277getEscapeEK5gGoQ())) {
            return FocusDirection.m777boximpl(FocusDirection.INSTANCE.m786getExitdhqQ8s());
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, null);
        Snapshot.INSTANCE.sendApplyNotifications();
        this.isDrawingContent = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder.getAndroidCanvas(), null);
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
            int iSave = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(iSave);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        if (!isDirty) {
            if (this.isDrawingContent) {
                return;
            }
            this.dirtyLayers.remove(layer);
            List<OwnedLayer> list = this.postponedDirtyLayers;
            if (list != null) {
                list.remove(layer);
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
            return;
        }
        List arrayList = this.postponedDirtyLayers;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.postponedDirtyLayers = arrayList;
        }
        arrayList.add(layer);
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = callback;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) {
        Object objBoundsUpdatesEventLoop$ui_release = this.contentCaptureManager.boundsUpdatesEventLoop$ui_release(continuation);
        return objBoundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBoundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object objBoundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return objBoundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBoundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        int i = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement(content[i]);
                i++;
            } while (i < size);
        }
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                invalidateLayers(content[i]);
                i++;
            } while (i < size);
        }
    }

    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        this._windowInfo.setWindowFocused(hasWindowFocus());
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || (lifecycleOwner3 != null && savedStateRegistryOwner != null && (lifecycleOwner3 != viewTreeOwners.getLifecycleOwner() || savedStateRegistryOwner != viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner3.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
            set_viewTreeOwners(viewTreeOwners2);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners2);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.m1262setInputModeiuPiT84(isInTouchMode() ? InputMode.INSTANCE.m1260getTouchaOaMEAU() : InputMode.INSTANCE.m1259getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        if (viewTreeOwners3 != null && (lifecycleOwner2 = viewTreeOwners3.getLifecycleOwner()) != null) {
            lifecycle2 = lifecycleOwner2.getLifecycle();
        }
        if (lifecycle2 == null) {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle2.addObserver(this);
        lifecycle2.addObserver(this.contentCaptureManager);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle = (viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null) ? null : lifecycleOwner.getLifecycle();
        if (lifecycle == null) {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle.removeObserver(this.contentCaptureManager);
        lifecycle.removeObserver(this);
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
        }
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || structure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui_release(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.onVirtualViewTranslationResponses$ui_release(androidContentCaptureManager, response);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        if (motionEvent.getActionMasked() == 8) {
            if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
                return super.dispatchGenericMotionEvent(motionEvent);
            }
            return motionEvent.isFromSource(4194304) ? handleRotaryEvent(motionEvent) : ProcessResult.m1388getDispatchedToAPointerInputModifierimpl(m1580handleMotionEvent8iAsVTc(motionEvent));
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int iM1580handleMotionEvent8iAsVTc = m1580handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m1387getAnyMovementConsumedimpl(iM1580handleMotionEvent8iAsVTc)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m1388getDispatchedToAPointerInputModifierimpl(iM1580handleMotionEvent8iAsVTc);
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f = -event.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(f * ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()), f * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), event.getEventTime(), event.getDeviceId()));
    }

    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m1580handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        int i;
        int i2;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent2 = this.previousMotionEvent;
                boolean z = motionEvent2 != null && motionEvent2.getToolType(0) == 3;
                if (motionEvent2 == null || !hasChangedDevices(motionEvent, motionEvent2)) {
                    i = 10;
                } else {
                    if (isDevicePressEvent(motionEvent2)) {
                        this.pointerInputEventProcessor.processCancel();
                    } else if (motionEvent2.getActionMasked() != 10 && z) {
                        i = 10;
                        sendSimulatedEvent$default(this, motionEvent2, 10, motionEvent2.getEventTime(), false, 8, null);
                    }
                    i = 10;
                }
                boolean z2 = motionEvent.getToolType(0) == 3;
                if (z || !z2 || actionMasked == 3 || actionMasked == 9 || !isInBounds(motionEvent)) {
                    i2 = 9;
                } else {
                    i2 = 9;
                    sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                MotionEvent motionEvent3 = this.previousMotionEvent;
                if (motionEvent3 != null && motionEvent3.getAction() == i) {
                    MotionEvent motionEvent4 = this.previousMotionEvent;
                    int pointerId = motionEvent4 != null ? motionEvent4.getPointerId(0) : -1;
                    if (motionEvent.getAction() == i2 && motionEvent.getHistorySize() == 0) {
                        if (pointerId >= 0) {
                            this.motionEventAdapter.endStream(pointerId);
                        }
                    } else if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                        MotionEvent motionEvent5 = this.previousMotionEvent;
                        float x = motionEvent5 != null ? motionEvent5.getX() : Float.NaN;
                        MotionEvent motionEvent6 = this.previousMotionEvent;
                        boolean z3 = (x == motionEvent.getX() && (motionEvent6 != null ? motionEvent6.getY() : Float.NaN) == motionEvent.getY()) ? false : true;
                        MotionEvent motionEvent7 = this.previousMotionEvent;
                        boolean z4 = (motionEvent7 != null ? motionEvent7.getEventTime() : -1L) != motionEvent.getEventTime();
                        if (z3 || z4) {
                            if (pointerId >= 0) {
                                this.motionEventAdapter.endStream(pointerId);
                            }
                            this.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
                        }
                    }
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int iM1584sendMotionEvent8iAsVTc = m1584sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                return iM1584sendMotionEvent8iAsVTc;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } finally {
            this.forceUseMatrixCache = false;
        }
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        int actionMasked;
        return event.getButtonState() != 0 || (actionMasked = event.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m1584sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m1645setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m1369constructorimpl(motionEvent.getMetaState()));
        }
        PointerInputEvent pointerInputEventConvertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (pointerInputEventConvertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> pointers = pointerInputEventConvertToPointerInputEvent$ui_release.getPointers();
            int size = pointers.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    pointerInputEventData = pointers.get(size);
                    if (pointerInputEventData.getDown()) {
                        break;
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
                pointerInputEventData = null;
            } else {
                pointerInputEventData = null;
            }
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.getPosition();
            }
            int iM1363processBIzXfog = this.pointerInputEventProcessor.m1363processBIzXfog(pointerInputEventConvertToPointerInputEvent$ui_release, this, isInBounds(motionEvent));
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked != 0 && actionMasked != 5) || ProcessResult.m1388getDispatchedToAPointerInputModifierimpl(iM1363processBIzXfog)) {
                return iM1363processBIzXfog;
            }
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            return iM1363processBIzXfog;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (action != 9 && action != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            pointerPropertiesArr[i] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerCoordsArr[i2] = new MotionEvent.PointerCoords();
        }
        int i3 = 0;
        while (i3 < pointerCount) {
            int i4 = ((actionIndex < 0 || i3 < actionIndex) ? 0 : 1) + i3;
            motionEvent.getPointerProperties(i4, pointerPropertiesArr[i3]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i3];
            motionEvent.getPointerCoords(i4, pointerCoords);
            long jMo1384localToScreenMKHz9U = mo1384localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = Offset.m842getXimpl(jMo1384localToScreenMKHz9U);
            pointerCoords.y = Offset.m843getYimpl(jMo1384localToScreenMKHz9U);
            i3++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? eventTime : motionEvent.getDownTime(), eventTime, action, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), forceHover ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        PointerInputEvent pointerInputEventConvertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEventObtain, this);
        Intrinsics.checkNotNull(pointerInputEventConvertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m1363processBIzXfog(pointerInputEventConvertToPointerInputEvent$ui_release, this, true);
        motionEventObtain.recycle();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.m1596canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.m1596canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo1384localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long jM1034mapMKHz9U = Matrix.m1034mapMKHz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(Offset.m842getXimpl(jM1034mapMKHz9U) + Offset.m842getXimpl(this.windowPosition), Offset.m843getYimpl(jM1034mapMKHz9U) + Offset.m843getYimpl(this.windowPosition));
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-58bKbWc */
    public void mo1383localToScreen58bKbWc(float[] localTransform) {
        recalculateWindowPosition();
        Matrix.m1042timesAssign58bKbWc(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m1601preTranslatecG2Xzmc(localTransform, Offset.m842getXimpl(this.windowPosition), Offset.m843getYimpl(this.windowPosition), this.tmpMatrix);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo1385screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        return Matrix.m1034mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m842getXimpl(positionOnScreen) - Offset.m842getXimpl(this.windowPosition), Offset.m843getYimpl(positionOnScreen) - Offset.m843getYimpl(this.windowPosition)));
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = jCurrentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f = iArr[0];
            float f2 = iArr[1];
            view.getLocationInWindow(iArr);
            int[] iArr2 = this.tmpPositionArray;
            this.windowPosition = OffsetKt.Offset(f - iArr2[0], f2 - iArr2[1]);
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long jM1034mapMKHz9U = Matrix.m1034mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m842getXimpl(jM1034mapMKHz9U), motionEvent.getRawY() - Offset.m843getYimpl(jM1034mapMKHz9U));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo1602calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m1622invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m755getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.getEditorHasFocus();
        }
        return androidPlatformTextInputSession.isReadyForConnection();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m755getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(outAttrs);
        }
        return androidPlatformTextInputSession.createInputConnection(outAttrs);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo1560calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m1034mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo1561calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m1034mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setDensity(AndroidDensity_androidKt.Density(getContext()));
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirection2 = FocusInteropUtils_androidKt.toLayoutDirection(layoutDirection);
            if (layoutDirection2 == null) {
                layoutDirection2 = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection2);
        }
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(event)) {
                if (event.getToolType(0) == 3 && event.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent = this.previousMotionEvent;
                if (motionEvent != null) {
                    motionEvent.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                this.hoverExitReceived = true;
                postDelayed(this.sendHoverExitEvent, 8L);
                return false;
            }
        } else if (!isPositionChanged(event)) {
            return false;
        }
        return ProcessResult.m1388getDispatchedToAPointerInputModifierimpl(m1580handleMotionEvent8iAsVTc(event));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082 A[LOOP:0: B:22:0x004c->B:39:0x0082, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085 A[EDGE_INSN: B:41:0x0085->B:40:0x0085 BREAK  A[LOOP:0: B:22:0x004c->B:39:0x0082], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isBadMotionEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L44
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L44
            float r0 = r7.getY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L44
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L44
            float r0 = r7.getRawX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L44
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L44
            float r0 = r7.getRawY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L44
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L44
            r0 = r2
            goto L45
        L44:
            r0 = r3
        L45:
            if (r0 != 0) goto L85
            int r1 = r7.getPointerCount()
            r4 = r3
        L4c:
            if (r4 >= r1) goto L85
            float r0 = r7.getX(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L7f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L7f
            float r0 = r7.getY(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L7f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L7f
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r0 < r5) goto L7d
            androidx.compose.ui.platform.MotionEventVerifierApi29 r0 = androidx.compose.ui.platform.MotionEventVerifierApi29.INSTANCE
            boolean r0 = r0.isValidMotionEvent(r7, r4)
            if (r0 != 0) goto L7d
            goto L7f
        L7d:
            r0 = r2
            goto L80
        L7f:
            r0 = r3
        L80:
            if (r0 != 0) goto L85
            int r4 = r4 + 1
            goto L4c
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.isBadMotionEvent(android.view.MotionEvent):boolean");
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent motionEvent;
        return (event.getPointerCount() == 1 && (motionEvent = this.previousMotionEvent) != null && motionEvent.getPointerCount() == event.getPointerCount() && event.getRawX() == motionEvent.getRawX() && event.getRawY() == motionEvent.getRawY()) ? false : true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", null);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(currentView, null), Integer.valueOf(accessibilityId))) {
                return currentView;
            }
            if (currentView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) currentView;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, viewGroup.getChildAt(i));
                    if (viewFindViewByAccessibilityIdRootedAtCurrentView != null) {
                        return viewFindViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        View viewFindViewByAccessibilityIdRootedAtCurrentView = null;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (objInvoke instanceof View) {
                    viewFindViewByAccessibilityIdRootedAtCurrentView = (View) objInvoke;
                }
            } else {
                viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
            }
        } catch (NoSuchMethodException unused) {
        }
        return viewFindViewByAccessibilityIdRootedAtCurrentView;
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object objInvoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                Boolean bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ViewTreeOwners {
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }
}
