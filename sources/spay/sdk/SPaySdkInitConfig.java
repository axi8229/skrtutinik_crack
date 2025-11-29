package spay.sdk;

import android.app.Application;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.api.InitializationResult;
import spay.sdk.api.SPayHelperConfig;
import spay.sdk.api.SPayStage;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b6\u00107J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fHÆ\u0003J[\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fHÆ\u0001J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0012\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0013\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b0\u0010#\u001a\u0004\b1\u0010%R#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00068"}, d2 = {"Lspay/sdk/SPaySdkInitConfig;", "", "Landroid/app/Application;", "component1", "", "component2", "Lspay/sdk/api/SPayStage;", "component3", "Lspay/sdk/api/SPayHelperConfig;", "component4", "component5", "component6", "Lkotlin/Function1;", "Lspay/sdk/api/InitializationResult;", "", "component7", "application", "enableBnpl", "stage", "helperConfig", "resultViewNeeded", "enableLogging", "initializationResult", "copy", "", "toString", "", "hashCode", "other", "equals", "a", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "b", "Z", "getEnableBnpl", "()Z", "c", "Lspay/sdk/api/SPayStage;", "getStage", "()Lspay/sdk/api/SPayStage;", "d", "Lspay/sdk/api/SPayHelperConfig;", "getHelperConfig", "()Lspay/sdk/api/SPayHelperConfig;", "e", "getResultViewNeeded", "f", "getEnableLogging", "g", "Lkotlin/jvm/functions/Function1;", "getInitializationResult", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Landroid/app/Application;ZLspay/sdk/api/SPayStage;Lspay/sdk/api/SPayHelperConfig;ZZLkotlin/jvm/functions/Function1;)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final /* data */ class SPaySdkInitConfig {

    /* renamed from: a, reason: from kotlin metadata */
    public final Application application;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean enableBnpl;

    /* renamed from: c, reason: from kotlin metadata */
    public final SPayStage stage;

    /* renamed from: d, reason: from kotlin metadata */
    public final SPayHelperConfig helperConfig;

    /* renamed from: e, reason: from kotlin metadata */
    public final boolean resultViewNeeded;

    /* renamed from: f, reason: from kotlin metadata */
    public final boolean enableLogging;

    /* renamed from: g, reason: from kotlin metadata */
    public final Function1<InitializationResult, Unit> initializationResult;

    /* JADX WARN: Multi-variable type inference failed */
    public SPaySdkInitConfig(Application application, boolean z, SPayStage stage, SPayHelperConfig helperConfig, boolean z2, boolean z3, Function1<? super InitializationResult, Unit> initializationResult) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(helperConfig, "helperConfig");
        Intrinsics.checkNotNullParameter(initializationResult, "initializationResult");
        this.application = application;
        this.enableBnpl = z;
        this.stage = stage;
        this.helperConfig = helperConfig;
        this.resultViewNeeded = z2;
        this.enableLogging = z3;
        this.initializationResult = initializationResult;
    }

    public static /* synthetic */ SPaySdkInitConfig copy$default(SPaySdkInitConfig sPaySdkInitConfig, Application application, boolean z, SPayStage sPayStage, SPayHelperConfig sPayHelperConfig, boolean z2, boolean z3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            application = sPaySdkInitConfig.application;
        }
        if ((i & 2) != 0) {
            z = sPaySdkInitConfig.enableBnpl;
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            sPayStage = sPaySdkInitConfig.stage;
        }
        SPayStage sPayStage2 = sPayStage;
        if ((i & 8) != 0) {
            sPayHelperConfig = sPaySdkInitConfig.helperConfig;
        }
        SPayHelperConfig sPayHelperConfig2 = sPayHelperConfig;
        if ((i & 16) != 0) {
            z2 = sPaySdkInitConfig.resultViewNeeded;
        }
        boolean z5 = z2;
        if ((i & 32) != 0) {
            z3 = sPaySdkInitConfig.enableLogging;
        }
        boolean z6 = z3;
        if ((i & 64) != 0) {
            function1 = sPaySdkInitConfig.initializationResult;
        }
        return sPaySdkInitConfig.copy(application, z4, sPayStage2, sPayHelperConfig2, z5, z6, function1);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableBnpl() {
        return this.enableBnpl;
    }

    /* renamed from: component3, reason: from getter */
    public final SPayStage getStage() {
        return this.stage;
    }

    /* renamed from: component4, reason: from getter */
    public final SPayHelperConfig getHelperConfig() {
        return this.helperConfig;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getResultViewNeeded() {
        return this.resultViewNeeded;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getEnableLogging() {
        return this.enableLogging;
    }

    public final Function1<InitializationResult, Unit> component7() {
        return this.initializationResult;
    }

    public final SPaySdkInitConfig copy(Application application, boolean enableBnpl, SPayStage stage, SPayHelperConfig helperConfig, boolean resultViewNeeded, boolean enableLogging, Function1<? super InitializationResult, Unit> initializationResult) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(helperConfig, "helperConfig");
        Intrinsics.checkNotNullParameter(initializationResult, "initializationResult");
        return new SPaySdkInitConfig(application, enableBnpl, stage, helperConfig, resultViewNeeded, enableLogging, initializationResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SPaySdkInitConfig)) {
            return false;
        }
        SPaySdkInitConfig sPaySdkInitConfig = (SPaySdkInitConfig) other;
        return Intrinsics.areEqual(this.application, sPaySdkInitConfig.application) && this.enableBnpl == sPaySdkInitConfig.enableBnpl && this.stage == sPaySdkInitConfig.stage && Intrinsics.areEqual(this.helperConfig, sPaySdkInitConfig.helperConfig) && this.resultViewNeeded == sPaySdkInitConfig.resultViewNeeded && this.enableLogging == sPaySdkInitConfig.enableLogging && Intrinsics.areEqual(this.initializationResult, sPaySdkInitConfig.initializationResult);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final boolean getEnableBnpl() {
        return this.enableBnpl;
    }

    public final boolean getEnableLogging() {
        return this.enableLogging;
    }

    public final SPayHelperConfig getHelperConfig() {
        return this.helperConfig;
    }

    public final Function1<InitializationResult, Unit> getInitializationResult() {
        return this.initializationResult;
    }

    public final boolean getResultViewNeeded() {
        return this.resultViewNeeded;
    }

    public final SPayStage getStage() {
        return this.stage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.application.hashCode() * 31;
        boolean z = this.enableBnpl;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int iHashCode2 = (this.helperConfig.hashCode() + ((this.stage.hashCode() + ((iHashCode + i) * 31)) * 31)) * 31;
        boolean z2 = this.resultViewNeeded;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode2 + i2) * 31;
        boolean z3 = this.enableLogging;
        return this.initializationResult.hashCode() + ((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31);
    }

    public String toString() {
        return "SPaySdkInitConfig(application=" + this.application + ", enableBnpl=" + this.enableBnpl + ", stage=" + this.stage + ", helperConfig=" + this.helperConfig + ", resultViewNeeded=" + this.resultViewNeeded + ", enableLogging=" + this.enableLogging + ", initializationResult=" + this.initializationResult + ')';
    }

    public /* synthetic */ SPaySdkInitConfig(Application application, boolean z, SPayStage sPayStage, SPayHelperConfig sPayHelperConfig, boolean z2, boolean z3, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? false : z, sPayStage, (i & 8) != 0 ? new SPayHelperConfig(true, CollectionsKt.emptyList()) : sPayHelperConfig, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? true : z3, function1);
    }
}
