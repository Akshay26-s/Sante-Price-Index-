## Sante Price Index - Android App

A micro-finance tool for small vendors in weekly markets (Santes) to determine fair selling prices based on city Mandi prices.

### Features

1. **Price Watch** 📊
   - View today's Mandi prices for various commodities (Onion, Tomato, Potato, etc.)
   - Simple list display showing commodity name and price per kg

2. **Profit Calculator** 💰
   - Select any commodity from dropdown
   - Enter transport cost and waste percentage
   - Set desired profit margin
   - Get recommended selling price with detailed cost breakdown
   - Shows profit amount and profit percentage

3. **Price Board** 📋
   - Full-screen digital display of all prices
   - High-contrast design for visibility
   - Easy to read from distance
   - Black background with yellow text

4. **Price Trends** 📈
   - Visual indicators for each commodity
   - Shows if prices are likely to rise (↑), fall (↓), or stable (→)
   - Helps vendors make informed decisions

### Technical Details

- **Language**: Kotlin
- **Architecture**: MVVM-ready structure
- **Data Source**: Mock data (no external APIs)
- **UI Framework**: Android Material Design
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)

### Project Structure

```
app/
├── src/main/
│   ├── java/com/example/santeprice/
│   │   ├── ui/
│   │   │   ├── MainActivity.kt
│   │   │   ├── PriceWatchActivity.kt
│   │   │   ├── ProfitCalcActivity.kt
│   │   │   ├── PriceBoardActivity.kt
│   │   │   └── TrendsActivity.kt
│   │   ├── data/
│   │   │   ├── Models.kt
│   │   │   └── MockDataProvider.kt
│   │   └── utils/
│   │       └── PricingCalculator.kt
│   ├── res/
│   │   ├── layout/
│   │   ├── values/
│   │   └── drawable/
│   └── AndroidManifest.xml
```

### Running the App

1. Open Android Studio
2. Select "Open an existing Android Studio project"
3. Navigate to `d:\Downloads\Android app project\SantePriceIndex`
4. Let Gradle sync and build
5. Run on emulator or physical device (minimum Android 7.0)

### Pricing Algorithm

The profit calculator uses a cost-plus pricing model:

1. **Mandi Cost**: Current market price of the commodity
2. **Waste Loss**: Calculated based on waste percentage (reduces effective stock)
3. **Transport Cost**: User-defined delivery/transport cost
4. **Profit**: Percentage markup on total cost
5. **Recommended Price**: Sum of all costs + profit

Formula:
```
Adjusted Cost = Mandi Price / (1 - Waste%)
Total Cost = Adjusted Cost + Transport Cost
Profit = Total Cost × Profit Margin %
Selling Price = Total Cost + Profit
```

### Mock Data

The app includes 10 commodities with simulated prices:
- Onion: ₹28/kg (Trend: Up)
- Tomato: ₹45/kg (Trend: Down)
- Potato: ₹35/kg (Trend: Stable)
- Carrot: ₹32/kg (Trend: Up)
- Brinjal: ₹42/kg (Trend: Down)
- Cabbage: ₹25/kg (Trend: Stable)
- Cucumber: ₹38/kg (Trend: Up)
- Bell Pepper: ₹55/kg (Trend: Up)
- Green Chilli: ₹50/kg (Trend: Down)
- Garlic: ₹65/kg (Trend: Stable)

### Future Enhancements

- Real-time price updates from database
- User authentication and vendor profiles
- Historical price data and charts
- Multi-language support (local languages)
- Offline mode with data caching
- SMS/WhatsApp price alerts

---
**Created for**: Micro-entrepreneurship empowerment  
**Target Users**: Small vegetable vendors in village markets
