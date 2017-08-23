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

    Promise<Realm>({ resolve, reject ->
        login(server_url, username, password)
        .then({ user ->
            openRealm(user).then({ realm ->
                resolve(realm)
            })
        })
        .catch({ error ->
            console.log(error)
            reject(error)
        })
    })
    .then({
        User.current?.logout()
        console.log("Sync user logged out")
//        process.exit()
    })
    .catch({ error ->
        console.log("Error: " + error)
//        process.exit(1)
    })
}

/**
 * Private function which logs a user into an object server.
 * @return Promise that resolves to a realm.
 */
fun login(server_url: String, username: String, password: String): Promise<User> {
    val current_user = User.current
    if (current_user != null) {
        console.log("Realm user ${current_user.identity} is currently logged in")
        return Promise.resolve(current_user)
    }

    return Promise<User>({ resolve, reject ->
        console.log("Logging into realm object server $server_url as user $username")
        User.login(server_url, username, password, { error, user ->
            if (error != null) {
                console.log("Error logging in")
                reject(Exception("Error logging in"))
            }

            if (user != null) {
                console.log("Successfully logged in")
                resolve(user)
            }

            reject(Exception("No error, but no user returned after login."))
        })
    })
}

/**
 * Private function which opens a realm for a given user.
 * @return Promise that resolves to a realm.
 */
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
