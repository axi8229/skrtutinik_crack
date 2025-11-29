package com.sputnik.common.extensions;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentNavigator;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.sputnik.common.utils.LogUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavController.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a=\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0004\u0010\r\u001a3\u0010\u0004\u001a\u00020\u000e*\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0004\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavController;", "Landroidx/navigation/NavDirections;", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "", "safeNavigate", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDirections;)V", "", "currentDestinationId", "id", "Landroid/os/Bundle;", "args", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "navExtras", "(Landroidx/navigation/NavController;IILandroid/os/Bundle;Landroidx/navigation/fragment/FragmentNavigator$Extras;)V", "", "(Landroidx/navigation/NavController;ILandroid/os/Bundle;Landroidx/navigation/fragment/FragmentNavigator$Extras;)Z", "safeNavigateUp", "(Landroidx/navigation/NavController;)V", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavControllerKt {
    public static final void safeNavigate(NavController navController, NavDirections direction) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination == null || currentDestination.getAction(direction.getActionId()) == null) {
            return;
        }
        navController.navigate(direction);
    }

    public static /* synthetic */ void safeNavigate$default(NavController navController, int i, int i2, Bundle bundle, FragmentNavigator.Extras extras, int i3, Object obj) throws Resources.NotFoundException {
        if ((i3 & 4) != 0) {
            bundle = null;
        }
        if ((i3 & 8) != 0) {
            extras = null;
        }
        safeNavigate(navController, i, i2, bundle, extras);
    }

    public static final void safeNavigate(NavController navController, int i, int i2, Bundle bundle, FragmentNavigator.Extras extras) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null && i == currentDestination.getId()) {
            navController.navigate(i2, bundle, (NavOptions) null, extras);
            return;
        }
        LogUtilsKt.writeLog("Error on safeNavigate");
        NavDestination currentDestination2 = navController.getCurrentDestination();
        LogUtilsKt.writeLog("Current destination: " + (currentDestination2 != null ? Integer.valueOf(currentDestination2.getId()) : null));
        LogUtilsKt.writeLog("Current destination: " + i);
    }

    public static /* synthetic */ boolean safeNavigate$default(NavController navController, int i, Bundle bundle, FragmentNavigator.Extras extras, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        if ((i2 & 4) != 0) {
            extras = null;
        }
        return safeNavigate(navController, i, bundle, extras);
    }

    public static final boolean safeNavigate(NavController navController, int i, Bundle bundle, FragmentNavigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        try {
            NavDestination currentDestination = navController.getCurrentDestination();
            if (currentDestination == null || currentDestination.getId() != i) {
                navController.navigate(i, bundle, (NavOptions) null, extras);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final void safeNavigateUp(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        try {
            if (navController.getPreviousBackStackEntry() != null) {
                navController.navigateUp();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
