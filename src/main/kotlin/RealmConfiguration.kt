import realm.Configuration
import realm.ObjectSchema
import realm.sync.User
import realm.sync.SyncConfiguration

data class RealmConfiguration(
    var sync: RealmSyncConfiguration,
    var schema: Array<ObjectSchema>
) {
    override fun toString() = "{sync:$sync,schema:$schema}"
}

data class RealmSyncConfiguration(
    var user: User,
    var url: String
) {
    override fun toString() = "{user:\"$user\",url:\"$url\"}"
}
