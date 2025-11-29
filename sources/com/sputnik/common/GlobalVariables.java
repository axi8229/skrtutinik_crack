package com.sputnik.common;

import androidx.navigation.NavController;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.Metadata;

/* compiled from: GlobalVariables.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/common/GlobalVariables;", "", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "setBlockLevel", "(I)V", "", "needNavigateToMarket", "Z", "getNeedNavigateToMarket", "()Z", "setNeedNavigateToMarket", "(Z)V", "Lcom/sputnik/common/BlockingLevel;", "<set-?>", "blockLevel", "Lcom/sputnik/common/BlockingLevel;", "getBlockLevel", "()Lcom/sputnik/common/BlockingLevel;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "bottomNavigationView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "getBottomNavigationView", "()Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "setBottomNavigationView", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;)V", "Landroidx/navigation/NavController;", "bottomController", "Landroidx/navigation/NavController;", "getBottomController", "()Landroidx/navigation/NavController;", "setBottomController", "(Landroidx/navigation/NavController;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlobalVariables {
    public static final GlobalVariables INSTANCE = new GlobalVariables();
    private static BlockingLevel blockLevel = BlockingLevel.NONE;
    private static NavController bottomController;
    private static BottomNavigationView bottomNavigationView;
    private static boolean needNavigateToMarket;

    private GlobalVariables() {
    }

    public final boolean getNeedNavigateToMarket() {
        return needNavigateToMarket;
    }

    public final void setNeedNavigateToMarket(boolean z) {
        needNavigateToMarket = z;
    }

    public final BlockingLevel getBlockLevel() {
        return blockLevel;
    }

    public final void setBlockLevel(int value) {
        blockLevel = GlobalVariablesKt.parseBlockingLevel(Integer.valueOf(value));
    }

    public final BottomNavigationView getBottomNavigationView() {
        return bottomNavigationView;
    }

    public final void setBottomNavigationView(BottomNavigationView bottomNavigationView2) {
        bottomNavigationView = bottomNavigationView2;
    }

    public final NavController getBottomController() {
        return bottomController;
    }

    public final void setBottomController(NavController navController) {
        bottomController = navController;
    }
}
