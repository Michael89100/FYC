import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    val userName = mutableStateOf("")
    val userEmail = mutableStateOf("")
    val userBio = mutableStateOf("")
    val notificationsEnabled = mutableStateOf(false)
    val newsletterSubscribed = mutableStateOf(false)
    val activityLevel = mutableStateOf(0.5f)
    val isUpdating = mutableStateOf(false)
    val updateConfirmation = mutableStateOf("")

    fun updateProfile() {
        isUpdating.value = true
        viewModelScope.launch {
            delay(2000)
            updateConfirmation.value = "Profil mis à jour avec succès !"
            isUpdating.value = false
        }
    }

    fun onNameChange(newName: String) {
        userName.value = newName
    }

    fun onEmailChange(newEmail: String) {
        userEmail.value = newEmail
    }

    fun onBioChange(newBio: String) {
        userBio.value = newBio
    }

    fun onNotificationsToggle() {
        notificationsEnabled.value = !notificationsEnabled.value
    }

    fun onNewsletterToggle() {
        newsletterSubscribed.value = !newsletterSubscribed.value
    }

    fun onActivityLevelChange(newLevel: Float) {
        activityLevel.value = newLevel
    }
}
