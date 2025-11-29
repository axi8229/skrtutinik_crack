package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.Navigator;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: ActivityNavigator.kt */
@Navigator.Name("activity")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "createDestination", "()Landroidx/navigation/ActivityNavigator$Destination;", "", "popBackStack", "()Z", "destination", "Landroid/os/Bundle;", "args", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Landroidx/navigation/NavDestination;", "navigate", "(Landroidx/navigation/ActivityNavigator$Destination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "hostActivity", "Landroid/app/Activity;", "Companion", "Destination", "Extras", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class ActivityNavigator extends Navigator<Destination> {
    private final Context context;
    private final Activity hostActivity;

    public ActivityNavigator(Context context) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Iterator it = SequencesKt.generateSequence(context, new Function1<Context, Context>() { // from class: androidx.navigation.ActivityNavigator$hostActivity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2 instanceof ContextWrapper) {
                    return ((ContextWrapper) it2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Context) next) instanceof Activity) {
                    break;
                }
            }
        }
        this.hostActivity = (Activity) next;
    }

    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.navigation.Navigator
    public NavDestination navigate(Destination destination, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intent intent;
        int intExtra;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.getIntent() == null) {
            throw new IllegalStateException(("Destination " + destination.getId() + " does not have an Intent set.").toString());
        }
        Intent intent2 = new Intent(destination.getIntent());
        if (args != null) {
            intent2.putExtras(args);
            String dataPattern = destination.getDataPattern();
            if (dataPattern != null && dataPattern.length() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(dataPattern);
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    if (!args.containsKey(strGroup)) {
                        throw new IllegalArgumentException("Could not find " + strGroup + " in " + args + " to fill data pattern " + dataPattern);
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(String.valueOf(args.get(strGroup))));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        boolean z = navigatorExtras instanceof Extras;
        if (z) {
            intent2.addFlags(((Extras) navigatorExtras).getFlags());
        }
        if (this.hostActivity == null) {
            intent2.addFlags(268435456);
        }
        if (navOptions != null && navOptions.getSingleTop()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.hostActivity;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination.getId());
        Resources resources = this.context.getResources();
        if (navOptions != null) {
            int popEnterAnim = navOptions.getPopEnterAnim();
            int popExitAnim = navOptions.getPopExitAnim();
            if ((popEnterAnim <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(popEnterAnim), "animator")) && (popExitAnim <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(popExitAnim), "animator"))) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", popEnterAnim);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", popExitAnim);
            } else {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(popEnterAnim) + " and popExit resource " + resources.getResourceName(popExitAnim) + " when launching " + destination);
            }
        }
        if (z) {
            ((Extras) navigatorExtras).getActivityOptions();
            this.context.startActivity(intent2);
        } else {
            this.context.startActivity(intent2);
        }
        if (navOptions == null || this.hostActivity == null) {
            return null;
        }
        int enterAnim = navOptions.getEnterAnim();
        int exitAnim = navOptions.getExitAnim();
        if ((enterAnim <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(enterAnim), "animator")) && (exitAnim <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(exitAnim), "animator"))) {
            if (enterAnim < 0 && exitAnim < 0) {
                return null;
            }
            this.hostActivity.overridePendingTransition(RangesKt.coerceAtLeast(enterAnim, 0), RangesKt.coerceAtLeast(exitAnim, 0));
            return null;
        }
        Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(enterAnim) + " and exit resource " + resources.getResourceName(exitAnim) + "when launching " + destination);
        return null;
    }

    /* compiled from: ActivityNavigator.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010\u0012J\u0017\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0017¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010)H\u0096\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u00100\u001a\u0004\u0018\u00010\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b2\u00103R(\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u00100\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u00104\u001a\u0004\b5\u0010(R(\u00106\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u00010\u001a8F@BX\u0086\u000e¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R(\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u00100\u001a\u0004\u0018\u00010\b8F@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b:\u0010(¨\u0006;"}, d2 = {"Landroidx/navigation/ActivityNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/Navigator;", "activityNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "Landroid/content/Context;", "context", "", "pattern", "parseApplicationId", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "setIntent", "(Landroid/content/Intent;)Landroidx/navigation/ActivityNavigator$Destination;", "dataPattern", "setDataPattern", "(Ljava/lang/String;)Landroidx/navigation/ActivityNavigator$Destination;", "Landroid/util/AttributeSet;", "attrs", "", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "packageName", "setTargetPackage", "Landroid/content/ComponentName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "setComponentName", "(Landroid/content/ComponentName;)Landroidx/navigation/ActivityNavigator$Destination;", "action", "setAction", "Landroid/net/Uri;", RemoteMessageConst.DATA, "setData", "(Landroid/net/Uri;)Landroidx/navigation/ActivityNavigator$Destination;", "", "supportsActions", "()Z", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "<set-?>", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "Ljava/lang/String;", "getDataPattern", "component", "Landroid/content/ComponentName;", "getComponent", "()Landroid/content/ComponentName;", "getAction", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class Destination extends NavDestination {
        private String dataPattern;
        private Intent intent;

        @Override // androidx.navigation.NavDestination
        public boolean supportsActions() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> activityNavigator) {
            super(activityNavigator);
            Intrinsics.checkNotNullParameter(activityNavigator, "activityNavigator");
        }

        public final Intent getIntent() {
            return this.intent;
        }

        public final String getDataPattern() {
            return this.dataPattern;
        }

        public final Destination setIntent(Intent intent) {
            this.intent = intent;
            return this;
        }

        public final Destination setDataPattern(String dataPattern) {
            this.dataPattern = dataPattern;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public void onInflate(Context context, AttributeSet attrs) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            super.onInflate(context, attrs);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R$styleable.ActivityNavigator);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "context.resources.obtain…leable.ActivityNavigator)");
            setTargetPackage(parseApplicationId(context, typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_targetPackage)));
            String string = typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_android_name);
            if (string != null) {
                if (string.charAt(0) == '.') {
                    string = context.getPackageName() + string;
                }
                setComponentName(new ComponentName(context, string));
            }
            setAction(typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_action));
            String applicationId = parseApplicationId(context, typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_data));
            if (applicationId != null) {
                setData(Uri.parse(applicationId));
            }
            setDataPattern(parseApplicationId(context, typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_dataPattern)));
            typedArrayObtainAttributes.recycle();
        }

        private final String parseApplicationId(Context context, String pattern) {
            if (pattern == null) {
                return null;
            }
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            return StringsKt.replace$default(pattern, "${applicationId}", packageName, false, 4, (Object) null);
        }

        public final Destination setTargetPackage(String packageName) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            Intrinsics.checkNotNull(intent);
            intent.setPackage(packageName);
            return this;
        }

        public final ComponentName getComponent() {
            Intent intent = this.intent;
            if (intent != null) {
                return intent.getComponent();
            }
            return null;
        }

        public final Destination setComponentName(ComponentName name) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            Intrinsics.checkNotNull(intent);
            intent.setComponent(name);
            return this;
        }

        public final String getAction() {
            Intent intent = this.intent;
            if (intent != null) {
                return intent.getAction();
            }
            return null;
        }

        public final Destination setAction(String action) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            Intrinsics.checkNotNull(intent);
            intent.setAction(action);
            return this;
        }

        public final Destination setData(Uri data) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            Intrinsics.checkNotNull(intent);
            intent.setData(data);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            ComponentName component = getComponent();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                String action = getAction();
                if (action != null) {
                    sb.append(" action=");
                    sb.append(action);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
            return string;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !(other instanceof Destination)) {
                return false;
            }
            if (super.equals(other)) {
                Intent intent = this.intent;
                if ((intent != null ? intent.filterEquals(((Destination) other).intent) : ((Destination) other).intent == null) && Intrinsics.areEqual(this.dataPattern, ((Destination) other).dataPattern)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            Intent intent = this.intent;
            int iFilterHashCode = (iHashCode + (intent != null ? intent.filterHashCode() : 0)) * 31;
            String str = this.dataPattern;
            return iFilterHashCode + (str != null ? str.hashCode() : 0);
        }
    }

    /* compiled from: ActivityNavigator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "", "flags", "I", "getFlags", "()I", "Landroidx/core/app/ActivityOptionsCompat;", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "getActivityOptions", "()Landroidx/core/app/ActivityOptionsCompat;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Extras implements Navigator.Extras {
        private final int flags;

        public final ActivityOptionsCompat getActivityOptions() {
            return null;
        }

        public final int getFlags() {
            return this.flags;
        }
    }
}
