package com.sputnik.common.viewmodels;

import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: StateViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/sputnik/common/viewmodels/StateViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/StateViewState;", "", "<init>", "()V", "", "enabled", "", "updateIsVpnEnabled", "(Z)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StateViewModel extends BaseViewModel<StateViewState> {
    public StateViewModel() {
        super(new StateViewState(false, 1, null), "javaClass");
    }

    public final void updateIsVpnEnabled(boolean enabled) {
        StateViewState stateViewStateCopy = getCurrentState().copy(enabled);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(stateViewStateCopy, this, null), 3, null);
        getState().setValue(stateViewStateCopy);
    }
}
