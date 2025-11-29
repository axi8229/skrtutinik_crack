package com.sputnik.common.viewmodels.interfaces;

import kotlin.Metadata;

/* compiled from: ICamerasViewModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/sputnik/common/viewmodels/interfaces/ICamerasViewModel;", "", "", "uuid", "flatUUID", "", "openDoor", "(Ljava/lang/String;Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICamerasViewModel {
    void openDoor(String uuid, String flatUUID);

    /* compiled from: ICamerasViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void openDoor$default(ICamerasViewModel iCamerasViewModel, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openDoor");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            iCamerasViewModel.openDoor(str, str2);
        }
    }
}
