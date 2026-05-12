# Sante Price Index - Setup & Running Guide

## Prerequisites
- Android Studio (latest version)
- JDK 11 or higher
- Android SDK API 34
- Gradle 8.1+

## Step-by-Step Setup

### 1. Open Project in Android Studio
```
File → Open → Navigate to d:\Downloads\Android app project\SantePriceIndex
```

### 2. Wait for Gradle Sync
Android Studio will automatically download dependencies. This may take 2-3 minutes on first setup.

### 3. Create Virtual Device (Emulator)
If you don't have a device, create an Android Virtual Device (AVD):
```
Tools → Device Manager → Create Device
Select: Pixel 4 (or any device with API 34)
```

### 4. Run the App
```
Run → Run 'app' (or press Shift + F10)
Select your emulator/device
```

## Expected Behavior

### Main Menu Screen
- Shows 4 main options with icons
- "Price Watch" - displays commodity prices
- "Profit Calculator" - calculates selling price
- "Price Board" - shows prices on black background
- "Price Trends" - shows price direction indicators

### Price Watch Screen
Click "Price Watch" to see list of commodities with their current Mandi prices.

### Profit Calculator Screen
1. Select a commodity from dropdown
2. Enter transport cost (e.g., 5)
3. Enter waste percentage (e.g., 5)
4. Enter profit margin percentage (e.g., 20)
5. Click "Calculate"
6. View recommended selling price and cost breakdown

**Example:**
- Commodity: Onion (₹28/kg)
- Transport: ₹5
- Waste: 5%
- Profit Margin: 20%
- Result: ~₹38-40/kg

### Price Board Screen
High-contrast display with black background and yellow/white text. Perfect for showing to customers.

### Trends Screen
Shows each commodity with a trend indicator:
- ↑ = Price likely to rise
- ↓ = Price likely to fall
- → = Price stable

## Troubleshooting

### Issue: "Gradle sync failed"
**Solution:**
1. File → Sync Now
2. If still fails: File → Invalidate Caches → Restart
3. Check internet connection

### Issue: "Build fails with 'compileSdkVersion'"
**Solution:**
1. Go to File → Project Structure
2. Set Compile SDK version to 34
3. Click "Sync Now"

### Issue: "Emulator is very slow"
**Solution:**
1. Use Hardware acceleration in emulator
2. Or use a physical Android device (Android 7.0+)

### Issue: "App crashes on startup"
**Solution:**
1. Check logcat (View → Tool Windows → Logcat)
2. Look for red error messages
3. Most common: missing layouts or resource IDs

## Testing the Profit Calculator

### Test Case 1: Onion
- Input: Transport=₹5, Waste=5%, Margin=20%
- Expected: RRP ≈ ₹38-40/kg

### Test Case 2: Tomato
- Input: Transport=₹3, Waste=10%, Margin=25%
- Expected: RRP ≈ ₹56-60/kg

### Test Case 3: Potato
- Input: Transport=₹2, Waste=3%, Margin=15%
- Expected: RRP ≈ ₹42-44/kg

## Project Files Explained

| File | Purpose |
|------|---------|
| `app/build.gradle` | Project dependencies and SDK versions |
| `AndroidManifest.xml` | App permissions and activity declarations |
| `MainActivity.kt` | Main menu with navigation buttons |
| `PriceWatchActivity.kt` | Display Mandi prices |
| `ProfitCalcActivity.kt` | Pricing calculator logic |
| `PriceBoardActivity.kt` | Price display for customers |
| `TrendsActivity.kt` | Price trend indicators |
| `Models.kt` | Data classes (Product, PriceBreakdown) |
| `MockDataProvider.kt` | Sample price data |
| `PricingCalculator.kt` | Cost-plus pricing algorithm |

## Making Changes

### Add a New Commodity
Edit `app/src/main/java/com/example/santeprice/data/MockDataProvider.kt`:
```kotlin
Product(11, "Spinach", 15.0, "UP"),
```

### Change Colors
Edit `app/src/main/res/values/colors.xml`:
- `primary_color` - Main app color
- `board_background` - Price board background
- `board_text` - Price board text color

### Modify Profit Margin Logic
Edit `app/src/main/java/com/example/santeprice/utils/PricingCalculator.kt` in the `calculateSellingPrice()` function.

## Deployment

### Generate APK (for distribution)
```
Build → Build Bundle(s) / APK(s) → Build APK(s)
APK will be at: app/build/outputs/apk/debug/app-debug.apk
```

### Create Signed APK (for Play Store)
```
Build → Generate Signed Bundle / APK
Follow the wizard to create a keystore and sign the APK
```

## Support & Notes

- This is a simplified version without real database/API
- All prices are mock data
- Perfect for learning Android development with Kotlin
- Can be extended with Firebase for real price data
- UI optimized for readability and simplicity

---
**Questions?** Check the README.md for more information.
