package com.calyrsoft.ucbp1.features.menu.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calyrsoft.ucbp1.R

@Composable
fun MenuScreen(viewModel: MenuViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 64.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen principal y encabezado superpuestos
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.menu_header),
                    contentDescription = "Menu header",
                    modifier = Modifier.fillMaxSize()
                )
                // Textos sobre la imagen
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, end = 16.dp, bottom = 0.dp) // Solo padding horizontal y mínimo abajo
                ) {
                    Text(
                        text = "NUESTRO MENÚ",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Pedí tu Boss Favorita!",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                // Encabezado superpuesto arriba de la imagen
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF4D8CD).copy(alpha = 0.85f))
                        .align(Alignment.TopCenter),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /* TODO: Navegar atrás */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Atrás",
                            tint = Color(0xFF5A2A06),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.bossguer_logo),
                        contentDescription = "Logo Bossguer",
                        modifier = Modifier.size(56.dp)
                    )
                    IconButton(onClick = { /* TODO: Ir al carrito */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cart),
                            contentDescription = "Carrito",
                            tint = Color(0xFF5A2A06),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
            // Sección Hamburguesas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF8C1C1C))
            ) {
                Text(
                    text = "HAMBURGUESAS",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            // Cards hamburguesas
            MenuBurgerCard(
                imageRes = R.drawable.burger_bossguer,
                name = "Bossguer",
                desc = "La original, inigualable e inconfundible.",
                price = "35,00Bs."
            )
            MenuBurgerCard(
                imageRes = R.drawable.burger_jefaza,
                name = "La Jefaza",
                desc = "Cargada con todo, solo para los verdaderos jefes.",
                price = "37,00Bs."
            )
            MenuBurgerCard(
                imageRes = R.drawable.burger_bossguer,
                name = "Bossguer",
                desc = "La original, inigualable e inconfundible.",
                price = "35,00Bs."
            )
            MenuBurgerCard(
                imageRes = R.drawable.burger_ejecutiva,
                name = "La Ejecutiva",
                desc = "Elegante, potente y llena de poder.",
                price = "37,00Bs."
            )
            MenuBurgerCard(
                imageRes = R.drawable.burger_bossguer,
                name = "Bossguer",
                desc = "Hoy, tu eres el Boss!",
                price = "35,00Bs."
            )
            // Arma la tuya
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.burger_custom),
                        contentDescription = "Arma la tuya",
                        modifier = Modifier.height(100.dp)
                    )
                    Text(
                        text = "Arma La Tuya!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color(0xFF5A2A06),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "ACLARACIÓN: Todas nuestras Boss incluyen porción de papas :)",
                fontSize = 12.sp,
                color = Color(0xFF5A2A06),
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
            )
            // Sección Bebidas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF8C1C1C))
            ) {
                Text(
                    text = "BEBIDAS",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            MenuDrinkRow("Agua", "9,00 Bs.")
            MenuDrinkRow("Jugo", "7,00 Bs.")
            MenuDrinkRow("Soda", "9,00 Bs.")
            // Sección Extras
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF387C3B))
            ) {
                Text(
                    text = "EXTRAS",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            MenuDrinkRow("Papas", "9,00 Bs.")
            MenuDrinkRow("Aros de Cebolla", "9,00 Bs.")
            Spacer(modifier = Modifier.height(32.dp))
        }
        // Barra de navegación inferior fija
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color(0xFFFFB347))
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(R.drawable.ic_nosotros, "")
            BottomNavItem(R.drawable.ic_menu, "")
            BottomNavItem(R.drawable.ic_chat, "")
            BottomNavItem(R.drawable.ic_cuenta, "")
        }
    }
}

@Composable
fun MenuBurgerCard(imageRes: Int, name: String, desc: String, price: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF5A2A06)
                )
                Text(
                    text = desc,
                    fontSize = 13.sp,
                    color = Color(0xFF222222)
                )
                Text(
                    text = price,
                    fontSize = 14.sp,
                    color = Color(0xFF5A2A06),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            // Contador
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO: Disminuir */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_minus),
                        contentDescription = "Menos",
                        tint = Color(0xFFFFB347),
                        modifier =Modifier.size(24.dp)
                    )
                }
                Text(
                    text = "0",
                    fontSize = 16.sp,
                    color = Color(0xFF5A2A06),
                    modifier = Modifier.width(24.dp),
                    textAlign = TextAlign.Center
                )
                IconButton(onClick = { /* TODO: Aumentar */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = "Más",
                        tint = Color(0xFFFFB347),
                        modifier =Modifier.size(24.dp)

                    )
                }
            }
        }
    }
}

@Composable
fun MenuDrinkRow(name: String, price: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            fontSize = 16.sp,
            color = Color(0xFF222222),
            fontWeight = FontWeight.Normal
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = price,
                fontSize = 16.sp,
                color = Color(0xFF5A2A06),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 8.dp)
            )
            IconButton(onClick = { /* TODO: Agregar */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "Agregar",
                    tint = Color(0xFFFFB347),
                    modifier =Modifier.size(24.dp)

                )
            }
        }
    }
}

@Composable
fun BottomNavItem(iconRes: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(Color(0xFFFFB347), shape = CircleShape), // Cambiado a color de la barra
            contentAlignment = Alignment.Center
        ) {

            IconButton(onClick = { /* TODO: Agregar */ }) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = label,
                    modifier = Modifier.size(50.dp),
                    tint = Color.White

                )
            }

        }

    }
}
