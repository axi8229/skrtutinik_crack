package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: Composer.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 r2\u00020\u0001:\u0001rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H'¢\u0006\u0004\b\n\u0010\bJ!\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H'¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H'¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H'¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H'¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H'¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0004H'¢\u0006\u0004\b\u001c\u0010\bJ#\u0010 \u001a\u00020\u0004\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH'¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H'¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010#\u001a\u00020\u0004H'¢\u0006\u0004\b#\u0010\bJ!\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b$\u0010\rJ\u000f\u0010%\u001a\u00020\u0004H'¢\u0006\u0004\b%\u0010\bJ=\u0010*\u001a\u00020\u0004\"\u0004\b\u0000\u0010&\"\u0004\b\u0001\u0010\u001d2\u0006\u0010'\u001a\u00028\u00002\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040(H'¢\u0006\u0004\b*\u0010+J\u0011\u0010,\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b.\u0010/J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\u0018\u00100J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u0018\u00101J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0018\u00102J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010'\u001a\u000203H\u0017¢\u0006\u0004\b\u0018\u00104J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010'\u001a\u000205H\u0017¢\u0006\u0004\b\u0018\u00106J\u0019\u00107\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0017¢\u0006\u0004\b7\u00100J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H'¢\u0006\u0004\b:\u0010;J\u001d\u0010=\u001a\u00020\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eH'¢\u0006\u0004\b=\u0010!J#\u0010?\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000>H'¢\u0006\u0004\b?\u0010@J#\u0010D\u001a\u00020\u00042\u0012\u0010C\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030B0AH'¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0004H'¢\u0006\u0004\bF\u0010\bJ\u001b\u0010G\u001a\u00020\u00042\n\u0010'\u001a\u0006\u0012\u0002\b\u00030BH'¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0004H'¢\u0006\u0004\bI\u0010\bJ\u000f\u0010J\u001a\u00020\u0004H&¢\u0006\u0004\bJ\u0010\bJ\u000f\u0010L\u001a\u00020KH'¢\u0006\u0004\bL\u0010MR\u001e\u0010R\u001a\u0006\u0012\u0002\b\u00030N8&X§\u0004¢\u0006\f\u0012\u0004\bQ\u0010\b\u001a\u0004\bO\u0010PR\u001a\u0010V\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\bU\u0010\b\u001a\u0004\bS\u0010TR\u001a\u0010Y\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\bX\u0010\b\u001a\u0004\bW\u0010TR\u001a\u0010\\\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b[\u0010\b\u001a\u0004\bZ\u0010TR\u001c\u0010`\u001a\u0004\u0018\u0001088&X§\u0004¢\u0006\f\u0012\u0004\b_\u0010\b\u001a\u0004\b]\u0010^R\u001a\u0010d\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bc\u0010\b\u001a\u0004\ba\u0010bR\u0014\u0010h\u001a\u00020e8&X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8&X¦\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u001a\u0010q\u001a\u00020m8gX§\u0004¢\u0006\f\u0012\u0004\bp\u0010\b\u001a\u0004\bn\u0010o\u0082\u0001\u0001sø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/Composer;", "", "", "key", "", "startReplaceableGroup", "(I)V", "endReplaceableGroup", "()V", "startReplaceGroup", "endReplaceGroup", "dataKey", "startMovableGroup", "(ILjava/lang/Object;)V", "endMovableGroup", "startDefaults", "endDefaults", "startRestartGroup", "(I)Landroidx/compose/runtime/Composer;", "Landroidx/compose/runtime/ScopeUpdateScope;", "endRestartGroup", "()Landroidx/compose/runtime/ScopeUpdateScope;", "skipToGroupEnd", "", "changed", "deactivateToEndGroup", "(Z)V", "startNode", "startReusableNode", "T", "Lkotlin/Function0;", "factory", "createNode", "(Lkotlin/jvm/functions/Function0;)V", "useNode", "endNode", "startReusableGroup", "endReusableGroup", "V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/Function2;", "block", "apply", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "rememberedValue", "()Ljava/lang/Object;", "updateRememberedValue", "(Ljava/lang/Object;)V", "(Ljava/lang/Object;)Z", "(Z)Z", "(I)Z", "", "(F)Z", "", "(J)Z", "changedInstance", "Landroidx/compose/runtime/RecomposeScope;", "scope", "recordUsed", "(Landroidx/compose/runtime/RecomposeScope;)V", "effect", "recordSideEffect", "Landroidx/compose/runtime/CompositionLocal;", "consume", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "", "Landroidx/compose/runtime/ProvidedValue;", "values", "startProviders", "([Landroidx/compose/runtime/ProvidedValue;)V", "endProviders", "startProvider", "(Landroidx/compose/runtime/ProvidedValue;)V", "endProvider", "collectParameterInformation", "Landroidx/compose/runtime/CompositionContext;", "buildContext", "()Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/Applier;", "getApplier", "()Landroidx/compose/runtime/Applier;", "getApplier$annotations", "applier", "getInserting", "()Z", "getInserting$annotations", "inserting", "getSkipping", "getSkipping$annotations", "skipping", "getDefaultsInvalid", "getDefaultsInvalid$annotations", "defaultsInvalid", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope$annotations", "recomposeScope", "getCompoundKeyHash", "()I", "getCompoundKeyHash$annotations", "compoundKeyHash", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentCompositionLocalMap", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionData", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "applyCoroutineContext", "Companion", "Landroidx/compose/runtime/ComposerImpl;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Composer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    <V, T> void apply(V value, Function2<? super T, ? super V, Unit> block);

    CompositionContext buildContext();

    boolean changed(Object value);

    void collectParameterInformation();

    <T> T consume(CompositionLocal<T> key);

    <T> void createNode(Function0<? extends T> factory);

    void deactivateToEndGroup(boolean changed);

    void endDefaults();

    void endMovableGroup();

    void endNode();

    void endProvider();

    void endProviders();

    void endReplaceGroup();

    void endReplaceableGroup();

    ScopeUpdateScope endRestartGroup();

    void endReusableGroup();

    Applier<?> getApplier();

    CoroutineContext getApplyCoroutineContext();

    CompositionData getCompositionData();

    int getCompoundKeyHash();

    CompositionLocalMap getCurrentCompositionLocalMap();

    boolean getDefaultsInvalid();

    boolean getInserting();

    RecomposeScope getRecomposeScope();

    boolean getSkipping();

    void recordSideEffect(Function0<Unit> effect);

    void recordUsed(RecomposeScope scope);

    Object rememberedValue();

    void skipToGroupEnd();

    void startDefaults();

    void startMovableGroup(int key, Object dataKey);

    void startNode();

    void startProvider(ProvidedValue<?> value);

    void startProviders(ProvidedValue<?>[] values);

    void startReplaceGroup(int key);

    void startReplaceableGroup(int key);

    Composer startRestartGroup(int key);

    void startReusableGroup(int key, Object dataKey);

    void startReusableNode();

    void updateRememberedValue(Object value);

    void useNode();

    default boolean changed(boolean value) {
        return changed(value);
    }

    default boolean changed(int value) {
        return changed(value);
    }

    default boolean changed(float value) {
        return changed(value);
    }

    default boolean changed(long value) {
        return changed(value);
    }

    default boolean changedInstance(Object value) {
        return changed(value);
    }

    /* compiled from: Composer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/Composer$Companion;", "", "<init>", "()V", "Empty", "Ljava/lang/Object;", "getEmpty", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Object Empty = new Object() { // from class: androidx.compose.runtime.Composer$Companion$Empty$1
            public String toString() {
                return "Empty";
            }
        };

        private Companion() {
        }

        public final Object getEmpty() {
            return Empty;
        }
    }
}
