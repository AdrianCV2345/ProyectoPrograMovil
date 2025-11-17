package com.calyrsoft.ucbp1.features.carrito.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calyrsoft.ucbp1.R
import com.calyrsoft.ucbp1.features.carrito.data.CartItem

@Composable
fun OrderScreen(cartViewModel: CartViewModel, onBack: () -> Unit) {
    val uiState by cartViewModel.uiState.collectAsState()
    var deliverySelected by remember { mutableStateOf(true) }
    var paymentMethod by remember { mutableStateOf("QR") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HeaderBar(onBack = onBack)
        if (uiState.items.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Tu carrito está vacío", fontSize = 20.sp)
            }
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                item {
                    Text(
                        text = "Tu pedido",
                        color = Color(0xFF4B2A10),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp, top = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                items(items = uiState.items, key = { it.product.name }) { cartItem ->
                    OrderItemRow(
                        cartItem = cartItem,
                        onAdd = { cartViewModel.addProduct(cartItem.product) },
                        onRemove = { cartViewModel.removeProduct(cartItem.product) }
                    )
                }
                item {
                    DeliveryOptions(
                        deliverySelected = deliverySelected,
                        onDeliverySelected = { deliverySelected = it },
                        paymentMethod = paymentMethod,
                        onPaymentMethodSelected = { paymentMethod = it }
                    )
                }
            }
            Footer(total = uiState.total)
        }
    }
}

@Composable
fun HeaderBar(onBack: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFF8E0D3))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onBack) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF2E5E3E),
                modifier = Modifier.size(24.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.size(24.dp)) // To balance the space of the IconButton
    }
}

@Composable
fun OrderItemRow(cartItem: CartItem, onAdd: () -> Unit, onRemove: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = cartItem.product.image),
            contentDescription = cartItem.product.name,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(text = cartItem.product.name, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = "Bs. ${"%.2f".format(cartItem.product.price)}", color = Color(0xFF2E5E3E))
        }
        QuantityControl(quantity = cartItem.quantity, onAdd = onAdd, onRemove = onRemove)
    }
}

@Composable
fun QuantityControl(quantity: Int, onAdd: () -> Unit, onRemove: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onRemove,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF9A825)),
            shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
        ) {
            Text(text = "–", color = Color.White)
        }
        Text(
            text = quantity.toString(),
            modifier = Modifier.padding(horizontal = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = onAdd,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF9A825)),
            shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
        ) {
            Text(text = "+", color = Color.White)
        }
    }
}

@Composable
fun DeliveryOptions(
    deliverySelected: Boolean,
    onDeliverySelected: (Boolean) -> Unit,
    paymentMethod: String,
    onPaymentMethodSelected: (String) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = { onDeliverySelected(true) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (deliverySelected) Color(0xFFF89E3E) else Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (!deliverySelected) BorderStroke(1.dp, Color(0xFF4CA57F)) else null
            ) {
                Text(text = "Delivery", color = if (deliverySelected) Color.White else Color(0xFF4CA57F))
            }
            Spacer(modifier = Modifier.size(8.dp))
            Button(
                onClick = { onDeliverySelected(false) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!deliverySelected) Color(0xFFF89E3E) else Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (deliverySelected) BorderStroke(1.dp, Color(0xFF4CA57F)) else null
            ) {
                Text(text = "Recojo del local", color = if (!deliverySelected) Color.White else Color(0xFF4CA57F))
            }
        }
        if (deliverySelected) {
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Servicio de delivery", color = Color(0xFFF89E3E))
                Text(text = "Bs. 10", color = Color.DarkGray)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Marque su dirección en el mapa")
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.LightGray, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Mapa de Google Maps")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Método de pago")
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = { onPaymentMethodSelected("QR") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (paymentMethod == "QR") Color(0xFFF89E3E) else Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (paymentMethod != "QR") BorderStroke(1.dp, Color(0xFF4CA57F)) else null
            ) {
                Text(text = "QR", color = if (paymentMethod == "QR") Color.White else Color(0xFF4CA57F))
            }
            Spacer(modifier = Modifier.size(8.dp))
            Button(
                onClick = { onPaymentMethodSelected("Efectivo") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (paymentMethod == "Efectivo") Color(0xFFF89E3E) else Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (paymentMethod != "Efectivo") BorderStroke(1.dp, Color(0xFF4CA57F)) else null
            ) {
                Text(text = "Efectivo", color = if (paymentMethod == "Efectivo") Color.White else Color(0xFF4CA57F))
            }
        }
        if (paymentMethod == "QR") {
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.LightGray, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Imagen de QR")
            }
        }
    }
}


@Composable
fun Footer(total: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Total del pedido",
            color = Color(0xFF4B2A10),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Bs. ${"%.2f".format(total)}",
            color = Color(0xFF2E5E3E),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
