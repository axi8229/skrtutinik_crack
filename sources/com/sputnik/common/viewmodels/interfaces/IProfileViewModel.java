package com.sputnik.common.viewmodels.interfaces;

import kotlin.Metadata;

/* compiled from: IProfileViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/viewmodels/interfaces/IProfileViewModel;", "", "", "withCheckup", "", "loadProfile", "(Z)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IProfileViewModel {
    void loadProfile(boolean withCheckup);

    /* compiled from: IProfileViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void loadProfile$default(IProfileViewModel iProfileViewModel, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadProfile");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            iProfileViewModel.loadProfile(z);
        }
    }
}
