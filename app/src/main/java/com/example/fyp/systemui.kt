import android.graphics.Color as AndroidColor
import android.os.Build
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun CustomizeSystemBars(
    statusBarColor: Color,
    darkStatusBarIcons: Boolean,
    darkNavBarIcons: Boolean
) {
    val activity = LocalContext.current as ComponentActivity
    val window = activity.window
    val view = LocalView.current

    // Enable edge-to-edge content
    WindowCompat.setDecorFitsSystemWindows(window, false)

    // Set status bar color (modern approach)
    window.statusBarColor = statusBarColor.toArgb()

    // Set transparent navigation bar for edge-to-edge
    window.navigationBarColor = AndroidColor.TRANSPARENT

    // Configure system bar icon appearance
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val insetsController = window.insetsController
        insetsController?.setSystemBarsAppearance(
            if (darkStatusBarIcons) WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS else 0,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
        insetsController?.setSystemBarsAppearance(
            if (darkNavBarIcons) WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS else 0,
            WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
        )
    } else {
        val insetsController = WindowCompat.getInsetsController(window, view)
        insetsController?.isAppearanceLightStatusBars = darkStatusBarIcons
        insetsController?.isAppearanceLightNavigationBars = darkNavBarIcons
    }
}