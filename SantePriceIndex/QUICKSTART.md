# Quick Start Guide - Sante Price Index

## 🚀 Launch in 3 Steps

### Step 1: Open in Android Studio
```
Open Android Studio → File → Open → 
Navigate to: d:\Downloads\Android app project\SantePriceIndex
Click OK
```

### Step 2: Wait for Build
Android Studio will automatically sync Gradle. Wait for "Gradle build finished" message at bottom.

### Step 3: Run
```
Click green Run button (▶) or press Shift + F10
Select emulator/device
App opens in ~30 seconds
```

---

## 📱 Four Main Features

### 1️⃣ Price Watch
**What it does:** Shows today's Mandi prices
**How to use:** 
- Click "📊 Price Watch" from main menu
- Scroll through list of commodities
- See price per kg

**Sample Data:**
```
Onion          ₹28/kg
Tomato         ₹45/kg
Potato         ₹35/kg
... 7 more items
```

### 2️⃣ Profit Calculator
**What it does:** Calculates what you should sell at
**How to use:**
1. Click "💰 Profit Calculator"
2. Select commodity from dropdown
3. Enter Transport Cost (e.g., 5)
4. Enter Waste % (e.g., 5)
5. Enter Profit Margin % (e.g., 20)
6. Click Calculate
7. See recommended selling price + breakdown

**Real Example:**
```
Commodity: Onion (₹28/kg from Mandi)
Transport: ₹5
Waste: 5%
Profit Margin: 20%

RESULT: Sell at ₹38/kg to make ₹10 profit!
```

### 3️⃣ Price Board
**What it does:** Big, clear display for customers to see
**Design:**
- Black background (easy on eyes)
- Yellow text (easy to read from distance)
- Large fonts
- Perfect for hanging on shop

**Example Display:**
```
Onion            ₹28/kg
Tomato           ₹45/kg
Potato           ₹35/kg
```

### 4️⃣ Price Trends
**What it does:** Tells you if prices will rise or fall
**Symbols:**
- ↑ = Price Going UP (buy more now, can sell higher later!)
- ↓ = Price Going DOWN (sell what you have before price drops)
- → = Price STABLE (no change expected)

---

## 💡 Key Formulas Used

### Selling Price Calculation

```
Cost After Waste = Mandi Price ÷ (100% - Waste%)
Cost After Transport = Cost After Waste + Transport
Your Profit = Cost After Transport × Profit Margin %
Selling Price = Cost After Transport + Your Profit
```

**Example:**
```
Onion at Mandi = ₹28/kg
Waste 5% → Cost = ₹28 ÷ 0.95 = ₹29.47
Transport = ₹5 → Total Cost = ₹34.47
Profit 20% → Profit = ₹6.89
Selling Price = ₹34.47 + ₹6.89 = ₹41.36/kg
```

---

## ⚙️ Project Structure

The app is organized simply:

```
📁 SantePriceIndex/
├── 📁 app/
│   ├── 📁 src/main/
│   │   ├── 📁 java/com/example/santeprice/
│   │   │   ├── 📁 ui/          (4 activities + main menu)
│   │   │   ├── 📁 data/        (product models & mock data)
│   │   │   └── 📁 utils/       (pricing math)
│   │   ├── 📁 res/
│   │   │   ├── 📁 layout/      (XML UI designs)
│   │   │   ├── 📁 values/      (colors, strings, styles)
│   │   │   └── 📁 drawable/    (icons)
│   │   └── AndroidManifest.xml (app permissions)
│   ├── build.gradle            (dependencies)
│   └── proguard-rules.pro       (app security rules)
├── build.gradle                (project settings)
└── settings.gradle             (gradle configuration)
```

---

## 🧪 Test It Out!

### Quick Test Flow:
1. **Launch app** → See main menu with 4 buttons
2. **Click Price Watch** → See 10 commodities + prices
3. **Click Profit Calc** → Select Onion, enter Transport=5, Waste=5, Margin=20 → Click Calculate
4. **Click Price Board** → See prices on black background
5. **Click Trends** → See price direction indicators

**Expected Results:**
- ✅ All screens load quickly
- ✅ Calculator gives correct results
- ✅ Price Board is readable from far
- ✅ No crashes or errors

---

## 🔧 How to Modify Data

### Change Prices:
File: `app/src/main/java/com/example/santeprice/data/MockDataProvider.kt`
```kotlin
Product(1, "Onion", 28.0, "UP")  // Change 28.0 to any number
```

### Add New Vegetable:
Add this line in the `getAllProducts()` function:
```kotlin
Product(11, "Spinach", 18.0, "UP"),
```

### Change Colors:
File: `app/src/main/res/values/colors.xml`
```xml
<color name="board_text">#FFFF00</color>  <!-- Yellow for price board -->
<color name="board_background">#000000</color>  <!-- Black background -->
```

---

## 🐛 Common Issues & Fixes

| Problem | Fix |
|---------|-----|
| Gradle won't sync | Click "File → Sync Now" or restart Android Studio |
| App crashes | Check Logcat (View → Tool Windows → Logcat) for errors |
| Emulator slow | Use physical device or enable GPU acceleration |
| Can't find emulator | Device Manager → Create new AVD with API 34 |

---

## 📚 What's Included

✅ 5 Complete Activities (Main + 4 Features)
✅ 10 Mock Commodities
✅ Profit Calculator with Math
✅ Mock Price Data
✅ Professional UI Layout
✅ Color Scheme for Readability
✅ All Source Code in Kotlin
✅ No External APIs Needed
✅ Ready to Deploy

---

**Start coding! Happy Android development!** 🎉
