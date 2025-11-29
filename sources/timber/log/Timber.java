package timber.log;

import android.os.Build;
import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Timber.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Ltimber/log/Timber;", "", "()V", "DebugTree", "Forest", "Tree", "timber_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class Timber {

    /* renamed from: Forest, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ArrayList<Tree> trees = new ArrayList<>();
    private static volatile Tree[] treeArray = new Tree[0];

    @JvmStatic
    public static void d(String str, Object... objArr) {
        INSTANCE.d(str, objArr);
    }

    @JvmStatic
    public static void d(Throwable th) {
        INSTANCE.d(th);
    }

    @JvmStatic
    public static void d(Throwable th, String str, Object... objArr) {
        INSTANCE.d(th, str, objArr);
    }

    @JvmStatic
    public static void e(String str, Object... objArr) {
        INSTANCE.e(str, objArr);
    }

    @JvmStatic
    public static void e(Throwable th) {
        INSTANCE.e(th);
    }

    @JvmStatic
    public static void e(Throwable th, String str, Object... objArr) {
        INSTANCE.e(th, str, objArr);
    }

    @JvmStatic
    public static void w(String str, Object... objArr) {
        INSTANCE.w(str, objArr);
    }

    @JvmStatic
    public static void w(Throwable th) {
        INSTANCE.w(th);
    }

    private Timber() {
        throw new AssertionError();
    }

    /* compiled from: Timber.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0011\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0011\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0013J\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0014J1\u0010\u0015\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J;\u0010\u0015\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J1\u0010\u0016\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J1\u0010\u0017\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J;\u0010\u0017\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0019\u0010\u001cJ)\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\nH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H$¢\u0006\u0004\b\u001f\u0010 R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0!8@X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\b8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Ltimber/log/Timber$Tree;", "", "<init>", "()V", "", RemoteMessageConst.Notification.PRIORITY, "", "t", "", CrashHianalyticsData.MESSAGE, "", "args", "", "prepareLog", "(ILjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "getStackTraceString", "(Ljava/lang/Throwable;)Ljava/lang/String;", "d", "(Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Throwable;)V", "i", "w", "e", "", "isLoggable", "(I)Z", RemoteMessageConst.Notification.TAG, "(Ljava/lang/String;I)Z", "formatMessage", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "log", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Ljava/lang/ThreadLocal;", "explicitTag", "Ljava/lang/ThreadLocal;", "getExplicitTag$timber_release", "()Ljava/lang/ThreadLocal;", "getTag$timber_release", "()Ljava/lang/String;", "timber_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Tree {
        private final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        @Deprecated
        protected boolean isLoggable(int priority) {
            return true;
        }

        protected abstract void log(int priority, String tag, String message, Throwable t);

        /* renamed from: getExplicitTag$timber_release, reason: from getter */
        public final /* synthetic */ ThreadLocal getExplicitTag() {
            return this.explicitTag;
        }

        public /* synthetic */ String getTag$timber_release() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        public void d(String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            prepareLog(3, null, message, Arrays.copyOf(args, args.length));
        }

        public void d(Throwable t, String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            prepareLog(3, t, message, Arrays.copyOf(args, args.length));
        }

        public void d(Throwable t) {
            prepareLog(3, t, null, new Object[0]);
        }

        public void i(String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            prepareLog(4, null, message, Arrays.copyOf(args, args.length));
        }

        public void i(Throwable t, String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            prepareLog(4, t, message, Arrays.copyOf(args, args.length));
        }

        public void w(String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            prepareLog(5, null, message, Arrays.copyOf(args, args.length));
        }

        public void w(Throwable t) {
            prepareLog(5, t, null, new Object[0]);
        }

        public void e(String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            prepareLog(6, null, message, Arrays.copyOf(args, args.length));
        }

        public void e(Throwable t, String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            prepareLog(6, t, message, Arrays.copyOf(args, args.length));
        }

        public void e(Throwable t) {
            prepareLog(6, t, null, new Object[0]);
        }

        protected boolean isLoggable(String tag, int priority) {
            return isLoggable(priority);
        }

        private final void prepareLog(int priority, Throwable t, String message, Object... args) {
            String tag$timber_release = getTag$timber_release();
            if (isLoggable(tag$timber_release, priority)) {
                if (message != null && message.length() != 0) {
                    if (!(args.length == 0)) {
                        message = formatMessage(message, args);
                    }
                    if (t != null) {
                        message = ((Object) message) + '\n' + getStackTraceString(t);
                    }
                } else if (t == null) {
                    return;
                } else {
                    message = getStackTraceString(t);
                }
                log(priority, tag$timber_release, message, t);
            }
        }

        protected String formatMessage(String message, Object[] args) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(args, "args");
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str = String.format(message, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
            return str;
        }

        private final String getStackTraceString(Throwable t) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            t.printStackTrace(printWriter);
            printWriter.flush();
            String string = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(string, "sw.toString()");
            return string;
        }
    }

    /* compiled from: Timber.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Ltimber/log/Timber$DebugTree;", "Ltimber/log/Timber$Tree;", "()V", "fqcnIgnore", "", "", "kotlin.jvm.PlatformType", RemoteMessageConst.Notification.TAG, "getTag$timber_release", "()Ljava/lang/String;", "createStackElementTag", "element", "Ljava/lang/StackTraceElement;", "log", "", RemoteMessageConst.Notification.PRIORITY, "", CrashHianalyticsData.MESSAGE, "t", "", "Companion", "timber_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class DebugTree extends Tree {
        private final List<String> fqcnIgnore = CollectionsKt.listOf((Object[]) new String[]{Timber.class.getName(), Companion.class.getName(), Tree.class.getName(), DebugTree.class.getName()});
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

        @Override // timber.log.Timber.Tree
        public String getTag$timber_release() {
            String tag$timber_release = super.getTag$timber_release();
            if (tag$timber_release != null) {
                return tag$timber_release;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "Throwable().stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (!this.fqcnIgnore.contains(stackTraceElement.getClassName())) {
                    return createStackElementTag(stackTraceElement);
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        protected String createStackElementTag(StackTraceElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            String className = element.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "element.className");
            String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(className, '.', (String) null, 2, (Object) null);
            Matcher matcher = ANONYMOUS_CLASS.matcher(strSubstringAfterLast$default);
            if (matcher.find()) {
                strSubstringAfterLast$default = matcher.replaceAll("");
                Intrinsics.checkNotNullExpressionValue(strSubstringAfterLast$default, "m.replaceAll(\"\")");
            }
            if (strSubstringAfterLast$default.length() <= 23 || Build.VERSION.SDK_INT >= 26) {
                return strSubstringAfterLast$default;
            }
            String strSubstring = strSubstringAfterLast$default.substring(0, 23);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        @Override // timber.log.Timber.Tree
        protected void log(int priority, String tag, String message, Throwable t) {
            int iMin;
            Intrinsics.checkNotNullParameter(message, "message");
            if (message.length() < 4000) {
                if (priority == 7) {
                    Log.wtf(tag, message);
                    return;
                } else {
                    Log.println(priority, tag, message);
                    return;
                }
            }
            int length = message.length();
            int i = 0;
            while (i < length) {
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) message, '\n', i, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf$default, i + 4000);
                    String strSubstring = message.substring(i, iMin);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (priority == 7) {
                        Log.wtf(tag, strSubstring);
                    } else {
                        Log.println(priority, tag, strSubstring);
                    }
                    if (iMin >= iIndexOf$default) {
                        break;
                    } else {
                        i = iMin;
                    }
                }
                i = iMin + 1;
            }
        }
    }

    /* compiled from: Timber.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\n\u001a\u00020\t2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000eJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\n\u0010\u000fJ3\u0010\u0010\u001a\u00020\t2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\u0010\u0010\u000bJ=\u0010\u0010\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\u0010\u0010\u000eJ3\u0010\u0011\u001a\u00020\t2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\u0011\u0010\u000bJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u0011\u0010\u000fJ3\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\u0012\u0010\u000bJ=\u0010\u0012\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\u0012\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u0012\u0010\u000fJ3\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ltimber/log/Timber$Forest;", "Ltimber/log/Timber$Tree;", "<init>", "()V", "", CrashHianalyticsData.MESSAGE, "", "", "args", "", "d", "(Ljava/lang/String;[Ljava/lang/Object;)V", "", "t", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Throwable;)V", "i", "w", "e", "", RemoteMessageConst.Notification.PRIORITY, RemoteMessageConst.Notification.TAG, "log", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/String;)Ltimber/log/Timber$Tree;", "tree", "plant", "(Ltimber/log/Timber$Tree;)V", "treeArray", "[Ltimber/log/Timber$Tree;", "Ljava/util/ArrayList;", "trees", "Ljava/util/ArrayList;", "timber_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: timber.log.Timber$Forest, reason: from kotlin metadata */
    public static final class Companion extends Tree {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void d(String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.d(message, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void d(Throwable t, String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.d(t, message, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void d(Throwable t) {
            for (Tree tree : Timber.treeArray) {
                tree.d(t);
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void i(String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.i(message, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void i(Throwable t, String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.i(t, message, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void w(String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.w(message, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void w(Throwable t) {
            for (Tree tree : Timber.treeArray) {
                tree.w(t);
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void e(String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.e(message, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void e(Throwable t, String message, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.e(t, message, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        @JvmStatic
        public void e(Throwable t) {
            for (Tree tree : Timber.treeArray) {
                tree.e(t);
            }
        }

        @Override // timber.log.Timber.Tree
        protected void log(int priority, String tag, String message, Throwable t) {
            Intrinsics.checkNotNullParameter(message, "message");
            throw new AssertionError();
        }

        @JvmStatic
        public final Tree tag(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Tree[] treeArr = Timber.treeArray;
            int length = treeArr.length;
            int i = 0;
            while (i < length) {
                Tree tree = treeArr[i];
                i++;
                tree.getExplicitTag().set(tag);
            }
            return this;
        }

        @JvmStatic
        public final void plant(Tree tree) {
            Intrinsics.checkNotNullParameter(tree, "tree");
            if (tree != this) {
                synchronized (Timber.trees) {
                    Timber.trees.add(tree);
                    Object[] array = Timber.trees.toArray(new Tree[0]);
                    if (array != null) {
                        Timber.treeArray = (Tree[]) array;
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
    }
}
