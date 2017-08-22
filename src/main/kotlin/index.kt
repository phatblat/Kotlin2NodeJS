@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

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

@JsModule("realm")
external open class Realm {
    constructor(config: Realm.Configuration? = definedExternally /* null */)
    constructor(path: String? = definedExternally /* null */)
    open var empty: Boolean = definedExternally
    open var path: String = definedExternally
    open var readOnly: Boolean = definedExternally
    open var schema: Array<Realm.ObjectSchema> = definedExternally
    open var schemaVersion: Number = definedExternally
    open var syncSession: Realm.Sync.Session? = definedExternally
    open fun close(): Unit = definedExternally
    open fun <T> create(type: String, properties: T /* T & Realm.ObjectPropsType */, update: Boolean? = definedExternally /* null */): T = definedExternally
    open fun <T> create(type: Realm.ObjectClass, properties: T /* T & Realm.ObjectPropsType */, update: Boolean? = definedExternally /* null */): T = definedExternally
    open fun <T> create(type: Function<*>, properties: T /* T & Realm.ObjectPropsType */, update: Boolean? = definedExternally /* null */): T = definedExternally
    open fun delete(`object`: Realm.Object): Unit = definedExternally
    open fun delete(`object`: Array<Realm.Object>): Unit = definedExternally
    open fun delete(`object`: Realm.List<Any>): Unit = definedExternally
    open fun delete(`object`: Realm.Results<Any>): Unit = definedExternally
    open fun delete(`object`: Any): Unit = definedExternally
    open fun deleteAll(): Unit = definedExternally
    open fun <T> objectForPrimaryKey(type: String, key: Number): T? = definedExternally
    open fun <T> objectForPrimaryKey(type: String, key: String): T? = definedExternally
    open fun <T> objectForPrimaryKey(type: Realm.ObjectSchema, key: Number): T? = definedExternally
    open fun <T> objectForPrimaryKey(type: Realm.ObjectSchema, key: String): T? = definedExternally
    open fun <T> objectForPrimaryKey(type: Function<*>, key: Number): T? = definedExternally
    open fun <T> objectForPrimaryKey(type: Function<*>, key: String): T? = definedExternally
    open fun <T> objects(type: String): Realm.Results<T> = definedExternally
    open fun <T> objects(type: Realm.ObjectSchema): Realm.Results<T> = definedExternally
    open fun <T> objects(type: Function<*>): Realm.Results<T> = definedExternally
    open fun addListener(name: String, callback: (sender: Realm, event: Any /* "change" */) -> Unit): Unit = definedExternally
    open fun removeListener(name: String, callback: (sender: Realm, event: Any /* "change" */) -> Unit): Unit = definedExternally
    open fun removeAllListeners(name: String? = definedExternally /* null */): Unit = definedExternally
    open fun write(callback: () -> Unit): Unit = definedExternally
    companion object {
        var defaultPath: String = definedExternally
        fun schemaVersion(path: String, encryptionKey: ArrayBuffer? = definedExternally /* null */): Number = definedExternally
        fun schemaVersion(path: String, encryptionKey: ArrayBufferView? = definedExternally /* null */): Number = definedExternally
        fun open(config: Realm.Configuration): Promise<Realm> = definedExternally
        fun openAsync(config: Realm.Configuration, callback: (error: Any, realm: Realm) -> Unit): Unit = definedExternally
    }
}
