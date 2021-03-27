package com.tomdeveloper.data.local;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PokemonFavouriteDatabase_Impl extends PokemonFavouriteDatabase {
  private volatile PokemonFavouritesDao _pokemonFavouritesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `favourites` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `url` TEXT, `urlImage` TEXT NOT NULL, `height` TEXT, `weight` REAL, `types` TEXT, `favourite` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '085c8fc8f66cfd32c577b10a900977f2')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `favourites`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFavourites = new HashMap<String, TableInfo.Column>(8);
        _columnsFavourites.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("urlImage", new TableInfo.Column("urlImage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("height", new TableInfo.Column("height", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("weight", new TableInfo.Column("weight", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("types", new TableInfo.Column("types", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("favourite", new TableInfo.Column("favourite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavourites = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavourites = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavourites = new TableInfo("favourites", _columnsFavourites, _foreignKeysFavourites, _indicesFavourites);
        final TableInfo _existingFavourites = TableInfo.read(_db, "favourites");
        if (! _infoFavourites.equals(_existingFavourites)) {
          return new RoomOpenHelper.ValidationResult(false, "favourites(com.tomdeveloper.data.models.PokemonDTO).\n"
                  + " Expected:\n" + _infoFavourites + "\n"
                  + " Found:\n" + _existingFavourites);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "085c8fc8f66cfd32c577b10a900977f2", "70577393fd41a25731dffacd04a701e3");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "favourites");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `favourites`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public PokemonFavouritesDao pokemonFavouriteDao() {
    if (_pokemonFavouritesDao != null) {
      return _pokemonFavouritesDao;
    } else {
      synchronized(this) {
        if(_pokemonFavouritesDao == null) {
          _pokemonFavouritesDao = new PokemonFavouritesDao_Impl(this);
        }
        return _pokemonFavouritesDao;
      }
    }
  }
}
