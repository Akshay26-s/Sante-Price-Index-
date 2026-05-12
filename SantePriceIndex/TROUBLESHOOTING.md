# Installation & Troubleshooting - Complete Guide

## ✅ Pre-Installation Checklist

Before opening the project, ensure you have:

- [ ] Android Studio installed (latest version)
  - Download: https://developer.android.com/studio
  
- [ ] JDK 11 or higher
  - Check: `java -version` in terminal
  
- [ ] At least 4GB free disk space
  
- [ ] Android SDK API 34 installed
  - Open Android Studio → SDK Manager → Check "Android 14.0 (API 34)"
  
- [ ] Internet connection (for first-time Gradle sync)

---

## 🎯 Installation Steps

### Step 1: Open Project
```
1. Launch Android Studio
2. Click "Open"
3. Navigate to: d:\Downloads\Android app project\SantePriceIndex
4. Click "OK"
```

### Step 2: Wait for Gradle Sync
```
Expected: "Gradle build finished"
Time: 2-5 minutes on first sync
Do NOT interrupt this process
```

### Step 3: Set Up Emulator (Optional)
```
1. Tools → Device Manager
2. Click "Create Device"
3. Select "Pixel 4" or similar
4. Select "API 34"
5. Click "Next" → "Finish"
6. Wait for setup (5-10 minutes)
```

### Step 4: Run App
```
1. Select your device/emulator (top toolbar)
2. Click green Run button (▶️) or Shift+F10
3. App launches in 30-60 seconds
```

---

## 🐛 Common Issues & Solutions

### Issue 1: "Gradle sync failed"

**Symptoms:**
- Red error messages at bottom
- "Failed to resolve dependency"
- "Could not find gradle.jar"

**Solutions:**
```
Option A (Quick):
1. File → Sync Now
2. Wait for sync

Option B (Reset):
1. File → Invalidate Caches
2. Click "Invalidate and Restart"
3. Wait 2-3 minutes

Option C (Nuclear):
1. Delete: C:\Users\[YourUsername]\.gradle
2. Delete: d:\Downloads\Android app project\SantePriceIndex\.gradle
3. Restart Android Studio
4. File → Sync Now
```

### Issue 2: "Gradle version incompatible"

**Symptoms:**
- Error: "Gradle 8.1 required, you have X.X"
- Build fails immediately

**Solution:**
```
1. Open: build.gradle (top level)
2. Update plugin versions to 8.1.0:
   id 'com.android.application' version '8.1.0' apply false
3. File → Sync Now
```

### Issue 3: "compileSdkVersion not specified"

**Symptoms:**
- Error: "No compileSdkVersion specified"
- Build fails before running

**Solution:**
```
1. File → Project Structure
2. Set "Compile SDK Version" to 34
3. Click "Apply" → "OK"
4. File → Sync Now
```

### Issue 4: App crashes immediately

**Symptoms:**
- App starts then closes
- Logcat shows red error messages

**How to debug:**
```
1. Open: View → Tool Windows → Logcat
2. Look for lines with "ERROR" (red text)
3. Search for your package name: "santeprice"
4. Read the error message carefully

Common causes:
- Missing layout file
- Typo in activity class name
- Missing activity in AndroidManifest.xml
- Wrong resource ID in code
```

### Issue 5: "Activity not found"

**Symptoms:**
- Error: "Activity ComponentInfo{...} not found"
- App crashes on button click

**Solution:**
```
1. Check AndroidManifest.xml
2. Verify all activities are listed:
   - MainActivity
   - PriceWatchActivity
   - ProfitCalcActivity
   - PriceBoardActivity
   - TrendsActivity
3. Verify spelling exactly matches .kt file names
4. File → Sync Now
```

### Issue 6: "Resource not found (id or layout)"

**Symptoms:**
- Error: "findViewById(R.id.xyz) - xyz not found"
- Error: "Could not find layout xml_name"

**Solution:**
```
1. Check the activity .kt file for findViewById calls
2. Verify layout XML file exists in res/layout/
3. Check XML file has that id:
   android:id="@+id/xyz"
4. File → Sync Now
5. Rebuild: Build → Rebuild Project
```

### Issue 7: Emulator very slow

**Symptoms:**
- Emulator takes forever to boot
- App runs very slowly
- UI is laggy

**Solutions:**
```
Option A (Accelerate Emulator):
1. Run emulator from command line with GPU:
   emulator -avd Pixel_4_API_34 -gpu auto

Option B (Use Physical Device):
1. Connect Android phone via USB
2. Enable USB Debugging in Developer Options
3. Android Studio auto-detects device
4. Select device and run

Option C (Reduce Emulator Resources):
1. Device Manager → Edit device
2. Reduce RAM to 2GB
3. Reduce heap to 512MB
```

### Issue 8: "INSTALL_FAILED_INSUFFICIENT_STORAGE"

**Symptoms:**
- Can't install APK on emulator
- Error about storage space

**Solution:**
```
1. AVD Manager → Right-click device → Edit
2. Increase Internal Storage to 4000MB
3. Increase SD Card to 2000MB
4. Click Finish
5. Wipe device data (reset)
6. Try again
```

### Issue 9: "Build tools version X not found"

**Symptoms:**
- Error: "Could not find com.android.tools.build:gradle:X.X.X"

**Solution:**
```
1. SDK Manager → Android SDK → SDK Tools
2. Check "Android SDK Build-Tools 34.0.0"
3. Click "Apply" → "OK"
4. File → Sync Now
```

### Issue 10: App compiles but won't run

**Symptoms:**
- Build succeeds
- But app doesn't launch

**Debugging:**
```
1. Check Logcat output
2. Look for these messages:
   - "ActivityNotFoundException"
   - "ClassNotFoundException"
   - "NullPointerException" at line X
3. Fix the issue shown in Logcat
4. Run → Rebuild and Re-run
```

---

## 🔍 How to Read Logcat Errors

### Example Error Message
```
E/AndroidRuntime: FATAL EXCEPTION: main
   Process: com.example.santeprice, PID: 1234
   java.lang.NullPointerException: Attempt to invoke virtual method 'getSelectedItem' on null object reference
       at com.example.santeprice.ui.ProfitCalcActivity.calculatePrice(ProfitCalcActivity.kt:42)
```

**What this means:**
- Line 42 in ProfitCalcActivity.kt
- `spinnerCommodity` is null
- Solution: Initialize view with `findViewById` first

---

## ✔️ Verification Checklist

After installation, verify everything works:

1. **App launches**
   - [ ] No crash, main menu visible
   - [ ] 4 buttons visible
   - [ ] Title says "Sante Price Index"

2. **Price Watch works**
   - [ ] Click "Price Watch"
   - [ ] See list of 10 items
   - [ ] Each shows name and price
   - [ ] Back button works

3. **Profit Calculator works**
   - [ ] Click "Profit Calculator"
   - [ ] Dropdown shows items
   - [ ] Can type in all input fields
   - [ ] Click Calculate
   - [ ] See result and breakdown
   - [ ] Back button works

4. **Price Board works**
   - [ ] Click "Price Board"
   - [ ] See prices on black background
   - [ ] Text is yellow/white
   - [ ] Text is large
   - [ ] Back button works

5. **Trends works**
   - [ ] Click "Trends"
   - [ ] See all items with symbols (↑ ↓ →)
   - [ ] Back button works

6. **No crashes**
   - [ ] Logcat shows no errors
   - [ ] Can navigate all screens
   - [ ] All buttons work

---

## 🚀 Performance Optimization Tips

### For Emulator
```
- Use Android 14 (API 34)
- Allocate 4GB RAM minimum
- Enable GPU acceleration
- Use SSD storage for emulator
```

### For App
```
- No heavy computations on main thread
- Use View Binding instead of findViewById
- Cache data when possible
- No unnecessary logging in release builds
```

---

## 📞 When All Else Fails

### Last Resort Steps
```
1. Delete entire .gradle folder
2. Delete entire build folder
3. File → Invalidate Caches → Restart
4. Restart computer
5. Download project again
6. Sync from scratch
```

### Check These Files
```
✓ build.gradle (check versions)
✓ AndroidManifest.xml (check activity names)
✓ All layout XML files exist
✓ All Kotlin files compile
✓ strings.xml has all strings referenced in code
✓ colors.xml has all colors referenced in code
```

---

## 📝 Development Best Practices

### Before Running
1. **Commit to Git** (if using version control)
2. **Check Logcat** for pre-existing errors
3. **Clear project** (Build → Clean Project)
4. **Rebuild** (Build → Rebuild Project)

### During Development
1. **Use Logcat** to debug
2. **Test on Physical Device** when possible
3. **Check for Warnings** (yellow messages)
4. **Run Lint** (Analyze → Run Lint)

### Before Distribution
1. **Test on Multiple Devices**
2. **Test on Multiple Android Versions** (API 24-34)
3. **Check for Memory Leaks** (Profiler)
4. **Sign APK** before uploading

---

## 📚 Helpful Resources

- **Android Debug Bridge**: `adb devices` (list devices)
- **Logcat Help**: `adb logcat | grep santeprice`
- **Rebuild Project**: `Ctrl+F9`
- **Run App**: `Shift+F10`
- **Debug App**: `Shift+F9`

---

**Still stuck?** Check the other guides:
- `README.md` - Overview
- `QUICKSTART.md` - Quick guide
- `SETUP_GUIDE.md` - Installation
- `ARCHITECTURE.md` - Technical details

Good luck! 🎉
