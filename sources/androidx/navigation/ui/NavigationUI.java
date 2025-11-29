package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.ui.AppBarConfiguration;
import com.google.android.material.navigation.NavigationBarView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationUI.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0016J\u001d\u0010\u001c\u001a\u00020\b*\u00020\u00172\b\b\u0001\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/navigation/ui/NavigationUI;", "", "<init>", "()V", "Landroid/view/MenuItem;", "item", "Landroidx/navigation/NavController;", "navController", "", "onNavDestinationSelected", "(Landroid/view/MenuItem;Landroidx/navigation/NavController;)Z", "Landroidx/navigation/ui/AppBarConfiguration;", "configuration", "navigateUp", "(Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)Z", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "", "setupWithNavController", "(Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)V", "Lcom/google/android/material/navigation/NavigationBarView;", "navigationBarView", "(Lcom/google/android/material/navigation/NavigationBarView;Landroidx/navigation/NavController;)V", "Landroidx/navigation/NavDestination;", "", "destId", "matchDestination$navigation_ui_release", "(Landroidx/navigation/NavDestination;I)Z", "matchDestination", "navigation-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationUI {
    public static final NavigationUI INSTANCE = new NavigationUI();

    private NavigationUI() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean onNavDestinationSelected(android.view.MenuItem r5, androidx.navigation.NavController r6) throws android.content.res.Resources.NotFoundException {
        /*
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "navController"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.navigation.NavOptions$Builder r0 = new androidx.navigation.NavOptions$Builder
            r0.<init>()
            r1 = 1
            androidx.navigation.NavOptions$Builder r0 = r0.setLaunchSingleTop(r1)
            androidx.navigation.NavOptions$Builder r0 = r0.setRestoreState(r1)
            androidx.navigation.NavDestination r2 = r6.getCurrentDestination()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.navigation.NavGraph r2 = r2.getParent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r3 = r5.getItemId()
            androidx.navigation.NavDestination r2 = r2.findNode(r3)
            boolean r2 = r2 instanceof androidx.navigation.ActivityNavigator.Destination
            if (r2 == 0) goto L4b
            int r2 = androidx.navigation.ui.R$anim.nav_default_enter_anim
            androidx.navigation.NavOptions$Builder r2 = r0.setEnterAnim(r2)
            int r3 = androidx.navigation.ui.R$anim.nav_default_exit_anim
            androidx.navigation.NavOptions$Builder r2 = r2.setExitAnim(r3)
            int r3 = androidx.navigation.ui.R$anim.nav_default_pop_enter_anim
            androidx.navigation.NavOptions$Builder r2 = r2.setPopEnterAnim(r3)
            int r3 = androidx.navigation.ui.R$anim.nav_default_pop_exit_anim
            r2.setPopExitAnim(r3)
            goto L62
        L4b:
            int r2 = androidx.navigation.ui.R$animator.nav_default_enter_anim
            androidx.navigation.NavOptions$Builder r2 = r0.setEnterAnim(r2)
            int r3 = androidx.navigation.ui.R$animator.nav_default_exit_anim
            androidx.navigation.NavOptions$Builder r2 = r2.setExitAnim(r3)
            int r3 = androidx.navigation.ui.R$animator.nav_default_pop_enter_anim
            androidx.navigation.NavOptions$Builder r2 = r2.setPopEnterAnim(r3)
            int r3 = androidx.navigation.ui.R$animator.nav_default_pop_exit_anim
            r2.setPopExitAnim(r3)
        L62:
            int r2 = r5.getOrder()
            r3 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 & r3
            r3 = 0
            if (r2 != 0) goto L7d
            androidx.navigation.NavGraph$Companion r2 = androidx.navigation.NavGraph.INSTANCE
            androidx.navigation.NavGraph r4 = r6.getGraph()
            androidx.navigation.NavDestination r2 = r2.findStartDestination(r4)
            int r2 = r2.getId()
            r0.setPopUpTo(r2, r3, r1)
        L7d:
            androidx.navigation.NavOptions r0 = r0.build()
            int r2 = r5.getItemId()     // Catch: java.lang.IllegalArgumentException -> L9c
            r4 = 0
            r6.navigate(r2, r4, r0)     // Catch: java.lang.IllegalArgumentException -> L9c
            androidx.navigation.NavDestination r0 = r6.getCurrentDestination()     // Catch: java.lang.IllegalArgumentException -> L9c
            if (r0 == 0) goto L9a
            int r2 = r5.getItemId()     // Catch: java.lang.IllegalArgumentException -> L9c
            boolean r5 = matchDestination$navigation_ui_release(r0, r2)     // Catch: java.lang.IllegalArgumentException -> L9c
            if (r5 != r1) goto L9a
            goto L9e
        L9a:
            r1 = r3
            goto L9e
        L9c:
            r0 = move-exception
            goto La0
        L9e:
            r3 = r1
            goto Ld0
        La0:
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.INSTANCE
            android.content.Context r2 = r6.getContext()
            int r5 = r5.getItemId()
            java.lang.String r5 = r1.getDisplayName(r2, r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Ignoring onNavDestinationSelected for MenuItem "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " as it cannot be found from the current destination "
            r1.append(r5)
            androidx.navigation.NavDestination r5 = r6.getCurrentDestination()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r6 = "NavigationUI"
            android.util.Log.i(r6, r5, r0)
        Ld0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.NavigationUI.onNavDestinationSelected(android.view.MenuItem, androidx.navigation.NavController):boolean");
    }

    @JvmStatic
    public static final boolean navigateUp(NavController navController, AppBarConfiguration configuration) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Openable openableLayout = configuration.getOpenableLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        if (openableLayout != null && currentDestination != null && configuration.isTopLevelDestination(currentDestination)) {
            openableLayout.open();
            return true;
        }
        if (navController.navigateUp()) {
            return true;
        }
        AppBarConfiguration.OnNavigateUpListener fallbackOnNavigateUpListener = configuration.getFallbackOnNavigateUpListener();
        if (fallbackOnNavigateUpListener != null) {
            return fallbackOnNavigateUpListener.onNavigateUp();
        }
        return false;
    }

    public static /* synthetic */ void setupWithNavController$default(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    @JvmStatic
    public static final void setupWithNavController(Toolbar toolbar, final NavController navController, final AppBarConfiguration configuration) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, configuration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.NavigationUI$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationUI.setupWithNavController$lambda$1(navController, configuration, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupWithNavController$lambda$1(NavController navController, AppBarConfiguration configuration, View view) {
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(configuration, "$configuration");
        navigateUp(navController, configuration);
    }

    @JvmStatic
    public static final void setupWithNavController(NavigationBarView navigationBarView, final NavController navController) {
        Intrinsics.checkNotNullParameter(navigationBarView, "navigationBarView");
        Intrinsics.checkNotNullParameter(navController, "navController");
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: androidx.navigation.ui.NavigationUI$$ExternalSyntheticLambda1
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return NavigationUI.setupWithNavController$lambda$6(navController, menuItem);
            }
        });
        final WeakReference weakReference = new WeakReference(navigationBarView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.setupWithNavController.9
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                Intrinsics.checkNotNullParameter(destination, "destination");
                NavigationBarView navigationBarView2 = weakReference.get();
                if (navigationBarView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                if (destination instanceof FloatingWindow) {
                    return;
                }
                Menu menu = navigationBarView2.getMenu();
                Intrinsics.checkNotNullExpressionValue(menu, "view.menu");
                int size = menu.size();
                for (int i = 0; i < size; i++) {
                    MenuItem item = menu.getItem(i);
                    Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
                    if (NavigationUI.matchDestination$navigation_ui_release(destination, item.getItemId())) {
                        item.setChecked(true);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$6(NavController navController, MenuItem item) {
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(item, "item");
        return onNavDestinationSelected(item, navController);
    }

    @JvmStatic
    public static final boolean matchDestination$navigation_ui_release(NavDestination navDestination, int i) {
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(navDestination).iterator();
        while (it.hasNext()) {
            if (it.next().getId() == i) {
                return true;
            }
        }
        return false;
    }
}
