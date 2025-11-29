package androidx.navigation.compose;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import androidx.view.BackEventCompat;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: NavHost.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "backEvent", "", "<anonymous>", "(Lkotlinx/coroutines/flow/Flow;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$25$1", f = "NavHost.kt", l = {521}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class NavHostKt$NavHost$25$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ State<List<NavBackStackEntry>> $currentBackStack$delegate;
    final /* synthetic */ MutableState<Boolean> $inPredictiveBack$delegate;
    final /* synthetic */ MutableFloatState $progress$delegate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NavHostKt$NavHost$25$1(ComposeNavigator composeNavigator, MutableFloatState mutableFloatState, State<? extends List<NavBackStackEntry>> state, MutableState<Boolean> mutableState, Continuation<? super NavHostKt$NavHost$25$1> continuation) {
        super(2, continuation);
        this.$composeNavigator = composeNavigator;
        this.$progress$delegate = mutableFloatState;
        this.$currentBackStack$delegate = state;
        this.$inPredictiveBack$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavHostKt$NavHost$25$1 navHostKt$NavHost$25$1 = new NavHostKt$NavHost$25$1(this.$composeNavigator, this.$progress$delegate, this.$currentBackStack$delegate, this.$inPredictiveBack$delegate, continuation);
        navHostKt$NavHost$25$1.L$0 = obj;
        return navHostKt$NavHost$25$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$25$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NavBackStackEntry navBackStackEntry;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flow = (Flow) this.L$0;
                this.$progress$delegate.setFloatValue(0.0f);
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull(NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate));
                ComposeNavigator composeNavigator = this.$composeNavigator;
                Intrinsics.checkNotNull(navBackStackEntry2);
                composeNavigator.prepareForTransition(navBackStackEntry2);
                this.$composeNavigator.prepareForTransition((NavBackStackEntry) NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).get(NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).size() - 2));
                final MutableState<Boolean> mutableState = this.$inPredictiveBack$delegate;
                final MutableFloatState mutableFloatState = this.$progress$delegate;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.navigation.compose.NavHostKt$NavHost$25$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((BackEventCompat) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(BackEventCompat backEventCompat, Continuation<? super Unit> continuation) {
                        NavHostKt.NavHost$lambda$12(mutableState, true);
                        mutableFloatState.setFloatValue(backEventCompat.getProgress());
                        return Unit.INSTANCE;
                    }
                };
                this.L$0 = navBackStackEntry2;
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                navBackStackEntry = navBackStackEntry2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                navBackStackEntry = (NavBackStackEntry) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            NavHostKt.NavHost$lambda$12(this.$inPredictiveBack$delegate, false);
            this.$composeNavigator.popBackStack(navBackStackEntry, false);
        } catch (CancellationException unused) {
            NavHostKt.NavHost$lambda$12(this.$inPredictiveBack$delegate, false);
        }
        return Unit.INSTANCE;
    }
}
