package com.mocklets.pluto.modules.exceptions;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* compiled from: ANRListener.kt */
@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mocklets/pluto/modules/exceptions/ANRListener;", "", "onAppNotResponding", "", "exception", "Lcom/mocklets/pluto/modules/exceptions/ANRException;", "pluto-no-op_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface ANRListener {
    void onAppNotResponding(ANRException exception);
}
