import realm.Configuration
import realm.sync.SyncConfiguration
import kotlin.js.Promise
import realm.sync.User

external fun require(module: String): dynamic

val username    = "test@imac.local"
val password    = "password"
val hostname    = "imac.local"
val server_url  = "http://$hostname:9080"
val realm_url   = "realm://$hostname:9080/~/RealmNode"

fun main(args: Array<String>) {
    println("main(), args: $args")

    val realmPromise = Promise<Realm>({ resolve, reject ->
        if (User.current == null) {
            console.log("Logging into realm object server $server_url as user $username")

            User.login(server_url, username, password, { error, user ->
                if (error != null) {
                    console.log("Error logging in")
                    reject(Exception("Error logging in"))
                }

                console.log("Successfully logged in")
                openRealm(User.current).then({ realm ->
                    resolve(realm)
                })
            })
        }

        console.log("Realm user ${User.current.identity} is currently logged in")
        openRealm(User.current).then({ realm ->
            resolve(realm)
        })
    })
}

fun openRealm(user: User): Promise<Realm> {
    val syncConfig = object : SyncConfiguration {
        override var user = user
        override var url = realm_url
    }
    val config = object : Configuration {
        override var sync: SyncConfiguration? = syncConfig
        override var schema = arrayOf(
            UserSchema()
        )
    }

    // Open the realm
    // synchronously
    // module.exports.realm = new Realm(config)

    // asynchronously
    // Realm.openAsync(config, (error, realm) => {
    //     if (error) {
    //          console.log("Error connecting to realm at url: " + realm_url)
    //          return
    //     }
    //
    //     console.log("Connected to realm at url: " + realm_url)
    //     module.exports.realm = realm
    // })

    // as a Promise
    return Realm.open(config)
}
