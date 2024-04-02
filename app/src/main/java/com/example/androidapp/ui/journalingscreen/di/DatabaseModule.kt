package com.example.androidapp.ui.journalingscreen.di

import com.example.androidapp.ui.journalingscreen.data.MongoRepository
import com.example.androidapp.ui.journalingscreen.data.MongoRepositoryImpl
import com.example.androidapp.ui.journalingscreen.model.Note
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.TypedRealmObject
import javax.inject.Singleton
import kotlin.reflect.KClass

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                Note::class
//            ) as Set<KClass<out TypedRealmObject>>
            )
        )
            // optimises the db
            .compactOnLaunch()
            .build()
        return Realm.open(config)
    }

    @Singleton
    @Provides
    fun provideMongoRepository(realm: Realm): MongoRepository {
        return MongoRepositoryImpl.MongoRepositoryImpl(realm = realm)
    }

}