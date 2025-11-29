package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.NavDeepLink;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: NavDeepLink.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b)\u0018\u0000 u2\u00020\u0001:\u0004vuwxB'\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ5\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0002¢\u0006\u0004\b \u0010!JC\u0010&\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0002¢\u0006\u0004\b&\u0010'J1\u0010+\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b+\u0010,J3\u0010-\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u00100J\u001b\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$01H\u0002¢\u0006\u0004\b2\u00103J#\u00105\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u000104H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u000eH\u0002¢\u0006\u0004\b7\u00100J\u0017\u00109\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b9\u0010:J/\u0010;\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0007¢\u0006\u0004\b;\u0010<J/\u0010>\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0000¢\u0006\u0004\b=\u0010<J\u0019\u0010B\u001a\u0002082\b\u0010?\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0004\b@\u0010AJ\u001a\u0010D\u001a\u00020\u001b2\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u000208H\u0016¢\u0006\u0004\bF\u0010GR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010H\u001a\u0004\bI\u0010JR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010H\u001a\u0004\bK\u0010JR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010H\u001a\u0004\bL\u0010JR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010HR\u001d\u0010U\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001b\u0010W\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010R\u001a\u0004\bW\u0010XR'\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010R\u001a\u0004\bZ\u00103R\u0016\u0010\\\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R/\u0010`\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010R\u001a\u0004\b_\u00106R!\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010R\u001a\u0004\bb\u0010cR\u001d\u0010g\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010R\u001a\u0004\bf\u0010JR\u001d\u0010j\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010R\u001a\u0004\bi\u0010TR\u0018\u0010k\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010HR\u001d\u0010n\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010R\u001a\u0004\bm\u0010TR*\u0010p\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020\u001b8G@@X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010]\u001a\u0004\bp\u0010X\"\u0004\bq\u0010rR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bs\u0010c¨\u0006y"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "", "uriPattern", "action", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "uri", "", "args", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "uriRegex", "", "buildRegex", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/StringBuilder;)V", "fragment", "Landroid/os/Bundle;", "bundle", "", "Landroidx/navigation/NavArgument;", "arguments", "getMatchingUriFragment", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/util/Map;)V", "Ljava/util/regex/Matcher;", "matcher", "", "getMatchingPathArguments", "(Ljava/util/regex/Matcher;Landroid/os/Bundle;Ljava/util/Map;)Z", "Landroid/net/Uri;", "deepLink", "getMatchingQueryArguments", "(Landroid/net/Uri;Landroid/os/Bundle;Ljava/util/Map;)Z", "", "inputParams", "Landroidx/navigation/NavDeepLink$ParamQuery;", "storedParam", "parseInputParams", "(Ljava/util/List;Landroidx/navigation/NavDeepLink$ParamQuery;Landroid/os/Bundle;Ljava/util/Map;)Z", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "argument", "parseArgument", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "parseArgumentForRepeatedParam", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/NavArgument;)Z", "parsePath", "()V", "", "parseQuery", "()Ljava/util/Map;", "Lkotlin/Pair;", "parseFragment", "()Lkotlin/Pair;", "parseMime", "", "getMimeTypeMatchRating", "(Ljava/lang/String;)I", "getMatchingArguments", "(Landroid/net/Uri;Ljava/util/Map;)Landroid/os/Bundle;", "getMatchingPathAndQueryArgs$navigation_common_release", "getMatchingPathAndQueryArgs", "requestedLink", "calculateMatchingPathSegments$navigation_common_release", "(Landroid/net/Uri;)I", "calculateMatchingPathSegments", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getUriPattern", "()Ljava/lang/String;", "getAction", "getMimeType", "pathArgs", "Ljava/util/List;", "pathRegex", "Ljava/util/regex/Pattern;", "pathPattern$delegate", "Lkotlin/Lazy;", "getPathPattern", "()Ljava/util/regex/Pattern;", "pathPattern", "isParameterizedQuery$delegate", "isParameterizedQuery", "()Z", "queryArgsMap$delegate", "getQueryArgsMap", "queryArgsMap", "isSingleQueryParamValueOnly", "Z", "fragArgsAndRegex$delegate", "getFragArgsAndRegex", "fragArgsAndRegex", "fragArgs$delegate", "getFragArgs", "()Ljava/util/List;", "fragArgs", "fragRegex$delegate", "getFragRegex", "fragRegex", "fragPattern$delegate", "getFragPattern", "fragPattern", "mimeTypeRegex", "mimeTypePattern$delegate", "getMimeTypePattern", "mimeTypePattern", "<set-?>", "isExactDeepLink", "setExactDeepLink$navigation_common_release", "(Z)V", "getArgumentsNames$navigation_common_release", "argumentsNames", "Companion", "Builder", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavDeepLink {
    private final String action;

    /* renamed from: fragArgs$delegate, reason: from kotlin metadata */
    private final Lazy fragArgs;

    /* renamed from: fragArgsAndRegex$delegate, reason: from kotlin metadata */
    private final Lazy fragArgsAndRegex;

    /* renamed from: fragPattern$delegate, reason: from kotlin metadata */
    private final Lazy fragPattern;

    /* renamed from: fragRegex$delegate, reason: from kotlin metadata */
    private final Lazy fragRegex;
    private boolean isExactDeepLink;
    private boolean isSingleQueryParamValueOnly;
    private final String mimeType;

    /* renamed from: mimeTypePattern$delegate, reason: from kotlin metadata */
    private final Lazy mimeTypePattern;
    private String mimeTypeRegex;
    private String pathRegex;

    /* renamed from: queryArgsMap$delegate, reason: from kotlin metadata */
    private final Lazy queryArgsMap;
    private final String uriPattern;
    private static final Companion Companion = new Companion(null);
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private static final Pattern FILL_IN_PATTERN = Pattern.compile("\\{(.+?)\\}");
    private final List<String> pathArgs = new ArrayList();

    /* renamed from: pathPattern$delegate, reason: from kotlin metadata */
    private final Lazy pathPattern = LazyKt.lazy(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$pathPattern$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Pattern invoke() {
            String str = this.this$0.pathRegex;
            if (str != null) {
                return Pattern.compile(str, 2);
            }
            return null;
        }
    });

    /* renamed from: isParameterizedQuery$delegate, reason: from kotlin metadata */
    private final Lazy isParameterizedQuery = LazyKt.lazy(new Function0<Boolean>() { // from class: androidx.navigation.NavDeepLink.isParameterizedQuery.2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf((NavDeepLink.this.getUriPattern() == null || Uri.parse(NavDeepLink.this.getUriPattern()).getQuery() == null) ? false : true);
        }
    });

    public NavDeepLink(String str, String str2, String str3) {
        this.uriPattern = str;
        this.action = str2;
        this.mimeType = str3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.queryArgsMap = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Map<String, ParamQuery>>() { // from class: androidx.navigation.NavDeepLink$queryArgsMap$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, NavDeepLink.ParamQuery> invoke() {
                return this.this$0.parseQuery();
            }
        });
        this.fragArgsAndRegex = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Pair<? extends List<String>, ? extends String>>() { // from class: androidx.navigation.NavDeepLink$fragArgsAndRegex$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pair<? extends List<String>, ? extends String> invoke() {
                return this.this$0.parseFragment();
            }
        });
        this.fragArgs = LazyKt.lazy(lazyThreadSafetyMode, new Function0<List<String>>() { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<String> invoke() {
                List<String> list;
                Pair fragArgsAndRegex = this.this$0.getFragArgsAndRegex();
                return (fragArgsAndRegex == null || (list = (List) fragArgsAndRegex.getFirst()) == null) ? new ArrayList() : list;
            }
        });
        this.fragRegex = LazyKt.lazy(lazyThreadSafetyMode, new Function0<String>() { // from class: androidx.navigation.NavDeepLink$fragRegex$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Pair fragArgsAndRegex = this.this$0.getFragArgsAndRegex();
                if (fragArgsAndRegex != null) {
                    return (String) fragArgsAndRegex.getSecond();
                }
                return null;
            }
        });
        this.fragPattern = LazyKt.lazy(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$fragPattern$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pattern invoke() {
                String fragRegex = this.this$0.getFragRegex();
                if (fragRegex != null) {
                    return Pattern.compile(fragRegex, 2);
                }
                return null;
            }
        });
        this.mimeTypePattern = LazyKt.lazy(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$mimeTypePattern$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pattern invoke() {
                String str4 = this.this$0.mimeTypeRegex;
                if (str4 != null) {
                    return Pattern.compile(str4);
                }
                return null;
            }
        });
        parsePath();
        parseMime();
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    private final Pattern getPathPattern() {
        return (Pattern) this.pathPattern.getValue();
    }

    private final boolean isParameterizedQuery() {
        return ((Boolean) this.isParameterizedQuery.getValue()).booleanValue();
    }

    private final Map<String, ParamQuery> getQueryArgsMap() {
        return (Map) this.queryArgsMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<String>, String> getFragArgsAndRegex() {
        return (Pair) this.fragArgsAndRegex.getValue();
    }

    private final List<String> getFragArgs() {
        return (List) this.fragArgs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFragRegex() {
        return (String) this.fragRegex.getValue();
    }

    private final Pattern getFragPattern() {
        return (Pattern) this.fragPattern.getValue();
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern.getValue();
    }

    public final List<String> getArgumentsNames$navigation_common_release() {
        List<String> list = this.pathArgs;
        Collection<ParamQuery> collectionValues = getQueryArgsMap().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((ParamQuery) it.next()).getArguments());
        }
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) list, (Iterable) arrayList), (Iterable) getFragArgs());
    }

    /* renamed from: isExactDeepLink, reason: from getter */
    public final boolean getIsExactDeepLink() {
        return this.isExactDeepLink;
    }

    private final void buildRegex(String uri, List<String> args, StringBuilder uriRegex) {
        Matcher matcher = FILL_IN_PATTERN.matcher(uri);
        int iEnd = 0;
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            Intrinsics.checkNotNull(strGroup, "null cannot be cast to non-null type kotlin.String");
            args.add(strGroup);
            if (matcher.start() > iEnd) {
                String strSubstring = uri.substring(iEnd, matcher.start());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                uriRegex.append(Pattern.quote(strSubstring));
            }
            uriRegex.append("([^/]*?|)");
            iEnd = matcher.end();
        }
        if (iEnd < uri.length()) {
            String strSubstring2 = uri.substring(iEnd);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            uriRegex.append(Pattern.quote(strSubstring2));
        }
    }

    public final int getMimeTypeMatchRating(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (this.mimeType != null) {
            Pattern mimeTypePattern = getMimeTypePattern();
            Intrinsics.checkNotNull(mimeTypePattern);
            if (mimeTypePattern.matcher(mimeType).matches()) {
                return new MimeType(this.mimeType).compareTo(new MimeType(mimeType));
            }
        }
        return -1;
    }

    public final Bundle getMatchingArguments(Uri deepLink, Map<String, NavArgument> arguments) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Pattern pathPattern = getPathPattern();
        Matcher matcher = pathPattern != null ? pathPattern.matcher(deepLink.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        final Bundle bundle = new Bundle();
        if (!getMatchingPathArguments(matcher, bundle, arguments)) {
            return null;
        }
        if (isParameterizedQuery() && !getMatchingQueryArguments(deepLink, bundle, arguments)) {
            return null;
        }
        getMatchingUriFragment(deepLink.getFragment(), bundle, arguments);
        if (NavArgumentKt.missingRequiredArguments(arguments, new Function1<String, Boolean>() { // from class: androidx.navigation.NavDeepLink$getMatchingArguments$missingRequiredArguments$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String argName) {
                Intrinsics.checkNotNullParameter(argName, "argName");
                return Boolean.valueOf(!bundle.containsKey(argName));
            }
        }).isEmpty()) {
            return bundle;
        }
        return null;
    }

    public final Bundle getMatchingPathAndQueryArgs$navigation_common_release(Uri deepLink, Map<String, NavArgument> arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Bundle bundle = new Bundle();
        if (deepLink == null) {
            return bundle;
        }
        Pattern pathPattern = getPathPattern();
        Matcher matcher = pathPattern != null ? pathPattern.matcher(deepLink.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return bundle;
        }
        getMatchingPathArguments(matcher, bundle, arguments);
        if (isParameterizedQuery()) {
            getMatchingQueryArguments(deepLink, bundle, arguments);
        }
        return bundle;
    }

    private final void getMatchingUriFragment(String fragment, Bundle bundle, Map<String, NavArgument> arguments) {
        Pattern fragPattern = getFragPattern();
        Matcher matcher = fragPattern != null ? fragPattern.matcher(String.valueOf(fragment)) : null;
        if (matcher != null && matcher.matches()) {
            List<String> fragArgs = getFragArgs();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fragArgs, 10));
            int i = 0;
            for (Object obj : fragArgs) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                String value = Uri.decode(matcher.group(i2));
                NavArgument navArgument = arguments.get(str);
                try {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    parseArgument(bundle, str, value, navArgument);
                    arrayList.add(Unit.INSTANCE);
                    i = i2;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
    }

    private final boolean getMatchingPathArguments(Matcher matcher, Bundle bundle, Map<String, NavArgument> arguments) {
        List<String> list = this.pathArgs;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            String value = Uri.decode(matcher.group(i2));
            NavArgument navArgument = arguments.get(str);
            try {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                parseArgument(bundle, str, value, navArgument);
                arrayList.add(Unit.INSTANCE);
                i = i2;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    private final boolean getMatchingQueryArguments(Uri deepLink, Bundle bundle, Map<String, NavArgument> arguments) {
        String query;
        for (Map.Entry<String, ParamQuery> entry : getQueryArgsMap().entrySet()) {
            String key = entry.getKey();
            ParamQuery value = entry.getValue();
            List<String> inputParams = deepLink.getQueryParameters(key);
            if (this.isSingleQueryParamValueOnly && (query = deepLink.getQuery()) != null && !Intrinsics.areEqual(query, deepLink.toString())) {
                inputParams = CollectionsKt.listOf(query);
            }
            Intrinsics.checkNotNullExpressionValue(inputParams, "inputParams");
            if (!parseInputParams(inputParams, value, bundle, arguments)) {
                return false;
            }
        }
        return true;
    }

    private final boolean parseInputParams(List<String> inputParams, ParamQuery storedParam, Bundle bundle, Map<String, NavArgument> arguments) {
        Object objValueOf;
        Bundle bundleBundleOf = BundleKt.bundleOf(new Pair[0]);
        Iterator<T> it = storedParam.getArguments().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            NavArgument navArgument = arguments.get(str);
            NavType<Object> type = navArgument != null ? navArgument.getType() : null;
            if ((type instanceof CollectionNavType) && !navArgument.getIsDefaultValuePresent()) {
                type.put(bundleBundleOf, str, ((CollectionNavType) type).emptyCollection());
            }
        }
        for (String str2 : inputParams) {
            String paramRegex = storedParam.getParamRegex();
            Matcher matcher = paramRegex != null ? Pattern.compile(paramRegex, 32).matcher(str2) : null;
            if (matcher == null || !matcher.matches()) {
                return false;
            }
            List<String> arguments2 = storedParam.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments2, 10));
            int i = 0;
            for (Object obj : arguments2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) obj;
                String strGroup = matcher.group(i2);
                if (strGroup == null) {
                    strGroup = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(strGroup, "argMatcher.group(index + 1) ?: \"\"");
                }
                NavArgument navArgument2 = arguments.get(str3);
                try {
                    if (!bundleBundleOf.containsKey(str3)) {
                        parseArgument(bundleBundleOf, str3, strGroup, navArgument2);
                        objValueOf = Unit.INSTANCE;
                    } else {
                        objValueOf = Boolean.valueOf(parseArgumentForRepeatedParam(bundleBundleOf, str3, strGroup, navArgument2));
                    }
                } catch (IllegalArgumentException unused) {
                    objValueOf = Unit.INSTANCE;
                }
                arrayList.add(objValueOf);
                i = i2;
            }
        }
        bundle.putAll(bundleBundleOf);
        return true;
    }

    public final int calculateMatchingPathSegments$navigation_common_release(Uri requestedLink) {
        if (requestedLink == null || this.uriPattern == null) {
            return 0;
        }
        List<String> requestedPathSegments = requestedLink.getPathSegments();
        List<String> uriPathSegments = Uri.parse(this.uriPattern).getPathSegments();
        Intrinsics.checkNotNullExpressionValue(requestedPathSegments, "requestedPathSegments");
        Intrinsics.checkNotNullExpressionValue(uriPathSegments, "uriPathSegments");
        return CollectionsKt.intersect(requestedPathSegments, uriPathSegments).size();
    }

    private final void parseArgument(Bundle bundle, String name, String value, NavArgument argument) {
        if (argument != null) {
            argument.getType().parseAndPut(bundle, name, value);
        } else {
            bundle.putString(name, value);
        }
    }

    private final boolean parseArgumentForRepeatedParam(Bundle bundle, String name, String value, NavArgument argument) {
        if (!bundle.containsKey(name)) {
            return true;
        }
        if (argument == null) {
            return false;
        }
        NavType<Object> type = argument.getType();
        type.parseAndPut(bundle, name, value, type.get(bundle, name));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavDeepLink.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "addArgumentName", "(Ljava/lang/String;)V", "paramRegex", "Ljava/lang/String;", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", "", "arguments", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ParamQuery {
        private final List<String> arguments = new ArrayList();
        private String paramRegex;

        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(String str) {
            this.paramRegex = str;
        }

        public final List<String> getArguments() {
            return this.arguments;
        }

        public final void addArgumentName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.arguments.add(name);
        }
    }

    /* compiled from: NavDeepLink.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "", "mimeType", "<init>", "(Ljava/lang/String;)V", "other", "", "compareTo", "(Landroidx/navigation/NavDeepLink$MimeType;)I", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "subType", "getSubType", "setSubType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MimeType implements Comparable<MimeType> {
        private String subType;
        private String type;

        public MimeType(String mimeType) {
            List listEmptyList;
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            List<String> listSplit = new Regex("/").split(mimeType, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            this.type = (String) listEmptyList.get(0);
            this.subType = (String) listEmptyList.get(1);
        }

        public final String getType() {
            return this.type;
        }

        public final String getSubType() {
            return this.subType;
        }

        @Override // java.lang.Comparable
        public int compareTo(MimeType other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int i = Intrinsics.areEqual(this.type, other.type) ? 2 : 0;
            return Intrinsics.areEqual(this.subType, other.subType) ? i + 1 : i;
        }
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) other;
        return Intrinsics.areEqual(this.uriPattern, navDeepLink.uriPattern) && Intrinsics.areEqual(this.action, navDeepLink.action) && Intrinsics.areEqual(this.mimeType, navDeepLink.mimeType);
    }

    public int hashCode() {
        String str = this.uriPattern;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.action;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mimeType;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    /* compiled from: NavDeepLink.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0017¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0007J\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "<init>", "()V", "", "uriPattern", "setUriPattern", "(Ljava/lang/String;)Landroidx/navigation/NavDeepLink$Builder;", "action", "setAction", "mimeType", "setMimeType", "Landroidx/navigation/NavDeepLink;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Landroidx/navigation/NavDeepLink;", "Ljava/lang/String;", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private String action;
        private String mimeType;
        private String uriPattern;

        public final Builder setUriPattern(String uriPattern) {
            Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
            this.uriPattern = uriPattern;
            return this;
        }

        public final Builder setAction(String action) {
            Intrinsics.checkNotNullParameter(action, "action");
            if (action.length() <= 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.action = action;
            return this;
        }

        public final Builder setMimeType(String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.mimeType = mimeType;
            return this;
        }

        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }
    }

    /* compiled from: NavDeepLink.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "FILL_IN_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "SCHEME_PATTERN", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void parsePath() {
        if (this.uriPattern == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("^");
        if (!SCHEME_PATTERN.matcher(this.uriPattern).find()) {
            sb.append("http[s]?://");
        }
        Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(this.uriPattern);
        matcher.find();
        boolean z = false;
        String strSubstring = this.uriPattern.substring(0, matcher.start());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        buildRegex(strSubstring, this.pathArgs, sb);
        if (!StringsKt.contains$default((CharSequence) sb, (CharSequence) ".*", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) sb, (CharSequence) "([^/]+?)", false, 2, (Object) null)) {
            z = true;
        }
        this.isExactDeepLink = z;
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uriRegex.toString()");
        this.pathRegex = StringsKt.replace$default(string, ".*", "\\E.*\\Q", false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, ParamQuery> parseQuery() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!isParameterizedQuery()) {
            return linkedHashMap;
        }
        Uri uri = Uri.parse(this.uriPattern);
        for (String paramName : uri.getQueryParameterNames()) {
            StringBuilder sb = new StringBuilder();
            List<String> queryParams = uri.getQueryParameters(paramName);
            if (queryParams.size() > 1) {
                throw new IllegalArgumentException(("Query parameter " + paramName + " must only be present once in " + this.uriPattern + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
            }
            Intrinsics.checkNotNullExpressionValue(queryParams, "queryParams");
            String queryParam = (String) CollectionsKt.firstOrNull((List) queryParams);
            if (queryParam == null) {
                this.isSingleQueryParamValueOnly = true;
                queryParam = paramName;
            }
            Matcher matcher = FILL_IN_PATTERN.matcher(queryParam);
            ParamQuery paramQuery = new ParamQuery();
            int iEnd = 0;
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                Intrinsics.checkNotNull(strGroup, "null cannot be cast to non-null type kotlin.String");
                paramQuery.addArgumentName(strGroup);
                Intrinsics.checkNotNullExpressionValue(queryParam, "queryParam");
                String strSubstring = queryParam.substring(iEnd, matcher.start());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                sb.append(Pattern.quote(strSubstring));
                sb.append("(.+?)?");
                iEnd = matcher.end();
            }
            if (iEnd < queryParam.length()) {
                Intrinsics.checkNotNullExpressionValue(queryParam, "queryParam");
                String strSubstring2 = queryParam.substring(iEnd);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                sb.append(Pattern.quote(strSubstring2));
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "argRegex.toString()");
            paramQuery.setParamRegex(StringsKt.replace$default(string, ".*", "\\E.*\\Q", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(paramName, "paramName");
            linkedHashMap.put(paramName, paramQuery);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<String>, String> parseFragment() {
        String str = this.uriPattern;
        if (str == null || Uri.parse(str).getFragment() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fragment = Uri.parse(this.uriPattern).getFragment();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(fragment);
        buildRegex(fragment, arrayList, sb);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "fragRegex.toString()");
        return TuplesKt.to(arrayList, string);
    }

    private final void parseMime() {
        if (this.mimeType == null) {
            return;
        }
        if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
            throw new IllegalArgumentException(("The given mimeType " + this.mimeType + " does not match to required \"type/subtype\" format").toString());
        }
        MimeType mimeType = new MimeType(this.mimeType);
        this.mimeTypeRegex = StringsKt.replace$default("^(" + mimeType.getType() + "|[*]+)/(" + mimeType.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
    }
}
