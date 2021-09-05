# PCP (Phone code picker)

[![](https://jitpack.io/v/MrAdkhambek/PCP.svg)](https://jitpack.io/#MrAdkhambek/PCP)

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```gradle
dependencies {
    implementation 'com.github.MrAdkhambek:PCP:$lastVersion'
}
```

```kotlin
    val pcpView = findViewById<PcpView>(R.id.pcp_view)
    pcpView.value // String
```

### Custom atributies
```xml
    <mr.adkhambek.pcp.PcpView
        app:hideArrow="true"
        app:hideFlag="true"
        app:hideCountryName="true" />
```

### You must add this snippets your code
```xml
    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.MaterialComponents.DayNight.DarkActionBar">

        <!-- Add this snippets with your custom colors -->
        <item name="pcpTextColor">@android:color/white</item>
        <item name="pcpArrowColor">@android:color/white</item>
    </style>
```

![Image](media/1.jpeg)

![Image](media/2.jpeg)

![Image](media/3.jpeg)
