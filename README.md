# **Android Custom Slider**


---
A fully customizable Animated Custom Slider View Library for Android built using Kotlin.

This slider is:

- ✔ Fully controlled from XML
- ✔ Smooth animated thumb
- ✔ Animated progress track
- ✔ Lightweight and fast
- ✔ No Kotlin configuration required after adding in XML

---

## ✨ **Features**

- Custom minimum & maximum value

- Set default slider value

- Smooth thumb animation

- Animated progress fill

- Custom track color

- Custom progress color

- Custom thumb color

- Adjustable track height

- Adjustable thumb radius

- Enable/disable animation from XML

- Custom animation duration




  ---

# **Preview**
---
<p align="center">
  <img src="https://github.com/S13reya/Android_CustomSlider/blob/stages/app/src/main/assets/demovideo.gif" height="320"/>




</p>


## ⚡ **Installation**

**Step 1:** Add JitPack repository to your root build.gradle:

```gradle
maven { url = uri("https://jitpack.io") }
```

**Step 2:** Add the dependency in your app `build.gradle` (example if hosted on JitPack):  

```gradle
dependencies {
	        implementation 'com.github.Excelsior-Technologies-Community:Android_SwipeTransition:1.0.0'

}
```
## ⚡ **attrs file**

```

<?xml version="1.0" encoding="utf-8"?>
<resources>

    <declare-styleable name="CustomSliderView">

        <!-- Slider Range -->
        <attr name="cs_min" format="float" />
        <attr name="cs_max" format="float" />
        <attr name="cs_value" format="float" />

        <!-- Colors -->
        <attr name="cs_trackColor" format="color" />
        <attr name="cs_progressColor" format="color" />
        <attr name="cs_thumbColor" format="color" />

        <!-- Sizes -->
        <attr name="cs_trackHeight" format="dimension" />
        <attr name="cs_thumbRadius" format="dimension" />

        <!-- Animation -->
        <attr name="cs_enableAnimation" format="boolean" />
        <attr name="cs_animationDuration" format="integer" />

    </declare-styleable>

</resources>
```

## ⚡ **Usage**

1. Add in XML

```
  <com.ext.android_custom_slider.CustomSliderView
        android:layout_width="match_parent"
        android:layout_height="80dp"

        app:cs_min="0"
        app:cs_max="200"
        app:cs_value="70"

        app:cs_trackColor="@android:color/darker_gray"
        app:cs_progressColor="@android:color/holo_green_dark"
        app:cs_thumbColor="@android:color/holo_red_dark"
        app:cs_enableAnimation="true"
        app:cs_animationDuration="600"
        app:cs_trackHeight="10dp"
        app:cs_thumbRadius="20dp"/>
```


## **📄 License**

**MIT License**  
```
Copyright (c) 2025 Excelsior Technologies

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED **"AS IS"**, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```



  
