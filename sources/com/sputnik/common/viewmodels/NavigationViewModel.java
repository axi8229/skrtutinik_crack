package com.sputnik.common.viewmodels;

import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.domain.common.Event;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: NavigationViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u0005J\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u0005J\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u0005J\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0005J\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/sputnik/common/viewmodels/NavigationViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/NavigationViewState;", "", "<init>", "()V", "Lcom/sputnik/common/viewmodels/NavigationScenario;", "scenario", "", "addAction", "(Lcom/sputnik/common/viewmodels/NavigationScenario;)V", "addDelayedAction", "clearBottom", "removeAction", "clearPopBackStack", "hideBottomNavigationMenu", "showBottomNavigationMenu", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavigationViewModel extends BaseViewModel<NavigationViewState> {
    public NavigationViewModel() {
        super(new NavigationViewState(null, null, false, false, 15, null), "javaClass");
    }

    /* compiled from: NavigationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.viewmodels.NavigationViewModel$addDelayedAction$1", f = "NavigationViewModel.kt", l = {33}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.viewmodels.NavigationViewModel$addDelayedAction$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NavigationScenario $scenario;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NavigationScenario navigationScenario, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$scenario = navigationScenario;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NavigationViewModel.this.new AnonymousClass1(this.$scenario, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            NavigationViewModel navigationViewModel = NavigationViewModel.this;
            NavigationViewState navigationViewStateCopy$default = NavigationViewState.copy$default(navigationViewModel.getCurrentState(), null, new Event(new BottomNavigationAction(null, null, 3, null)), false, false, 12, null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(navigationViewModel), null, null, new BaseViewModel$updateState$1(navigationViewStateCopy$default, navigationViewModel, null), 3, null);
            navigationViewModel.getState().setValue(navigationViewStateCopy$default);
            if (this.$scenario.getNavigationActions().size() != 0 || this.$scenario.getNeedToPopBackStack() || this.$scenario.getBottomAction() != null) {
                NavigationViewModel navigationViewModel2 = NavigationViewModel.this;
                NavigationScenario navigationScenario = this.$scenario;
                navigationViewModel2.getCurrentState();
                NavigationViewState navigationViewState = new NavigationViewState(navigationScenario, new Event(new BottomNavigationAction(null, null, 3, null)), false, false, 12, null);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(navigationViewModel2), null, null, new BaseViewModel$updateState$1(navigationViewState, navigationViewModel2, null), 3, null);
                navigationViewModel2.getState().setValue(navigationViewState);
            }
            return Unit.INSTANCE;
        }
    }

    public final void addDelayedAction(NavigationScenario scenario) {
        Intrinsics.checkNotNullParameter(scenario, "scenario");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(scenario, null), 3, null);
    }

    public final void removeAction() {
        Queue<NavigationAction> navigationActions;
        NavigationScenario action = getCurrentState().getAction();
        NavigationAction navigationActionPeek = (action == null || (navigationActions = action.getNavigationActions()) == null) ? null : navigationActions.peek();
        NavigationScenario action2 = getCurrentState().getAction();
        Queue<NavigationAction> navigationActions2 = action2 != null ? action2.getNavigationActions() : null;
        if (navigationActions2 != null) {
            navigationActions2.remove(navigationActionPeek);
        }
        NavigationViewState currentState = getCurrentState();
        if (navigationActions2 == null) {
            navigationActions2 = new LinkedList<>();
        }
        NavigationViewState navigationViewStateCopy$default = NavigationViewState.copy$default(currentState, new NavigationScenario(null, navigationActions2, false, 1, null), null, false, true, 6, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(navigationViewStateCopy$default, this, null), 3, null);
        getState().setValue(navigationViewStateCopy$default);
    }

    public final void addAction(NavigationScenario scenario) {
        Intrinsics.checkNotNullParameter(scenario, "scenario");
        NavigationViewState navigationViewStateCopy$default = NavigationViewState.copy$default(getCurrentState(), null, new Event(new BottomNavigationAction(null, null, 3, null)), false, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(navigationViewStateCopy$default, this, null), 3, null);
        getState().setValue(navigationViewStateCopy$default);
        if (scenario.getNavigationActions().size() == 0 && !scenario.getNeedToPopBackStack() && scenario.getBottomAction() == null) {
            return;
        }
        getCurrentState();
        NavigationViewState navigationViewState = new NavigationViewState(scenario, new Event(new BottomNavigationAction(null, null, 3, null)), false, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(navigationViewState, this, null), 3, null);
        getState().setValue(navigationViewState);
    }

    public final void clearBottom() {
        NavigationViewState currentState = getCurrentState();
        Event event = new Event(new BottomNavigationAction(null, null, 3, null));
        NavigationScenario action = getCurrentState().getAction();
        NavigationViewState navigationViewStateCopy$default = NavigationViewState.copy$default(currentState, action != null ? NavigationScenario.copy$default(action, null, null, false, 6, null) : null, event, false, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(navigationViewStateCopy$default, this, null), 3, null);
        getState().setValue(navigationViewStateCopy$default);
    }

    public final void clearPopBackStack() {
        NavigationViewState currentState = getCurrentState();
        NavigationScenario action = getCurrentState().getAction();
        NavigationViewState navigationViewStateCopy$default = NavigationViewState.copy$default(currentState, action != null ? NavigationScenario.copy$default(action, null, null, false, 3, null) : null, null, false, false, 14, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(navigationViewStateCopy$default, this, null), 3, null);
        getState().setValue(navigationViewStateCopy$default);
    }

    public final void hideBottomNavigationMenu() {
        NavigationViewState navigationViewStateCopy$default = NavigationViewState.copy$default(getCurrentState(), null, null, true, false, 11, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(navigationViewStateCopy$default, this, null), 3, null);
        getState().setValue(navigationViewStateCopy$default);
    }

    public final void showBottomNavigationMenu() {
        NavigationViewState navigationViewStateCopy$default = NavigationViewState.copy$default(getCurrentState(), null, null, false, false, 11, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(navigationViewStateCopy$default, this, null), 3, null);
        getState().setValue(navigationViewStateCopy$default);
    }
}
