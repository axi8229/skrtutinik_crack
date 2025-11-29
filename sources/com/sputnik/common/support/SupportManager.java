package com.sputnik.common.support;

import android.app.Application;
import android.content.Intent;
import com.sputnik.common.StaticVariables;
import com.sputnik.common.ui.fragments.HDESupportActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SupportManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/common/support/SupportManager;", "Lcom/sputnik/common/support/ISupportManager;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "displayMessenger", "", "defaultMessage", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SupportManager implements ISupportManager {
    private final Application context;

    public SupportManager(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.sputnik.common.support.ISupportManager
    public void displayMessenger(String defaultMessage) {
        StaticVariables.INSTANCE.setCustomScenarioEnabled(true);
        Application application = this.context;
        Intent intent = new Intent(this.context, (Class<?>) HDESupportActivity.class);
        intent.setFlags(268435456);
        application.startActivity(intent);
    }
}
