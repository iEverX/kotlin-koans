package iv_properties

import util.TODO
import util.doc32
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PropertyExample {
    var counter = 0
    var propertyWithCounter: Int by Delegates.observable(0) {
        _, _, _ -> ++this.counter
    }
}

fun todoTask32(): Nothing = TODO(
    """
        Task 32.
        Add a custom setter to PropertyExample.propertyWithCounter so that
        the 'counter' property is incremented every time 'propertyWithCounter' is assigned to.
    """,
    documentation = doc32(),
    references = { PropertyExample() }
)
