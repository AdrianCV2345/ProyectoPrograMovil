package com.calyrsoft.ucbp1.features.loginPart.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calyrsoft.ucbp1.R

@Composable
fun LoginPartScreen(viewModel: LoginPartViewModel) {
    val usuario by viewModel.usuario.collectAsState()
    val contrasena by viewModel.contrasena.collectAsState()
    val onUsuarioChange = viewModel::onUsuarioChange
    val onContrasenaChange = viewModel::onContrasenaChange

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Confirma que\neres el jefe",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5A2A06),
                        lineHeight = 38.sp
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.bossguer_logo),
                    contentDescription = "Logo Bossguer",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(top = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(120.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Usuario",
                    fontSize = 18.sp,
                    color = Color(0xFF222222),
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(
                    value = usuario,
                    onValueChange = onUsuarioChange,
                    placeholder = { Text("12345678", color = Color(0xFFBDBDBD)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFFFA726),
                        unfocusedBorderColor = Color(0xFFFFA726),
                        focusedContainerColor = Color(0xFFF9F6F6),
                        unfocusedContainerColor = Color(0xFFF9F6F6)
                    ),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Contraseña",
                    fontSize = 18.sp,
                    color = Color(0xFF222222),
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(
                    value = contrasena,
                    onValueChange = onContrasenaChange,
                    placeholder = { Text("megustalaburguer123", color = Color(0xFFBDBDBD)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFFFA726),
                        unfocusedBorderColor = Color(0xFFFFA726),
                        focusedContainerColor = Color(0xFFF9F6F6),
                        unfocusedContainerColor = Color(0xFFF9F6F6)
                    ),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "¿Olvidaste tu contraseña?",
                        fontSize = 13.sp,
                        color = Color(0xFF4CAF50)
                    )
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
            Button(
                onClick = { viewModel.onLoginClick() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(220.dp)
                    .height(56.dp)
                    .shadow(8.dp, RoundedCornerShape(28.dp)),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFB347))
            ) {
                Text(
                    text = "¡ORDENAR YA!",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
