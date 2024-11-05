import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = ProfileViewModel()) {
    val userName by viewModel.userName
    val userEmail by viewModel.userEmail
    val userBio by viewModel.userBio
    val notificationsEnabled by viewModel.notificationsEnabled
    val newsletterSubscribed by viewModel.newsletterSubscribed
    val activityLevel by viewModel.activityLevel
    val isUpdating by viewModel.isUpdating
    val updateConfirmation by viewModel.updateConfirmation

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Champ de saisie pour le nom
        OutlinedTextField(
            value = userName,
            onValueChange = { viewModel.onNameChange(it) },
            label = { Text("Nom") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Champ de saisie pour l'email
        OutlinedTextField(
            value = userEmail,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Champ de saisie pour la biographie
        OutlinedTextField(
            value = userBio,
            onValueChange = { viewModel.onBioChange(it) },
            label = { Text("Biographie") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = false,
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Switch pour activer les notifications
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Activer les notifications")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = notificationsEnabled,
                onCheckedChange = { viewModel.onNotificationsToggle() }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Switch pour s'abonner à la newsletter
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Abonné à la newsletter")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = newsletterSubscribed,
                onCheckedChange = { viewModel.onNewsletterToggle() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Slider pour le niveau d'activité
        Text("Niveau d'activité")
        Slider(
            value = activityLevel,
            onValueChange = { viewModel.onActivityLevelChange(it) },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bouton de mise à jour
        Button(
            onClick = { viewModel.updateProfile() },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isUpdating
        ) {
            if (isUpdating) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = Color.White,
                    strokeWidth = 2.dp
                )
            } else {
                Text("Mettre à jour")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Message de confirmation
        if (updateConfirmation.isNotEmpty()) {
            Text(text = updateConfirmation, color = Color.Green)
        }
    }
}
