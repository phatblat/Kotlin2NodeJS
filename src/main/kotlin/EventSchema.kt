import realm.ObjectSchema
import realm.PropertiesTypes

open class Event: ObjectSchema {
    override var name = "Event"
    override var primaryKey: String? = "id"
    override var properties: PropertiesTypes = mapOf(
            "id" to "string",
            "name" to "string"
    ) as PropertiesTypes
}
