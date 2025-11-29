package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class PreferenceDao_Impl implements PreferenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Preference> __insertionAdapterOfPreference;

    public PreferenceDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPreference = new EntityInsertionAdapter<Preference>(__db) { // from class: androidx.work.impl.model.PreferenceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Preference value) {
                if (value.getKey() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getKey());
                }
                if (value.getValue() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindLong(2, value.getValue().longValue());
                }
            }
        };
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void insertPreference(final Preference preference) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPreference.insert(preference);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public Long getLongValue(final String key) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (key == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, key);
        }
        this.__db.assertNotSuspendingTransaction();
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                lValueOf = Long.valueOf(cursorQuery.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
