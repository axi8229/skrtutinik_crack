package sputnik.axmor.com.sputnik.ui.splash.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: SplashViewModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0010B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/splash/viewmodel/SplashViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/splash/viewmodel/SplashViewState;", "", "<init>", "()V", "", "index", "", "handleNewIndex", "(I)V", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SplashViewModel extends BaseViewModel<SplashViewState> {
    private final Job job;

    public SplashViewModel() {
        SplashViewState splashViewState = new SplashViewState(0, 1, null);
        String name = SplashViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(splashViewState, name);
        Job jobLaunch = BuildersKt.launch(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), CoroutineStart.LAZY, new SplashViewModel$job$1(this, null));
        this.job = jobLaunch;
        jobLaunch.start();
    }

    public void handleNewIndex(int index) {
        if (getCurrentState().getCurLoaderIndex() == 3) {
            SplashViewState splashViewStateCopy = getCurrentState().copy(0);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SplashViewModel$handleNewIndex$$inlined$updateState$1(splashViewStateCopy, this, null), 3, null);
            getState().setValue(splashViewStateCopy);
        } else {
            SplashViewState splashViewStateCopy2 = getCurrentState().copy(index);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SplashViewModel$handleNewIndex$$inlined$updateState$2(splashViewStateCopy2, this, null), 3, null);
            getState().setValue(splashViewStateCopy2);
        }
    }
}
