@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:[JsQualifier("Realm") JsModule("realm")]
package Realm

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

external interface ObjectSchemaProperty {
    var type: dynamic /* String | Any /* "bool" */ | Any /* "int" */ | Any /* "float" */ | Any /* "double" */ | Any /* "string" */ | Any /* "data" */ | Any /* "date" */ | Any /* "list" */ | Any /* "linkingObjects" */ */
    var objectType: String? get() = definedExternally; set(value) = definedExternally
    var property: String? get() = definedExternally; set(value) = definedExternally
    var default: Any? get() = definedExternally; set(value) = definedExternally
    var optional: Boolean? get() = definedExternally; set(value) = definedExternally
    var indexed: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface PropertiesTypes {
    @nativeGetter
    operator fun get(keys: String): dynamic /* String | Any /* "bool" */ | Any /* "int" */ | Any /* "float" */ | Any /* "double" */ | Any /* "string" */ | Any /* "data" */ | Any /* "date" */ | Any /* "list" */ | Any /* "linkingObjects" */ | ObjectSchemaProperty */
    @nativeSetter
    operator fun set(keys: String, value: String)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "bool" */)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "int" */)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "float" */)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "double" */)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "string" */)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "data" */)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "date" */)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "list" */)
    @nativeSetter
    operator fun set(keys: String, value: Any /* "linkingObjects" */)
    @nativeSetter
    operator fun set(keys: String, value: ObjectSchemaProperty)
}
external interface ObjectSchema {
    var name: String
    var primaryKey: String? get() = definedExternally; set(value) = definedExternally
    var properties: PropertiesTypes
}
external interface ObjectClass {
    var schema: ObjectSchema
}
external interface ObjectType {
    var type: ObjectClass
}
external interface Configuration {
    var encryptionKey: dynamic /* ArrayBuffer | ArrayBufferView | Int8Array */ get() = definedExternally; set(value) = definedExternally
    var migration: ((oldRealm: Realm, newRealm: Realm) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var readOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var schema: dynamic /* Array<ObjectClass> | Array<ObjectSchema> */ get() = definedExternally; set(value) = definedExternally
    var schemaVersion: Number? get() = definedExternally; set(value) = definedExternally
    var sync: Realm.Sync.SyncConfiguration? get() = definedExternally; set(value) = definedExternally
}
external interface ObjectPropsType {
    @nativeGetter
    operator fun get(keys: String): Any?
    @nativeSetter
    operator fun set(keys: String, value: Any)
}
external interface Object {
    fun isValid(): Boolean
    fun objectSchema(): ObjectSchema
    fun <T> linkingObjects(objectType: String, property: String): Results<T>
    companion object : ``T$0` by definedExternally: `T$0`` {
    }
}
external interface `T$0` {
    var prototype: Any
}
external interface CollectionChangeSet {
    var insertions: Array<Number>
    var deletions: Array<Number>
    var modifications: Array<Number>
}
external interface Collection<T> : ReadonlyArray<T> {
    fun isValid(): Boolean
    fun filtered(query: String, vararg arg: Any): Results<T>
    fun sorted(descriptor: String, reverse: Boolean? = definedExternally /* null */): Results<T>
    fun sorted(descriptor: Array<Any>, reverse: Boolean? = definedExternally /* null */): Results<T>
    fun snapshot(): Results<T>
    fun addListener(callback: (collection: Collection<T>, change: CollectionChangeSet) -> Unit)
    fun removeAllListeners()
    fun removeListener(callback: (collection: Collection<T>, change: CollectionChangeSet) -> Unit)
    companion object : ``T$1` by definedExternally: `T$1`` {
    }
}
external interface `T$1` {
    var prototype: Collection<Any>
}
external interface List<T> : Collection<T> {
    @nativeGetter
    operator fun get(n: Number): T?
    @nativeSetter
    operator fun set(n: Number, value: T)
    fun pop(): T?
    fun push(`object`: T): Number
    fun shift(): T?
    fun splice(index: Number, count: Number? = definedExternally /* null */, `object`: Any? = definedExternally /* null */): Array<T>
    fun unshift(`object`: T): Number
    companion object : ``T$2` by definedExternally: `T$2`` {
    }
}
external interface `T$2` {
    var prototype: List<Any>
}
external var Results: `T$3` = definedExternally
external interface `T$3` {
    var prototype: Results<Any>
}
