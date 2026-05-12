# Project Directory Structure - Visual Guide

## 📂 Complete File Tree

```
SantePriceIndex/                                  ← PROJECT ROOT
│
├── 📄 README.md                                 ← Start here!
├── 📄 PROJECT_SUMMARY.md                        ← Project overview
├── 📄 QUICKSTART.md                             ← Quick 3-step guide
├── 📄 SETUP_GUIDE.md                            ← Detailed setup
├── 📄 ARCHITECTURE.md                           ← Technical details
├── 📄 TROUBLESHOOTING.md                        ← Problem solutions
├── 📄 .gitignore                                ← Git ignore rules
│
├── 📄 build.gradle                              ← Project config
├── 📄 settings.gradle                           ← Gradle settings
│
├── 📁 app/                                      ← APP MODULE
│   ├── 📄 build.gradle                          ← App dependencies
│   ├── 📄 proguard-rules.pro                    ← Build rules
│   │
│   └── 📁 src/
│       └── 📁 main/
│           │
│           ├── 📄 AndroidManifest.xml           ← App permissions & activities
│           │
│           ├── 📁 java/
│           │   └── 📁 com/example/santeprice/
│           │       │
│           │       ├── 📁 ui/                   ← ACTIVITIES (User Interface)
│           │       │   ├── 📄 MainActivity.kt                   (Main menu)
│           │       │   ├── 📄 PriceWatchActivity.kt             (Price list)
│           │       │   ├── 📄 ProfitCalcActivity.kt             (Calculator)
│           │       │   ├── 📄 PriceBoardActivity.kt             (Display board)
│           │       │   ├── 📄 TrendsActivity.kt                 (Trends)
│           │       │   └── 📄 PriceBoardAdapter.kt              (Custom styling)
│           │       │
│           │       ├── 📁 data/                 ← DATA LAYER
│           │       │   ├── 📄 Models.kt                         (Data classes)
│           │       │   └── 📄 MockDataProvider.kt               (Sample data)
│           │       │
│           │       └── 📁 utils/                ← UTILITIES
│           │           └── 📄 PricingCalculator.kt              (Math logic)
│           │
│           └── 📁 res/                          ← RESOURCES
│               ├── 📁 layout/                   ← XML LAYOUTS
│               │   ├── 📄 activity_main.xml                     (Menu screen)
│               │   ├── 📄 activity_price_watch.xml              (Price list)
│               │   ├── 📄 activity_profit_calc.xml              (Calculator)
│               │   ├── 📄 activity_price_board.xml              (Price board)
│               │   └── 📄 activity_trends.xml                   (Trends)
│               │
│               ├── 📁 values/                   ← RESOURCE VALUES
│               │   ├── 📄 strings.xml                           (Text labels)
│               │   ├── 📄 colors.xml                            (Color definitions)
│               │   └── 📄 styles.xml                            (Theme styles)
│               │
│               └── 📁 drawable/                 ← IMAGES & ICONS
│                   ├── 📄 ic_launcher.xml                       (App icon)
│                   └── 📄 ic_launcher_round.xml                 (Round icon)
```

---

## 📊 Layer Architecture

```
PRESENTATION LAYER (User Interface)
├── MainActivity.kt                  (Main menu with 4 buttons)
├── PriceWatchActivity.kt            (Show prices)
├── ProfitCalcActivity.kt            (Input form + result)
├── PriceBoardActivity.kt            (Price display)
└── TrendsActivity.kt                (Trend indicators)
        ↓
BUSINESS LOGIC LAYER (Calculations)
├── PricingCalculator.kt             (Cost-plus pricing math)
├── PriceBoardAdapter.kt             (UI customization)
└── Layout XML files                 (UI design)
        ↓
DATA LAYER (Information)
├── Models.kt                        (Product, PriceBreakdown)
└── MockDataProvider.kt              (10 vegetables with prices)
```

---

## 🎯 Feature Flow

```
MAIN MENU
│
├─→ Price Watch
│   └─→ ListView of 10 items
│
├─→ Profit Calculator  
│   ├─→ Spinner (select commodity)
│   ├─→ Input fields (transport, waste, margin)
│   └─→ Shows: Selling price + Breakdown
│
├─→ Price Board
│   └─→ ListView with black bg + yellow text
│
└─→ Trends
    └─→ ListView with trend symbols (↑↓→)
```

---

## 💾 Data Flow

```
MockDataProvider.getAllProducts()
        ↓
List<Product>
├─ Product(1, "Onion", 28.0, "UP")
├─ Product(2, "Tomato", 45.0, "DOWN")
├─ ... 8 more items
└─ Product(10, "Garlic", 65.0, "STABLE")
        ↓
Activities use this data:
├─ PriceWatchActivity → displays in ListView
├─ ProfitCalcActivity → user selects from Spinner
├─ PriceBoardActivity → formats for display
└─ TrendsActivity → shows trends
```

---

## 🔄 Profit Calculator Flow

```
USER INPUT:
├─ Commodity selection (Spinner)
├─ Transport cost (EditText)
├─ Waste percentage (EditText)
└─ Profit margin % (EditText)
        ↓
PricingCalculator.calculateSellingPrice()
        ↓
PROCESSING:
├─ Get Mandi price from MockDataProvider
├─ Calculate waste loss
├─ Add transport cost
├─ Calculate profit amount
└─ Sum for selling price
        ↓
RESULT:
├─ Display recommended selling price
├─ Show cost breakdown
│   ├─ Mandi cost
│   ├─ Waste loss
│   ├─ Transport
│   ├─ Profit
│   └─ Total
└─ Calculate profit percentage
```

---

## 📋 Code Organization

### By Function Type

**Activities (Screen Controllers)**
- MainActivity - Menu controller
- PriceWatchActivity - Price listing
- ProfitCalcActivity - Calculator logic
- PriceBoardActivity - Display control
- TrendsActivity - Trend display

**Data Models**
- Product - Vegetable data
- PriceBreakdown - Pricing details
- MockDataProvider - Sample database

**Utilities**
- PricingCalculator - Math operations
- PriceBoardAdapter - UI customization

**Resources**
- Layouts (5 XML files) - Screen designs
- Values - Colors, strings, styles
- Drawables - Icons

---

## 🎨 UI Component Map

```
SCREEN HIERARCHY
│
└─ MainActivity (activity_main.xml)
   ├─ Toolbar with title
   ├─ 4 Buttons
   │  ├─ "Price Watch" → PriceWatchActivity
   │  ├─ "Profit Calculator" → ProfitCalcActivity
   │  ├─ "Price Board" → PriceBoardActivity
   │  └─ "Price Trends" → TrendsActivity
   │
   ├─ PriceWatchActivity
   │  ├─ Toolbar
   │  └─ ListView
   │     └─ ArrayAdapter
   │
   ├─ ProfitCalcActivity
   │  ├─ Toolbar
   │  ├─ ScrollView
   │  │  ├─ Spinner (select product)
   │  │  ├─ EditText (transport)
   │  │  ├─ EditText (waste %)
   │  │  ├─ EditText (profit %)
   │  │  ├─ Button (calculate)
   │  │  ├─ TextView (result)
   │  │  └─ TextView (breakdown)
   │  
   ├─ PriceBoardActivity
   │  ├─ Toolbar
   │  └─ ListView
   │     └─ PriceBoardAdapter (yellow text on black)
   │
   └─ TrendsActivity
      ├─ Toolbar
      └─ ListView
         └─ ArrayAdapter
```

---

## 🔗 File Dependencies

```
activity_main.xml
    ↓
MainActivity.kt
    ├─→ PriceWatchActivity
    ├─→ ProfitCalcActivity
    ├─→ PriceBoardActivity
    └─→ TrendsActivity
            ↓
        MockDataProvider.kt
            ↓
        Product (Models.kt)

ProfitCalcActivity.kt
    ├─→ PricingCalculator.kt
    ├─→ Models.kt (PriceBreakdown)
    └─→ activity_profit_calc.xml

PriceBoardActivity.kt
    ├─→ PriceBoardAdapter.kt
    ├─→ MockDataProvider.kt
    └─→ activity_price_board.xml

colors.xml ← all activities use this
strings.xml ← all activities use this
styles.xml ← AndroidManifest references
```

---

## 📦 Package Structure

```
com.example.santeprice/
│
├── ui/                    (User Interface Layer)
│   ├── MainActivity
│   ├── PriceWatchActivity
│   ├── ProfitCalcActivity
│   ├── PriceBoardActivity
│   ├── TrendsActivity
│   └── PriceBoardAdapter
│
├── data/                  (Data Layer)
│   ├── Product
│   ├── PriceBreakdown
│   └── MockDataProvider
│
└── utils/                 (Business Logic Layer)
    └── PricingCalculator
```

---

## 🔌 Key Integration Points

### Activities Register in AndroidManifest.xml
```xml
<activity android:name=".ui.MainActivity" android:exported="true">
<activity android:name=".ui.PriceWatchActivity" />
<activity android:name=".ui.ProfitCalcActivity" />
<activity android:name=".ui.PriceBoardActivity" />
<activity android:name=".ui.TrendsActivity" />
```

### Layouts Used by Activities
```
MainActivity          uses  activity_main.xml
PriceWatchActivity    uses  activity_price_watch.xml
ProfitCalcActivity    uses  activity_profit_calc.xml
PriceBoardActivity    uses  activity_price_board.xml
TrendsActivity        uses  activity_trends.xml
```

### Resources Referenced
```
All Activities use:
├── strings.xml (text labels)
├── colors.xml (color definitions)
└── styles.xml (theme)
```

---

## 📊 Class Relationships

```
Product
├── id: Int
├── name: String
├── mandiPrice: Double
└── trend: String

PriceBreakdown
├── mandiCost: Double
├── wasteLoss: Double
├── transportCost: Double
├── profit: Double
└── recommendedSellingPrice: Double

MockDataProvider
└── getAllProducts(): List<Product>
    └── getProductByName(name: String): Product?

PricingCalculator
└── calculateSellingPrice(...): PriceBreakdown

MainActivity
├── PriceWatchActivity
├── ProfitCalcActivity
├── PriceBoardActivity
└── TrendsActivity
```

---

## 🎯 File Purpose Summary

| File | Purpose | Size |
|------|---------|------|
| build.gradle (app) | Dependencies, SDK versions | Medium |
| AndroidManifest.xml | App permissions, activities | Small |
| MainActivity.kt | Main menu controller | Small |
| PriceWatchActivity.kt | Price list display | Small |
| ProfitCalcActivity.kt | Calculator logic | Medium |
| PriceBoardActivity.kt | Price board display | Small |
| TrendsActivity.kt | Trend indicators | Small |
| Models.kt | Data class definitions | Tiny |
| MockDataProvider.kt | Sample data (10 items) | Small |
| PricingCalculator.kt | Math algorithm | Small |
| activity_main.xml | Menu layout | Small |
| activity_profit_calc.xml | Form layout | Medium |
| colors.xml | Color palette | Small |
| strings.xml | Text labels | Small |
| styles.xml | Theme definition | Small |

---

## 🚀 Ready to Go!

All files are organized and ready. Each file has a clear purpose:
- **Easy to find** - Logical folder structure
- **Easy to understand** - Clear naming conventions  
- **Easy to modify** - Well-commented code
- **Easy to extend** - Modular design

**Start exploring:** Open in Android Studio and run! 🎉

