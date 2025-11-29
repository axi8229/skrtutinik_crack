package com.sputnik.common.di;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.ui.dialogs.SingleButtonDialog;
import com.sputnik.common.ui.fragments.HDESupportActivity;
import kotlin.Metadata;

/* compiled from: CommonComponent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/sputnik/common/di/CommonComponent;", "", "inject", "", "fragment", "Lcom/sputnik/common/base/BaseFragment;", "dialog", "Lcom/sputnik/common/ui/dialogs/SingleButtonDialog;", "activity", "Lcom/sputnik/common/ui/fragments/HDESupportActivity;", "Builder", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CommonComponent {

    /* compiled from: CommonComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/di/CommonComponent$Builder;", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/sputnik/common/di/CommonComponent;", "deps", "servicePaymentDeps", "Lcom/sputnik/common/di/CommonDeps;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        CommonComponent build();

        Builder deps(CommonDeps servicePaymentDeps);
    }

    void inject(BaseFragment fragment);

    void inject(SingleButtonDialog dialog);

    void inject(HDESupportActivity activity);
}
