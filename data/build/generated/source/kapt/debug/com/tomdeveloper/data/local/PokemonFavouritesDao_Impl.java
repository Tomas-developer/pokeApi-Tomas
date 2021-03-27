package com.tomdeveloper.data.local;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tomdeveloper.data.models.PokemonDTO;
import com.tomdeveloper.data.models.Types;
import com.tomdeveloper.data.models.converters.Converters;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PokemonFavouritesDao_Impl implements PokemonFavouritesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PokemonDTO> __insertionAdapterOfPokemonDTO;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<PokemonDTO> __deletionAdapterOfPokemonDTO;

  public PokemonFavouritesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPokemonDTO = new EntityInsertionAdapter<PokemonDTO>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `favourites` (`id`,`name`,`url`,`urlImage`,`height`,`weight`,`types`,`favourite`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PokemonDTO value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUrl());
        }
        if (value.getUrlImage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUrlImage());
        }
        if (value.getHeight() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHeight());
        }
        if (value.getWeight() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getWeight());
        }
        final String _tmp;
        _tmp = __converters.toJson(value.getTypes());
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp);
        }
        final int _tmp_1;
        _tmp_1 = value.getFavourite() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
      }
    };
    this.__deletionAdapterOfPokemonDTO = new EntityDeletionOrUpdateAdapter<PokemonDTO>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `favourites` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PokemonDTO value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void savePokemonFavourite(final PokemonDTO pokemonDTO) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPokemonDTO.insert(pokemonDTO);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletePokemonFavourite(final PokemonDTO pokemonDTO) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPokemonDTO.handle(pokemonDTO);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PokemonDTO> getPokemonFavourites() {
    final String _sql = "SELECT * FROM favourites";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfUrlImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlImage");
      final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
      final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
      final int _cursorIndexOfTypes = CursorUtil.getColumnIndexOrThrow(_cursor, "types");
      final int _cursorIndexOfFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
      final List<PokemonDTO> _result = new ArrayList<PokemonDTO>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PokemonDTO _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpUrl;
        _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        final String _tmpUrlImage;
        _tmpUrlImage = _cursor.getString(_cursorIndexOfUrlImage);
        final String _tmpHeight;
        _tmpHeight = _cursor.getString(_cursorIndexOfHeight);
        final Double _tmpWeight;
        if (_cursor.isNull(_cursorIndexOfWeight)) {
          _tmpWeight = null;
        } else {
          _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
        }
        final List<Types> _tmpTypes;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTypes);
        _tmpTypes = __converters.toList(_tmp);
        final boolean _tmpFavourite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfFavourite);
        _tmpFavourite = _tmp_1 != 0;
        _item = new PokemonDTO(_tmpId,_tmpName,_tmpUrl,_tmpUrlImage,_tmpHeight,_tmpWeight,_tmpTypes,_tmpFavourite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PokemonDTO getPokemonFavouriteFindId(final int id) {
    final String _sql = "SELECT * FROM favourites WHERE id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfUrlImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlImage");
      final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
      final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
      final int _cursorIndexOfTypes = CursorUtil.getColumnIndexOrThrow(_cursor, "types");
      final int _cursorIndexOfFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
      final PokemonDTO _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpUrl;
        _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        final String _tmpUrlImage;
        _tmpUrlImage = _cursor.getString(_cursorIndexOfUrlImage);
        final String _tmpHeight;
        _tmpHeight = _cursor.getString(_cursorIndexOfHeight);
        final Double _tmpWeight;
        if (_cursor.isNull(_cursorIndexOfWeight)) {
          _tmpWeight = null;
        } else {
          _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
        }
        final List<Types> _tmpTypes;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTypes);
        _tmpTypes = __converters.toList(_tmp);
        final boolean _tmpFavourite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfFavourite);
        _tmpFavourite = _tmp_1 != 0;
        _result = new PokemonDTO(_tmpId,_tmpName,_tmpUrl,_tmpUrlImage,_tmpHeight,_tmpWeight,_tmpTypes,_tmpFavourite);
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
