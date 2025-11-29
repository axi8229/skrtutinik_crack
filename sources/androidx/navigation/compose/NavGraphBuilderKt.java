package androidx.navigation.compose;

import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraphBuilder;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* compiled from: NavGraphBuilder.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aÕ\u0001\u0010\u0015\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u001e\b\u0002\u0010\f\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\b2\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b2\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\b2\u001e\b\u0002\u0010\u0010\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", "", "route", "", "Landroidx/navigation/NamedNavArgument;", "arguments", "Landroidx/navigation/NavDeepLink;", "deepLinks", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "enterTransition", "Landroidx/compose/animation/ExitTransition;", "exitTransition", "popEnterTransition", "popExitTransition", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "", "content", "composable", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "navigation-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavGraphBuilderKt {
    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function4 function4, int i, Object obj) {
        List listEmptyList = (i & 2) != 0 ? CollectionsKt.emptyList() : list;
        List listEmptyList2 = (i & 4) != 0 ? CollectionsKt.emptyList() : list2;
        Function1 function15 = (i & 8) != 0 ? null : function1;
        Function1 function16 = (i & 16) != 0 ? null : function12;
        composable(navGraphBuilder, str, listEmptyList, listEmptyList2, function15, function16, (i & 32) != 0 ? function15 : function13, (i & 64) != 0 ? function16 : function14, function4);
    }

    @Deprecated
    public static final /* synthetic */ void composable(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function4 function4) {
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), str, function4);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) it.next();
            composeNavigatorDestinationBuilder.argument(namedNavArgument.getName(), namedNavArgument.getArgument());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            composeNavigatorDestinationBuilder.deepLink((NavDeepLink) it2.next());
        }
        composeNavigatorDestinationBuilder.setEnterTransition(function1);
        composeNavigatorDestinationBuilder.setExitTransition(function12);
        composeNavigatorDestinationBuilder.setPopEnterTransition(function13);
        composeNavigatorDestinationBuilder.setPopExitTransition(function14);
        navGraphBuilder.destination(composeNavigatorDestinationBuilder);
    }
}
