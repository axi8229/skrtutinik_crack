package com.sputnik.data.local;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sputnik.data.DataConstants;
import com.sputnik.data.IConfig;
import com.sputnik.data.entities.cameras.CameraPreferences;
import com.sputnik.data.entities.preferences.MarketRedPointPreferences;
import com.sputnik.data.local.delegates.PrefDelegate;
import com.sputnik.data.local.delegates.PrefObjDelegate;
import com.sputnik.data.local.delegates.adapters.AppSettingsAdapter;
import com.sputnik.data.local.delegates.adapters.CamerasAdapter;
import com.sputnik.data.local.delegates.adapters.CamerasWidgetAdapter;
import com.sputnik.data.local.delegates.adapters.VersionAdapter;
import com.sputnik.data.local.legacy.Session;
import com.sputnik.data.local.legacy.SessionSerializer;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.domain.entities.experimental.ExperimentalFunctions;
import com.sputnik.domain.entities.prefs.AppSettings;
import com.sputnik.domain.entities.prefs.Camera;
import com.sputnik.domain.entities.prefs.CamerasWidget;
import com.sputnik.domain.entities.prefs.DebugToolsSettings;
import com.sputnik.domain.entities.prefs.EventsSettings;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.prefs.OnboardingSettings;
import com.sputnik.domain.entities.prefs.ProfileSettings;
import com.sputnik.domain.entities.prefs.SplashScreen;
import com.sputnik.domain.entities.prefs.VersionModel;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: PrefManager.kt */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bc\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010\u0016J\u001d\u0010%\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000eH\u0016¢\u0006\u0004\b%\u0010\u0012J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001bH\u0016¢\u0006\u0004\b'\u0010\u001eJ\u000f\u0010(\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0013H\u0016¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u0013H\u0016¢\u0006\u0004\b+\u0010)J\u000f\u0010,\u001a\u00020\u001bH\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u001bH\u0016¢\u0006\u0004\b.\u0010-J\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0013H\u0016¢\u0006\u0004\b1\u0010)J\u0015\u00102\u001a\b\u0012\u0004\u0012\u00020#0\u000eH\u0016¢\u0006\u0004\b2\u00100J\u000f\u00103\u001a\u00020\u001bH\u0016¢\u0006\u0004\b3\u0010-J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u000204H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0013H\u0016¢\u0006\u0004\b:\u0010)J\u000f\u0010;\u001a\u00020\u0013H\u0016¢\u0006\u0004\b;\u0010)J\u0017\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u0013H\u0016¢\u0006\u0004\b=\u0010\u0016J\u0017\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u0013H\u0016¢\u0006\u0004\b?\u0010\u0016J\u0017\u0010A\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u0013H\u0016¢\u0006\u0004\bA\u0010\u0016J\u000f\u0010B\u001a\u00020\u0013H\u0016¢\u0006\u0004\bB\u0010)J\u0017\u0010C\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u001bH\u0016¢\u0006\u0004\bC\u0010\u001eJ\u000f\u0010D\u001a\u00020\u001bH\u0016¢\u0006\u0004\bD\u0010-J\u000f\u0010E\u001a\u00020\u001bH\u0016¢\u0006\u0004\bE\u0010-J\u0017\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u001bH\u0016¢\u0006\u0004\bG\u0010\u001eJ\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020HH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020\u000b2\u0006\u00107\u001a\u00020NH\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\u000b2\u0006\u00107\u001a\u00020SH\u0016¢\u0006\u0004\bV\u0010WJ\u0015\u0010Y\u001a\u00020\u000b2\u0006\u00107\u001a\u00020X¢\u0006\u0004\bY\u0010ZJ\u0013\u0010[\u001a\b\u0012\u0004\u0012\u00020X0\u000e¢\u0006\u0004\b[\u00100J\u0015\u0010]\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\\¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\\¢\u0006\u0004\b_\u0010`J\u0017\u0010b\u001a\u00020\u000b2\u0006\u00107\u001a\u00020aH\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020aH\u0016¢\u0006\u0004\bd\u0010eJ\u0015\u0010g\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u001b¢\u0006\u0004\bg\u0010\u001eJ\r\u0010h\u001a\u00020\u001b¢\u0006\u0004\bh\u0010-J\u001d\u0010k\u001a\u00020\u000b2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020i0\u000eH\u0016¢\u0006\u0004\bk\u0010\u0012J\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020i0\u000eH\u0016¢\u0006\u0004\bl\u00100J\u0017\u0010n\u001a\u00020\u000b2\u0006\u00107\u001a\u00020mH\u0016¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020mH\u0016¢\u0006\u0004\bp\u0010qJ\u000f\u0010s\u001a\u00020rH\u0016¢\u0006\u0004\bs\u0010tJ\u0017\u0010u\u001a\u00020\u000b2\u0006\u00107\u001a\u00020rH\u0016¢\u0006\u0004\bu\u0010vJ\u0011\u0010x\u001a\u0004\u0018\u00010wH\u0016¢\u0006\u0004\bx\u0010yJ\u0015\u0010z\u001a\b\u0012\u0004\u0012\u00020w0\u000eH\u0016¢\u0006\u0004\bz\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010{R\u001f\u0010~\u001a\b\u0012\u0004\u0012\u00020}0|8\u0006¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R1\u0010\u008f\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0005\b\u008d\u0001\u0010)\"\u0005\b\u008e\u0001\u0010\u0016R1\u0010\u0093\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b\u0090\u0001\u0010\u008c\u0001\u001a\u0005\b\u0091\u0001\u0010)\"\u0005\b\u0092\u0001\u0010\u0016R1\u0010\u0097\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b\u0094\u0001\u0010\u008c\u0001\u001a\u0005\b\u0095\u0001\u0010)\"\u0005\b\u0096\u0001\u0010\u0016R1\u0010\u0099\u0001\u001a\u00020\u001b2\u0007\u0010\u008a\u0001\u001a\u00020\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b\u0098\u0001\u0010\u008c\u0001\u001a\u0005\b\u0099\u0001\u0010-\"\u0005\b\u009a\u0001\u0010\u001eR1\u0010\u009e\u0001\u001a\u00020\u001b2\u0007\u0010\u008a\u0001\u001a\u00020\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b\u009b\u0001\u0010\u008c\u0001\u001a\u0005\b\u009c\u0001\u0010-\"\u0005\b\u009d\u0001\u0010\u001eR@\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u000f\u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0005\b¡\u0001\u00100\"\u0005\b¢\u0001\u0010\u0012RA\u0010¦\u0001\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010\u000e2\u000f\u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010\u000e8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b£\u0001\u0010 \u0001\u001a\u0005\b¤\u0001\u00100\"\u0005\b¥\u0001\u0010\u0012R1\u0010ª\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b§\u0001\u0010\u008c\u0001\u001a\u0005\b¨\u0001\u0010)\"\u0005\b©\u0001\u0010\u0016RA\u0010®\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000e2\u000f\u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000e8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b«\u0001\u0010 \u0001\u001a\u0005\b¬\u0001\u00100\"\u0005\b\u00ad\u0001\u0010\u0012R1\u0010²\u0001\u001a\u00020\u001b2\u0007\u0010\u008a\u0001\u001a\u00020\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b¯\u0001\u0010\u008c\u0001\u001a\u0005\b°\u0001\u0010-\"\u0005\b±\u0001\u0010\u001eR1\u0010¶\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b³\u0001\u0010\u008c\u0001\u001a\u0005\b´\u0001\u0010)\"\u0005\bµ\u0001\u0010\u0016R1\u0010º\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b·\u0001\u0010\u008c\u0001\u001a\u0005\b¸\u0001\u0010)\"\u0005\b¹\u0001\u0010\u0016R1\u0010¾\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b»\u0001\u0010\u008c\u0001\u001a\u0005\b¼\u0001\u0010)\"\u0005\b½\u0001\u0010\u0016R1\u0010Â\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b¿\u0001\u0010\u008c\u0001\u001a\u0005\bÀ\u0001\u0010)\"\u0005\bÁ\u0001\u0010\u0016R0\u0010Å\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0015\n\u0006\bÃ\u0001\u0010\u008c\u0001\u001a\u0004\b_\u0010)\"\u0005\bÄ\u0001\u0010\u0016R1\u0010É\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bÆ\u0001\u0010\u008c\u0001\u001a\u0005\bÇ\u0001\u0010)\"\u0005\bÈ\u0001\u0010\u0016R1\u0010Ë\u0001\u001a\u00020\u001b2\u0007\u0010\u008a\u0001\u001a\u00020\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bÊ\u0001\u0010\u008c\u0001\u001a\u0005\bË\u0001\u0010-\"\u0005\bÌ\u0001\u0010\u001eR1\u0010Î\u0001\u001a\u00020\u001b2\u0007\u0010\u008a\u0001\u001a\u00020\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bÍ\u0001\u0010\u008c\u0001\u001a\u0005\bÎ\u0001\u0010-\"\u0005\bÏ\u0001\u0010\u001eR1\u0010Ó\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bÐ\u0001\u0010\u008c\u0001\u001a\u0005\bÑ\u0001\u0010)\"\u0005\bÒ\u0001\u0010\u0016R1\u0010×\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bÔ\u0001\u0010\u008c\u0001\u001a\u0005\bÕ\u0001\u0010)\"\u0005\bÖ\u0001\u0010\u0016R/\u0010Ù\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0014\n\u0006\bØ\u0001\u0010\u008c\u0001\u001a\u0004\bO\u0010)\"\u0004\bQ\u0010\u0016R1\u0010Ý\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bÚ\u0001\u0010\u008c\u0001\u001a\u0005\bÛ\u0001\u0010)\"\u0005\bÜ\u0001\u0010\u0016R1\u0010ß\u0001\u001a\u00020\u001b2\u0007\u0010\u008a\u0001\u001a\u00020\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bÞ\u0001\u0010\u008c\u0001\u001a\u0005\bß\u0001\u0010-\"\u0005\bà\u0001\u0010\u001eR5\u0010ä\u0001\u001a\u0004\u0018\u00010m2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010m8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bá\u0001\u0010 \u0001\u001a\u0005\bâ\u0001\u0010q\"\u0005\bã\u0001\u0010oR1\u0010è\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u00138B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\bå\u0001\u0010\u008c\u0001\u001a\u0005\bæ\u0001\u0010)\"\u0005\bç\u0001\u0010\u0016R\u0018\u0010ê\u0001\u001a\u00030é\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001¨\u0006ì\u0001"}, d2 = {"Lcom/sputnik/data/local/PrefManager;", "", "Landroid/app/Application;", "context", "Lcom/sputnik/data/IConfig;", "config", "<init>", "(Landroid/app/Application;Lcom/sputnik/data/IConfig;)V", "Lcom/sputnik/data/local/legacy/Session;", "getOldSession", "()Lcom/sputnik/data/local/legacy/Session;", "", "clearPrefs", "()V", "", "Lcom/sputnik/domain/entities/prefs/CamerasWidget;", "camerasInWidgets", "updateCamerasInWidgets", "(Ljava/util/List;)V", "", "jwt", "updateJwtToken", "(Ljava/lang/String;)V", "token", "updatePushToken", "phone", "updatePhone", "", "fullMenu", "updateIsFullMenu", "(Z)V", "isNoDomofon", "updateIsNoDomofon", "locale", "updateUserLocale", "Lcom/sputnik/domain/entities/prefs/VersionModel;", "localesVersions", "updateLocaleVersions", "needShowOnBoarding", "updateShowStartOnBoarding", "getJwtToken", "()Ljava/lang/String;", "getPhone", "getPushToken", "getIsFullMenu", "()Z", "getIsNoDomofon", "getCamerasInWidget", "()Ljava/util/List;", "getCurLocale", "getLocalesVersions", "getIsNeedShowStartOnBoarding", "Lcom/sputnik/domain/entities/prefs/OnboardingSettings;", "getOnboardingSettings", "()Lcom/sputnik/domain/entities/prefs/OnboardingSettings;", "obj", "setOnboardingSettings", "(Lcom/sputnik/domain/entities/prefs/OnboardingSettings;)V", "getBaseUrl", "getLastAccruedDate", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "setLastAccruedDate", "url", "updateBaseUrl", "version", "updateAppVersion", "getAppVersion", "updateCallHistoryBottomSheetShowed", "getIsCallHistoryBottomSheetShowed", "getIsTestEnvironmentForPaymentsEnabled", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setIsTestEnvironmentForPaymentsEnabled", "Lcom/sputnik/domain/entities/prefs/LoginState;", "getLoginState", "()Lcom/sputnik/domain/entities/prefs/LoginState;", "loginState", "setLoginState", "(Lcom/sputnik/domain/entities/prefs/LoginState;)V", "Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "getDebugToolsSettings", "()Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "setDebugToolsSettings", "(Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;)V", "Lcom/sputnik/domain/entities/prefs/ProfileSettings;", "getProfileSettings", "()Lcom/sputnik/domain/entities/prefs/ProfileSettings;", "setProfileSettings", "(Lcom/sputnik/domain/entities/prefs/ProfileSettings;)V", "Lcom/sputnik/data/entities/cameras/CameraPreferences;", "saveZoom", "(Lcom/sputnik/data/entities/cameras/CameraPreferences;)V", "getCameraPreferences", "Lcom/sputnik/data/entities/preferences/MarketRedPointPreferences;", "saveMarketRedPointPreferences", "(Lcom/sputnik/data/entities/preferences/MarketRedPointPreferences;)V", "getMarketRedPointPreferences", "()Lcom/sputnik/data/entities/preferences/MarketRedPointPreferences;", "Lcom/sputnik/domain/entities/experimental/ExperimentalFunctions;", "updateExperimental", "(Lcom/sputnik/domain/entities/experimental/ExperimentalFunctions;)V", "getExperimentalSettings", "()Lcom/sputnik/domain/entities/experimental/ExperimentalFunctions;", "newValue", "updateIsLoggedIn", "getIsLoggedIn", "Lcom/sputnik/domain/entities/prefs/Camera;", "cameras", "updateCameras", "getCameras", "Lcom/sputnik/domain/entities/prefs/AppSettings;", "updateAppSettings", "(Lcom/sputnik/domain/entities/prefs/AppSettings;)V", "getAppSettings", "()Lcom/sputnik/domain/entities/prefs/AppSettings;", "Lcom/sputnik/domain/entities/prefs/EventsSettings;", "getEventsSettings", "()Lcom/sputnik/domain/entities/prefs/EventsSettings;", "setEventsSettings", "(Lcom/sputnik/domain/entities/prefs/EventsSettings;)V", "Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address;", "getCurrentAddress", "()Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address;", "getCurrentAddresses", "Landroid/app/Application;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore", "Landroidx/datastore/core/DataStore;", "getDataStore", "()Landroidx/datastore/core/DataStore;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "errHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$data_release", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "loginPhone$delegate", "Lkotlin/properties/ReadWriteProperty;", "getLoginPhone", "setLoginPhone", "loginPhone", "sessionToken$delegate", "getSessionToken", "setSessionToken", "sessionToken", "callToken$delegate", "getCallToken", "setCallToken", "callToken", "isFullMenu$delegate", "isFullMenu", "setFullMenu", "noDomofon$delegate", "getNoDomofon", "setNoDomofon", "noDomofon", "camerasInWidgets$delegate", "Lcom/sputnik/data/local/delegates/PrefObjDelegate;", "getCamerasInWidgets", "setCamerasInWidgets", "_cameras$delegate", "get_cameras", "set_cameras", "_cameras", "userLocale$delegate", "getUserLocale", "setUserLocale", "userLocale", "localeVersions$delegate", "getLocaleVersions", "setLocaleVersions", "localeVersions", "showStartOnBoarding$delegate", "getShowStartOnBoarding", "setShowStartOnBoarding", "showStartOnBoarding", "baseUrlPreference$delegate", "getBaseUrlPreference", "setBaseUrlPreference", "baseUrlPreference", "lastAccruedDatePreference$delegate", "getLastAccruedDatePreference", "setLastAccruedDatePreference", "lastAccruedDatePreference", "debugAppVersion$delegate", "getDebugAppVersion", "setDebugAppVersion", "debugAppVersion", "zoom$delegate", "getZoom", "setZoom", "zoom", "marketRedPointPreferences$delegate", "setMarketRedPointPreferences", "marketRedPointPreferences", "experimentalFunctions$delegate", "getExperimentalFunctions", "setExperimentalFunctions", "experimentalFunctions", "isBottomSheetAboutCallHistoryShowed$delegate", "isBottomSheetAboutCallHistoryShowed", "setBottomSheetAboutCallHistoryShowed", "isTestEnvironmentForPaymentsEnabled$delegate", "isTestEnvironmentForPaymentsEnabled", "setTestEnvironmentForPaymentsEnabled", "_onboardingSettings$delegate", "get_onboardingSettings", "set_onboardingSettings", "_onboardingSettings", "_loginState$delegate", "get_loginState", "set_loginState", "_loginState", "debugToolsSettings$delegate", "debugToolsSettings", "_profileSettings$delegate", "get_profileSettings", "set_profileSettings", "_profileSettings", "isLoggedIn$delegate", "isLoggedIn", "setLoggedIn", "_appSettings$delegate", "get_appSettings", "set_appSettings", "_appSettings", "_eventsSettings$delegate", "get_eventsSettings", "set_eventsSettings", "_eventsSettings", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrefManager {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "loginPhone", "getLoginPhone()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "sessionToken", "getSessionToken()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "callToken", "getCallToken()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "isFullMenu", "isFullMenu()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "noDomofon", "getNoDomofon()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "camerasInWidgets", "getCamerasInWidgets()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "_cameras", "get_cameras()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "userLocale", "getUserLocale()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "localeVersions", "getLocaleVersions()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "showStartOnBoarding", "getShowStartOnBoarding()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "baseUrlPreference", "getBaseUrlPreference()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "lastAccruedDatePreference", "getLastAccruedDatePreference()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "debugAppVersion", "getDebugAppVersion()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "zoom", "getZoom()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "marketRedPointPreferences", "getMarketRedPointPreferences()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "experimentalFunctions", "getExperimentalFunctions()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "isBottomSheetAboutCallHistoryShowed", "isBottomSheetAboutCallHistoryShowed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "isTestEnvironmentForPaymentsEnabled", "isTestEnvironmentForPaymentsEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "_onboardingSettings", "get_onboardingSettings()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "_loginState", "get_loginState()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "debugToolsSettings", "getDebugToolsSettings()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "_profileSettings", "get_profileSettings()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "isLoggedIn", "isLoggedIn()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "_appSettings", "get_appSettings()Lcom/sputnik/domain/entities/prefs/AppSettings;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PrefManager.class, "_eventsSettings", "get_eventsSettings()Ljava/lang/String;", 0))};

    /* renamed from: _appSettings$delegate, reason: from kotlin metadata */
    private final PrefObjDelegate _appSettings;

    /* renamed from: _cameras$delegate, reason: from kotlin metadata */
    private final PrefObjDelegate _cameras;

    /* renamed from: _eventsSettings$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty _eventsSettings;

    /* renamed from: _loginState$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty _loginState;

    /* renamed from: _onboardingSettings$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty _onboardingSettings;

    /* renamed from: _profileSettings$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty _profileSettings;

    /* renamed from: baseUrlPreference$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty baseUrlPreference;

    /* renamed from: callToken$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty callToken;

    /* renamed from: camerasInWidgets$delegate, reason: from kotlin metadata */
    private final PrefObjDelegate camerasInWidgets;
    private final Application context;
    private final DataStore<Preferences> dataStore;

    /* renamed from: debugAppVersion$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty debugAppVersion;

    /* renamed from: debugToolsSettings$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty debugToolsSettings;
    private final CoroutineExceptionHandler errHandler;

    /* renamed from: experimentalFunctions$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty experimentalFunctions;
    private final Gson gson;

    /* renamed from: isBottomSheetAboutCallHistoryShowed$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty isBottomSheetAboutCallHistoryShowed;

    /* renamed from: isFullMenu$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty isFullMenu;

    /* renamed from: isLoggedIn$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty isLoggedIn;

    /* renamed from: isTestEnvironmentForPaymentsEnabled$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty isTestEnvironmentForPaymentsEnabled;

    /* renamed from: lastAccruedDatePreference$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty lastAccruedDatePreference;

    /* renamed from: localeVersions$delegate, reason: from kotlin metadata */
    private final PrefObjDelegate localeVersions;

    /* renamed from: loginPhone$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty loginPhone;

    /* renamed from: marketRedPointPreferences$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty marketRedPointPreferences;

    /* renamed from: noDomofon$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty noDomofon;
    private final CoroutineScope scope;

    /* renamed from: sessionToken$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty sessionToken;

    /* renamed from: showStartOnBoarding$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty showStartOnBoarding;

    /* renamed from: userLocale$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty userLocale;

    /* renamed from: zoom$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty zoom;

    public PrefManager(Application context, IConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        Log.e("DAGGER", "PrefManager");
        this.dataStore = PrefManagerKt.getDataStore(context);
        PrefManager$special$$inlined$CoroutineExceptionHandler$1 prefManager$special$$inlined$CoroutineExceptionHandler$1 = new PrefManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.errHandler = prefManager$special$$inlined$CoroutineExceptionHandler$1;
        String str = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        byte b7 = 0;
        byte b8 = 0;
        byte b9 = 0;
        byte b10 = 0;
        byte b11 = 0;
        byte b12 = 0;
        byte b13 = 0;
        byte b14 = 0;
        byte b15 = 0;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        byte b19 = 0;
        byte b20 = 0;
        byte b21 = 0;
        byte b22 = 0;
        byte b23 = 0;
        byte b24 = 0;
        byte b25 = 0;
        byte b26 = 0;
        byte b27 = 0;
        byte b28 = 0;
        byte b29 = 0;
        byte b30 = 0;
        byte b31 = 0;
        byte b32 = 0;
        byte b33 = 0;
        byte b34 = 0;
        byte b35 = 0;
        byte b36 = 0;
        byte b37 = 0;
        byte b38 = 0;
        byte b39 = 0;
        byte b40 = 0;
        byte b41 = 0;
        byte b42 = 0;
        byte b43 = 0;
        byte b44 = 0;
        byte b45 = 0;
        byte b46 = 0;
        byte b47 = 0;
        byte b48 = 0;
        byte b49 = 0;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(prefManager$special$$inlined$CoroutineExceptionHandler$1));
        Session oldSession = getOldSession();
        String login = oldSession != null ? oldSession.getLogin() : null;
        String str2 = "";
        int i = 2;
        PrefDelegate prefDelegate = new PrefDelegate(login == null ? "" : login, str, i, b49 == true ? 1 : 0);
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        this.loginPhone = prefDelegate.provideDelegate(this, kPropertyArr[0]);
        Session oldSession2 = getOldSession();
        String token = oldSession2 != null ? oldSession2.getToken() : null;
        this.sessionToken = new PrefDelegate(token == null ? "" : token, b48 == true ? 1 : 0, i, b47 == true ? 1 : 0).provideDelegate(this, kPropertyArr[1]);
        this.callToken = new PrefDelegate(str2, b46 == true ? 1 : 0, i, b45 == true ? 1 : 0).provideDelegate(this, kPropertyArr[2]);
        Boolean bool = Boolean.FALSE;
        this.isFullMenu = new PrefDelegate(bool, b44 == true ? 1 : 0, i, b43 == true ? 1 : 0).provideDelegate(this, kPropertyArr[3]);
        this.noDomofon = new PrefDelegate(bool, b42 == true ? 1 : 0, i, b41 == true ? 1 : 0).provideDelegate(this, kPropertyArr[4]);
        this.camerasInWidgets = new PrefObjDelegate(new CamerasWidgetAdapter(), b40 == true ? 1 : 0, i, b39 == true ? 1 : 0);
        this._cameras = new PrefObjDelegate(new CamerasAdapter(), b38 == true ? 1 : 0, i, b37 == true ? 1 : 0);
        this.userLocale = new PrefDelegate(DataConstants.INSTANCE.getPhoneLocale(), b36 == true ? 1 : 0, i, b35 == true ? 1 : 0).provideDelegate(this, kPropertyArr[7]);
        this.localeVersions = new PrefObjDelegate(new VersionAdapter(), b34 == true ? 1 : 0, i, b33 == true ? 1 : 0);
        this.showStartOnBoarding = new PrefDelegate(Boolean.TRUE, b32 == true ? 1 : 0, i, b31 == true ? 1 : 0).provideDelegate(this, kPropertyArr[9]);
        this.baseUrlPreference = new PrefDelegate(config.getIsStage() ? "https://citizen-app-second.stage.sputnik.systems/api/mobile/v2/" : "https://api-mobile-gorod.sputnik.systems/api/mobile/v2/", b30 == true ? 1 : 0, i, b29 == true ? 1 : 0).provideDelegate(this, kPropertyArr[10]);
        this.lastAccruedDatePreference = new PrefDelegate(str2, b28 == true ? 1 : 0, i, b27 == true ? 1 : 0).provideDelegate(this, kPropertyArr[11]);
        this.debugAppVersion = new PrefDelegate(config.getVersionName(), b26 == true ? 1 : 0, i, b25 == true ? 1 : 0).provideDelegate(this, kPropertyArr[12]);
        this.zoom = new PrefDelegate(str2, b24 == true ? 1 : 0, i, b23 == true ? 1 : 0).provideDelegate(this, kPropertyArr[13]);
        this.marketRedPointPreferences = new PrefDelegate(str2, b22 == true ? 1 : 0, i, b21 == true ? 1 : 0).provideDelegate(this, kPropertyArr[14]);
        this.experimentalFunctions = new PrefDelegate(str2, b20 == true ? 1 : 0, i, b19 == true ? 1 : 0).provideDelegate(this, kPropertyArr[15]);
        this.isBottomSheetAboutCallHistoryShowed = new PrefDelegate(bool, b18 == true ? 1 : 0, i, b17 == true ? 1 : 0).provideDelegate(this, kPropertyArr[16]);
        this.isTestEnvironmentForPaymentsEnabled = new PrefDelegate(bool, b16 == true ? 1 : 0, i, b15 == true ? 1 : 0).provideDelegate(this, kPropertyArr[17]);
        this._onboardingSettings = new PrefDelegate(str2, b14 == true ? 1 : 0, i, b13 == true ? 1 : 0).provideDelegate(this, kPropertyArr[18]);
        this._loginState = new PrefDelegate(str2, b12 == true ? 1 : 0, i, b11 == true ? 1 : 0).provideDelegate(this, kPropertyArr[19]);
        this.debugToolsSettings = new PrefDelegate(str2, b10 == true ? 1 : 0, i, b9 == true ? 1 : 0).provideDelegate(this, kPropertyArr[20]);
        this._profileSettings = new PrefDelegate(str2, b8 == true ? 1 : 0, i, b7 == true ? 1 : 0).provideDelegate(this, kPropertyArr[21]);
        this.isLoggedIn = new PrefDelegate(bool, b6 == true ? 1 : 0, i, b5 == true ? 1 : 0).provideDelegate(this, kPropertyArr[22]);
        this._appSettings = new PrefObjDelegate(new AppSettingsAdapter(), b4 == true ? 1 : 0, i, b3 == true ? 1 : 0);
        this._eventsSettings = new PrefDelegate(str2, b2 == true ? 1 : 0, i, b == true ? 1 : 0).provideDelegate(this, kPropertyArr[24]);
        this.gson = new Gson();
    }

    public final DataStore<Preferences> getDataStore() {
        return this.dataStore;
    }

    /* renamed from: getScope$data_release, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    private final String getLoginPhone() {
        return (String) this.loginPhone.getValue(this, $$delegatedProperties[0]);
    }

    private final void setLoginPhone(String str) {
        this.loginPhone.setValue(this, $$delegatedProperties[0], str);
    }

    private final String getSessionToken() {
        return (String) this.sessionToken.getValue(this, $$delegatedProperties[1]);
    }

    private final void setSessionToken(String str) {
        this.sessionToken.setValue(this, $$delegatedProperties[1], str);
    }

    private final String getCallToken() {
        return (String) this.callToken.getValue(this, $$delegatedProperties[2]);
    }

    private final void setCallToken(String str) {
        this.callToken.setValue(this, $$delegatedProperties[2], str);
    }

    private final boolean isFullMenu() {
        return ((Boolean) this.isFullMenu.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    private final void setFullMenu(boolean z) {
        this.isFullMenu.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z));
    }

    private final boolean getNoDomofon() {
        return ((Boolean) this.noDomofon.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    private final void setNoDomofon(boolean z) {
        this.noDomofon.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    private final List<CamerasWidget> getCamerasInWidgets() {
        return (List) this.camerasInWidgets.getValue(this, $$delegatedProperties[5]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCamerasInWidgets(List<CamerasWidget> list) {
        this.camerasInWidgets.setValue2(this, $$delegatedProperties[5], (KProperty<?>) list);
    }

    private final List<Camera> get_cameras() {
        return (List) this._cameras.getValue(this, $$delegatedProperties[6]);
    }

    private final void set_cameras(List<Camera> list) {
        this._cameras.setValue2(this, $$delegatedProperties[6], (KProperty<?>) list);
    }

    private final String getUserLocale() {
        return (String) this.userLocale.getValue(this, $$delegatedProperties[7]);
    }

    private final void setUserLocale(String str) {
        this.userLocale.setValue(this, $$delegatedProperties[7], str);
    }

    private final List<VersionModel> getLocaleVersions() {
        return (List) this.localeVersions.getValue(this, $$delegatedProperties[8]);
    }

    private final void setLocaleVersions(List<VersionModel> list) {
        this.localeVersions.setValue2(this, $$delegatedProperties[8], (KProperty<?>) list);
    }

    private final boolean getShowStartOnBoarding() {
        return ((Boolean) this.showStartOnBoarding.getValue(this, $$delegatedProperties[9])).booleanValue();
    }

    private final void setShowStartOnBoarding(boolean z) {
        this.showStartOnBoarding.setValue(this, $$delegatedProperties[9], Boolean.valueOf(z));
    }

    private final String getBaseUrlPreference() {
        return (String) this.baseUrlPreference.getValue(this, $$delegatedProperties[10]);
    }

    private final void setBaseUrlPreference(String str) {
        this.baseUrlPreference.setValue(this, $$delegatedProperties[10], str);
    }

    private final String getLastAccruedDatePreference() {
        return (String) this.lastAccruedDatePreference.getValue(this, $$delegatedProperties[11]);
    }

    private final void setLastAccruedDatePreference(String str) {
        this.lastAccruedDatePreference.setValue(this, $$delegatedProperties[11], str);
    }

    private final String getDebugAppVersion() {
        return (String) this.debugAppVersion.getValue(this, $$delegatedProperties[12]);
    }

    private final void setDebugAppVersion(String str) {
        this.debugAppVersion.setValue(this, $$delegatedProperties[12], str);
    }

    private final String getZoom() {
        return (String) this.zoom.getValue(this, $$delegatedProperties[13]);
    }

    private final void setZoom(String str) {
        this.zoom.setValue(this, $$delegatedProperties[13], str);
    }

    private final String getMarketRedPointPreferences() {
        return (String) this.marketRedPointPreferences.getValue(this, $$delegatedProperties[14]);
    }

    private final void setMarketRedPointPreferences(String str) {
        this.marketRedPointPreferences.setValue(this, $$delegatedProperties[14], str);
    }

    private final String getExperimentalFunctions() {
        return (String) this.experimentalFunctions.getValue(this, $$delegatedProperties[15]);
    }

    private final void setExperimentalFunctions(String str) {
        this.experimentalFunctions.setValue(this, $$delegatedProperties[15], str);
    }

    private final boolean isBottomSheetAboutCallHistoryShowed() {
        return ((Boolean) this.isBottomSheetAboutCallHistoryShowed.getValue(this, $$delegatedProperties[16])).booleanValue();
    }

    private final void setBottomSheetAboutCallHistoryShowed(boolean z) {
        this.isBottomSheetAboutCallHistoryShowed.setValue(this, $$delegatedProperties[16], Boolean.valueOf(z));
    }

    private final boolean isTestEnvironmentForPaymentsEnabled() {
        return ((Boolean) this.isTestEnvironmentForPaymentsEnabled.getValue(this, $$delegatedProperties[17])).booleanValue();
    }

    private final void setTestEnvironmentForPaymentsEnabled(boolean z) {
        this.isTestEnvironmentForPaymentsEnabled.setValue(this, $$delegatedProperties[17], Boolean.valueOf(z));
    }

    private final String get_onboardingSettings() {
        return (String) this._onboardingSettings.getValue(this, $$delegatedProperties[18]);
    }

    private final void set_onboardingSettings(String str) {
        this._onboardingSettings.setValue(this, $$delegatedProperties[18], str);
    }

    private final String get_loginState() {
        return (String) this._loginState.getValue(this, $$delegatedProperties[19]);
    }

    private final void set_loginState(String str) {
        this._loginState.setValue(this, $$delegatedProperties[19], str);
    }

    private final String getDebugToolsSettings() {
        return (String) this.debugToolsSettings.getValue(this, $$delegatedProperties[20]);
    }

    private final void setDebugToolsSettings(String str) {
        this.debugToolsSettings.setValue(this, $$delegatedProperties[20], str);
    }

    private final String get_profileSettings() {
        return (String) this._profileSettings.getValue(this, $$delegatedProperties[21]);
    }

    private final void set_profileSettings(String str) {
        this._profileSettings.setValue(this, $$delegatedProperties[21], str);
    }

    private final boolean isLoggedIn() {
        return ((Boolean) this.isLoggedIn.getValue(this, $$delegatedProperties[22])).booleanValue();
    }

    private final void setLoggedIn(boolean z) {
        this.isLoggedIn.setValue(this, $$delegatedProperties[22], Boolean.valueOf(z));
    }

    private final AppSettings get_appSettings() {
        return (AppSettings) this._appSettings.getValue(this, $$delegatedProperties[23]);
    }

    private final void set_appSettings(AppSettings appSettings) {
        this._appSettings.setValue2(this, $$delegatedProperties[23], (KProperty<?>) appSettings);
    }

    private final String get_eventsSettings() {
        return (String) this._eventsSettings.getValue(this, $$delegatedProperties[24]);
    }

    private final void set_eventsSettings(String str) {
        this._eventsSettings.setValue(this, $$delegatedProperties[24], str);
    }

    private final Session getOldSession() {
        try {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences("sputnik.axmor.com.sputnik.shared_preference", 0);
            Session object = SessionSerializer.getObject(sharedPreferences, "sputnik.axmor.com.sputnik.core.service.local.session_pref");
            return object == null ? SessionSerializer.getObject(sharedPreferences, "session_pref") : object;
        } catch (Exception unused) {
            return null;
        }
    }

    /* compiled from: PrefManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.local.PrefManager$clearPrefs$1", f = "PrefManager.kt", l = {114}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.local.PrefManager$clearPrefs$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PrefManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PrefManager.this.setCamerasInWidgets(CollectionsKt.emptyList());
                DataStore<Preferences> dataStore = PrefManager.this.getDataStore();
                C01131 c01131 = new C01131(null);
                this.label = 1;
                if (PreferencesKt.edit(dataStore, c01131, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: PrefManager.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.local.PrefManager$clearPrefs$1$1", f = "PrefManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.local.PrefManager$clearPrefs$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01131 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C01131(Continuation<? super C01131> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01131 c01131 = new C01131(continuation);
                c01131.L$0 = obj;
                return c01131;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return ((C01131) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ((MutablePreferences) this.L$0).clear();
                return Unit.INSTANCE;
            }
        }
    }

    public void clearPrefs() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    public void updateCamerasInWidgets(List<CamerasWidget> camerasInWidgets) {
        Intrinsics.checkNotNullParameter(camerasInWidgets, "camerasInWidgets");
        setCamerasInWidgets(camerasInWidgets);
    }

    public void updateJwtToken(String jwt) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        setSessionToken(jwt);
    }

    public void updatePushToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        setCallToken(token);
    }

    public void updatePhone(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        setLoginPhone(phone);
    }

    public void updateIsFullMenu(boolean fullMenu) {
        setFullMenu(fullMenu);
    }

    public void updateIsNoDomofon(boolean isNoDomofon) {
        setNoDomofon(isNoDomofon);
    }

    public void updateUserLocale(String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Log.e("saved language new", locale);
        setUserLocale(locale);
    }

    public void updateLocaleVersions(List<VersionModel> localesVersions) {
        Intrinsics.checkNotNullParameter(localesVersions, "localesVersions");
        setLocaleVersions(localesVersions);
    }

    public void updateShowStartOnBoarding(boolean needShowOnBoarding) {
        setShowStartOnBoarding(needShowOnBoarding);
    }

    public String getJwtToken() {
        String sessionToken = getSessionToken();
        setSessionToken(sessionToken);
        return sessionToken;
    }

    public String getPhone() {
        return getLoginPhone();
    }

    public String getPushToken() {
        return getCallToken();
    }

    public boolean getIsFullMenu() {
        return isFullMenu();
    }

    public boolean getIsNoDomofon() {
        return getNoDomofon();
    }

    public List<CamerasWidget> getCamerasInWidget() {
        List<CamerasWidget> camerasInWidgets = getCamerasInWidgets();
        return camerasInWidgets == null ? CollectionsKt.emptyList() : camerasInWidgets;
    }

    public String getCurLocale() {
        return getUserLocale();
    }

    public List<VersionModel> getLocalesVersions() {
        List<VersionModel> localeVersions = getLocaleVersions();
        return localeVersions == null ? CollectionsKt.emptyList() : localeVersions;
    }

    public boolean getIsNeedShowStartOnBoarding() {
        return getShowStartOnBoarding();
    }

    public OnboardingSettings getOnboardingSettings() {
        if (StringsKt.isBlank(get_onboardingSettings())) {
            return new OnboardingSettings(0L, 0L, 0L, false, false, null, null, null, false, false, 1023, null);
        }
        try {
            Object objFromJson = this.gson.fromJson(get_onboardingSettings(), (Class<Object>) OnboardingSettings.class);
            Intrinsics.checkNotNull(objFromJson);
            return (OnboardingSettings) objFromJson;
        } catch (Exception e) {
            e.printStackTrace();
            return new OnboardingSettings(0L, 0L, 0L, false, false, null, null, null, false, false, 1023, null);
        }
    }

    public void setOnboardingSettings(OnboardingSettings obj) {
        String json;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            json = this.gson.toJson(obj);
            Intrinsics.checkNotNull(json);
        } catch (Exception unused) {
            json = this.gson.toJson(new OnboardingSettings(0L, 0L, 0L, false, false, null, null, null, false, false, 1023, null));
            Intrinsics.checkNotNull(json);
        }
        set_onboardingSettings(json);
    }

    public String getBaseUrl() {
        return getBaseUrlPreference();
    }

    public String getLastAccruedDate() {
        return getLastAccruedDatePreference();
    }

    public void setLastAccruedDate(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        setLastAccruedDatePreference(date);
    }

    public void updateBaseUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        setBaseUrlPreference(url);
    }

    public void updateAppVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        setDebugAppVersion(version);
    }

    public String getAppVersion() {
        return getDebugAppVersion();
    }

    public void updateCallHistoryBottomSheetShowed(boolean obj) {
        setBottomSheetAboutCallHistoryShowed(obj);
    }

    public boolean getIsCallHistoryBottomSheetShowed() {
        return isBottomSheetAboutCallHistoryShowed();
    }

    public boolean getIsTestEnvironmentForPaymentsEnabled() {
        return isTestEnvironmentForPaymentsEnabled();
    }

    public void setIsTestEnvironmentForPaymentsEnabled(boolean value) {
        setTestEnvironmentForPaymentsEnabled(value);
    }

    public LoginState getLoginState() {
        try {
            LoginState loginState = (LoginState) this.gson.fromJson(get_loginState(), LoginState.class);
            if (loginState != null) {
                return loginState;
            }
            return new LoginState((String) null, (Long) null, (String) null, false, (Long) null, (RegistrationWay) null, (List) null, 127, (DefaultConstructorMarker) null);
        } catch (Exception unused) {
            return new LoginState((String) null, (Long) null, (String) null, false, (Long) null, (RegistrationWay) null, (List) null, 127, (DefaultConstructorMarker) null);
        }
    }

    public void setLoginState(LoginState loginState) {
        String json;
        Intrinsics.checkNotNullParameter(loginState, "loginState");
        try {
            LoginState loginState2 = getLoginState();
            Gson gson = this.gson;
            String phone = loginState.getPhone();
            if (phone == null) {
                phone = loginState2.getPhone();
            }
            Long limitExpiresAt = loginState.getLimitExpiresAt();
            if (limitExpiresAt == null) {
                limitExpiresAt = loginState2.getLimitExpiresAt();
            }
            String limitExpiresAtMessage = loginState.getLimitExpiresAtMessage();
            if (limitExpiresAtMessage == null) {
                limitExpiresAtMessage = loginState2.getLimitExpiresAtMessage();
            }
            boolean needNavigateToCode = loginState.getNeedNavigateToCode();
            Long smsCodeExpiresAt = loginState.getSmsCodeExpiresAt();
            if (smsCodeExpiresAt == null) {
                smsCodeExpiresAt = loginState2.getSmsCodeExpiresAt();
            }
            List<LoginState.Session> sessions = loginState.getSessions();
            if (sessions == null && (sessions = loginState2.getSessions()) == null) {
                sessions = new ArrayList<>();
            }
            List<LoginState.Session> list = sessions;
            RegistrationWay way = loginState.getWay();
            if (way == null) {
                way = loginState2 != null ? loginState2.getWay() : null;
            }
            json = gson.toJson(loginState2.copy(phone, limitExpiresAt, limitExpiresAtMessage, needNavigateToCode, smsCodeExpiresAt, way, list));
            Intrinsics.checkNotNull(json);
        } catch (Exception unused) {
            json = this.gson.toJson(getLoginState());
            Intrinsics.checkNotNull(json);
        }
        set_loginState(json);
    }

    /* renamed from: getDebugToolsSettings, reason: collision with other method in class */
    public DebugToolsSettings m2507getDebugToolsSettings() {
        try {
            DebugToolsSettings debugToolsSettings = (DebugToolsSettings) this.gson.fromJson(getDebugToolsSettings(), DebugToolsSettings.class);
            return debugToolsSettings == null ? DebugToolsSettings.INSTANCE.m2543default() : debugToolsSettings;
        } catch (Exception unused) {
            return DebugToolsSettings.INSTANCE.m2543default();
        }
    }

    public void setDebugToolsSettings(DebugToolsSettings obj) {
        String json;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            DebugToolsSettings debugToolsSettingsM2507getDebugToolsSettings = m2507getDebugToolsSettings();
            Gson gson = this.gson;
            Boolean boolIsAccountLimitsEnabled = obj.getIsAccountLimitsEnabled();
            if (boolIsAccountLimitsEnabled == null) {
                boolIsAccountLimitsEnabled = debugToolsSettingsM2507getDebugToolsSettings.getIsAccountLimitsEnabled();
            }
            Boolean boolIsBleServiceAvailable = obj.getIsBleServiceAvailable();
            if (boolIsBleServiceAvailable == null) {
                boolIsBleServiceAvailable = debugToolsSettingsM2507getDebugToolsSettings.getIsBleServiceAvailable();
            }
            json = gson.toJson(debugToolsSettingsM2507getDebugToolsSettings.copy(boolIsAccountLimitsEnabled, boolIsBleServiceAvailable));
            Intrinsics.checkNotNull(json);
        } catch (Exception unused) {
            json = this.gson.toJson(m2507getDebugToolsSettings());
            Intrinsics.checkNotNull(json);
        }
        setDebugToolsSettings(json);
    }

    public ProfileSettings getProfileSettings() {
        try {
            ProfileSettings profileSettings = (ProfileSettings) this.gson.fromJson(get_profileSettings(), ProfileSettings.class);
            return profileSettings == null ? ProfileSettings.INSTANCE.m2544default() : profileSettings;
        } catch (Exception unused) {
            return ProfileSettings.INSTANCE.m2544default();
        }
    }

    public void setProfileSettings(ProfileSettings obj) {
        String json;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            ProfileSettings profileSettings = getProfileSettings();
            Gson gson = this.gson;
            String fullAddress = obj.getFullAddress();
            SplashScreen splashScreen = obj.getSplashScreen();
            Boolean needToClearSupportScreen = obj.getNeedToClearSupportScreen();
            json = gson.toJson(profileSettings.copy(fullAddress, splashScreen, Boolean.valueOf(needToClearSupportScreen != null ? needToClearSupportScreen.booleanValue() : false)));
            Intrinsics.checkNotNull(json);
        } catch (Exception unused) {
            json = this.gson.toJson(getProfileSettings());
            Intrinsics.checkNotNull(json);
        }
        set_profileSettings(json);
    }

    public final void saveZoom(CameraPreferences obj) {
        String json;
        Object next;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            List<CameraPreferences> cameraPreferences = getCameraPreferences();
            Iterator<T> it = cameraPreferences.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((CameraPreferences) next).getUuid(), obj.getUuid())) {
                        break;
                    }
                }
            }
            List mutableList = CollectionsKt.toMutableList((Collection) cameraPreferences);
            TypeIntrinsics.asMutableCollection(mutableList).remove((CameraPreferences) next);
            mutableList.add(obj);
            json = this.gson.toJson(mutableList);
            Intrinsics.checkNotNull(json);
        } catch (Exception unused) {
            json = this.gson.toJson(CollectionsKt.emptyList());
            Intrinsics.checkNotNull(json);
        }
        setZoom(json);
    }

    public final List<CameraPreferences> getCameraPreferences() {
        List<CameraPreferences> listEmptyList;
        try {
            Type type = new TypeToken<List<? extends CameraPreferences>>() { // from class: com.sputnik.data.local.PrefManager$getCameraPreferences$listType$1
            }.getType();
            if (StringsKt.isBlank(getZoom())) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                Object objFromJson = this.gson.fromJson(getZoom(), type);
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                listEmptyList = (List) objFromJson;
            }
            return listEmptyList;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    public final void saveMarketRedPointPreferences(MarketRedPointPreferences obj) {
        String json;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            MarketRedPointPreferences marketRedPointPreferencesM2508getMarketRedPointPreferences = m2508getMarketRedPointPreferences();
            Boolean boolIsMarketAvailable = obj.getIsMarketAvailable();
            if (boolIsMarketAvailable == null) {
                boolIsMarketAvailable = marketRedPointPreferencesM2508getMarketRedPointPreferences.getIsMarketAvailable();
            }
            Boolean bool = boolIsMarketAvailable;
            List<String> subscriptionsIdentifiers = obj.getSubscriptionsIdentifiers();
            if (subscriptionsIdentifiers == null) {
                subscriptionsIdentifiers = marketRedPointPreferencesM2508getMarketRedPointPreferences.getSubscriptionsIdentifiers();
            }
            List<String> list = subscriptionsIdentifiers;
            List<String> servicesIdentifiers = obj.getServicesIdentifiers();
            if (servicesIdentifiers == null) {
                servicesIdentifiers = marketRedPointPreferencesM2508getMarketRedPointPreferences.getServicesIdentifiers();
            }
            List<String> list2 = servicesIdentifiers;
            List<String> marketItemsIdentifiers = obj.getMarketItemsIdentifiers();
            if (marketItemsIdentifiers == null) {
                marketItemsIdentifiers = marketRedPointPreferencesM2508getMarketRedPointPreferences.getMarketItemsIdentifiers();
            }
            List<String> list3 = marketItemsIdentifiers;
            List<DomainBaseSubscription> subscriptions = obj.getSubscriptions();
            if (subscriptions == null) {
                subscriptions = marketRedPointPreferencesM2508getMarketRedPointPreferences.getSubscriptions();
            }
            json = this.gson.toJson(new MarketRedPointPreferences(bool, list, list2, list3, subscriptions));
            Intrinsics.checkNotNull(json);
        } catch (Exception unused) {
            json = this.gson.toJson(MarketRedPointPreferences.INSTANCE.m2506default());
            Intrinsics.checkNotNull(json);
        }
        setMarketRedPointPreferences(json);
    }

    /* renamed from: getMarketRedPointPreferences, reason: collision with other method in class */
    public final MarketRedPointPreferences m2508getMarketRedPointPreferences() {
        try {
            MarketRedPointPreferences marketRedPointPreferencesM2506default = StringsKt.isBlank(getMarketRedPointPreferences()) ? MarketRedPointPreferences.INSTANCE.m2506default() : (MarketRedPointPreferences) this.gson.fromJson(getMarketRedPointPreferences(), MarketRedPointPreferences.class);
            Intrinsics.checkNotNull(marketRedPointPreferencesM2506default);
            return marketRedPointPreferencesM2506default;
        } catch (Exception unused) {
            return MarketRedPointPreferences.INSTANCE.m2506default();
        }
    }

    public void updateExperimental(ExperimentalFunctions obj) {
        String json;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            ExperimentalFunctions experimentalSettings = getExperimentalSettings();
            Boolean webrtcEnabled = obj.getWebrtcEnabled();
            json = this.gson.toJson(new ExperimentalFunctions(Boolean.valueOf((webrtcEnabled == null && (webrtcEnabled = experimentalSettings.getWebrtcEnabled()) == null) ? false : webrtcEnabled.booleanValue())));
            Intrinsics.checkNotNull(json);
        } catch (Exception unused) {
            json = this.gson.toJson(new ExperimentalFunctions(null, 1, null));
            Intrinsics.checkNotNull(json);
        }
        setExperimentalFunctions(json);
    }

    public ExperimentalFunctions getExperimentalSettings() {
        try {
            ExperimentalFunctions experimentalFunctions = StringsKt.isBlank(getExperimentalFunctions()) ? new ExperimentalFunctions(null, 1, null) : (ExperimentalFunctions) this.gson.fromJson(getExperimentalFunctions(), ExperimentalFunctions.class);
            Intrinsics.checkNotNull(experimentalFunctions);
            return experimentalFunctions;
        } catch (Exception unused) {
            return new ExperimentalFunctions(null, 1, null);
        }
    }

    public final void updateIsLoggedIn(boolean newValue) {
        setLoggedIn(newValue);
    }

    public final boolean getIsLoggedIn() {
        return isLoggedIn();
    }

    public void updateCameras(List<Camera> cameras) {
        Intrinsics.checkNotNullParameter(cameras, "cameras");
        set_cameras(cameras);
    }

    public List<Camera> getCameras() {
        List<Camera> list = get_cameras();
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public void updateAppSettings(AppSettings obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        set_appSettings(obj);
    }

    public AppSettings getAppSettings() {
        AppSettings appSettings = get_appSettings();
        return appSettings == null ? AppSettings.INSTANCE.m2542default() : appSettings;
    }

    public EventsSettings getEventsSettings() {
        if (StringsKt.isBlank(get_eventsSettings())) {
            return new EventsSettings(null, 1, null);
        }
        try {
            Object objFromJson = this.gson.fromJson(get_eventsSettings(), (Class<Object>) EventsSettings.class);
            Intrinsics.checkNotNull(objFromJson);
            return (EventsSettings) objFromJson;
        } catch (Exception e) {
            e.printStackTrace();
            return new EventsSettings(null, 1, null);
        }
    }

    public void setEventsSettings(EventsSettings obj) {
        String json;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            json = this.gson.toJson(obj);
            Intrinsics.checkNotNull(json);
        } catch (Exception unused) {
            json = this.gson.toJson(new EventsSettings(null, 1, null));
            Intrinsics.checkNotNull(json);
        }
        set_eventsSettings(json);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoginState.Session.Address getCurrentAddress() {
        LoginState.Session session;
        List<LoginState.Session.Address> listEmptyList;
        Object next;
        Object next2;
        List<LoginState.Session> sessions = getLoginState().getSessions();
        LoginState.Session session2 = null;
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                if (Intrinsics.areEqual(((LoginState.Session) next2).getJwt(), getJwtToken())) {
                    break;
                }
            }
            session = (LoginState.Session) next2;
        } else {
            session = null;
        }
        if (session == null || (listEmptyList = session.getAddresses()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList.isEmpty()) {
            return null;
        }
        List<LoginState.Session.Address> list = listEmptyList;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (((LoginState.Session.Address) next).getIsSelected()) {
                break;
            }
        }
        LoginState.Session.Address address = (LoginState.Session.Address) next;
        if (address == null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                LoginState.Session.Address address2 = (LoginState.Session.Address) obj;
                arrayList.add(address2.copy((383 & 1) != 0 ? address2.id : null, (383 & 2) != 0 ? address2.fullAddress : null, (383 & 4) != 0 ? address2.fullAddressWithApartment : null, (383 & 8) != 0 ? address2.addressVerificationRequired : null, (383 & 16) != 0 ? address2.apartment : null, (383 & 32) != 0 ? address2.flatUUID : null, (383 & 64) != 0 ? address2.entryUUID : null, (383 & 128) != 0 ? address2.isSelected : i == 0, (383 & 256) != 0 ? address2.status : null));
                i = i2;
            }
            address = (LoginState.Session.Address) CollectionsKt.firstOrNull((List) arrayList);
            LoginState loginState = getLoginState();
            List<LoginState.Session> sessions2 = loginState.getSessions();
            if (sessions2 != null) {
                Iterator<T> it3 = sessions2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next3 = it3.next();
                    if (Intrinsics.areEqual(((LoginState.Session) next3).getJwt(), session != null ? session.getJwt() : null)) {
                        session2 = next3;
                        break;
                    }
                }
                session2 = session2;
            }
            if (session2 != null) {
                session2.setAddresses(arrayList);
            }
            setLoginState(loginState);
        }
        return address;
    }

    public List<LoginState.Session.Address> getCurrentAddresses() {
        Object next;
        List<LoginState.Session.Address> addresses;
        List<LoginState.Session> sessions = getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((LoginState.Session) next).getJwt(), getJwtToken())) {
                    break;
                }
            }
            LoginState.Session session = (LoginState.Session) next;
            if (session != null && (addresses = session.getAddresses()) != null) {
                return addresses;
            }
        }
        return CollectionsKt.emptyList();
    }
}
