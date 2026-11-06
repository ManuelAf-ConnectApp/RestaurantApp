package com.connectapp.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.connectapp.commonresources.resources.Res
import com.connectapp.commonresources.resources.restaurant_card_ambience
import com.connectapp.presentation.home.RestaurantPreview
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun HomeCard(restaurant: RestaurantPreview, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
        shape = MaterialTheme.shapes.large,
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    modifier = Modifier.size(96.dp).clip(MaterialTheme.shapes.medium),
                    color = MaterialTheme.colorScheme.surfaceVariant,
                ) {
                    androidx.compose.foundation.Image(
                        painter = painterResource(Res.drawable.restaurant_card_ambience),
                        contentDescription = "Ambiente de ${restaurant.name}",
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(restaurant.name, style = MaterialTheme.typography.titleMedium)
                    Text("${restaurant.cuisine.label} · ${restaurant.city}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(restaurant.description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("Tarifa demo: ${restaurant.reservationPriceCents / 100} € por persona", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                }
            }
            Icon(Icons.AutoMirrored.Filled.ArrowForward, "Ver restaurante", tint = MaterialTheme.colorScheme.outline)
        }
    }
}
