import kotlin.js.Promise
//import realm.Realm

// TODO: Change alias after realm js library stubs successfully imported.
typealias RealmType = Any

external fun require(module: String): dynamic

val Realm = require("realm")

val username    = "test@imac.local"
val password    = "password"
val hostname    = "imac.local"
val server_url  = "http://$hostname:9080"
val realm_url   = "realm://$hostname:9080/~/RealmNode"

fun main(args: Array<String>) {
    println("main(), args: $args")

    val realmPromise = Promise<RealmType>({ resolve, reject ->
        if (!Realm.Sync.User.current) {
            console.log("Logging into realm object server $server_url as user $username")

            Realm.Sync.User.login(server_url, username, password, { error, user ->
                if (error) {
                    console.log("Error logging in")
                    reject(Exception("Error logging in"))
                }

                console.log("Successfully logged in")
                resolve(openRealm(Realm.Sync.User.current))
            })
        }

        console.log("Realm user ${Realm.Sync.User.current.identity} is currently logged in")
        resolve(openRealm(Realm.Sync.User.current))
    })
}

fun openRealm(user: User) {
    val config = mapOf(
        "sync" to mapOf(
            "user" to user,
            "url" to realm_url
        ),
        "schema" to arrayOf(
            UserSchema()
        )
    )

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
