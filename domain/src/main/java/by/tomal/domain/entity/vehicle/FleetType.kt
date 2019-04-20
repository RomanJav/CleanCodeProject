package by.tomal.domain.entity.vehicle

enum class FleetType {
    TAXI, POOLING, UNDEFINED;

    companion object {
        fun fromString(typeString: String): FleetType {
            return when (typeString) {
                "TAXI" -> TAXI
                "POOLING" -> POOLING
                else -> UNDEFINED
            }
        }
    }
}