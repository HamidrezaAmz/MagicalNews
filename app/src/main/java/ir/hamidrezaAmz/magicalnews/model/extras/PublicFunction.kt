package ir.hamidrezaAmz.magicalnews.model.extras

import java.util.*

class PublicFunction {

    companion object {

        fun getDisplayLanguage(languageCode: String? = "US"): String {
            val loc = Locale(languageCode)
            return loc.displayLanguage
        }
    }

}