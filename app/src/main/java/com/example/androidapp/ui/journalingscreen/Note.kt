import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidapp.ui.theme.Pink80
import com.example.androidapp.ui.theme.Purple40
import com.example.androidapp.ui.theme.Purple80
import com.example.androidapp.ui.theme.PurpleGrey80


// This annotation indicates that the class represents
// an entity in the Room database,
@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    //unique identifier for each record within that entity.
    @PrimaryKey val id: Int? = null
) {
    companion object{
        val noteColors = listOf(
            Purple80, PurpleGrey80,
            Pink80, Purple40)
    }
}

class InvalidNoteException(message: String): Exception(message)
