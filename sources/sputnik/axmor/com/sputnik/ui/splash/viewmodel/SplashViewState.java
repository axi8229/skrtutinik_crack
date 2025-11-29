package sputnik.axmor.com.sputnik.ui.splash.viewmodel;

import com.sputnik.common.base.VMState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SplashViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/splash/viewmodel/SplashViewState;", "Lcom/sputnik/common/base/VMState;", "", "curLoaderIndex", "<init>", "(I)V", "copy", "(I)Lsputnik/axmor/com/sputnik/ui/splash/viewmodel/SplashViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCurLoaderIndex", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SplashViewState implements VMState {
    private final int curLoaderIndex;

    public SplashViewState() {
        this(0, 1, null);
    }

    public final SplashViewState copy(int curLoaderIndex) {
        return new SplashViewState(curLoaderIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SplashViewState) && this.curLoaderIndex == ((SplashViewState) other).curLoaderIndex;
    }

    public int hashCode() {
        return Integer.hashCode(this.curLoaderIndex);
    }

    public String toString() {
        return "SplashViewState(curLoaderIndex=" + this.curLoaderIndex + ")";
    }

    public SplashViewState(int i) {
        this.curLoaderIndex = i;
    }

    public /* synthetic */ SplashViewState(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getCurLoaderIndex() {
        return this.curLoaderIndex;
    }
}
