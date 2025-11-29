package androidx.navigation.compose;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: NavHostController.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0005\u001a\u00020\u00042\"\u0010\u0003\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u0000\"\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\f\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigators", "Landroidx/navigation/NavHostController;", "rememberNavController", "([Landroidx/navigation/Navigator;Landroidx/compose/runtime/Composer;I)Landroidx/navigation/NavHostController;", "Landroid/content/Context;", "context", "createNavController", "(Landroid/content/Context;)Landroidx/navigation/NavHostController;", "Landroidx/compose/runtime/saveable/Saver;", "NavControllerSaver", "(Landroid/content/Context;)Landroidx/compose/runtime/saveable/Saver;", "navigation-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavHostControllerKt {
    public static final NavHostController rememberNavController(Navigator<? extends NavDestination>[] navigatorArr, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-312215566, i, -1, "androidx.navigation.compose.rememberNavController (NavHostController.kt:57)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object[] objArrCopyOf = Arrays.copyOf(navigatorArr, navigatorArr.length);
        Saver<NavHostController, ?> saverNavControllerSaver = NavControllerSaver(context);
        boolean zChangedInstance = composer.changedInstance(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<NavHostController>() { // from class: androidx.navigation.compose.NavHostControllerKt$rememberNavController$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final NavHostController invoke() {
                    return NavHostControllerKt.createNavController(context);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        NavHostController navHostController = (NavHostController) RememberSaveableKt.rememberSaveable(objArrCopyOf, saverNavControllerSaver, null, (Function0) objRememberedValue, composer, 0, 4);
        for (Navigator<? extends NavDestination> navigator : navigatorArr) {
            navHostController.get_navigatorProvider().addNavigator(navigator);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return navHostController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavHostController createNavController(Context context) {
        NavHostController navHostController = new NavHostController(context);
        navHostController.get_navigatorProvider().addNavigator(new ComposeNavGraphNavigator(navHostController.get_navigatorProvider()));
        navHostController.get_navigatorProvider().addNavigator(new ComposeNavigator());
        navHostController.get_navigatorProvider().addNavigator(new DialogNavigator());
        return navHostController;
    }

    private static final Saver<NavHostController, ?> NavControllerSaver(final Context context) {
        return SaverKt.Saver(new Function2<SaverScope, NavHostController, Bundle>() { // from class: androidx.navigation.compose.NavHostControllerKt.NavControllerSaver.1
            @Override // kotlin.jvm.functions.Function2
            public final Bundle invoke(SaverScope saverScope, NavHostController navHostController) {
                return navHostController.saveState();
            }
        }, new Function1<Bundle, NavHostController>() { // from class: androidx.navigation.compose.NavHostControllerKt.NavControllerSaver.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavHostController invoke(Bundle bundle) {
                NavHostController navHostControllerCreateNavController = NavHostControllerKt.createNavController(context);
                navHostControllerCreateNavController.restoreState(bundle);
                return navHostControllerCreateNavController;
            }
        });
    }
}
