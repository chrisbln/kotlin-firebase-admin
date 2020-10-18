package firebase

import kotlin.js.Date

@JsModule("firebase-admin")
external object admin {

    fun app(name: String? = definedExternally): App
    fun initializeApp(): App
    fun initializeApp(options: Any, name: String? = definedExternally): App

    /**
     * JS: firebase.storage().bucket("images")
     */
    fun storage(): admin.storage.Storage

    object firestore {
        open class Timestamp {
            companion object {
                fun now(): Timestamp
                fun fromDate(date: Date): Timestamp
                fun fromMillis(milliseconds: Double): Timestamp
            }

            fun toDate(): Date
            fun toMillis(): Double
            fun isEqual(other: Timestamp): Boolean
        }

        open class FieldValue {
            companion object {
                fun increment(n: Int): FieldValue
            }
        }
    }

    /**
     * declare namespace admin.storage
     */
    object storage {
        open class Storage {
            /**
             *
             * @returns A [Bucket](https://cloud.google.com/nodejs/docs/reference/storage/latest/Bucket)
             * instance as defined in the `@google-cloud/storage` package.
             *
             * JS: bucket(name?: string): Bucket;
             */
            fun bucket(name: String?): Bucket
        }
    }

}

external interface App {
    val name: String
    fun auth(): Auth
    fun firestore(): Firestore
}


