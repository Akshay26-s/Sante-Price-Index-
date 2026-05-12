# Sante Price Index - Complete Developer Guide

## 📋 Project Overview

**Sante Price Index** is an Android application designed to help small vegetable vendors in village markets determine fair selling prices based on city wholesale prices, transport costs, and desired profit margins.

### Problem Solved
Small vendors often don't know the "fair selling price" and either:
- Sell too cheap → lose profit
- Sell too expensive → lose customers

This app bridges that gap with data-driven pricing.

---

## 🏗️ Architecture Overview

### Technology Stack
- **Language**: Kotlin
- **UI Framework**: Android Native (XML + Kotlin)
- **Data**: Mock in-memory (no database/API)
- **Architecture Pattern**: MVVM-ready (simple activities for now)
- **Min SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)

### Project Layer Structure
```
Presentation Layer (UI)
    ↓
Business Logic Layer (Calculator, Mock Data)
    ↓
Data Layer (Models)
```

---

## 📁 Complete File Structure

```
SantePriceIndex/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/santeprice/
│   │   │   ├── ui/
│   │   │   │   ├── MainActivity.kt              (Menu activity)
│   │   │   │   ├── PriceWatchActivity.kt        (Display prices)
│   │   │   │   ├── ProfitCalcActivity.kt        (Calculate price)
│   │   │   │   ├── PriceBoardActivity.kt        (Price board view)
│   │   │   │   ├── TrendsActivity.kt            (Trends display)
│   │   │   │   └── PriceBoardAdapter.kt         (Custom adapter)
│   │   │   ├── data/
│   │   │   │   ├── Models.kt                    (Data classes)
│   │   │   │   └── MockDataProvider.kt          (Sample data)
│   │   │   └── utils/
│   │   │       └── PricingCalculator.kt         (Math logic)
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml            (Menu layout)
│   │   │   │   ├── activity_price_watch.xml     (Price list)
│   │   │   │   ├── activity_profit_calc.xml     (Calculator form)
│   │   │   │   ├── activity_price_board.xml     (Board display)
│   │   │   │   └── activity_trends.xml          (Trends list)
│   │   │   ├── values/
│   │   │   │   ├── strings.xml                  (All text)
│   │   │   │   ├── colors.xml                   (Color definitions)
│   │   │   │   └── styles.xml                   (Theme styles)
│   │   │   └── drawable/
│   │   │       ├── ic_launcher.xml              (App icon)
│   │   │       └── ic_launcher_round.xml        (Round icon)
│   │   └── AndroidManifest.xml                  (App config)
│   ├── build.gradle                             (Dependencies)
│   └── proguard-rules.pro                       (Build rules)
├── build.gradle                                 (Project config)
├── settings.gradle                              (Gradle settings)
├── README.md                                    (Overview)
├── QUICKSTART.md                                (Quick guide)
├── SETUP_GUIDE.md                               (Detailed setup)
├── ARCHITECTURE.md                              (This file)
└── .gitignore                                   (Git ignore rules)
```

---

## 🔄 Data Flow

### Price Watch Flow
```
MockDataProvider.getAllProducts()
    ↓
PriceWatchActivity loads data
    ↓
ArrayAdapter populates ListView
    ↓
User sees list of commodities and prices
```

### Profit Calculator Flow
```
User Input:
  - Commodity (spinner)
  - Transport Cost (EditText)
  - Waste % (EditText)
  - Profit Margin % (EditText)
    ↓
PricingCalculator.calculateSellingPrice()
    ↓
Calculation Algorithm:
  1. Get Mandi Price from MockDataProvider
  2. Calculate waste loss
  3. Add transport cost
  4. Calculate profit %
  5. Sum to get selling price
    ↓
PriceBreakdown object returned
    ↓
Display to user in formatted layout
```

### Price Board Flow
```
MockDataProvider.getAllProducts()
    ↓
Format prices for display (padding, alignment)
    ↓
PriceBoardAdapter applies yellow-on-black styling
    ↓
ListView displays with custom colors
    ↓
High contrast display for customers
```

---

## 💾 Data Models

### Product
```kotlin
data class Product(
    val id: Int,
    val name: String,          // "Onion"
    val mandiPrice: Double,    // 28.0
    val trend: String          // "UP", "DOWN", "STABLE"
)
```

### PriceBreakdown
```kotlin
data class PriceBreakdown(
    val mandiCost: Double,           // Base Mandi price
    val wasteLoss: Double,           // Loss from waste %
    val transportCost: Double,       // Transport charges
    val profit: Double,              // Profit amount
    val recommendedSellingPrice: Double  // Final selling price
)
```

---

## 🧮 Pricing Algorithm Deep Dive

### Formula
```
Adjusted Mandi Cost = Mandi Price / (1 - Waste% / 100)
Cost After Transport = Adjusted Mandi Cost + Transport Cost
Profit Amount = Cost After Transport × Profit Margin% / 100
Recommended Selling Price = Cost After Transport + Profit Amount
```

### Example Calculation
```
Commodity: Onion
Mandi Price: ₹28/kg
Transport: ₹5
Waste: 5%
Profit Margin: 20%

Step 1: Adjusted Cost = 28 / (1 - 0.05) = 28 / 0.95 = ₹29.47
Step 2: Cost + Transport = 29.47 + 5 = ₹34.47
Step 3: Profit = 34.47 × 0.20 = ₹6.89
Step 4: Selling Price = 34.47 + 6.89 = ₹41.36/kg
```

### Logic Explanation
- **Waste Loss**: If 5% waste, need to sell remaining 95% at higher price to cover waste
- **Transport**: Direct additional cost per kg
- **Profit Margin**: Percentage of total cost (not markup on cost)

---

## 🎨 UI/UX Design Principles

### Color Scheme
- **Primary**: Green (#2E7D32) - Trust, growth, nature
- **Secondary**: Gold (#FFC107) - Value, prosperity
- **Price Board**: Black background + Yellow text - High contrast for elderly vendors

### Typography
- **App Title**: 32sp, Bold
- **Section Headers**: 20sp, Bold
- **Body Text**: 14sp, Regular
- **Price Board**: 24sp, Large for visibility

### Layout Strategy
- **Simplicity**: No complex animations
- **Clarity**: Large buttons, clear labels
- **Accessibility**: High contrast colors, readable fonts
- **Offline**: No internet needed

---

## 🔧 How to Modify & Extend

### Adding a New Commodity

**File**: `MockDataProvider.kt`
```kotlin
fun getAllProducts(): List<Product> {
    return listOf(
        // ... existing items ...
        Product(11, "Spinach", 18.0, "UP"),  // Add this line
        Product(12, "Lettuce", 22.0, "DOWN") // Add this line
    )
}
```

### Changing Profit Calculation

**File**: `PricingCalculator.kt`
```kotlin
fun calculateSellingPrice(...): PriceBreakdown {
    // Modify the algorithm here
    // For example, add a fixed markup instead of percentage
    val profitAmount = costWithTransport + 50  // Fixed ₹50 profit
}
```

### Adding a New Feature (e.g., Bulk Pricing)

1. Create `BulkPricingActivity.kt`
2. Add layout file `activity_bulk_pricing.xml`
3. Register in `AndroidManifest.xml`
4. Add button in `MainActivity.kt`
5. Implement logic in activity

### Changing Colors

**File**: `app/src/main/res/values/colors.xml`
```xml
<color name="primary_color">#FF6F00</color>  <!-- Orange instead of green -->
<color name="board_text">#00FF00</color>     <!-- Green instead of yellow -->
```

### Changing Text Labels

**File**: `app/src/main/res/values/strings.xml`
```xml
<string name="app_name">Mandi Mitra</string>  <!-- New name -->
<string name="profit_calc">मुनाफा कैलकुलेटर</string>  <!-- Hindi translation -->
```

---

## 🧪 Testing the App

### Manual Testing Checklist

- [ ] **Launch**: App opens without crash
- [ ] **Price Watch**: Shows all 10 commodities
- [ ] **Profit Calc**: 
  - [ ] Dropdown loads all products
  - [ ] Can enter numbers in all fields
  - [ ] Calculate button produces result
  - [ ] Result is visible and readable
  - [ ] Cost breakdown is accurate
- [ ] **Price Board**: 
  - [ ] Shows all prices
  - [ ] Yellow text visible on black
  - [ ] Text is large enough to read from distance
- [ ] **Trends**: Shows all products with trend symbols
- [ ] **Navigation**: Can go back from each screen
- [ ] **No Crashes**: Logcat shows no errors

### Test Data to Use
```
Test Case 1 (Low profit):
  Product: Potato
  Transport: ₹2
  Waste: 3%
  Margin: 10%

Test Case 2 (High waste):
  Product: Tomato
  Transport: ₹5
  Waste: 10%
  Margin: 25%

Test Case 3 (High transport):
  Product: Bell Pepper
  Transport: ₹10
  Waste: 5%
  Margin: 15%
```

---

## 📦 Building & Deployment

### Build APK (Debug)
```
Build → Build Bundle(s) / APK(s) → Build APK(s)
Output: app/build/outputs/apk/debug/app-debug.apk
```

### Build APK (Release/Production)
```
Build → Generate Signed Bundle / APK
Create keystore → Sign APK
Output: Signed APK ready for Play Store
```

### Install on Device
```
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

---

## 🔐 Security & Performance

### Security
- No external APIs → No data leaks
- No permissions needed → No privacy concerns
- Local data only → Works offline
- ProGuard enabled → Code obfuscation on release builds

### Performance
- Small APK size (expect <5MB)
- No network calls → Instant loading
- Mock data → Instant response
- Simple UI → Minimal CPU usage

---

## 🚀 Future Enhancements

### Phase 1 (MVP)
✅ Current state - Price watch, calculator, board, trends

### Phase 2 (Real Data)
- [ ] Connect to Firebase for real prices
- [ ] Auto-update prices daily
- [ ] Historical price trends (charts)

### Phase 3 (Advanced Features)
- [ ] User profiles / vendor accounts
- [ ] Price alerts (SMS/WhatsApp)
- [ ] Inventory management
- [ ] Sales tracking

### Phase 4 (Localization)
- [ ] Multi-language support
- [ ] Regional price databases
- [ ] Local payment integration

---

## 📞 Troubleshooting Guide

| Issue | Cause | Solution |
|-------|-------|----------|
| Gradle sync fails | Offline/corrupted cache | Invalidate caches → Restart |
| Emulator won't start | Insufficient resources | Close other apps, use physical device |
| App crashes on launch | Missing resource | Check Logcat for resource ID errors |
| Profit calc wrong math | Algorithm error | Check PricingCalculator.kt math |
| Price board text unreadable | Color issue | Verify colors.xml has right values |

---

## 📚 Learning Resources

- Android Official Docs: https://developer.android.com/
- Kotlin Documentation: https://kotlinlang.org/docs/
- Material Design: https://material.io/
- Android Studio: https://developer.android.com/studio/

---

## 📄 License & Credits

Created for: Micro-entrepreneurship empowerment
Target Users: Small vegetable vendors
Built With: Kotlin, Android SDK, Material Design
No external dependencies for core functionality

---

**Remember**: This is a foundation. Extend it, customize it, and make it your own! 🚀
