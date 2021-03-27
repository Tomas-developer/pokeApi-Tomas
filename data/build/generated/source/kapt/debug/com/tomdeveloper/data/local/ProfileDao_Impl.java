package com.tomdeveloper.data.local;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tomdeveloper.data.models.ProfileDto;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProfileDao_Impl implements ProfileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProfileDto> __insertionAdapterOfProfileDto;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ProfileDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProfileDto = new EntityInsertionAdapter<ProfileDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `profile` (`name`,`surname`,`age`,`numBadget`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProfileDto value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getSurname() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSurname());
        }
        if (value.getAge() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getAge());
        }
        if (value.getNumBadget() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getNumBadget());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM profile";
        return _query;
      }
    };
  }

  @Override
  public void save(final ProfileDto transactions) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfileDto.insert(transactions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public ProfileDto getAll() {
    final String _sql = "SELECT * FROM profile";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfSurname = CursorUtil.getColumnIndexOrThrow(_cursor, "surname");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfNumBadget = CursorUtil.getColumnIndexOrThrow(_cursor, "numBadget");
      final ProfileDto _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpSurname;
        _tmpSurname = _cursor.getString(_cursorIndexOfSurname);
        final Integer _tmpAge;
        if (_cursor.isNull(_cursorIndexOfAge)) {
          _tmpAge = null;
        } else {
          _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        }
        final Integer _tmpNumBadget;
        if (_cursor.isNull(_cursorIndexOfNumBadget)) {
          _tmpNumBadget = null;
        } else {
          _tmpNumBadget = _cursor.getInt(_cursorIndexOfNumBadget);
        }
        _result = new ProfileDto(_tmpName,_tmpSurname,_tmpAge,_tmpNumBadget);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
