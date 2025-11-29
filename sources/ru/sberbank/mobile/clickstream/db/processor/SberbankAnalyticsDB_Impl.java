package ru.sberbank.mobile.clickstream.db.processor;

import android.database.SQLException;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import ru.yoomoney.sdk.yooprofiler.YooProfilerImpl;

/* loaded from: classes4.dex */
public final class SberbankAnalyticsDB_Impl extends SberbankAnalyticsDB {
    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(6) { // from class: ru.sberbank.mobile.clickstream.db.processor.SberbankAnalyticsDB_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sba_data` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `meta_id` INTEGER NOT NULL, `profile_id` INTEGER NOT NULL, `is_sending` INTEGER NOT NULL, `event_category` TEXT, `event_action` TEXT NOT NULL, `event_type` TEXT, `value` TEXT, `time_stamp` TEXT NOT NULL, `geo_latitude` TEXT, `geo_longitude` TEXT, `cellular_provider` TEXT, `battery_level` TEXT, `connection_type` TEXT, `internal_ip` TEXT, `properties_map` TEXT, FOREIGN KEY(`meta_id`) REFERENCES `sba_meta`(`_id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`profile_id`) REFERENCES `sba_profile`(`_id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sba_profile` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profile_map` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sba_meta` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `meta_map` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b23cddc15267257c4d4b8229264213ba')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `sba_data`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `sba_profile`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `sba_meta`");
                if (((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                ((RoomDatabase) SberbankAnalyticsDB_Impl.this).mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                SberbankAnalyticsDB_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) SberbankAnalyticsDB_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(16);
                map.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map.put("meta_id", new TableInfo.Column("meta_id", "INTEGER", true, 0, null, 1));
                map.put("profile_id", new TableInfo.Column("profile_id", "INTEGER", true, 0, null, 1));
                map.put("is_sending", new TableInfo.Column("is_sending", "INTEGER", true, 0, null, 1));
                map.put("event_category", new TableInfo.Column("event_category", "TEXT", false, 0, null, 1));
                map.put("event_action", new TableInfo.Column("event_action", "TEXT", true, 0, null, 1));
                map.put(YooProfilerImpl.EVENT_TYPE_ATTRIBUTE_NAME, new TableInfo.Column(YooProfilerImpl.EVENT_TYPE_ATTRIBUTE_NAME, "TEXT", false, 0, null, 1));
                map.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.VALUE, "TEXT", false, 0, null, 1));
                map.put("time_stamp", new TableInfo.Column("time_stamp", "TEXT", true, 0, null, 1));
                map.put("geo_latitude", new TableInfo.Column("geo_latitude", "TEXT", false, 0, null, 1));
                map.put("geo_longitude", new TableInfo.Column("geo_longitude", "TEXT", false, 0, null, 1));
                map.put("cellular_provider", new TableInfo.Column("cellular_provider", "TEXT", false, 0, null, 1));
                map.put("battery_level", new TableInfo.Column("battery_level", "TEXT", false, 0, null, 1));
                map.put("connection_type", new TableInfo.Column("connection_type", "TEXT", false, 0, null, 1));
                map.put("internal_ip", new TableInfo.Column("internal_ip", "TEXT", false, 0, null, 1));
                map.put("properties_map", new TableInfo.Column("properties_map", "TEXT", false, 0, null, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new TableInfo.ForeignKey("sba_meta", "NO ACTION", "NO ACTION", Arrays.asList("meta_id"), Arrays.asList("_id")));
                hashSet.add(new TableInfo.ForeignKey("sba_profile", "NO ACTION", "NO ACTION", Arrays.asList("profile_id"), Arrays.asList("_id")));
                TableInfo tableInfo = new TableInfo("sba_data", map, hashSet, new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "sba_data");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "sba_data(ru.sberbank.mobile.clickstream.db.processor.entities.SberbankAnalyticsDataDBEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(2);
                map2.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map2.put("profile_map", new TableInfo.Column("profile_map", "TEXT", false, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("sba_profile", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "sba_profile");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "sba_profile(ru.sberbank.mobile.clickstream.db.processor.entities.SberbankAnalyticsProfileDBEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(2);
                map3.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map3.put("meta_map", new TableInfo.Column("meta_map", "TEXT", false, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("sba_meta", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(supportSQLiteDatabase, "sba_meta");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "sba_meta(ru.sberbank.mobile.clickstream.db.processor.entities.SberbankAnalyticsMetaDBEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "b23cddc15267257c4d4b8229264213ba", "351440fff04a64738be1b1f54ce6649c")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "sba_data", "sba_profile", "sba_meta");
    }
}
