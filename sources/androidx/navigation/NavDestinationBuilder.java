package androidx.navigation;

import androidx.navigation.NavDestination;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavDestinationBuilder.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B-\b\u0000\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bB#\b\u0016\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\"\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/0)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010+¨\u00061"}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavDestination;", "D", "", "Landroidx/navigation/Navigator;", "navigator", "", "id", "", "route", "<init>", "(Landroidx/navigation/Navigator;ILjava/lang/String;)V", "(Landroidx/navigation/Navigator;Ljava/lang/String;)V", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroidx/navigation/NavArgument;", "argument", "", "(Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "Landroidx/navigation/NavDeepLink;", "navDeepLink", "deepLink", "(Landroidx/navigation/NavDeepLink;)V", "instantiateDestination", "()Landroidx/navigation/NavDestination;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "I", "getId", "()I", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "label", "Ljava/lang/CharSequence;", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "", "arguments", "Ljava/util/Map;", "", "deepLinks", "Ljava/util/List;", "Landroidx/navigation/NavAction;", "actions", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NavDestinationBuilder<D extends NavDestination> {
    private Map<Integer, NavAction> actions;
    private Map<String, NavArgument> arguments;
    private List<NavDeepLink> deepLinks;
    private final int id;
    private CharSequence label;
    private final Navigator<? extends D> navigator;
    private final String route;

    public NavDestinationBuilder(Navigator<? extends D> navigator, int i, String str) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        this.navigator = navigator;
        this.id = i;
        this.route = str;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    public final String getRoute() {
        return this.route;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDestinationBuilder(Navigator<? extends D> navigator, String str) {
        this(navigator, -1, str);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    public final void argument(String name, NavArgument argument) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.arguments.put(name, argument);
    }

    public final void deepLink(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.deepLinks.add(navDeepLink);
    }

    protected D instantiateDestination() {
        return (D) this.navigator.createDestination();
    }

    public D build() {
        D d = (D) instantiateDestination();
        d.setLabel(this.label);
        for (Map.Entry<String, NavArgument> entry : this.arguments.entrySet()) {
            d.addArgument(entry.getKey(), entry.getValue());
        }
        Iterator<T> it = this.deepLinks.iterator();
        while (it.hasNext()) {
            d.addDeepLink((NavDeepLink) it.next());
        }
        for (Map.Entry<Integer, NavAction> entry2 : this.actions.entrySet()) {
            d.putAction(entry2.getKey().intValue(), entry2.getValue());
        }
        String str = this.route;
        if (str != null) {
            d.setRoute(str);
        }
        int i = this.id;
        if (i != -1) {
            d.setId(i);
        }
        return d;
    }
}
