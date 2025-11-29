package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InvalidationTracker.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 j2\u00020\u0001:\u0004jklmBS\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0011H\u0000¢\u0006\u0004\b \u0010!J'\u0010*\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+H\u0017¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+H\u0017¢\u0006\u0004\b/\u0010.J\u000f\u00103\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u00020\u0011H\u0016¢\u0006\u0004\b4\u0010!J#\u00106\u001a\u00020\u00112\u0012\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005H\u0007¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\rH\u0000¢\u0006\u0004\b8\u0010\u001eJ\u000f\u00109\u001a\u00020\u0011H\u0000¢\u0006\u0004\b8\u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010:\u001a\u0004\b;\u0010<R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010=R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010=R&\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010=\u001a\u0004\b?\u0010@R\"\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010ER\u001a\u0010G\u001a\u00020F8GX\u0087\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010K\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR&\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020[0Z8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010c\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010dR\u001a\u0010g\u001a\u00020f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bg\u0010h\u0012\u0004\bi\u0010!¨\u0006n"}, d2 = {"Landroidx/room/InvalidationTracker;", "", "Landroidx/room/RoomDatabase;", "database", "", "", "shadowTablesMap", "", "viewTables", "", "tableNames", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "tableId", "", "stopTrackingTable", "(Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "startTrackingTable", "names", "resolveViews", "([Ljava/lang/String;)[Ljava/lang/String;", "Landroidx/room/AutoCloser;", "autoCloser", "setAutoCloser$room_runtime_release", "(Landroidx/room/AutoCloser;)V", "setAutoCloser", "internalInit$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "internalInit", "onAutoCloseCallback$room_runtime_release", "()V", "onAutoCloseCallback", "Landroid/content/Context;", "context", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroid/content/Intent;", "serviceIntent", "startMultiInstanceInvalidation$room_runtime_release", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "startMultiInstanceInvalidation", "Landroidx/room/InvalidationTracker$Observer;", "observer", "addObserver", "(Landroidx/room/InvalidationTracker$Observer;)V", "removeObserver", "", "ensureInitialization$room_runtime_release", "()Z", "ensureInitialization", "refreshVersionsAsync", "tables", "notifyObserversByTableNames", "([Ljava/lang/String;)V", "syncTriggers$room_runtime_release", "syncTriggers", "Landroidx/room/RoomDatabase;", "getDatabase$room_runtime_release", "()Landroidx/room/RoomDatabase;", "Ljava/util/Map;", "tableIdLookup", "getTableIdLookup$room_runtime_release", "()Ljava/util/Map;", "tablesNames", "[Ljava/lang/String;", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "Landroidx/room/AutoCloser;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getPendingRefresh", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Z", "Landroidx/sqlite/db/SupportSQLiteStatement;", "cleanupStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getCleanupStatement$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "setCleanupStatement$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "observedTableTracker", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "Landroidx/room/InvalidationLiveDataContainer;", "invalidationLiveDataContainer", "Landroidx/room/InvalidationLiveDataContainer;", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/InvalidationTracker$ObserverWrapper;", "observerMap", "Landroidx/arch/core/internal/SafeIterableMap;", "getObserverMap$room_runtime_release", "()Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/MultiInstanceInvalidationClient;", "multiInstanceInvalidationClient", "Landroidx/room/MultiInstanceInvalidationClient;", "syncTriggersLock", "Ljava/lang/Object;", "trackerLock", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "Companion", "ObservedTableTracker", "Observer", "ObserverWrapper", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class InvalidationTracker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    private AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;
    private final AtomicBoolean pendingRefresh;
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(tableNames.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String str = tableNames[i];
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase2 = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i));
            String str2 = this.shadowTablesMap.get(tableNames[i]);
            if (str2 != null) {
                Intrinsics.checkNotNullExpressionValue(US, "US");
                lowerCase = str2.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i] = lowerCase2;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String lowerCase3 = value.toLowerCase(US2);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String lowerCase4 = key.toLowerCase(US2);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase4, MapsKt.getValue(map, lowerCase3));
            }
        }
        this.refreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Set<Integer> setEmptySet;
                AutoCloser autoCloser;
                AutoCloser autoCloser2;
                Lock closeLock$room_runtime_release = this.this$0.getDatabase().getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                try {
                    try {
                    } catch (SQLiteException e) {
                        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                        setEmptySet = SetsKt.emptySet();
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                        }
                    } catch (IllegalStateException e2) {
                        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                        setEmptySet = SetsKt.emptySet();
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                        }
                    }
                    if (!this.this$0.ensureInitialization$room_runtime_release()) {
                        if (autoCloser2 != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (!this.this$0.getPendingRefresh().compareAndSet(true, false)) {
                        closeLock$room_runtime_release.unlock();
                        AutoCloser autoCloser3 = this.this$0.autoCloser;
                        if (autoCloser3 != null) {
                            autoCloser3.decrementCountAndScheduleClose();
                            return;
                        }
                        return;
                    }
                    if (this.this$0.getDatabase().inTransaction()) {
                        closeLock$room_runtime_release.unlock();
                        AutoCloser autoCloser4 = this.this$0.autoCloser;
                        if (autoCloser4 != null) {
                            autoCloser4.decrementCountAndScheduleClose();
                            return;
                        }
                        return;
                    }
                    SupportSQLiteDatabase writableDatabase = this.this$0.getDatabase().getOpenHelper().getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        setEmptySet = checkUpdatedTable();
                        writableDatabase.setTransactionSuccessful();
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                            autoCloser.decrementCountAndScheduleClose();
                        }
                        if (setEmptySet.isEmpty()) {
                            return;
                        }
                        SafeIterableMap<InvalidationTracker.Observer, InvalidationTracker.ObserverWrapper> observerMap$room_runtime_release = this.this$0.getObserverMap$room_runtime_release();
                        InvalidationTracker invalidationTracker = this.this$0;
                        synchronized (observerMap$room_runtime_release) {
                            try {
                                Iterator<Map.Entry<K, V>> it = invalidationTracker.getObserverMap$room_runtime_release().iterator();
                                while (it.hasNext()) {
                                    ((InvalidationTracker.ObserverWrapper) ((Map.Entry) it.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setEmptySet);
                                }
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } finally {
                    closeLock$room_runtime_release.unlock();
                    autoCloser2 = this.this$0.autoCloser;
                    if (autoCloser2 != null) {
                        autoCloser2.decrementCountAndScheduleClose();
                    }
                }
            }

            private final Set<Integer> checkUpdatedTable() {
                InvalidationTracker invalidationTracker = this.this$0;
                Set setCreateSetBuilder = SetsKt.createSetBuilder();
                Cursor cursorQuery$default = RoomDatabase.query$default(invalidationTracker.getDatabase(), new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
                try {
                    Cursor cursor = cursorQuery$default;
                    while (cursor.moveToNext()) {
                        setCreateSetBuilder.add(Integer.valueOf(cursor.getInt(0)));
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursorQuery$default, null);
                    Set<Integer> setBuild = SetsKt.build(setCreateSetBuilder);
                    if (!setBuild.isEmpty()) {
                        if (this.this$0.getCleanupStatement() == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        SupportSQLiteStatement cleanupStatement = this.this$0.getCleanupStatement();
                        if (cleanupStatement == null) {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                        cleanupStatement.executeUpdateDelete();
                    }
                    return setBuild;
                } finally {
                }
            }
        };
    }

    /* renamed from: getDatabase$room_runtime_release, reason: from getter */
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    /* renamed from: getCleanupStatement$room_runtime_release, reason: from getter */
    public final SupportSQLiteStatement getCleanupStatement() {
        return this.cleanupStatement;
    }

    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new Runnable() { // from class: androidx.room.InvalidationTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onAutoCloseCallback$room_runtime_release();
            }
        });
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            syncTriggers$room_runtime_release(database);
            this.cleanupStatement = database.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.initialized = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onAutoCloseCallback$room_runtime_release() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String name, Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, serviceIntent, this, this.database.getQueryExecutor());
    }

    private final void stopTrackingTable(SupportSQLiteDatabase db, int tableId) throws SQLException {
        String str = this.tablesNames[tableId];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + INSTANCE.getTriggerName$room_runtime_release(str, str2);
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            db.execSQL(str3);
        }
    }

    private final void startTrackingTable(SupportSQLiteDatabase db, int tableId) throws SQLException {
        db.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + tableId + ", 0)");
        String str = this.tablesNames[tableId];
        for (String str2 : TRIGGERS) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + INSTANCE.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + tableId + " AND invalidated = 0; END";
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            db.execSQL(str3);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void addObserver(Observer observer) {
        ObserverWrapper observerWrapperPutIfAbsent;
        Intrinsics.checkNotNullParameter(observer, "observer");
        String[] strArrResolveViews = resolveViews(observer.getTables());
        ArrayList arrayList = new ArrayList(strArrResolveViews.length);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            arrayList.add(num);
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, intArray, strArrResolveViews);
        synchronized (this.observerMap) {
            observerWrapperPutIfAbsent = this.observerMap.putIfAbsent(observer, observerWrapper);
        }
        if (observerWrapperPutIfAbsent == null && this.observedTableTracker.onAdded(Arrays.copyOf(intArray, intArray.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    private final String[] resolveViews(String[] names) {
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        for (String str : names) {
            Map<String, Set<String>> map = this.viewTables;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase2 = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                Intrinsics.checkNotNull(set);
                setCreateSetBuilder.addAll(set);
            } else {
                setCreateSetBuilder.add(str);
            }
        }
        Object[] array = SetsKt.build(setCreateSetBuilder).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    @SuppressLint({"RestrictedApi"})
    public void removeObserver(Observer observer) {
        ObserverWrapper observerWrapperRemove;
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.observerMap) {
            observerWrapperRemove = this.observerMap.remove(observer);
        }
        if (observerWrapperRemove != null) {
            ObservedTableTracker observedTableTracker = this.observedTableTracker;
            int[] tableIds = observerWrapperRemove.getTableIds();
            if (observedTableTracker.onRemoved(Arrays.copyOf(tableIds, tableIds.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpen()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    public final void notifyObserversByTableNames(String... tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        synchronized (this.observerMap) {
            try {
                Iterator<Map.Entry<K, V>> it = this.observerMap.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Intrinsics.checkNotNullExpressionValue(entry, "(observer, wrapper)");
                    Observer observer = (Observer) entry.getKey();
                    ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                    if (!observer.isRemote$room_runtime_release()) {
                        observerWrapper.notifyByTableNames$room_runtime_release(tables);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        if (database.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    INSTANCE.beginTransactionInternal$room_runtime_release(database);
                    try {
                        int length = tablesToSync.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            int i3 = tablesToSync[i];
                            int i4 = i2 + 1;
                            if (i3 == 1) {
                                startTrackingTable(database, i2);
                            } else if (i3 == 2) {
                                stopTrackingTable(database, i2);
                            }
                            i++;
                            i2 = i4;
                        }
                        database.setTransactionSuccessful();
                        database.endTransaction();
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        database.endTransaction();
                        throw th;
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
        } catch (IllegalStateException e2) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
        }
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpen()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/room/InvalidationTracker$ObserverWrapper;", "", "Landroidx/room/InvalidationTracker$Observer;", "observer", "", "tableIds", "", "", "tableNames", "<init>", "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "", "", "invalidatedTablesIds", "", "notifyByTableInvalidStatus$room_runtime_release", "(Ljava/util/Set;)V", "notifyByTableInvalidStatus", "tables", "notifyByTableNames$room_runtime_release", "([Ljava/lang/String;)V", "notifyByTableNames", "Landroidx/room/InvalidationTracker$Observer;", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "[I", "getTableIds$room_runtime_release", "()[I", "[Ljava/lang/String;", "singleTableSet", "Ljava/util/Set;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            Set<String> setEmptySet;
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            this.observer = observer;
            this.tableIds = tableIds;
            this.tableNames = tableNames;
            if (!(tableNames.length == 0)) {
                setEmptySet = SetsKt.setOf(tableNames[0]);
            } else {
                setEmptySet = SetsKt.emptySet();
            }
            this.singleTableSet = setEmptySet;
            if (tableIds.length != tableNames.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        /* renamed from: getTableIds$room_runtime_release, reason: from getter */
        public final int[] getTableIds() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> invalidatedTablesIds) {
            Set<String> setEmptySet;
            Intrinsics.checkNotNullParameter(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            if (length != 0) {
                int i = 0;
                if (length == 1) {
                    if (invalidatedTablesIds.contains(Integer.valueOf(iArr[0]))) {
                        setEmptySet = this.singleTableSet;
                    } else {
                        setEmptySet = SetsKt.emptySet();
                    }
                } else {
                    Set setCreateSetBuilder = SetsKt.createSetBuilder();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i2 = 0;
                    while (i < length2) {
                        int i3 = i2 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i]))) {
                            setCreateSetBuilder.add(this.tableNames[i2]);
                        }
                        i++;
                        i2 = i3;
                    }
                    setEmptySet = SetsKt.build(setCreateSetBuilder);
                }
            } else {
                setEmptySet = SetsKt.emptySet();
            }
            if (setEmptySet.isEmpty()) {
                return;
            }
            this.observer.onInvalidated(setEmptySet);
        }

        public final void notifyByTableNames$room_runtime_release(String[] tables) {
            Set<String> setEmptySet;
            Intrinsics.checkNotNullParameter(tables, "tables");
            int length = this.tableNames.length;
            if (length != 0) {
                if (length != 1) {
                    Set setCreateSetBuilder = SetsKt.createSetBuilder();
                    for (String str : tables) {
                        for (String str2 : this.tableNames) {
                            if (StringsKt.equals(str2, str, true)) {
                                setCreateSetBuilder.add(str2);
                            }
                        }
                    }
                    setEmptySet = SetsKt.build(setCreateSetBuilder);
                } else {
                    int length2 = tables.length;
                    int i = 0;
                    while (true) {
                        if (i < length2) {
                            if (StringsKt.equals(tables[i], this.tableNames[0], true)) {
                                setEmptySet = this.singleTableSet;
                                break;
                            }
                            i++;
                        } else {
                            setEmptySet = SetsKt.emptySet();
                            break;
                        }
                    }
                }
            } else {
                setEmptySet = SetsKt.emptySet();
            }
            if (setEmptySet.isEmpty()) {
                return;
            }
            this.observer.onInvalidated(setEmptySet);
        }
    }

    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/room/InvalidationTracker$Observer;", "", "", "", "tables", "<init>", "([Ljava/lang/String;)V", "", "", "onInvalidated", "(Ljava/util/Set;)V", "[Ljava/lang/String;", "getTables$room_runtime_release", "()[Ljava/lang/String;", "", "isRemote$room_runtime_release", "()Z", "isRemote", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Observer {
        private final String[] tables;

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> tables);

        public Observer(String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            this.tables = tables;
        }

        /* renamed from: getTables$room_runtime_release, reason: from getter */
        public final String[] getTables() {
            return this.tables;
        }
    }

    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\f\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00020\u0006\"\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\n\u0010\u0007\u001a\u00020\u0006\"\u00020\u0002¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker;", "", "", "tableCount", "<init>", "(I)V", "", "tableIds", "", "onAdded", "([I)Z", "onRemoved", "", "resetTriggerState", "()V", "getTablesToSync", "()[I", "", "tableObservers", "[J", "getTableObservers", "()[J", "", "triggerStates", "[Z", "triggerStateChanges", "[I", "needsSync", "Z", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ObservedTableTracker {
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        public ObservedTableTracker(int i) {
            this.tableObservers = new long[i];
            this.triggerStates = new boolean[i];
            this.triggerStateChanges = new int[i];
        }

        public final boolean onAdded(int... tableIds) {
            boolean z;
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : tableIds) {
                        long[] jArr = this.tableObservers;
                        long j = jArr[i];
                        jArr[i] = 1 + j;
                        if (j == 0) {
                            this.needsSync = true;
                            z = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public final boolean onRemoved(int... tableIds) {
            boolean z;
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : tableIds) {
                        long[] jArr = this.tableObservers;
                        long j = jArr[i];
                        jArr[i] = j - 1;
                        if (j == 1) {
                            this.needsSync = true;
                            z = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final int[] getTablesToSync() {
            synchronized (this) {
                try {
                    if (!this.needsSync) {
                        return null;
                    }
                    long[] jArr = this.tableObservers;
                    int length = jArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        int i4 = 1;
                        boolean z = jArr[i] > 0;
                        boolean[] zArr = this.triggerStates;
                        if (z != zArr[i2]) {
                            int[] iArr = this.triggerStateChanges;
                            if (!z) {
                                i4 = 2;
                            }
                            iArr[i2] = i4;
                        } else {
                            this.triggerStateChanges[i2] = 0;
                        }
                        zArr[i2] = z;
                        i++;
                        i2 = i3;
                    }
                    this.needsSync = false;
                    return (int[]) this.triggerStateChanges.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/room/InvalidationTracker$Companion;", "", "<init>", "()V", "", "tableName", "triggerType", "getTriggerName$room_runtime_release", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getTriggerName", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", "", "beginTransactionInternal$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "beginTransactionInternal", "CREATE_TRACKING_TABLE_SQL", "Ljava/lang/String;", "INVALIDATED_COLUMN_NAME", "TABLE_ID_COLUMN_NAME", "", "TRIGGERS", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTriggerName$room_runtime_release(String tableName, String triggerType) {
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            Intrinsics.checkNotNullParameter(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            if (database.isWriteAheadLoggingEnabled()) {
                database.beginTransactionNonExclusive();
            } else {
                database.beginTransaction();
            }
        }
    }
}
