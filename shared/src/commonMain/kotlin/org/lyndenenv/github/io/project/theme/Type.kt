package org.lyndenenv.github.io.project.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import portfolio.shared.generated.resources.Res
import portfolio.shared.generated.resources.inter_bold
import portfolio.shared.generated.resources.inter_medium
import portfolio.shared.generated.resources.inter_regular
import portfolio.shared.generated.resources.inter_semibold

@Composable
fun portfolioTypography(): Typography {
    // Font(...) is itself @Composable, so these calls must happen directly
    // in this function body -- not inside a remember { } block, which
    // disallows composable calls in its calculation lambda.
    val regular = Font(Res.font.inter_regular, FontWeight.Normal)
    val medium = Font(Res.font.inter_medium, FontWeight.Medium)
    val semibold = Font(Res.font.inter_semibold, FontWeight.SemiBold)
    val bold = Font(Res.font.inter_bold, FontWeight.Bold)

    val inter = remember(regular, medium, semibold, bold) {
        FontFamily(regular, medium, semibold, bold)
    }

    return remember(inter) {
        Typography(
            displayLarge = TextStyle(fontFamily = inter, fontWeight = FontWeight.Bold, fontSize = 57.sp, lineHeight = 64.sp, letterSpacing = (-0.25).sp),
            displayMedium = TextStyle(fontFamily = inter, fontWeight = FontWeight.Bold, fontSize = 45.sp, lineHeight = 52.sp),
            displaySmall = TextStyle(fontFamily = inter, fontWeight = FontWeight.Bold, fontSize = 36.sp, lineHeight = 44.sp),
            headlineLarge = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 32.sp, lineHeight = 40.sp),
            headlineMedium = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 28.sp, lineHeight = 36.sp),
            headlineSmall = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, lineHeight = 32.sp),
            titleLarge = TextStyle(fontFamily = inter, fontWeight = FontWeight.Medium, fontSize = 22.sp, lineHeight = 28.sp),
            titleMedium = TextStyle(fontFamily = inter, fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.15.sp),
            titleSmall = TextStyle(fontFamily = inter, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
            bodyLarge = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.5.sp),
            bodyMedium = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.25.sp),
            bodySmall = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.4.sp),
            labelLarge = TextStyle(fontFamily = inter, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
            labelMedium = TextStyle(fontFamily = inter, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
            labelSmall = TextStyle(fontFamily = inter, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
        )
    }
}