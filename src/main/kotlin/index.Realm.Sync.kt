@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("Realm.Sync")
package realm.sync

import Realm
import realm.*

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external interface UserInfo {
    var id: String
    var isAdmin: Boolean
}
external interface Account {
    var provider_id: String
    var provider: String
    var user: UserInfo
}
external interface `T$4` {
    @nativeGetter
    operator fun get(identity: String): User?
    @nativeSetter
    operator fun set(identity: String, value: User)
}
external interface `T$5` {
    var provider: String
    var providerToken: String
    var userInfo: Any
}
external open class User {
    open var identity: String = definedExternally
    open var isAdmin: Boolean = definedExternally
    open var server: String = definedExternally
    open var token: String = definedExternally
    open fun logout(): Unit = definedExternally
    open fun openManagementRealm(): Realm = definedExternally
    open fun retrieveAccount(provider: String, username: String): Promise<Account> = definedExternally
    companion object {
        var all: `T$4` = definedExternally
        var current: User? = definedExternally
        fun adminUser(adminToken: String, server: String? = definedExternally /* null */): User = definedExternally
        fun login(server: String, username: String, password: String, callback: (error: Error?, user: User?) -> Unit): Unit = definedExternally
        fun loginWithProvider(server: String, provider: String, providerToken: String, callback: (error: Error?, user: User?) -> Unit): Unit = definedExternally
        fun register(server: String, username: String, password: String, callback: (error: Error?, user: User?) -> Unit): Unit = definedExternally
        fun registerWithProvider(server: String, options: `T$5`, callback: (error: Error?, user: User?) -> Unit): Unit = definedExternally
    }
}
external interface SyncConfiguration {
    var user: User
    var url: String
    var validate_ssl: Boolean? get() = definedExternally; set(value) = definedExternally
    var ssl_trust_certificate_path: String? get() = definedExternally; set(value) = definedExternally
}
external open class Session {
    open var config: SyncConfiguration = definedExternally
    open var state: dynamic /* Any /* "invalid" */ | Any /* "active" */ | Any /* "inactive" */ */ = definedExternally
    open var url: String = definedExternally
    open var user: User = definedExternally
}
external open class AuthError {
    open var code: Number = definedExternally
    open var type: String = definedExternally
}
external interface ObjectPropsType {
    @nativeGetter
    operator fun get(object_type: String): CollectionChangeSet?
    @nativeSetter
    operator fun set(object_type: String, value: CollectionChangeSet)
}
external interface ChangeEvent {
    var changes: ObjectPropsType
    var oldRealm: Realm
    var path: String
    var realm: Realm
}
external fun addListener(serverURL: String, adminUser: User, regex: String, name: String, changeCallback: (changeEvent: ChangeEvent) -> Unit): Unit = definedExternally
external fun removeAllListeners(name: String? = definedExternally /* null */): Unit = definedExternally
external fun removeListener(regex: String, name: String, changeCallback: (changeEvent: ChangeEvent) -> Unit): Unit = definedExternally
external fun setLogLevel(logLevel: Any /* "error" */): Unit = definedExternally
external fun setLogLevel(logLevel: Any /* "info" */): Unit = definedExternally
external fun setLogLevel(logLevel: Any /* "debug" */): Unit = definedExternally
external fun setAccessToken(accessToken: String): Unit = definedExternally
external interface `T$7` {
    var type: dynamic /* Any /* "INSERT" */ | Any /* "SET" */ | Any /* "DELETE" */ | Any /* "CLEAR" */ | Any /* "LIST_SET" */ | Any /* "LIST_INSERT" */ | Any /* "LIST_ERASE" */ | Any /* "LIST_CLEAR" */ | Any /* "ADD_TYPE" */ | Any /* "ADD_PROPERTIES" */ */
    var object_type: String
    var identity: String
    var values: Any?
    var list_index: Any?
    var object_identity: Any?
    var new_identity: Any?
    var property: Any?
    var properties: Any?
    var primary_key: String?
}
external open class Adapter(local_path: String, server_url: String, admin_user: User, regex: String, change_callback: Function<*>) {
    open fun advance(path: String): Unit = definedExternally
    open fun close(): Unit = definedExternally
    open fun current(path: String): Array<`T$7`> = definedExternally
    open fun realmAtPath(path: String, realmID: String? = definedExternally /* null */, schema: Array<ObjectSchema>? = definedExternally /* null */): Realm = definedExternally
}
