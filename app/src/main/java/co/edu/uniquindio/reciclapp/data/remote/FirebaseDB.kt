package co.edu.uniquindio.reciclapp.data.remote

import co.edu.uniquindio.reciclapp.data.ObjetoBase
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException

val db by lazy { Firebase.firestore }

class FirebaseDB {
    @ExperimentalCoroutinesApi
    companion object {
        suspend fun <T> obtenerPorId(obj: ObjetoBase, clase: Class<T>): T ? {
            val snapshot = db.collection(obj.coleccion).whereEqualTo("id", obj.id).get().await()
            val documents = snapshot?.documents
            return if (documents != null && documents.isNotEmpty()) {
                documents[0].toObject(clase)
            } else {
                null
            }
        }

        suspend fun insertar(obj: ObjetoBase) : Boolean {
            val snapshot = db.collection(obj.coleccion).add(obj).await()
            return snapshot != null
        }
    }
}


@ExperimentalCoroutinesApi
private suspend fun <T> Task<T>.await(): T? {
    if (isComplete) {
        val e = exception
        return if (e == null) {
            if (isCanceled) {
                throw CancellationException(
                    "Task $this was cancelled normally.")
            } else {
                result
            }
        } else {
            throw e
        }
    }

    return suspendCancellableCoroutine { cont ->
        addOnCompleteListener {
            val e = exception
            if (e == null) {
                if (isCanceled) cont.cancel() else cont.resume(result, null)
            } else {
                cont.resumeWithException(e)
            }
        }
    }
}

